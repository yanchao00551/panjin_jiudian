
package com.jiudian.modules.app.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Consumer;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.transaction.support.DefaultTransactionDefinition;
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
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.jiudian.StartUpRunner;
import com.jiudian.common.exception.RRException;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;
import com.jiudian.common.utils.SMSConfig;
import com.jiudian.common.utils.SMSMessage;
import com.jiudian.common.utils.SpringContextUtils;
import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.album.service.AlbumPictureService;
import com.jiudian.modules.app.annotation.Login;
import com.jiudian.modules.app.calculate.RewardCaculationManager;
import com.jiudian.modules.app.calculate.RewardCalcuTask;
import com.jiudian.modules.app.calculate.RewardCalcuUtil;
import com.jiudian.modules.app.entity.GenerateOrderGoodsEntity;
import com.jiudian.modules.app.entity.UserEntity;
import com.jiudian.modules.app.form.OrderForm;
import com.jiudian.modules.app.form.PayForm;
import com.jiudian.modules.app.service.UserService;
import com.jiudian.modules.balance.entity.BalanceCofigEntity;
import com.jiudian.modules.balance.service.BalanceCofigService;
import com.jiudian.modules.cart.entity.CartEntity;
import com.jiudian.modules.cart.service.CartService;
import com.jiudian.modules.goods.entity.GoodsAttributeEntity;
import com.jiudian.modules.goods.entity.GoodsEntity;
import com.jiudian.modules.goods.service.GoodsAttributeService;
import com.jiudian.modules.goods.service.GoodsService;
import com.jiudian.modules.member.entity.MemberAccountEntity;
import com.jiudian.modules.member.entity.MemberAccountRecordsEntity;
import com.jiudian.modules.member.entity.MemberEntity;
import com.jiudian.modules.member.entity.MemberExpressAddressEntity;
import com.jiudian.modules.member.service.MemberAccountRecordsService;
import com.jiudian.modules.member.service.MemberAccountService;
import com.jiudian.modules.member.service.MemberExpressAddressService;
import com.jiudian.modules.member.service.MemberService;
import com.jiudian.modules.order.entity.GoodsCommentEntity;
import com.jiudian.modules.order.entity.OrderConfirmEntity;
import com.jiudian.modules.order.entity.OrderEntity;
import com.jiudian.modules.order.entity.OrderGoodsEntity;
import com.jiudian.modules.order.service.GoodsCommentService;
import com.jiudian.modules.order.service.OrderGoodsService;
import com.jiudian.modules.order.service.OrderService;
import com.jiudian.modules.star.entity.StarEntity;
import com.jiudian.modules.star.service.StarService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 订单控制器
 * 
 * @author KF-180419
 *
 */
@RestController
@RequestMapping("/app")
@Api("订单管理接口")
public class AppOrderController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private GoodsCommentService goodsCommentService;
	@Autowired
	private OrderGoodsService orderGoodsService;
	@Autowired
	private AlbumPictureService albumPictureService;
	@Autowired
	private UserService userService;
	@Autowired
	private MemberExpressAddressService memberExpressAddressService;
