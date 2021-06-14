package com.jiudian.modules.weixin.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 微信功能按钮
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:23:07
 */
@TableName("sys_weixin_functions_button")
public class SysWeixinFunctiobuttonEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Integer buttonId;
	/**
	 * 实例
	 */
	private Integer instanceId;
	/**
	 * 模块名
	 */
	private String buttonName;
	/**
	 * 触发关键词
	 */
	private String keyname;
	/**
	 * 触发网址
	 */
	private String url;
	/**
	 * 触发次数
	 */
	private Integer hits;
	/**
	 * 是否启用
	 */
	private Integer isEnabled;
	/**
	 * 
	 */
	private Integer isSystem;
	/**
	 * 排序号
	 */
	private Integer orders;
	/**
	 * 创建日期
	 */
	private Integer createTime;
	/**
	 * 修改日期
	 */
	private Integer modifyTime;

	/**
	 * 设置：主键id
	 */
	public void setButtonId(Integer buttonId) {
		this.buttonId = buttonId;
	}
	/**
	 * 获取：主键id
	 */
	public Integer getButtonId() {
		return buttonId;
	}
	/**
	 * 设置：实例
	 */
	public void setInstanceId(Integer instanceId) {
		this.instanceId = instanceId;
	}
	/**
	 * 获取：实例
	 */
	public Integer getInstanceId() {
		return instanceId;
	}
	/**
	 * 设置：模块名
	 */
	public void setButtonName(String buttonName) {
		this.buttonName = buttonName;
	}
	/**
	 * 获取：模块名
	 */
	public String getButtonName() {
		return buttonName;
	}
	/**
	 * 设置：触发关键词
	 */
	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}
	/**
	 * 获取：触发关键词
	 */
	public String getKeyname() {
		return keyname;
	}
	/**
	 * 设置：触发网址
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：触发网址
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：触发次数
	 */
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	/**
	 * 获取：触发次数
	 */
	public Integer getHits() {
		return hits;
	}
	/**
	 * 设置：是否启用
	 */
	public void setIsEnabled(Integer isEnabled) {
		this.isEnabled = isEnabled;
	}
	/**
	 * 获取：是否启用
	 */
	public Integer getIsEnabled() {
		return isEnabled;
	}
	/**
	 * 设置：
	 */
	public void setIsSystem(Integer isSystem) {
		this.isSystem = isSystem;
	}
	/**
	 * 获取：
	 */
	public Integer getIsSystem() {
		return isSystem;
	}
	/**
	 * 设置：排序号
	 */
	public void setOrders(Integer orders) {
		this.orders = orders;
	}
	/**
	 * 获取：排序号
	 */
	public Integer getOrders() {
		return orders;
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
