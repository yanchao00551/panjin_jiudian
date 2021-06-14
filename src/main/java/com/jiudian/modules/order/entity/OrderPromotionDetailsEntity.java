package com.jiudian.modules.order.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 订单优惠详情
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:37
 */
@TableName("ns_order_promotion_details")
public class OrderPromotionDetailsEntity implements Serializable {
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
	 * 优惠类型规则ID（满减对应规则）
	 */
	private Integer promotionTypeId;
	/**
	 * 优惠ID
	 */
	private Integer promotionId;
	/**
	 * 优惠类型
	 */
	private String promotionType;
	/**
	 * 该优惠活动的名称
	 */
	private String promotionName;
	/**
	 * 优惠使用条件说明
	 */
	private String promotionCondition;
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
	 * 设置：优惠类型规则ID（满减对应规则）
	 */
	public void setPromotionTypeId(Integer promotionTypeId) {
		this.promotionTypeId = promotionTypeId;
	}
	/**
	 * 获取：优惠类型规则ID（满减对应规则）
	 */
	public Integer getPromotionTypeId() {
		return promotionTypeId;
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
	 * 设置：优惠类型
	 */
	public void setPromotionType(String promotionType) {
		this.promotionType = promotionType;
	}
	/**
	 * 获取：优惠类型
	 */
	public String getPromotionType() {
		return promotionType;
	}
	/**
	 * 设置：该优惠活动的名称
	 */
	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}
	/**
	 * 获取：该优惠活动的名称
	 */
	public String getPromotionName() {
		return promotionName;
	}
	/**
	 * 设置：优惠使用条件说明
	 */
	public void setPromotionCondition(String promotionCondition) {
		this.promotionCondition = promotionCondition;
	}
	/**
	 * 获取：优惠使用条件说明
	 */
	public String getPromotionCondition() {
		return promotionCondition;
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
