package com.jiudian.modules.order.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 预售订单表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:37
 */
@TableName("ns_order_presell")
public class OrderPresellEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 订单id
	 */
	@TableId
	private Integer presellOrderId;
	/**
	 * 外部交易号
	 */
	private String outTradeNo;
	/**
	 * 支付类型
	 */
	private Integer paymentType;
	/**
	 * 订单状态 0创建 1尾款待支付 2开始结尾款 
	 */
	private Integer orderStatus;
	/**
	 * 订单付款时间
	 */
	private Integer payTime;
	/**
	 * 订单创建时间
	 */
	private Integer createTime;
	/**
	 * 操作人类型  1店铺  2用户
	 */
	private Integer operatorType;
	/**
	 * 操作人id
	 */
	private Integer operatorId;
	/**
	 * 关联id
	 */
	private Integer relateId;
	/**
	 * 预售结束时间
	 */
	private Integer presellTime;
	/**
	 * 预售金额
	 */
	private BigDecimal presellMoney;
	/**
	 * 预售支付金额
	 */
	private BigDecimal presellPay;
	/**
	 * 平台余额
	 */
	private BigDecimal platformMoney;
	/**
	 * 订单消耗积分
	 */
	private BigDecimal point;
	/**
	 * 订单消耗积分抵多少钱
	 */
	private BigDecimal pointMoney;
	/**
	 * 预售金单价
	 */
	private BigDecimal presellPrice;
	/**
	 * 预售发货形式 1指定时间 2支付后天数
	 */
	private Integer presellDeliveryType;
	/**
	 * 预售发货时间 按形式 
	 */
	private Integer presellDeliveryValue;
	/**
	 * 预售发货具体时间（实则为结尾款时间）
	 */
	private Integer presellDeliveryTime;
	/**
	 * 是否全款预定
	 */
	private Integer isFullPayment;

	/**
	 * 设置：订单id
	 */
	public void setPresellOrderId(Integer presellOrderId) {
		this.presellOrderId = presellOrderId;
	}
	/**
	 * 获取：订单id
	 */
	public Integer getPresellOrderId() {
		return presellOrderId;
	}
	/**
	 * 设置：外部交易号
	 */
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	/**
	 * 获取：外部交易号
	 */
	public String getOutTradeNo() {
		return outTradeNo;
	}
	/**
	 * 设置：支付类型
	 */
	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}
	/**
	 * 获取：支付类型
	 */
	public Integer getPaymentType() {
		return paymentType;
	}
	/**
	 * 设置：订单状态 0创建 1尾款待支付 2开始结尾款 
	 */
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * 获取：订单状态 0创建 1尾款待支付 2开始结尾款 
	 */
	public Integer getOrderStatus() {
		return orderStatus;
	}
	/**
	 * 设置：订单付款时间
	 */
	public void setPayTime(Integer payTime) {
		this.payTime = payTime;
	}
	/**
	 * 获取：订单付款时间
	 */
	public Integer getPayTime() {
		return payTime;
	}
	/**
	 * 设置：订单创建时间
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：订单创建时间
	 */
	public Integer getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：操作人类型  1店铺  2用户
	 */
	public void setOperatorType(Integer operatorType) {
		this.operatorType = operatorType;
	}
	/**
	 * 获取：操作人类型  1店铺  2用户
	 */
	public Integer getOperatorType() {
		return operatorType;
	}
	/**
	 * 设置：操作人id
	 */
	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}
	/**
	 * 获取：操作人id
	 */
	public Integer getOperatorId() {
		return operatorId;
	}
	/**
	 * 设置：关联id
	 */
	public void setRelateId(Integer relateId) {
		this.relateId = relateId;
	}
	/**
	 * 获取：关联id
	 */
	public Integer getRelateId() {
		return relateId;
	}
	/**
	 * 设置：预售结束时间
	 */
	public void setPresellTime(Integer presellTime) {
		this.presellTime = presellTime;
	}
	/**
	 * 获取：预售结束时间
	 */
	public Integer getPresellTime() {
		return presellTime;
	}
	/**
	 * 设置：预售金额
	 */
	public void setPresellMoney(BigDecimal presellMoney) {
		this.presellMoney = presellMoney;
	}
	/**
	 * 获取：预售金额
	 */
	public BigDecimal getPresellMoney() {
		return presellMoney;
	}
	/**
	 * 设置：预售支付金额
	 */
	public void setPresellPay(BigDecimal presellPay) {
		this.presellPay = presellPay;
	}
	/**
	 * 获取：预售支付金额
	 */
	public BigDecimal getPresellPay() {
		return presellPay;
	}
	/**
	 * 设置：平台余额
	 */
	public void setPlatformMoney(BigDecimal platformMoney) {
		this.platformMoney = platformMoney;
	}
	/**
	 * 获取：平台余额
	 */
	public BigDecimal getPlatformMoney() {
		return platformMoney;
	}
	/**
	 * 设置：订单消耗积分
	 */
	public void setPoint(BigDecimal point) {
		this.point = point;
	}
	/**
	 * 获取：订单消耗积分
	 */
	public BigDecimal getPoint() {
		return point;
	}
	/**
	 * 设置：订单消耗积分抵多少钱
	 */
	public void setPointMoney(BigDecimal pointMoney) {
		this.pointMoney = pointMoney;
	}
	/**
	 * 获取：订单消耗积分抵多少钱
	 */
	public BigDecimal getPointMoney() {
		return pointMoney;
	}
	/**
	 * 设置：预售金单价
	 */
	public void setPresellPrice(BigDecimal presellPrice) {
		this.presellPrice = presellPrice;
	}
	/**
	 * 获取：预售金单价
	 */
	public BigDecimal getPresellPrice() {
		return presellPrice;
	}
	/**
	 * 设置：预售发货形式 1指定时间 2支付后天数
	 */
	public void setPresellDeliveryType(Integer presellDeliveryType) {
		this.presellDeliveryType = presellDeliveryType;
	}
	/**
	 * 获取：预售发货形式 1指定时间 2支付后天数
	 */
	public Integer getPresellDeliveryType() {
		return presellDeliveryType;
	}
	/**
	 * 设置：预售发货时间 按形式 
	 */
	public void setPresellDeliveryValue(Integer presellDeliveryValue) {
		this.presellDeliveryValue = presellDeliveryValue;
	}
	/**
	 * 获取：预售发货时间 按形式 
	 */
	public Integer getPresellDeliveryValue() {
		return presellDeliveryValue;
	}
	/**
	 * 设置：预售发货具体时间（实则为结尾款时间）
	 */
	public void setPresellDeliveryTime(Integer presellDeliveryTime) {
		this.presellDeliveryTime = presellDeliveryTime;
	}
	/**
	 * 获取：预售发货具体时间（实则为结尾款时间）
	 */
	public Integer getPresellDeliveryTime() {
		return presellDeliveryTime;
	}
	/**
	 * 设置：是否全款预定
	 */
	public void setIsFullPayment(Integer isFullPayment) {
		this.isFullPayment = isFullPayment;
	}
	/**
	 * 获取：是否全款预定
	 */
	public Integer getIsFullPayment() {
		return isFullPayment;
	}
}
