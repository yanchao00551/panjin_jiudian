package com.jiudian.modules.weixin.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 微信用户消息回复表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
@TableName("sys_weixin_user_msg_replay")
public class SysWeixinUserMsgReplayEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer replayId;
	/**
	 * 
	 */
	private Integer msgId;
	/**
	 * 当前客服uid
	 */
	private Integer replayUid;
	/**
	 * 
	 */
	private String replayType;
	/**
	 * 
	 */
	private String content;
	/**
	 * 
	 */
	private Integer replayTime;
	/**
	 * 昵称
	 */
	private String nickname;

	/**
	 * 设置：
	 */
	public void setReplayId(Integer replayId) {
		this.replayId = replayId;
	}
	/**
	 * 获取：
	 */
	public Integer getReplayId() {
		return replayId;
	}
	/**
	 * 设置：
	 */
	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}
	/**
	 * 获取：
	 */
	public Integer getMsgId() {
		return msgId;
	}
	/**
	 * 设置：当前客服uid
	 */
	public void setReplayUid(Integer replayUid) {
		this.replayUid = replayUid;
	}
	/**
	 * 获取：当前客服uid
	 */
	public Integer getReplayUid() {
		return replayUid;
	}
	/**
	 * 设置：
	 */
	public void setReplayType(String replayType) {
		this.replayType = replayType;
	}
	/**
	 * 获取：
	 */
	public String getReplayType() {
		return replayType;
	}
	/**
	 * 设置：
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：
	 */
	public void setReplayTime(Integer replayTime) {
		this.replayTime = replayTime;
	}
	/**
	 * 获取：
	 */
	public Integer getReplayTime() {
		return replayTime;
	}
	/**
	 * 设置：昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：昵称
	 */
	public String getNickname() {
		return nickname;
	}
}
