package com.jiudian.modules.app.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 重置密码
 * @author Mr.Yan
 *
 */
@ApiModel(value = "重置密码表单")

public class SetPasswordForm {
    @ApiModelProperty(value = "原密码")
    @NotNull(message="原密码不能为空")
    private String lastPassword;
    
    @ApiModelProperty(value = "新密码")
    @NotNull(message="新密码不能为空")
    private String newPassword;

	public String getLastPassword() {
		return lastPassword;
	}

	public void setLastPassword(String lastPassword) {
		this.lastPassword = lastPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

    
}
