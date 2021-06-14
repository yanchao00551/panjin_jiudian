package com.jiudian.modules.goods.entity;

import java.math.BigDecimal;


public class GoodsCreateOrUpdateForm {
	/**
	 * 商品id(SKU)
	 */
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
	 * 周边服务坐标
	 */
	private String location;
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
	 * 
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
	 * 扩展字段 酒店日历价格
	 */
	private String extends1;
	
	/**
	 * 商品标题
	 */
	private String title;
	
	/**
	 * 分组tag
	 */
	private String groupArray;
	
	/**
	 * 兑换所需积分
	 * @return
	 */
	private Integer integrationAvailableUse;
	
	/**
	 * 购买可赠送
	 * @return
	 */
	private Integer integrationAvailableGive;
	
	/**
	 * 库存预警
	 * @return
	 */
	private Integer minstock;
	
	/**
	 * 基础点击数
	 * @return
	 */
	private Integer baseGood;
	
	/**
	 * 基础分享数
	 * @return
	 */
	private Integer baseShare;
	
	/**
	 * 基础销量
	 * @return
	 */
	private Integer baseSales;
	
	/**
	 * 关键词
	 * @return
	 */
	private String keyWords;
	
	/**
	 * 库存显示
	 * @return
	 */
	private Integer displayStock;
	
	/**
	 * 商品图片
	 * @return
	 */
	private String imageArray;
	
	/**
	 * 商品规格抽象字符串
	 * @return
	 */
	private String skuArray;
	
	/**
	 * 是否上架
	 * @return
	 */
	private Integer isSale;
	
	/**
	 * 商品属性值json
	 * @return
	 */
	private String goodsAttribute;
	
	/**
	 * 商品规格图片json
	 * @return
	 */
	private String skuPictureVlaues;
	
	
	/**
	 * 扩展分类ID
	 * @return
	 */
	private Integer categoryExtendId;
	
	/**
	 * 虚拟商品类型数据
	 */
	private String virtualGoodsTypeData;
	
	private String ladderPreference;
	
	/**
	 * 特殊商品日历价格
	 * @return
	 */
	private String calendarPrice;
	
	
	private int isEdit;
	

	public String getCalendarPrice() {
		return calendarPrice;
	}

	public void setCalendarPrice(String calendarPrice) {
		this.calendarPrice = calendarPrice;
	}

	public String getLadderPreference() {
		return ladderPreference;
	}

	public void setLadderPreference(String ladderPreference) {
		this.ladderPreference = ladderPreference;
	}

	public String getVirtualGoodsTypeData() {
		return virtualGoodsTypeData;
	}

	public void setVirtualGoodsTypeData(String virtualGoodsTypeData) {
		this.virtualGoodsTypeData = virtualGoodsTypeData;
	}

	public Integer getCategoryExtendId() {
		return categoryExtendId;
	}

	public void setCategoryExtendId(Integer categoryExtendId) {
		this.categoryExtendId = categoryExtendId;
	}

	public String getSkuPictureVlaues() {
		return skuPictureVlaues;
	}

	public void setSkuPictureVlaues(String skuPictureVlaues) {
		this.skuPictureVlaues = skuPictureVlaues;
	}

	public String getGoodsAttribute() {
		return goodsAttribute;
	}

	public void setGoodsAttribute(String goodsAttribute) {
		this.goodsAttribute = goodsAttribute;
	}

	public Integer getIsSale() {
		return isSale;
	}

	public void setIsSale(Integer isSale) {
		this.isSale = isSale;
	}

	public String getSkuArray() {
		return skuArray;
	}

	public void setSkuArray(String skuArray) {
		this.skuArray = skuArray;
	}

	public String getImageArray() {
		return imageArray;
	}

	public void setImageArray(String imageArray) {
		this.imageArray = imageArray;
	}

	public Integer getDisplayStock() {
		return displayStock;
	}

	public void setDisplayStock(Integer displayStock) {
		this.displayStock = displayStock;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}

	public Integer getBaseSales() {
		return baseSales;
	}

	public void setBaseSales(Integer baseSales) {
		this.baseSales = baseSales;
	}

	public Integer getBaseShare() {
		return baseShare;
	}

	public void setBaseShare(Integer baseShare) {
		this.baseShare = baseShare;
	}

	public Integer getBaseGood() {
		return baseGood;
	}

	public void setBaseGood(Integer baseGood) {
		this.baseGood = baseGood;
	}

	public Integer getMinstock() {
		return minstock;
	}

	public void setMinstock(Integer minstock) {
		this.minstock = minstock;
	}

	public Integer getIntegrationAvailableUse() {
		return integrationAvailableUse;
	}

	public void setIntegrationAvailableUse(Integer integrationAvailableUse) {
		this.integrationAvailableUse = integrationAvailableUse;
	}

	public Integer getIntegrationAvailableGive() {
		return integrationAvailableGive;
	}

