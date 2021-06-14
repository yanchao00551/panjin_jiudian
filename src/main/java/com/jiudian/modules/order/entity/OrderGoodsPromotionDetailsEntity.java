package com.jiudian.modules.order.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 订单商品优惠详情
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-02 15:13:28
 */
@TableName("ns_order_goods_promotion_details")
public class OrderGoodsPromotionDetailsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 订单ID
	 */
	private Integer orderId;
	/**
	 * 商品skuid
	 */
	private Integer skuId;
	/**
	 * 优惠类型规则ID（满减对应规则）
	 */
	private byte[] promotionType;
	/**
	 * 优惠ID
	 */
	private Integer promotionId;
	/**
	 * 优惠的金额，单位：元，精确到小数点后两位
	 */
	private BigDecimal discountMoney;
	/**
	 * 使用时间
	 */
	private Integer usedTime;

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
	 * 设置：商品skuid
	 */
	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}
	/**
	 * 获取：商品skuid
	 */
	public Integer getSkuId() {
		return skuId;
	}
	/**
	 * 设置：优惠类型规则ID（满减对应规则）
	 */
	public void setPromotionType(byte[] promotionType) {
		this.promotionType = promotionType;
	}
	/**
	 * 获取：优惠类型规则ID（满减对应规则）
	 */
	public byte[] getPromotionType() {
		return promotionType;
	}
	/**
	 * 设置：优惠ID
	 */
	public void setPromotionId(Integer promotionId) {
		this.promotionId = promotionId;
	}
	/**
	 * 获取：优惠ID
	 */
	public Integer getPromotionId() {
		return promotionId;
	}
	/**
	 * 设置：优惠的金额，单位：元，精确到小数点后两位
	 */
	public void setDiscountMoney(BigDecimal discountMoney) {
		this.discountMoney = discountMoney;
	}
	/**
	 * 获取：优惠的金额，单位：元，精确到小数点后两位
	 */
	public BigDecimal getDiscountMoney() {
		return discountMoney;
	}
	/**
	 * 设置：使用时间
	 */
	public void setUsedTime(Integer usedTime) {
		this.usedTime = usedTime;
	}
	/**
	 * 获取：使用时间
	 */
	public Integer getUsedTime() {
		return usedTime;
	}
}
