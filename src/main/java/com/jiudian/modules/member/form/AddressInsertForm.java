package com.jiudian.modules.member.form;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings(value= {})
@ApiModel(value = "会员添加地址表单")
public class AddressInsertForm {
	private Integer id;

	/**
	 * 收件人
	 */
	@ApiModelProperty(value = "收件人")
    @NotBlank(message="收件人不能为空")
	private String consigner;
	/**
	 * 手机
	 */
	@ApiModelProperty(value = "手机")
    @NotBlank(message="手机不能为空")
	private String mobile;
	/**
	 * phone固话
	 */
	private String phone; 
	/**
	 * 省
	 */
	@ApiModelProperty(value = "省")
	@NotNull(message="省不能为空")
	private int province;
	/**
	 * 市
	 */
	@ApiModelProperty(value = "市")
	@NotNull(message="市不能为空")
	private int city;
	/**
	 * 区
	 */
	@ApiModelProperty(value = "区")
	@NotNull(message="区不能为空")
	private int district;
	/**
	 * 详细地址
	 */
	@ApiModelProperty(value = "街道地址")
    @NotBlank(message="街道地址不能为空")
	private String address;
	/**
	 * 邮政编码
	 */
	private String zipCode;
	/**
	 * 城市别名
	 * 
	 */
	private String alias;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getConsigner() {
		return consigner;
	}
	public void setConsigner(String consigner) {
		this.consigner = consigner;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getProvince() {
		return province;
	}
	public void setProvince(int province) {
		this.province = province;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
		this.city = city;
	}
	public int getDistrict() {
		return district;
	}
	public void setDistrict(int district) {
		this.district = district;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
}
