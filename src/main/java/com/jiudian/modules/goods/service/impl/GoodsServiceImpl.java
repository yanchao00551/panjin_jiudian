package com.jiudian.modules.goods.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.exception.RRException;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;
import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.album.service.AlbumPictureService;
import com.jiudian.modules.app.calculate.RewardCalcuUtil;
import com.jiudian.modules.app.entity.UserEntity;
import com.jiudian.modules.app.service.UserService;
import com.jiudian.modules.cart.entity.CartEntity;
import com.jiudian.modules.cart.service.CartService;
import com.jiudian.modules.goods.dao.GoodsDao;
import com.jiudian.modules.goods.entity.AttributeEntity;
import com.jiudian.modules.goods.entity.AttributeValueEntity;
import com.jiudian.modules.goods.entity.GoodsAttributeEntity;
import com.jiudian.modules.goods.entity.GoodsCategoryEntity;
import com.jiudian.modules.goods.entity.GoodsEntity;
import com.jiudian.modules.goods.entity.GoodsSkuEntity;
import com.jiudian.modules.goods.entity.GoodsSkuPictureEntity;
import com.jiudian.modules.goods.entity.GoodsSpecEntity;
import com.jiudian.modules.goods.entity.GoodsSpecValueEntity;
import com.jiudian.modules.goods.service.AttributeService;
import com.jiudian.modules.goods.service.AttributeValueService;
import com.jiudian.modules.goods.service.GoodsAttributeService;
import com.jiudian.modules.goods.service.GoodsCategoryService;
import com.jiudian.modules.goods.service.GoodsGroupService;
import com.jiudian.modules.goods.service.GoodsService;
import com.jiudian.modules.goods.service.GoodsSkuPictureService;
import com.jiudian.modules.goods.service.GoodsSkuService;
import com.jiudian.modules.goods.service.GoodsSpecService;
import com.jiudian.modules.goods.service.GoodsSpecValueService;
import com.jiudian.modules.member.entity.MemberEntity;
import com.jiudian.modules.member.service.MemberLevelService;
import com.jiudian.modules.member.service.MemberPartnerService;
import com.jiudian.modules.member.service.MemberService;
import com.jiudian.modules.order.entity.GoodsCommentEntity;
import com.jiudian.modules.order.service.GoodsCommentService;
import com.jiudian.modules.order.service.OrderGoodsService;
import com.jiudian.modules.shop.service.ShopService;

import net.sf.json.JSONArray;


@Service("goodsService")
public class GoodsServiceImpl extends ServiceImpl<GoodsDao, GoodsEntity> implements GoodsService {
	
	@Autowired
	AttributeService attributeService;
	@Autowired
	AttributeValueService attributeValueService;
	@Autowired
	GoodsSpecService goodsSpecService;
	@Autowired
	GoodsSpecValueService goodsSpecValueService;
	@Autowired
	GoodsCategoryService goodsCategoryService;
	@Autowired
	MemberLevelService memberLevelService;
	@Autowired
	GoodsSkuPictureService goodsSkuPictureService;
	@Autowired
	AlbumPictureService albumPictureService;
	@Autowired 
	GoodsGroupService goodsGroupService;
	@Autowired
	GoodsSkuService goodsSkuService;
	@Autowired
	GoodsAttributeService goodsAttributeService;
	@Autowired
	ShopService shopService;
	@Autowired
	OrderGoodsService orderGoodsService;
	@Autowired
	CartService cartService;
	@Autowired
	MemberService memberService;
	@Autowired
	MemberPartnerService memberPartnerService;
	@Autowired
	private GoodsCommentService goodsCommentService;
	@Autowired
	private UserService userService;
	@Autowired
	private RewardCalcuUtil rewardCalcuUtil;

	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsEntity> page = this.selectPage(
                new Query<GoodsEntity>(params).getPage(),
                new EntityWrapper<GoodsEntity>()
        );

