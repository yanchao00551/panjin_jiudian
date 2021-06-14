package com.jiudian.modules.invoice.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 
 * 
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-09-29 15:29:06
 */
@TableName("ns_user_invoice")
public class UserInvoiceEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 发票ID
	 */
	@TableId
	private Integer invoiceId;
	/**
	 * 是否公司发票0公司1个人
	 */
	private Integer isCompany;
	/**
	 * 发票类型0增值税普票1增值税专票
	 */
	private Integer invoiceType;
	/**
	 * 企业名称（个人发票时为开票人姓名）
	 */
	private String companyName;
	/**
	 * 纳税人识别编号
	 */
	private String taxpayerCode;
	/**
	 * 统一社会信用代码
	 */
	private String socialCreditCode;
	/**
	 * 公司注册地址
	 */
	private String companyAddress;
	/**
	 * 联系电话
	 */
	private String telNum;
	/**
	 * 对外付款开户行
	 */
	private String bank;
	/**
	 * 对外付款银行账号
	 */
	private String bankAccount;
	/**
	 * 用户ID
	 */
	private Integer uid;

	/**
	 * 设置：发票ID
	 */
	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}
	/**
	 * 获取：发票ID
	 */
	public Integer getInvoiceId() {
		return invoiceId;
	}
	/**
	 * 设置：是否公司发票0公司1个人
	 */
	public void setIsCompany(Integer isCompany) {
		this.isCompany = isCompany;
	}
	/**
	 * 获取：是否公司发票0公司1个人
	 */
	public Integer getIsCompany() {
		return isCompany;
	}
	/**
	 * 设置：发票类型0增值税普票1增值税专票
	 */
	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
	}
	/**
	 * 获取：发票类型0增值税普票1增值税专票
	 */
	public Integer getInvoiceType() {
		return invoiceType;
	}
	/**
	 * 设置：企业名称（个人发票时为开票人姓名）
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 获取：企业名称（个人发票时为开票人姓名）
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * 设置：纳税人识别编号
	 */
	public void setTaxpayerCode(String taxpayerCode) {
		this.taxpayerCode = taxpayerCode;
	}
	/**
	 * 获取：纳税人识别编号
	 */
	public String getTaxpayerCode() {
		return taxpayerCode;
	}
	/**
	 * 设置：统一社会信用代码
	 */
	public void setSocialCreditCode(String socialCreditCode) {
		this.socialCreditCode = socialCreditCode;
	}
	/**
	 * 获取：统一社会信用代码
	 */
	public String getSocialCreditCode() {
		return socialCreditCode;
	}
	/**
	 * 设置：公司注册地址
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	/**
	 * 获取：公司注册地址
	 */
	public String getCompanyAddress() {
		return companyAddress;
	}
	/**
	 * 设置：联系电话
	 */
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	/**
	 * 获取：联系电话
	 */
	public String getTelNum() {
		return telNum;
	}
	/**
	 * 设置：对外付款开户行
	 */
	public void setBank(String bank) {
		this.bank = bank;
	}
	/**
	 * 获取：对外付款开户行
	 */
	public String getBank() {
		return bank;
	}
	/**
	 * 设置：对外付款银行账号
	 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	/**
	 * 获取：对外付款银行账号
	 */
	public String getBankAccount() {
		return bankAccount;
	}
	/**
	 * 设置：用户ID
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：用户ID
	 */
	public Integer getUid() {
		return uid;
	}
}
