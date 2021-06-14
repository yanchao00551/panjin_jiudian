package com.jiudian.modules.goods.form;


import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;


/**
 * 新增商品类型
 * @author KF-180419
 *
 */

public class AddAttributeServiceForm {
	
	/**
	 * 属性ID
	 */
	private Integer attrId;
	
	/**
	 * 类型名称
	 */
	@ApiModelProperty(value = "类型名称")
    @NotNull(message="类型名称不能为空")
	private String attrName;
	
	/**
	 * 是否启用
	 */
	private Integer isUse;

	/**
	 * 排序
	 */
	private Integer sort;
	
	/**
	 * 关联规格
	 */
	private String selectBox;
	
	/**
	 * 关联品牌
	 */
	private String selectBrank;
	
	/**
	 * 属性键值对
	 * @return
	 */
	private String dataObjStr;
	
	/**
	 * 值ID
	 */
	private Integer attrValueId;
	
	


	public Integer getAttrValueId() {
		return attrValueId;
	}

	public void setAttrValueId(Integer attrValueId) {
		this.attrValueId = attrValueId;
	}

	public Integer getAttrId() {
		return attrId;
	}

	public void setAttrId(Integer attrId) {
		this.attrId = attrId;
	}

	public String getDataObjStr() {
		return dataObjStr;
	}

	public void setDataObjStr(String dataObjStr) {
		this.dataObjStr = dataObjStr;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	

	public Integer getIsUse() {
		return isUse;
	}

	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getSelectBox() {
		return selectBox;
	}

	public void setSelectBox(String selectBox) {
		this.selectBox = selectBox;
	}

	public String getSelectBrank() {
		return selectBrank;
	}

	public void setSelectBrank(String selectBrank) {
		this.selectBrank = selectBrank;
	}
	
	
}