//	@Autowired
//	private GoodsSkuService goodsSkuService;
	@Autowired
	private RewardCalcuUtil rewardCalcuUtil;
	@Autowired
	private CartService cartService;
	@Autowired
	private MemberAccountRecordsService memberAccountRecordsService;
	@Autowired
	private MemberAccountService memberAccountService;
	@Autowired
	private RewardCaculationManager rewardCaculationManager;
	@Autowired
	private GoodsAttributeService goodsAttributeService;
	@Autowired
	private StarService starService;
	@Autowired
	private BalanceCofigService balanceCofigService;

	@Login
	@GetMapping("confirmOrder")
	@ApiOperation("确认订单")
	public R confirmOrder(@RequestAttribute("userId") Integer userId, @RequestParam Map<String, String> params) {
		OrderConfirmEntity confirmEntity = new OrderConfirmEntity();
		String goodsIdList = params.get("goods_id_list");
		String[] goodsIds = goodsIdList.split(",");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("uid", userId);
		MemberEntity memberEntity = memberService.queryByUserDetail(map);
		confirmEntity.setMemberEntity(memberEntity);
//    	memberEntity.setMobile(memberEntity.getMobile().substring(0, 3) + "****" + memberEntity.getMobile().substring(7, 11));
		MemberExpressAddressEntity expressAddressEntity = memberService.getDefaultExpressAddress(userId);
		confirmEntity.setExpressAddressEntity(expressAddressEntity);
		List<GoodsEntity> goodsEntities = new ArrayList<GoodsEntity>();
		for (String goodsId : goodsIds) {
			goodsEntities.add(goodsService.selectOne(new EntityWrapper<GoodsEntity>().eq("goods_id", goodsId)));
		}
		confirmEntity.setGoodsEntities(goodsEntities);
		return R.ok().put("data", confirmEntity);
	}

	@SuppressWarnings("unchecked")
	@Login
	@GetMapping("goodsOrderList")
	@ApiOperation("订单列表")
	public R goodsOrderList(@RequestAttribute("userId") Integer userId, @RequestParam Map<String, String> params) {
		params.put("buyerId", String.valueOf(userId));
		params.put("shopId", "0");
		if (params.containsKey("orderStatus2")) {
			if (params.get("orderStatus2") == null || "".equals(params.get("orderStatus2"))) {
				params.remove("orderStatus2");
			}
			if("2".equals(params.get("orderStatus2"))) {
				params.remove("orderStatus2");
				params.put("orderStatus3", "2,6");
			}
		}
		PageUtils result = orderService.getOrderList(params);
		List<OrderEntity> orderEntities = (List<OrderEntity>) result.getList();
		orderEntities.forEach(oe -> {
			int curr = (int) (System.currentTimeMillis() / 1000);
			if(oe.getOrderStatus() == 0 && curr - oe.getCreateTime() > 30 * 60 ) {
				oe.setOrderStatus(5);
				orderService.insertOrUpdate(oe);
				if(oe.getOrderStatus() != 1) {
					List<OrderGoodsEntity> orderGoodsEntities = orderGoodsService
							.selectList(new EntityWrapper<OrderGoodsEntity>().eq("order_id", oe.getOrderId()));
					orderGoodsEntities.forEach(og -> {
						int goodsId = og.getGoodsId();
						GoodsEntity goodsEntity = goodsService
								.selectOne(new EntityWrapper<GoodsEntity>().eq("goods_id", goodsId));
						int stock = goodsEntity.getStock();
						goodsEntity.setStock(stock + Integer.parseInt(og.getNum()));
					});
				}
			}
		});
		return R.ok().put("data", result);
	}

	@Login
	@PostMapping("commitRecieve")
	@ApiOperation("确认收货")
	public R commitRecieve(@RequestAttribute("userId") Integer userId, @RequestParam Map<String, String> params) {
		String orderId = params.get("orderId");
		if (orderId == null) {
			return R.error("没有获取到订单信息");
		}
		OrderEntity detail = orderService.getOrderDetail(Integer.parseInt(orderId));
		if (detail == null) {
			return R.error("没有获取到订单信息");
		}
		detail.setOrderStatus(3);// 已收货/待评价
		return orderService.insertOrUpdate(detail) ? R.ok() : R.error("数据更新失败！");
	}

	@Login
	@GetMapping("goodsOrderDetail")
	@ApiOperation("订单详情")
	public R goodsOrderDetail(@RequestParam Map<String, String> params) {
		String orderId = params.get("orderId");
		if (orderId == null) {
			return R.error("没有获取到订单信息");
		}
		OrderEntity detail = orderService.getOrderDetail(Integer.parseInt(orderId));
		if (detail == null) {
			return R.error("没有获取到订单信息");
		}
		return R.ok().put("data", detail);
	}

	@Login
	@PostMapping("cancelOrder")
	@ApiOperation("取消订单")
	public R cancelOrder(@RequestParam Map<String, String> params) {
		String orderId = params.get("orderId");
		if (orderId == null) {
			return R.error("没有获取到订单信息");
		}
		Wrapper<OrderEntity> wrapper = new EntityWrapper<OrderEntity>().eq("order_id", orderId);
		OrderEntity orderEntity = orderService.selectOne(wrapper);
		orderEntity.setOrderStatus(5); // 设置状态为已关闭
		boolean res = orderService.update(orderEntity, wrapper);
		if (res) {
			// 修改库存
			List<OrderGoodsEntity> orderGoodsEntities = orderGoodsService
					.selectList(new EntityWrapper<OrderGoodsEntity>().eq("order_id", orderId));
			orderGoodsEntities.forEach(og -> {
				int goodsId = og.getGoodsId();
				GoodsEntity goodsEntity = goodsService
						.selectOne(new EntityWrapper<GoodsEntity>().eq("goods_id", goodsId));
				int stock = goodsEntity.getStock();
				goodsEntity.setStock(stock + Integer.parseInt(og.getNum()));
			});
		} else {
			return R.error("更新失败");
		}
		return R.ok();
	}

	@Login
	@PostMapping("dropOrder")
	@ApiOperation("删除订单")
	public R dropOrder(@RequestParam Map<String, String> params) {
		String orderId = params.get("orderId");
		if (orderId == null) {
			return R.error("没有获取到订单信息");
		}
		Wrapper<OrderEntity> wrapper = new EntityWrapper<OrderEntity>().eq("order_id", orderId);
		OrderEntity orderEntity = orderService.selectOne(wrapper);
		orderEntity.setIsDeleted(1); // 设置已删除
		boolean res = orderService.update(orderEntity, wrapper);
		if (!res) {
			return R.error("删除失败");
		}
		return R.ok();
	}

	@Login
	@PostMapping("commentGoods")
	@ApiOperation("评价商品")
	@Transactional
	public R commentGoods(@RequestAttribute("userId") Integer userId, @RequestParam Map<String, String> params) {
//		if(Constant.getWordCount(params.get("comments")) > 400) {
//    		return R.error("评论内容超过长度限制");
//    	}
		GoodsCommentEntity commentEntity = new GoodsCommentEntity();
		commentEntity.setOrderId(Integer.parseInt(params.get("order_id")));
		commentEntity.setGoodsId(Integer.parseInt(params.get("goods_id")));
		commentEntity.setPoint(Double.parseDouble(params.get("point")));
		commentEntity.setComments(params.get("comments"));
		commentEntity.setUid(userId);
		commentEntity.setShopId(0);
		commentEntity.setCreateTime((int) (System.currentTimeMillis() / 1000));
		boolean res = goodsCommentService.insert(commentEntity);
		if (!res) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return R.error("评价添加失败");
		}
		// 更新评价状态
		Wrapper<OrderGoodsEntity> wrapper = new EntityWrapper<OrderGoodsEntity>().eq("order_id", params.get("order_id"))
				.eq("goods_id", params.get("goods_id"));
		OrderGoodsEntity entity = orderGoodsService.selectOne(wrapper);
		entity.setIsEvaluate(1); // 已评价
		res = orderGoodsService.insertOrUpdate(entity);
