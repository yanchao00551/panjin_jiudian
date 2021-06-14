package com.jiudian.modules.member.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 会员收货地址管理
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-26 13:10:53
 */
@TableName("ns_member_express_address")
public class MemberExpressAddressEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 会员基本资料表ID
	 */
	private Integer uid;
	/**
	 * 收件人
	 */
	private String consigner;
	/**
	 * 手机
	 */
	private String mobile;
	/**
	 * 固定电话
	 */
	private String phone;
	/**
	 * 省
	 */
	private Integer province;
	/**
	 * 市
	 */
	private Integer city;
	/**
	 * 区县
	 */
	private Integer district;
	/**
	 * 详细地址
	 */
	private String address;
	/**
	 * 邮编
	 */
	private String zipCode;
	/**
	 * 地址别名
	 */
	private String alias;
	/**
	 * 默认收货地址
	 */
	private Integer isDefault;
	
	private int recvTimeRange;

	/**
	 * 地址信息 如: 湖南省 湘潭市 雨湖区
	 */
	@TableField(exist = false)
	private String addressInfo;
	
	public String getAddressInfo() {
		return addressInfo;
	}
	public void setAddressInfo(String addressInfo) {
		this.addressInfo = addressInfo;
	}
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
	 * 设置：会员基本资料表ID
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：会员基本资料表ID
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：收件人
	 */
	public void setConsigner(String consigner) {
		this.consigner = consigner;
	}
	/**
	 * 获取：收件人
	 */
	public String getConsigner() {
		return consigner;
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
	 * 设置：固定电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * 获取：固定电话
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * 设置：省
	 */
	public void setProvince(Integer province) {
		this.province = province;
	}
	/**
	 * 获取：省
	 */
	public Integer getProvince() {
		return province;
	}
	/**
	 * 设置：市
	 */
	public void setCity(Integer city) {
		this.city = city;
	}
	/**
	 * 获取：市
	 */
	public Integer getCity() {
		return city;
	}
	/**
	 * 设置：区县
	 */
	public void setDistrict(Integer district) {
		this.district = district;
	}
	/**
	 * 获取：区县
	 */
	public Integer getDistrict() {
		return district;
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
	 * 设置：邮编
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * 获取：邮编
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * 设置：地址别名
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	/**
	 * 获取：地址别名
	 */
	public String getAlias() {
		return alias;
	}
	/**
	 * 设置：默认收货地址
	 */
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	/**
	 * 获取：默认收货地址
	 */
	public Integer getIsDefault() {
		return isDefault;
	}
	public int getRecvTimeRange() {
		return recvTimeRange;
	}
	public void setRecvTimeRange(int recvTimeRange) {
		this.recvTimeRange = recvTimeRange;
	}
}
