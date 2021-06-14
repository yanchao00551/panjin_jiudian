package com.jiudian.modules.order.entity;

import java.util.List;

public class GoodsPacketList {
	private String packetName;
	
	private String expressName;
	
	private String expressCode;
	
	private Integer expressId;
	
	private Integer isExpress;
	
	private Integer expressCompanyId;
	
	private List<OrderGoodsEntity> orderGoodsList;

	
	public Integer getExpressCompanyId() {
		return expressCompanyId;
	}

	public void setExpressCompanyId(Integer expressCompanyId) {
		this.expressCompanyId = expressCompanyId;
	}

	public String getPacketName() {
		return packetName;
	}

	public void setPacketName(String packetName) {
		this.packetName = packetName;
	}

	public String getExpressName() {
		return expressName;
	}

	public void setExpressName(String expressName) {
		this.expressName = expressName;
	}

	public String getExpressCode() {
		return expressCode;
	}

	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}

	public Integer getExpressId() {
		return expressId;
	}

	public void setExpressId(Integer expressId) {
		this.expressId = expressId;
	}

	public Integer getIsExpress() {
		return isExpress;
	}

	public void setIsExpress(Integer isExpress) {
		this.isExpress = isExpress;
	}

	public List<OrderGoodsEntity> getOrderGoodsList() {
		return orderGoodsList;
	}

	public void setOrderGoodsList(List<OrderGoodsEntity> orderGoodsList) {
		this.orderGoodsList = orderGoodsList;
	}
	
	
	
}
