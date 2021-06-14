package com.jiudian.modules.member.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 会员赠品表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-26 13:10:53
 */
@TableName("ns_member_gift")
public class MemberGiftEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer giftId;
	/**
	 * 会员ID
	 */
	private Integer uid;
	/**
	 * 赠品活动ID
	 */
	private Integer promotionGiftId;
	/**
	 * 赠品ID
	 */
	private Integer goodsId;
	/**
	 * 赠品名称
	 */
	private String goodsName;
	/**
	 * 赠品图片
	 */
	private Integer goodsPicture;
	/**
	 * 赠品数量
	 */
	private Integer num;
	/**
	 * 获取方式
	 */
	private Integer getType;
	/**
	 * 获取方式对应ID
	 */
	private Integer getTypeId;
	/**
	 * 说明
	 */
	private String desc;
	/**
	 * 创建时间
	 */
	private Integer createTime;

	/**
	 * 设置：主键
	 */
	public void setGiftId(Integer giftId) {
		this.giftId = giftId;
	}
	/**
	 * 获取：主键
	 */
	public Integer getGiftId() {
		return giftId;
	}
	/**
	 * 设置：会员ID
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：会员ID
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：赠品活动ID
	 */
	public void setPromotionGiftId(Integer promotionGiftId) {
		this.promotionGiftId = promotionGiftId;
	}
	/**
	 * 获取：赠品活动ID
	 */
	public Integer getPromotionGiftId() {
		return promotionGiftId;
	}
	/**
	 * 设置：赠品ID
	 */
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	/**
	 * 获取：赠品ID
	 */
	public Integer getGoodsId() {
		return goodsId;
	}
	/**
	 * 设置：赠品名称
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	/**
	 * 获取：赠品名称
	 */
	public String getGoodsName() {
		return goodsName;
	}
	/**
	 * 设置：赠品图片
	 */
	public void setGoodsPicture(Integer goodsPicture) {
		this.goodsPicture = goodsPicture;
	}
	/**
	 * 获取：赠品图片
	 */
	public Integer getGoodsPicture() {
		return goodsPicture;
	}
	/**
	 * 设置：赠品数量
	 */
	public void setNum(Integer num) {
		this.num = num;
	}
	/**
	 * 获取：赠品数量
	 */
	public Integer getNum() {
		return num;
	}
	/**
	 * 设置：获取方式
	 */
	public void setGetType(Integer getType) {
		this.getType = getType;
	}
	/**
	 * 获取：获取方式
	 */
	public Integer getGetType() {
		return getType;
	}
	/**
	 * 设置：获取方式对应ID
	 */
	public void setGetTypeId(Integer getTypeId) {
		this.getTypeId = getTypeId;
	}
	/**
	 * 获取：获取方式对应ID
	 */
	public Integer getGetTypeId() {
		return getTypeId;
	}
	/**
	 * 设置：说明
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * 获取：说明
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Integer getCreateTime() {
		return createTime;
	}
}