        return new PageUtils(page);
    }

	@SuppressWarnings("unchecked")
	@Override
	public PageUtils getAttributeServiceList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<AttributeEntity> attribute = new ArrayList<AttributeEntity>();  
		List<AttributeValueEntity> attributeValue = new ArrayList<AttributeValueEntity>();
		PageUtils page = attributeService.queryPage(params);
		attribute = (List<AttributeEntity>) page.getList();
		if(!page.getList().isEmpty()) {
			for(int i=0;i<attribute.size();i++) {
				attributeValue = attributeValueService.selectList(new EntityWrapper<AttributeValueEntity>().eq("attr_id", attribute.get(i).getAttrId()));
				String valueStr = "";
				for(int j=0;j<attributeValue.size();j++) {
					valueStr = valueStr + "," + attributeValue.get(j).getAttrValueName();
				}
				valueStr = valueStr.substring(1);
				attribute.get(i).setValueStr(valueStr);
			}
			page.setList(attribute);
		}
		return page;
	}

	@Override
	@Transactional
	public Integer addAttributeService(String attrName, Integer isUse, String selectBox, Integer sort,
			String dataObjStr, String selectBrank) {
		// TODO Auto-generated method stub
		try {
			AttributeEntity attribute = new AttributeEntity();
			attribute.setAttrName(attrName);
			attribute.setIsUse(isUse);
			attribute.setSpecIdArray(selectBox);
			attribute.setSort(sort);
			attribute.setBrandIdArray(selectBrank);
			attribute.setCreateTime((int)(System.currentTimeMillis() / 1000));
			attributeService.insert(attribute);
			Integer attrId = attribute.getAttrId();
			if(!dataObjStr.isEmpty()) {
				String [] valueArray = dataObjStr.split(";");
				if(valueArray.length == 1) {
					String [] newArray = dataObjStr.split("\\|");
					this.addAttributeValueService(attrId,newArray[0],
							new Integer(newArray[1]),new Integer(newArray[2]),new Integer(newArray[3]),
							newArray[4].equals("null") ? null :newArray[4], new Integer(newArray[5]));			
				}else {
					for(int i=0;i<valueArray.length;i++) {
						String [] newArray = valueArray[i].split("\\|");
						this.addAttributeValueService(attrId,newArray[0],
								new Integer(newArray[1]),new Integer(newArray[2]),
								new Integer(newArray[3]),newArray[4].equals("null") ? null :newArray[4], new Integer(newArray[5]));
					}
				}
			}
			return attrId;
		}catch(RRException e){
	        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	        throw new RRException("添加商品类型fail!");
	    }
	}

	private Integer addAttributeValueService(Integer attrId, String attrValueName, Integer type, 
			Integer sort, Integer isSearch, String value, int ico) {
		// TODO Auto-generated method stub
		AttributeValueEntity attributeValue = new AttributeValueEntity();
		attributeValue.setAttrId(attrId);
		attributeValue.setAttrValueName(attrValueName);
		attributeValue.setType(type);
		attributeValue.setSort(sort);
		attributeValue.setIsIcon(isSearch);
		attributeValue.setValue(value);
		attributeValue.setIco(ico);
		attributeValueService.insert(attributeValue);
		return attributeValue.getAttrId();
	}

	@Override
	@Transactional
	public Integer updateAttributeService(Integer attrId,String attrName, Integer isUse, String selectBox, Integer sort,
			String dataObjStr, String selectBrank) {
		try {
			AttributeEntity attribute = new AttributeEntity();
			attribute.setAttrName(attrName);
			attribute.setIsUse(isUse);
			attribute.setSpecIdArray(selectBox);
			attribute.setSort(sort);
			attribute.setBrandIdArray(selectBrank.isEmpty() ? "" : selectBrank);
			attribute.setCreateTime((int)(System.currentTimeMillis() / 1000));
			attribute.setAttrId(attrId);
			attributeService.update(attribute, new EntityWrapper<AttributeEntity>().eq("attr_id", attrId));
			if(!dataObjStr.isEmpty()) {
				String [] valueArray = dataObjStr.split(";");
				if(valueArray.length == 1) {
					String [] newArray = dataObjStr.split("\\|");
					this.addAttributeValueService(attrId,newArray[0],new Integer(newArray[1]),
							new Integer(newArray[2]),new Integer(newArray[3]),
							newArray[4].equals("null") ? null : newArray[4],new Integer(newArray[5]));
				}else {
					for(int i=0;i<valueArray.length;i++) {
						String [] newArray = valueArray[i].split("\\|");
						this.addAttributeValueService(attrId,newArray[0],new Integer(newArray[1]),
								new Integer(newArray[2]),new Integer(newArray[3]),
								newArray[4].equals("null") ? null : newArray[4],new Integer(newArray[5]));
					}
				}
			}
			return 0;
		}catch(RRException e){
	        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	        throw new RRException("修改商品类型fail!");
	    }
	}

	@Override
	public Boolean deleteAttributeService(Integer attrId) {
		// TODO Auto-generated method stub
		boolean res = attributeService.deleteById(attrId);
		attributeValueService.delete(new EntityWrapper<AttributeValueEntity>().eq("attr_id", attrId));
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageUtils getGoodsSpecList(Map<String, Object> params) {
		// TODO Auto-generated method stub
		List<GoodsSpecEntity> goodsSpec = new ArrayList<GoodsSpecEntity>();
		List<GoodsSpecValueEntity> goodsSpecValue = new ArrayList<GoodsSpecValueEntity>();
		PageUtils page = goodsSpecService.queryPage(params);
		goodsSpec = (List<GoodsSpecEntity>) page.getList();
		if(!page.getList().isEmpty()) {
			for(int i=0;i<goodsSpec.size();i++) {
				goodsSpecValue = goodsSpecValueService.selectList(new EntityWrapper<GoodsSpecValueEntity>().eq("spec_id", goodsSpec.get(i).getSpecId()));
				String valueStr = "";
				for(int j=0;j<goodsSpecValue.size();j++) {
					valueStr = valueStr + "," + goodsSpecValue.get(j).getSpecValueName();
				}
				goodsSpec.get(i).setSpecValueList(goodsSpecValue);
				valueStr = (valueStr == "" || valueStr == null) ? "" :  valueStr.substring(1);
				goodsSpec.get(i).setGoodsSpecValueName(valueStr);
			}
			page.setList(goodsSpec);
		}
		return page;
	}

	@Override
	@Transactional
	public Integer addGoodsSpecService(Integer shopId, String specName, Integer showType, Integer isVisible,
			Integer sort, String specValueStr, Integer attrId, Integer isScreen, String specDes) {
		// TODO Auto-generated method stub
		try {
			GoodsSpecEntity goodsSpec = new GoodsSpecEntity();
			goodsSpec.setShopId(shopId);
			goodsSpec.setSpecName(specName);
			goodsSpec.setShowType(showType);
			goodsSpec.setIsVisible(isVisible);
			goodsSpec.setSort(sort);
			goodsSpec.setSpecDes(specDes);
			goodsSpec.setIsScreen(isScreen);
			goodsSpec.setCreateTime((int)(System.currentTimeMillis() / 1000));
			goodsSpecService.insert(goodsSpec);
			Integer goodsSpecId = goodsSpec.getSpecId();
			 // 添加规格并修改上级分类关联规格
			if(goodsSpecId > 0) {
				AttributeEntity attributeInfo = new AttributeEntity();
				attributeInfo = attributeService.selectById(goodsSpecId);
				if(attributeInfo != null && (attributeInfo.getSpecIdArray().equals(null) || attributeInfo.getSpecIdArray().equals(""))) {
					attributeInfo.setSpecIdArray(goodsSpecId.toString());
					attributeInfo.setAttrId(goodsSpecId);
					attributeService.updateById(attributeInfo);
				}else {
					attributeInfo = new AttributeEntity();
					attributeInfo.setSpecIdArray(attributeInfo.getSpecIdArray() + "," + goodsSpecId.toString());
					attributeInfo.setAttrId(goodsSpecId);
					attributeService.updateById(attributeInfo);
				}
				String[] specValueArray = specValueStr.split(",");
				specValueArray = this.replaceNull(specValueArray);  //去空
				specValueArray = this.goRepeat(specValueArray); //去重
				for(int i=0;i<specValueArray.length;i++) {
					if(showType == 2) {
						String[] specValue = specValueArray[i].split(":");
						this.addGoodsSpecValueService(goodsSpecId,specValue[0],specValue[1],1,255);
					}else {
						this.addGoodsSpecValueService(goodsSpecId,specValueArray[i],"",1,255);
					}
				}
			}
			return goodsSpecId;
		}catch(RRException e){
	        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	        throw new RRException("添加商品规格fail!");
	    }
	}
	
	
	private Integer addGoodsSpecValueService(Integer goodsSpecId, String specValueName, String specValueData, Integer isVisible, Integer sort) {
		// TODO Auto-generated method stub
		GoodsSpecValueEntity entity = new GoodsSpecValueEntity();
		entity.setSpecId(goodsSpecId);
		entity.setSpecValueName(specValueName);
		entity.setSpecValueData(specValueData);
		entity.setIsVisible(isVisible);
		entity.setSort(sort);
		entity.setCreateTime((int)(System.currentTimeMillis() / 1000));
		goodsSpecValueService.insert(entity);
		return entity.getSpecValueId();
	}

	/**
	 * 字符串数组去空
	 * @param str
	 * @return
	 */
	private String[] replaceNull(String[] str) {
		// 用StringBuffer来存放数组中的非空元素，用“;”分隔
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length; i++) {
			if ("".equals(str[i])) {
				continue;
			}
			sb.append(str[i]);
			if (i != str.length - 1) {
				sb.append(";");
			}
		}
		// 用String的split方法分割，得到数组
		str = sb.toString().split(";");
		return str;
	}
	
	/**
	 * 字符串数组去重
	 * 
	 * @param str
	 * @return
	 */
	private String[] goRepeat(String[] temp) {
		List<String> list = new LinkedList<String>();
		for (int i = 0; i < temp.length; i++) {
			if (!list.contains(temp[i])) {
				list.add(temp[i]);
			}
		}
		String[] rowsTemp = list.toArray(new String[list.size()]);
		return rowsTemp;
	}

	@Override
	@Transactional
	public Integer updateGoodsSpecService(Integer specId, Integer shopId, String specName, Integer showType,
			Integer isVisible, Integer sort, String specValueStr, Integer attrId, Integer isScreen, String specDes) {
		// TODO Auto-generated method stub
		try {
			GoodsSpecEntity goodsSpec = new GoodsSpecEntity();
			goodsSpec.setShopId(shopId);
			goodsSpec.setSpecName(specName);
			goodsSpec.setShowType(showType);
			goodsSpec.setIsVisible(isVisible);
			goodsSpec.setSort(sort);
			goodsSpec.setSpecDes(specDes);
			goodsSpec.setIsScreen(isScreen);
			goodsSpec.setCreateTime((int)(System.currentTimeMillis() / 1000));
			goodsSpec.setSpecId(specId);
			goodsSpecService.updateById(goodsSpec);
			 // 删掉规格下的属性
			this.deleteSpecValue(specId);
			if(!specValueStr.isEmpty()) {
				String[] specValueArray = specValueStr.split(",");
				specValueArray = this.replaceNull(specValueArray);  //去空
				specValueArray = this.goRepeat(specValueArray); //去重
				for(int i=0;i<specValueArray.length;i++) {
					if(showType == 2) {
						String[] specValue = specValueArray[i].split(":");
						this.addGoodsSpecValueService(specId,specValue[0],specValue[1],1,255);
					}else {
						this.addGoodsSpecValueService(specId,specValueArray[i],"",1,255);
					}
				}
			}
			return 0;
		}catch(RRException e){
	        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	        throw new RRException("修改商品规格fail!");
	    }
	}

	private boolean deleteSpecValue(Integer specId) {
		// TODO Auto-generated method stub
		return goodsSpecValueService.delete(new EntityWrapper<GoodsSpecValueEntity>().eq("spec_id", specId));
	}

	@Override
	@Transactional
	public Boolean deleteGoodsSpec(Integer specId) {
		// TODO Auto-generated method stub
		try {
			String[] specIdArray = specId.toString().split(",");
			for(int i=0;i<specIdArray.length;i++) {
				goodsSpecService.deleteById(specIdArray[i]);
				goodsSpecValueService.delete(new EntityWrapper<GoodsSpecValueEntity>().eq("spec_id", specIdArray[i]));
			}
			return true;
		}catch(RRException e){
	        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	        throw new RRException("删除商品规格fail!");
	    }
	}

	@Override
	public List<GoodsCategoryEntity> getCategoryTreeUseInAdmin() {
		// TODO Auto-generated method stub
		List<GoodsCategoryEntity> levelOne = new ArrayList<GoodsCategoryEntity>();
		List<GoodsCategoryEntity> levelTwo = new ArrayList<GoodsCategoryEntity>();
		List<GoodsCategoryEntity> levelThreeList = new ArrayList<GoodsCategoryEntity>();

		
		levelOne = goodsCategoryService.selectList(new EntityWrapper<GoodsCategoryEntity>().eq("level", 1));
		if(!levelOne.isEmpty()) {
			for(int i=0;i<levelOne.size();i++) {
				levelTwo = goodsCategoryService.selectList(new EntityWrapper<GoodsCategoryEntity>().eq("level", 2).eq("pid", levelOne.get(i).getCategoryId()));
				levelOne.get(i).setCount(levelTwo.size());
				if(!levelTwo.isEmpty()) {
					for(int j=0;j<levelTwo.size();j++) {
						levelThreeList = goodsCategoryService.selectList(new EntityWrapper<GoodsCategoryEntity>().eq("level", 3).eq("pid", levelTwo.get(j).getCategoryId()));
						levelTwo.get(j).setCount(levelThreeList.size());
						levelTwo.get(j).setChildList(levelThreeList);
					}
				}
				levelOne.get(i).setChildList(levelTwo);
			}
		}
		return levelOne;
	}

	@Override
	public GoodsSpecEntity getGoodsSpecDetail(long specId) {
		// TODO Auto-generated method stub
		GoodsSpecEntity info = goodsSpecService.selectById(specId);
		List<GoodsSpecValueEntity> goodsSpecValueList = new ArrayList<GoodsSpecValueEntity>();
		
		String goodsSpecValueName = "";
		if(info != null) {
			// 去除规格属性空值
			goodsSpecValueService.delete(new EntityWrapper<GoodsSpecValueEntity>().eq("spec_id", info.getSpecId()).eq("spec_value_name", ""));
			goodsSpecValueList = goodsSpecValueService.selectList(new EntityWrapper<GoodsSpecValueEntity>().eq("spec_id", info.getSpecId()));
			for(int i=0;i<goodsSpecValueList.size();i++) {
				goodsSpecValueName = goodsSpecValueName + "," + goodsSpecValueList.get(i).getSpecValueName();
			}
		}
		info.setGoodsSpecValueName(goodsSpecValueName.substring(1));
		info.setSpecValueList(goodsSpecValueList);
		return info;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public GoodsEntity getGoodsDetail(Integer goodsId,Long uid,HttpServletRequest request) {
		//查询商品主表
		GoodsEntity goodsDetail = baseMapper.selectById(goodsId);
		if(goodsDetail == null || goodsDetail.getState() == 0) {
			return null;
		}
		// 查询图片表
		String order = "instr('," + goodsDetail.getImgIdArray() + ",',CONCAT(',',pic_id,','))";  // 根据 in里边的id 排序
		List<AlbumPictureEntity> goodsImgList = albumPictureService.selectList(new EntityWrapper<AlbumPictureEntity>().in("pic_id", goodsDetail.getImgIdArray()).orderBy(order));
		List<AlbumPictureEntity> imgTempArray = new ArrayList<AlbumPictureEntity>();
		if(goodsDetail != null && goodsDetail.getImgIdArray() != null && goodsDetail.getImgIdArray().trim() != null) {
			if(!org.springframework.util.StringUtils.isEmpty(goodsDetail.getImgIdArray().trim())) {
				String [] imgArray = goodsDetail.getImgIdArray().split(",");
				for(int i=0;i<imgArray.length;i++) {
					if(!goodsImgList.isEmpty()) {
						for(AlbumPictureEntity v:goodsImgList) {
							if(!org.springframework.util.StringUtils.isEmpty(imgArray[i])) {
								if(v.getPicId() == Integer.parseInt(imgArray[i])) {
									imgTempArray.add(v);
								}
							}
						}
					}
				}
			}
		}
		AlbumPictureEntity goodsPicture = albumPictureService.selectById(goodsDetail.getPicture());
		goodsDetail.setImgTempArray(imgTempArray);
//		goodsDetail.setImgList(goodsImgList);
		goodsDetail.setPictureDetail(goodsPicture);
		// 查询分类名称
		String categoryName = this.getGoodsCategoryName(goodsDetail.getCategoryId1(),goodsDetail.getCategoryId2(),goodsDetail.getCategoryId3());
		goodsDetail.setCategoryName(categoryName);
		// 扩展分类 暂略
		
		// 查询商品类型相关信息
		if(goodsDetail.getGoodsAttributeId() != 0) {
			AttributeEntity attributeInfo = attributeService.selectById(goodsDetail.getGoodsAttributeId());
			goodsDetail.setGoodsAttributeName(attributeInfo.getAttrName());
			List<GoodsAttributeEntity> goodsAttributeList = new ArrayList<GoodsAttributeEntity>();
			goodsAttributeList = goodsAttributeService.selectList(new EntityWrapper<GoodsAttributeEntity>()
					.eq("goods_id", goodsId).ne("attr_value_name", "").orderBy("sort desc"));
			goodsDetail.setGoodsAttributeList(goodsAttributeList);
		}else {
			goodsDetail.setGoodsAttributeName("");
			goodsDetail.setGoodsAttributeList(null);
		}
		// 商品满减送活动 单品活动  包邮活动 暂略
		
		//查询店铺名
		if(goodsDetail.getShopId() > 0) {
			String shopName = shopService.selectById(goodsDetail.getShopId()).getShopName() != null ? shopService.selectById(goodsDetail.getShopId()).getShopName() : null;
			goodsDetail.setShopName(shopName);
		}
		
		// 查询商品的已购数量
		Map<String,String> tmpMap = new HashMap<String,String>();
		tmpMap.put("goodsId", String.valueOf(goodsId));
		List<GoodsEntity> goodsEntities = baseMapper.queryGoodsSoldCount(tmpMap);
		int soldCount = 0;
		if(goodsEntities != null && goodsEntities.size() > 0 && goodsEntities.get(0) != null) {
			soldCount = goodsEntities.get(0).getSoldcount();
		}
		goodsDetail.setSoldcount(soldCount);
		if(request.getParameter("commentPage") != null && request.getParameter("commentLimit") != null) {
			Map<String,Object> commentArgs = new HashMap<String,Object>();
			commentArgs.put("page", request.getParameter("commentPage"));
			commentArgs.put("limit", request.getParameter("commentLimit"));
			commentArgs.put("goodsId", goodsId);
			PageUtils commentPage = goodsCommentService.queryPage(commentArgs, "2");
			List<GoodsCommentEntity> goodsCommentEntities = (List<GoodsCommentEntity>) commentPage.getList();
			goodsCommentEntities.forEach(t ->{
				UserEntity userEntity = userService.selectOne(new EntityWrapper<UserEntity>().eq("user_id", t.getUid()));
				AlbumPictureEntity info = new AlbumPictureEntity();
		    	info = albumPictureService.selectById(userEntity.getUserHeadimg());
		    	userEntity.setUserHeadImgDetail(info);
				t.setUserEntity(userEntity);
			});
			goodsDetail.setCommentData(commentPage);
		}
		return goodsDetail;
	}

	/**
	 * 根据当前商品分类组装分类名称
	 * @param categoryId1
	 * @param categoryId2
	 * @param categoryId3
	 * @return
	 */
	private String getGoodsCategoryName(Integer categoryId1, Integer categoryId2, Integer categoryId3) {
		// TODO Auto-generated method stub
		String name = null;
		GoodsCategoryEntity info1 = goodsCategoryService.selectById(categoryId1);
		GoodsCategoryEntity info2 = goodsCategoryService.selectById(categoryId2);
		GoodsCategoryEntity info3 = goodsCategoryService.selectById(categoryId3);
		
		if(info1 != null) {
			name = info1.getCategoryName() + " > ";
		}
		if(info2!= null) {
			name = name + info2.getCategoryName() + " > ";
		}
		if(info3 != null) {
			name = name + info3.getCategoryName() + " > ";
		}
		
		return name;
	}

	/**
	 * 查询sku多图数据
	 * @param goodsId
	 * @return
	 */
	@Override
	public List<GoodsSkuPictureEntity> getGoodsSkuPicture(Integer goodsId) {
		// TODO Auto-generated method stub
		List<GoodsSkuPictureEntity> goodsSkuPictureList = new ArrayList<GoodsSkuPictureEntity>();
		goodsSkuPictureList = goodsSkuPictureService.selectList(new EntityWrapper<GoodsSkuPictureEntity>().eq("goods_id", goodsId));

		String [] totalSkuImgArray = null;
		for(int i=0;i<goodsSkuPictureList.size();i++) {
			String skuImgIds = goodsSkuPictureList.get(i).getSkuImgArray();
			String[] skuImgArray = skuImgIds.split(",");
			if(totalSkuImgArray != null) {
				int strLen1 = skuImgArray.length;
				int strLen2 = totalSkuImgArray.length;
				totalSkuImgArray = Arrays.copyOf(totalSkuImgArray, strLen1+strLen2);  //扩容
				System.arraycopy(skuImgArray, 0, totalSkuImgArray, strLen2,strLen1);  //合并
			}else {
				totalSkuImgArray = skuImgArray;
			}
		}
		if(totalSkuImgArray != null) {
			List<String> totalSkuImgIds = java.util.Arrays.asList(totalSkuImgArray);
			List<AlbumPictureEntity> albumPictureList = new ArrayList<AlbumPictureEntity>();
			if(!totalSkuImgIds.isEmpty()) {
				albumPictureList = albumPictureService.selectBatchIds(totalSkuImgIds);
			}else {
				albumPictureList = null;
			}
			
			int i = 0;
			for(GoodsSkuPictureEntity value:goodsSkuPictureList) {
				String skuImgIds = value.getSkuImgArray();
				String [] skuImgArray = skuImgIds.split(",");
				List<AlbumPictureEntity> list = new ArrayList<AlbumPictureEntity>();
				for(AlbumPictureEntity value2:albumPictureList) {
					String currPicId = value2.getPicId().toString();
					if(Arrays.asList(skuImgArray).contains(currPicId)) {    //in_array
						list.add(value2);
					}
				}
				goodsSkuPictureList.get(i).setAlbumPictureList(list);
				i++;
			}
		}
		
		return goodsSkuPictureList;
	}

	@Override
	public Integer deleteAttributeValueService(Integer attrId, Integer attrValueId) {
		// TODO Auto-generated method stub
        // 检测类型属性数量
		Integer count = attributeValueService.selectCount(new EntityWrapper<AttributeValueEntity>().eq("attr_id", attrId));
		if(count == 1) {
			return -2;
		}else {
			attributeValueService.deleteById(attrValueId);
		}
		return 0;
	}

	@Override
	public PageUtils getGoodsList(Map<String, String> params,Map<String,List<GoodsEntity>> recommendMap) {
		// TODO Auto-generated method stub
		int limit = Integer.parseInt((String)params.get("limit"));
    	int current = (Integer.parseInt((String)params.get("page")));
    	Page<GoodsEntity> page = new Page<GoodsEntity>(current,limit);
    	List<GoodsEntity> pageList = baseMapper.queryByGoodsList(page,params);
    	//0非推荐商品1推荐商品
    	if(recommendMap != null) {
    		recommendMap.put("recommend", baseMapper.selectList(new EntityWrapper<GoodsEntity>().eq("is_recommend", 1)));
    	}
    	page.setRecords(pageList);
    	return new PageUtils(page);
	}
	
	@Override
	public PageUtils queryGoodsListCanSort(Map<String, String> params,Map<String,List<GoodsEntity>> recommendMap,
			String categoryId, String goodsAttributeId) {
		// TODO Auto-generated method stub
		int limit = Integer.parseInt((String)params.get("limit"));
    	int current = (Integer.parseInt((String)params.get("page")));
    	Page<GoodsEntity> page = new Page<GoodsEntity>(current,limit);
    	List<GoodsEntity> pageList = baseMapper.queryGoodsListCanSort(page,params);
    	//0非推荐商品1推荐商品
    	if(recommendMap != null) {
    		Wrapper<GoodsEntity> wrapper = new EntityWrapper<GoodsEntity>().eq("is_recommend", 1)
    				.eq("category_id", categoryId);
    		if(!StringUtils.isEmpty(goodsAttributeId) && Integer.parseInt(goodsAttributeId) == 1) {
    			wrapper.eq("goods_attribute_id", 1);
    		}else {
				wrapper.ne("goods_attribute_id", 1);
			}
    		wrapper.eq("state", 1);
    		List<GoodsEntity> goodsEntity = baseMapper.selectList(wrapper);
    		goodsEntity.forEach(t -> {
    			Map<String, String> tmpMap = new HashMap<String, String>();
    			tmpMap.put("goodsId", String.valueOf(t.getGoodsId()));
    			List<GoodsEntity> goodsEntities = baseMapper.queryGoodsSoldCount(tmpMap);
    			int soldCount = 0;
    			if(goodsEntities != null && goodsEntities.size() > 0 && goodsEntities.get(0) != null) {
    				soldCount = goodsEntities.get(0).getSoldcount();
    			}
    			t.setSoldcount(soldCount);
    		});
    		recommendMap.put("recommend", goodsEntity);
    	}
    	page.setRecords(pageList);
    	return new PageUtils(page);
	}
	
	@Override
	public PageUtils getGoodsList(Map<String, String> params) {
		return getGoodsList(params, null);
	}

	@SuppressWarnings("unused")
	@Override
	@Transactional
	public Integer addOrEditGoods(Integer goodsId, String title, Integer shopId, Integer categoryId, int ii, int jj,
			int kk, Integer supplierId, Integer brandId, String groupArray, Integer goodsType, BigDecimal marketPrice,
			BigDecimal price, BigDecimal costPrice, Integer pointExchangeType, Integer integrationAvailableUse,
			Integer integrationAvailableGive, int isMemberDiscount, BigDecimal shippingFee, Integer shippingFeeId,
			Integer stock, String location, Integer maxBuy, Integer minBuy, Integer minstock, Integer baseGood,
			Integer baseSales, int m, int n, int o, Integer baseShare, Integer provinceId, Integer cityId,
			Integer picture, String keyWords, String introduction, String description, String qrcode, String code,
			Integer displayStock, int p, int q, int r, Integer sort, String imageArray, String skuArray, Integer isSale,
			String string, Integer goodsAttributeId, String goodsAttribute, String goodsSpecFormat,
			BigDecimal goodsWeight, BigDecimal goodsVolume, Integer shippingFeeType, String extendCategoryId,
			String skuPictureVlaues, String virtualGoodsTypeData, Integer productionDate, String shelfLife,
			String ladderPreference, String goodsVideoAddress, Integer maxUsePoint, Integer isOpenPresell,
			Integer presellDeliveryType, BigDecimal presellPrice, Integer presellTime, Integer presellDay,
			String goodsUnit, String calendarPrice, Integer isRecommend, Integer goodsSort, int isEdit) {
		// TODO Auto-generated method stub
		Integer[] categoryList = this.getGoodsCategoryId(categoryId);
		int error = 0;
		//扩展分类逻辑暂略
		
		try {
			GoodsEntity ew = new GoodsEntity();
			if(goodsId != null) {
				ew.setGoodsId(goodsId);
				ew = baseMapper.selectOne(ew);
			}
			ew.setGoodsName(title);
			ew.setShopId(shopId);
			ew.setCategoryId(categoryId);
			ew.setCategoryId1(0);
			ew.setCategoryId2(0);
			ew.setCategoryId3(0);
			ew.setPromotionType(0);
			ew.setPromoteId(0);
			ew.setIsBill(0);
			ew.setRealSales(0);
			ew.setPcCustomTemplate("");
			ew.setWapCustomTemplate("");
			ew.setPreselltimeFormat("0");
			ew.setPresellDay(0);
			ew.setPresellDeliveryType(0);
			ew.setPresellPrice(new BigDecimal(0));
			ew.setSupplierId(0);
			ew.setBrandId(0);
			ew.setGroupIdArray(groupArray);
			ew.setGoodsType(goodsType);
			ew.setMarketPrice(marketPrice);
			ew.setPrice(price);
			ew.setPromotionPrice(price);
			ew.setCostPrice(costPrice);
			ew.setPointExchangeType(pointExchangeType);
			ew.setPointExchange(integrationAvailableUse);
			ew.setGivePoint(integrationAvailableGive);
			ew.setIsMemberDiscount(isMemberDiscount);
			ew.setShippingFee(shippingFee);
			ew.setShippingFeeId(shippingFeeId);
			ew.setStock(stock);
			ew.setLocation(location == null ? "" : location);
			ew.setMaxBuy(maxBuy);
			ew.setMinBuy(minBuy);
			ew.setMinStockAlarm(minstock);
			ew.setClicks(baseGood);
			ew.setSales(baseSales);
			ew.setCollects(m);
			ew.setStar(n);
			ew.setEvaluates(o);
			ew.setShares(baseShare);
			ew.setProvinceId(0);
			ew.setCityId(0);
			ew.setPicture(picture == null ? 0 : picture);
			ew.setKeywords(keyWords);
			ew.setIntroduction(introduction);
			ew.setDescription(StringUtils.isEmpty(description) ? "[]" : description);
			ew.setQrcode(qrcode);
			ew.setCode(code);
			ew.setIsStockVisible(displayStock);
			ew.setIsHot(p);
			ew.setIsRecommend(q);
			ew.setIsNew(r);
			ew.setSort(sort);
			ew.setImgIdArray(org.springframework.util.StringUtils.isEmpty(imageArray) ? null : imageArray);
			ew.setState(isSale);
			ew.setSkuImgArray(skuPictureVlaues);
			ew.setGoodsAttributeId(goodsAttributeId);
			ew.setGoodsSpecFormat(goodsSpecFormat);
			ew.setGoodsWeight(goodsWeight);
			ew.setGoodsVolume(goodsVolume);
			ew.setShippingFeeType(shippingFeeType);
			ew.setExtendCategoryId(extendCategoryId);
			ew.setProductionDate(productionDate);
			ew.setShelfLife(shelfLife);
			ew.setGoodsVideoAddress(goodsVideoAddress);
			ew.setMaxUsePoint(maxUsePoint);
			ew.setIsOpenPresell(isOpenPresell);
			ew.setPresellTime(0);
			ew.setPresellDay(presellDay);
			ew.setPresellDeliveryType(presellDeliveryType);
			ew.setPresellPrice(presellPrice);
			ew.setGoodsUnit(goodsUnit);
			ew.setExtends1(calendarPrice);
			ew.setIsRecommend(isRecommend);
			ew.setSort(goodsSort);
			//检查当前添加的规格集合中，是否有新增的规格、规格值
			/*JSONObject goodsSpecFormatObj = JSONObject.parseObject(goodsSpecFormat);
			Set<Entry<String,Object>> entrySet = goodsSpecFormatObj.entrySet();
			for(Entry<String,Object> s:entrySet) {
			
			}
			JSONArray array = JSONArray.fromObject(goodsSpecFormat);
			Integer tempSpecId = 0;
			for(int i=0;i<array.size();i++) {
				if(Integer.parseInt(array.getJSONObject(i).getString("specId")) < 0) {
                    // 记录之前spec_id的值，后续用于替换
					tempSpecId = Integer.parseInt(array.getJSONObject(i).getString("specId"));
					array.getJSONObject(i).put("specId", this.addGoodsSpecService(shopId,array.getJSONObject(i).getString("specName"),
							Integer.parseInt(array.getJSONObject(i).getJSONArray("value").getJSONObject(0).getString("specShowType")),1,0,"",0,1,"",goodsId));
				}
                // 由于需要替换操作，需要先处理规格值，从里到外
				for(int j=0;j<array.getJSONObject(i).getJSONArray("value").size();j++) {
                    // 规格已经添到库中，但是规格值还没有进库，需要添加
					
				}
			}*/
			if(goodsId == null) {
				ew.setCreateTime((int)(System.currentTimeMillis() / 1000));
				ew.setSaleDate((int)(System.currentTimeMillis() / 1000));
				baseMapper.insert(ew);
				goodsId = ew.getGoodsId();
				if(skuArray != null && skuArray != "") {
					String[] skuListArray = skuArray.split("\\§");
				    for(String v:skuListArray) {
				    	Boolean ret = this.addOrUpdateGoodsSkuItem(ew.getGoodsId(),v,goodsSpecFormat);
				    	if(!ret) {
				    		error = 1;
				    	}
				    }
                    // sku图片添加
				    if(!org.springframework.util.StringUtils.isEmpty(skuPictureVlaues)) {
						JSONArray array = JSONArray.fromObject(skuPictureVlaues);
						for(int i=0;i<array.size();i++) {
							Boolean ret = this.addGoodsSkuPicture(shopId,goodsId,array.getJSONObject(i).getString("specId"),array.getJSONObject(i).getString("specValueId"),
									array.getJSONObject(i).getString("imgIds"));
							if(!ret) {
								error = 1;
							}
						}
				    }
				}else {
                    // 添加一条skuitem
					GoodsSkuEntity entity = new GoodsSkuEntity();
					entity.setGoodsId(goodsId);
					entity.setSkuName("");
					entity.setMarketPrice(marketPrice);
					entity.setPrice(price);
					entity.setPromotePrice(price);
					entity.setCostPrice(costPrice);
					entity.setStock(stock);
					entity.setPicture(0);
					entity.setCode(code);
					entity.setQrcode(qrcode);
					entity.setCreateDate((int)(System.currentTimeMillis() / 1000));
					entity.setGoodsExtends1(calendarPrice);  
					Boolean ret = goodsSkuService.insert(entity);
					if(!ret) {
						error = 1;
					}
				}
			}else {
				ew.setUpdateTime((int)(System.currentTimeMillis() / 1000));
				ew.setGoodsId(goodsId);
				baseMapper.updateAllColumnById(ew);
				if(skuArray != null && !skuArray.equals("")) {
					String[] skuListArray = skuArray.split("\\§");
					// 删除商品规格、以及与当前商品关联的规格、规格值
					this.deleteSkuItemAndGoodsSpec(goodsId,skuListArray);
					
					for(String v:skuListArray) {
						Boolean res = this.addOrUpdateGoodsSkuItem(goodsId, v, goodsSpecFormat);
						if(!res) {
							error = 1;
						}
					}
					
                    // 修改时先删除原来的规格图片
					EntityWrapper<GoodsSkuPictureEntity> es = new EntityWrapper<GoodsSkuPictureEntity>();
					es.eq("goods_id", goodsId);
					this.deleteGoodsSkuPicture(es);
					
					// sku图片添加
					if(!org.springframework.util.StringUtils.isEmpty(skuPictureVlaues)) {
						JSONArray array = JSONArray.fromObject(skuPictureVlaues);
						for(int i=0;i<array.size();i++) {
							Boolean ret = this.addGoodsSkuPicture(shopId,goodsId,array.getJSONObject(i).getString("specId"),array.getJSONObject(i).getString("specValueId"),
									array.getJSONObject(i).getString("imgIds"));
							if(!ret) {
								error = 1;
							}
						}
				    }
				}else {
					GoodsSkuEntity entity = new GoodsSkuEntity();
					entity.setGoodsId(goodsId);
					entity.setSkuName("");
					entity.setMarketPrice(marketPrice);
					entity.setPrice(price);
					entity.setPromotePrice(price);
					entity.setCostPrice(costPrice);
					entity.setStock(stock);
					entity.setPicture(0);
					entity.setCode(code);
					entity.setQrcode(qrcode);
					entity.setUpdateDate((int)(System.currentTimeMillis() / 1000));
					boolean retval = goodsSkuService.delete(new EntityWrapper<GoodsSkuEntity>().eq("goods_id", goodsId));
					if(!retval) {
						error = 1;
					}
					Boolean ret = goodsSkuService.insert(entity);
					if(!ret) {
						error = 1;
					}
				}
				//参加活动的商品暂略
			}
			// 每次都要重新更新商品属性
			if(isEdit == 1) {
				goodsAttributeService.delete(new EntityWrapper<GoodsAttributeEntity>().eq("goods_id", goodsId));
				if(goodsAttribute != null && goodsAttribute != "") {
					JSONArray array = JSONArray.fromObject(goodsAttribute);
					if(array.getJSONObject(0).getString("attrValueId") != null) {
						for(int i=0;i<array.size();i++) {
							GoodsAttributeEntity entity = new GoodsAttributeEntity();
							entity.setGoodsId(goodsId);
							entity.setShopId(shopId);
							entity.setAttrValueId(Integer.parseInt(array.getJSONObject(i).getString("attrValueId")));
							entity.setAttrValue(array.getJSONObject(i).getString("attrValue"));
							entity.setAttrValueName(array.getJSONObject(i).getString("attrValueName"));
							entity.setSort(Integer.parseInt(array.getJSONObject(i).getString("sort")));
							entity.setCreateTime((int)(System.currentTimeMillis() / 1000));
							if(array.getJSONObject(i).containsKey("price") && !StringUtils.isEmpty(array.getJSONObject(i).getString("price"))) {
								entity.setPrice(new BigDecimal(array.getJSONObject(i).getString("price")));
							}
							goodsAttributeService.insert(entity);
						}
					}
				}
			}
			
			//优惠 和 虚拟商品略
			
			if(error == 0) {
				return goodsId;
			}else {
		        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		        return -1;
			}
		}catch(RRException e){
	        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	        throw new RRException("保存商品fail!");
	    }
	}
	


	private void deleteGoodsSkuPicture(EntityWrapper<GoodsSkuPictureEntity> es) {
		// TODO Auto-generated method stub
		goodsSkuPictureService.delete(es);
	}

	/**
	 * 删除当前商品的SKU项，以及关联的规格、规格值
	 * @param goodsId
	 * @param skuListArray
	 */
	private void deleteSkuItemAndGoodsSpec(Integer goodsId, String[] skuListArray) {
		// TODO Auto-generated method stub
		String[] skuItemListArray = new String[skuListArray.length];
		int i = 0;
		for(String v:skuListArray) {
			String[] skuItem = v.split("\\¦");
			skuItemListArray[i] = skuItem[0];
			i++;
		}
		
        // 当前商品的规格数组
		String[] specIdArr = new String[2 * skuListArray.length];
		// 当前商品的规格值数组
		String[] specValueIdArr = new String[2 * skuListArray.length];
   		i = 0;
   		if(skuItemListArray.length >= 2) {
	        for(String item:skuItemListArray) {
	        	String[] one = item.split(";");
	        	for(String oneItem:one) {
	        		String[] currArr = oneItem.split(":");
	        		String specId = currArr[0];
	        		String specValueId = currArr[1];
	        		specIdArr[i] = specId;
	        		specValueIdArr[i] = specValueId;
	            	i++;
	        	}
	        }
   		}
        
        List<String> list1 = new ArrayList<String>();
        for(int t=0;t<specIdArr.length;t++) {
        	if(!list1.contains(specIdArr[t])) {
        		list1.add(specIdArr[t]);
        	}
        }
        List<String> list2 = new ArrayList<String>();
        for(int t=0;t<specValueIdArr.length;t++) {
        	if(!list2.contains(specValueIdArr[t])) {
        		list2.add(specValueIdArr[t]);
        	}
        }
        specIdArr = new String[list1.size()];
        specValueIdArr = new String[list2.size()];
        list1.toArray(specIdArr);
        list2.toArray(specValueIdArr);
        

        // 查询当前商品关联的规格列表
        List<GoodsSpecEntity> goodsSpecIdArray = goodsSpecService.selectList(new EntityWrapper<GoodsSpecEntity>().eq("goods_id", goodsId));
        
        // 要删除的规格id数组
        String[] delSpecIdArr = new String[specIdArr.length];
        // 要删除的规格值id数组
        String[] delSpecValueIdArr = new String[specValueIdArr.length];

        if(!goodsSpecIdArray.isEmpty() && goodsSpecIdArray != null) {
        	i=0;
        	int j=0;
        	for(GoodsSpecEntity item:goodsSpecIdArray) {
                // 如果不存在则加入到规格删除队列数组中...
        		if(!Arrays.asList(specIdArr).contains(item.getSpecId().toString())) {
        			delSpecIdArr[i] = item.getSpecId().toString();
        			i++;
        		}
        		
                // 查询当前规格的所有规格值列表
        		List<GoodsSpecValueEntity> goodsSpecValueIdArray = goodsSpecValueService.selectList(new EntityWrapper<GoodsSpecValueEntity>().eq("spec_id", item.getSpecId()));
        		if(!goodsSpecValueIdArray.isEmpty() && goodsSpecValueIdArray != null) {
        			for(GoodsSpecValueEntity value:goodsSpecValueIdArray) {
                        // 如果不存在则加入到规格值删除队列数组中...
                		if(!Arrays.asList(specValueIdArr).contains(value.getSpecValueId().toString())) {
                			delSpecValueIdArr[j] = value.getSpecValueId().toString();
            			    j++;
                		}
        			}
        		}
        	}
        }
        delSpecValueIdArr = this.removeArrayEmptyTextBackNewArray(delSpecValueIdArr);
        delSpecIdArr = this.removeArrayEmptyTextBackNewArray(delSpecIdArr);
        
        // 删除当前商品没有用到的规格值集合
        if(delSpecValueIdArr.length > 0) {
        	String delSpecValueIdStr = StringUtils.join(delSpecValueIdArr, ",");
        	goodsSpecValueService.delete(new EntityWrapper<GoodsSpecValueEntity>().in("spec_value_id", delSpecValueIdStr));
        }
        // 删除当前商品没有用到的规格集合
        if(delSpecIdArr.length > 0) {
        	String delSpecIdStr = StringUtils.join(delSpecIdArr, ",");
        	goodsSpecService.delete(new EntityWrapper<GoodsSpecEntity>().in("spec_id", delSpecIdStr));
        }
        
        List<GoodsSkuEntity> skuList = goodsSkuService.selectList(new EntityWrapper<GoodsSkuEntity>().eq("goods_id", goodsId));
        if(!skuList.isEmpty() && skuList != null) {
        	for(GoodsSkuEntity item:skuList) {
        		if(!Arrays.asList(skuItemListArray).contains(item.getAttrValueItems())) {
        			goodsSkuService.deleteById(item.getSkuId());
        		}
        	}
        }
        
	}

	/**
	 * 去除数组空元素
	 * @param strArray
	 * @return
	 */
	private String[] removeArrayEmptyTextBackNewArray(String[] strArray) {
        List<String> strList= Arrays.asList(strArray);
        List<String> strListNew=new ArrayList<>();
        for (int i = 0; i <strList.size(); i++) {
            if (strList.get(i)!=null&&!strList.get(i).equals("")){
                strListNew.add(strList.get(i));
            }
        }
        String[] strNewArray = strListNew.toArray(new String[strListNew.size()]);
        return   strNewArray;
    }
	
	private Boolean addGoodsSkuPicture(Integer shopId, Integer goodsId, String specId, String specValueId, String skuImgArray) {
		// TODO Auto-generated method stub
		GoodsSkuPictureEntity ew = new GoodsSkuPictureEntity();
		ew.setShopId(shopId);
		ew.setGoodsId(goodsId);
		ew.setSpecId(Integer.parseInt(specId));
		ew.setSpecValueId(Integer.parseInt(specValueId));
		ew.setSkuImgArray(skuImgArray);
		ew.setCreateTime((int)(System.currentTimeMillis() / 1000));
		ew.setModifyTime((int)(System.currentTimeMillis() / 1000));
		return goodsSkuPictureService.insert(ew);
	}

	/**
	 * 添加商品sku列表
	 * @param goodsId
	 * @param v
	 * @return
	 */
	private Boolean addOrUpdateGoodsSkuItem(Integer goodsId, String v,String goodsSpecFormat) {
		// TODO Auto-generated method stub
		String[] skuItem = v.split("\\¦");
		String skuName = this.createSkuName(skuItem[0],goodsSpecFormat);
		GoodsSkuEntity sku = new GoodsSkuEntity();
		sku = goodsSkuService.selectOne(new EntityWrapper<GoodsSkuEntity>().eq("goods_id", goodsId).eq("attr_value_items", skuItem[0]));
		if(sku == null) {
			GoodsSkuEntity ew = new GoodsSkuEntity();
			ew.setGoodsId(goodsId);
			ew.setSkuName(skuName);
			ew.setAttrValueItems(skuItem[0]);
			ew.setAttrValueItemsFormat(skuItem[0]);
			ew.setPrice(new BigDecimal(skuItem[1]));
			ew.setPromotePrice(new BigDecimal(skuItem[1]));
			ew.setMarketPrice(new BigDecimal(skuItem[2]));
			ew.setCostPrice(new BigDecimal(skuItem[3]));
			ew.setStock(Integer.parseInt(skuItem[4]));
			ew.setPicture(0);
			ew.setCode(skuItem[5]);
			ew.setQrcode(null);
			ew.setCreateDate((int)(System.currentTimeMillis()/1000));
			goodsSkuService.insert(ew);
			if(ew.getSkuId() > 0) {
				return true;
			}else {
				return false;
			}
		}else {
			GoodsSkuEntity ew = new GoodsSkuEntity();
			ew.setGoodsId(goodsId);
			ew.setSkuName(skuName);
			ew.setPrice(new BigDecimal(skuItem[1]));
			ew.setPromotePrice(new BigDecimal(skuItem[1]));
			ew.setMarketPrice(new BigDecimal(skuItem[2]));
			ew.setCostPrice(new BigDecimal(skuItem[3]));
			ew.setStock(Integer.parseInt(skuItem[4]));
			ew.setCode(skuItem[5]);
			ew.setQrcode(null);
			ew.setCreateDate((int)(System.currentTimeMillis()/1000));
			ew.setSkuId(sku.getSkuId());
			return goodsSkuService.updateById(ew);
		}
	}

	/**
	 * 组装sku name
	 * @param string
	 * @return
	 */
	private String createSkuName(String pvs,String goodsSpecFormat) {
		// TODO Auto-generated method stub
		String name = "";
		if(org.springframework.util.StringUtils.isEmpty(pvs)) {
			return name;
		}
		String[] pvsArray = pvs.split(";");
		for(String v:pvsArray) {
			String[] value = v.split(":");
//			String propId = value[0];
			String propValue = value[1];
			String valueName = this.getUserSkuName(propValue,goodsSpecFormat);
			name = name + valueName + " ";
		}
		return name;
	}
	
	/**
	 * 获取用户自定义的规格值名称
	 * @param propValue
	 * @return
	 */
	private String getUserSkuName(String specId,String goodsSpecFormat) {
		// TODO Auto-generated method stub
		String skuName = "";
		if(goodsSpecFormat != null) {
			JSONArray array = JSONArray.fromObject(goodsSpecFormat);
			for(int i=0;i<array.size();i++) {
				for(int j=0;j<array.getJSONObject(i).getJSONArray("specValueList").size();j++) {
					if(specId.equals(array.getJSONObject(i).getJSONArray("specValueList").getJSONObject(j).getString("specValueId"))) {
						skuName = array.getJSONObject(i).getJSONArray("specValueList").getJSONObject(j).getString("specValueName");
					}
				}
			}
		}
		return skuName;
	}

	@Transactional
	private Integer addGoodsSpecService(Integer shopId, String specName, Integer showType, int isVisible, int sort, String specValueStr,
			int attrId, int isScreen, String specDes, Integer goodsId) {
		// TODO Auto-generated method stub
		try {
			GoodsSpecEntity data = new GoodsSpecEntity();
			data.setShopId(shopId);
			data.setSpecName(specName);
			data.setShowType(showType);
			data.setIsVisible(isVisible);
			data.setSort(sort);
			data.setIsScreen(isScreen);
			data.setSpecDes(specDes);
			data.setCreateTime((int) (System.currentTimeMillis() / 1000));
			data.setGoodsId(goodsId);
			goodsSpecService.insert(data);
			Integer specId = data.getSpecId();
            // 添加规格并修改上级分类关联规格
			if(attrId > 0) {
				AttributeEntity attributeInfo = new AttributeEntity();
				attributeInfo = attributeService.selectById(attrId);
				if(attributeInfo.getSpecIdArray().equals("") || attributeInfo.getSpecIdArray().equals(null)) {
					attributeInfo.setSpecIdArray(specId.toString());
					attributeInfo.setAttrId(attrId);
					attributeService.updateById(attributeInfo);
				}else {
					attributeInfo.setSpecIdArray(attributeInfo.getSpecIdArray() + ","+specId.toString());
					attributeInfo.setAttrId(attrId);
					attributeService.updateById(attributeInfo);
				}
			}
			String[] specValueArray = specValueStr.split(",");
			for(String v:specValueArray) {
				if(showType == 2) {
					String[] specValue = v.split(":");
					this.addGoodsSpecValueService(specId, specValue[0], specValue[1], isVisible, 255);
				}else {
					this.addGoodsSpecValueService(specId, v, null, 1, 255);
				}
			}
			return specId;
		}catch(RRException e){
	        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	        throw new RRException("保存商品fail!");
	    }
	}

	/**
	 * 根据当前分类ID查询商品分类的三级分类ID
	 * @param categoryId
	 * @return
	 */
	private Integer[] getGoodsCategoryId(Integer categoryId) {
		// 获取分类层级
//		GoodsCategoryEntity info = goodsCategoryService.selectById(categoryId);
//		if(info.getLevel() == 1) {
//			Integer[] ret = {categoryId,0,0};
//			return ret;
//		}
//		if(info.getLevel() == 2) {
//			Integer[] ret = {info.getPid(),categoryId,0};
//			return ret;
//		}
//		if(info.getLevel() == 3) {
//			GoodsCategoryEntity infoParent = goodsCategoryService.selectById(info.getPid());
//			//获取父级
//			Integer[] ret = {infoParent.getPid(),info.getPid(),categoryId};
//			return ret;
//		}
		return null;
	}

	@Override
	@Transactional
	public void deleteGoods(String goodsIds) {
		// TODO Auto-generated method stub
		try {
			String[] arr = goodsIds.split(",");
			List<String> ids = Arrays.asList(arr);
			Integer ret = baseMapper.deleteBatchIds(ids);
			if(ret > 0) {
				for(int i=0;i<arr.length;i++) {
					//删除商品sku
					goodsSkuService.delete(new EntityWrapper<GoodsSkuEntity>().eq("goods_id", arr[i]));
					//删除商品属性
					goodsAttributeService.delete(new EntityWrapper<GoodsAttributeEntity>().eq("goods_id", arr[i]));
					//删除规格图片
					goodsSkuPictureService.delete(new EntityWrapper<GoodsSkuPictureEntity>().eq("goods_id", arr[i]));
				}
			}
		}catch(RRException e){
	        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	        throw new RRException("删除商品fail!");
	    }
	}

	@Override
	public void ModifyGoodsOffline(String goodsIds, int state) {
		// TODO Auto-generated method stub
		GoodsEntity ew = new GoodsEntity();
		ew.setState(state);
		ew.setUpdateTime((int)System.currentTimeMillis() / 1000);
		baseMapper.update(ew, new EntityWrapper<GoodsEntity>().in("goods_id", goodsIds));
	}

	@Override
	public boolean addCart(Integer userId, Integer shopId, Integer goodsId, String goodsName, Integer goodsAttributeId, 
			BigDecimal price, Integer count, Integer pictureId, int blId,Integer type,Integer intoStore,Integer leaveStore,
			int maxUsePoint) {
		Wrapper<CartEntity> wrapper = new EntityWrapper<CartEntity>().eq("buyer_id", userId)
				.eq("goods_id", goodsId);
		if(goodsAttributeId != null && goodsAttributeId != 0) {
			wrapper.eq("sku_id", goodsAttributeId);
		}
		if(userId > 0) {
			int number = 0;
			number = cartService.selectCount(wrapper);
			if(number == 0) {
				CartEntity entity = new CartEntity();
				entity.setBuyerId(userId);
				entity.setShopId(shopId);
				entity.setGoodsId(goodsId);
				entity.setGoodsName(goodsName);
//				entity.setSkuId(skuId);
//				entity.setSkuName(skuName);
				entity.setPrice(price);
				entity.setNum(count);
				entity.setGoodsPicture(pictureId);
				entity.setBlId(blId);
				entity.setType(type);
				entity.setMaxUsePoint(maxUsePoint);
				entity.setIntoStore(intoStore);  //住店日期
				entity.setLeaveStore(leaveStore);  //离店日期
				entity.setSkuId(goodsAttributeId);
				return cartService.insert(entity);
			}else {
				CartEntity entity = cartService.selectOne(wrapper);
				entity.setBuyerId(userId);
				entity.setGoodsId(goodsId);
				entity.setGoodsName(goodsName);
				entity.setPrice(price);
				entity.setSkuId(goodsAttributeId);
				entity.setNum(entity.getNum() + count);
				entity.setGoodsPicture(pictureId);
				entity.setType(type);
				entity.setMaxUsePoint(maxUsePoint);
				entity.setIntoStore(intoStore);  //住店日期
				entity.setLeaveStore(leaveStore);  //离店日期
				return cartService.insertOrUpdate(entity);
			}
		}
		return false;
	}

	@SuppressWarnings("unused")
	@Override
	public List<CartEntity> getCart(Integer userId,Integer type) {
		List<CartEntity> cartGoodsList = new ArrayList<CartEntity>();
		if(userId > 0) {
			cartGoodsList = cartService.selectList(new EntityWrapper<CartEntity>().eq("buyer_id", userId).eq("type", type));
		}
		if(!cartGoodsList.isEmpty()) {
//			Integer[] goodsIdArray = new Integer[cartGoodsList.size()];
			for (int i = 0; i < cartGoodsList.size(); i++) {
//				GoodsEntity goodsInfo = baseMapper.selectById(cartGoodsList.get(i).getGoodsId());
//				// 获取商品sku信息
//				GoodsSkuEntity skuInfo = goodsSkuService.selectById(cartGoodsList.get(i).getSkuId());
//				// 将goods_id 存放到数组中
//				goodsIdArray[i] = cartGoodsList.get(i).getGoodsId();
//				// 验证商品或sku是否存在,不存在则从购物车移除
//				if(userId > 0) {
//					if(goodsInfo == null) {
//						cartService.delete(new EntityWrapper<CartEntity>().eq("goodsId", cartGoodsList.get(i).getGoodsId()).eq("buyer_id", userId));
//						cartGoodsList.remove(i);
//						continue;
//					}
//					if(skuInfo == null) {
//						cartGoodsList.remove(i);
//						cartService.delete(new EntityWrapper<CartEntity>().eq("sku_id", cartGoodsList.get(i).getSkuId()).eq("buyer_id", userId));
//						continue;
//					}
//					if(goodsInfo.getState() != 1) {
//						cartGoodsList.remove(i);
//						continue;
//					}
//				}
				AlbumPictureEntity pictureInfo = albumPictureService.selectById(cartGoodsList.get(i).getGoodsPicture());
				cartGoodsList.get(i).setPictureInfo(pictureInfo);
				
				//如果是房间类型购物车
				if(type == 1) {
					//查询会员等级
					MemberEntity memberInfo = memberService.selectOne(new EntityWrapper<MemberEntity>().eq("uid", userId));
					int level = rewardCalcuUtil.getCurrentLevel(userId, String.valueOf(memberInfo.getPid()));
					
					Integer intoDate = cartGoodsList.get(i).getIntoStore();
					Integer leaveDate = cartGoodsList.get(i).getLeaveStore();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
					String intoDateFormat = sdf.format(new Date(Long.valueOf(intoDate+"000"))); 
					String leaveDateFormat = sdf.format(new Date(Long.valueOf(leaveDate+"000"))); 
					
//					String[] intoArr = intoDateFormat.split("-");
//					int iday = new Integer(intoArr[2]);
//					String[] leaveArr = leaveDateFormat.split("-");
//					int lday = new Integer(leaveArr[2]);
//					
//					Integer goodsId = cartGoodsList.get(i).getGoodsId();
					//查询会员等级日历价格
//					GoodsEntity objData = baseMapper.selectById(goodsId);
//					if(!org.springframework.util.StringUtils.isEmpty(objData.getExtends1())) {
//						JSONArray objArr = JSONArray.fromObject(objData.getExtends1()); 
//						if(level == 4) {  //普通价格
//							Map<String,Object> map = this.makePrice(objArr,"price0",intoArr,leaveArr,iday,lday);
//							cartGoodsList.get(i).setPrice(new BigDecimal(map.get("newPrice").toString()));
//							cartGoodsList.get(i).setBadDay(new Integer(map.get("badDay").toString()));
//						}else if(level == 1) {  //合伙人价格
//							Map<String,Object> map = this.makePrice(objArr,"price1",intoArr,leaveArr,iday,lday);
//							cartGoodsList.get(i).setPrice(new BigDecimal(map.get("newPrice").toString()));
//							cartGoodsList.get(i).setBadDay(new Integer(map.get("badDay").toString()));   //共几晚
//						}else if(level == 2 || level == 3) {  //高级会员/受邀会员价格
//							Map<String,Object> map = this.makePrice(objArr,"price2",intoArr,leaveArr,iday,lday);
//							cartGoodsList.get(i).setPrice(new BigDecimal(map.get("newPrice").toString()));
//							cartGoodsList.get(i).setBadDay(new Integer(map.get("badDay").toString()));
//						}
//					}
				}
			}
		}
		return cartGoodsList;
	}

	/**
	 * 房间不同身份价格
	 * @param objArr
	 * @param lday 
	 * @param iday 
	 * @param intoArr 
	 * @param leaveArr 
	 * @param string
	 * @return
	 */
	@SuppressWarnings("unused")
	private Map<String, Object> makePrice(JSONArray objArr, String price, String[] intoArr, String[] leaveArr, int iday, int lday) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		double newPrice = 0;
		Integer[] intArr = new Integer[2];
		int badDay = 0;  //相差天数
		int w = 0;
		for(int j=0; j<objArr.size(); j++) {
			if(objArr.getJSONObject(j).getString("year").equals(intoArr[0]) && objArr.getJSONObject(j).getString("month").equals(intoArr[1])) {  //如果年，月相等
				if(objArr.getJSONObject(j).getString("year").equals(leaveArr[0]) && objArr.getJSONObject(j).getString("month").equals(leaveArr[1])) {
					for(int k=0; k<objArr.getJSONObject(j).getJSONArray(price).size();k++) {
						if(objArr.getJSONObject(j).getJSONArray(price).getString(k) == null || objArr.getJSONObject(j).getJSONArray(price).getString(k).equals("null")) {
							w = k;
						}
					}
					int p = 1;
					for(int k=w+1; k<objArr.getJSONObject(j).getJSONArray(price).size();k++) {
						if(iday == p) {
							intArr[0] = k;
						}
						if(lday == p) {
							intArr[1] = k;
						}
						p++;
					}
					for(int z=intArr[0]; z<intArr[1];z++) {
						newPrice += objArr.getJSONObject(j).getJSONArray(price).getDouble(z);
					}
					badDay = intArr[1] - intArr[0];  //相差天数
				}
			}
		}
		map.put("badDay", badDay);
		map.put("newPrice", newPrice);
		return map;
	}

	@Override
	public void cartAdjustNum(Integer cartId, Integer num, Integer userId) {
		// TODO Auto-generated method stub
		if(userId > 0) {
			CartEntity info = new CartEntity();
			info.setNum(num);
			cartService.update(info, new EntityWrapper<CartEntity>().eq("cart_id", cartId));
		}
	}

	@Override
	public PageUtils queryRoomList(Map<String, String> params) {
		int limit = Integer.parseInt((String)params.get("limit"));
    	int current = (Integer.parseInt((String)params.get("page")));
    	Page<GoodsEntity> page = new Page<GoodsEntity>(current,limit);
    	List<GoodsEntity> pageList = baseMapper.queryRoomList(page, params);
    	page.setRecords(pageList);
		return new PageUtils(page);
	}

	@Override
	public GoodsEntity queryRoomUse(Map<String, String> params) {
		return baseMapper.queryRoomUse(params);
	}
}
