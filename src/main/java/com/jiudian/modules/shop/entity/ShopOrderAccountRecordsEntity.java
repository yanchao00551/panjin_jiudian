package com.jiudian.modules.shop.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 店铺针对订单的金额分配
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 13:58:03
 */
@TableName("ns_shop_order_account_records")
public class ShopOrderAccountRecordsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 店铺ID
	 */
	private Integer shopId;
	/**
	 * 订单ID
	 */
	private Integer orderId;
	/**
	 * 订单编号
	 */
	private String orderNo;
	/**
	 * 订单项ID
	 */
	private Integer orderGoodsId;
	/**
	 * 订单项实际支付金额
	 */
	private BigDecimal goodsPayMoney;
	/**
	 * 商品平台佣金比率
	 */
	private BigDecimal rate;
	/**
	 * 店铺获取金额
	 */
	private BigDecimal shopMoney;
	/**
	 * 平台获取金额
	 */
	private BigDecimal platformMoney;
	/**
	 * 是否产生退款
	 */
	private Integer isRefund;
	/**
	 * 实际退款金额
	 */
	private BigDecimal refundMoney;
	/**
	 * 店铺扣减余额
	 */
	private BigDecimal shopRefundMoney;
	/**
	 * 平台扣减余额
	 */
	private BigDecimal platformRefundMoney;
	/**
	 * 是否已经结算
	 */
	private Integer isIssue;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Integer createTime;

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
	 * 设置：店铺ID
	 */
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	/**
	 * 获取：店铺ID
	 */
	public Integer getShopId() {
		return shopId;
	}
	/**
	 * 设置：订单ID
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：订单ID
	 */
	public Integer getOrderId() {
		return orderId;
	}
	/**
	 * 设置：订单编号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：订单编号
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * 设置：订单项ID
	 */
	public void setOrderGoodsId(Integer orderGoodsId) {
		this.orderGoodsId = orderGoodsId;
	}
	/**
	 * 获取：订单项ID
	 */
	public Integer getOrderGoodsId() {
		return orderGoodsId;
	}
	/**
	 * 设置：订单项实际支付金额
	 */
	public void setGoodsPayMoney(BigDecimal goodsPayMoney) {
		this.goodsPayMoney = goodsPayMoney;
	}
	/**
	 * 获取：订单项实际支付金额
	 */
	public BigDecimal getGoodsPayMoney() {
		return goodsPayMoney;
	}
	/**
	 * 设置：商品平台佣金比率
	 */
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	/**
	 * 获取：商品平台佣金比率
	 */
	public BigDecimal getRate() {
		return rate;
	}
	/**
	 * 设置：店铺获取金额
	 */
	public void setShopMoney(BigDecimal shopMoney) {
		this.shopMoney = shopMoney;
	}
	/**
	 * 获取：店铺获取金额
	 */
	public BigDecimal getShopMoney() {
		return shopMoney;
	}
	/**
	 * 设置：平台获取金额
	 */
	public void setPlatformMoney(BigDecimal platformMoney) {
		this.platformMoney = platformMoney;
	}
	/**
	 * 获取：平台获取金额
	 */
	public BigDecimal getPlatformMoney() {
		return platformMoney;
	}
	/**
	 * 设置：是否产生退款
	 */
	public void setIsRefund(Integer isRefund) {
		this.isRefund = isRefund;
	}
	/**
	 * 获取：是否产生退款
	 */
	public Integer getIsRefund() {
		return isRefund;
	}
	/**
	 * 设置：实际退款金额
	 */
	public void setRefundMoney(BigDecimal refundMoney) {
		this.refundMoney = refundMoney;
	}
	/**
	 * 获取：实际退款金额
	 */
	public BigDecimal getRefundMoney() {
		return refundMoney;
	}
	/**
	 * 设置：店铺扣减余额
	 */
	public void setShopRefundMoney(BigDecimal shopRefundMoney) {
		this.shopRefundMoney = shopRefundMoney;
	}
	/**
	 * 获取：店铺扣减余额
	 */
	public BigDecimal getShopRefundMoney() {
		return shopRefundMoney;
	}
	/**
	 * 设置：平台扣减余额
	 */
	public void setPlatformRefundMoney(BigDecimal platformRefundMoney) {
		this.platformRefundMoney = platformRefundMoney;
	}
	/**
	 * 获取：平台扣减余额
	 */
	public BigDecimal getPlatformRefundMoney() {
		return platformRefundMoney;
	}
	/**
	 * 设置：是否已经结算
	 */
	public void setIsIssue(Integer isIssue) {
		this.isIssue = isIssue;
	}
	/**
	 * 获取：是否已经结算
	 */
	public Integer getIsIssue() {
		return isIssue;
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
}
