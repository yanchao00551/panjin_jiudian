package com.jiudian.modules.shop.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 店铺分享内容设置
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 13:58:03
 */
@TableName("ns_shop_weixin_share")
public class ShopWeixinShareEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer shopId;
	/**
	 * 商品分享价格标示
	 */
	private String goodsParam1;
	/**
	 * 商品分享内容
	 */
	private String goodsParam2;
	/**
	 * 店铺分享标题
	 */
	private String shopParam1;
	/**
	 * 店铺分享主题
	 */
	private String shopParam2;
	/**
	 * 店铺分享内容
	 */
	private String shopParam3;
	/**
	 * 二维码分享主题
	 */
	private String qrcodeParam1;
	/**
	 * 二维码分享内容
	 */
	private String qrcodeParam2;

	/**
	 * 设置：
	 */
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	/**
	 * 获取：
	 */
	public Integer getShopId() {
		return shopId;
	}
	/**
	 * 设置：商品分享价格标示
	 */
	public void setGoodsParam1(String goodsParam1) {
		this.goodsParam1 = goodsParam1;
	}
	/**
	 * 获取：商品分享价格标示
	 */
	public String getGoodsParam1() {
		return goodsParam1;
	}
	/**
	 * 设置：商品分享内容
	 */
	public void setGoodsParam2(String goodsParam2) {
		this.goodsParam2 = goodsParam2;
	}
	/**
	 * 获取：商品分享内容
	 */
	public String getGoodsParam2() {
		return goodsParam2;
	}
	/**
	 * 设置：店铺分享标题
	 */
	public void setShopParam1(String shopParam1) {
		this.shopParam1 = shopParam1;
	}
	/**
	 * 获取：店铺分享标题
	 */
	public String getShopParam1() {
		return shopParam1;
	}
	/**
	 * 设置：店铺分享主题
	 */
	public void setShopParam2(String shopParam2) {
		this.shopParam2 = shopParam2;
	}
	/**
	 * 获取：店铺分享主题
	 */
	public String getShopParam2() {
		return shopParam2;
	}
	/**
	 * 设置：店铺分享内容
	 */
	public void setShopParam3(String shopParam3) {
		this.shopParam3 = shopParam3;
	}
	/**
	 * 获取：店铺分享内容
	 */
	public String getShopParam3() {
		return shopParam3;
	}
	/**
	 * 设置：二维码分享主题
	 */
	public void setQrcodeParam1(String qrcodeParam1) {
		this.qrcodeParam1 = qrcodeParam1;
	}
	/**
	 * 获取：二维码分享主题
	 */
	public String getQrcodeParam1() {
		return qrcodeParam1;
	}
	/**
	 * 设置：二维码分享内容
	 */
	public void setQrcodeParam2(String qrcodeParam2) {
		this.qrcodeParam2 = qrcodeParam2;
	}
	/**
	 * 获取：二维码分享内容
	 */
	public String getQrcodeParam2() {
		return qrcodeParam2;
	}
}
