package com.jiudian.modules.member.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 会员余额提现记录表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-26 13:10:53
 */
@TableName("ns_member_balance_withdraw")
public class MemberBalanceWithdrawEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 店铺编号
	 */
	private Integer shopId;
	/**
	 * 提现流水号
	 */
	private String withdrawNo;
	/**
	 * 会员id
	 */
	private Integer uid;
	/**
	 * 提现银行名称
	 */
	private String bankName;
	/**
	 * 提现银行账号
	 */
	private String accountNumber;
	/**
	 * 提现账户姓名
	 */
	private String realname;
	/**
	 * 手机
	 */
	private String mobile;
	/**
	 * 提现金额
	 */
	private BigDecimal cash;
	/**
	 * 当前状态 0已申请(等待处理) 1已同意 -1 已拒绝
	 */
	private Integer status;
	/**
	 * 备注
	 */
	private String memo;
	/**
	 * 提现日期
	 */
	private Integer askForDate;
	/**
	 * 到账日期
	 */
	private Integer paymentDate;
	/**
	 * 修改日期
	 */
	private Integer modifyDate;
	/**
	 * 转账方式   1 线下转账  2线上转账
	 */
	private Integer transferType;
	/**
	 * 转账银行名称
	 */
	private String transferName;
	/**
	 * 转账金额
	 */
	private BigDecimal transferMoney;
	/**
	 * 转账状态 0未转账 1已转账 -1转账失败
	 */
	private Integer transferStatus;
	/**
	 * 转账备注
	 */
	private String transferRemark;
	/**
	 * 转账结果
	 */
	private String transferResult;
	/**
	 * 转账流水号
	 */
	private String transferNo;
	/**
	 * 转账银行账号
	 */
	private String transferAccountNo;
	
	/**
	 * 提现流水号
	 * 
	 */
	private Integer flowId;
	

	/* ----- */
	@TableField(exist = false)
	private String username;
	
	@TableField(exist = false)
	private String realName;
	
	@TableField(exist = false)
	private int accountType;
	
	
	
	public Integer getFlowId() {
		return flowId;
	}
	public void setFlowId(Integer flowId) {
		this.flowId = flowId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
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
	 * 设置：店铺编号
	 */
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	/**
	 * 获取：店铺编号
	 */
	public Integer getShopId() {
		return shopId;
	}
	/**
	 * 设置：提现流水号
	 */
	public void setWithdrawNo(String withdrawNo) {
		this.withdrawNo = withdrawNo;
	}
	/**
	 * 获取：提现流水号
	 */
	public String getWithdrawNo() {
		return withdrawNo;
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
	 * 设置：提现银行名称
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * 获取：提现银行名称
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * 设置：提现银行账号
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * 获取：提现银行账号
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	/**
	 * 设置：提现账户姓名
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}
	/**
	 * 获取：提现账户姓名
	 */
	public String getRealname() {
		return realname;
	}
	/**
	 * 设置：手机
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：提现金额
	 */
	public void setCash(BigDecimal cash) {
		this.cash = cash;
	}
	/**
	 * 获取：提现金额
	 */
	public BigDecimal getCash() {
		return cash;
	}
	/**
	 * 设置：当前状态 0已申请(等待处理) 1已同意 -1 已拒绝
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：当前状态 0已申请(等待处理) 1已同意 -1 已拒绝
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：备注
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**
	 * 获取：备注
	 */
	public String getMemo() {
		return memo;
	}
	/**
	 * 设置：提现日期
	 */
	public void setAskForDate(Integer askForDate) {
		this.askForDate = askForDate;
	}
	/**
	 * 获取：提现日期
	 */
	public Integer getAskForDate() {
		return askForDate;
	}
	/**
	 * 设置：到账日期
	 */
	public void setPaymentDate(Integer paymentDate) {
		this.paymentDate = paymentDate;
	}
	/**
	 * 获取：到账日期
	 */
	public Integer getPaymentDate() {
		return paymentDate;
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
	 * 设置：转账方式   1 线下转账  2线上转账
	 */
	public void setTransferType(Integer transferType) {
		this.transferType = transferType;
	}
	/**
	 * 获取：转账方式   1 线下转账  2线上转账
	 */
	public Integer getTransferType() {
		return transferType;
	}
	/**
	 * 设置：转账银行名称
	 */
	public void setTransferName(String transferName) {
		this.transferName = transferName;
	}
	/**
	 * 获取：转账银行名称
	 */
	public String getTransferName() {
		return transferName;
	}
	/**
	 * 设置：转账金额
	 */
	public void setTransferMoney(BigDecimal transferMoney) {
		this.transferMoney = transferMoney;
	}
	/**
	 * 获取：转账金额
	 */
	public BigDecimal getTransferMoney() {
		return transferMoney;
	}
	/**
	 * 设置：转账状态 0未转账 1已转账 -1转账失败
	 */
	public void setTransferStatus(Integer transferStatus) {
		this.transferStatus = transferStatus;
	}
	/**
	 * 获取：转账状态 0未转账 1已转账 -1转账失败
	 */
	public Integer getTransferStatus() {
		return transferStatus;
	}
	/**
	 * 设置：转账备注
	 */
	public void setTransferRemark(String transferRemark) {
		this.transferRemark = transferRemark;
	}
	/**
	 * 获取：转账备注
	 */
	public String getTransferRemark() {
		return transferRemark;
	}
	/**
	 * 设置：转账结果
	 */
	public void setTransferResult(String transferResult) {
		this.transferResult = transferResult;
	}
	/**
	 * 获取：转账结果
	 */
	public String getTransferResult() {
		return transferResult;
	}
	/**
	 * 设置：转账流水号
	 */
	public void setTransferNo(String transferNo) {
		this.transferNo = transferNo;
	}
	/**
	 * 获取：转账流水号
	 */
	public String getTransferNo() {
		return transferNo;
	}
	/**
	 * 设置：转账银行账号
	 */
	public void setTransferAccountNo(String transferAccountNo) {
		this.transferAccountNo = transferAccountNo;
	}
	/**
	 * 获取：转账银行账号
	 */
	public String getTransferAccountNo() {
		return transferAccountNo;
	}
	public int getAccountType() {
		return accountType;
	}
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
}
