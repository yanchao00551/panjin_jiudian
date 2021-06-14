package com.jiudian.modules.app.form;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings(value= {})
@ApiModel(value = "发送验证码表单")
public class SendMsgForm {
	/**
	 * 手机号
	 */
	@ApiModelProperty(value = "手机号")
    @NotNull(message="手机号不能为空")
	private String mobile;
	
	private String imgCode;
	
	private String sendType;
	
	
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getImgCode() {
		return imgCode;
	}

	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	
}
