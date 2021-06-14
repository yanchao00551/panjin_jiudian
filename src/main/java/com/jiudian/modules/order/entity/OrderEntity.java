package com.jiudian.modules.order.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jiudian.modules.star.entity.StarEntity;

/**
 * 订单表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:36
 */
@TableName("ns_order")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 订单id
	 */
	@TableId
	private Integer orderId;
	/**
	 * 订单编号
	 */
	private String orderNo;
	/**
	 * 外部交易号
	 */
	private String outTradeNo;
	/**
	 * 订单类型
	 */
	private Integer orderType;
	/**
	 * 支付类型。取值范围：
	 * WEIXIN (微信自有支付)
	 * WEIXIN_DAIXIAO (微信代销支付)
	 * ALIPAY (支付宝支付)
	 */
	private Integer paymentType;
	/**
	 * 订单配送方式
	 */
	private Integer shippingType;
	/**
	 * 订单来源
	 */
	private String orderFrom;
	/**
	 * 买家id
	 */
	private Integer buyerId;
	/**
	 * 买家会员名称
	 */
	private String userName;
	/**
	 * 买家ip
	 */
	private String buyerIp;
	/**
	 * 买家附言
	 */
	private String buyerMessage;
	/**
	 * 买家发票信息
	 */
	private String buyerInvoice;
	/**
	 * 收货人的手机号码
	 */
	private String receiverMobile;
	/**
	 * 收货人所在省
	 */
	private Integer receiverProvince;
	/**
	 * 收货人所在城市
	 */
	private Integer receiverCity;
	/**
	 * 收货人所在街道
	 */
	private Integer receiverDistrict;
	/**
	 * 收货人详细地址
	 */
	private String receiverAddress;
	/**
	 * 收货人邮编
	 */
	private String receiverZip;
	/**
	 * 收货人姓名
	 */
	private String receiverName;
	/**
	 * 卖家店铺id
	 */
	private Integer shopId;
	/**
	 * 卖家店铺名称
	 */
	private String shopName;
	/**
	 * 卖家对订单的标注星标
	 */
	private Integer sellerStar;
	/**
	 * 卖家对订单的备注
	 */
	private String sellerMemo;
	/**
	 * 卖家延迟发货时间
	 */
	private Integer consignTimeAdjust;
	/**
	 * 商品总价
	 */
	private BigDecimal goodsMoney;
	/**
	 * 订单总价
	 */
	private BigDecimal orderMoney;
	/**
	 * 订单消耗积分
	 */
	private Integer point;
	/**
	 * 订单消耗积分抵多少钱
	 */
	private BigDecimal pointMoney;
	/**
	 * 订单代金券支付金额
	 */
	private BigDecimal couponMoney;
	/**
	 * 订单代金券id
	 */
	private Integer couponId;
	/**
	 * 订单余额支付金额
	 */
	private BigDecimal userMoney;
	/**
	 * 用户平台余额支付
	 */
	private BigDecimal userPlatformMoney;
	/**
	 * 订单优惠活动金额
	 */
	private BigDecimal promotionMoney;
	/**
	 * 订单运费
	 */
	private BigDecimal shippingMoney;
	/**
	 * 订单实付金额
	 */
	private BigDecimal payMoney;
	/**
	 * 订单退款金额
	 */
	private BigDecimal refundMoney;
	/**
	 * 购物币金额
	 */
	private BigDecimal coinMoney;
	/**
	 * 订单赠送积分
	 */
	private Integer givePoint;
	/**
	 * 订单成功之后返购物币
	 */
	private BigDecimal giveCoin;
	/**
	 * 订单状态
	 */
	private Integer orderStatus;
	/**
	 * 订单付款状态
	 */
	private Integer payStatus;
	/**
	 * 订单配送状态
	 */
	private Integer shippingStatus;
	/**
	 * 订单评价状态
	 */
	private Integer reviewStatus;
	/**
	 * 订单维权状态
	 */
	private Integer feedbackStatus;
	/**
	 * 是否评价 0为未评价 1为已评价 2为已追评
	 */
	private Integer isEvaluate;
	/**
	 * 
	 */
	private BigDecimal taxMoney;
	/**
	 * 配送物流公司ID
	 */
	private Integer shippingCompanyId;
	/**
	 * 积分返还类型 1 订单完成  2 订单收货 3  支付订单
	 */
	private Integer givePointType;
	/**
	 * 订单付款时间
	 */
	private Integer payTime;
	/**
	 * 买家要求配送时间
	 */
	private Integer shippingTime;
	/**
	 * 买家签收时间
	 */
	private Integer signTime;
	/**
	 * 卖家发货时间
	 */
	private Integer consignTime;
	/**
	 * 订单创建时间
	 */
	private Integer createTime;
	/**
	 * 订单完成时间
	 */
	private Integer finishTime;
	/**
	 * 订单是否已删除
	 */
	private Integer isDeleted;
	/**
	 * 操作人类型  1店铺  2用户
	 */
	private Integer operatorType;
	/**
	 * 操作人id
	 */
	private Integer operatorId;
	/**
	 * 订单退款余额
	 */
	private BigDecimal refundBalanceMoney;
	/**
	 * 固定电话
	 */
	private String fixedTelephone;
	
	private int keyId;
	
	private int keyCommentFlag;
	
	private String refundReason;
	
	@TableField(exist = false)
	private String starName;
	
	/*------------ other ------------*/
	@TableField(exist = false)
	private List<OrderGoodsEntity> orderItemList;
	@TableField(exist = false)
	private String operation;
	@TableField(exist = false)
	private String orderFromName;
	@TableField(exist = false)
	private String orderFromTag;
	@TableField(exist = false)
	private String payTypeName;
	@TableField(exist = false)
	private String[] buyerInvoiceInfo;
	@TableField(exist = false)
	private String paymentTypeName;
	@TableField(exist = false)
	private String shippingTypeName;
	@TableField(exist = false)
	private String shippingCompanyName;
	@TableField(exist = false)
	private List<OrderGoodsEntity> orderGoods;
	@TableField(exist = false)
	private String payStatusName;
	@TableField(exist = false)
	private String shippingStatusName;
	@TableField(exist = false)
	private List<OrderGoodsEntity> orderGoodsNoDelive;
	@TableField(exist = false)
	private List<GoodsPacketList> goodsPacketList;
	@TableField(exist = false)
	private String address;
	
	@TableField(exist = false)
	private StarEntity star;
	
	@TableField(exist = false)
	private int orderMaxUsePoint;
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<GoodsPacketList> getGoodsPacketList() {
		return goodsPacketList;
	}
	public void setGoodsPacketList(List<GoodsPacketList> goodsPacketList) {
		this.goodsPacketList = goodsPacketList;
	}
	public List<OrderGoodsEntity> getOrderGoodsNoDelive() {
		return orderGoodsNoDelive;
	}
	public void setOrderGoodsNoDelive(List<OrderGoodsEntity> orderGoodsNoDelive) {
		this.orderGoodsNoDelive = orderGoodsNoDelive;
	}
	public String getPayStatusName() {
		return payStatusName;
	}
	public void setPayStatusName(String payStatusName) {
		this.payStatusName = payStatusName;
	}
	public String getShippingStatusName() {
		return shippingStatusName;
	}
	public void setShippingStatusName(String shippingStatusName) {
		this.shippingStatusName = shippingStatusName;
	}
	public List<OrderGoodsEntity> getOrderGoods() {
		return orderGoods;
	}
	public void setOrderGoods(List<OrderGoodsEntity> list) {
		this.orderGoods = list;
	}
	public String getShippingCompanyName() {
		return shippingCompanyName;
	}
	public void setShippingCompanyName(String shippingCompanyName) {
		this.shippingCompanyName = shippingCompanyName;
	}
	public String getShippingTypeName() {
		return shippingTypeName;
	}
	public void setShippingTypeName(String shippingTypeName) {
		this.shippingTypeName = shippingTypeName;
	}
	public String getPaymentTypeName() {
		return paymentTypeName;
	}
	public void setPaymentTypeName(String paymentTypeName) {
		this.paymentTypeName = paymentTypeName;
	}
	public String[] getBuyerInvoiceInfo() {
		return buyerInvoiceInfo;
	}
	public void setBuyerInvoiceInfo(String[] tempArray) {
		this.buyerInvoiceInfo = tempArray;
	}
	public String getOrderFromName() {
		return orderFromName;
	}
	public void setOrderFromName(String orderFromName) {
		this.orderFromName = orderFromName;
	}
	public String getOrderFromTag() {
		return orderFromTag;
	}
	public void setOrderFromTag(String orderFromTag) {
		this.orderFromTag = orderFromTag;
	}
	public String getPayTypeName() {
		return payTypeName;
	}
	public void setPayTypeName(String payTypeName) {
		this.payTypeName = payTypeName;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public List<OrderGoodsEntity> getOrderItemList() {
		return orderItemList;
	}
	public void setOrderItemList(List<OrderGoodsEntity> orderItemList) {
		this.orderItemList = orderItemList;
	}
	/**
	 * 设置：订单id
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：订单id
	 */
	public Integer getOrderId() {
		return orderId;
	}
	/**
	 * 设置：订单编号
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：订单编号
	 */
	public String getOrderNo() {
		return orderNo;
	}
	/**
	 * 设置：外部交易号
	 */
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
	/**
	 * 获取：外部交易号
	 */
	public String getOutTradeNo() {
		return outTradeNo;
	}
	/**
	 * 设置：订单类型
	 */
	public void setOrderType(Integer orderType) {
		this.orderType = orderType;
	}
	/**
	 * 获取：订单类型
	 */
	public Integer getOrderType() {
		return orderType;
	}
	/**
	 * 设置：支付类型。取值范围：
	 * WEIXIN (微信自有支付)
	 * WEIXIN_DAIXIAO (微信代销支付)
	 * ALIPAY (支付宝支付)
	 */
	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}
	/**
	 * 获取：支付类型。取值范围：
	 * WEIXIN (微信自有支付)
	 * WEIXIN_DAIXIAO (微信代销支付)
	 * ALIPAY (支付宝支付)
	 */
	public Integer getPaymentType() {
		return paymentType;
	}
	/**
	 * 设置：订单配送方式
	 */
	public void setShippingType(Integer shippingType) {
		this.shippingType = shippingType;
	}
	/**
	 * 获取：订单配送方式
	 */
	public Integer getShippingType() {
		return shippingType;
	}
	/**
	 * 设置：订单来源
	 */
	public void setOrderFrom(String orderFrom) {
		this.orderFrom = orderFrom;
	}
	/**
	 * 获取：订单来源
	 */
	public String getOrderFrom() {
		return orderFrom;
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
	 * 设置：买家会员名称
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：买家会员名称
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：买家ip
	 */
	public void setBuyerIp(String buyerIp) {
		this.buyerIp = buyerIp;
	}
	/**
	 * 获取：买家ip
	 */
	public String getBuyerIp() {
		return buyerIp;
	}
	/**
	 * 设置：买家附言
	 */
	public void setBuyerMessage(String buyerMessage) {
		this.buyerMessage = buyerMessage;
	}
	/**
	 * 获取：买家附言
	 */
	public String getBuyerMessage() {
		return buyerMessage;
	}
	/**
	 * 设置：买家发票信息
	 */
	public void setBuyerInvoice(String buyerInvoice) {
		this.buyerInvoice = buyerInvoice;
	}
	/**
	 * 获取：买家发票信息
	 */
	public String getBuyerInvoice() {
		return buyerInvoice;
	}
	/**
	 * 设置：收货人的手机号码
	 */
	public void setReceiverMobile(String receiverMobile) {
		this.receiverMobile = receiverMobile;
	}
	/**
	 * 获取：收货人的手机号码
	 */
	public String getReceiverMobile() {
		return receiverMobile;
	}
	/**
	 * 设置：收货人所在省
	 */
	public void setReceiverProvince(Integer receiverProvince) {
		this.receiverProvince = receiverProvince;
	}
	/**
	 * 获取：收货人所在省
	 */
	public Integer getReceiverProvince() {
		return receiverProvince;
	}
	/**
	 * 设置：收货人所在城市
	 */
	public void setReceiverCity(Integer receiverCity) {
		this.receiverCity = receiverCity;
	}
	/**
	 * 获取：收货人所在城市
	 */
	public Integer getReceiverCity() {
		return receiverCity;
	}
	/**
	 * 设置：收货人所在街道
	 */
	public void setReceiverDistrict(Integer receiverDistrict) {
		this.receiverDistrict = receiverDistrict;
	}
	/**
	 * 获取：收货人所在街道
	 */
	public Integer getReceiverDistrict() {
		return receiverDistrict;
	}
	/**
	 * 设置：收货人详细地址
	 */
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	/**
	 * 获取：收货人详细地址
	 */
	public String getReceiverAddress() {
		return receiverAddress;
	}
	/**
	 * 设置：收货人邮编
	 */
	public void setReceiverZip(String receiverZip) {
		this.receiverZip = receiverZip;
	}
	/**
	 * 获取：收货人邮编
	 */
	public String getReceiverZip() {
		return receiverZip;
	}
	/**
	 * 设置：收货人姓名
	 */
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	/**
	 * 获取：收货人姓名
	 */
	public String getReceiverName() {
		return receiverName;
	}
	/**
	 * 设置：卖家店铺id
	 */
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	/**
	 * 获取：卖家店铺id
	 */
	public Integer getShopId() {
		return shopId;
	}
	/**
	 * 设置：卖家店铺名称
	 */
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	/**
	 * 获取：卖家店铺名称
	 */
	public String getShopName() {
		return shopName;
	}
	/**
	 * 设置：卖家对订单的标注星标
	 */
	public void setSellerStar(Integer sellerStar) {
		this.sellerStar = sellerStar;
	}
	/**
	 * 获取：卖家对订单的标注星标
	 */
	public Integer getSellerStar() {
		return sellerStar;
	}
	/**
	 * 设置：卖家对订单的备注
	 */
	public void setSellerMemo(String sellerMemo) {
		this.sellerMemo = sellerMemo;
	}
	/**
	 * 获取：卖家对订单的备注
	 */
	public String getSellerMemo() {
		return sellerMemo;
	}
	/**
	 * 设置：卖家延迟发货时间
	 */
	public void setConsignTimeAdjust(Integer consignTimeAdjust) {
		this.consignTimeAdjust = consignTimeAdjust;
	}
	/**
	 * 获取：卖家延迟发货时间
	 */
	public Integer getConsignTimeAdjust() {
		return consignTimeAdjust;
	}
	/**
	 * 设置：商品总价
	 */
	public void setGoodsMoney(BigDecimal goodsMoney) {
		this.goodsMoney = goodsMoney;
	}
	/**
	 * 获取：商品总价
	 */
	public BigDecimal getGoodsMoney() {
		return goodsMoney;
	}
	/**
	 * 设置：订单总价
	 */
	public void setOrderMoney(BigDecimal orderMoney) {
		this.orderMoney = orderMoney;
	}
	/**
	 * 获取：订单总价
	 */
	public BigDecimal getOrderMoney() {
		return orderMoney;
	}
	/**
	 * 设置：订单消耗积分
	 */
	public void setPoint(Integer point) {
		this.point = point;
	}
	/**
	 * 获取：订单消耗积分
	 */
	public Integer getPoint() {
		return point;
	}
	/**
	 * 设置：订单消耗积分抵多少钱
	 */
	public void setPointMoney(BigDecimal pointMoney) {
		this.pointMoney = pointMoney;
	}
	/**
	 * 获取：订单消耗积分抵多少钱
	 */
	public BigDecimal getPointMoney() {
		return pointMoney;
	}
	/**
	 * 设置：订单代金券支付金额
	 */
	public void setCouponMoney(BigDecimal couponMoney) {
		this.couponMoney = couponMoney;
	}
	/**
	 * 获取：订单代金券支付金额
	 */
	public BigDecimal getCouponMoney() {
		return couponMoney;
	}
	/**
	 * 设置：订单代金券id
	 */
	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}
	/**
	 * 获取：订单代金券id
	 */
	public Integer getCouponId() {
		return couponId;
	}
	/**
	 * 设置：订单余额支付金额
	 */
	public void setUserMoney(BigDecimal userMoney) {
		this.userMoney = userMoney;
	}
	/**
	 * 获取：订单余额支付金额
	 */
	public BigDecimal getUserMoney() {
		return userMoney;
	}
	/**
	 * 设置：用户平台余额支付
	 */
	public void setUserPlatformMoney(BigDecimal userPlatformMoney) {
		this.userPlatformMoney = userPlatformMoney;
	}
	/**
	 * 获取：用户平台余额支付
	 */
	public BigDecimal getUserPlatformMoney() {
		return userPlatformMoney;
	}
	/**
	 * 设置：订单优惠活动金额
	 */
	public void setPromotionMoney(BigDecimal promotionMoney) {
		this.promotionMoney = promotionMoney;
	}
	/**
	 * 获取：订单优惠活动金额
	 */
	public BigDecimal getPromotionMoney() {
		return promotionMoney;
	}
	/**
	 * 设置：订单运费
	 */
	public void setShippingMoney(BigDecimal shippingMoney) {
		this.shippingMoney = shippingMoney;
	}
	/**
	 * 获取：订单运费
	 */
	public BigDecimal getShippingMoney() {
		return shippingMoney;
	}
	/**
	 * 设置：订单实付金额
	 */
	public void setPayMoney(BigDecimal payMoney) {
		this.payMoney = payMoney;
	}
	/**
	 * 获取：订单实付金额
	 */
	public BigDecimal getPayMoney() {
		return payMoney;
	}
	/**
	 * 设置：订单退款金额
	 */
	public void setRefundMoney(BigDecimal refundMoney) {
		this.refundMoney = refundMoney;
	}
	/**
	 * 获取：订单退款金额
	 */
	public BigDecimal getRefundMoney() {
		return refundMoney;
	}
	/**
	 * 设置：购物币金额
	 */
	public void setCoinMoney(BigDecimal coinMoney) {
		this.coinMoney = coinMoney;
	}
	/**
	 * 获取：购物币金额
	 */
	public BigDecimal getCoinMoney() {
		return coinMoney;
	}
	/**
	 * 设置：订单赠送积分
	 */
	public void setGivePoint(Integer givePoint) {
		this.givePoint = givePoint;
	}
	/**
	 * 获取：订单赠送积分
	 */
	public Integer getGivePoint() {
		return givePoint;
	}
	/**
	 * 设置：订单成功之后返购物币
	 */
	public void setGiveCoin(BigDecimal giveCoin) {
		this.giveCoin = giveCoin;
	}
	/**
	 * 获取：订单成功之后返购物币
	 */
	public BigDecimal getGiveCoin() {
		return giveCoin;
	}
	/**
	 * 设置：订单状态
	 */
	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * 获取：订单状态
	 */
	public Integer getOrderStatus() {
		return orderStatus;
	}
	/**
	 * 设置：订单付款状态
	 */
	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}
	/**
	 * 获取：订单付款状态
	 */
	public Integer getPayStatus() {
		return payStatus;
	}
	/**
	 * 设置：订单配送状态
	 */
	public void setShippingStatus(Integer shippingStatus) {
		this.shippingStatus = shippingStatus;
	}
	/**
	 * 获取：订单配送状态
	 */
	public Integer getShippingStatus() {
		return shippingStatus;
	}
	/**
	 * 设置：订单评价状态
	 */
	public void setReviewStatus(Integer reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	/**
	 * 获取：订单评价状态
	 */
	public Integer getReviewStatus() {
		return reviewStatus;
	}
	/**
	 * 设置：订单维权状态
	 */
	public void setFeedbackStatus(Integer feedbackStatus) {
		this.feedbackStatus = feedbackStatus;
	}
	/**
	 * 获取：订单维权状态
	 */
	public Integer getFeedbackStatus() {
		return feedbackStatus;
	}
	/**
	 * 设置：是否评价 0为未评价 1为已评价 2为已追评
	 */
	public void setIsEvaluate(Integer isEvaluate) {
		this.isEvaluate = isEvaluate;
	}
	/**
	 * 获取：是否评价 0为未评价 1为已评价 2为已追评
	 */
	public Integer getIsEvaluate() {
		return isEvaluate;
	}
	/**
	 * 设置：
	 */
	public void setTaxMoney(BigDecimal taxMoney) {
		this.taxMoney = taxMoney;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getTaxMoney() {
		return taxMoney;
	}
	/**
	 * 设置：配送物流公司ID
	 */
	public void setShippingCompanyId(Integer shippingCompanyId) {
		this.shippingCompanyId = shippingCompanyId;
	}
	/**
	 * 获取：配送物流公司ID
	 */
	public Integer getShippingCompanyId() {
		return shippingCompanyId;
	}
	/**
	 * 设置：积分返还类型 1 订单完成  2 订单收货 3  支付订单
	 */
	public void setGivePointType(Integer givePointType) {
		this.givePointType = givePointType;
	}
	/**
	 * 获取：积分返还类型 1 订单完成  2 订单收货 3  支付订单
	 */
	public Integer getGivePointType() {
		return givePointType;
	}
	/**
	 * 设置：订单付款时间
	 */
	public void setPayTime(Integer payTime) {
		this.payTime = payTime;
	}
	/**
	 * 获取：订单付款时间
	 */
	public Integer getPayTime() {
		return payTime;
	}
	/**
	 * 设置：买家要求配送时间
	 */
	public void setShippingTime(Integer shippingTime) {
		this.shippingTime = shippingTime;
	}
	/**
	 * 获取：买家要求配送时间
	 */
	public Integer getShippingTime() {
		return shippingTime;
	}
	/**
	 * 设置：买家签收时间
	 */
	public void setSignTime(Integer signTime) {
		this.signTime = signTime;
	}
	/**
	 * 获取：买家签收时间
	 */
	public Integer getSignTime() {
		return signTime;
	}
	/**
	 * 设置：卖家发货时间
	 */
	public void setConsignTime(Integer consignTime) {
		this.consignTime = consignTime;
	}
	/**
	 * 获取：卖家发货时间
	 */
	public Integer getConsignTime() {
		return consignTime;
	}
	/**
	 * 设置：订单创建时间
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：订单创建时间
	 */
	public Integer getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：订单完成时间
	 */
	public void setFinishTime(Integer finishTime) {
		this.finishTime = finishTime;
	}
	/**
	 * 获取：订单完成时间
	 */
	public Integer getFinishTime() {
		return finishTime;
	}
	/**
	 * 设置：订单是否已删除
	 */
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	/**
	 * 获取：订单是否已删除
	 */
	public Integer getIsDeleted() {
		return isDeleted;
	}
	/**
	 * 设置：操作人类型  1店铺  2用户
	 */
	public void setOperatorType(Integer operatorType) {
		this.operatorType = operatorType;
	}
	/**
	 * 获取：操作人类型  1店铺  2用户
	 */
	public Integer getOperatorType() {
		return operatorType;
	}
	/**
	 * 设置：操作人id
	 */
	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}
	/**
	 * 获取：操作人id
	 */
	public Integer getOperatorId() {
		return operatorId;
	}
	/**
	 * 设置：订单退款余额
	 */
	public void setRefundBalanceMoney(BigDecimal refundBalanceMoney) {
		this.refundBalanceMoney = refundBalanceMoney;
	}
	/**
	 * 获取：订单退款余额
	 */
	public BigDecimal getRefundBalanceMoney() {
		return refundBalanceMoney;
	}
	/**
	 * 设置：固定电话
	 */
	public void setFixedTelephone(String fixedTelephone) {
		this.fixedTelephone = fixedTelephone;
	}
	/**
	 * 获取：固定电话
	 */
	public String getFixedTelephone() {
		return fixedTelephone;
	}
	public int getKeyId() {
		return keyId;
	}
	public void setKeyId(int keyId) {
		this.keyId = keyId;
	}
	public int getKeyCommentFlag() {
		return keyCommentFlag;
	}
	public void setKeyCommentFlag(int keyCommentFlag) {
		this.keyCommentFlag = keyCommentFlag;
	}
	public StarEntity getStar() {
		return star;
	}
	public void setStar(StarEntity star) {
		this.star = star;
	}
	public String getStarName() {
		return starName;
	}
	public void setStarName(String starName) {
		this.starName = starName;
	}
	public int getOrderMaxUsePoint() {
		return orderMaxUsePoint;
	}
	public void setOrderMaxUsePoint(int orderMaxUsePoint) {
		this.orderMaxUsePoint = orderMaxUsePoint;
	}
	public String getRefundReason() {
		return refundReason;
	}
	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}
}
