package com.jiudian.modules.sms.form;

/**
 * 短信配置表单
 * @author KF-180419
 *
 */
public class SmsconfigForm {
	/**
	 * 是否开启
	 */
	private String key;
	/**
	 * 配置json值
	 */
	private String value;
	/**
	 * 是否启用
	 * @return
	 */
	private Boolean isUse;
	
	/**
	 * 时间戳
	 * @return
	 */
	private String t;

	public Boolean getIsUse() {
		return isUse;
	}
	public void setIsUse(Boolean isUse) {
		this.isUse = isUse;
	}
	public String getT() {
		return t;
	}
	public void setT(String t) {
		this.t = t;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
