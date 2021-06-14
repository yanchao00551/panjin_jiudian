package com.jiudian.modules.order.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 商品订单物流信息表（多次发货）
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-02 15:13:19
 */
@TableName("ns_order_goods_express")
public class OrderGoodsExpressEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 订单id
	 */
	private Integer orderId;
	/**
	 * 订单项商品组合列表
	 */
	private String orderGoodsIdArray;
	/**
	 * 包裹名称  （包裹- 1 包裹 - 2）
	 */
	private String expressName;
	/**
	 * 发货方式1 需要物流 0无需物流
	 */
	private Integer shippingType;
	/**
	 * 快递公司id
	 */
	private Integer expressCompanyId;
	/**
	 * 物流公司名称
	 */
	private String expressCompany;
	/**
	 * 运单编号
	 */
	private String expressNo;
	/**
	 * 用户id
	 */
	private Integer uid;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 备注
	 */
	private String memo;
	/**
	 * 发货时间
	 */
	private Integer shippingTime;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：订单id
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：订单id
	 */
	public Integer getOrderId() {
		return orderId;
	}
	/**
	 * 设置：订单项商品组合列表
	 */
	public void setOrderGoodsIdArray(String orderGoodsIdArray) {
		this.orderGoodsIdArray = orderGoodsIdArray;
	}
	/**
	 * 获取：订单项商品组合列表
	 */
	public String getOrderGoodsIdArray() {
		return orderGoodsIdArray;
	}
	/**
	 * 设置：包裹名称  （包裹- 1 包裹 - 2）
	 */
	public void setExpressName(String expressName) {
		this.expressName = expressName;
	}
	/**
	 * 获取：包裹名称  （包裹- 1 包裹 - 2）
	 */
	public String getExpressName() {
		return expressName;
	}
	/**
	 * 设置：发货方式1 需要物流 0无需物流
	 */
	public void setShippingType(Integer shippingType) {
		this.shippingType = shippingType;
	}
	/**
	 * 获取：发货方式1 需要物流 0无需物流
	 */
	public Integer getShippingType() {
		return shippingType;
	}
	/**
	 * 设置：快递公司id
	 */
	public void setExpressCompanyId(Integer expressCompanyId) {
		this.expressCompanyId = expressCompanyId;
	}
	/**
	 * 获取：快递公司id
	 */
	public Integer getExpressCompanyId() {
		return expressCompanyId;
	}
	/**
	 * 设置：物流公司名称
	 */
	public void setExpressCompany(String expressCompany) {
		this.expressCompany = expressCompany;
	}
	/**
	 * 获取：物流公司名称
	 */
	public String getExpressCompany() {
		return expressCompany;
	}
	/**
	 * 设置：运单编号
	 */
	public void setExpressNo(String expressNo) {
		this.expressNo = expressNo;
	}
	/**
	 * 获取：运单编号
	 */
	public String getExpressNo() {
		return expressNo;
	}
	/**
	 * 设置：用户id
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：用户id
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：用户名
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：用户名
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：备注
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**
	 * 获取：备注
	 */
	public String getMemo() {
		return memo;
	}
	/**
	 * 设置：发货时间
	 */
	public void setShippingTime(Integer shippingTime) {
		this.shippingTime = shippingTime;
	}
	/**
	 * 获取：发货时间
	 */
	public Integer getShippingTime() {
		return shippingTime;
	}
}