	public void setIntegrationAvailableGive(Integer integrationAvailableGive) {
		this.integrationAvailableGive = integrationAvailableGive;
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

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getCategoryId1() {
		return categoryId1;
	}

	public void setCategoryId1(Integer categoryId1) {
		this.categoryId1 = categoryId1;
	}

	public Integer getCategoryId2() {
		return categoryId2;
	}

	public void setCategoryId2(Integer categoryId2) {
		this.categoryId2 = categoryId2;
	}

	public Integer getCategoryId3() {
		return categoryId3;
	}

	public void setCategoryId3(Integer categoryId3) {
		this.categoryId3 = categoryId3;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getGroupIdArray() {
		return groupIdArray;
	}

	public void setGroupIdArray(String groupIdArray) {
		this.groupIdArray = groupIdArray;
	}

	public Integer getPromotionType() {
		return promotionType;
	}

	public void setPromotionType(Integer promotionType) {
		this.promotionType = promotionType;
	}

	public Integer getPromoteId() {
		return promoteId;
	}

	public void setPromoteId(Integer promoteId) {
		this.promoteId = promoteId;
	}

	public Integer getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(Integer goodsType) {
		this.goodsType = goodsType;
	}

	public BigDecimal getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(BigDecimal marketPrice) {
		this.marketPrice = marketPrice;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getPromotionPrice() {
		return promotionPrice;
	}

	public void setPromotionPrice(BigDecimal promotionPrice) {
		this.promotionPrice = promotionPrice;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public Integer getPointExchangeType() {
		return pointExchangeType;
	}

	public void setPointExchangeType(Integer pointExchangeType) {
		this.pointExchangeType = pointExchangeType;
	}

	public Integer getPointExchange() {
		return pointExchange;
	}

	public void setPointExchange(Integer pointExchange) {
		this.pointExchange = pointExchange;
	}

	public Integer getGivePoint() {
		return givePoint;
	}

	public void setGivePoint(Integer givePoint) {
		this.givePoint = givePoint;
	}

	public Integer getIsMemberDiscount() {
		return isMemberDiscount;
	}

	public void setIsMemberDiscount(Integer isMemberDiscount) {
		this.isMemberDiscount = isMemberDiscount;
	}

	public BigDecimal getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(BigDecimal shippingFee) {
		this.shippingFee = shippingFee;
	}

	public Integer getShippingFeeId() {
		return shippingFeeId;
	}

	public void setShippingFeeId(Integer shippingFeeId) {
		this.shippingFeeId = shippingFeeId;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Integer getMaxBuy() {
		return maxBuy;
	}

	public void setMaxBuy(Integer maxBuy) {
		this.maxBuy = maxBuy;
	}

	public Integer getClicks() {
		return clicks;
	}

	public void setClicks(Integer clicks) {
		this.clicks = clicks;
	}

	public Integer getMinStockAlarm() {
		return minStockAlarm;
	}

	public void setMinStockAlarm(Integer minStockAlarm) {
		this.minStockAlarm = minStockAlarm;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

	public Integer getCollects() {
		return collects;
	}

	public void setCollects(Integer collects) {
		this.collects = collects;
	}

	public Integer getStar() {
		return star;
	}

	public void setStar(Integer star) {
		this.star = star;
	}

	public Integer getEvaluates() {
		return evaluates;
	}

	public void setEvaluates(Integer evaluates) {
		this.evaluates = evaluates;
	}

	public Integer getShares() {
		return shares;
	}

	public void setShares(Integer shares) {
		this.shares = shares;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public Integer getPicture() {
		return picture;
	}

	public void setPicture(Integer picture) {
		this.picture = picture;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getIsStockVisible() {
		return isStockVisible;
	}

	public void setIsStockVisible(Integer isStockVisible) {
		this.isStockVisible = isStockVisible;
	}

	public Integer getIsHot() {
		return isHot;
	}

	public void setIsHot(Integer isHot) {
		this.isHot = isHot;
	}

	public Integer getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(Integer isRecommend) {
		this.isRecommend = isRecommend;
	}

	public Integer getIsNew() {
		return isNew;
	}

	public void setIsNew(Integer isNew) {
		this.isNew = isNew;
	}

	public Integer getIsPreSale() {
		return isPreSale;
	}

	public void setIsPreSale(Integer isPreSale) {
		this.isPreSale = isPreSale;
	}

	public Integer getIsBill() {
		return isBill;
	}

	public void setIsBill(Integer isBill) {
		this.isBill = isBill;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getImgIdArray() {
		return imgIdArray;
	}

	public void setImgIdArray(String imgIdArray) {
		this.imgIdArray = imgIdArray;
	}

	public String getSkuImgArray() {
		return skuImgArray;
	}

	public void setSkuImgArray(String skuImgArray) {
		this.skuImgArray = skuImgArray;
	}

	public Float getMatchPoint() {
		return matchPoint;
	}

	public void setMatchPoint(Float matchPoint) {
		this.matchPoint = matchPoint;
	}

	public Float getMatchRatio() {
		return matchRatio;
	}

	public void setMatchRatio(Float matchRatio) {
		this.matchRatio = matchRatio;
	}

	public Integer getRealSales() {
		return realSales;
	}

	public void setRealSales(Integer realSales) {
		this.realSales = realSales;
	}

	public Integer getGoodsAttributeId() {
		return goodsAttributeId;
	}

	public void setGoodsAttributeId(Integer goodsAttributeId) {
		this.goodsAttributeId = goodsAttributeId;
	}

	public String getGoodsSpecFormat() {
		return goodsSpecFormat;
	}

	public void setGoodsSpecFormat(String goodsSpecFormat) {
		this.goodsSpecFormat = goodsSpecFormat;
	}

	public BigDecimal getGoodsWeight() {
		return goodsWeight;
	}

	public void setGoodsWeight(BigDecimal goodsWeight) {
		this.goodsWeight = goodsWeight;
	}

	public BigDecimal getGoodsVolume() {
		return goodsVolume;
	}

	public void setGoodsVolume(BigDecimal goodsVolume) {
		this.goodsVolume = goodsVolume;
	}

	public Integer getShippingFeeType() {
		return shippingFeeType;
	}

	public void setShippingFeeType(Integer shippingFeeType) {
		this.shippingFeeType = shippingFeeType;
	}

	public String getExtendCategoryId() {
		return extendCategoryId;
	}

	public void setExtendCategoryId(String extendCategoryId) {
		this.extendCategoryId = extendCategoryId;
	}

	public String getExtendCategoryId1() {
		return extendCategoryId1;
	}

	public void setExtendCategoryId1(String extendCategoryId1) {
		this.extendCategoryId1 = extendCategoryId1;
	}

	public String getExtendCategoryId2() {
		return extendCategoryId2;
	}

	public void setExtendCategoryId2(String extendCategoryId2) {
		this.extendCategoryId2 = extendCategoryId2;
	}

	public String getExtendCategoryId3() {
		return extendCategoryId3;
	}

	public void setExtendCategoryId3(String extendCategoryId3) {
		this.extendCategoryId3 = extendCategoryId3;
	}

	public Integer getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}

	public Integer getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Integer saleDate) {
		this.saleDate = saleDate;
	}

	public Integer getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}

	public Integer getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Integer updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getMinBuy() {
		return minBuy;
	}

	public void setMinBuy(Integer minBuy) {
		this.minBuy = minBuy;
	}

	public Integer getVirtualGoodsTypeId() {
		return virtualGoodsTypeId;
	}

	public void setVirtualGoodsTypeId(Integer virtualGoodsTypeId) {
		this.virtualGoodsTypeId = virtualGoodsTypeId;
	}

	public Integer getProductionDate() {
		return productionDate;
	}

	public void setProductionDate(Integer productionDate) {
		this.productionDate = productionDate;
	}

	public String getShelfLife() {
		return shelfLife;
	}

	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}

	public String getGoodsVideoAddress() {
		return goodsVideoAddress;
	}

	public void setGoodsVideoAddress(String goodsVideoAddress) {
		this.goodsVideoAddress = goodsVideoAddress;
	}

	public String getPcCustomTemplate() {
		return pcCustomTemplate;
	}

	public void setPcCustomTemplate(String pcCustomTemplate) {
		this.pcCustomTemplate = pcCustomTemplate;
	}

	public String getWapCustomTemplate() {
		return wapCustomTemplate;
	}

	public void setWapCustomTemplate(String wapCustomTemplate) {
		this.wapCustomTemplate = wapCustomTemplate;
	}

	public Integer getMaxUsePoint() {
		return maxUsePoint;
	}

	public void setMaxUsePoint(Integer maxUsePoint) {
		this.maxUsePoint = maxUsePoint;
	}

	public Integer getIsOpenPresell() {
		return isOpenPresell;
	}

	public void setIsOpenPresell(Integer isOpenPresell) {
		this.isOpenPresell = isOpenPresell;
	}

	public Integer getPresellTime() {
		return presellTime;
	}

	public void setPresellTime(Integer presellTime) {
		this.presellTime = presellTime;
	}

	public Integer getPresellDay() {
		return presellDay;
	}

	public void setPresellDay(Integer presellDay) {
		this.presellDay = presellDay;
	}

	public Integer getPresellDeliveryType() {
		return presellDeliveryType;
	}

	public void setPresellDeliveryType(Integer presellDeliveryType) {
		this.presellDeliveryType = presellDeliveryType;
	}

	public BigDecimal getPresellPrice() {
		return presellPrice;
	}

	public void setPresellPrice(BigDecimal presellPrice) {
		this.presellPrice = presellPrice;
	}

	public String getGoodsUnit() {
		return goodsUnit;
	}

	public void setGoodsUnit(String goodsUnit) {
		this.goodsUnit = goodsUnit;
	}

	public String getExtends1() {
		return extends1;
	}

	public void setExtends1(String extends1) {
		this.extends1 = extends1;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGroupArray() {
		return groupArray;
	}

	public void setGroupArray(String groupArray) {
		this.groupArray = groupArray;
	}

	public int getIsEdit() {
		return isEdit;
	}

	public void setIsEdit(int isEdit) {
		this.isEdit = isEdit;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
