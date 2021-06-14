package com.jiudian.modules.order.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * o2o订单配送
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:47
 */
@TableName("ns_o2o_order_delivery")
public class O2oOrderDeliveryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 订单编号
	 */
	private String expressNo;
	/**
	 * 订单id
	 */
	private Integer orderId;
	/**
	 * 配送人员id
	 */
	private Integer orderDeliveryUserId;
	/**
	 * 配送人员姓名
	 */
	private String orderDeliveryUserName;
	/**
	 * 配送人员电话
	 */
	private String orderDeliveryUserMobile;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 备注
	 */
	private String remark;

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
	 * 设置：订单编号
	 */
	public void setExpressNo(String expressNo) {
		this.expressNo = expressNo;
	}
	/**
	 * 获取：订单编号
	 */
	public String getExpressNo() {
		return expressNo;
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
	 * 设置：配送人员id
	 */
	public void setOrderDeliveryUserId(Integer orderDeliveryUserId) {
		this.orderDeliveryUserId = orderDeliveryUserId;
	}
	/**
	 * 获取：配送人员id
	 */
	public Integer getOrderDeliveryUserId() {
		return orderDeliveryUserId;
	}
	/**
	 * 设置：配送人员姓名
	 */
	public void setOrderDeliveryUserName(String orderDeliveryUserName) {
		this.orderDeliveryUserName = orderDeliveryUserName;
	}
	/**
	 * 获取：配送人员姓名
	 */
	public String getOrderDeliveryUserName() {
		return orderDeliveryUserName;
	}
	/**
	 * 设置：配送人员电话
	 */
	public void setOrderDeliveryUserMobile(String orderDeliveryUserMobile) {
		this.orderDeliveryUserMobile = orderDeliveryUserMobile;
	}
	/**
	 * 获取：配送人员电话
	 */
	public String getOrderDeliveryUserMobile() {
		return orderDeliveryUserMobile;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
}
