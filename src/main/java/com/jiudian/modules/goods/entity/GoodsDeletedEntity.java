package com.jiudian.modules.goods.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 商品回收站表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
@TableName("ns_goods_deleted")
public class GoodsDeletedEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 商品id(SKU)
	 */
	@TableId
	private Integer goodsId;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 店铺id
	 */
	private Integer shopId;
	/**
	 * 商品分类id
	 */
	private Integer categoryId;
	/**
	 * 一级分类id
	 */
	private Integer categoryId1;
	/**
	 * 二级分类id
	 */
	private Integer categoryId2;
	/**
	 * 三级分类id
	 */
	private Integer categoryId3;
	/**
	 * 品牌id
	 */
	private Integer brandId;
	/**
	 * 店铺分类id 首尾用,隔开
	 */
	private String groupIdArray;
	/**
	 * 促销类型 0无促销，1团购，2限时折扣
	 */
	private Integer promotionType;
	/**
	 * 促销活动ID
	 */
	private Integer promoteId;
	/**
	 * 实物或虚拟商品标志 1实物商品 0 虚拟商品 2 F码商品
	 */
	private Integer goodsType;
	/**
	 * 市场价
	 */
	private BigDecimal marketPrice;
	/**
	 * 商品原价格
	 */
	private BigDecimal price;
	/**
	 * 商品促销价格
	 */
	private BigDecimal promotionPrice;
	/**
	 * 成本价
	 */
	private BigDecimal costPrice;
	/**
	 * 积分兑换类型 0 非积分兑换 1 只能积分兑换 
	 */
	private Integer pointExchangeType;
	/**
	 * 积分兑换
	 */
	private Integer pointExchange;
	/**
	 * 购买商品赠送积分
	 */
	private Integer givePoint;
	/**
	 * 参与会员折扣
	 */
	private Integer isMemberDiscount;
	/**
	 * 运费 0为免运费
	 */
	private BigDecimal shippingFee;
	/**
	 * 售卖区域id 物流模板id  ns_order_shipping_fee 表id
	 */
	private Integer shippingFeeId;
	/**
	 * 商品库存
	 */
	private Integer stock;
	/**
	 * 限购 0 不限购
	 */
	private Integer maxBuy;
	/**
	 * 商品点击数量
	 */
	private Integer clicks;
	/**
	 * 库存预警值
	 */
	private Integer minStockAlarm;
	/**
	 * 销售数量
	 */
	private Integer sales;
	/**
	 * 收藏数量
	 */
	private Integer collects;
	/**
	 * 好评星级
	 */
	private Integer star;
	/**
	 * 评价数
	 */
	private Integer evaluates;
	/**
	 * 分享数
	 */
	private Integer shares;
	/**
	 * 一级地区id
	 */
	private Integer provinceId;
	/**
	 * 二级地区id
	 */
	private Integer cityId;
	/**
	 * 商品主图
	 */
	private Integer picture;
	/**
	 * 商品关键词
	 */
	private String keywords;
	/**
	 * 商品简介，促销语
	 */
	private String introduction;
	/**
	 * 商品详情
	 */
	private String description;
	/**
	 * 商品二维码
	 */
	private String qrcode;
	/**
	 * 商家编号
	 */
	private String code;
	/**
	 * 页面不显示库存
	 */
	private Integer isStockVisible;
	/**
	 * 是否热销商品
	 */
	private Integer isHot;
	/**
	 * 是否推荐
	 */
	private Integer isRecommend;
	/**
	 * 是否新品
	 */
	private Integer isNew;
	/**
	 * 是否预售
	 */
	private Integer isPreSale;
	/**
	 * 是否开具增值税发票 1是，0否
	 */
	private Integer isBill;
	/**
	 * 商品状态 0下架，1正常，10违规（禁售）
	 */
	private Integer state;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 商品图片序列
	 */
	private String imgIdArray;
	/**
	 * 商品sku应用图片列表  属性,属性值，图片ID
	 */
	private String skuImgArray;
	/**
	 * 实物与描述相符（根据评价计算）
	 */
	private Float matchPoint;
	/**
	 * 实物与描述相符（根据评价计算）百分比
	 */
	private Float matchRatio;
	/**
	 * 实际销量
	 */
	private Integer realSales;
	/**
	 * 商品类型
	 */
	private Integer goodsAttributeId;
	/**
	 * 商品规格
	 */
	private String goodsSpecFormat;
	/**
	 * 商品重量
	 */
	private BigDecimal goodsWeight;
	/**
	 * 商品体积
	 */
	private BigDecimal goodsVolume;
	/**
	 * 计价方式1.重量2.体积3.计件
	 */
	private Integer shippingFeeType;
	/**
	 * 
	 */
	private String extendCategoryId;
	/**
	 * 
	 */
	private String extendCategoryId1;
	/**
	 * 
	 */
	private String extendCategoryId2;
	/**
	 * 
	 */
	private String extendCategoryId3;
	/**
	 * 供货商id
	 */
	private Integer supplierId;
	/**
	 * 上下架时间
	 */
	private Integer saleDate;
	/**
	 * 商品添加时间
	 */
	private Integer createTime;
	/**
	 * 商品编辑时间
	 */
	private Integer updateTime;
	/**
	 * 最少买几件
	 */
	private Integer minBuy;
	/**
	 * 虚拟商品类型id
	 */
	private Integer virtualGoodsTypeId;
	/**
	 * 生产日期
	 */
	private Integer productionDate;
	/**
	 * 保质期
	 */
	private String shelfLife;
	/**
	 * 商品视频地址，不为空时前台显示视频
	 */
	private String goodsVideoAddress;
	/**
	 * pc端商品自定义模板
	 */
	private String pcCustomTemplate;
	/**
	 * wap端商品自定义模板
	 */
	private String wapCustomTemplate;
	/**
	 * 积分抵现最大可用积分数 0为不可使用
	 */
	private Integer maxUsePoint;
	/**
	 * 是否支持预售
	 */
	private Integer isOpenPresell;
	/**
	 * 预售发货时间
	 */
	private Integer presellTime;
	/**
	 * 预售发货天数
	 */
	private Integer presellDay;
	/**
	 * 预售发货方式1. 按照预售发货时间 2.按照预售发货天数
	 */
	private Integer presellDeliveryType;
	/**
	 * 预售金额
	 */
	private BigDecimal presellPrice;
	/**
	 * 商品单位
	 */
	private String goodsUnit;

	/**
	 * 设置：商品id(SKU)
	 */
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	/**
	 * 获取：商品id(SKU)
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
	 * 设置：商品分类id
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * 获取：商品分类id
	 */
	public Integer getCategoryId() {
		return categoryId;
	}
	/**
	 * 设置：一级分类id
	 */
	public void setCategoryId1(Integer categoryId1) {
		this.categoryId1 = categoryId1;
	}
	/**
	 * 获取：一级分类id
	 */
	public Integer getCategoryId1() {
		return categoryId1;
	}
	/**
	 * 设置：二级分类id
	 */
	public void setCategoryId2(Integer categoryId2) {
		this.categoryId2 = categoryId2;
	}
	/**
	 * 获取：二级分类id
	 */
	public Integer getCategoryId2() {
		return categoryId2;
	}
	/**
	 * 设置：三级分类id
	 */
	public void setCategoryId3(Integer categoryId3) {
		this.categoryId3 = categoryId3;
	}
	/**
	 * 获取：三级分类id
	 */
	public Integer getCategoryId3() {
		return categoryId3;
	}
	/**
	 * 设置：品牌id
	 */
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	/**
	 * 获取：品牌id
	 */
	public Integer getBrandId() {
		return brandId;
	}
	/**
	 * 设置：店铺分类id 首尾用,隔开
	 */
	public void setGroupIdArray(String groupIdArray) {
		this.groupIdArray = groupIdArray;
	}
	/**
	 * 获取：店铺分类id 首尾用,隔开
	 */
	public String getGroupIdArray() {
		return groupIdArray;
	}
	/**
	 * 设置：促销类型 0无促销，1团购，2限时折扣
	 */
	public void setPromotionType(Integer promotionType) {
		this.promotionType = promotionType;
	}
	/**
	 * 获取：促销类型 0无促销，1团购，2限时折扣
	 */
	public Integer getPromotionType() {
		return promotionType;
	}
	/**
	 * 设置：促销活动ID
	 */
	public void setPromoteId(Integer promoteId) {
		this.promoteId = promoteId;
	}
	/**
	 * 获取：促销活动ID
	 */
	public Integer getPromoteId() {
		return promoteId;
	}
	/**
	 * 设置：实物或虚拟商品标志 1实物商品 0 虚拟商品 2 F码商品
	 */
	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}
	/**
	 * 获取：实物或虚拟商品标志 1实物商品 0 虚拟商品 2 F码商品
	 */
	public Integer getGoodsType() {
		return goodsType;
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
	 * 设置：商品原价格
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * 获取：商品原价格
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * 设置：商品促销价格
	 */
	public void setPromotionPrice(BigDecimal promotionPrice) {
		this.promotionPrice = promotionPrice;
	}
	/**
	 * 获取：商品促销价格
	 */
	public BigDecimal getPromotionPrice() {
		return promotionPrice;
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
	 * 设置：积分兑换类型 0 非积分兑换 1 只能积分兑换 
	 */
	public void setPointExchangeType(Integer pointExchangeType) {
		this.pointExchangeType = pointExchangeType;
	}
	/**
	 * 获取：积分兑换类型 0 非积分兑换 1 只能积分兑换 
	 */
	public Integer getPointExchangeType() {
		return pointExchangeType;
	}
	/**
	 * 设置：积分兑换
	 */
	public void setPointExchange(Integer pointExchange) {
		this.pointExchange = pointExchange;
	}
	/**
	 * 获取：积分兑换
	 */
	public Integer getPointExchange() {
		return pointExchange;
	}
	/**
	 * 设置：购买商品赠送积分
	 */
	public void setGivePoint(Integer givePoint) {
		this.givePoint = givePoint;
	}
	/**
	 * 获取：购买商品赠送积分
	 */
	public Integer getGivePoint() {
		return givePoint;
	}
	/**
	 * 设置：参与会员折扣
	 */
	public void setIsMemberDiscount(Integer isMemberDiscount) {
		this.isMemberDiscount = isMemberDiscount;
	}
	/**
	 * 获取：参与会员折扣
	 */
	public Integer getIsMemberDiscount() {
		return isMemberDiscount;
	}
	/**
	 * 设置：运费 0为免运费
	 */
	public void setShippingFee(BigDecimal shippingFee) {
		this.shippingFee = shippingFee;
	}
	/**
	 * 获取：运费 0为免运费
	 */
	public BigDecimal getShippingFee() {
		return shippingFee;
	}
	/**
	 * 设置：售卖区域id 物流模板id  ns_order_shipping_fee 表id
	 */
	public void setShippingFeeId(Integer shippingFeeId) {
		this.shippingFeeId = shippingFeeId;
	}
	/**
	 * 获取：售卖区域id 物流模板id  ns_order_shipping_fee 表id
	 */
	public Integer getShippingFeeId() {
		return shippingFeeId;
	}
	/**
	 * 设置：商品库存
	 */
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	/**
	 * 获取：商品库存
	 */
	public Integer getStock() {
		return stock;
	}
	/**
	 * 设置：限购 0 不限购
	 */
	public void setMaxBuy(Integer maxBuy) {
		this.maxBuy = maxBuy;
	}
	/**
	 * 获取：限购 0 不限购
	 */
	public Integer getMaxBuy() {
		return maxBuy;
	}
	/**
	 * 设置：商品点击数量
	 */
	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}
	/**
	 * 获取：商品点击数量
	 */
	public Integer getClicks() {
		return clicks;
	}
	/**
	 * 设置：库存预警值
	 */
	public void setMinStockAlarm(Integer minStockAlarm) {
		this.minStockAlarm = minStockAlarm;
	}
	/**
	 * 获取：库存预警值
	 */
	public Integer getMinStockAlarm() {
		return minStockAlarm;
	}
	/**
	 * 设置：销售数量
	 */
	public void setSales(Integer sales) {
		this.sales = sales;
	}
	/**
	 * 获取：销售数量
	 */
	public Integer getSales() {
		return sales;
	}
	/**
	 * 设置：收藏数量
	 */
	public void setCollects(Integer collects) {
		this.collects = collects;
	}
	/**
	 * 获取：收藏数量
	 */
	public Integer getCollects() {
		return collects;
	}
	/**
	 * 设置：好评星级
	 */
	public void setStar(Integer star) {
		this.star = star;
	}
	/**
	 * 获取：好评星级
	 */
	public Integer getStar() {
		return star;
	}
	/**
	 * 设置：评价数
	 */
	public void setEvaluates(Integer evaluates) {
		this.evaluates = evaluates;
	}
	/**
	 * 获取：评价数
	 */
	public Integer getEvaluates() {
		return evaluates;
	}
	/**
	 * 设置：分享数
	 */
	public void setShares(Integer shares) {
		this.shares = shares;
	}
	/**
	 * 获取：分享数
	 */
	public Integer getShares() {
		return shares;
	}
	/**
	 * 设置：一级地区id
	 */
	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
	/**
	 * 获取：一级地区id
	 */
	public Integer getProvinceId() {
		return provinceId;
	}
	/**
	 * 设置：二级地区id
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	/**
	 * 获取：二级地区id
	 */
	public Integer getCityId() {
		return cityId;
	}
	/**
	 * 设置：商品主图
	 */
	public void setPicture(Integer picture) {
		this.picture = picture;
	}
	/**
	 * 获取：商品主图
	 */
	public Integer getPicture() {
		return picture;
	}
	/**
	 * 设置：商品关键词
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	/**
	 * 获取：商品关键词
	 */
	public String getKeywords() {
		return keywords;
	}
	/**
	 * 设置：商品简介，促销语
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	/**
	 * 获取：商品简介，促销语
	 */
	public String getIntroduction() {
		return introduction;
	}
	/**
	 * 设置：商品详情
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * 获取：商品详情
	 */
	public String getDescription() {
		return description;
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
	 * 设置：商家编号
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 获取：商家编号
	 */
	public String getCode() {
		return code;
	}
	/**
	 * 设置：页面不显示库存
	 */
	public void setIsStockVisible(Integer isStockVisible) {
		this.isStockVisible = isStockVisible;
	}
	/**
	 * 获取：页面不显示库存
	 */
	public Integer getIsStockVisible() {
		return isStockVisible;
	}
	/**
	 * 设置：是否热销商品
	 */
	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}
	/**
	 * 获取：是否热销商品
	 */
	public Integer getIsHot() {
		return isHot;
	}
	/**
	 * 设置：是否推荐
	 */
	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}
	/**
	 * 获取：是否推荐
	 */
	public Integer getIsRecommend() {
		return isRecommend;
	}
	/**
	 * 设置：是否新品
	 */
	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}
	/**
	 * 获取：是否新品
	 */
	public Integer getIsNew() {
		return isNew;
	}
	/**
	 * 设置：是否预售
	 */
	public void setIsPreSale(Integer isPreSale) {
		this.isPreSale = isPreSale;
	}
	/**
	 * 获取：是否预售
	 */
	public Integer getIsPreSale() {
		return isPreSale;
	}
	/**
	 * 设置：是否开具增值税发票 1是，0否
	 */
	public void setIsBill(Integer isBill) {
		this.isBill = isBill;
	}
	/**
	 * 获取：是否开具增值税发票 1是，0否
	 */
	public Integer getIsBill() {
		return isBill;
	}
	/**
	 * 设置：商品状态 0下架，1正常，10违规（禁售）
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：商品状态 0下架，1正常，10违规（禁售）
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * 设置：排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：商品图片序列
	 */
	public void setImgIdArray(String imgIdArray) {
		this.imgIdArray = imgIdArray;
	}
	/**
	 * 获取：商品图片序列
	 */
	public String getImgIdArray() {
		return imgIdArray;
	}
	/**
	 * 设置：商品sku应用图片列表  属性,属性值，图片ID
	 */
	public void setSkuImgArray(String skuImgArray) {
		this.skuImgArray = skuImgArray;
	}
	/**
	 * 获取：商品sku应用图片列表  属性,属性值，图片ID
	 */
	public String getSkuImgArray() {
		return skuImgArray;
	}
	/**
	 * 设置：实物与描述相符（根据评价计算）
	 */
	public void setMatchPoint(Float matchPoint) {
		this.matchPoint = matchPoint;
	}
	/**
	 * 获取：实物与描述相符（根据评价计算）
	 */
	public Float getMatchPoint() {
		return matchPoint;
	}
	/**
	 * 设置：实物与描述相符（根据评价计算）百分比
	 */
	public void setMatchRatio(Float matchRatio) {
		this.matchRatio = matchRatio;
	}
	/**
	 * 获取：实物与描述相符（根据评价计算）百分比
	 */
	public Float getMatchRatio() {
		return matchRatio;
	}
	/**
	 * 设置：实际销量
	 */
	public void setRealSales(Integer realSales) {
		this.realSales = realSales;
	}
	/**
	 * 获取：实际销量
	 */
	public Integer getRealSales() {
		return realSales;
	}
	/**
	 * 设置：商品类型
	 */
	public void setGoodsAttributeId(Integer goodsAttributeId) {
		this.goodsAttributeId = goodsAttributeId;
	}
	/**
	 * 获取：商品类型
	 */
	public Integer getGoodsAttributeId() {
		return goodsAttributeId;
	}
	/**
	 * 设置：商品规格
	 */
	public void setGoodsSpecFormat(String goodsSpecFormat) {
		this.goodsSpecFormat = goodsSpecFormat;
	}
	/**
	 * 获取：商品规格
	 */
	public String getGoodsSpecFormat() {
		return goodsSpecFormat;
	}
	/**
	 * 设置：商品重量
	 */
	public void setGoodsWeight(BigDecimal goodsWeight) {
		this.goodsWeight = goodsWeight;
	}
	/**
	 * 获取：商品重量
	 */
	public BigDecimal getGoodsWeight() {
		return goodsWeight;
	}
	/**
	 * 设置：商品体积
	 */
	public void setGoodsVolume(BigDecimal goodsVolume) {
		this.goodsVolume = goodsVolume;
	}
	/**
	 * 获取：商品体积
	 */
	public BigDecimal getGoodsVolume() {
		return goodsVolume;
	}
	/**
	 * 设置：计价方式1.重量2.体积3.计件
	 */
	public void setShippingFeeType(Integer shippingFeeType) {
		this.shippingFeeType = shippingFeeType;
	}
	/**
	 * 获取：计价方式1.重量2.体积3.计件
	 */
	public Integer getShippingFeeType() {
		return shippingFeeType;
	}
	/**
	 * 设置：
	 */
	public void setExtendCategoryId(String extendCategoryId) {
		this.extendCategoryId = extendCategoryId;
	}
	/**
	 * 获取：
	 */
	public String getExtendCategoryId() {
		return extendCategoryId;
	}
	/**
	 * 设置：
	 */
	public void setExtendCategoryId1(String extendCategoryId1) {
		this.extendCategoryId1 = extendCategoryId1;
	}
	/**
	 * 获取：
	 */
	public String getExtendCategoryId1() {
		return extendCategoryId1;
	}
	/**
	 * 设置：
	 */
	public void setExtendCategoryId2(String extendCategoryId2) {
		this.extendCategoryId2 = extendCategoryId2;
	}
	/**
	 * 获取：
	 */
	public String getExtendCategoryId2() {
		return extendCategoryId2;
	}
	/**
	 * 设置：
	 */
	public void setExtendCategoryId3(String extendCategoryId3) {
		this.extendCategoryId3 = extendCategoryId3;
	}
	/**
	 * 获取：
	 */
	public String getExtendCategoryId3() {
		return extendCategoryId3;
	}
	/**
	 * 设置：供货商id
	 */
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	/**
	 * 获取：供货商id
	 */
	public Integer getSupplierId() {
		return supplierId;
	}
	/**
	 * 设置：上下架时间
	 */
	public void setSaleDate(Integer saleDate) {
		this.saleDate = saleDate;
	}
	/**
	 * 获取：上下架时间
	 */
	public Integer getSaleDate() {
		return saleDate;
	}
	/**
	 * 设置：商品添加时间
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：商品添加时间
	 */
	public Integer getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：商品编辑时间
	 */
	public void setUpdateTime(Integer updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：商品编辑时间
	 */
	public Integer getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：最少买几件
	 */
	public void setMinBuy(Integer minBuy) {
		this.minBuy = minBuy;
	}
	/**
	 * 获取：最少买几件
	 */
	public Integer getMinBuy() {
		return minBuy;
	}
	/**
	 * 设置：虚拟商品类型id
	 */
	public void setVirtualGoodsTypeId(Integer virtualGoodsTypeId) {
		this.virtualGoodsTypeId = virtualGoodsTypeId;
	}
	/**
	 * 获取：虚拟商品类型id
	 */
	public Integer getVirtualGoodsTypeId() {
		return virtualGoodsTypeId;
	}
	/**
	 * 设置：生产日期
	 */
	public void setProductionDate(Integer productionDate) {
		this.productionDate = productionDate;
	}
	/**
	 * 获取：生产日期
	 */
	public Integer getProductionDate() {
		return productionDate;
	}
	/**
	 * 设置：保质期
	 */
	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}
	/**
	 * 获取：保质期
	 */
	public String getShelfLife() {
		return shelfLife;
	}
	/**
	 * 设置：商品视频地址，不为空时前台显示视频
	 */
	public void setGoodsVideoAddress(String goodsVideoAddress) {
		this.goodsVideoAddress = goodsVideoAddress;
	}
	/**
	 * 获取：商品视频地址，不为空时前台显示视频
	 */
	public String getGoodsVideoAddress() {
		return goodsVideoAddress;
	}
	/**
	 * 设置：pc端商品自定义模板
	 */
	public void setPcCustomTemplate(String pcCustomTemplate) {
		this.pcCustomTemplate = pcCustomTemplate;
	}
	/**
	 * 获取：pc端商品自定义模板
	 */
	public String getPcCustomTemplate() {
		return pcCustomTemplate;
	}
	/**
	 * 设置：wap端商品自定义模板
	 */
	public void setWapCustomTemplate(String wapCustomTemplate) {
		this.wapCustomTemplate = wapCustomTemplate;
	}
	/**
	 * 获取：wap端商品自定义模板
	 */
	public String getWapCustomTemplate() {
		return wapCustomTemplate;
	}
	/**
	 * 设置：积分抵现最大可用积分数 0为不可使用
	 */
	public void setMaxUsePoint(Integer maxUsePoint) {
		this.maxUsePoint = maxUsePoint;
	}
	/**
	 * 获取：积分抵现最大可用积分数 0为不可使用
	 */
	public Integer getMaxUsePoint() {
		return maxUsePoint;
	}
	/**
	 * 设置：是否支持预售
	 */
	public void setIsOpenPresell(Integer isOpenPresell) {
		this.isOpenPresell = isOpenPresell;
	}
	/**
	 * 获取：是否支持预售
	 */
	public Integer getIsOpenPresell() {
		return isOpenPresell;
	}
	/**
	 * 设置：预售发货时间
	 */
	public void setPresellTime(Integer presellTime) {
		this.presellTime = presellTime;
	}
	/**
	 * 获取：预售发货时间
	 */
	public Integer getPresellTime() {
		return presellTime;
	}
	/**
	 * 设置：预售发货天数
	 */
	public void setPresellDay(Integer presellDay) {
		this.presellDay = presellDay;
	}
	/**
	 * 获取：预售发货天数
	 */
	public Integer getPresellDay() {
		return presellDay;
	}
	/**
	 * 设置：预售发货方式1. 按照预售发货时间 2.按照预售发货天数
	 */
	public void setPresellDeliveryType(Integer presellDeliveryType) {
		this.presellDeliveryType = presellDeliveryType;
	}
	/**
	 * 获取：预售发货方式1. 按照预售发货时间 2.按照预售发货天数
	 */
	public Integer getPresellDeliveryType() {
		return presellDeliveryType;
	}
	/**
	 * 设置：预售金额
	 */
	public void setPresellPrice(BigDecimal presellPrice) {
		this.presellPrice = presellPrice;
	}
	/**
	 * 获取：预售金额
	 */
	public BigDecimal getPresellPrice() {
		return presellPrice;
	}
	/**
	 * 设置：商品单位
	 */
	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}
	/**
	 * 获取：商品单位
	 */
	public String getGoodsUnit() {
		return goodsUnit;
	}
}
