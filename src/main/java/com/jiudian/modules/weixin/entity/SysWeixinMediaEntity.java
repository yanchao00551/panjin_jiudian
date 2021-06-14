package com.jiudian.modules.weixin.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
@TableName("sys_weixin_media")
public class SysWeixinMediaEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 图文消息id
	 */
	@TableId
	private Integer mediaId;
	/**
	 * 
	 */
	private String title;
	/**
	 * 实例id店铺id
	 */
	private Integer instanceId;
	/**
	 * 类型1文本(项表无内容) 2单图文 3多图文
	 */
	private String type;
	/**
	 * 
	 */
	private Integer sort;
	/**
	 * 创建日期
	 */
	private Integer createTime;
	/**
	 * 修改日期
	 */
	private Integer modifyTime;

	/**
	 * 设置：图文消息id
	 */
	public void setMediaId(Integer mediaId) {
		this.mediaId = mediaId;
	}
	/**
	 * 获取：图文消息id
	 */
	public Integer getMediaId() {
		return mediaId;
	}
	/**
	 * 设置：
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：实例id店铺id
	 */
	public void setInstanceId(Integer instanceId) {
		this.instanceId = instanceId;
	}
	/**
	 * 获取：实例id店铺id
	 */
	public Integer getInstanceId() {
		return instanceId;
	}
	/**
	 * 设置：类型1文本(项表无内容) 2单图文 3多图文
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型1文本(项表无内容) 2单图文 3多图文
	 */
	public String getType() {
		return type;
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
	 * 设置：创建日期
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建日期
	 */
	public Integer getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：修改日期
	 */
	public void setModifyTime(Integer modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：修改日期
	 */
	public Integer getModifyTime() {
		return modifyTime;
	}
}
