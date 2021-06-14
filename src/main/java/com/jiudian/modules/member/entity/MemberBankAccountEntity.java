package com.jiudian.modules.member.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 会员提现账号
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-26 13:10:53
 */
@TableName("ns_member_bank_account")
public class MemberBankAccountEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 会员id
	 */
	private Integer uid;
	/**
	 * 支行信息
	 */
	private String branchBankName;
	/**
	 * 真实姓名
	 */
	private String realname;
	/**
	 * 银行账号
	 */
	private String accountNumber;
	/**
	 * 手机号
	 */
	private String mobile;
	/**
	 * 是否默认账号
	 */
	private Integer isDefault;
	/**
	 * 创建日期
	 */
	private Integer createDate;
	/**
	 * 修改日期
	 */
	private Integer modifyDate;
	/**
	 * 账户类型，1：银行卡，2：微信，3：支付宝
	 */
	private Integer accountType;
	/**
	 * 账户类型名称：银行卡，微信，支付宝
	 */
	private String accountTypeName;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：会员id
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：会员id
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：支行信息
	 */
	public void setBranchBankName(String branchBankName) {
		this.branchBankName = branchBankName;
	}
	/**
	 * 获取：支行信息
	 */
	public String getBranchBankName() {
		return branchBankName;
	}
	/**
	 * 设置：真实姓名
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}
	/**
	 * 获取：真实姓名
	 */
	public String getRealname() {
		return realname;
	}
	/**
	 * 设置：银行账号
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * 获取：银行账号
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：是否默认账号
	 */
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	/**
	 * 获取：是否默认账号
	 */
	public Integer getIsDefault() {
		return isDefault;
	}
	/**
	 * 设置：创建日期
	 */
	public void setCreateDate(Integer createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建日期
	 */
	public Integer getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：修改日期
	 */
	public void setModifyDate(Integer modifyDate) {
		this.modifyDate = modifyDate;
	}
	/**
	 * 获取：修改日期
	 */
	public Integer getModifyDate() {
		return modifyDate;
	}
	/**
	 * 设置：账户类型，1：银行卡，2：微信，3：支付宝
	 */
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	/**
	 * 获取：账户类型，1：银行卡，2：微信，3：支付宝
	 */
	public Integer getAccountType() {
		return accountType;
	}
	/**
	 * 设置：账户类型名称：银行卡，微信，支付宝
	 */
	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}
	/**
	 * 获取：账户类型名称：银行卡，微信，支付宝
	 */
	public String getAccountTypeName() {
		return accountTypeName;
	}
}
