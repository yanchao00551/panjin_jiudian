package com.jiudian.modules.address.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-02 10:59:59
 */
@TableName("sys_province")
public class ProvinceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer provinceId;
	/**
	 * 
	 */
	private Integer areaId;
	/**
	 * 
	 */
	private String provinceName;
	/**
	 * 
	 */
	private Integer sort;

	/**
	 * 设置：
	 */
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	/**
	 * 获取：
	 */
	public Integer getProvinceId() {
		return provinceId;
	}
	/**
	 * 设置：
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	/**
	 * 获取：
	 */
	public Integer getAreaId() {
		return areaId;
	}
	/**
	 * 设置：
	 */
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	/**
	 * 获取：
	 */
	public String getProvinceName() {
		return provinceName;
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
}
