package com.jiudian.modules.member.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 收藏表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-26 13:10:53
 */
@TableName("ns_member_favorites")
public class MemberFavoritesEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 记录ID
	 */
	@TableId
	private Integer logId;
	/**
	 * 会员ID
	 */
	private Integer uid;
	/**
	 * 商品或店铺ID
	 */
	private Integer favId;
	/**
	 * 类型:goods为商品,shop为店铺,默认为商品
	 */
	private String favType;
	/**
	 * 店铺ID
	 */
	private Integer shopId;
	/**
	 * 店铺名称
	 */
	private String shopName;
	/**
	 * 店铺logo
	 */
	private String shopLogo;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 
	 */
	private String goodsImage;
	/**
	 * 商品收藏时价格
	 */
	private BigDecimal logPrice;
	/**
	 * 收藏备注
	 */
	private String logMsg;
	/**
	 * 收藏时间
	 */
	private Integer favTime;

	/**
	 * 设置：记录ID
	 */
	public void setLogId(Integer logId) {
		this.logId = logId;
	}
	/**
	 * 获取：记录ID
	 */
	public Integer getLogId() {
		return logId;
	}
	/**
	 * 设置：会员ID
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：会员ID
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：商品或店铺ID
	 */
	public void setFavId(Integer favId) {
		this.favId = favId;
	}
	/**
	 * 获取：商品或店铺ID
	 */
	public Integer getFavId() {
		return favId;
	}
	/**
	 * 设置：类型:goods为商品,shop为店铺,默认为商品
	 */
	public void setFavType(String favType) {
		this.favType = favType;
	}
	/**
	 * 获取：类型:goods为商品,shop为店铺,默认为商品
	 */
	public String getFavType() {
		return favType;
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
	 * 设置：店铺名称
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	/**
	 * 获取：店铺名称
	 */
	public String getShopName() {
		return shopName;
	}
	/**
	 * 设置：店铺logo
	 */
	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}
	/**
	 * 获取：店铺logo
	 */
	public String getShopLogo() {
		return shopLogo;
	}
	/**
	 * 设置：商品名称
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	/**
	 * 获取：商品名称
	 */
	public String getGoodsName() {
		return goodsName;
	}
	/**
	 * 设置：
	 */
	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}
	/**
	 * 获取：
	 */
	public String getGoodsImage() {
		return goodsImage;
	}
	/**
	 * 设置：商品收藏时价格
	 */
	public void setLogPrice(BigDecimal logPrice) {
		this.logPrice = logPrice;
	}
	/**
	 * 获取：商品收藏时价格
	 */
	public BigDecimal getLogPrice() {
		return logPrice;
	}
	/**
	 * 设置：收藏备注
	 */
	public void setLogMsg(String logMsg) {
		this.logMsg = logMsg;
	}
	/**
	 * 获取：收藏备注
	 */
	public String getLogMsg() {
		return logMsg;
	}
	/**
	 * 设置：收藏时间
	 */
	public void setFavTime(Integer favTime) {
		this.favTime = favTime;
	}
	/**
	 * 获取：收藏时间
	 */
	public Integer getFavTime() {
		return favTime;
	}
}
