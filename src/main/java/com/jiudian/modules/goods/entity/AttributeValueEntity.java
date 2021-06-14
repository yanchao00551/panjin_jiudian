package com.jiudian.modules.goods.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jiudian.modules.album.entity.AlbumPictureEntity;

/**
 * 商品属性值
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 15:31:36
 */
@TableName("ns_attribute_value")
public class AttributeValueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 属性值ID
	 */
	@TableId
	private Integer attrValueId;
	/**
	 * 属性值名称
	 */
	private String attrValueName;
	/**
	 * 属性ID
	 */
	private Integer attrId;
	/**
	 * 属性对应相关数据
	 */
	private String value;
	/**
	 * 属性对应输入类型1.直接2.单选3.多选
	 */
	private Integer type;
	/**
	 * 排序号
	 */
	private Integer sort;
	/**
	 * 是否使用
	 */
	private Integer isSearch;
	
	private int isIcon;
	
	private int ico;
	
	@TableField(exist = false)
	private AlbumPictureEntity iconDetail;
	
	@TableField(exist = false)
	private int isBind;
	
	@TableField(exist = false)
	private String bindIds;

	/*----- other ----- */
	/**
	 * 属性值  ["有", "无"]
	 */
	@TableField(exist = false) 
	private String [] valueItems;
	
	
	public String[] getValueItems() {
		return valueItems;
	}
	public void setValueItems(String[] valueItems) {
		this.valueItems = valueItems;
	}
	
	/**
	 * 设置：属性值ID
	 */
	public void setAttrValueId(Integer attrValueId) {
		this.attrValueId = attrValueId;
	}
	/**
	 * 获取：属性值ID
	 */
	public Integer getAttrValueId() {
		return attrValueId;
	}
	/**
	 * 设置：属性值名称
	 */
	public void setAttrValueName(String attrValueName) {
		this.attrValueName = attrValueName;
	}
	/**
	 * 获取：属性值名称
	 */
	public String getAttrValueName() {
		return attrValueName;
	}
	/**
	 * 设置：属性ID
	 */
	public void setAttrId(Integer attrId) {
		this.attrId = attrId;
	}
	/**
	 * 获取：属性ID
	 */
	public Integer getAttrId() {
		return attrId;
	}
	/**
	 * 设置：属性对应相关数据
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * 获取：属性对应相关数据
	 */
	public String getValue() {
		return value;
	}
	/**
	 * 设置：属性对应输入类型1.直接2.单选3.多选
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：属性对应输入类型1.直接2.单选3.多选
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：排序号
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序号
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：是否使用
	 */
	public void setIsSearch(Integer isSearch) {
		this.isSearch = isSearch;
	}
	/**
	 * 获取：是否使用
	 */
	public Integer getIsSearch() {
		return isSearch;
	}
	public int getIsIcon() {
		return isIcon;
	}
	public void setIsIcon(int isIcon) {
		this.isIcon = isIcon;
	}
	public int getIco() {
		return ico;
	}
	public void setIco(int ico) {
		this.ico = ico;
	}
	public AlbumPictureEntity getIconDetail() {
		return iconDetail;
	}
	public void setIconDetail(AlbumPictureEntity iconDetail) {
		this.iconDetail = iconDetail;
	}
	public int getIsBind() {
		return isBind;
	}
	public void setIsBind(int isBind) {
		this.isBind = isBind;
	}
	public String getBindIds() {
		return bindIds;
	}
	public void setBindIds(String bindIds) {
		this.bindIds = bindIds;
	}
}
