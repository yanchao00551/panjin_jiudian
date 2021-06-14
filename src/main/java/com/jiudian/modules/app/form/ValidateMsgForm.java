package com.jiudian.modules.app.form;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@SuppressWarnings(value= {})
@ApiModel(value = "验证码注册验证表单")
public class ValidateMsgForm {
	/**
	 * 手机号
	 */
	@ApiModelProperty(value = "手机号")
	@NotNull(message="手机号不能为空")
	private String mobile;
	/**
	 * 验证码
	 */
	@ApiModelProperty(value = "验证码")
	@NotNull(message="验证码不能为空")
	private String msgNum;
	/**
	 * 时间戳
	 */
	@ApiModelProperty(value = "时间戳")
    @NotNull(message="时间戳不能为空")
	private String tamp;
	/**
	 * hash
	 */
	@ApiModelProperty(value = "hash")
    @NotNull(message="hash不能为空")
	private String hash;
	
	/**
	 * 自定义密码
	 */
	private String password;
	
	/**
	 * 推广人ID
	 * 
	 */
	private String promoter;
	
	private int type;
	
	private String birthDate;
	
	
	public String getPromoter() {
		return promoter;
	}

	public void setPromoter(String promoter) {
		this.promoter = promoter;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMsgNum() {
		return msgNum;
	}

	public void setMsgNum(String msgNum) {
		this.msgNum = msgNum;
	}

	public String getTamp() {
		return tamp;
	}

	public void setTamp(String tamp) {
		this.tamp = tamp;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
}
