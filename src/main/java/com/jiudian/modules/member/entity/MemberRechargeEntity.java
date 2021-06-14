package com.jiudian.modules.member.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 会员充值余额记录
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-26 13:10:53
 */
@TableName("ns_member_recharge")
public class MemberRechargeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 支付金额
	 */
	private BigDecimal rechargeMoney;
	/**
	 * 用户uid
	 */
	private String uid;
	/**
	 * 支付流水号
	 */
	private String outTradeNo;
	/**
	 * 创建时间
	 */
	private String createTime;
	/**
	 * 是否支付
	 */
	private String isPay;
	/**
	 * 状态
	 */
	private String status;

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
	 * 设置：支付金额
	 */
	public void setRechargeMoney(BigDecimal rechargeMoney) {
		this.rechargeMoney = rechargeMoney;
	}
	/**
	 * 获取：支付金额
	 */
	public BigDecimal getRechargeMoney() {
		return rechargeMoney;
	}
	/**
	 * 设置：用户uid
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * 获取：用户uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * 设置：支付流水号
	 */
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	/**
	 * 获取：支付流水号
	 */
	public String getOutTradeNo() {
		return outTradeNo;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public String getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIsPay() {
		return isPay;
	}
	/**
	 * 设置：状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * 获取：状态
	 */
	public String getStatus() {
		return status;
	}
}
