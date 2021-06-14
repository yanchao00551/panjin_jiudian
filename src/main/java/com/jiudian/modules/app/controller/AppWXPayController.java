package com.jiudian.modules.app.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jiudian.common.utils.IPUtils;
import com.jiudian.common.utils.R;
import com.jiudian.common.wxsdk.WXPay;
import com.jiudian.common.wxsdk.WXPayConstants.SignType;
import com.jiudian.common.wxsdk.WXPayUtil;
import com.jiudian.modules.app.annotation.Login;
import com.jiudian.modules.app.calculate.RewardCaculationManager;
import com.jiudian.modules.app.config.PayConfig;
import com.jiudian.modules.app.config.WXConfig;
import com.jiudian.modules.balance.entity.BalanceCofigEntity;
import com.jiudian.modules.balance.service.BalanceCofigService;
import com.jiudian.modules.order.entity.OrderEntity;
import com.jiudian.modules.order.entity.OrderGoodsEntity;
import com.jiudian.modules.order.service.OrderGoodsService;
import com.jiudian.modules.order.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/app/wxpay")
@Api("微信支付接口")
public class AppWXPayController {
	
	@Autowired
	private RewardCaculationManager rewardCaculationManager;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderGoodsService orderGoodsService;
	
	@Autowired
	private BalanceCofigService balanceCofigService;
	
	/**
	 * 支付宝订单结算统一下单接口
	 * @param userId
	 * @param param
	 * @return
	 */
	@Login
	@GetMapping("wxOrderPrePay")
	@ApiOperation("统一下单(酒店)")
	public R wxOrderPrePay(@RequestAttribute("userId") Integer userId, @RequestParam Map<String, String> param,
			HttpServletRequest request) {
		String orderId = param.get("orderId");
		String usePt = param.get("usePoint");
		int usePoint = 0;
		try {
			usePoint = Integer.parseInt(usePt);
		} catch (NumberFormatException e) {
			return R.error("积分格式输入错误，支付失败！");
		}
		OrderEntity orderEntity = orderService.selectOne(new EntityWrapper<OrderEntity>().eq("order_id", orderId));
		int curr = (int) (System.currentTimeMillis() / 1000);
		if(curr - orderEntity.getCreateTime() > 30 * 60 ) {
			orderEntity.setOrderStatus(5);
			orderService.insertOrUpdate(orderEntity);
			return R.error("订单已过期，无法支付");
		}
		if(orderEntity == null || StringUtils.isEmpty(orderEntity.getOrderNo()) ||
				orderEntity.getOrderMoney() == null || orderEntity.getOrderMoney().compareTo(new BigDecimal(0)) <= 0 ) {
			return R.error("下单失败！请联系管理员");
		}
		Map<String, String> params = new HashMap<>();
		params.put("orderId", orderId);
		List<OrderGoodsEntity> orderGoodsEntities = orderGoodsService.queryOrderGoodsInfo(params);
		int downCount = orderGoodsEntities.stream().filter(oge -> oge.getState() == 0).mapToInt(oge -> 1).sum();
		if(downCount > 0) {
			return R.error("订单包含已下架商品，支付失败！");
		}
		if(orderGoodsEntities == null || orderGoodsEntities.size() == 0) {
			return R.error("订单没有商品，下单失败！请联系管理员");
		}
		Long maxUse = 0l;
		for (OrderGoodsEntity oge : orderGoodsEntities) {
			maxUse += oge.getMaxUsePoint();
		}
		if(new BigDecimal(usePt).compareTo(new BigDecimal(maxUse)) > 0) {
			return R.error("使用积分数大于最大可用积分，支付失败！");
		}
		orderEntity.setPoint(usePoint);
		orderService.insertOrUpdate(orderEntity);
		Map<String, String> map = new HashMap<String, String>();
		map.put("goodsName",PayConfig.COMMON_GOODS_NAME);
		map.put("orderNo", orderEntity.getOrderNo());
		map.put("totalFee", orderEntity.getOrderMoney().toString());
		return wxPrePay(userId, map, request, usePoint);
	}
	
