package com.jiudian.modules.weixin.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 关注时回复
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:23:07
 */
@TableName("sys_weixin_follow_replay")
public class SysWeixinFollowReplayEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 店铺id
	 */
	private Integer instanceId;
	/**
	 * 回复媒体内容id
	 */
	private Integer replyMediaId;
	/**
	 * 
	 */
	private Integer sort;
	/**
	 * 
	 */
	private Integer createTime;
	/**
	 * 
	 */
	private Integer modifyTime;

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
	 * 设置：店铺id
	 */
	public void setInstanceId(Integer instanceId) {
		this.instanceId = instanceId;
	}
	/**
	 * 获取：店铺id
	 */
	public Integer getInstanceId() {
		return instanceId;
	}
	/**
	 * 设置：回复媒体内容id
	 */
	public void setReplyMediaId(Integer replyMediaId) {
		this.replyMediaId = replyMediaId;
	}
	/**
	 * 获取：回复媒体内容id
	 */
	public Integer getReplyMediaId() {
		return replyMediaId;
	}
	/**
	 * 设置：
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：
	 */
	public Integer getSort() {
		return sort;
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
	 * 设置：
	 */
	public void setModifyTime(Integer modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：
	 */
	public Integer getModifyTime() {
		return modifyTime;
	}
}
