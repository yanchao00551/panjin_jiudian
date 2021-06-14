package com.jiudian.modules.shop.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 物流地址
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 13:58:02
 */
@TableName("ns_shop_express_address")
public class ShopExpressAddressEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 物流地址id
	 */
	@TableId
	private Integer expressAddressId;
	/**
	 * 商铺id
	 */
	private Integer shopId;
	/**
	 * 联系人
	 */
	private String contact;
	/**
	 * 手机
	 */
	private String mobile;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 公司名称
	 */
	private String companyName;
	/**
	 * 所在地省
	 */
	private Integer province;
	/**
	 * 所在地市
	 */
	private Integer city;
	/**
	 * 所在地区县
	 */
	private Integer district;
	/**
	 * 邮编
	 */
	private String zipcode;
	/**
	 * 详细地址
	 */
	private String address;
	/**
	 * 发货地址标记
	 */
	private Integer isConsigner;
	/**
	 * 收货地址标记
	 */
	private Integer isReceiver;
	/**
	 * 创建日期
	 */
	private Integer createDate;
	/**
	 * 修改日期
	 */
	private Integer modifyDate;

	/**
	 * 设置：物流地址id
	 */
	public void setExpressAddressId(Integer expressAddressId) {
		this.expressAddressId = expressAddressId;
	}
	/**
	 * 获取：物流地址id
	 */
	public Integer getExpressAddressId() {
		return expressAddressId;
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
	 * 设置：联系人
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}
	/**
	 * 获取：联系人
	 */
	public String getContact() {
		return contact;
	}
	/**
	 * 设置：手机
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：公司名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 获取：公司名称
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * 设置：所在地省
	 */
	public void setProvince(Integer province) {
		this.province = province;
	}
	/**
	 * 获取：所在地省
	 */
	public Integer getProvince() {
		return province;
	}
	/**
	 * 设置：所在地市
	 */
	public void setCity(Integer city) {
		this.city = city;
	}
	/**
	 * 获取：所在地市
	 */
	public Integer getCity() {
		return city;
	}
	/**
	 * 设置：所在地区县
	 */
	public void setDistrict(Integer district) {
		this.district = district;
	}
	/**
	 * 获取：所在地区县
	 */
	public Integer getDistrict() {
		return district;
	}
	/**
	 * 设置：邮编
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * 获取：邮编
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * 设置：详细地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：详细地址
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * 设置：发货地址标记
	 */
	public void setIsConsigner(Integer isConsigner) {
		this.isConsigner = isConsigner;
	}
	/**
	 * 获取：发货地址标记
	 */
	public Integer getIsConsigner() {
		return isConsigner;
	}
	/**
	 * 设置：收货地址标记
	 */
	public void setIsReceiver(Integer isReceiver) {
		this.isReceiver = isReceiver;
	}
	/**
	 * 获取：收货地址标记
	 */
	public Integer getIsReceiver() {
		return isReceiver;
	}
	/**
	 * 设置：创建日期
	 */
	public void setCreateDate(Integer createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建日期
	 */
	public Integer getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：修改日期
	 */
	public void setModifyDate(Integer modifyDate) {
		this.modifyDate = modifyDate;
	}
	/**
	 * 获取：修改日期
	 */
	public Integer getModifyDate() {
		return modifyDate;
	}
}