	@Login
	@GetMapping("wxRechargePrePay")
	@ApiOperation("统一下单(充值)")
	public R wxRechargePrePay(@RequestAttribute("userId") Integer userId, @RequestParam Map<String, String> param,
			HttpServletRequest request) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmmss");
		String timeStr = simpleDateFormat.format(Calendar.getInstance().getTime());
		String money = param.get("money");
		try {
			Double.parseDouble(money);
		} catch (Exception e) {
			e.printStackTrace();
			return R.error("充值数额输入异常，无法进行充值！");
		}
		if(Double.parseDouble(money) < 100d)
		{
			return R.error("充值数额最小为100元");
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("goodsName",PayConfig.RECHARGE_GOODS_NAME);
		map.put("orderNo", PayConfig.RECHARGE_TEXT + timeStr);
		map.put("totalFee", money);
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setBuyerId(userId);
		orderEntity.setOrderMoney(new BigDecimal(money));
		orderEntity.setOrderNo(map.get("orderNo"));
		orderEntity.setOrderType(3); //充值订单
		orderEntity.setOrderStatus(0);
		orderEntity.setReceiverProvince(0);
		orderEntity.setReceiverCity(0);
		orderEntity.setReceiverDistrict(0);
		orderEntity.setShopId(0);
		orderEntity.setGoodsMoney(new BigDecimal(0));
		orderEntity.setPoint(0);
		orderEntity.setPointMoney(new BigDecimal(0));
		orderEntity.setCouponMoney(new BigDecimal(0));
		orderEntity.setPromotionMoney(new BigDecimal(0));
		orderEntity.setShippingMoney(new BigDecimal(0));
		orderEntity.setPayMoney(new BigDecimal(0));
		orderEntity.setRefundMoney(new BigDecimal(0));
		orderEntity.setPayStatus(0);
		orderEntity.setShippingStatus(0);
		orderEntity.setGivePoint(0);
		orderEntity.setCouponId(0);
		orderEntity.setReviewStatus(0);
		orderEntity.setFeedbackStatus(0);
		orderService.insert(orderEntity);
		return wxPrePay(userId, map, request, 0);
	}

//	@Login
//	@GetMapping("wxPrePay")
//	@ApiOperation("统一下单")
	public R wxPrePay(@RequestAttribute("userId") Integer userId, @RequestParam Map<String, String> param,
			HttpServletRequest request, int usePoint) {
		String goodsName = param.get("goodsName"); // 商品名称
		String createIp = IPUtils.getIpAddr(request); // 终端IP
		String orderNo = param.get("orderNo"); // 订单号
		String totalFee = param.get("totalFee"); // 支付金额
		BigDecimal fee = new BigDecimal(0);
		try {
			fee = new BigDecimal(totalFee);
		} catch (NumberFormatException e) {
			return R.error("订单价格异常，支付失败！");
		}
		BalanceCofigEntity balanceConfigInfo = balanceCofigService.selectById(1);
		if (balanceConfigInfo == null || balanceConfigInfo.getConvertRate().compareTo(new BigDecimal(0)) == 0) {
			return R.error("系统当前未设置余额兑换积分比例，支付失败！");
		}
		fee = fee.add(new BigDecimal(usePoint).divide(balanceConfigInfo.getConvertRate()).negate());
		Map<String, String> data = new HashMap<String, String>();
		Map<String, String> resMap = new HashMap<String, String>();
		try {
			WXConfig config = new WXConfig();
			WXPay wxpay = new WXPay(config,true,false);
			data.put("body", PayConfig.PREFIX + goodsName);
			data.put("out_trade_no", orderNo);
			data.put("device_info", "WEB");
			data.put("fee_type", "CNY");
			data.put("total_fee", String.valueOf(fee.multiply(new BigDecimal(100).setScale(0)).intValue()));
			data.put("spbill_create_ip", createIp);
			data.put("notify_url", WXConfig.NOTIFY_URL);
			data.put("trade_type", "APP"); // APP支付
//			data.put("product_id", "12");
			Map<String, String> resp = wxpay.unifiedOrder(data);
//			Iterator<String> iterator = resp.keySet().iterator();
//			while(iterator.hasNext()) {
//				String key = iterator.next();
//				System.out.println("微信支付notify，key: " + key + " value: " + resp.get(key));
//			}
			resMap.put("appid", config.getAppID());
			resMap.put("partnerid", config.getMchID());
			resMap.put("prepayid", resp.get("prepay_id"));
			resMap.put("package", "Sign=WXPay");
			resMap.put("noncestr", WXPayUtil.generateNonceStr());
			// 本来生成的时间戳是13位，但是ios必须是10位，所以截取了一下
			resMap.put("timestamp", String.valueOf(System.currentTimeMillis()).toString().substring(0, 10));
			resMap.put("sign", WXPayUtil.generateSignature(resMap, config.getKey(), SignType.MD5));
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(JSON.toJSON(resMap).toString());
		return R.ok().put("data", resMap);
	}

	@RequestMapping("notify")
	@ApiOperation("支付结果通知")
	public String wxNotify(HttpServletRequest request, HttpServletResponse response) {
		BufferedReader bufferedReader = null;
		InputStream inputStream = null;
		try {
			StringBuffer stringBuffer = new StringBuffer();
			inputStream = request.getInputStream();
			String temp;
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			while ((temp = bufferedReader.readLine()) != null) {
				stringBuffer.append(temp);
			}
			String notifyData = stringBuffer.toString(); // 支付结果通知的xml格式数据
			WXConfig config = new WXConfig();
			WXPay wxpay = new WXPay(config);
			Map<String, String> notifyMap = WXPayUtil.xmlToMap(notifyData); // 转换成map
//			Iterator<String> iterator = notifyMap.keySet().iterator();
//			while (iterator.hasNext()) {
//				String key = iterator.next();
//				System.out.println("微信支付notify，key: " + key + " value: " + notifyMap.get(key));
//			}
			// 签名验证
			if (wxpay.isPayResultNotifySignatureValid(notifyMap)) {
				// 签名正确
				// 进行处理。
				// 注意特殊情况：订单已经退款，但收到了支付结果成功的通知，不应把商户侧订单状态从退款改成支付成功
				String orderNo = notifyMap.get("out_trade_no");
				String cost = notifyMap.get("total_fee");
				BigDecimal costDecimal = new BigDecimal(cost);
				cost = String.valueOf(costDecimal.divide(new BigDecimal(100)).doubleValue());
				if(orderNo.startsWith(PayConfig.RECHARGE_TEXT)) {
					rewardCaculationManager.updateRecordByRecharge(orderNo, cost);
				}else {
					rewardCaculationManager.updateRecordByHotel(orderNo, cost, "微信");
					rewardCaculationManager.calcuPush(orderNo, Double.parseDouble(cost), true);
				}
			} else {
				// 签名错误，如果数据里没有sign字段，也认为是签名错误
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "success";
	}

}
