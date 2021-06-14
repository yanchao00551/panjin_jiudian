package com.jiudian.modules.cart.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.goods.entity.GoodsAttributeEntity;

/**
 * 购物车表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-28 10:13:44
 */
@TableName("ns_cart")
public class CartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 购物车id
	 */
	@TableId
	private Integer cartId;
	/**
	 * 买家id
	 */
	private Integer buyerId;
	/**
	 * 店铺id
	 */
	private Integer shopId;
	/**
	 * 店铺名称
	 */
	private String shopName;
	/**
	 * 商品id
	 */
	private Integer goodsId;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品的skuid
	 */
	private Integer skuId;
	/**
	 * 商品的sku名称
	 */
	private String skuName;
	/**
	 * 商品价格
	 */
	private BigDecimal price;
	/**
	 * 购买商品数量
	 */
	private Integer num;
	/**
	 * 商品图片
	 */
	private Integer goodsPicture;
	/**
	 * 组合套装ID
	 */
	private Integer blId;
	
	/**
	 * 类型
	 */
	private Integer type;
	/**
	 * 住店日期
	 */
	private Integer intoStore;
	/**
	 * 离店日期
	 */
	private Integer leaveStore;
	
	private int maxUsePoint;
	
	
	/*----- other -----*/
	@TableField(exist = false)
	private AlbumPictureEntity pictureInfo;
	
	/**
	 * 相差天数
	 */
	@TableField(exist = false)
	private Integer badDay;
	
	/**
	 * 商品属性信息
	 */
	@TableField(exist = false)
	private GoodsAttributeEntity goodsAttributeEntity;


	public Integer getBadDay() {
		return badDay;
	}
	public void setBadDay(Integer badDay) {
		this.badDay = badDay;
	}
	public Integer getIntoStore() {
		return intoStore;
	}
	public void setIntoStore(Integer intoStore) {
		this.intoStore = intoStore;
	}
	public Integer getLeaveStore() {
		return leaveStore;
	}
	public void setLeaveStore(Integer leaveStore) {
		this.leaveStore = leaveStore;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public AlbumPictureEntity getPictureInfo() {
		return pictureInfo;
	}
	public void setPictureInfo(AlbumPictureEntity pictureInfo) {
		this.pictureInfo = pictureInfo;
	}
	/**
	 * 设置：购物车id
	 */
	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}
	/**
	 * 获取：购物车id
	 */
	public Integer getCartId() {
		return cartId;
	}
	/**
	 * 设置：买家id
	 */
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	/**
	 * 获取：买家id
	 */
	public Integer getBuyerId() {
		return buyerId;
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
	 * 设置：商品id
	 */
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	/**
	 * 获取：商品id
	 */
	public Integer getGoodsId() {
		return goodsId;
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
	 * 设置：商品的skuid
	 */
	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}
	/**
	 * 获取：商品的skuid
	 */
	public Integer getSkuId() {
		return skuId;
	}
	/**
	 * 设置：商品的sku名称
	 */
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	/**
	 * 获取：商品的sku名称
	 */
	public String getSkuName() {
		return skuName;
	}
	/**
	 * 设置：商品价格
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：商品价格
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：购买商品数量
	 */
	public void setNum(Integer num) {
		this.num = num;
	}
	/**
	 * 获取：购买商品数量
	 */
	public Integer getNum() {
		return num;
	}
	/**
	 * 设置：商品图片
	 */
	public void setGoodsPicture(Integer goodsPicture) {
		this.goodsPicture = goodsPicture;
	}
	/**
	 * 获取：商品图片
	 */
	public Integer getGoodsPicture() {
		return goodsPicture;
	}
	/**
	 * 设置：组合套装ID
	 */
	public void setBlId(Integer blId) {
		this.blId = blId;
	}
	/**
	 * 获取：组合套装ID
	 */
	public Integer getBlId() {
		return blId;
	}
	public GoodsAttributeEntity getGoodsAttributeEntity() {
		return goodsAttributeEntity;
	}
	public void setGoodsAttributeEntity(GoodsAttributeEntity goodsAttributeEntity) {
		this.goodsAttributeEntity = goodsAttributeEntity;
	}
	public int getMaxUsePoint() {
		return maxUsePoint;
	}
	public void setMaxUsePoint(int maxUsePoint) {
		this.maxUsePoint = maxUsePoint;
	}
}
