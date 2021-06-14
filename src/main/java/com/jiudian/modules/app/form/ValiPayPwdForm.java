package com.jiudian.modules.app.form;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "设置支付密码表单")
public class ValiPayPwdForm {

	@ApiModelProperty(value = "原始密码(首次设置无需填写)")
	private String lastPwd;
	
	@ApiModelProperty(value = "新密码")
	@NotNull(message = "新密码不能为空")
	private String newPwd;

	public String getLastPwd() {
		return lastPwd;
	}

	public void setLastPwd(String lastPwd) {
		this.lastPwd = lastPwd;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}
}
