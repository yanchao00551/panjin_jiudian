package com.jiudian.modules.address.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-02 10:59:51
 */
@TableName("sys_district")
public class DistrictEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer districtId;
	/**
	 * 
	 */
	private Integer cityId;
	/**
	 * 
	 */
	private String districtName;
	/**
	 * 
	 */
	private Integer sort;

	/**
	 * 设置：
	 */
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	/**
	 * 获取：
	 */
	public Integer getDistrictId() {
		return districtId;
	}
	/**
	 * 设置：
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	/**
	 * 获取：
	 */
	public Integer getCityId() {
		return cityId;
	}
	/**
	 * 设置：
	 */
	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}
	/**
	 * 获取：
	 */
	public String getDistrictName() {
		return districtName;
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