//		if(!res) {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//			return R.error("订单评价");
//		}
		String orderId = params.get("order_id");
		if (orderId == null) {
			return R.error("没有获取到订单信息");
		}
		OrderEntity detail = orderService.getOrderDetail(Integer.parseInt(orderId));
		if (detail == null) {
			return R.error("没有获取到订单信息");
		}
		boolean isEvl = true;
		List<OrderGoodsEntity> orderGoodsEntities = orderGoodsService.selectList
				(new EntityWrapper<OrderGoodsEntity>().eq("order_id", params.get("order_id")));
		for (OrderGoodsEntity oge : orderGoodsEntities) {
			int evl = oge.getIsEvaluate();
			if(evl != 1) {
				isEvl = false;
				break;
			}
		}
		if(isEvl) {
			detail.setOrderStatus(4);// 已完成			
			res = orderService.insertOrUpdate(detail);
		}
		if (!res) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return R.error("订单状态更新失败");
		}
		return res ? R.ok() : R.error("评价添加失败");
	}

	@GetMapping("getComments")
	@ApiOperation("获取商品评价信息")
	public R getComments(@RequestParam Map<String, Object> params) {
		PageUtils pageUtils = goodsCommentService.queryPage(params,"2");
		@SuppressWarnings("unchecked")
		List<GoodsCommentEntity> commentEntities = (List<GoodsCommentEntity>) pageUtils.getList();
		int count = goodsCommentService.selectCount(
				new EntityWrapper<GoodsCommentEntity>().eq("goods_id", params.get("goodsId")).eq("review_status", 2));
		commentEntities.forEach(new Consumer<GoodsCommentEntity>() {
			public void accept(GoodsCommentEntity commentEntity) {
				// 查询评价用户详细信息
				UserEntity userEntity = userService
						.selectOne(new EntityWrapper<UserEntity>().eq("user_id", commentEntity.getUid()));
				AlbumPictureEntity info = new AlbumPictureEntity();
				info = albumPictureService.selectById(userEntity.getUserHeadimg());
				userEntity.setUserHeadImgDetail(info);
				commentEntity.setUserEntity(userEntity);
				// 计算评价时间显示方式
				temp = 0;
				commentEntity.setCommentDate(
						caculateDate((int) (System.currentTimeMillis() / 1000) - commentEntity.getCreateTime()));
			};
		});
		return R.ok(String.valueOf(count)).put("data", pageUtils);
	}

	@Login
	@PostMapping("generateOrder")
	@ApiOperation("生成订单")
	public R commitOrder(@RequestAttribute("userId") Integer userId, @RequestBody OrderForm orderForm) {
		// 验证库存是否充足
		List<GenerateOrderGoodsEntity> generateOrderGoodsEntities = orderForm.getGenerateOrderGoodsEntities();
		String errGoodsName = "";
		int err = 0;
		if (orderForm.getOrderType() != 1) {
			for (GenerateOrderGoodsEntity goge : generateOrderGoodsEntities) {
				int goodsId = goge.getGoodsId();
				GoodsEntity goodsEntity = goodsService
						.selectOne(new EntityWrapper<GoodsEntity>().eq("goods_id", goodsId));
				int stock = goodsEntity.getStock();
				if (stock == 0 || stock < goge.getCount()) {
					err = -3;
					errGoodsName = goodsEntity.getGoodsName();
					break;
				}
				if(goodsEntity.getState() == 0) {
					errGoodsName = goodsEntity.getGoodsName();
					return R.error("商品【" + errGoodsName + "】已下架，无法生成订单");
				}
				if(goge.getSkuId() != 0) {
					List<GoodsAttributeEntity> goodsAttributeEntities = goodsAttributeService.selectList
							(new EntityWrapper<GoodsAttributeEntity>().eq("goods_id", goodsId));
					if(goodsAttributeEntities == null || goodsAttributeEntities.size() == 0) {
						err = -1;
						errGoodsName = goodsEntity.getGoodsName();
						break;
					}
					for (GoodsAttributeEntity ga : goodsAttributeEntities) {
						if(ga.getPrice() == null || ga.getPrice().compareTo(new BigDecimal(0)) == 0) {
							err = -2;
							errGoodsName = goodsEntity.getGoodsName();
							break;
						}
					}
				}
				
			}
			if (err < 0) {
				return err == -3 ? R.error("商品【" + errGoodsName + "】库存不足，无法生成订单") :
					R.error("商品【" + errGoodsName + "】信息异常，无法生成订单");
			}
		}else {
			//酒店房间库存check
			for (GenerateOrderGoodsEntity goge : generateOrderGoodsEntities) {
				int goodsId = goge.getGoodsId();
				Map<String, String> params = new HashMap<String,String>();
				params.put("goodsId", String.valueOf(goodsId));
				params.put("liveIn", orderForm.getLiveIn());
				params.put("leaveOut", orderForm.getLeaveOut());
				GoodsEntity ge = goodsService.queryRoomUse(params);
				int count = 0;
				if(ge != null) {
					count = ge.getSoldcount();
				}
				GoodsEntity goodsEntity = goodsService.selectOne
						(new EntityWrapper<GoodsEntity>().eq("goods_id", goodsId));
				if(goodsEntity != null) {
					if(goodsEntity.getStock() - count - goge.getCount() < 0) {
						errGoodsName = goodsEntity.getGoodsName();
						err = -1;
						break;
					}
					if(goodsEntity.getState() == 0) {
						errGoodsName = goodsEntity.getGoodsName();
						return R.error("酒店【" + errGoodsName + "】已下架，无法生成订单");
					}
				}
			}
			if (err < 0) {
				return R.error("酒店【" + errGoodsName + "】库存不足，无法生成订单");
			}
		}

//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
		BigDecimal decZero = new BigDecimal(0);
		UserEntity userEntity = userService.selectOne(new EntityWrapper<UserEntity>().eq("user_id", userId));
		MemberExpressAddressEntity memberExpressAddressEntity = memberExpressAddressService
				.selectOne(new EntityWrapper<MemberExpressAddressEntity>().eq("id", orderForm.getRecieverAddressId()));
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setOrderNo(generateOrderNumByUUId());
		orderEntity.setOrderFrom(fillEmptyStr(null));
		orderEntity.setOrderType(orderForm.getOrderType());
		orderEntity.setBuyerId(userId);
		orderEntity.setUserName(userEntity.getUsername());
		orderEntity.setBuyerIp(fillEmptyStr(userEntity.getLastLoginIp(), "127.0.0.1"));
		orderEntity.setBuyerMessage(fillEmptyStr(orderForm.getBuyerMsg(), ""));
		orderEntity.setBuyerInvoice(orderForm.getBuyerInvoice());//
		orderEntity.setKeyId(orderForm.getKeyId());
		orderEntity.setKeyCommentFlag(0);
		if (orderForm.getOrderType() == 1) {
			orderEntity.setReceiverMobile(orderForm.getReceiverMobile());
		} else {
			orderEntity.setReceiverMobile(
					memberExpressAddressEntity == null ? "" : memberExpressAddressEntity.getMobile());
		}

		orderEntity
				.setReceiverProvince(memberExpressAddressEntity == null ? 0 : memberExpressAddressEntity.getProvince());
		orderEntity.setReceiverCity(memberExpressAddressEntity == null ? 0 : memberExpressAddressEntity.getCity());
		orderEntity
				.setReceiverDistrict(memberExpressAddressEntity == null ? 0 : memberExpressAddressEntity.getDistrict());
		orderEntity
				.setReceiverAddress(memberExpressAddressEntity == null ? "" : memberExpressAddressEntity.getAddress());
		orderEntity.setReceiverZip("0");
		if (orderForm.getOrderType() == 1) {
			orderEntity.setReceiverName(orderForm.getReceiverName());
		} else {
			orderEntity.setReceiverName(
					memberExpressAddressEntity == null ? "" : memberExpressAddressEntity.getConsigner());
		}
		orderEntity.setShopId(0);
		orderEntity.setShopName(fillEmptyStr(null));
		orderEntity.setSellerStar(0);
		orderEntity.setSellerMemo(fillEmptyStr(null));
		orderEntity.setGoodsMoney(decZero);
		orderEntity.setOrderMoney(decZero);
		orderEntity.setPoint(0);
		orderEntity.setPointMoney(decZero);
		orderEntity.setCouponMoney(decZero);
		orderEntity.setCouponId(0);
		orderEntity.setPromotionMoney(decZero);
		orderEntity.setShippingMoney(decZero);
		orderEntity.setPayMoney(decZero);
		orderEntity.setRefundMoney(decZero);
		orderEntity.setGiveCoin(decZero);
		orderEntity.setOrderStatus(0);// 订单状态：待付款
		orderEntity.setPayStatus(0);
		orderEntity.setShippingStatus(0);
		orderEntity.setReviewStatus(0);
		orderEntity.setFeedbackStatus(0);
		orderEntity.setFixedTelephone("0");
		orderEntity.setGivePoint(0);
		orderEntity.setCreateTime((int) (System.currentTimeMillis() / 1000));

		boolean res = orderService.insert(orderEntity);
		if (res) {
			final List<BigDecimal> priceDecimals = new ArrayList<BigDecimal>();
			priceDecimals.add(new BigDecimal(0));
			List<OrderGoodsEntity> orderGoodsEntities = new ArrayList<OrderGoodsEntity>();
			generateOrderGoodsEntities.forEach(new Consumer<GenerateOrderGoodsEntity>() {
				@SuppressWarnings("deprecation")
				@Override
				public void accept(GenerateOrderGoodsEntity t) {
					int count = t.getCount();
					int skuId = t.getSkuId();
					GoodsEntity goodsEntity = goodsService
							.selectOne(new EntityWrapper<GoodsEntity>().eq("goods_id", t.getGoodsId()));
					BigDecimal price = null;
					if (orderForm.getOrderType() == 2) {
						//商品属性价格计算
						GoodsAttributeEntity goodsAttributeEntity = goodsAttributeService.selectOne
								(new EntityWrapper<GoodsAttributeEntity>().eq("attr_id", t.getSkuId()));
						if(goodsAttributeEntity != null && goodsAttributeEntity.getPrice() != null) {
							price = goodsAttributeEntity.getPrice().multiply(new BigDecimal(count));
						}
					} else if (orderForm.getOrderType() == 1) {
						//酒店房价计算
						price = new BigDecimal(0);
						MemberEntity memberEntity = memberService
								.selectOne(new EntityWrapper<MemberEntity>().eq("uid", userId));
						int level = rewardCalcuUtil.getCurrentLevel(userId, String.valueOf(memberEntity.getPid()));
						JSONArray jsonArray = JSON.parseArray(goodsEntity.getExtends1());
						JSONObject startJsonObject = null;
						JSONObject endJsonObject = null;
						int liveInYear = 0;
						int leaveOutYear = 0;
						int liveInMonth = 0;
						int leaveOutMonth = 0;
						int liveInDay = 0;
						int leaveOutDay = 0;
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
						try {
							Date liveIn = dateFormat.parse(orderForm.getLiveIn());
							Date leaveOut = dateFormat.parse(orderForm.getLeaveOut());
							liveInYear = 1900 + liveIn.getYear();
							leaveOutYear = 1900 + leaveOut.getYear();
							liveInMonth = liveIn.getMonth() + 1;
							leaveOutMonth = leaveOut.getMonth() + 1;
							liveInDay = liveIn.getDate();
							leaveOutDay = leaveOut.getDate();
						} catch (ParseException e) {
							e.printStackTrace();
						}
						Calendar sCalendar = Calendar.getInstance();
						sCalendar.set(liveInYear, liveInMonth - 1, 1);
						int sDayOfWeek = sCalendar.getTime().getDay();
						Calendar eCalendar = Calendar.getInstance();
						eCalendar.set(leaveOutYear, leaveOutMonth - 1, 1);
						int eDayOfWeek = eCalendar.getTime().getDay();
						for (int i = 0; i < jsonArray.size(); i++) {
							String tYear = jsonArray.getJSONObject(i).getString("year");
							String tMonth = jsonArray.getJSONObject(i).getString("month");
							if (!StringUtils.isEmpty(tYear) && tYear.equals(String.valueOf(liveInYear))
									&& !StringUtils.isEmpty(tMonth) && tMonth.equals(String.valueOf(liveInMonth))) {
								startJsonObject = jsonArray.getJSONObject(i);
							}
							if (!StringUtils.isEmpty(tYear) && tYear.equals(String.valueOf(leaveOutYear))
									&& !StringUtils.isEmpty(tMonth) && tMonth.equals(String.valueOf(leaveOutMonth))) {
								endJsonObject = jsonArray.getJSONObject(i);
							}
						}
						String stmpPrice0 = startJsonObject.getString("price0").replaceAll("\\[", "")
								.replaceAll("\\]", "").replaceAll("null", "");
						String stmpPrice1 = startJsonObject.getString("price1").replaceAll("\\[", "")
								.replaceAll("\\]", "").replaceAll("null", "");
						String stmpPrice2 = startJsonObject.getString("price2").replaceAll("\\[", "")
								.replaceAll("\\]", "").replaceAll("null", "");
						String etmpPrice0 = endJsonObject == null ? stmpPrice0
								: (endJsonObject.getString("price0").replaceAll("\\[", "").replaceAll("\\]", "")
										.replaceAll("null", ""));
						String etmpPrice1 = endJsonObject == null ? stmpPrice1
								: (endJsonObject.getString("price1").replaceAll("\\[", "").replaceAll("\\]", "")
										.replaceAll("null", ""));
						String etmpPrice2 = endJsonObject == null ? stmpPrice2
								: (endJsonObject.getString("price2").replaceAll("\\[", "").replaceAll("\\]", "")
										.replaceAll("null", ""));

						for (int j = 0; j < sDayOfWeek - 1; j++) {
							stmpPrice0 = stmpPrice0.replaceFirst(",", "");
							stmpPrice1 = stmpPrice1.replaceFirst(",", "");
							stmpPrice2 = stmpPrice2.replaceFirst(",", "");
						}
						for (int j = 0; j < eDayOfWeek - 1; j++) {
							etmpPrice0 = etmpPrice0.replaceFirst(",", "");
							etmpPrice1 = etmpPrice1.replaceFirst(",", "");
							etmpPrice2 = etmpPrice2.replaceFirst(",", "");
						}
						String[] sPriceNormals = stmpPrice0.split(",");
						String[] sPriceLv1s = stmpPrice1.split(",");
						String[] sPriceLv2s = stmpPrice2.split(",");
						String[] ePriceNormals = etmpPrice0.split(",");
						String[] ePriceLv1s = etmpPrice1.split(",");
						String[] ePriceLv2s = etmpPrice2.split(",");
						String[] sPriceTemp = null;
						String[] ePriceTemp = null;
						switch (level) {
						case 1:
							sPriceTemp = sPriceLv1s;
							ePriceTemp = ePriceLv1s;
							break;
						case 2:
						case 3:
							sPriceTemp = sPriceLv2s;
							ePriceTemp = ePriceLv2s;
							break;
						case 4:
							sPriceTemp = sPriceNormals;
							ePriceTemp = ePriceNormals;
							break;
						default:
							break;
						}
						if (startJsonObject == endJsonObject) {// 同月
							for (int i = liveInDay; i < leaveOutDay; i++) {
								price = price.add(new BigDecimal(sPriceTemp[i - 1].replaceAll("\"", "")));
							}
						} else {// 跨月
							for (int i = liveInDay; i <= sPriceTemp.length; i++) {
								price = price.add(new BigDecimal(sPriceTemp[i - 1].replaceAll("\"", "")));
							}
							for (int i = 1; i < leaveOutDay; i++) {
								price = price.add(new BigDecimal(ePriceTemp[i - 1].replaceAll("\"", "")));
							}
						}
						price = price.multiply(new BigDecimal(count));
					}
					priceDecimals.set(0, priceDecimals.get(0).add(price));
//					GoodsSkuEntity goodsSkuEntity = goodsSkuService
//							.selectOne(new EntityWrapper<GoodsSkuEntity>().eq("sku_id", skuId));
					OrderGoodsEntity orderGoodsEntity = new OrderGoodsEntity();
					orderGoodsEntity.setOrderId(orderEntity.getOrderId());
					orderGoodsEntity.setGoodsId(t.getGoodsId());
					orderGoodsEntity.setGoodsName(goodsEntity.getGoodsName());
					orderGoodsEntity.setSkuId(skuId);
					orderGoodsEntity.setSkuName(fillEmptyStr(null));
					orderGoodsEntity.setNum(String.valueOf(count));
					orderGoodsEntity.setBuyerId(userId);
//				orderGoodsEntity.setPicture(albumPictureService.selectOne(
//						new EntityWrapper<AlbumPictureEntity>().eq("pic_id", goodsEntity.getPicture())));
					orderGoodsEntity.setGoodsPicture(goodsEntity.getPicture());
					orderGoodsEntity.setShopId(0);
					orderGoodsEntity.setPointExchangeType(0);// 非积分兑换
					orderGoodsEntity.setOrderType(goodsEntity.getGoodsAttributeId());
					orderGoodsEntity.setOrderStatus(0);// 待付款
					orderGoodsEntity.setGivePoint(0);// 积分获取，暂未明确规则，暂定为0
					orderGoodsEntity.setRefundReason(fillEmptyStr(null));
					orderGoodsEntity.setRefundShippingCode("0");
					orderGoodsEntity.setTmpExpressCompany(fillEmptyStr(null));
					orderGoodsEntity.setGiftFlag(1);// 非赠品
					orderGoodsEntity.setMemo(fillEmptyStr(null));
					orderGoodsEntity.setIsEvaluate(0);// 未评价
					orderGoodsEntity.setPrice(price);
					// 酒店订单更新入住离店信息
					try {
						if (orderForm.getOrderType() == 1) {
							SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
							orderGoodsEntity.setLiveinDate(dateFormat.parse(orderForm.getLiveIn()));
							orderGoodsEntity.setLeaveoutDate(dateFormat.parse(orderForm.getLeaveOut()));
							int liveDays = (int)((orderGoodsEntity.getLeaveoutDate().getTime()/1000 - 
									orderGoodsEntity.getLiveinDate().getTime() / 1000) / 24 / 60 / 60);
							orderGoodsEntity.setMaxUsePoint((goodsEntity.getMaxUsePoint() * count * liveDays));
						}
					} catch (ParseException e) {
						e.printStackTrace();
					}
					orderGoodsService.insert(orderGoodsEntity);
					orderGoodsEntities.add(orderGoodsEntity);
					dropGoodsFromCart(userId, t.getGoodsId(),t.getSkuId());
				}
			});
			orderEntity.setOrderMoney(priceDecimals.get(0));
			orderService.insertOrUpdate(orderEntity);
			// 调整库存
			if (orderForm.getOrderType() != 1) {
				orderGoodsEntities.forEach(og -> {
					int goodsId = og.getGoodsId();
					GoodsEntity goodsEntity = goodsService
							.selectOne(new EntityWrapper<GoodsEntity>().eq("goods_id", goodsId));
					int stock = goodsEntity.getStock();
					goodsEntity.setStock(stock - Integer.parseInt(og.getNum()));
					goodsService.insertOrUpdate(goodsEntity);
				});
			}
		}
		return R.ok().put("id", orderEntity.getOrderId());
	}

	/**
	 * @param userId
	 * @param form
	 * @return
	 */
	@Login
	@PostMapping("payGoods")
	@ApiOperation("商城订单支付")
	@Transactional
	public R payGoods(@RequestAttribute("userId") Integer userId, @RequestBody PayForm form) {
		boolean res = false;
		OrderEntity orderEntity = null;
		try {
			String payPwd = form.getPayPwd();
			UserEntity userEntity = userService.selectOne(new EntityWrapper<UserEntity>().eq("user_id", userId));
			String save = userEntity.getPaymentPassword();
			String now = DigestUtils.md5Hex(payPwd + userEntity.getPaySalt());
			if (StringUtils.isEmpty(now) || !now.equals(save)) {
				return R.error("支付密码错误，支付失败！");
			}
			String orderId = String.valueOf(form.getOrderId());
			orderEntity = orderService.selectOne(new EntityWrapper<OrderEntity>().eq("order_id", orderId));
			Map<String, String> params = new HashMap<>();
			params.put("orderId", orderId);
			List<OrderGoodsEntity> orderGoodsEntities = orderGoodsService.queryOrderGoodsInfo(params);
			int downCount = orderGoodsEntities.stream().filter(oge -> oge.getState() == 0).mapToInt(oge -> 1).sum();
			if(downCount > 0) {
				return R.error("订单包含已下架商品，支付失败！");
			}
			Semaphore semaphore = new Semaphore(0);
			Vector<String> uidVector = new Vector<String>();
			double totalFee = orderEntity.getOrderMoney().doubleValue();
			MemberAccountEntity memberAccountEntity = memberAccountService
					.selectOne(new EntityWrapper<MemberAccountEntity>().eq("uid", userId));
			if (memberAccountEntity.getPoint() < orderEntity.getOrderMoney().intValue()) {
				return R.error("积分余额不足，无法完成支付！");
			}
			if (orderEntity.getOrderStatus() == 3 || orderEntity.getOrderStatus() == 4 || orderEntity.getOrderStatus() == 5) {
				return R.error("该订单为已完成/已关闭状态，无法完成支付！");
			}
			int curr = (int) (System.currentTimeMillis() / 1000);
			if(orderEntity.getOrderStatus() == 0 && curr - orderEntity.getCreateTime() > 30 * 60 ) {
				orderEntity.setOrderStatus(5);
				orderService.insertOrUpdate(orderEntity);
				orderGoodsEntities.forEach(og -> {
					int goodsId = og.getGoodsId();
					GoodsEntity goodsEntity = goodsService
							.selectOne(new EntityWrapper<GoodsEntity>().eq("goods_id", goodsId));
					int stock = goodsEntity.getStock();
					goodsEntity.setStock(stock + Integer.parseInt(og.getNum()));
				});
				return R.error("订单已过期，无法支付");
			}
			RewardCalcuTask rewardCalcuTask = new RewardCalcuTask(String.valueOf(userId), -totalFee,
					memberAccountService, semaphore, uidVector);
			StartUpRunner.executor.getQueue().offer(rewardCalcuTask);
			try {
				semaphore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (uidVector.size() > 0 && uidVector.get(0).equals(String.valueOf(userId))) {
				res = true;
			} else {
				throw new RRException("支付失败");
			}
			if (res) {
				MemberAccountRecordsEntity accountRecordsEntity = new MemberAccountRecordsEntity();
				accountRecordsEntity.setUid(userId);
				accountRecordsEntity.setShopId(0);
				accountRecordsEntity.setAccountType(1);
				accountRecordsEntity.setSign(1);
				accountRecordsEntity.setNumber(orderEntity.getOrderMoney().negate());
				accountRecordsEntity.setFromType(1);
				accountRecordsEntity.setDataId(0);
				accountRecordsEntity.setText("商城订单|订单号：" + orderEntity.getOrderNo());
				accountRecordsEntity.setIsFreeze(0);
				Date date = Calendar.getInstance().getTime();
				accountRecordsEntity.setCreateTime(date);
				res = memberAccountRecordsService.insert(accountRecordsEntity);
			}
			if (!res) {
				throw new RRException("支付失败");
			}
			if (res) {
				orderEntity.setOrderStatus(2);//支付完成
				res = orderService.insertOrUpdate(orderEntity);
			}
			if (!res) {
				throw new RRException("支付失败");
			}
		} catch (Exception e) {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
			return R.error("支付失败");
		}
		if(res) {
			UserEntity userEntity = userService.selectOne
					(new EntityWrapper<UserEntity>().eq("user_id", orderEntity.getBuyerId()));
			sendOrderNotifySMS(userEntity.getNickName(), userEntity.getMobile(), orderEntity);
		}
		return res ? R.ok() : R.error("支付失败！");
	}

	@Login
	@GetMapping("hasPayPwd")
	@ApiOperation("是否设置支付密码")
	public R hasPayPwd(@RequestAttribute("userId") Integer userId, @RequestParam Map<String, String> params) {
		boolean res = false;
		String usePt = params.get("usePoint");
		String orderId = params.get("orderId");
		OrderEntity orderEntity = orderService.selectOne
				(new EntityWrapper<OrderEntity>().eq("order_id", orderId));
		BigDecimal totalFee = orderEntity.getOrderMoney();
		BalanceCofigEntity balanceConfigInfo = balanceCofigService.selectById(1);
		if (balanceConfigInfo == null || balanceConfigInfo.getConvertRate().compareTo(new BigDecimal(0)) == 0) {
			return R.error("系统当前未设置余额兑换积分比例，获取支付信息失败！");
		}
		totalFee = totalFee.add(new BigDecimal(usePt).divide(balanceConfigInfo.getConvertRate()).negate());
		UserEntity userEntity = userService.selectOne(new EntityWrapper<UserEntity>().eq("user_id", userId));
		int isSet = userEntity.getIsSetPaymentPassword();
		if (isSet == 1) {
			res = true;
		}
		return R.ok().put("hasPwd", res).put("fee", totalFee.doubleValue());
	}

//	@Login
//	@PostMapping("valiPayPwd")
//	@ApiOperation("验证支付密码")
//	public R valiPayPwd(@RequestAttribute("userId") Integer userId, @RequestBody PayForm form) {
//		
//			return R.ok();
//		
//	}

	@Login
	@PostMapping("payByBalance")
	@ApiOperation("酒店订单余额支付")
//	@Transactional
	public R payByBalance(@RequestAttribute("userId") Integer userId, @RequestBody PayForm form) {
		boolean res = false;
		OrderEntity orderEntity = null;
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		PlatformTransactionManager txManager = (PlatformTransactionManager) 
				SpringContextUtils.getBean(PlatformTransactionManager.class);
//		PlatformTransactionManager txManager = ContextLoader.getCurrentWebApplicationContext()
//				.getBean(PlatformTransactionManager.class);
		TransactionStatus status = null;
		try {
			String payPwd = form.getPayPwd();
			String usePt = form.getUsePoint();
			BigDecimal usePoint = new BigDecimal(0);
			try {
				if(!StringUtils.isEmpty(usePt)) {
					usePoint = new BigDecimal(usePt);
				}
			} catch (Exception e) {
				return R.error("积分格式输入错误，支付失败！");
			}
			BalanceCofigEntity balanceConfigInfo = balanceCofigService.selectById(1);
			if (balanceConfigInfo == null || balanceConfigInfo.getConvertRate().compareTo(new BigDecimal(0)) == 0) {
				return R.error("系统当前未设置余额兑换积分比例，支付失败！");
			}
			String orderId = String.valueOf(form.getOrderId());
			orderEntity = orderService.selectOne(new EntityWrapper<OrderEntity>().eq("order_id", orderId));
			BigDecimal convert = balanceConfigInfo.getConvertRate();
			BigDecimal totalFee = orderEntity.getOrderMoney();
			totalFee = totalFee.add(usePoint.divide(convert).negate());
			UserEntity userEntity = userService.selectOne(new EntityWrapper<UserEntity>().eq("user_id", userId));
			String save = userEntity.getPaymentPassword();
			String now = DigestUtils.md5Hex(payPwd + userEntity.getPaySalt());
			if (StringUtils.isEmpty(now) || !now.equals(save)) {
				return R.error("支付密码错误，支付失败！");
			}
			int curr = (int) (System.currentTimeMillis() / 1000);
			if(orderEntity.getOrderStatus() == 0 && curr - orderEntity.getCreateTime() > 30 * 60 ) {
				orderEntity.setOrderStatus(5);
				orderService.insertOrUpdate(orderEntity);
				return R.error("订单已过期，无法支付");
			}
			Map<String, String> params = new HashMap<>();
			params.put("orderId", orderId);
			List<OrderGoodsEntity> orderGoodsEntities = orderGoodsService.queryOrderGoodsInfo(params);
			int downCount = orderGoodsEntities.stream().filter(oge -> oge.getState() == 0).mapToInt(oge -> 1).sum();
			if(downCount > 0) {
				return R.error("订单包含已下架商品，支付失败！");
			}
			MemberAccountEntity memberAccountEntity = memberAccountService
					.selectOne(new EntityWrapper<MemberAccountEntity>().eq("uid", userId));
			if (memberAccountEntity.getBalance().compareTo(totalFee) < 0) {
				return R.error("余额不足，无法完成支付！");
			}
			if (orderEntity.getOrderStatus() == 2 || orderEntity.getOrderStatus() == 3 
					|| orderEntity.getOrderStatus() == 4 || orderEntity.getOrderStatus() == 5) {
				return R.error("该订单为已付款/已完成/已关闭状态，无法完成支付！");
			}
			Semaphore semaphore = new Semaphore(0);
			Vector<String> uidVector = new Vector<String>();
			if (memberAccountEntity.getPoint() < usePoint.intValue()) {
				return R.error("积分余额不足，无法完成支付！");
			}
			if(orderGoodsEntities == null || orderGoodsEntities.size() == 0) {
				return R.error("订单没有商品，下单失败！请联系管理员");
			}
			Long maxUse = 0l;
			for (OrderGoodsEntity oge : orderGoodsEntities) {
				maxUse += oge.getMaxUsePoint();
			}
			if(usePoint.compareTo(new BigDecimal(maxUse)) > 0) {
				return R.error("使用积分数大于最大可用积分，支付失败！");
			}
			RewardCalcuTask rewardCalcuTask = new RewardCalcuTask(String.valueOf(userId), usePoint.negate().doubleValue(),
					memberAccountService, semaphore, uidVector);
			StartUpRunner.executor.getQueue().offer(rewardCalcuTask);
			try {
				semaphore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (uidVector.size() > 0 && uidVector.get(0).equals(String.valueOf(userId))) {
				res = true;
			} else {
				throw new RRException("支付失败");
			}
			if (res && usePoint.compareTo(new BigDecimal(0)) != 0) {
				MemberAccountRecordsEntity accountRecordsEntity = new MemberAccountRecordsEntity();
				accountRecordsEntity.setUid(userId);
				accountRecordsEntity.setShopId(0);
				accountRecordsEntity.setAccountType(1);
				accountRecordsEntity.setSign(1);
				accountRecordsEntity.setNumber(usePoint.negate());
				accountRecordsEntity.setFromType(14);
				accountRecordsEntity.setDataId(0);
				accountRecordsEntity.setText("酒店订单积分抵扣|订单号：" + orderEntity.getOrderNo());
				accountRecordsEntity.setIsFreeze(0);
				Date date = Calendar.getInstance().getTime();
				accountRecordsEntity.setCreateTime(date);
				res = memberAccountRecordsService.insert(accountRecordsEntity);
			}
			if (!res) {
				throw new RRException("支付失败");
			}
			status = txManager.getTransaction(def);
			memberAccountEntity = memberAccountService
					.selectOne(new EntityWrapper<MemberAccountEntity>().eq("uid", userId));
			memberAccountEntity.setBalance(memberAccountEntity.getBalance().add(totalFee.negate()));
			res = memberAccountService.insertOrUpdate(memberAccountEntity);
			if (res) {
				MemberAccountRecordsEntity accountRecordsEntity = new MemberAccountRecordsEntity();
				accountRecordsEntity.setUid(userId);
				accountRecordsEntity.setShopId(0);
				accountRecordsEntity.setAccountType(2);
				accountRecordsEntity.setSign(1);
				accountRecordsEntity.setNumber(totalFee.negate());
				accountRecordsEntity.setFromType(14);//酒店订单
				accountRecordsEntity.setDataId(0);
				accountRecordsEntity.setText("余额支付|酒店订单|订单号：" + orderEntity.getOrderNo());
				accountRecordsEntity.setIsFreeze(0);
				Date date = Calendar.getInstance().getTime();
				accountRecordsEntity.setCreateTime(date);
				res = memberAccountRecordsService.insert(accountRecordsEntity);
			}
			if (!res) {
				txManager.rollback(status);
				throw new RRException("支付失败");
			}
			
			if (res) {
				orderEntity.setOrderStatus(2);
				orderEntity.setPoint(usePoint.intValue());
				res = orderService.insertOrUpdate(orderEntity);
			}
			if (!res) {
				txManager.rollback(status);
				throw new RRException("支付失败");
			}
			if (res) {
				rewardCaculationManager.calcuPush(orderEntity.getOrderNo(), totalFee.doubleValue(), false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			if(status != null) {
				txManager.rollback(status);
			}
			return R.error("支付失败");
		}
//		if(res) {
//			UserEntity userEntity = userService.selectOne
//					(new EntityWrapper<UserEntity>().eq("user_id", orderEntity.getBuyerId()));
//			sendOrderNotifySMS(userEntity.getNickName(), userEntity.getMobile(), orderEntity);
//		}
		if(status != null) {
			txManager.commit(status);
		}
		return res ? R.ok() : R.error("支付失败！");
	}

	private boolean dropGoodsFromCart(int userId, int goodsId, int skuId) {
		return cartService.delete(new EntityWrapper<CartEntity>().eq("buyer_id", userId)
				.eq("goods_id", goodsId).eq("sku_id", skuId));
	}

	// 30位订单号
	public String generateOrderNumByUUId() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss");
		String timeStr = simpleDateFormat.format(Calendar.getInstance().getTime());
		String randomNum = RandomStringUtils.randomNumeric(4);
//		int hCode = UUID.randomUUID().toString().hashCode();
//		if (hCode < 0) {
//			hCode = -hCode;
//		}
//		// 0 代表前面补充0     
//		// 13 代表长度为13     
//		// d 代表参数为整数型
		return timeStr + randomNum;
	}

	private int temp = 0;

	private String caculateDate(int minusRes) {
		int[] divs = { 60, 60, 24, 30 };
		String[] units = { "秒", "分钟", "小时", "天", "30天" };
		if (minusRes < 0) {
			return null;
		}
		int res = temp == 4 ? -1 : minusRes / divs[temp];
		if (res > 0) {
			temp++;
			return caculateDate(res);
		}
		return (temp == 4 ? "" : String.valueOf(minusRes)) + units[temp] + "前";
	}

	private String fillEmptyStr(String str, String... exchange) {
		String res = (StringUtils.isEmpty(exchange) || exchange.length == 0) ? "unused" : str;
		return StringUtils.isEmpty(str) ? res : str;
	}
	
	private String fillGoodsDetail(OrderEntity orderEntity) {
		List<OrderGoodsEntity> goodsEntities = orderGoodsService.selectList
				(new EntityWrapper<OrderGoodsEntity>().eq("order_id", orderEntity.getOrderId()));
		//XXX产品-产品属性-产品数量，
		StringBuffer stringBuffer = new StringBuffer();
		goodsEntities.forEach(ge -> {
			String goodsName = ge.getGoodsName();
			String num = ge.getNum();
			int goodsAttrId = ge.getSkuId();
			GoodsAttributeEntity goodsAttributeEntity = goodsAttributeService.selectOne
					(new EntityWrapper<GoodsAttributeEntity>().eq("attr_id", goodsAttrId));
			if(goodsAttributeEntity != null) {
				String attrName = goodsAttributeEntity.getAttrValue() + ":" + goodsAttributeEntity.getAttrValueName();
				stringBuffer.append(goodsName).append("-").append(attrName).append("-").append(num).append(",");
			}
		});
		return stringBuffer.toString();
	}
	
	private boolean sendOrderNotifySMS(String nickName, String uMobile,
			OrderEntity orderEntity) {
		boolean res = false;
		int keyId = orderEntity.getKeyId();
		StarEntity starEntity = starService.selectOne(new EntityWrapper<StarEntity>().eq("star_id", keyId));
		Map<String, String> tplMap = new HashMap<String, String>();
		tplMap.put(SMSConfig.KEY_NICKNAME, nickName);
		tplMap.put(SMSConfig.KEY_MOBILE, uMobile);
		tplMap.put(SMSConfig.KEY_GOODS_DETAIL, fillGoodsDetail(orderEntity));
		res = SMSMessage.mobileQuery(starEntity.getTelNum(), SMSConfig.TPL_ORDER, tplMap);
		return res;
	}
}
