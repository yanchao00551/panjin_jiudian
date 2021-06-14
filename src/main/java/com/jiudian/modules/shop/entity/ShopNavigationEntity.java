package com.jiudian.modules.shop.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 店铺导航管理
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 13:58:02
 */
@TableName("ns_shop_navigation")
public class ShopNavigationEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer navId;
	/**
	 * 店铺ID
	 */
	private Integer shopId;
	/**
	 * 导航名称
	 */
	private String navTitle;
	/**
	 * 链接地址
	 */
	private String navUrl;
	/**
	 * 1pc端  2手机端
	 */
	private Integer type;
	/**
	 * 排序号
	 */
	private Integer sort;
	/**
	 * 横向所在位置1 左  2  右
	 */
	private Integer align;
	/**
	 * 
	 */
	private Integer navType;
	/**
	 * 
	 */
	private Integer isBlank;
	/**
	 * 
	 */
	private String templateName;
	/**
	 * 创建时间
	 */
	private Integer createTime;
	/**
	 * 修改时间
	 */
	private Integer modifyTime;
	/**
	 * 导航图标
	 */
	private String navIcon;
	/**
	 * 是否显示 1显示 0不显示
	 */
	private Integer isShow;

	/**
	 * 设置：主键
	 */
	public void setNavId(Integer navId) {
		this.navId = navId;
	}
	/**
	 * 获取：主键
	 */
	public Integer getNavId() {
		return navId;
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
	 * 设置：导航名称
	 */
	public void setNavTitle(String navTitle) {
		this.navTitle = navTitle;
	}
	/**
	 * 获取：导航名称
	 */
	public String getNavTitle() {
		return navTitle;
	}
	/**
	 * 设置：链接地址
	 */
	public void setNavUrl(String navUrl) {
		this.navUrl = navUrl;
	}
	/**
	 * 获取：链接地址
	 */
	public String getNavUrl() {
		return navUrl;
	}
	/**
	 * 设置：1pc端  2手机端
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 获取：1pc端  2手机端
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
	 * 设置：横向所在位置1 左  2  右
	 */
	public void setAlign(Integer align) {
		this.align = align;
	}
	/**
	 * 获取：横向所在位置1 左  2  右
	 */
	public Integer getAlign() {
		return align;
	}
	/**
	 * 设置：
	 */
	public void setNavType(Integer navType) {
		this.navType = navType;
	}
	/**
	 * 获取：
	 */
	public Integer getNavType() {
		return navType;
	}
	/**
	 * 设置：
	 */
	public void setIsBlank(Integer isBlank) {
		this.isBlank = isBlank;
	}
	/**
	 * 获取：
	 */
	public Integer getIsBlank() {
		return isBlank;
	}
	/**
	 * 设置：
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	/**
	 * 获取：
	 */
	public String getTemplateName() {
		return templateName;
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
	 * 设置：导航图标
	 */
	public void setNavIcon(String navIcon) {
		this.navIcon = navIcon;
	}
	/**
	 * 获取：导航图标
	 */
	public String getNavIcon() {
		return navIcon;
	}
	/**
	 * 设置：是否显示 1显示 0不显示
	 */
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	/**
	 * 获取：是否显示 1显示 0不显示
	 */
	public Integer getIsShow() {
		return isShow;
	}
}
