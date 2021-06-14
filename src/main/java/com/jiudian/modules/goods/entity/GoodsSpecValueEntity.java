package com.jiudian.modules.goods.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 商品规格值模版表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:53
 */
@TableName("ns_goods_spec_value")
public class GoodsSpecValueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品属性值ID
	 */
	@TableId
	private Integer specValueId;
	/**
	 * 商品属性ID
	 */
	private Integer specId;
	/**
	 * 商品属性值名称
	 */
	private String specValueName;
	/**
	 * 商品属性值数据
	 */
	private String specValueData;
	/**
	 * 是否可视
	 */
	private Integer isVisible;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 
	 */
	private Integer createTime;
	
	/**
	 * 商品ID
	 */
	private Integer goodsId;
	
	/*----- other -----*/
	@TableField(exist = false) 
	private Integer specShowType;
	@TableField(exist = false) 
	private Integer picture;
	@TableField(exist = false) 
	private String specName;
	@TableField(exist = false) 
	private String specValueDataSrc;
	
	
	
	
	
	

	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getSpecValueDataSrc() {
		return specValueDataSrc;
	}
	public void setSpecValueDataSrc(String specValueDataSrc) {
		this.specValueDataSrc = specValueDataSrc;
	}
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	public Integer getPicture() {
		return picture;
	}
	public void setPicture(Integer picture) {
		this.picture = picture;
	}
	public Integer getSpecShowType() {
		return specShowType;
	}
	public void setSpecShowType(Integer specShowType) {
		this.specShowType = specShowType;
	}
	/**
	 * 设置：商品属性值ID
	 */
	public void setSpecValueId(Integer specValueId) {
		this.specValueId = specValueId;
	}
	/**
	 * 获取：商品属性值ID
	 */
	public Integer getSpecValueId() {
		return specValueId;
	}
	/**
	 * 设置：商品属性ID
	 */
	public void setSpecId(Integer specId) {
		this.specId = specId;
	}
	/**
	 * 获取：商品属性ID
	 */
	public Integer getSpecId() {
		return specId;
	}
	/**
	 * 设置：商品属性值名称
	 */
	public void setSpecValueName(String specValueName) {
		this.specValueName = specValueName;
	}
	/**
	 * 获取：商品属性值名称
	 */
	public String getSpecValueName() {
		return specValueName;
	}
	/**
	 * 设置：商品属性值数据
	 */
	public void setSpecValueData(String specValueData) {
		this.specValueData = specValueData;
	}
	/**
	 * 获取：商品属性值数据
	 */
	public String getSpecValueData() {
		return specValueData;
	}
	/**
	 * 设置：是否可视
	 */
	public void setIsVisible(Integer isVisible) {
		this.isVisible = isVisible;
	}
	/**
	 * 获取：是否可视
	 */
	public Integer getIsVisible() {
		return isVisible;
	}
	/**
	 * 设置：排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序
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
}
