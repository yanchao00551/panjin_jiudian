package com.jiudian.modules.app.form;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *  编辑收货地址表单
 * @author Mr.Yan
 *
 */
@ApiModel(value = "编辑收货地址表单")

public class OperationAddressForm {
	private Integer id;
	
    @ApiModelProperty(value = "收件人")
    @NotNull(message="收件人不能为空")
    private String consigner;

    @ApiModelProperty(value = "电话")
    @NotNull(message="电话不能为空")
    private String mobile;

    @ApiModelProperty(value = "固定电话")
    private String phone;
    
    @ApiModelProperty(value = "省id")
    @NotNull(message="省id不能为空")
    private Integer province;
    
    @ApiModelProperty(value = "城市id")
    @NotNull(message="城市id不能为空")
    private Integer city;
    
    @ApiModelProperty(value = "县区不能为空")
    @NotNull(message="县区不能为空")
    private Integer district;
    
    @ApiModelProperty(value = "详细地址不能为空")
    @NotNull(message="address不能为空")
    private String address; 
    
    @ApiModelProperty(value = "邮编")
    private String zipCode;
    
    @ApiModelProperty(value = "是否为默认地址0否1是")
    @NotNull(message="是否为默认地址不能为空")
    private int isDefault;
    
    @ApiModelProperty(value = "收件时间区间（0：不限，1：8-10，2：10-12，3：12-14，4：14-16，5：16-18，6：18-20）")
    @NotNull(message="收件时间区间不能为空")
    private int recvTimeRange;
    
	public int getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(int isDefault) {
		this.isDefault = isDefault;
	}

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

	public Integer getProvince() {
		return province;
	}

	public void setProvince(Integer province) {
		this.province = province;
	}

	public Integer getCity() {
		return city;
	}

	public void setCity(Integer city) {
		this.city = city;
	}

	public Integer getDistrict() {
		return district;
	}

	public void setDistrict(Integer district) {
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

	public int getRecvTimeRange() {
		return recvTimeRange;
	}

	public void setRecvTimeRange(int recvTimeRange) {
		this.recvTimeRange = recvTimeRange;
	}
    
    
    


    
    
}
