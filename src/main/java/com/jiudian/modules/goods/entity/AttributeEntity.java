package com.jiudian.modules.goods.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;



/**
 * 商品相关属性
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 15:31:36
 */
@TableName("ns_attribute")
public class AttributeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品属性ID
	 */
	@TableId
	private Integer attrId;
	/**
	 * 属性名称
	 */
	private String attrName;
	/**
	 * 是否使用
	 */
	private Integer isUse;
	/**
	 * 关联规格
	 */
	private String specIdArray;
	/**
	 * 
	 */
	private Integer sort;
	/**
	 * 创建时间
	 */
	private Integer createTime;
	/**
	 * 修改时间
	 */
	private Integer modifyTime;
	/**
	 * 关联品牌
	 */
	private String brandIdArray;
	
	/*---- other ---*/
	@TableField(exist = false) 
	private String valueStr;
	@TableField(exist = false)
	private List<AttributeValueEntity> valueList;
	

	public List<AttributeValueEntity> getValueList() {
		return valueList;
	}
	 
	public void setValueList(List<AttributeValueEntity> valueList) {
		this.valueList = valueList;
	}
	
	
	 
	public String getValueStr() {
		return valueStr;
	}
	 
	public void setValueStr(String valueStr) {
		this.valueStr = valueStr;
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
	 * 设置：属性名称
	 */
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
	/**
	 * 获取：属性名称
	 */
	public String getAttrName() {
		return attrName;
	}
	/**
	 * 设置：是否使用
	 */
	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}
	/**
	 * 获取：是否使用
	 */
	public Integer getIsUse() {
		return isUse;
	}
	/**
	 * 设置：关联规格
	 */
	public void setSpecIdArray(String specIdArray) {
		this.specIdArray = specIdArray;
	}
	/**
	 * 获取：关联规格
	 */
	public String getSpecIdArray() {
		return specIdArray;
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
	/**
	 * 设置：关联品牌
	 */
	public void setBrandIdArray(String brandIdArray) {
		this.brandIdArray = brandIdArray;
	}
	/**
	 * 获取：关联品牌
	 */
	public String getBrandIdArray() {
		return brandIdArray;
	}
}
