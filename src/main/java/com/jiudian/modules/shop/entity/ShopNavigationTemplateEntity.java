package com.jiudian.modules.shop.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 导航 的 系统默认模板
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 13:58:03
 */
@TableName("ns_shop_navigation_template")
public class ShopNavigationTemplateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer templateId;
	/**
	 * 模板名称
	 */
	private String templateName;
	/**
	 * 访问路径
	 */
	private String templateUrl;
	/**
	 * 是否有效
	 */
	private Integer isUse;
	/**
	 * 1 shop端 2wap端
	 */
	private Integer useType;
	/**
	 * 创建时间
	 */
	private Integer createTime;

	/**
	 * 设置：
	 */
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}
	/**
	 * 获取：
	 */
	public Integer getTemplateId() {
		return templateId;
	}
	/**
	 * 设置：模板名称
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	/**
	 * 获取：模板名称
	 */
	public String getTemplateName() {
		return templateName;
	}
	/**
	 * 设置：访问路径
	 */
	public void setTemplateUrl(String templateUrl) {
		this.templateUrl = templateUrl;
	}
	/**
	 * 获取：访问路径
	 */
	public String getTemplateUrl() {
		return templateUrl;
	}
	/**
	 * 设置：是否有效
	 */
	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}
	/**
	 * 获取：是否有效
	 */
	public Integer getIsUse() {
		return isUse;
	}
	/**
	 * 设置：1 shop端 2wap端
	 */
	public void setUseType(Integer useType) {
		this.useType = useType;
	}
	/**
	 * 获取：1 shop端 2wap端
	 */
	public Integer getUseType() {
		return useType;
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
}
