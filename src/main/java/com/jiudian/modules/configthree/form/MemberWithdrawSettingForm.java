package com.jiudian.modules.configthree.form;


import java.math.BigDecimal;
import java.util.List;
import java.util.Map;


/**
 * 会员提现设置表单
 * @author KF-180419
 *
 */

public class MemberWithdrawSettingForm {

	private Integer shopId;
	
	/**
	 * 提现账户 1.银行卡 2.微信 3.支付宝
	 */
	private String withdrawAccount;
	
	/**
	 * 最低提现金额
	 */
	private BigDecimal cashMin;
	
	/**
	 * 提现倍数
	 */
	private Integer multiple;
	
	/**
	 * 提现提示信息
	 */
	private String message;
	
	/**
	 * 是否使用
	 */
	private Integer isUse;
	
	private List<Map<String,Object>> withdrawAccountMap;
	

	public List<Map<String, Object>> getWithdrawAccountMap() {
		return withdrawAccountMap;
	}

	public void setWithdrawAccountMap(List<Map<String, Object>> withdrawAccountMap) {
		this.withdrawAccountMap = withdrawAccountMap;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getWithdrawAccount() {
		return withdrawAccount;
	}

	public void setWithdrawAccount(String withdrawAccount) {
		this.withdrawAccount = withdrawAccount;
	}

	public BigDecimal getCashMin() {
		return cashMin;
	}

	public void setCashMin(BigDecimal cashMin) {
		this.cashMin = cashMin;
	}

	public Integer getMultiple() {
		return multiple;
	}

	public void setMultiple(Integer multiple) {
		this.multiple = multiple;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getIsUse() {
		return isUse;
	}

	public void setIsUse(Integer isUse) {
		this.isUse = isUse;
	}
	
	
	
}

