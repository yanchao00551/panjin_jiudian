package com.jiudian.modules.member.form;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;


/**
 * 更新会员登录密码
 * @author KF-180419
 *
 */

public class UpdateMemberPasswordForm {
	@ApiModelProperty(value = "ID")
	@NotNull(message="ID不能为空")
	private Integer id;
	@ApiModelProperty(value = "密码")
    @NotBlank(message="密码不能为空")
	private String password;
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
