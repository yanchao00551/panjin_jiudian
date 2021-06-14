package com.jiudian.modules.rewardRecord.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 
 * 
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-10-20 15:45:58
 */
@TableName("ns_reward_record")
public class RewardRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 返润信息ID
	 */
	@TableId
	private Integer rewardId;
	/**
	 * 返润生成账号
	 */
	private Integer fromUid;
	/**
	 * 积分流入账号
	 */
	private Integer toUid;
	/**
	 * 返润积分数
	 */
	private Integer value;
	
	
	@TableField(exist = false)
	private int reward;

	/**
	 * 设置：返润信息ID
	 */
	public void setRewardId(Integer rewardId) {
		this.rewardId = rewardId;
	}
	/**
	 * 获取：返润信息ID
	 */
	public Integer getRewardId() {
		return rewardId;
	}
	/**
	 * 设置：返润生成账号
	 */
	public void setFromUid(Integer fromUid) {
		this.fromUid = fromUid;
	}
	/**
	 * 获取：返润生成账号
	 */
	public Integer getFromUid() {
		return fromUid;
	}
	/**
	 * 设置：积分流入账号
	 */
	public void setToUid(Integer toUid) {
		this.toUid = toUid;
	}
	/**
	 * 获取：积分流入账号
	 */
	public Integer getToUid() {
		return toUid;
	}
	/**
	 * 设置：返润积分数
	 */
	public void setValue(Integer value) {
		this.value = value;
	}
	/**
	 * 获取：返润积分数
	 */
	public Integer getValue() {
		return value;
	}
	public int getReward() {
		return reward;
	}
	public void setReward(int reward) {
		this.reward = reward;
	}
}
