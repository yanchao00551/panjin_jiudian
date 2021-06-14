package com.jiudian.modules.order.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 订单支付表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-02 15:13:28
 */
@TableName("ns_order_payment")
public class OrderPaymentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 支付单编号
	 */
	@TableId
	private String outTradeNo;
	/**
	 * 执行支付的相关店铺ID（0平台）
	 */
	private Integer shopId;
	/**
	 * 订单类型1.商城订单2.交易商支付
	 */
	private Integer type;
	/**
	 * 订单类型关联ID
	 */
	private Integer typeAlisId;
	/**
	 * 订单支付简介
	 */
	private String payBody;
	/**
	 * 订单支付详情
	 */
	private String payDetail;
	/**
	 * 支付金额
	 */
	private BigDecimal payMoney;
	/**
	 * 支付状态
	 */
	private Integer payStatus;
	/**
	 * 支付方式
	 */
	private Integer payType;
	/**
	 * 创建时间
	 */
	private Integer createTime;
	/**
	 * 支付时间
	 */
	private Integer payTime;
	/**
	 * 交易号，支付宝退款用，微信传入空
	 */
	private String tradeNo;

	/**
	 * 设置：支付单编号
	 */
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	/**
	 * 获取：支付单编号
	 */
	public String getOutTradeNo() {
		return outTradeNo;
	}
	/**
	 * 设置：执行支付的相关店铺ID（0平台）
	 */
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	/**
	 * 获取：执行支付的相关店铺ID（0平台）
	 */
	public Integer getShopId() {
		return shopId;
	}
	/**
	 * 设置：订单类型1.商城订单2.交易商支付
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：订单类型1.商城订单2.交易商支付
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：订单类型关联ID
	 */
	public void setTypeAlisId(Integer typeAlisId) {
		this.typeAlisId = typeAlisId;
	}
	/**
	 * 获取：订单类型关联ID
	 */
	public Integer getTypeAlisId() {
		return typeAlisId;
	}
	/**
	 * 设置：订单支付简介
	 */
	public void setPayBody(String payBody) {
		this.payBody = payBody;
	}
	/**
	 * 获取：订单支付简介
	 */
	public String getPayBody() {
		return payBody;
	}
	/**
	 * 设置：订单支付详情
	 */
	public void setPayDetail(String payDetail) {
		this.payDetail = payDetail;
	}
	/**
	 * 获取：订单支付详情
	 */
	public String getPayDetail() {
		return payDetail;
	}
	/**
	 * 设置：支付金额
	 */
	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}
	/**
	 * 获取：支付金额
	 */
	public BigDecimal getPayMoney() {
		return payMoney;
	}
	/**
	 * 设置：支付状态
	 */
	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}
	/**
	 * 获取：支付状态
	 */
	public Integer getPayStatus() {
		return payStatus;
	}
	/**
	 * 设置：支付方式
	 */
	public void setPayType(Integer payType) {
		this.payType = payType;
	}
	/**
	 * 获取：支付方式
	 */
	public Integer getPayType() {
		return payType;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Integer getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：支付时间
	 */
	public void setPayTime(Integer payTime) {
		this.payTime = payTime;
	}
	/**
	 * 获取：支付时间
	 */
	public Integer getPayTime() {
		return payTime;
	}
	/**
	 * 设置：交易号，支付宝退款用，微信传入空
	 */
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	/**
	 * 获取：交易号，支付宝退款用，微信传入空
	 */
	public String getTradeNo() {
		return tradeNo;
	}
}
