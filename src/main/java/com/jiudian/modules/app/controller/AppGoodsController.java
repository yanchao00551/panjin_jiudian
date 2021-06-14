package com.jiudian.modules.app.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;
import com.jiudian.common.validator.ValidatorUtils;
import com.jiudian.modules.album.entity.AlbumClassEntity;
import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.album.service.AlbumClassService;
import com.jiudian.modules.album.service.AlbumPictureService;
import com.jiudian.modules.app.annotation.Login;
import com.jiudian.modules.app.calculate.RewardCalcuUtil;
import com.jiudian.modules.app.entity.CalendarPriceInfo;
import com.jiudian.modules.app.entity.RoomAttrbuteInfo;
import com.jiudian.modules.app.entity.RoomAttributeValues;
import com.jiudian.modules.app.form.AddCartForm;
import com.jiudian.modules.cart.entity.CartEntity;
import com.jiudian.modules.cart.service.CartService;
import com.jiudian.modules.goods.entity.AttributeValueEntity;
import com.jiudian.modules.goods.entity.GoodsAttributeEntity;
import com.jiudian.modules.goods.entity.GoodsCategoryEntity;
import com.jiudian.modules.goods.entity.GoodsEntity;
import com.jiudian.modules.goods.entity.GoodsGroupEntity;
import com.jiudian.modules.goods.entity.RecommendGoodsInfo;
import com.jiudian.modules.goods.service.AttributeValueService;
import com.jiudian.modules.goods.service.GoodsAttributeService;
import com.jiudian.modules.goods.service.GoodsCategoryService;
import com.jiudian.modules.goods.service.GoodsGroupService;
import com.jiudian.modules.goods.service.GoodsService;
import com.jiudian.modules.member.entity.MemberEntity;
import com.jiudian.modules.member.service.MemberService;

import io.swagger.annotations.Api;

/**
 * 商品控制器
 * 
 * @author KF-180419
 *
 */
@RestController
@RequestMapping("/app")
@Api("商城控制器")
public class AppGoodsController {
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private GoodsCategoryService goodsCategoryService;
	@Autowired
	private AlbumClassService albumClassService;
	@Autowired
	private AlbumPictureService albumPictureService;
	@Autowired
	private CartService cartService;
	@Autowired
	private GoodsGroupService goodsGroupService;
	@Autowired
	private GoodsAttributeService goodsAttributeService;
	@Autowired
	private RewardCalcuUtil rewardCalcuUtil;
	@Autowired
	private MemberService memberService;
	@Autowired
	private AttributeValueService attributeValueService;

	private Integer instance_id;

	public AppGoodsController() {
		this.instance_id = 0;
	}

	/**
	 * 添加购物车
	 * 
	 */
	@Login
	@PostMapping("addCart")
	public R addCart(@RequestAttribute("userId") Integer userId, @RequestBody AddCartForm form) {
		ValidatorUtils.validateEntity(form);
		if (form.getType() == 1) {
			if (form.getIntoStore() == null || form.getIntoStore() == 0) {
				return R.error("缺少参数入住时间戳");
			}
			if (form.getLeaveStore() == null || form.getLeaveStore() == 0) {
				return R.error("缺少参数离店时间戳");
			}
		}
		boolean res = goodsService.addCart(userId, this.instance_id, form.getGoodsId(), form.getGoodsName(),
				form.getGoodsAttributeId(), form.getPrice(), form.getCount(), form.getPictureId(), 0,
				form.getType(), form.getIntoStore(),
				form.getLeaveStore(), form.getMaxUsePoint() == null ? 0 : form.getMaxUsePoint());
		if (res) {
			return R.ok();
		}else {
			return R.error("购物车添加失败!");
		}
	}

