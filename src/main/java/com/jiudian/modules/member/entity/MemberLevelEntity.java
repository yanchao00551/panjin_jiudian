package com.jiudian.modules.member.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 会员等级
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-26 13:10:53
 */
@TableName("ns_member_level")
public class MemberLevelEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 等级ID
	 */
	@TableId
	private Integer levelId;
	/**
	 * 店铺ID
	 */
	private Integer shopId;
	/**
	 * 等级名称
	 */
	private String levelName;
	/**
	 * 累计积分
	 */
	private Integer minIntegral;
	/**
	 * 折扣率
	 */
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
	private Integer relation;

	/**
	 * 设置：等级ID
	 */
	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}
	/**
	 * 获取：等级ID
	 */
	public Integer getLevelId() {
		return levelId;
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
	 * 设置：等级名称
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	/**
	 * 获取：等级名称
	 */
	public String getLevelName() {
		return levelName;
	}
	/**
	 * 设置：累计积分
	 */
	public void setMinIntegral(Integer minIntegral) {
		this.minIntegral = minIntegral;
	}
	/**
	 * 获取：累计积分
	 */
	public Integer getMinIntegral() {
		return minIntegral;
	}
	/**
	 * 设置：折扣率
	 */
	public void setGoodsDiscount(BigDecimal goodsDiscount) {
		this.goodsDiscount = goodsDiscount;
	}
	/**
	 * 获取：折扣率
	 */
	public BigDecimal getGoodsDiscount() {
		return goodsDiscount;
	}
	/**
	 * 设置：等级描述
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * 获取：等级描述
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * 设置：是否是默认
	 */
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	/**
	 * 获取：是否是默认
	 */
	public Integer getIsDefault() {
		return isDefault;
	}
	/**
	 * 设置：消费额度
	 */
	public void setQuota(Integer quota) {
		this.quota = quota;
	}
	/**
	 * 获取：消费额度
	 */
	public Integer getQuota() {
		return quota;
	}
	/**
	 * 设置：升级条件  1.累计积分 2.消费额度 3.同时满足
	 */
	public void setUpgrade(Integer upgrade) {
		this.upgrade = upgrade;
	}
	/**
	 * 获取：升级条件  1.累计积分 2.消费额度 3.同时满足
	 */
	public Integer getUpgrade() {
		return upgrade;
	}
	/**
	 * 设置：1.或 2. 且
	 */
	public void setRelation(Integer relation) {
		this.relation = relation;
	}
	/**
	 * 获取：1.或 2. 且
	 */
	public Integer getRelation() {
		return relation;
	}
}
