package com.jiudian.modules.promotion.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 获奖记录
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-19 17:14:29
 */
@TableName("ns_promotion_games_winning_records")
public class NsPromotionGamesWinningRecordsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 会员id
	 */
	private String uid;
	/**
	 * 店铺id
	 */
	private Integer shopId;
	/**
	 * 是否使用
	 */
	private Integer isUse;
	/**
	 * 活动id
	 */
	private Integer gameId;
	/**
	 * 游戏类型1.大转盘2.刮刮乐3.九宫格
	 */
	private Integer gameType;
	/**
	 * 奖励类型1.积分2.优惠券3.红包4.赠品...
	 */
	private Integer type;
	/**
	 * 奖励积分
	 */
	private BigDecimal points;
	/**
	 * 红包数（余额）
	 */
	private BigDecimal hongbao;
	/**
	 * 奖励优惠券
	 */
	private Integer couponId;
	/**
	 * 赠品id
	 */
	private Integer giftId;
	/**
	 * 说明
	 */
	private String remark;
	/**
	 * 该次是否中奖 0未中奖  1中奖
	 */
	private Integer isWinning;
	/**
	 * 会员昵称
	 */
	private String nickName;
	/**
	 * 添加时间
	 */
	private Integer addTime;
	/**
	 * 奖项id
	 */
	private Integer ruleId;
	/**
	 * 关联赠品记录id
	 */
	private Integer associatedGiftRecordId;

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
	 * 设置：会员id
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * 获取：会员id
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * 设置：店铺id
	 */
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	/**
	 * 获取：店铺id
	 */
	public Integer getShopId() {
		return shopId;
	}
	/**
	 * 设置：是否使用
	 */
	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}
	/**
	 * 获取：是否使用
	 */
	public Integer getIsUse() {
		return isUse;
	}
	/**
	 * 设置：活动id
	 */
	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}
	/**
	 * 获取：活动id
	 */
	public Integer getGameId() {
		return gameId;
	}
	/**
	 * 设置：游戏类型1.大转盘2.刮刮乐3.九宫格
	 */
	public void setGameType(Integer gameType) {
		this.gameType = gameType;
	}
	/**
	 * 获取：游戏类型1.大转盘2.刮刮乐3.九宫格
	 */
	public Integer getGameType() {
		return gameType;
	}
	/**
	 * 设置：奖励类型1.积分2.优惠券3.红包4.赠品...
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：奖励类型1.积分2.优惠券3.红包4.赠品...
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：奖励积分
	 */
	public void setPoints(BigDecimal points) {
		this.points = points;
	}
	/**
	 * 获取：奖励积分
	 */
	public BigDecimal getPoints() {
		return points;
	}
	/**
	 * 设置：红包数（余额）
	 */
	public void setHongbao(BigDecimal hongbao) {
		this.hongbao = hongbao;
	}
	/**
	 * 获取：红包数（余额）
	 */
	public BigDecimal getHongbao() {
		return hongbao;
	}
	/**
	 * 设置：奖励优惠券
	 */
	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}
	/**
	 * 获取：奖励优惠券
	 */
	public Integer getCouponId() {
		return couponId;
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
	 * 设置：说明
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：说明
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：该次是否中奖 0未中奖  1中奖
	 */
	public void setIsWinning(Integer isWinning) {
		this.isWinning = isWinning;
	}
	/**
	 * 获取：该次是否中奖 0未中奖  1中奖
	 */
	public Integer getIsWinning() {
		return isWinning;
	}
	/**
	 * 设置：会员昵称
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * 获取：会员昵称
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * 设置：添加时间
	 */
	public void setAddTime(Integer addTime) {
		this.addTime = addTime;
	}
	/**
	 * 获取：添加时间
	 */
	public Integer getAddTime() {
		return addTime;
	}
	/**
	 * 设置：奖项id
	 */
	public void setRuleId(Integer ruleId) {
		this.ruleId = ruleId;
	}
	/**
	 * 获取：奖项id
	 */
	public Integer getRuleId() {
		return ruleId;
	}
	/**
	 * 设置：关联赠品记录id
	 */
	public void setAssociatedGiftRecordId(Integer associatedGiftRecordId) {
		this.associatedGiftRecordId = associatedGiftRecordId;
	}
	/**
	 * 获取：关联赠品记录id
	 */
	public Integer getAssociatedGiftRecordId() {
		return associatedGiftRecordId;
	}
}
