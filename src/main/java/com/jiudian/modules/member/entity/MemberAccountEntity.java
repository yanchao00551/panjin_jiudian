package com.jiudian.modules.member.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * 会员账户统计表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-26 13:10:53
 */
@TableName("ns_member_account")
public class MemberAccountEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 会员uid
	 */
	private Integer uid;
	/**
	 * 店铺ID
	 */
	private Integer shopId;
	/**
	 * 会员积分
	 */
	private Integer point;
	/**
	 * 余额
	 */
	private BigDecimal balance;
	/**
	 * 购物币
	 */
	private Integer coin;
	/**
	 * 会员消费
	 */
	private BigDecimal memberCunsum;
	/**
	 * 会员累计积分
	 */
	private Integer memberSumPoint;

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
	 * 设置：会员uid
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：会员uid
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：店铺ID
	 */
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	/**
	 * 获取：店铺ID
	 */
	public Integer getShopId() {
		return shopId;
	}
	/**
	 * 设置：会员积分
	 */
	public void setPoint(Integer point) {
		this.point = point;
	}
	/**
	 * 获取：会员积分
	 */
	public Integer getPoint() {
		return point;
	}
	/**
	 * 设置：余额
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	/**
	 * 获取：余额
	 */
	public BigDecimal getBalance() {
		return balance;
	}
	/**
	 * 设置：购物币
	 */
	public void setCoin(Integer coin) {
		this.coin = coin;
	}
	/**
	 * 获取：购物币
	 */
	public Integer getCoin() {
		return coin;
	}
	/**
	 * 设置：会员消费
	 */
	public void setMemberCunsum(BigDecimal memberCunsum) {
		this.memberCunsum = memberCunsum;
	}
	/**
	 * 获取：会员消费
	 */
	public BigDecimal getMemberCunsum() {
		return memberCunsum;
	}
	/**
	 * 设置：会员累计积分
	 */
	public void setMemberSumPoint(Integer memberSumPoint) {
		this.memberSumPoint = memberSumPoint;
	}
	/**
	 * 获取：会员累计积分
	 */
	public Integer getMemberSumPoint() {
		return memberSumPoint;
	}
}
