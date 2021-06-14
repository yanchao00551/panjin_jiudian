package com.jiudian.modules.shop.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 店铺退货设置
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 13:58:04
 */
@TableName("ns_order_shop_return")
public class OrderShopReturnEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer shopId;
	/**
	 * 商家地址
	 */
	private String shopAddress;
	/**
	 * 收件人
	 */
	private String sellerName;
	/**
	 * 收件人手机号
	 */
	private String sellerMobile;
	/**
	 * 邮编
	 */
	private String sellerZipcode;
	/**
	 * 创建时间
	 */
	private Integer createTime;
	/**
	 * 修改时间
	 */
	private Integer modifyTime;

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
	 * 设置：商家地址
	 */
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	/**
	 * 获取：商家地址
	 */
	public String getShopAddress() {
		return shopAddress;
	}
	/**
	 * 设置：收件人
	 */
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	/**
	 * 获取：收件人
	 */
	public String getSellerName() {
		return sellerName;
	}
	/**
	 * 设置：收件人手机号
	 */
	public void setSellerMobile(String sellerMobile) {
		this.sellerMobile = sellerMobile;
	}
	/**
	 * 获取：收件人手机号
	 */
	public String getSellerMobile() {
		return sellerMobile;
	}
	/**
	 * 设置：邮编
	 */
	public void setSellerZipcode(String sellerZipcode) {
		this.sellerZipcode = sellerZipcode;
	}
	/**
	 * 获取：邮编
	 */
	public String getSellerZipcode() {
		return sellerZipcode;
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
}
