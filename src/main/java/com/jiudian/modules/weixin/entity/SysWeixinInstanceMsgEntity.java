package com.jiudian.modules.weixin.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 微信实例消息
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
@TableName("sys_weixin_instance_msg")
public class SysWeixinInstanceMsgEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer id;
	/**
	 * 店铺id（单店版为0）
	 */
	private Integer instanceId;
	/**
	 * 模版编号
	 */
	private String templateNo;
	/**
	 * 微信模板消息的ID
	 */
	private byte[] templateId;
	/**
	 * 模版标题
	 */
	private String title;
	/**
	 * 是否启用
	 */
	private Boolean isEnable;
	/**
	 * 头部文字
	 */
	private String headtext;
	/**
	 * 底部文字
	 */
	private String bottomtext;

	/**
	 * 设置：主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：店铺id（单店版为0）
	 */
	public void setInstanceId(Integer instanceId) {
		this.instanceId = instanceId;
	}
	/**
	 * 获取：店铺id（单店版为0）
	 */
	public Integer getInstanceId() {
		return instanceId;
	}
	/**
	 * 设置：模版编号
	 */
	public void setTemplateNo(String templateNo) {
		this.templateNo = templateNo;
	}
	/**
	 * 获取：模版编号
	 */
	public String getTemplateNo() {
		return templateNo;
	}
	/**
	 * 设置：微信模板消息的ID
	 */
	public void setTemplateId(byte[] templateId) {
		this.templateId = templateId;
	}
	/**
	 * 获取：微信模板消息的ID
	 */
	public byte[] getTemplateId() {
		return templateId;
	}
	/**
	 * 设置：模版标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：模版标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：是否启用
	 */
	public void setIsEnable(Boolean isEnable) {
		this.isEnable = isEnable;
	}
	/**
	 * 获取：是否启用
	 */
	public Boolean getIsEnable() {
		return isEnable;
	}
	/**
	 * 设置：头部文字
	 */
	public void setHeadtext(String headtext) {
		this.headtext = headtext;
	}
	/**
	 * 获取：头部文字
	 */
	public String getHeadtext() {
		return headtext;
	}
	/**
	 * 设置：底部文字
	 */
	public void setBottomtext(String bottomtext) {
		this.bottomtext = bottomtext;
	}
	/**
	 * 获取：底部文字
	 */
	public String getBottomtext() {
		return bottomtext;
	}
}
