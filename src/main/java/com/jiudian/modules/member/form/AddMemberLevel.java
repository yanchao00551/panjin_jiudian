package com.jiudian.modules.member.form;


import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;


/**
 * 会员等级添加
 * @author KF-180419
 *
 */

public class AddMemberLevel {
	
	/**
	 * 店铺ID
	 */
	@ApiModelProperty(value = "店铺ID")
    @NotNull(message="shopId不能为空")
	private Integer shopId;
	
	/**
	 * 等级名称
	 */
	@ApiModelProperty(value = "等级名称")
    @NotNull(message="levelName不能为空")
	private String levelName;
	
	/**
	 * 累计积分
	 */
	private Integer minIntegral;
	/**
	 * 折扣率
	 */
	@ApiModelProperty(value = "折扣率名称")
    @NotNull(message="折扣率不能为空")
	private BigDecimal goodsDiscount;
	/**
	 * 等级描述
	 */
	private String desc;
	/**
	 * 是否是默认
	 */
	private Integer isDefault;
	/**
	 * 消费额度
	 */
	private Integer quota;
	/**
	 * 升级条件  1.累计积分 2.消费额度 3.同时满足
	 */
	private Integer upgrade;
	
	/**
	 * 1.或 2. 且
	 */
	@ApiModelProperty(value = "且或")
    @NotNull(message="且或不能为空")
	private Integer relation;

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public Integer getMinIntegral() {
		return minIntegral;
	}

	public void setMinIntegral(Integer minIntegral) {
		this.minIntegral = minIntegral;
	}

	public BigDecimal getGoodsDiscount() {
		return goodsDiscount;
	}

	public void setGoodsDiscount(BigDecimal goodsDiscount) {
		this.goodsDiscount = goodsDiscount;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public Integer getQuota() {
		return quota;
	}

	public void setQuota(Integer quota) {
		this.quota = quota;
	}

	public Integer getUpgrade() {
		return upgrade;
	}

	public void setUpgrade(Integer upgrade) {
		this.upgrade = upgrade;
	}

	public Integer getRelation() {
		return relation;
	}

	public void setRelation(Integer relation) {
		this.relation = relation;
	}
	
	
}
