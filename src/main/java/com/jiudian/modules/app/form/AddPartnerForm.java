package com.jiudian.modules.app.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

/**
 * 申请成为合伙人
 * @author Mr.Yan
 *
 */
@ApiModel(value = "申请合伙人表单")

public class AddPartnerForm {
    @ApiModelProperty(value = "联系方式")
    @NotNull(message="联系方式不能为空")
    private String userTel;

    @ApiModelProperty(value = "真实姓名")
    @NotNull(message="真实姓名不能为空")
    private String realName;

    @ApiModelProperty(value = "身份证反面")
    @NotNull(message="身份证反面")
    private Integer cardReverse;
    
    @ApiModelProperty(value = "身份证正面")
    @NotNull(message="身份证正面")
    private Integer cardFront;

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getCardReverse() {
		return cardReverse;
	}

	public void setCardReverse(Integer cardReverse) {
		this.cardReverse = cardReverse;
	}

	public Integer getCardFront() {
		return cardFront;
	}

	public void setCardFront(Integer cardFront) {
		this.cardFront = cardFront;
	}
    
    
}
