package com.jiudian.modules.member.form;


import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;


/**
 * 后台更新用户信息
 * @author KF-180419
 *
 */

public class UpdateMemberForm {
	@ApiModelProperty(value = "ID")
	@NotNull(message="ID不能为空")
	private Integer id;
	
	@ApiModelProperty(value = "username")
    @NotBlank(message="username不能为空")
	private String username;
	
	private String nickname;
	
	@ApiModelProperty(value = "levelName等级")
	private Integer levelName;
	
	private String mobile;
	
	private String email;
	
	private Integer sex;
	
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getLevelName() {
		return levelName;
	}

	public void setLevelName(Integer levelName) {
		this.levelName = levelName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
