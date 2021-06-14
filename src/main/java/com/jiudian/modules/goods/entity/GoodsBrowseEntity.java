package com.jiudian.modules.goods.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 商品足迹表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
@TableName("ns_goods_browse")
public class GoodsBrowseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer browseId;
	/**
	 * 商品id
	 */
	private Integer goodsId;
	/**
	 * 用户id
	 */
	private Integer uid;
	/**
	 * 浏览时间
	 */
	private Integer createTime;
	/**
	 * 分类id
	 */
	private Integer categoryId;

	/**
	 * 设置：
	 */
	public void setBrowseId(Integer browseId) {
		this.browseId = browseId;
	}
	/**
	 * 获取：
	 */
	public Integer getBrowseId() {
		return browseId;
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
	 * 设置：浏览时间
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：浏览时间
	 */
	public Integer getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：分类id
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	/**
	 * 获取：分类id
	 */
	public Integer getCategoryId() {
		return categoryId;
	}
}
