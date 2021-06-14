package com.jiudian.modules.goods.form;


import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;


/*
 * 添加商品规格
 * @author KF-180419
 *
 */

public class AddGoodsSpecForm {
	
	/**
	 * 规格名称
	 */	
	@ApiModelProperty(value = "规格名称")
    @NotNull(message="规格名称")
	private String specName;
	
	/**
	 * 是否启用
	 */
	private Integer isVisible;
	
	/**
	 * 排序
	 */
	private Integer sort;
	
	/**
	 * 展示方式
	 */
	private Integer showType;
	
	/**
	 * 规格值
	 */
	@ApiModelProperty(value = "规格值")
    @NotNull(message="规格值不能为空")
	private String specValueStr;
	
	/**
	 * 说明
	 */
	private String specDes;
	
	/**
	 * 是否参与筛选 0 不参与 1 参与
	 */
	private Integer isScreen;
	
	private Integer attrId;
	
	private Integer specId;
	
	

	public Integer getSpecId() {
		return specId;
	}

	public void setSpecId(Integer specId) {
		this.specId = specId;
	}


	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}

	public Integer getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(Integer isVisible) {
		this.isVisible = isVisible;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getShowType() {
		return showType;
	}

	public void setShowType(Integer showType) {
		this.showType = showType;
	}

	public String getSpecValueStr() {
		return specValueStr;
	}

	public void setSpecValueStr(String specValueStr) {
		this.specValueStr = specValueStr;
	}

	public String getSpecDes() {
		return specDes;
	}

	public void setSpecDes(String specDes) {
		this.specDes = specDes;
	}

	public Integer getIsScreen() {
		return isScreen;
	}

	public void setIsScreen(Integer isScreen) {
		this.isScreen = isScreen;
	}

	public Integer getAttrId() {
		return attrId;
	}

	public void setAttrId(Integer attrId) {
		this.attrId = attrId;
	}
	
	
}
