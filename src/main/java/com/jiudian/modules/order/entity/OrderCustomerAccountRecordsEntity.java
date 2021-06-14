package com.jiudian.modules.order.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 订单售后账户记录
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:36
 */
@TableName("ns_order_customer_account_records")
public class OrderCustomerAccountRecordsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Integer id;
	/**
	 * 订单项id
	 */
	private Integer orderGoodsId;
	/**
	 * 退款交易号
	 */
	private String refundTradeNo;
	/**
	 * 退款金额
	 */
	private BigDecimal refundMoney;
	/**
	 * 退款方式（1：微信，2：支付宝，10：线下）
	 */
	private Integer refundWay;
	/**
	 * 买家id
	 */
	private Integer buyerId;
	/**
	 * 退款时间
	 */
	private Integer refundTime;
	/**
	 * 备注
	 */
	private String remark;

	/**
	 * 设置：主键id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：订单项id
	 */
	public void setOrderGoodsId(Integer orderGoodsId) {
		this.orderGoodsId = orderGoodsId;
	}
	/**
	 * 获取：订单项id
	 */
	public Integer getOrderGoodsId() {
		return orderGoodsId;
	}
	/**
	 * 设置：退款交易号
	 */
	public void setRefundTradeNo(String refundTradeNo) {
		this.refundTradeNo = refundTradeNo;
	}
	/**
	 * 获取：退款交易号
	 */
	public String getRefundTradeNo() {
		return refundTradeNo;
	}
	/**
	 * 设置：退款金额
	 */
	public void setRefundMoney(BigDecimal refundMoney) {
		this.refundMoney = refundMoney;
	}
	/**
	 * 获取：退款金额
	 */
	public BigDecimal getRefundMoney() {
		return refundMoney;
	}
	/**
	 * 设置：退款方式（1：微信，2：支付宝，10：线下）
	 */
	public void setRefundWay(Integer refundWay) {
		this.refundWay = refundWay;
	}
	/**
	 * 获取：退款方式（1：微信，2：支付宝，10：线下）
	 */
	public Integer getRefundWay() {
		return refundWay;
	}
	/**
	 * 设置：买家id
	 */
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	/**
	 * 获取：买家id
	 */
	public Integer getBuyerId() {
		return buyerId;
	}
	/**
	 * 设置：退款时间
	 */
	public void setRefundTime(Integer refundTime) {
		this.refundTime = refundTime;
	}
	/**
	 * 获取：退款时间
	 */
	public Integer getRefundTime() {
		return refundTime;
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
