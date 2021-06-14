package com.jiudian.modules.sms.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 通知模板项
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-22 11:24:27
 */
@TableName("sys_notice_template_item")
public class SysNoticeTemplateItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 项名称
	 */
	private String itemName;
	/**
	 * 显示名称
	 */
	private String showName;
	/**
	 * 替换字段名字
	 */
	private String replaceName;
	/**
	 * 关联type类型
	 */
	private String typeIds;
	/**
	 * 排序
	 */
	private Integer order;

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
	 * 设置：项名称
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * 获取：项名称
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * 设置：显示名称
	 */
	public void setShowName(String showName) {
		this.showName = showName;
	}
	/**
	 * 获取：显示名称
	 */
	public String getShowName() {
		return showName;
	}
	/**
	 * 设置：替换字段名字
	 */
	public void setReplaceName(String replaceName) {
		this.replaceName = replaceName;
	}
	/**
	 * 获取：替换字段名字
	 */
	public String getReplaceName() {
		return replaceName;
	}
	/**
	 * 设置：关联type类型
	 */
	public void setTypeIds(String typeIds) {
		this.typeIds = typeIds;
	}
	/**
	 * 获取：关联type类型
	 */
	public String getTypeIds() {
		return typeIds;
	}
	/**
	 * 设置：排序
	 */
	public void setOrder(Integer order) {
		this.order = order;
	}
	/**
	 * 获取：排序
	 */
	public Integer getOrder() {
		return order;
	}
}
