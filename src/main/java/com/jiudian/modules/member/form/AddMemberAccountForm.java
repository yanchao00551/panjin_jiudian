package com.jiudian.modules.member.form;


import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;


/**
 * 调整积分或余额
 * @author KF-180419
 *
 */

public class AddMemberAccountForm {
	@ApiModelProperty(value = "ID")
    @NotNull(message="ID不能为空")
	private Integer id;
	
	@ApiModelProperty(value = "type")
    @NotNull(message="type不能为空")
	private Integer type;

	@ApiModelProperty(value = "num")
    @NotNull(message="num不能为空")
	private BigDecimal num;
	
	/**
	 * 备注
	 */
	private String text;
	
	private Integer shopId;
	
	

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public BigDecimal getNum() {
		return num;
	}

	public void setNum(BigDecimal num) {
		this.num = num;
	}
	
}
