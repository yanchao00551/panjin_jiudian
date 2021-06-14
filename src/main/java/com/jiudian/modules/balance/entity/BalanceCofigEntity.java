package com.jiudian.modules.balance.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 余额设置表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-22 08:46:17
 */
@TableName("ns_balance_cofig")
public class BalanceCofigEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer id;
	/**
	 * 店铺ID
	 */
	private Integer shopId;
	/**
	 * 是否启动
	 */
	private Integer isOpen;
	/**
	 * 1余额对应积分
	 */
	private BigDecimal convertRate;
	/**
	 * 积分说明
	 */
	private String desc;
	/**
	 * 创建时间
	 */
	private Integer createTime;
	/**
	 * 修改时间
	 */
	private Integer modifyTime;

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
	 * 设置：是否启动
	 */
	public void setIsOpen(Integer isOpen) {
		this.isOpen = isOpen;
	}
	/**
	 * 获取：是否启动
	 */
	public Integer getIsOpen() {
		return isOpen;
	}
	/**
	 * 设置：1余额对应积分
	 */
	public void setConvertRate(BigDecimal convertRate) {
		this.convertRate = convertRate;
	}
	/**
	 * 获取：1余额对应积分
	 */
	public BigDecimal getConvertRate() {
		return convertRate;
	}
	/**
	 * 设置：积分说明
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * 获取：积分说明
	 */
	public String getDesc() {
		return desc;
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
	/**
	 * 设置：修改时间
	 */
	public void setModifyTime(Integer modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Integer getModifyTime() {
		return modifyTime;
	}
}
