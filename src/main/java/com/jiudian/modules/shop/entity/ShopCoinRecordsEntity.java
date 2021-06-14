package com.jiudian.modules.shop.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 店铺购物币记录
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 13:58:02
 */
@TableName("ns_shop_coin_records")
public class ShopCoinRecordsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 店铺ID
	 */
	private Integer shopId;
	/**
	 * 购物币数量
	 */
	private BigDecimal num;
	/**
	 * 增加或减少类型
	 */
	private Integer accountType;
	/**
	 * 关联ID
	 */
	private Integer typeAlisId;
	/**
	 * 是否显示
	 */
	private Integer isDisplay;
	/**
	 * 简介
	 */
	private String text;
	/**
	 * 创建时间
	 */
	private Integer createTime;

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
	 * 设置：购物币数量
	 */
	public void setNum(BigDecimal num) {
		this.num = num;
	}
	/**
	 * 获取：购物币数量
	 */
	public BigDecimal getNum() {
		return num;
	}
	/**
	 * 设置：增加或减少类型
	 */
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	/**
	 * 获取：增加或减少类型
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
	 * 设置：是否显示
	 */
	public void setIsDisplay(Integer isDisplay) {
		this.isDisplay = isDisplay;
	}
	/**
	 * 获取：是否显示
	 */
	public Integer getIsDisplay() {
		return isDisplay;
	}
	/**
	 * 设置：简介
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * 获取：简介
	 */
	public String getText() {
		return text;
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
