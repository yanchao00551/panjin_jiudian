package com.jiudian.modules.order.form;


public class OrderDeliveryForm {
	private Integer orderId;
	
	private String orderGoodsIdArray;
	
	private String expressName;
	
	private Integer shippingType;
	
	private Integer expressCompanyId;
	
	private String expressNo;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderGoodsIdArray() {
		return orderGoodsIdArray;
	}

	public void setOrderGoodsIdArray(String orderGoodsIdArray) {
		this.orderGoodsIdArray = orderGoodsIdArray;
	}

	public String getExpressName() {
		return expressName;
	}

	public void setExpressName(String expressName) {
		this.expressName = expressName;
	}

	public Integer getShippingType() {
		return shippingType;
	}

	public void setShippingType(Integer shippingType) {
		this.shippingType = shippingType;
	}

	public Integer getExpressCompanyId() {
		return expressCompanyId;
	}

	public void setExpressCompanyId(Integer expressCompanyId) {
		this.expressCompanyId = expressCompanyId;
	}

	public String getExpressNo() {
		return expressNo;
	}

	public void setExpressNo(String expressNo) {
		this.expressNo = expressNo;
	}
	
	
}
