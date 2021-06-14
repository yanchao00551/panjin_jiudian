package com.jiudian.modules.order.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 订单自提点管理
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:54:29
 */
@TableName("ns_order_pickup")
public class OrderPickupEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 订单ID
	 */
	private Integer orderId;
	/**
	 * 自提点名称
	 */
	private String name;
	/**
	 * 自提点地址
	 */
	private String address;
	/**
	 * 联系人
	 */
	private String contact;
	/**
	 * 联系电话
	 */
	private String phone;
	/**
	 * 市ID
	 */
	private Integer cityId;
	/**
	 * 省ID
	 */
	private Integer provinceId;
	/**
	 * 区县ID
	 */
	private Integer districtId;
	/**
	 * 供应门店ID
	 */
	private Integer supplierId;
	/**
	 * 经度
	 */
	private String longitude;
	/**
	 * 维度
	 */
	private String latitude;
	/**
	 * 提货人姓名
	 */
	private String buyerName;
	/**
	 * 提货人电话
	 */
	private String buyerMobile;
	/**
	 * 提货备注信息
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Integer createTime;

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
	 * 设置：订单ID
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：订单ID
	 */
	public Integer getOrderId() {
		return orderId;
	}
	/**
	 * 设置：自提点名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：自提点名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：自提点地址
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * 获取：自提点地址
	 */
	public String getAddress() {
		return address;
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
	 * 设置：市ID
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	/**
	 * 获取：市ID
	 */
	public Integer getCityId() {
		return cityId;
	}
	/**
	 * 设置：省ID
	 */
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	/**
	 * 获取：省ID
	 */
	public Integer getProvinceId() {
		return provinceId;
	}
	/**
	 * 设置：区县ID
	 */
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}
	/**
	 * 获取：区县ID
	 */
	public Integer getDistrictId() {
		return districtId;
	}
	/**
	 * 设置：供应门店ID
	 */
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	/**
	 * 获取：供应门店ID
	 */
	public Integer getSupplierId() {
		return supplierId;
	}
	/**
	 * 设置：经度
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * 获取：经度
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * 设置：维度
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * 获取：维度
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * 设置：提货人姓名
	 */
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	/**
	 * 获取：提货人姓名
	 */
	public String getBuyerName() {
		return buyerName;
	}
	/**
	 * 设置：提货人电话
	 */
	public void setBuyerMobile(String buyerMobile) {
		this.buyerMobile = buyerMobile;
	}
	/**
	 * 获取：提货人电话
	 */
	public String getBuyerMobile() {
		return buyerMobile;
	}
	/**
	 * 设置：提货备注信息
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：提货备注信息
	 */
	public String getRemark() {
		return remark;
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
}
