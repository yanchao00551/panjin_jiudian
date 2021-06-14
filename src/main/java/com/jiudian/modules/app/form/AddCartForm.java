package com.jiudian.modules.app.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 添加购物车表单
 * @author Mr.Yan
 *
 */
@ApiModel(value = "添加购物车表单")

public class AddCartForm {
    @ApiModelProperty(value = "商品ID")
    @NotNull(message="商品ID不能为空")
    private Integer goodsId;

    @ApiModelProperty(value = "商品名称")
    @NotNull(message="商品名称不能为空")
    private String goodsName;

    @ApiModelProperty(value = "购买数量")
    @NotNull(message="购买数量不能为空")
    private Integer count;
    
//    @ApiModelProperty(value = "商品sku")
//    @NotNull(message="商品sku ID不能为空")
//    private int goodsAtrributeId;
//    
//    @ApiModelProperty(value = "商品sku名称")
//    @NotNull(message="商品sku 名称不能为空")
//    private String skuName;
    
    
    @ApiModelProperty(value = "商品价格")
    @NotNull(message="商品价格不能为空")
    private BigDecimal price;
    
    
//    @ApiModelProperty(value = "成本价")
//    private BigDecimal costPrice;
    
    @ApiModelProperty(value = "商品图片")
    @NotNull(message="商品图片不能为空")
    private Integer pictureId;
    
    @ApiModelProperty(value = "入店日期")
    private Integer intoStore;
    @ApiModelProperty(value = "入店日期")
    private Integer leaveStore;
    @ApiModelProperty(value = "酒店房价最大可用积分")
    private Integer maxUsePoint;
    
    
    
    @ApiModelProperty(value = "购物车类型 不为null 则是酒店类型")
    private Integer type;
    
    @ApiModelProperty(value = "商品属性ID")
    private Integer goodsAttributeId;
    

    

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

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

//	public Integer getSkuId() {
//		return skuId;
//	}
//
//	public void setSkuId(Integer skuId) {
//		this.skuId = skuId;
//	}
//
//	public String getSkuName() {
//		return skuName;
//	}
//
//	public void setSkuName(String skuName) {
//		this.skuName = skuName;
//	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

//	public BigDecimal getCostPrice() {
//		return costPrice;
//	}
//
//	public void setCostPrice(BigDecimal costPrice) {
//		this.costPrice = costPrice;
//	}

	public Integer getPictureId() {
		return pictureId;
	}

	public void setPictureId(Integer pictureId) {
		this.pictureId = pictureId;
	}

	public Integer getGoodsAttributeId() {
		return goodsAttributeId;
	}

	public void setGoodsAttributeId(Integer goodsAttributeId) {
		this.goodsAttributeId = goodsAttributeId;
	}

	public Integer getMaxUsePoint() {
		return maxUsePoint;
	}

	public void setMaxUsePoint(Integer maxUsePoint) {
		this.maxUsePoint = maxUsePoint;
	}
    
    
    

    
}
