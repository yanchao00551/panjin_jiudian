package com.jiudian.modules.app.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 添加或修改会员提现账号
 * @author Mr.Yan
 *
 */
@ApiModel(value = "添加或修改会员提现账号表单")

public class AddOrUpdateBankAccountForm {
    @ApiModelProperty(value = "账户类型")
    @NotNull(message="账户类型不能为空")
    private Integer accountType;
    
    @ApiModelProperty(value = "真实姓名")
    @NotNull(message="真实姓名不能为空")
    private String realname;
    
    @ApiModelProperty(value = "账号")
    @NotNull(message="账号不能为空")
    private String accountNumber;
    
    private Integer id;

	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    
    
    

    
}
