package com.jiudian.modules.goods.form;

/**
 * 添加商品分类
 * @author KF-180419
 *
 */

public class AddGoodsCategoryForm {
	
	/**
	 * 分类ID
	 */
	private Integer categoryId;
	
	/**
	 * 分类名称
	 */
	private String categoryName;
	
	/**
	 * 上级类ID
	 */
	private Integer pid;
	
	/**
	 * 是否启用
	 */
	private Integer isVisible;
	
	/**
	 * 关键字
	 */
	private String keywords;
	
	/**
	 * 说明
	 */
	private String description;
	
	/**
	 * 排序
	 */
	private Integer sort;
	
	/**
	 * 图片
	 */
	private String categoryPic;
	
	/**
	 * 关联商品类型ID
	 */
	private Integer attrId;
	
	/**
	 * 关联类型名称
	 */
	 private String attrName;
	 
	 /**
	  * 商品分类简称 
	  */
	private String shortName;
	
	private int icon;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(Integer isVisible) {
		this.isVisible = isVisible;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getCategoryPic() {
		return categoryPic;
	}

	public void setCategoryPic(String categoryPic) {
		this.categoryPic = categoryPic;
	}

	public Integer getAttrId() {
		return attrId;
	}

	public void setAttrId(Integer attrId) {
		this.attrId = attrId;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}
	
	
}
