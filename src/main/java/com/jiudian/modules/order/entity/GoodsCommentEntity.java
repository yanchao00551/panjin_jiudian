package com.jiudian.modules.order.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jiudian.modules.app.entity.UserEntity;
import com.jiudian.modules.goods.entity.GoodsEntity;

/**
 * 商品评论送积分记录表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-09-27 11:50:49
 */
@TableName("ns_goods_comment")
public class GoodsCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@TableId
	private Integer id;
	/**
	 * 用户id
	 */
	private Integer uid;
	/**
	 * 店铺id
	 */
	private Integer shopId;
	/**
	 * 订单id
	 */
	private Integer orderId;
	/**
	 * 评论创建时间
	 */
	private Integer createTime;
	/**
	 * 评价内容
	 */
	private String comments;
	/**
	 * 评分1.0-5.0
	 */
	private Double point;
	/**
	 * 商品ID
	 */
	private Integer goodsId;
	
	private int reviewStatus;
	
	@TableField(exist = false)
	private UserEntity userEntity;
	
	@TableField(exist = false)
	private GoodsEntity goodsInfo;
	
	@TableField(exist = false)
	private String nickName;
	
	@TableField(exist = false)
	private String goodsName;
	
	/**
	 * 评价时间（前台展示用）
	 */
	@TableField(exist = false)
	private String commentDate;

	/**
	 * 设置：主键id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：用户id
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：用户id
	 */
	public Integer getUid() {
		return uid;
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
	 * 设置：评论创建时间
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：评论创建时间
	 */
	public Integer getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：评价内容
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	/**
	 * 获取：评价内容
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * 设置：评分1.0-5.0
	 */
	public void setPoint(Double point) {
		this.point = point;
	}
	/**
	 * 获取：评分1.0-5.0
	 */
	public Double getPoint() {
		return point;
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
	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	public String getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}
	public int getReviewStatus() {
		return reviewStatus;
	}
	public void setReviewStatus(int reviewStatus) {
		this.reviewStatus = reviewStatus;
	}
	public GoodsEntity getGoodsInfo() {
		return goodsInfo;
	}
	public void setGoodsInfo(GoodsEntity goodsInfo) {
		this.goodsInfo = goodsInfo;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
}
