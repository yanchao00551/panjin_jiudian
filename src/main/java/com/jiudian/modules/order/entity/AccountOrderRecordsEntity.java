package com.jiudian.modules.order.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 金额账户记录
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:47
 */
@TableName("ns_account_order_records")
public class AccountOrderRecordsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer id;
	/**
	 * 流水号
	 */
	private String serialNo;
	/**
	 * 店铺id
	 */
	private Integer shopId;
	/**
	 * 对应金额
	 */
	private BigDecimal money;
	/**
	 * 账户类型
	 */
	private Integer accountType;
	/**
	 * 关联ID
	 */
	private Integer typeAlisId;
	/**
	 * 简介
	 */
	private String remark;
	/**
	 * 创建时间
	 */
	private Integer createTime;

	/**
	 * 设置：主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：流水号
	 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	/**
	 * 获取：流水号
	 */
	public String getSerialNo() {
		return serialNo;
	}
	/**
	 * 设置：店铺id
	 */
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	/**
	 * 获取：店铺id
	 */
	public Integer getShopId() {
		return shopId;
	}
	/**
	 * 设置：对应金额
	 */
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	/**
	 * 获取：对应金额
	 */
	public BigDecimal getMoney() {
		return money;
	}
	/**
	 * 设置：账户类型
	 */
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	/**
	 * 获取：账户类型
	 */
	public Integer getAccountType() {
		return accountType;
	}
	/**
	 * 设置：关联ID
	 */
	public void setTypeAlisId(Integer typeAlisId) {
		this.typeAlisId = typeAlisId;
	}
	/**
	 * 获取：关联ID
	 */
	public Integer getTypeAlisId() {
		return typeAlisId;
	}
	/**
	 * 设置：简介
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：简介
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Integer getCreateTime() {
		return createTime;
	}
}
