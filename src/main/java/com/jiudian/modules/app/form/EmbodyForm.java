package com.jiudian.modules.app.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

/**
 * 体现申请
 * @author Mr.Yan
 *
 */
@ApiModel(value = "体现申请表单")

public class EmbodyForm {
    @ApiModelProperty(value = "提醒金额")
    @NotNull(message="体现金额不能为空")
    private BigDecimal cash;
    
    @ApiModelProperty(value = "体现账户ID")
    @NotNull(message="体现账户Id不能为空")
    private Integer memberBankAccountId;

	public BigDecimal getCash() {
		return cash;
	}

	public void setCash(BigDecimal cash) {
		this.cash = cash;
	}

	public Integer getMemberBankAccountId() {
		return memberBankAccountId;
	}

	public void setMemberBankAccountId(Integer memberBankAccountId) {
		this.memberBankAccountId = memberBankAccountId;
	}
    
    
    
}
