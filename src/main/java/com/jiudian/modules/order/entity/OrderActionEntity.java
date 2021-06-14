package com.jiudian.modules.order.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 订单操作表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:35
 */
@TableName("ns_order_action")
public class OrderActionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 动作id
	 */
	@TableId
	private Integer actionId;
	/**
	 * 订单id
	 */
	private Integer orderId;
	/**
	 * 动作内容
	 */
	private String action;
	/**
	 * 操作人id
	 */
	private Integer uid;
	/**
	 * 操作人
	 */
	private String userName;
	/**
	 * 订单大状态
	 */
	private Integer orderStatus;
	/**
	 * 订单状态名称
	 */
	private String orderStatusText;
	/**
	 * 操作时间
	 */
	private Integer actionTime;

	/**
	 * 设置：动作id
	 */
	public void setActionId(Integer actionId) {
		this.actionId = actionId;
	}
	/**
	 * 获取：动作id
	 */
	public Integer getActionId() {
		return actionId;
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
	 * 设置：动作内容
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * 获取：动作内容
	 */
	public String getAction() {
		return action;
	}
	/**
	 * 设置：操作人id
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：操作人id
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：操作人
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：操作人
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：订单大状态
	 */
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * 获取：订单大状态
	 */
	public Integer getOrderStatus() {
		return orderStatus;
	}
	/**
	 * 设置：订单状态名称
	 */
	public void setOrderStatusText(String orderStatusText) {
		this.orderStatusText = orderStatusText;
	}
	/**
	 * 获取：订单状态名称
	 */
	public String getOrderStatusText() {
		return orderStatusText;
	}
	/**
	 * 设置：操作时间
	 */
	public void setActionTime(Integer actionTime) {
		this.actionTime = actionTime;
	}
	/**
	 * 获取：操作时间
	 */
	public Integer getActionTime() {
		return actionTime;
	}
}