	/**
	 * 购物车列表
	 */
	@Login
	@GetMapping("cart")
	public R cart(@RequestAttribute("userId") Integer userId, @RequestParam Map<String, Object> params) {
		Integer type = new Integer(params.get("type").toString());
		List<CartEntity> cartList = goodsService.getCart(userId, type);
		cartList.forEach( c -> {
			GoodsAttributeEntity goodsAttributeEntity = goodsAttributeService.selectOne
					(new EntityWrapper<GoodsAttributeEntity>().eq("attr_id", c.getSkuId()).eq("goods_id", c.getGoodsId()));
			c.setGoodsAttributeEntity(goodsAttributeEntity);
		});
		return R.ok().put("cartList", cartList);
	}

	/**
	 * 根据cartId删除购物车中的商品
	 */
	@Login
	@PostMapping("deleteShoppingCartById")
	public R deleteShoppingCartById(@RequestParam Map<String, String> params) {
		String[] cartIds = params.get("cartId").split(",");
		for (String cartId : cartIds) {
			cartService.deleteById(Integer.parseInt(cartId));
		}
		return R.ok();
	}

	/**
	 * 更新购物车中商品数量
	 */
	@Login
	@PostMapping("updateCartGoodsNumber")
	public R updateCartGoodsNumber(@RequestAttribute("userId") Integer userId, @RequestParam Map<String, String> params) {
		String num = params.get("num");
		String goodsId = params.get("goodsId");
		String cartId = params.get("cartId");
		CartEntity cartEntity = cartService.selectOne(new EntityWrapper<CartEntity>()
				.eq("cart_id", cartId).eq("buyer_id", userId).eq("goods_id", goodsId));
		cartEntity.setNum(Integer.parseInt(num));
		return cartService.insertOrUpdate(cartEntity) ? R.ok() : R.error("数据更新失败！");
	}

