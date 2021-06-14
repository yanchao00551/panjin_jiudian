package com.jiudian.modules.goods.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 品牌表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
@TableName("ns_goods_brand")
public class GoodsBrandEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 索引ID
	 */
	@TableId
	private Long brandId;
	/**
	 * 店铺ID
	 */
	private Integer shopId;
	/**
	 * 品牌名称
	 */
	private String brandName;
	/**
	 * 品牌首字母
	 */
	private String brandInitial;
	/**
	 * 图片
	 */
	private String brandPic;
	/**
	 * 推荐，0为否，1为是，默认为0
	 */
	private Integer brandRecommend;
	/**
	 * 
	 */
	private Integer sort;
	/**
	 * 类别名称
	 */
	private String brandCategoryName;
	/**
	 * 所属分类id组
	 */
	private String categoryIdArray;
	/**
	 * 品牌推荐广告
	 */
	private String brandAds;
	/**
	 * 品牌所属分类名称
	 */
	private String categoryName;
	/**
	 * 一级分类ID
	 */
	private Integer categoryId1;
	/**
	 * 二级分类ID
	 */
	private Integer categoryId2;
	/**
	 * 三级分类ID
	 */
	private Integer categoryId3;

	/**
	 * 设置：索引ID
	 */
	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}
	/**
	 * 获取：索引ID
	 */
	public Long getBrandId() {
		return brandId;
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
	 * 设置：品牌名称
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	/**
	 * 获取：品牌名称
	 */
	public String getBrandName() {
		return brandName;
	}
	/**
	 * 设置：品牌首字母
	 */
	public void setBrandInitial(String brandInitial) {
		this.brandInitial = brandInitial;
	}
	/**
	 * 获取：品牌首字母
	 */
	public String getBrandInitial() {
		return brandInitial;
	}
	/**
	 * 设置：图片
	 */
	public void setBrandPic(String brandPic) {
		this.brandPic = brandPic;
	}
	/**
	 * 获取：图片
	 */
	public String getBrandPic() {
		return brandPic;
	}
	/**
	 * 设置：推荐，0为否，1为是，默认为0
	 */
	public void setBrandRecommend(Integer brandRecommend) {
		this.brandRecommend = brandRecommend;
	}
	/**
	 * 获取：推荐，0为否，1为是，默认为0
	 */
	public Integer getBrandRecommend() {
		return brandRecommend;
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
	 * 设置：类别名称
	 */
	public void setBrandCategoryName(String brandCategoryName) {
		this.brandCategoryName = brandCategoryName;
	}
	/**
	 * 获取：类别名称
	 */
	public String getBrandCategoryName() {
		return brandCategoryName;
	}
	/**
	 * 设置：所属分类id组
	 */
	public void setCategoryIdArray(String categoryIdArray) {
		this.categoryIdArray = categoryIdArray;
	}
	/**
	 * 获取：所属分类id组
	 */
	public String getCategoryIdArray() {
		return categoryIdArray;
	}
	/**
	 * 设置：品牌推荐广告
	 */
	public void setBrandAds(String brandAds) {
		this.brandAds = brandAds;
	}
	/**
	 * 获取：品牌推荐广告
	 */
	public String getBrandAds() {
		return brandAds;
	}
	/**
	 * 设置：品牌所属分类名称
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	/**
	 * 获取：品牌所属分类名称
	 */
	public String getCategoryName() {
		return categoryName;
	}
	/**
	 * 设置：一级分类ID
	 */
	public void setCategoryId1(Integer categoryId1) {
		this.categoryId1 = categoryId1;
	}
	/**
	 * 获取：一级分类ID
	 */
	public Integer getCategoryId1() {
		return categoryId1;
	}
	/**
	 * 设置：二级分类ID
	 */
	public void setCategoryId2(Integer categoryId2) {
		this.categoryId2 = categoryId2;
	}
	/**
	 * 获取：二级分类ID
	 */
	public Integer getCategoryId2() {
		return categoryId2;
	}
	/**
	 * 设置：三级分类ID
	 */
	public void setCategoryId3(Integer categoryId3) {
		this.categoryId3 = categoryId3;
	}
	/**
	 * 获取：三级分类ID
	 */
	public Integer getCategoryId3() {
		return categoryId3;
	}
}
