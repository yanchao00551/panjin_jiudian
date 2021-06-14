package com.jiudian.modules.order.controller;

import java.util.ArrayList;
import java.util.List;

import com.jiudian.modules.order.entity.OrderGromType;
import com.jiudian.modules.order.entity.PayStatus;
import com.jiudian.modules.order.entity.PayType;
import com.jiudian.modules.order.entity.ShippingStatus;
import com.jiudian.modules.order.entity.ShippingTypeName;

/**
 * 订单调度类
 * @author Mr.Yan
 *
 */
public class OrderStatus {
	
	/**
	 * 获取订单来源
	 * @param typeId
	 * @return
	 */
	public static OrderGromType getOrderFrom(String typeId){
		List<OrderGromType> list = new ArrayList<OrderGromType>();
		OrderGromType info = new OrderGromType();
		info.setTypeId("1");
		info.setTypeName("微信端");
		info.setTag("fa fa-weixin");
		list.add(info);
		info.setTypeId("2");
		info.setTypeName("手机端");
		info.setTag("fa fa-mobile fa-2x");
		list.add(info);
		info.setTypeId("3");
		info.setTypeName("pc端");
		info.setTag("fa fa-television");
		list.add(info);
		info.setTypeId("4");
		info.setTypeName("微信小程序端");
		info.setTag("fa fa-wechat-applet");
		list.add(info);
		OrderGromType typeName = new OrderGromType();
		for(OrderGromType item:list) {
			if(item.getTypeId().equals(typeId)) {
				typeName = item;
			}
		}
		
		return typeName;
	}

	/**
	 * 获取支付方式
	 * @param paymentType
	 * @return
	 */
	public static String getPayType(Integer paymentType) {
		// TODO Auto-generated method stub
		List<PayType> list = new ArrayList<PayType>();
		PayType info = new PayType();
		info.setTypeId("0");
		info.setTypeName("在线支付");
		list.add(info);
		info.setTypeId("1");
		info.setTypeId("微信支付");
		list.add(info);
		info.setTypeId("2");
		info.setTypeName("支付宝");
		list.add(info);
		info.setTypeId("3");
		info.setTypeName("银联卡");
		list.add(info);
		info.setTypeId("4");
		info.setTypeName("货到付款");
		list.add(info);
		info.setTypeId("5");
		info.setTypeName("余额支付");
		list.add(info);
		info.setTypeId("6");
		info.setTypeName("到店支付");
		list.add(info);
		info.setTypeId("10");
		info.setTypeName("线下支付");
		list.add(info);
		info.setTypeId("11");
		info.setTypeName("积分兑换");
		list.add(info);
		info.setTypeId("12");
		info.setTypeName("砍价");
		
		String 	typeName = null;
		for(PayType item:list) {
			if(item.getTypeId().equals(paymentType)) {
				typeName = item.getTypeName();
			}
		}
		return typeName;
	}

	/**
	 * 获取发货操作状态
	 * @return
	 */
	public static List<ShippingStatus> getShippingStatus() {
		// TODO Auto-generated method stub
		List<ShippingStatus> list = new ArrayList<ShippingStatus>();
		ShippingStatus info = new ShippingStatus();
		info.setShippingStatus("0");
		info.setStatusName("待发货");
		list.add(info);
		info.setShippingStatus("1");
		info.setStatusName("已发货");
		list.add(info);
		info.setShippingStatus("2");
		info.setStatusName("已收货");
		list.add(info);
		info.setShippingStatus("3");
		info.setStatusName("备货中");
		list.add(info);
		info.setShippingStatus("4");
		info.setStatusName("未入住");
		list.add(info);
		info.setShippingStatus("5");
		info.setStatusName("已入住");
		list.add(info);
		return list;
	}

	/**
	 * 获取订单支付操作状态
	 */
	public static List<PayStatus> getPayStatus() {
		// TODO Auto-generated method stub
		List<PayStatus> list = new ArrayList<PayStatus>();
		PayStatus info = new PayStatus();
		info.setPayStatus("0");
		info.setStatusName("待支付");
		list.add(info);
		info.setPayStatus("1");
		info.setStatusName("支付中");
		list.add(info);
		info.setPayStatus("2");
		info.setStatusName("已支付");
		list.add(info);
		return list;
	}

	public static ShippingTypeName getShippingTypeName(Integer shippingType) {
		// TODO Auto-generated method stub
		List<ShippingTypeName> list = new ArrayList<ShippingTypeName>();
		ShippingTypeName info = new ShippingTypeName();
		info.setTypeId("1");
		info.setTypeName("物流配送");
		list.add(info);
		info.setTypeId("2");
		info.setTypeName("买家自提");
		list.add(info);
		info.setTypeId("3");
		info.setTypeName("本地配送");
		list.add(info);
		
		ShippingTypeName typeName = new ShippingTypeName();
		for(ShippingTypeName item:list) {
			if(Integer.parseInt(item.getTypeId()) == shippingType) {
				typeName = item;
			}
		}
		return typeName;
	}
}


