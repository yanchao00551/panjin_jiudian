package com.jiudian.modules.goods.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 商品属性回收站表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:40
 */
@TableName("ns_goods_attribute_deleted")
public class GoodsAttributeDeletedEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer attrId;
	/**
	 * 商品ID
	 */
	private Integer goodsId;
	/**
	 * 店铺ID
	 */
	private Integer shopId;
	/**
	 * 属性值id
	 */
	private Integer attrValueId;
	/**
	 * 属性值名称
	 */
	private String attrValue;
	/**
	 * 属性值对应数据值
	 */
	private String attrValueName;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 创建时间
	 */
	private Integer createTime;

	/**
	 * 设置：
	 */
	public void setAttrId(Integer attrId) {
		this.attrId = attrId;
	}
	/**
	 * 获取：
	 */
	public Integer getAttrId() {
		return attrId;
	}
	/**
	 * 设置：商品ID
	 */
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	/**
	 * 获取：商品ID
	 */
	public Integer getGoodsId() {
		return goodsId;
	}
	/**
	 * 设置：店铺ID
	 */
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	/**
	 * 获取：店铺ID
	 */
	public Integer getShopId() {
		return shopId;
	}
	/**
	 * 设置：属性值id
	 */
	public void setAttrValueId(Integer attrValueId) {
		this.attrValueId = attrValueId;
	}
	/**
	 * 获取：属性值id
	 */
	public Integer getAttrValueId() {
		return attrValueId;
	}
	/**
	 * 设置：属性值名称
	 */
	public void setAttrValue(String attrValue) {
		this.attrValue = attrValue;
	}
	/**
	 * 获取：属性值名称
	 */
	public String getAttrValue() {
		return attrValue;
	}
	/**
	 * 设置：属性值对应数据值
	 */
	public void setAttrValueName(String attrValueName) {
		this.attrValueName = attrValueName;
	}
	/**
	 * 获取：属性值对应数据值
	 */
	public String getAttrValueName() {
		return attrValueName;
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
