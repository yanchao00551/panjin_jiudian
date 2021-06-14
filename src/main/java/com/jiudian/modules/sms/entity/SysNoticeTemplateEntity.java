package com.jiudian.modules.sms.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 通知模版设置
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-22 10:30:13
 */
@TableName("sys_notice_template")
public class SysNoticeTemplateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 模板id
	 */
	@TableId
	private Integer templateId;
	/**
	 * 模板类型
	 */
	private String templateType;
	/**
	 * 店铺id
	 */
	private Integer instanceId;
	/**
	 * 模板编号
	 */
	private String templateCode;
	/**
	 * 模板编号
	 */
	private String templateTitle;
	/**
	 * 模板名称
	 */
	private String templateContent;
	/**
	 * 签名
	 */
	private String signName;
	/**
	 * 是否开启
	 */
	private Integer isEnable;
	/**
	 * 更新时间
	 */
	private Integer modifyTime;
	/**
	 * 通知人类型
	 */
	private String notifyType;
	/**
	 * 通知方式
	 */
	private String notificationMode;

	/**
	 * 设置：模板id
	 */
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}
	/**
	 * 获取：模板id
	 */
	public Integer getTemplateId() {
		return templateId;
	}
	/**
	 * 设置：模板类型
	 */
	public void setTemplateType(String templateType) {
		this.templateType = templateType;
	}
	/**
	 * 获取：模板类型
	 */
	public String getTemplateType() {
		return templateType;
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
	 * 设置：模板编号
	 */
	public void setTemplateCode(String templateCode) {
		this.templateCode = templateCode;
	}
	/**
	 * 获取：模板编号
	 */
	public String getTemplateCode() {
		return templateCode;
	}
	/**
	 * 设置：模板编号
	 */
	public void setTemplateTitle(String templateTitle) {
		this.templateTitle = templateTitle;
	}
	/**
	 * 获取：模板编号
	 */
	public String getTemplateTitle() {
		return templateTitle;
	}
	/**
	 * 设置：模板名称
	 */
	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}
	/**
	 * 获取：模板名称
	 */
	public String getTemplateContent() {
		return templateContent;
	}
	/**
	 * 设置：签名
	 */
	public void setSignName(String signName) {
		this.signName = signName;
	}
	/**
	 * 获取：签名
	 */
	public String getSignName() {
		return signName;
	}
	/**
	 * 设置：是否开启
	 */
	public void setIsEnable(Integer isEnable) {
		this.isEnable = isEnable;
	}
	/**
	 * 获取：是否开启
	 */
	public Integer getIsEnable() {
		return isEnable;
	}
	/**
	 * 设置：更新时间
	 */
	public void setModifyTime(Integer modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：更新时间
	 */
	public Integer getModifyTime() {
		return modifyTime;
	}
	/**
	 * 设置：通知人类型
	 */
	public void setNotifyType(String notifyType) {
		this.notifyType = notifyType;
	}
	/**
	 * 获取：通知人类型
	 */
	public String getNotifyType() {
		return notifyType;
	}
	/**
	 * 设置：通知方式
	 */
	public void setNotificationMode(String notificationMode) {
		this.notificationMode = notificationMode;
	}
	/**
	 * 获取：通知方式
	 */
	public String getNotificationMode() {
		return notificationMode;
	}
}
