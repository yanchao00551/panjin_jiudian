package com.jiudian.modules.goods.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 商品skui规格价格库存信息回收站表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:53
 */
@TableName("ns_goods_sku_deleted")
public class GoodsSkuDeletedEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 表序号
	 */
	@TableId
	private Integer skuId;
	/**
	 * 商品编号
	 */
	private Integer goodsId;
	/**
	 * SKU名称
	 */
	private String skuName;
	/**
	 * 属性和属性值 id串 attribute + attribute value 表ID分号分隔
	 */
	private String attrValueItems;
	/**
	 * 属性和属性值id串组合json格式
	 */
	private String attrValueItemsFormat;
	/**
	 * 市场价
	 */
	private BigDecimal marketPrice;
	/**
	 * 价格
	 */
	private BigDecimal price;
	/**
	 * 促销价格
	 */
	private BigDecimal promotePrice;
	/**
	 * 成本价
	 */
	private BigDecimal costPrice;
	/**
	 * 库存
	 */
	private Integer stock;
	/**
	 * 如果是第一个sku编码, 可以加图片
	 */
	private Integer picture;
	/**
	 * 商家编码
	 */
	private String code;
	/**
	 * 商品二维码
	 */
	private String qrcode;
	/**
	 * 创建时间
	 */
	private Integer createDate;
	/**
	 * 修改时间
	 */
	private Integer updateDate;

	/**
	 * 设置：表序号
	 */
	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}
	/**
	 * 获取：表序号
	 */
	public Integer getSkuId() {
		return skuId;
	}
	/**
	 * 设置：商品编号
	 */
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	/**
	 * 获取：商品编号
	 */
	public Integer getGoodsId() {
		return goodsId;
	}
	/**
	 * 设置：SKU名称
	 */
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	/**
	 * 获取：SKU名称
	 */
	public String getSkuName() {
		return skuName;
	}
	/**
	 * 设置：属性和属性值 id串 attribute + attribute value 表ID分号分隔
	 */
	public void setAttrValueItems(String attrValueItems) {
		this.attrValueItems = attrValueItems;
	}
	/**
	 * 获取：属性和属性值 id串 attribute + attribute value 表ID分号分隔
	 */
	public String getAttrValueItems() {
		return attrValueItems;
	}
	/**
	 * 设置：属性和属性值id串组合json格式
	 */
	public void setAttrValueItemsFormat(String attrValueItemsFormat) {
		this.attrValueItemsFormat = attrValueItemsFormat;
	}
	/**
	 * 获取：属性和属性值id串组合json格式
	 */
	public String getAttrValueItemsFormat() {
		return attrValueItemsFormat;
	}
	/**
	 * 设置：市场价
	 */
	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}
	/**
	 * 获取：市场价
	 */
	public BigDecimal getMarketPrice() {
		return marketPrice;
	}
	/**
	 * 设置：价格
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：价格
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：促销价格
	 */
	public void setPromotePrice(BigDecimal promotePrice) {
		this.promotePrice = promotePrice;
	}
	/**
	 * 获取：促销价格
	 */
	public BigDecimal getPromotePrice() {
		return promotePrice;
	}
	/**
	 * 设置：成本价
	 */
	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}
	/**
	 * 获取：成本价
	 */
	public BigDecimal getCostPrice() {
		return costPrice;
	}
	/**
	 * 设置：库存
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	/**
	 * 获取：库存
	 */
	public Integer getStock() {
		return stock;
	}
	/**
	 * 设置：如果是第一个sku编码, 可以加图片
	 */
	public void setPicture(Integer picture) {
		this.picture = picture;
	}
	/**
	 * 获取：如果是第一个sku编码, 可以加图片
	 */
	public Integer getPicture() {
		return picture;
	}
	/**
	 * 设置：商家编码
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：商家编码
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：商品二维码
	 */
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	/**
	 * 获取：商品二维码
	 */
	public String getQrcode() {
		return qrcode;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Integer createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Integer getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：修改时间
	 */
	public void setUpdateDate(Integer updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：修改时间
	 */
	public Integer getUpdateDate() {
		return updateDate;
	}
}
