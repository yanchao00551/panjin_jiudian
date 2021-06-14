package com.jiudian.modules.goods.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 商品规格值模版表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
@TableName("ns_goods_attribute_value")
public class GoodsAttributeValueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品属性值ID
	 */
	@TableId
	private Integer attrValueId;
	/**
	 * 商品属性ID
	 */
	private Integer attrId;
	/**
	 * 值名称
	 */
	private String attrValue;
	/**
	 * 是否可视
	 */
	private Boolean isVisible;
	/**
	 * 
	 */
	private Integer sort;
	/**
	 * 
	 */
	private Integer createTime;

	/**
	 * 设置：商品属性值ID
	 */
	public void setAttrValueId(Integer attrValueId) {
		this.attrValueId = attrValueId;
	}
	/**
	 * 获取：商品属性值ID
	 */
	public Integer getAttrValueId() {
		return attrValueId;
	}
	/**
	 * 设置：商品属性ID
	 */
	public void setAttrId(Integer attrId) {
		this.attrId = attrId;
	}
	/**
	 * 获取：商品属性ID
	 */
	public Integer getAttrId() {
		return attrId;
	}
	/**
	 * 设置：值名称
	 */
	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}
	/**
	 * 获取：值名称
	 */
	public String getAttrValue() {
		return attrValue;
	}
	/**
	 * 设置：是否可视
	 */
	public void setIsVisible(Boolean isVisible) {
		this.isVisible = isVisible;
	}
	/**
	 * 获取：是否可视
	 */
	public Boolean getIsVisible() {
		return isVisible;
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
