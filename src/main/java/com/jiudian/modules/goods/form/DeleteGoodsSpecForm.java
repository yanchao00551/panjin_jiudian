package com.jiudian.modules.goods.form;


import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;


/**
 * 删除商品规格表单
 * @author KF-180419
 *
 */

public class DeleteGoodsSpecForm {
	
	/**
	 * 规格ID
	 */	
	@ApiModelProperty(value = "商品规格ID")
    @NotNull(message="商品规格ID不能为空")
	private Integer specId;

	public Integer getSpecId() {
		return specId;
	}

	public void setSpecId(Integer specId) {
		this.specId = specId;
	}

	

	
}
