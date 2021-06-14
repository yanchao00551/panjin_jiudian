package com.jiudian.modules.shop.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 店铺广告设置
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 13:58:03
 */
@TableName("ns_shop_ad")
public class ShopAdEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer shopId;
	/**
	 * 广告图片
	 */
	private String adImage;
	/**
	 * 链接地址
	 */
	private String linkUrl;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 类型 0 -- pc端  1-- 手机端 
	 */
	private Integer type;
	/**
	 * 背景色
	 */
	private String background;

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
	 * 设置：
	 */
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	/**
	 * 获取：
	 */
	public Integer getShopId() {
		return shopId;
	}
	/**
	 * 设置：广告图片
	 */
	public void setAdImage(String adImage) {
		this.adImage = adImage;
	}
	/**
	 * 获取：广告图片
	 */
	public String getAdImage() {
		return adImage;
	}
	/**
	 * 设置：链接地址
	 */
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
	/**
	 * 获取：链接地址
	 */
	public String getLinkUrl() {
		return linkUrl;
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
	 * 设置：类型 0 -- pc端  1-- 手机端 
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：类型 0 -- pc端  1-- 手机端 
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * 设置：背景色
	 */
	public void setBackground(String background) {
		this.background = background;
	}
	/**
	 * 获取：背景色
	 */
	public String getBackground() {
		return background;
	}
}
