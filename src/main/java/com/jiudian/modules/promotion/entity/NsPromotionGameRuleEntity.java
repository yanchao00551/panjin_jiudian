package com.jiudian.modules.promotion.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 游戏活动规则
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-19 17:14:29
 */
@TableName("ns_promotion_game_rule")
public class NsPromotionGameRuleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 规则id
	 */
	@TableId
	private Integer ruleId;
	/**
	 * 游戏id
	 */
	private Integer gameId;
	/**
	 * 奖品数量
	 */
	private Integer ruleNum;
	/**
	 * 奖励类型1. 积分 2. 优惠券3.红包4.赠品...
	 */
	private Integer type;
	/**
	 * 优惠券类型id
	 */
	private Integer couponTypeId;
	/**
	 * 奖励积分数
	 */
	private Integer points;
	/**
	 * 奖励红包数
	 */
	private BigDecimal hongbao;
	/**
	 * 赠品id
	 */
	private Integer giftId;
	/**
	 * 规则关键字
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Integer createTime;
	/**
	 * 奖励规则等级
	 */
	private String ruleName;
	/**
	 * 奖励的具体的对应信息名称
	 */
	private String typeValue;
	/**
	 * 剩余奖品数量
	 */
	private Integer remainingNumber;
	/**
	 * 中奖概率
	 */
	private Integer prob;
	
	
	/*------- other ------*/
	@TableField(exist = false)
	private String rules;

	
	
	public Integer getProb() {
		return prob;
	}
	public void setProb(Integer prob) {
		this.prob = prob;
	}
	public String getRules() {
		return rules;
	}
	public void setRules(String rules) {
		this.rules = rules;
	}
	/**
	 * 设置：规则id
	 */
	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}
	/**
	 * 获取：规则id
	 */
	public Integer getRuleId() {
		return ruleId;
	}
	/**
	 * 设置：游戏id
	 */
	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}
	/**
	 * 获取：游戏id
	 */
	public Integer getGameId() {
		return gameId;
	}
	/**
	 * 设置：奖品数量
	 */
	public void setRuleNum(Integer ruleNum) {
		this.ruleNum = ruleNum;
	}
	/**
	 * 获取：奖品数量
	 */
	public Integer getRuleNum() {
		return ruleNum;
	}
	/**
	 * 设置：奖励类型1. 积分 2. 优惠券3.红包4.赠品...
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：奖励类型1. 积分 2. 优惠券3.红包4.赠品...
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：优惠券类型id
	 */
	public void setCouponTypeId(Integer couponTypeId) {
		this.couponTypeId = couponTypeId;
	}
	/**
	 * 获取：优惠券类型id
	 */
	public Integer getCouponTypeId() {
		return couponTypeId;
	}
	/**
	 * 设置：奖励积分数
	 */
	public void setPoints(Integer points) {
		this.points = points;
	}
	/**
	 * 获取：奖励积分数
	 */
	public Integer getPoints() {
		return points;
	}
	/**
	 * 设置：奖励红包数
	 */
	public void setHongbao(BigDecimal hongbao) {
		this.hongbao = hongbao;
	}
	/**
	 * 获取：奖励红包数
	 */
	public BigDecimal getHongbao() {
		return hongbao;
	}
	/**
	 * 设置：赠品id
	 */
	public void setGiftId(Integer giftId) {
		this.giftId = giftId;
	}
	/**
	 * 获取：赠品id
	 */
	public Integer getGiftId() {
		return giftId;
	}
	/**
	 * 设置：规则关键字
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：规则关键字
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
	/**
	 * 设置：奖励规则等级
	 */
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	/**
	 * 获取：奖励规则等级
	 */
	public String getRuleName() {
		return ruleName;
	}
	/**
	 * 设置：奖励的具体的对应信息名称
	 */
	public void setTypeValue(String typeValue) {
		this.typeValue = typeValue;
	}
	/**
	 * 获取：奖励的具体的对应信息名称
	 */
	public String getTypeValue() {
		return typeValue;
	}
	/**
	 * 设置：剩余奖品数量
	 */
	public void setRemainingNumber(Integer remainingNumber) {
		this.remainingNumber = remainingNumber;
	}
	/**
	 * 获取：剩余奖品数量
	 */
	public Integer getRemainingNumber() {
		return remainingNumber;
	}
}
