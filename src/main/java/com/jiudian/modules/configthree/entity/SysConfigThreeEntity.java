package com.jiudian.modules.configthree.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 第三方配置表
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-06-20 09:40:02
 */
@TableName("sys_config_three")
public class SysConfigThreeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer id;
	/**
	 * 实例ID
	 */
	private Integer instanceId;
	/**
	 * 配置项WCHAT,QQ,WPAY,ALIPAY...
	 */
	private String key;
	/**
	 * 配置值json
	 */
	private String value;
	/**
	 * 描述
	 */
	private String desc;
	/**
	 * 是否启用 1启用 0不启用
	 */
	private Integer isUse;
	/**
	 * 创建时间
	 */
	private Integer createTime;
	/**
	 * 修改时间
	 */
	private Integer modifyTime;

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
	 * 设置：实例ID
	 */
	public void setInstanceId(Integer instanceId) {
		this.instanceId = instanceId;
	}
	/**
	 * 获取：实例ID
	 */
	public Integer getInstanceId() {
		return instanceId;
	}
	/**
	 * 设置：配置项WCHAT,QQ,WPAY,ALIPAY...
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * 获取：配置项WCHAT,QQ,WPAY,ALIPAY...
	 */
	public String getKey() {
		return key;
	}
	/**
	 * 设置：配置值json
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 获取：配置值json
	 */
	public String getValue() {
		return value;
	}
	/**
	 * 设置：描述
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * 获取：描述
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * 设置：是否启用 1启用 0不启用
	 */
	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}
	/**
	 * 获取：是否启用 1启用 0不启用
	 */
	public Integer getIsUse() {
		return isUse;
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
	/**
	 * 设置：修改时间
	 */
	public void setModifyTime(Integer modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Integer getModifyTime() {
		return modifyTime;
	}
}
