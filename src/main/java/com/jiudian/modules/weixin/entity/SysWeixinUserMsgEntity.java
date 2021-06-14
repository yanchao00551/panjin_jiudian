package com.jiudian.modules.weixin.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 微信用户消息表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
@TableName("sys_weixin_user_msg")
public class SysWeixinUserMsgEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer msgId;
	/**
	 * 
	 */
	private Integer uid;
	/**
	 * 
	 */
	private String msgType;
	/**
	 * 
	 */
	private String content;
	/**
	 * 是否回复
	 */
	private Integer isReplay;
	/**
	 * 
	 */
	private Integer createTime;
	/**
	 * 粉丝openid
	 */
	private String openid;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 头像
	 */
	private String headimgurl;

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
	 * 设置：
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：
	 */
	public void setMsgType(String msgType) {
		this.msgType = msgType;
	}
	/**
	 * 获取：
	 */
	public String getMsgType() {
		return msgType;
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
	 * 设置：是否回复
	 */
	public void setIsReplay(Integer isReplay) {
		this.isReplay = isReplay;
	}
	/**
	 * 获取：是否回复
	 */
	public Integer getIsReplay() {
		return isReplay;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Integer getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：粉丝openid
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	/**
	 * 获取：粉丝openid
	 */
	public String getOpenid() {
		return openid;
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
	/**
	 * 设置：头像
	 */
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	/**
	 * 获取：头像
	 */
	public String getHeadimgurl() {
		return headimgurl;
	}
}
