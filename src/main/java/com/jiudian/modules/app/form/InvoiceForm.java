package com.jiudian.modules.app.form;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 发票表单
 * 
 *
 */
@ApiModel(value = "订单表单")
public class InvoiceForm {
	@ApiModelProperty(value = "发票ID")
    @NotNull(message="发票ID不能为空")
	private int invoiceId;
	
	@ApiModelProperty(value = "是否公司发票")
    @NotNull(message="是否公司发票不能为空")
	private int isCpmpany;
	
	@ApiModelProperty(value = "发票类型")
    @NotNull(message="发票类型不能为空")
	private int invoiceType;
	
	@ApiModelProperty(value = "企业名称")
    @NotNull(message="企业名称不能为空")
	private String companyName;
	
	@ApiModelProperty(value = "纳税人识别编号")
	private String taxpayerCode;
	
	@ApiModelProperty(value = "统一社会信用代码")
	private String socialCreditCode;
	
	@ApiModelProperty(value = "公司注册地址")
	private String companyAddress;
	
	@ApiModelProperty(value = "联系电话")
	private String telNum;
	
	@ApiModelProperty(value = "对外付款开户行")
	private String bank;
	
	@ApiModelProperty(value = "对外付款银行账号")
	private String bankAccount;
	
	@ApiModelProperty(value = "用户ID")
    @NotNull(message="用户ID不能为空")
	private int uid;

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public int getIsCpmpany() {
		return isCpmpany;
	}

	public void setIsCpmpany(int isCpmpany) {
		this.isCpmpany = isCpmpany;
	}

	public int getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(int invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getTaxpayerCode() {
		return taxpayerCode;
	}

	public void setTaxpayerCode(String taxpayerCode) {
		this.taxpayerCode = taxpayerCode;
	}

	public String getSocialCreditCode() {
		return socialCreditCode;
	}

	public void setSocialCreditCode(String socialCreditCode) {
		this.socialCreditCode = socialCreditCode;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getTelNum() {
		return telNum;
	}

	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
	
}
