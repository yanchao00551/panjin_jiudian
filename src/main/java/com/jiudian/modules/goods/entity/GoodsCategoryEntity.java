package com.jiudian.modules.goods.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jiudian.modules.album.entity.AlbumPictureEntity;

/**
 * 商品分类表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
@TableName("ns_goods_category")
public class GoodsCategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer categoryId;
	/**
	 * 
	 */
	private String categoryName;
	/**
	 * 商品分类简称 
	 */
	private String shortName;
	/**
	 * 
	 */
	private Integer pid;
	/**
	 * 
	 */
	private Integer level;
	/**
	 * 是否显示  1 显示 0 不显示
	 */
	private Integer isVisible;
	/**
	 * 关联商品类型ID
	 */
	private Integer attrId;
	/**
	 * 关联类型名称
	 */
	private String attrName;
	/**
	 * 分类关键字用于seo
	 */
	private String keywords;
	/**
	 * 分类描述用于seo
	 */
	private String description;
	/**
	 * 
	 */
	private Integer sort;
	/**
	 * 商品分类图片
	 */
	private String categoryPic;
	/**
	 * pc端商品分类自定义模板
	 */
	private String pcCustomTemplate;
	/**
	 * wap端商品分类自定义模板
	 */
	private String wapCustomTemplate;
	
	private String icon;

	
	/*----- other ----*/
	@TableField(exist = false) 
	private List<GoodsCategoryEntity> childList;
	@TableField(exist = false) 
	private Integer count;
	@TableField(exist = false) 
	private Integer isParent;
	@TableField(exist = false) 
	private List<GoodsCategoryEntity> children;
	@TableField(exist = false) 
	private Integer value;
	@TableField(exist = false) 
	private String label;
	@TableField(exist = false)
	private Integer parentId;
	@TableField(exist = false)
	private AlbumPictureEntity catePic;
	@TableField(exist = false)
	private AlbumPictureEntity iconPic;
	
	
	
	
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer integer) {
		this.value = integer;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public List<GoodsCategoryEntity> getChildren() {
		return children;
	}
	public void setChildren(List<GoodsCategoryEntity> children) {
		this.children = children;
	}
	public Integer getIsParent() {
		return isParent;
	}
	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public List<GoodsCategoryEntity> getChildList() {
		return childList;
	}
	public void setChildList(List<GoodsCategoryEntity> childList) {
		this.childList = childList;
	}
	/**
	 * 设置：
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * 获取：
	 */
	public Integer getCategoryId() {
		return categoryId;
	}
	/**
	 * 设置：
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * 获取：
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * 设置：商品分类简称 
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	/**
	 * 获取：商品分类简称 
	 */
	public String getShortName() {
		return shortName;
	}
	/**
	 * 设置：
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 获取：
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * 设置：
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 获取：
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * 设置：是否显示  1 显示 0 不显示
	 */
	public void setIsVisible(Integer isVisible) {
		this.isVisible = isVisible;
	}
	/**
	 * 获取：是否显示  1 显示 0 不显示
	 */
	public Integer getIsVisible() {
		return isVisible;
	}
	/**
	 * 设置：关联商品类型ID
	 */
	public void setAttrId(Integer attrId) {
		this.attrId = attrId;
	}
	/**
	 * 获取：关联商品类型ID
	 */
	public Integer getAttrId() {
		return attrId;
	}
	/**
	 * 设置：关联类型名称
	 */
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
	/**
	 * 获取：关联类型名称
	 */
	public String getAttrName() {
		return attrName;
	}
	/**
	 * 设置：分类关键字用于seo
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	/**
	 * 获取：分类关键字用于seo
	 */
	public String getKeywords() {
		return keywords;
	}
	/**
	 * 设置：分类描述用于seo
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：分类描述用于seo
	 */
	public String getDescription() {
		return description;
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
	 * 设置：商品分类图片
	 */
	public void setCategoryPic(String categoryPic) {
		this.categoryPic = categoryPic;
	}
	/**
	 * 获取：商品分类图片
	 */
	public String getCategoryPic() {
		return categoryPic;
	}
	/**
	 * 设置：pc端商品分类自定义模板
	 */
	public void setPcCustomTemplate(String pcCustomTemplate) {
		this.pcCustomTemplate = pcCustomTemplate;
	}
	/**
	 * 获取：pc端商品分类自定义模板
	 */
	public String getPcCustomTemplate() {
		return pcCustomTemplate;
	}
	/**
	 * 设置：wap端商品分类自定义模板
	 */
	public void setWapCustomTemplate(String wapCustomTemplate) {
		this.wapCustomTemplate = wapCustomTemplate;
	}
	/**
	 * 获取：wap端商品分类自定义模板
	 */
	public String getWapCustomTemplate() {
		return wapCustomTemplate;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public AlbumPictureEntity getCatePic() {
		return catePic;
	}
	public void setCatePic(AlbumPictureEntity catePic) {
		this.catePic = catePic;
	}
	public AlbumPictureEntity getIconPic() {
		return iconPic;
	}
	public void setIconPic(AlbumPictureEntity iconPic) {
		this.iconPic = iconPic;
	}
}