	/**
	 * 获取商品列表
	 */
	@SuppressWarnings("unchecked")
	@GetMapping("goodsList")
	public R goodsList(@RequestParam Map<String, String> params) {
//    	Integer stateType = Integer.parseInt(params.get("state"));
//    	String selectGoodsLableId = params.get("selectGoodsLableId");
//    	String sortRule = params.get("sortRule");
//    	String goodsType = params.get("goodsType");
//    	String goodsAttributeId = params.get("goodsAttributeId");
//    	
//    	if(goodsAttributeId != null && goodsAttributeId.equals("all")) {
//    		params.put("goodsAttributeIdAll", "1");
//    		params.remove("goodsAttributeId");
//    	}

//    	if(!goodsType.equals("all")) {
//    		
//    		params.put("goodsType", goodsType);
//    	}
//    	params.put("state", String.valueOf(stateType));
//    	if(stateType > 0) {   //商品状态
//    		params.put("state", "0");
//    	}else {
//    		params.put("state", "1");
//    	}  	

//    	if(selectGoodsLableId != null) {   //标签 可多选
//    		String [] selectGoodsLabelIdArray = selectGoodsLableId.split(",");
//    		String str = selectGoodsLabelIdArray[0];
//    		if(selectGoodsLabelIdArray.length > 1) {
//    			str = str + ",";
//    		}
//    		for(int i=1;i<selectGoodsLabelIdArray.length;i++) {
//    			str += selectGoodsLabelIdArray[i];
//    			if(i!= selectGoodsLabelIdArray.length - 1) {
//    				str += ",";
//    			}
//    		}
//    		params.put("selectGoodsLableId", str);
//    	}

//    	if(sortRule != null && !"".equals(sortRule)) {   //排序规则
//    		String [] sortRuleArr = sortRule.split(",");
//    		String sortField = sortRuleArr[0];
//    		String sortValue = sortRuleArr[1];
//    		if(sortValue.equals("a")) {
//    			sortValue = "ASC";
//    		}else if(sortValue.equals("d")) {
//    			sortValue = "DESC";
//    		}else {
//    			sortValue = null;
//    		}
//    		if(sortValue != null) {
//    			switch(sortField) {
//    			case "price":
//    				params.put("orderPrice", sortValue);
//    				break;
//    			case "stock":
//    				params.put("orderStock", sortValue);
//    				break;
//    			case "sales":
//    				params.put("orderSales", sortValue);
//    				break;
//    			case "sort":
//    				params.put("orderSort", sortValue);
//    				break;
//    			}
//    		}
//    	}else {
//    		// 默认时间排序
//			params.put("orderCreateTime","desc");
//		}
//    	params.put("shopId", this.instance_id.toString());
		String categoryId = "";
		if (params.containsKey("categoryId")) {
			categoryId = params.get("categoryId");
//			params.remove("categoryId");
		}
		Map<String, List<GoodsEntity>> recommendList = new HashMap<String, List<GoodsEntity>>();
		PageUtils result = goodsService.queryGoodsListCanSort(params, recommendList, categoryId,
				params.get("goodsAttributeId"));
		List<GoodsEntity> goodsList = (List<GoodsEntity>) result.getList();
		goodsList.forEach(new Consumer<GoodsEntity>() {
			@Override
			public void accept(GoodsEntity t) {
				AlbumPictureEntity albumPictureEntity = albumPictureService
						.selectOne(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", t.getPicture()));
				t.setPictureDetail(albumPictureEntity);
				List<GoodsAttributeEntity> goodsAttributeEntities = goodsAttributeService.selectList
						(new EntityWrapper<GoodsAttributeEntity>().eq("goods_id", t.getGoodsId()));
				if(goodsAttributeEntities == null || goodsAttributeEntities.size() == 0) {
					return;
				}
				Collections.sort(goodsAttributeEntities,(GoodsAttributeEntity o1, GoodsAttributeEntity o2) -> {
					if(o1.getPrice() == null) {
						return -1;
					}
					if(o2.getPrice() == null) {
						return 1;
					}
					return o1.getPrice().compareTo(o2.getPrice());
				});
				t.setPrice(goodsAttributeEntities.get(0).getPrice());
			}
		});
		if("4".equals(params.get("orderColum")) && goodsList != null && goodsList.size() > 0) {
			if("0".equals(params.get("orderSection"))) {
				Collections.sort(goodsList,(GoodsEntity o1, GoodsEntity o2) -> {
					if(o1.getPrice() == null) {
						return 1;
					}
					if(o2.getPrice() == null) {
						return -1;
					}
					return o1.getPrice().compareTo(o2.getPrice());
				});
			}else if ("1".equals(params.get("orderSection"))) {
				Collections.sort(goodsList,(GoodsEntity o1, GoodsEntity o2) -> {
					if(o1.getPrice() == null) {
						return 1;
					}
					if(o2.getPrice() == null) {
						return -1;
					}
					return o2.getPrice().compareTo(o1.getPrice());
				});
			}
		}
		result.setList(goodsList);
		List<RecommendGoodsInfo> recommendGoodsInfos = new ArrayList<RecommendGoodsInfo>();
		if (recommendList.get("recommend") != null) {
			recommendList.get("recommend").forEach(new Consumer<GoodsEntity>() {
				@Override
				public void accept(GoodsEntity t) {
					List<GoodsAttributeEntity> goodsAttributeEntities = goodsAttributeService.selectList
							(new EntityWrapper<GoodsAttributeEntity>().eq("goods_id", t.getGoodsId()));
					if(goodsAttributeEntities == null || goodsAttributeEntities.size() == 0) {
						return;
					}
					Collections.sort(goodsAttributeEntities,(GoodsAttributeEntity o1, GoodsAttributeEntity o2) -> {
						if(o1.getPrice() == null) {
							return -1;
						}
						if(o2.getPrice() == null) {
							return 1;
						}
						return o1.getPrice().compareTo(o2.getPrice());
					});
					t.setPrice(goodsAttributeEntities.get(0).getPrice());
					RecommendGoodsInfo recommendGoodsInfo = new RecommendGoodsInfo();
					recommendGoodsInfo.setGoodsId(String.valueOf(t.getGoodsId()));
					recommendGoodsInfo.setGoodsName(t.getGoodsName());
					recommendGoodsInfo.setSellPrice(t.getPrice() == null ? "0" : t.getPrice().toString());
					recommendGoodsInfo.setSoldCount(String.valueOf(t.getSoldcount()));
					AlbumPictureEntity albumPictureEntity = albumPictureService
							.selectOne(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", t.getPicture()));
					recommendGoodsInfo.setAlbumPictureEntity(albumPictureEntity);
					recommendGoodsInfos.add(recommendGoodsInfo);
				}
			});
		}
		Map<String, Object> resMap = new HashMap<String, Object>();
		resMap.put("recommendList", recommendGoodsInfos);
		resMap.put("goodsList", result);
		return R.ok().put("data", resMap);
	}

	/**
	 * 获取商品详情
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping("getGoodsDetail")
	public R getGoodsDetail(HttpServletRequest request) {
		Map<String, Object> retvalMap = new HashMap<String, Object>();
		String goodsId = request.getParameter("goodsId");
		Integer goodsAttrId = 0; // 商品类目关联ID
		if (goodsAttrId != null) {
			retvalMap.put("goodsAttrId", goodsAttrId);
		}
		retvalMap.put("shopType", 2);

		// 相册列表
		AlbumClassEntity albumClassDetail = albumClassService
				.selectOne(new EntityWrapper<AlbumClassEntity>().eq("shop_id", this.instance_id).eq("is_default", 1));
		retvalMap.put("detailAlbumId", albumClassDetail.getAlbumId()); // 默认相册ID

		long uid = 0;
		GoodsEntity goodsInfo = new GoodsEntity();
		if (goodsId != null) {
			retvalMap.put("goodsId", goodsId);
			goodsInfo = goodsService.getGoodsDetail(Integer.parseInt(goodsId), uid, request);
			if (Integer.parseInt(goodsId) > 0) {
				if (goodsInfo != null) {
					SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
					sdf.applyPattern("yyyy-MM-dd HH:mm:ss"); // a为am/pm的标记
					goodsInfo.setPreselltimeFormat(sdf.format(goodsInfo.getPresellTime() * 1000));
					if (goodsInfo.getDescription().trim() != null) {
						goodsInfo.setDescription(goodsInfo.getDescription().replace("\n", ""));
					}
					List<GoodsAttributeEntity> goodsAttributeEntities = goodsAttributeService.selectList
							(new EntityWrapper<GoodsAttributeEntity>().eq("goods_id", goodsInfo.getGoodsId()));
					if(goodsAttributeEntities == null || goodsAttributeEntities.size() == 0) {
						return R.error("商品属性异常");
					}
					Collections.sort(goodsAttributeEntities,(GoodsAttributeEntity o1, GoodsAttributeEntity o2) -> {
						if(o1.getPrice() == null) {
							return -1;
						}
						if(o2.getPrice() == null) {
							return 1;
						}
						return o1.getPrice().compareTo(o2.getPrice());
					});
					goodsInfo.setPrice(goodsAttributeEntities.get(0).getPrice());
				} else {
//					R.error(ErrorMsg.GOODS_NOT_FOUND.getCode(), ErrorMsg.GOODS_NOT_FOUND.getName());
					return R.error("查询不到数据！");
				}
				goodsInfo.setDescription(rewardCalcuUtil.getRichText(goodsInfo.getDescription()));
			}
			retvalMap.put("goodsInfo", goodsInfo);
		}
		return R.ok(retvalMap);
	}
	
	@SuppressWarnings({ "unchecked", "deprecation", "unlikely-arg-type" })
	@GetMapping("getRoomsList")
	public R getRoomsList(@RequestParam Map<String, String> params) {
		Map<String,Object> resData = new HashMap<String,Object>();
		List<GoodsGroupEntity> goodsGroupEntities = goodsGroupService.selectList(new EntityWrapper<GoodsGroupEntity>());
		PageUtils roomsPage  = goodsService.queryRoomList(params);
		List<GoodsEntity> goodsEntities = (List<GoodsEntity>) roomsPage.getList();
		goodsEntities.forEach(ge -> {
			AlbumPictureEntity pictureEntity = albumPictureService.selectOne
					(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", ge.getPicture()));
			ge.setPictureDetail(pictureEntity);
			List<GoodsAttributeEntity> attributeEntities = goodsAttributeService.selectList(
					new EntityWrapper<GoodsAttributeEntity>().eq("goods_id", ge.getGoodsId()));
			List<RoomAttrbuteInfo> roomProps = new AttrList<RoomAttrbuteInfo>();
			for (GoodsAttributeEntity t : attributeEntities) {
				if(roomProps.indexOf(t.getAttrValue()) > 0) {
					RoomAttrbuteInfo attrbuteInfo = roomProps.get(roomProps.indexOf(t.getAttrValue()));
					List<RoomAttributeValues> attributeValues = attrbuteInfo.getAttributeValues();
					RoomAttributeValues roomAttributeValues = new RoomAttributeValues();
					roomAttributeValues.setAttrValue(t.getAttrValueName());
					attributeValues.add(roomAttributeValues);
//					roomProps.add(attrbuteInfo);
				}else {
					AttributeValueEntity attributeValueEntity = attributeValueService.selectOne
							(new EntityWrapper<AttributeValueEntity>().eq("attr_value_id", t.getAttrValueId()));
					RoomAttrbuteInfo attrbuteInfo = new RoomAttrbuteInfo();
					attrbuteInfo.setIsIcon(attributeValueEntity.getIsIcon());
					attrbuteInfo.setIco(attributeValueEntity.getIco());
					AlbumPictureEntity albumPictureEntity = albumPictureService.selectOne
							(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", attributeValueEntity.getIco()));
					attrbuteInfo.setIconDetail(albumPictureEntity);
					List<RoomAttributeValues> attributeValues = new ArrayList<RoomAttributeValues>() ;
					RoomAttributeValues roomAttributeValues = new RoomAttributeValues();
					roomAttributeValues.setAttrValue(t.getAttrValueName());
					attributeValues.add(roomAttributeValues);
					attrbuteInfo.setAttrKey(t.getAttrValue());
					attrbuteInfo.setAttributeValues(attributeValues);
					roomProps.add(attrbuteInfo);
				}
			}
			ge.setRoomProps(roomProps);
			try {
				Calendar currentCalendar = Calendar.getInstance();
				int currentDay = currentCalendar.getTime().getDate();
				int currentYear = 1900 + currentCalendar.getTime().getYear();
				int currentMonth = currentCalendar.getTime().getMonth() + 1;
				Calendar firstDayCalendar = Calendar.getInstance();
				firstDayCalendar.set(currentYear, currentMonth - 1, 1);
				if(!StringUtils.isEmpty(ge.getExtends1())) {
					JSONArray jsonArray = JSON.parseArray(ge.getExtends1());
					JSONObject currentMonthJson = null;
					int dayOfWeek = firstDayCalendar.getTime().getDay();
					for (int i = 0; i < jsonArray.size(); i++) {
						String tYear = jsonArray.getJSONObject(i).getString("year");
						String tMonth = jsonArray.getJSONObject(i).getString("month");
						if (!StringUtils.isEmpty(tYear) && tYear.equals(String.valueOf(currentYear))
								&& !StringUtils.isEmpty(tMonth) && tMonth.equals(String.valueOf(currentMonth))) {
							currentMonthJson = jsonArray.getJSONObject(i);
						}
					}
					if(currentMonthJson != null) {
						String priceNormals = currentMonthJson.getString("price0");
						String tmpPrice0 = priceNormals.replaceAll("\\[", "").replaceAll("\\]", "")
								.replaceAll("null", "").replaceAll("\"", "");
						for(int j = 0; j < dayOfWeek - 1; j++) {
							tmpPrice0 = tmpPrice0.replaceFirst(",", "");
						}
						String[] price0 = tmpPrice0.split(",");
						ge.setPrice(new BigDecimal(price0[currentDay - 1]));
					}else {
						ge.setPrice(new BigDecimal(0));
					}
				}else {
					ge.setPrice(new BigDecimal(0));
				}
			} catch (Exception e) {
				if(ge != null) {
					ge.setPrice(new BigDecimal(0));
				}
			}
		});
		if("4".equals(params.get("orderColum")) && goodsEntities != null && goodsEntities.size() > 0) {
			if("0".equals(params.get("orderSection"))) {
				Collections.sort(goodsEntities,(GoodsEntity o1, GoodsEntity o2) -> {
					if(o1.getPrice() == null) {
						return -1;
					}
					if(o2.getPrice() == null) {
						return 1;
					}
					return o1.getPrice().compareTo(o2.getPrice());
				});
			}else if ("1".equals(params.get("orderSection"))) {
				Collections.sort(goodsEntities,(GoodsEntity o1, GoodsEntity o2) -> {
					if(o1.getPrice() == null) {
						return -1;
					}
					if(o2.getPrice() == null) {
						return 1;
					}
					return o2.getPrice().compareTo(o1.getPrice());
				});
			}
		}
		roomsPage.setList(goodsEntities);
		resData.put("groupList", goodsGroupEntities);
		resData.put("roomsList", roomsPage);
		return R.ok().put("data", resData);
	}
	
	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	@GetMapping("getRoomDetail")
	public R getRoomDetail(@RequestParam Map<String, String> params) {
		String goodsId = params.get("goodsId");
		params.put("page", "1");
		params.put("limit", "10");
		params.put("orderColum", "1");
		params.put("orderSection", "1");
		PageUtils roomsPage  = goodsService.queryRoomList(params);
		List<GoodsEntity> goodsEntities = (List<GoodsEntity>) roomsPage.getList();
		if(goodsEntities == null || goodsEntities.size() == 0) {
			return R.error("查询不到数据！");
		}
		GoodsEntity goodsEntity = goodsEntities.get(0);
		if(!StringUtils.isEmpty(goodsEntity.getImgIdArray())) {
			String[] imgArrayStr = goodsEntity.getImgIdArray().split(",");
			List<AlbumPictureEntity> imgArray = new ArrayList<AlbumPictureEntity>();
			for (String imgId : imgArrayStr) {
				AlbumPictureEntity albumPictureEntity = albumPictureService.selectOne
						(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", imgId));
				imgArray.add(albumPictureEntity);
			}
			goodsEntity.setDescription(rewardCalcuUtil.getRichText(goodsEntity.getDescription()));
			goodsEntity.setImgList(imgArray);
			goodsEntity.setExtends1(goodsEntity.getExtends1());
			List<CalendarPriceInfo> calendarPriceInfos = StringUtils.isEmpty(goodsEntity.getExtends1()) ?
					null : packagePrice(goodsEntity.getExtends1());
			goodsEntity.setExtends1Array(calendarPriceInfos);
		}
		List<GoodsAttributeEntity> attributeEntities = goodsAttributeService.selectList
				(new EntityWrapper<GoodsAttributeEntity>().eq("goods_id", goodsId));
		List<RoomAttrbuteInfo> roomProps = new AttrList<RoomAttrbuteInfo>();
		for (GoodsAttributeEntity t : attributeEntities) {
			if(roomProps.indexOf(t.getAttrValue()) > 0) {
				RoomAttrbuteInfo attrbuteInfo = roomProps.get(roomProps.indexOf(t.getAttrValue()));
				List<RoomAttributeValues> attributeValues = attrbuteInfo.getAttributeValues();
				RoomAttributeValues roomAttributeValues = new RoomAttributeValues();
				roomAttributeValues.setAttrValue(t.getAttrValueName());
				attributeValues.add(roomAttributeValues);
//				roomProps.add(attrbuteInfo);
			}else {
				AttributeValueEntity attributeValueEntity = attributeValueService.selectOne
						(new EntityWrapper<AttributeValueEntity>().eq("attr_value_id", t.getAttrValueId()));
				RoomAttrbuteInfo attrbuteInfo = new RoomAttrbuteInfo();
				attrbuteInfo.setIsIcon(attributeValueEntity.getIsIcon());
				attrbuteInfo.setIco(attributeValueEntity.getIco());
				AlbumPictureEntity albumPictureEntity = albumPictureService.selectOne
						(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", attributeValueEntity.getIco()));
				attrbuteInfo.setIconDetail(albumPictureEntity);
				List<RoomAttributeValues> attributeValues = new ArrayList<RoomAttributeValues>() ;
				RoomAttributeValues roomAttributeValues = new RoomAttributeValues();
				roomAttributeValues.setAttrValue(t.getAttrValueName());
				attributeValues.add(roomAttributeValues);
				attrbuteInfo.setAttrKey(t.getAttrValue());
				attrbuteInfo.setAttributeValues(attributeValues);
				roomProps.add(attrbuteInfo);
			}
		}
//		attributeEntities.forEach(t ->{		
//			
//		});
		Map<String,Object> resData = new HashMap<String,Object>();
		resData.put("roomInfo", goodsEntity);
		resData.put("props", roomProps);
		return R.ok().put("data", resData);
	}
	
	@SuppressWarnings("unchecked")
	@Login
	@GetMapping("getRoomDetailLogin")
	public R getRoomDetailLogin(@RequestAttribute("userId") Integer userId,@RequestParam Map<String, String> params) {
		MemberEntity memberEntity = memberService.selectOne(new EntityWrapper<MemberEntity>().eq("uid", userId));
		int level = rewardCalcuUtil.getCurrentLevel(userId, String.valueOf(memberEntity.getPid()));
		R r = getRoomDetail(params);
		Map<String,Object> resData = (Map<String, Object>) r.get("data");
		GoodsEntity goodsEntity = (GoodsEntity) resData.get("roomInfo");
		String userPrice = "";
		switch (level) {
		case 1:
			userPrice = "price1";
			break;
		case 2:
		case 3:
			userPrice = "price2";
			break;
		case 4:
			userPrice = "price0";
			break;
		default:
			userPrice = "price0";
			break;
		}
		resData.put("roomInfo", goodsEntity);
		goodsEntity.setUserPrice(userPrice);
		r.put("data", resData);
		return r;
	}

	@GetMapping("getGoodsCategory")
	public R getGoodsCategory() {
		List<GoodsCategoryEntity> goodsCategory = new ArrayList<GoodsCategoryEntity>();
//    	goodsCategory = goodsService.getCategoryTreeUseInAdmin();
		goodsCategory = goodsCategoryService.selectList(new EntityWrapper<GoodsCategoryEntity>());
		goodsCategory.forEach(new Consumer<GoodsCategoryEntity>() {
			@Override
			public void accept(GoodsCategoryEntity t) {
				AlbumPictureEntity catePic = albumPictureService
						.selectOne(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", t.getCategoryPic()));
				AlbumPictureEntity iconPic = albumPictureService
						.selectOne(new EntityWrapper<AlbumPictureEntity>().eq("pic_id", t.getIcon()));
				t.setCatePic(catePic);
				t.setIconPic(iconPic);
			}
		});
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("categoryList", goodsCategory);
		return R.ok(map);
	}

	@SuppressWarnings("unused")
	private List<GoodsCategoryEntity> getTreeList(Integer topId, List<GoodsCategoryEntity> goodsCategoryList) {
		List<GoodsCategoryEntity> resultList = new ArrayList<>();

		// 获取顶层元素集合
		Integer parentId;
		for (GoodsCategoryEntity entity : goodsCategoryList) {
			parentId = entity.getPid();
			entity.setLabel(entity.getCategoryName());
			entity.setValue(entity.getCategoryId());
			if (parentId == null || topId.equals(parentId)) {
				resultList.add(entity);
			}
		}

		// 获取每个顶层元素的子数据集合
		for (GoodsCategoryEntity entity : resultList) {
			entity.setChildren(getSubList(entity.getCategoryId(), goodsCategoryList));
		}

		return resultList;

	}

	/**
	 * 获取子数据集合
	 * 
	 * @param id
	 * @param entityList
	 * @return
	 */
	private static List<GoodsCategoryEntity> getSubList(Integer id, List<GoodsCategoryEntity> entityList) {
		List<GoodsCategoryEntity> childList = new ArrayList<>();
		Integer parentId;

		// 子集的直接子对象
		for (GoodsCategoryEntity entity : entityList) {
			parentId = entity.getPid();
			entity.setLabel(entity.getCategoryName());
			entity.setValue(entity.getCategoryId());
			if (id.equals(parentId)) {
				childList.add(entity);
			}
		}

		// 子集的间接子对象
		for (GoodsCategoryEntity entity : childList) {
			entity.setChildren(getSubList(entity.getCategoryId(), entityList));
		}

		// 递归退出条件
		if (childList.size() == 0) {
			return null;
		}
		return childList;
	}

	/*
	 * 方法二：推荐，速度最快 判断是否为整数
	 * 
	 * @param str 传入的字符串
	 * 
	 * @return 是整数返回true,否则返回false
	 */
	@SuppressWarnings("unused")
	private static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}
	
	@SuppressWarnings("deprecation")
	private List<CalendarPriceInfo> packagePrice(String str){
		List<CalendarPriceInfo> calendarPriceInfos = new ArrayList<CalendarPriceInfo>();
		JSONArray jsonArray =  JSON.parseArray(str);
		for (int i = 0; i < jsonArray.size(); i++) {
			CalendarPriceInfo calendarPriceInfo = new CalendarPriceInfo();
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			String year = jsonObject.getString("year");
			calendarPriceInfo.setYear(year);
			String month = jsonObject.getString("month");
			calendarPriceInfo.setMonth(month);
			Calendar calendar = Calendar.getInstance();
			calendar.set(Integer.parseInt(year), Integer.parseInt(month) - 1, 1);
			int dayOfWeek = calendar.getTime().getDay();
			String priceNormals = jsonObject.getString("price0");
			String priceLv1s = jsonObject.getString("price1");
			String priceLv2s = jsonObject.getString("price2");
			String tmpPrice0 = priceNormals.replaceAll("\\[", "").replaceAll("\\]", "")
					.replaceAll("null", "").replaceAll("\"", "");
			String tmpPrice1 = priceLv1s.replaceAll("\\[", "").replaceAll("\\]", "")
					.replaceAll("null", "").replaceAll("\"", "");
			String tmpPrice2 = priceLv2s.replaceAll("\\[", "").replaceAll("\\]", "")
					.replaceAll("null", "").replaceAll("\"", "");
			for(int j = 0; j < dayOfWeek - 1; j++) {
				tmpPrice0 = tmpPrice0.replaceFirst(",", "");
				tmpPrice1 = tmpPrice1.replaceFirst(",", "");
				tmpPrice2 = tmpPrice2.replaceFirst(",", "");
			}
			String[] price0 = tmpPrice0.split(",");
			String[] price1 = tmpPrice1.split(",");
			String[] price2 = tmpPrice2.split(",");
			calendarPriceInfo.setPrice0(price0);
			calendarPriceInfo.setPrice1(price1);
			calendarPriceInfo.setPrice2(price2);
			calendarPriceInfos.add(calendarPriceInfo);
		}
		return calendarPriceInfos;
	}
	
	class AttrList<T> extends ArrayList<T>{
		/**
		 * 
		 */
		private static final long serialVersionUID = 3767296116048377313L;
		private List<String> keyList = new ArrayList<String>();
		@Override
		public boolean add(T e) {
			boolean res = super.add(e);
			if(e instanceof RoomAttrbuteInfo) {
				keyList.add(((RoomAttrbuteInfo) e).getAttrKey());
			}
			return res;
		}
		@Override
		public int indexOf(Object o) {
			return keyList.indexOf(o);
		}
	}
}
