package com.jiudian.modules.express.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 物流公司
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-14 09:27:46
 */
@TableName("ns_express_company")
public class ExpressCompanyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 表序号
	 */
	@TableId
	private Integer coId;
	/**
	 * 商铺id
	 */
	private Integer shopId;
	/**
	 * 物流公司名称
	 */
	private String companyName;
	/**
	 * 物流编号
	 */
	private String expressNo;
	/**
	 * 使用状态
	 */
	private Integer isEnabled;
	/**
	 * 物流公司模版图片
	 */
	private String image;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 
	 */
	private Integer orders;
	/**
	 * 公司logo
	 */
	private String expressLogo;
	/**
	 * 是否设置为默认 0未设置 1 默认
	 */
	private Integer isDefault;

	/**
	 * 设置：表序号
	 */
	public void setCoId(Integer coId) {
		this.coId = coId;
	}
	/**
	 * 获取：表序号
	 */
	public Integer getCoId() {
		return coId;
	}
	/**
	 * 设置：商铺id
	 */
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	/**
	 * 获取：商铺id
	 */
	public Integer getShopId() {
		return shopId;
	}
	/**
	 * 设置：物流公司名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 获取：物流公司名称
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * 设置：物流编号
	 */
	public void setExpressNo(String expressNo) {
		this.expressNo = expressNo;
	}
	/**
	 * 获取：物流编号
	 */
	public String getExpressNo() {
		return expressNo;
	}
	/**
	 * 设置：使用状态
	 */
	public void setIsEnabled(Integer isEnabled) {
		this.isEnabled = isEnabled;
	}
	/**
	 * 获取：使用状态
	 */
	public Integer getIsEnabled() {
		return isEnabled;
	}
	/**
	 * 设置：物流公司模版图片
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * 获取：物流公司模版图片
	 */
	public String getImage() {
		return image;
	}
	/**
	 * 设置：联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：联系电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：
	 */
	public void setOrders(Integer orders) {
		this.orders = orders;
	}
	/**
	 * 获取：
	 */
	public Integer getOrders() {
		return orders;
	}
	/**
	 * 设置：公司logo
	 */
	public void setExpressLogo(String expressLogo) {
		this.expressLogo = expressLogo;
	}
	/**
	 * 获取：公司logo
	 */
	public String getExpressLogo() {
		return expressLogo;
	}
	/**
	 * 设置：是否设置为默认 0未设置 1 默认
	 */
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	/**
	 * 获取：是否设置为默认 0未设置 1 默认
	 */
	public Integer getIsDefault() {
		return isDefault;
	}
}
