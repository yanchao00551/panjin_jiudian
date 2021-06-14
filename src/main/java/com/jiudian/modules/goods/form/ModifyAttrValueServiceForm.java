package com.jiudian.modules.goods.form;

import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModelProperty;


/**
 * 实时更新属性值表单
 * @author KF-180419
 *
 */

public class ModifyAttrValueServiceForm {
	

	/**
	 * 属性值ID
	 */
	@ApiModelProperty(value = "属性值id")
    @NotNull(message="属性值id不能为空")
	private Integer attrValueId;
	
	/**
	 * 更新列名
	 */
	@ApiModelProperty(value = " 更新列名")
    @NotNull(message=" 更新列名不能为空")
	private String fieldName;
	
	/**
	 * 更新列值
	 */
	@ApiModelProperty(value = " 更新列值")
    @NotNull(message=" 更新列值不能为空")
	private String fieldValue;

	public Integer getAttrValueId() {
		return attrValueId;
	}

	public void setAttrValueId(Integer attrValueId) {
		this.attrValueId = attrValueId;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(String fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	
}
