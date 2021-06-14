package com.jiudian.modules.goods.form;


import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;


/**
 * 删除商品类型
 * @author KF-180419
 *
 */

public class DeleteAttrForm {
	
	/**
	 * 属性ID
	 */	
	@ApiModelProperty(value = "属性ID")
    @NotNull(message="属性ID")
	private Integer attrId;

	public Integer getAttrId() {
		return attrId;
	}

	public void setAttrId(Integer attrId) {
		this.attrId = attrId;
	}
	
	
	
}
