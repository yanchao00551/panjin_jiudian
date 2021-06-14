package com.jiudian.modules.goods.entity;

import java.util.List;

/**
 * 后台商品属性vue前端动态表单
 * @author Mr.Yan
 *
 */

public class FormDynamic{
	private String type;
	private String label;
	private boolean disable;
	private boolean readonly;
	private String value;
	private String placeholder;
	private String rules;
	private String key;
	private String subtype;
	private boolean button;
	private boolean border;
	private String [] options;
	private List<AttrModel> models;
	private String [] arrValue;  //checkbox v-model
	private Integer attrValueId;
	private int sort;         
	
	
	
	public Integer getAttrValueId() {
		return attrValueId;
	}



	public void setAttrValueId(Integer attrValueId) {
		this.attrValueId = attrValueId;
	}



	public int getSort() {
		return sort;
	}



	public void setSort(int sort) {
		this.sort = sort;
	}



	public FormDynamic() {
		this.disable = false;
		this.readonly = false;
		this.value = "";
		this.button = false;
		this.border = true;
	}
	
	
	
	public String[] getArrValue() {
		return arrValue;
	}



	public void setArrValue(String[] arrValue) {
		this.arrValue = arrValue;
	}



	public boolean isButton() {
		return button;
	}

	public void setButton(boolean button) {
		this.button = button;
	}

	public boolean isBorder() {
		return border;
	}

	public void setBorder(boolean border) {
		this.border = border;
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public boolean isDisable() {
		return disable;
	}
	public void setDisable(boolean disable) {
		this.disable = disable;
	}
	public boolean isReadonly() {
		return readonly;
	}
	public void setReadonly(boolean readonly) {
		this.readonly = readonly;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getPlaceholder() {
		return placeholder;
	}
	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	public String getRules() {
		return rules;
	}
	public void setRules(String rules) {
		this.rules = rules;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getSubtype() {
		return subtype;
	}
	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}



	public List<AttrModel> getModels() {
		return models;
	}



	public void setModels(List<AttrModel> models) {
		this.models = models;
	}
	
	
	
}