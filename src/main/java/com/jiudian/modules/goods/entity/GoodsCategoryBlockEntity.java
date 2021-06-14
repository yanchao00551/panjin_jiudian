package com.jiudian.modules.goods.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 商品分类楼层表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
@TableName("ns_goods_category_block")
public class GoodsCategoryBlockEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 实例id
	 */
	private Integer shopId;
	/**
	 * 分类名称
	 */
	private String categoryName;
	/**
	 * 分类id
	 */
	private Integer categoryId;
	/**
	 * 分类别名
	 */
	private String categoryAlias;
	/**
	 * 颜色
	 */
	private String color;
	/**
	 * 是否显示 1显示 0 不显示
	 */
	private Integer isShow;
	/**
	 * 是否显示下级分类
	 */
	private Integer isShowLowerCategory;
	/**
	 * 是否显示品牌
	 */
	private Integer isShowBrand;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 广告图  {["title":"","subtitle":"","picture":"","url":"","background":""]}
	 */
	private String adPicture;
	/**
	 * 创建时间
	 */
	private Integer createTime;
	/**
	 * 修改时间
	 */
	private Integer modifyTime;
	/**
	 * 分类简称
	 */
	private String shortName;
	/**
	 * 楼层商品排序方式 0默认按时间和排序号倒叙 1按发布时间排序 2按销量排序 3按排序号排序 4按人气排序
	 */
	private Integer goodsSortType;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：实例id
	 */
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	/**
	 * 获取：实例id
	 */
	public Integer getShopId() {
		return shopId;
	}
	/**
	 * 设置：分类名称
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * 获取：分类名称
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * 设置：分类id
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * 获取：分类id
	 */
	public Integer getCategoryId() {
		return categoryId;
	}
	/**
	 * 设置：分类别名
	 */
	public void setCategoryAlias(String categoryAlias) {
		this.categoryAlias = categoryAlias;
	}
	/**
	 * 获取：分类别名
	 */
	public String getCategoryAlias() {
		return categoryAlias;
	}
	/**
	 * 设置：颜色
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * 获取：颜色
	 */
	public String getColor() {
		return color;
	}
	/**
	 * 设置：是否显示 1显示 0 不显示
	 */
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	/**
	 * 获取：是否显示 1显示 0 不显示
	 */
	public Integer getIsShow() {
		return isShow;
	}
	/**
	 * 设置：是否显示下级分类
	 */
	public void setIsShowLowerCategory(Integer isShowLowerCategory) {
		this.isShowLowerCategory = isShowLowerCategory;
	}
	/**
	 * 获取：是否显示下级分类
	 */
	public Integer getIsShowLowerCategory() {
		return isShowLowerCategory;
	}
	/**
	 * 设置：是否显示品牌
	 */
	public void setIsShowBrand(Integer isShowBrand) {
		this.isShowBrand = isShowBrand;
	}
	/**
	 * 获取：是否显示品牌
	 */
	public Integer getIsShowBrand() {
		return isShowBrand;
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
	 * 设置：广告图  {["title":"","subtitle":"","picture":"","url":"","background":""]}
	 */
	public void setAdPicture(String adPicture) {
		this.adPicture = adPicture;
	}
	/**
	 * 获取：广告图  {["title":"","subtitle":"","picture":"","url":"","background":""]}
	 */
	public String getAdPicture() {
		return adPicture;
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
	 * 设置：分类简称
	 */
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	/**
	 * 获取：分类简称
	 */
	public String getShortName() {
		return shortName;
	}
	/**
	 * 设置：楼层商品排序方式 0默认按时间和排序号倒叙 1按发布时间排序 2按销量排序 3按排序号排序 4按人气排序
	 */
	public void setGoodsSortType(Integer goodsSortType) {
		this.goodsSortType = goodsSortType;
	}
	/**
	 * 获取：楼层商品排序方式 0默认按时间和排序号倒叙 1按发布时间排序 2按销量排序 3按排序号排序 4按人气排序
	 */
	public Integer getGoodsSortType() {
		return goodsSortType;
	}
}
