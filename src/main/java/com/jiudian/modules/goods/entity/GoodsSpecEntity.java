package com.jiudian.modules.goods.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.List;

/**
 * 商品属性（规格）表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:53
 */
@TableName("ns_goods_spec")
public class GoodsSpecEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 属性ID
	 */
	@TableId
	private Integer specId;
	/**
	 * 店铺ID
	 */
	private Integer shopId;
	/**
	 * 属性名称
	 */
	private String specName;
	/**
	 * 是否可视
	 */
	private Integer isVisible;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 展示方式 1 文字 2 颜色 3 图片
	 */
	private Integer showType;
	/**
	 * 创建日期
	 */
	private Integer createTime;
	/**
	 * 是否参与筛选 0 不参与 1 参与
	 */
	private Integer isScreen;
	/**
	 * 属性说明
	 */
	private String specDes;
	
	/**
	 * 商品关联ID
	 */
	private Integer goodsId;
	
	/*---- other --- */
	@TableField(exist = false) 
	private List<GoodsSpecValueEntity> specValueList;
	@TableField(exist = false) 
	private String goodsSpecValueName;
	@TableField(exist = false) 
	private String specValueNameList;
	
	
	
	public Integer getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}
	public String getSpecValueNameList() {
		return specValueNameList;
	}
	public void setSpecValueNameList(String specValueNameList) {
		this.specValueNameList = specValueNameList;
	}
	public List<GoodsSpecValueEntity> getSpecValueList() {
		return specValueList;
	}
	public void setSpecValueList(List<GoodsSpecValueEntity> specValueList) {
		this.specValueList = specValueList;
	}
	public String getGoodsSpecValueName() {
		return goodsSpecValueName;
	}
	public void setGoodsSpecValueName(String goodsSpecValueName) {
		this.goodsSpecValueName = goodsSpecValueName;
	}
	/**
	 * 设置：属性ID
	 */
	public void setSpecId(Integer specId) {
		this.specId = specId;
	}
	/**
	 * 获取：属性ID
	 */
	public Integer getSpecId() {
		return specId;
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
	 * 设置：属性名称
	 */
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	/**
	 * 获取：属性名称
	 */
	public String getSpecName() {
		return specName;
	}
	/**
	 * 设置：是否可视
	 */
	public void setIsVisible(Integer isVisible) {
		this.isVisible = isVisible;
	}
	/**
	 * 获取：是否可视
	 */
	public Integer getIsVisible() {
		return isVisible;
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
	 * 设置：展示方式 1 文字 2 颜色 3 图片
	 */
	public void setShowType(Integer showType) {
		this.showType = showType;
	}
	/**
	 * 获取：展示方式 1 文字 2 颜色 3 图片
	 */
	public Integer getShowType() {
		return showType;
	}
	/**
	 * 设置：创建日期
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建日期
	 */
	public Integer getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：是否参与筛选 0 不参与 1 参与
	 */
	public void setIsScreen(Integer isScreen) {
		this.isScreen = isScreen;
	}
	/**
	 * 获取：是否参与筛选 0 不参与 1 参与
	 */
	public Integer getIsScreen() {
		return isScreen;
	}
	/**
	 * 设置：属性说明
	 */
	public void setSpecDes(String specDes) {
		this.specDes = specDes;
	}
	/**
	 * 获取：属性说明
	 */
	public String getSpecDes() {
		return specDes;
	}
}
