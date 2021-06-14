package com.jiudian.modules.order.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.express.entity.ExpressCompanyEntity;
import com.jiudian.modules.goods.entity.GoodsAttributeEntity;
import com.jiudian.modules.goods.entity.GoodsEntity;

/**
 * 订单商品表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:36
 */
@TableName("ns_order_goods")
public class OrderGoodsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 订单项ID
	 */
	@TableId
	private Integer orderGoodsId;
	/**
	 * 订单ID
	 */
	private Integer orderId;
	/**
	 * 商品ID
	 */
	private Integer goodsId;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * skuID
	 */
	private Integer skuId;
	/**
	 * sku名称
	 */
	private String skuName;
	/**
	 * 商品价格
	 */
	private BigDecimal price;
	/**
	 * 商品成本价
	 */
	private BigDecimal costPrice;
	/**
	 * 购买数量
	 */
	private String num;
	/**
	 * 调整金额
	 */
	private BigDecimal adjustMoney;
	/**
	 * 商品总价
	 */
	private BigDecimal goodsMoney;
	/**
	 * 商品图片
	 */
	private Integer goodsPicture;
	/**
	 * 店铺ID
	 */
	private Integer shopId;
	/**
	 * 购买人ID
	 */
	private Integer buyerId;
	/**
	 * 积分兑换类型0.非积分兑换1.积分兑换
	 */
	private Integer pointExchangeType;
	/**
	 * 商品类型
	 */
	private String goodsType;
	/**
	 * 促销ID
	 */
	private Integer promotionId;
	/**
	 * 促销类型
	 */
	private Integer promotionTypeId;
	/**
	 * 订单类型
	 */
	private Integer orderType;
	/**
	 * 订单状态
	 */
	private Integer orderStatus;
	/**
	 * 积分数量
	 */
	private Integer givePoint;
	/**
	 * 物流状态
	 */
	private Integer shippingStatus;
	/**
	 * 退款方式
	 */
	private Integer refundType;
	/**
	 * 退款金额
	 */
	private BigDecimal refundRequireMoney;
	/**
	 * 退款原因
	 */
	private String refundReason;
	/**
	 * 退款物流单号
	 */
	private String refundShippingCode;
	/**
	 * 退款物流公司名称
	 */
	private String refundShippingCompany;
	/**
	 * 实际退款金额
	 */
	private BigDecimal refundRealMoney;
	/**
	 * 退款状态
	 */
	private Integer refundStatus;
	/**
	 * 备注
	 */
	private String memo;
	/**
	 * 是否评价 0为未评价 1为已评价 2为已追评
	 */
	private Integer isEvaluate;
	/**
	 * 退款时间
	 */
	private Integer refundTime;
	/**
	 * 订单退款余额
	 */
	private BigDecimal refundBalanceMoney;
	/**
	 * 批量打印时添加的临时物流公司
	 */
	private String tmpExpressCompany;
	/**
	 * 批量打印时添加的临时物流公司id
	 */
	private Integer tmpExpressCompanyId;
	/**
	 * 批量打印时添加的临时订单编号
	 */
	private String tmpExpressNo;
	
	
	private Date liveinDate;
	
	private Date leaveoutDate;
	
	/**
	 * 赠品标识，0:不是赠品，大于0：赠品id
	 */
	private Integer giftFlag;
	
	/*------------ other --------*/
	@TableField(exist = false) 
	private String code;
	@TableField(exist = false)
	private AlbumPictureEntity picture;
	@TableField(exist = false)
	private ExpressCompanyEntity expressInfo;
	@TableField(exist = false)
	private String shippingStatusName;
	@TableField(exist = false)
	private AlbumPictureEntity pictureInfo;
	@TableField(exist = false)
	private String refundOperation;
	@TableField(exist = false)
	private GoodsEntity goodsEntities;
	@TableField(exist = false)
	private GoodsAttributeEntity goodsAttributeEntity;
	@TableField(exist = false)
	private String attrName;
	@TableField(exist = false)
	private int state;

	private int maxUsePoint;
	
	
	public String getRefundOperation() {
		return refundOperation;
	}
	public void setRefundOperation(String refundOperation) {
		this.refundOperation = refundOperation;
	}
	public AlbumPictureEntity getPictureInfo() {
		return pictureInfo;
	}
	public void setPictureInfo(AlbumPictureEntity pictureInfo) {
		this.pictureInfo = pictureInfo;
	}
	public String getShippingStatusName() {
		return shippingStatusName;
	}
	public void setShippingStatusName(String shippingStatusName) {
		this.shippingStatusName = shippingStatusName;
	}
	public ExpressCompanyEntity getExpressInfo() {
		return expressInfo;
	}
	public void setExpressInfo(ExpressCompanyEntity expressInfo) {
		this.expressInfo = expressInfo;
	}
	public AlbumPictureEntity getPicture() {
		return picture;
	}
	public void setPicture(AlbumPictureEntity picture) {
		this.picture = picture;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * 设置：订单项ID
	 */
	public void setOrderGoodsId(Integer orderGoodsId) {
		this.orderGoodsId = orderGoodsId;
	}
	/**
	 * 获取：订单项ID
	 */
	public Integer getOrderGoodsId() {
		return orderGoodsId;
	}
	/**
	 * 设置：订单ID
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	/**
	 * 获取：订单ID
	 */
	public Integer getOrderId() {
		return orderId;
	}
	/**
	 * 设置：商品ID
	 */
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	/**
	 * 获取：商品ID
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
	 * 设置：skuID
	 */
	public void setSkuId(Integer skuId) {
		this.skuId = skuId;
	}
	/**
	 * 获取：skuID
	 */
	public Integer getSkuId() {
		return skuId;
	}
	/**
	 * 设置：sku名称
	 */
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
	/**
	 * 获取：sku名称
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
	 * 设置：商品成本价
	 */
	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}
	/**
	 * 获取：商品成本价
	 */
	public BigDecimal getCostPrice() {
		return costPrice;
	}
	/**
	 * 设置：购买数量
	 */
	public void setNum(String num) {
		this.num = num;
	}
	/**
	 * 获取：购买数量
	 */
	public String getNum() {
		return num;
	}
	/**
	 * 设置：调整金额
	 */
	public void setAdjustMoney(BigDecimal adjustMoney) {
		this.adjustMoney = adjustMoney;
	}
	/**
	 * 获取：调整金额
	 */
	public BigDecimal getAdjustMoney() {
		return adjustMoney;
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
	 * 设置：购买人ID
	 */
	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}
	/**
	 * 获取：购买人ID
	 */
	public Integer getBuyerId() {
		return buyerId;
	}
	/**
	 * 设置：积分兑换类型0.非积分兑换1.积分兑换
	 */
	public void setPointExchangeType(Integer pointExchangeType) {
		this.pointExchangeType = pointExchangeType;
	}
	/**
	 * 获取：积分兑换类型0.非积分兑换1.积分兑换
	 */
	public Integer getPointExchangeType() {
		return pointExchangeType;
	}
	/**
	 * 设置：商品类型
	 */
	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}
	/**
	 * 获取：商品类型
	 */
	public String getGoodsType() {
		return goodsType;
	}
	/**
	 * 设置：促销ID
	 */
	public void setPromotionId(Integer promotionId) {
		this.promotionId = promotionId;
	}
	/**
	 * 获取：促销ID
	 */
	public Integer getPromotionId() {
		return promotionId;
	}
	/**
	 * 设置：促销类型
	 */
	public void setPromotionTypeId(Integer promotionTypeId) {
		this.promotionTypeId = promotionTypeId;
	}
	/**
	 * 获取：促销类型
	 */
	public Integer getPromotionTypeId() {
		return promotionTypeId;
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
	 * 设置：积分数量
	 */
	public void setGivePoint(Integer givePoint) {
		this.givePoint = givePoint;
	}
	/**
	 * 获取：积分数量
	 */
	public Integer getGivePoint() {
		return givePoint;
	}
	/**
	 * 设置：物流状态
	 */
	public void setShippingStatus(Integer shippingStatus) {
		this.shippingStatus = shippingStatus;
	}
	/**
	 * 获取：物流状态
	 */
	public Integer getShippingStatus() {
		return shippingStatus;
	}
	/**
	 * 设置：退款方式
	 */
	public void setRefundType(Integer refundType) {
		this.refundType = refundType;
	}
	/**
	 * 获取：退款方式
	 */
	public Integer getRefundType() {
		return refundType;
	}
	/**
	 * 设置：退款金额
	 */
	public void setRefundRequireMoney(BigDecimal refundRequireMoney) {
		this.refundRequireMoney = refundRequireMoney;
	}
	/**
	 * 获取：退款金额
	 */
	public BigDecimal getRefundRequireMoney() {
		return refundRequireMoney;
	}
	/**
	 * 设置：退款原因
	 */
	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}
	/**
	 * 获取：退款原因
	 */
	public String getRefundReason() {
		return refundReason;
	}
	/**
	 * 设置：退款物流单号
	 */
	public void setRefundShippingCode(String refundShippingCode) {
		this.refundShippingCode = refundShippingCode;
	}
	/**
	 * 获取：退款物流单号
	 */
	public String getRefundShippingCode() {
		return refundShippingCode;
	}
	/**
	 * 设置：退款物流公司名称
	 */
	public void setRefundShippingCompany(String refundShippingCompany) {
		this.refundShippingCompany = refundShippingCompany;
	}
	/**
	 * 获取：退款物流公司名称
	 */
	public String getRefundShippingCompany() {
		return refundShippingCompany;
	}
	/**
	 * 设置：实际退款金额
	 */
	public void setRefundRealMoney(BigDecimal refundRealMoney) {
		this.refundRealMoney = refundRealMoney;
	}
	/**
	 * 获取：实际退款金额
	 */
	public BigDecimal getRefundRealMoney() {
		return refundRealMoney;
	}
	/**
	 * 设置：退款状态
	 */
	public void setRefundStatus(Integer refundStatus) {
		this.refundStatus = refundStatus;
	}
	/**
	 * 获取：退款状态
	 */
	public Integer getRefundStatus() {
		return refundStatus;
	}
	/**
	 * 设置：备注
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**
	 * 获取：备注
	 */
	public String getMemo() {
		return memo;
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
	 * 设置：退款时间
	 */
	public void setRefundTime(Integer refundTime) {
		this.refundTime = refundTime;
	}
	/**
	 * 获取：退款时间
	 */
	public Integer getRefundTime() {
		return refundTime;
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
	 * 设置：批量打印时添加的临时物流公司
	 */
	public void setTmpExpressCompany(String tmpExpressCompany) {
		this.tmpExpressCompany = tmpExpressCompany;
	}
	/**
	 * 获取：批量打印时添加的临时物流公司
	 */
	public String getTmpExpressCompany() {
		return tmpExpressCompany;
	}
	/**
	 * 设置：批量打印时添加的临时物流公司id
	 */
	public void setTmpExpressCompanyId(Integer tmpExpressCompanyId) {
		this.tmpExpressCompanyId = tmpExpressCompanyId;
	}
	/**
	 * 获取：批量打印时添加的临时物流公司id
	 */
	public Integer getTmpExpressCompanyId() {
		return tmpExpressCompanyId;
	}
	/**
	 * 设置：批量打印时添加的临时订单编号
	 */
	public void setTmpExpressNo(String tmpExpressNo) {
		this.tmpExpressNo = tmpExpressNo;
	}
	/**
	 * 获取：批量打印时添加的临时订单编号
	 */
	public String getTmpExpressNo() {
		return tmpExpressNo;
	}
	/**
	 * 设置：赠品标识，0:不是赠品，大于0：赠品id
	 */
	public void setGiftFlag(Integer giftFlag) {
		this.giftFlag = giftFlag;
	}
	/**
	 * 获取：赠品标识，0:不是赠品，大于0：赠品id
	 */
	public Integer getGiftFlag() {
		return giftFlag;
	}
	public GoodsEntity getGoodsEntities() {
		return goodsEntities;
	}
	public void setGoodsEntities(GoodsEntity goodsEntities) {
		this.goodsEntities = goodsEntities;
	}
	public Date getLiveinDate() {
		return liveinDate;
	}
	public void setLiveinDate(Date liveinDate) {
		this.liveinDate = liveinDate;
	}
	public Date getLeaveoutDate() {
		return leaveoutDate;
	}
	public void setLeaveoutDate(Date leaveoutDate) {
		this.leaveoutDate = leaveoutDate;
	}
	public GoodsAttributeEntity getGoodsAttributeEntity() {
		return goodsAttributeEntity;
	}
	public void setGoodsAttributeEntity(GoodsAttributeEntity goodsAttributeEntity) {
		this.goodsAttributeEntity = goodsAttributeEntity;
	}
	public String getAttrName() {
		return attrName;
	}
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
	public int getMaxUsePoint() {
		return maxUsePoint;
	}
	public void setMaxUsePoint(int maxUsePoint) {
		this.maxUsePoint = maxUsePoint;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
