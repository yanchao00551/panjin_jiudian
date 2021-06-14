package com.jiudian.modules.goods.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 商品评价表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
@TableName("ns_goods_evaluate")
public class GoodsEvaluateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 评价ID
	 */
	@TableId
	private Integer id;
	/**
	 * 订单ID
	 */
	private Integer orderId;
	/**
	 * 订单编号
	 */
	private Long orderNo;
	/**
	 * 订单项ID
	 */
	private Integer orderGoodsId;
	/**
	 * 商品ID
	 */
	private Integer goodsId;
	/**
	 * 商品名称
	 */
	private String goodsName;
	/**
	 * 商品价格
	 */
	private BigDecimal goodsPrice;
	/**
	 * 商品图片
	 */
	private String goodsImage;
	/**
	 * 店铺ID
	 */
	private Integer shopId;
	/**
	 * 店铺名称
	 */
	private String shopName;
	/**
	 * 评价内容
	 */
	private String content;
	/**
	 * 评价图片
	 */
	private String image;
	/**
	 * 解释内容
	 */
	private String explainFirst;
	/**
	 * 评价人名称
	 */
	private String memberName;
	/**
	 * 评价人编号
	 */
	private Integer uid;
	/**
	 * 0表示不是 1表示是匿名评价
	 */
	private Integer isAnonymous;
	/**
	 * 1-5分
	 */
	private Integer scores;
	/**
	 * 追加评价内容
	 */
	private String againContent;
	/**
	 * 追评评价图片
	 */
	private String againImage;
	/**
	 * 追加解释内容
	 */
	private String againExplain;
	/**
	 * 1好评2中评3差评
	 */
	private Integer explainType;
	/**
	 * 1显示 0隐藏
	 */
	private Integer isShow;
	/**
	 * 评价时间
	 */
	private Integer addtime;
	/**
	 * 追加评价时间
	 */
	private Integer againAddtime;

	/**
	 * 设置：评价ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：评价ID
	 */
	public Integer getId() {
		return id;
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
	 * 设置：订单编号
	 */
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	/**
	 * 获取：订单编号
	 */
	public Long getOrderNo() {
		return orderNo;
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
	 * 设置：商品价格
	 */
	public void setGoodsPrice(BigDecimal goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	/**
	 * 获取：商品价格
	 */
	public BigDecimal getGoodsPrice() {
		return goodsPrice;
	}
	/**
	 * 设置：商品图片
	 */
	public void setGoodsImage(String goodsImage) {
		this.goodsImage = goodsImage;
	}
	/**
	 * 获取：商品图片
	 */
	public String getGoodsImage() {
		return goodsImage;
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
	 * 设置：评价内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：评价内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：评价图片
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * 获取：评价图片
	 */
	public String getImage() {
		return image;
	}
	/**
	 * 设置：解释内容
	 */
	public void setExplainFirst(String explainFirst) {
		this.explainFirst = explainFirst;
	}
	/**
	 * 获取：解释内容
	 */
	public String getExplainFirst() {
		return explainFirst;
	}
	/**
	 * 设置：评价人名称
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	/**
	 * 获取：评价人名称
	 */
	public String getMemberName() {
		return memberName;
	}
	/**
	 * 设置：评价人编号
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：评价人编号
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：0表示不是 1表示是匿名评价
	 */
	public void setIsAnonymous(Integer isAnonymous) {
		this.isAnonymous = isAnonymous;
	}
	/**
	 * 获取：0表示不是 1表示是匿名评价
	 */
	public Integer getIsAnonymous() {
		return isAnonymous;
	}
	/**
	 * 设置：1-5分
	 */
	public void setScores(Integer scores) {
		this.scores = scores;
	}
	/**
	 * 获取：1-5分
	 */
	public Integer getScores() {
		return scores;
	}
	/**
	 * 设置：追加评价内容
	 */
	public void setAgainContent(String againContent) {
		this.againContent = againContent;
	}
	/**
	 * 获取：追加评价内容
	 */
	public String getAgainContent() {
		return againContent;
	}
	/**
	 * 设置：追评评价图片
	 */
	public void setAgainImage(String againImage) {
		this.againImage = againImage;
	}
	/**
	 * 获取：追评评价图片
	 */
	public String getAgainImage() {
		return againImage;
	}
	/**
	 * 设置：追加解释内容
	 */
	public void setAgainExplain(String againExplain) {
		this.againExplain = againExplain;
	}
	/**
	 * 获取：追加解释内容
	 */
	public String getAgainExplain() {
		return againExplain;
	}
	/**
	 * 设置：1好评2中评3差评
	 */
	public void setExplainType(Integer explainType) {
		this.explainType = explainType;
	}
	/**
	 * 获取：1好评2中评3差评
	 */
	public Integer getExplainType() {
		return explainType;
	}
	/**
	 * 设置：1显示 0隐藏
	 */
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	/**
	 * 获取：1显示 0隐藏
	 */
	public Integer getIsShow() {
		return isShow;
	}
	/**
	 * 设置：评价时间
	 */
	public void setAddtime(Integer addtime) {
		this.addtime = addtime;
	}
	/**
	 * 获取：评价时间
	 */
	public Integer getAddtime() {
		return addtime;
	}
	/**
	 * 设置：追加评价时间
	 */
	public void setAgainAddtime(Integer againAddtime) {
		this.againAddtime = againAddtime;
	}
	/**
	 * 获取：追加评价时间
	 */
	public Integer getAgainAddtime() {
		return againAddtime;
	}
}
