package com.jiudian.modules.member.form;
import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings(value= {})
@ApiModel(value = "修改密码表单")
public class ModifyPasswordForm {
	/**
	 * 旧密码
	 */
	@ApiModelProperty(value = "旧密码")
    @NotBlank(message="旧密码不能为空")
	private String oldPassword;
	/**
	 * 新密码
	 */
	@ApiModelProperty(value = "新密码")
    @NotBlank(message="新密码不能为空")
	private String newPassword;
	
	
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
}
