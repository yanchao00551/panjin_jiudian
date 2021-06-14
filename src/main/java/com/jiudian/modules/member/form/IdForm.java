package com.jiudian.modules.member.form;


import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;


/**
 * 调整积分或余额
 * @author KF-180419
 *
 */

public class IdForm {
	@ApiModelProperty(value = "ID")
    @NotNull(message="ID不能为空")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
