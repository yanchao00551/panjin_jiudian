package com.jiudian.modules.promotion.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 营销游戏（概率游戏）
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-19 17:14:29
 */
@TableName("ns_promotion_games")
public class NsPromotionGamesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 游戏id
	 */
	@TableId
	private Integer gameId;
	/**
	 * 店铺id
	 */
	private Integer shopId;
	/**
	 * 游戏活动名称
	 */
	private String name;
	/**
	 * 游戏类型
	 */
	private Integer gameType;
	/**
	 * 参与的会员等级0表示全部参与
	 */
	private String memberLevel;
	/**
	 * 参与活动会员名称
	 */
	private String levelName;
	/**
	 * 参与一次扣除积分
	 */
	private Integer points;
	/**
	 * 活动开始时间
	 */
	private Integer startTime;
	/**
	 * 活动结束时间
	 */
	private Integer endTime;
	/**
	 * 活动状态 0未开始 1已开始 -1已结束 -2已关闭
	 */
	private Integer status;
	/**
	 * 活动说明
	 */
	private String remark;
	/**
	 * 中奖率
	 */
	private BigDecimal winningRate;
	/**
	 * 未中奖说明
	 */
	private String noWinningDes;
	/**
	 * 活动图片，只有上传了活动图，才会在首页显示
	 */
	private String activityImages;
	/**
	 * 中奖名单是否显示 0不显示 1显示
	 */
	private Integer winningListDisplay;
	/**
	 * 参加类型 0 次/活动全过程 1 次/每天
	 */
	private Integer joinType;
	/**
	 * 根据类型计算参加次数
	 */
	private Integer joinFrequency;
	/**
	 * 中奖类型 0 次/活动全过程 1 次/每天
	 */
	private Integer winningType;
	/**
	 * 根据类型计算中奖最大限制
	 */
	private Integer winningMax;

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
	 * 设置：游戏活动名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：游戏活动名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：游戏类型
	 */
	public void setGameType(Integer gameType) {
		this.gameType = gameType;
	}
	/**
	 * 获取：游戏类型
	 */
	public Integer getGameType() {
		return gameType;
	}
	/**
	 * 设置：参与的会员等级0表示全部参与
	 */
	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}
	/**
	 * 获取：参与的会员等级0表示全部参与
	 */
	public String getMemberLevel() {
		return memberLevel;
	}
	/**
	 * 设置：参与活动会员名称
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	/**
	 * 获取：参与活动会员名称
	 */
	public String getLevelName() {
		return levelName;
	}
	/**
	 * 设置：参与一次扣除积分
	 */
	public void setPoints(Integer points) {
		this.points = points;
	}
	/**
	 * 获取：参与一次扣除积分
	 */
	public Integer getPoints() {
		return points;
	}
	/**
	 * 设置：活动开始时间
	 */
	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}
	/**
	 * 获取：活动开始时间
	 */
	public Integer getStartTime() {
		return startTime;
	}
	/**
	 * 设置：活动结束时间
	 */
	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}
	/**
	 * 获取：活动结束时间
	 */
	public Integer getEndTime() {
		return endTime;
	}
	/**
	 * 设置：活动状态 0未开始 1已开始 -1已结束 -2已关闭
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：活动状态 0未开始 1已开始 -1已结束 -2已关闭
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：活动说明
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：活动说明
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：中奖率
	 */
	public void setWinningRate(BigDecimal winningRate) {
		this.winningRate = winningRate;
	}
	/**
	 * 获取：中奖率
	 */
	public BigDecimal getWinningRate() {
		return winningRate;
	}
	/**
	 * 设置：未中奖说明
	 */
	public void setNoWinningDes(String noWinningDes) {
		this.noWinningDes = noWinningDes;
	}
	/**
	 * 获取：未中奖说明
	 */
	public String getNoWinningDes() {
		return noWinningDes;
	}
	/**
	 * 设置：活动图片，只有上传了活动图，才会在首页显示
	 */
	public void setActivityImages(String activityImages) {
		this.activityImages = activityImages;
	}
	/**
	 * 获取：活动图片，只有上传了活动图，才会在首页显示
	 */
	public String getActivityImages() {
		return activityImages;
	}
	/**
	 * 设置：中奖名单是否显示 0不显示 1显示
	 */
	public void setWinningListDisplay(Integer winningListDisplay) {
		this.winningListDisplay = winningListDisplay;
	}
	/**
	 * 获取：中奖名单是否显示 0不显示 1显示
	 */
	public Integer getWinningListDisplay() {
		return winningListDisplay;
	}
	/**
	 * 设置：参加类型 0 次/活动全过程 1 次/每天
	 */
	public void setJoinType(Integer joinType) {
		this.joinType = joinType;
	}
	/**
	 * 获取：参加类型 0 次/活动全过程 1 次/每天
	 */
	public Integer getJoinType() {
		return joinType;
	}
	/**
	 * 设置：根据类型计算参加次数
	 */
	public void setJoinFrequency(Integer joinFrequency) {
		this.joinFrequency = joinFrequency;
	}
	/**
	 * 获取：根据类型计算参加次数
	 */
	public Integer getJoinFrequency() {
		return joinFrequency;
	}
	/**
	 * 设置：中奖类型 0 次/活动全过程 1 次/每天
	 */
	public void setWinningType(Integer winningType) {
		this.winningType = winningType;
	}
	/**
	 * 获取：中奖类型 0 次/活动全过程 1 次/每天
	 */
	public Integer getWinningType() {
		return winningType;
	}
	/**
	 * 设置：根据类型计算中奖最大限制
	 */
	public void setWinningMax(Integer winningMax) {
		this.winningMax = winningMax;
	}
	/**
	 * 获取：根据类型计算中奖最大限制
	 */
	public Integer getWinningMax() {
		return winningMax;
	}
}
