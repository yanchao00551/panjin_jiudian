package com.jiudian.modules.goods.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jiudian.modules.album.entity.AlbumPictureEntity;

import java.io.Serializable;
import java.util.List;

/**
 * 商品sku多图
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:53
 */
@TableName("ns_goods_sku_picture")
public class GoodsSkuPictureEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 商品id
	 */
	private Integer goodsId;
	/**
	 * 店铺id
	 */
	private Integer shopId;
	/**
	 * 主规格id
	 */
	private Integer specId;
	/**
	 * 规格值id
	 */
	private Integer specValueId;
	/**
	 * 图片id 多个用逗号隔开
	 */
	private String skuImgArray;
	/**
	 * 创建时间
	 */
	private Integer createTime;
	/**
	 * 修改时间
	 */
	private Integer modifyTime;
	
	/*---------- other --------*/
	@TableField(exist = false) 
	List<AlbumPictureEntity> albumPictureList;
	@TableField(exist = false) 
	private String specName;
	@TableField(exist = false) 
	private String specValueName;
	@TableField(exist = false) 
	private List<AlbumPictureEntity> skuPictureQuery;
	
	
	

	public List<AlbumPictureEntity> getSkuPictureQuery() {
		return skuPictureQuery;
	}
	public void setSkuPictureQuery(List<AlbumPictureEntity> skuPictureQuery) {
		this.skuPictureQuery = skuPictureQuery;
	}
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	public String getSpecValueName() {
		return specValueName;
	}
	public void setSpecValueName(String specValueName) {
		this.specValueName = specValueName;
	}
	public List<AlbumPictureEntity> getAlbumPictureList() {
		return albumPictureList;
	}
	public void setAlbumPictureList(List<AlbumPictureEntity> albumPictureList) {
		this.albumPictureList = albumPictureList;
	}
	
	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
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
	 * 设置：主规格id
	 */
	public void setSpecId(Integer specId) {
		this.specId = specId;
	}
	/**
	 * 获取：主规格id
	 */
	public Integer getSpecId() {
		return specId;
	}
	/**
	 * 设置：规格值id
	 */
	public void setSpecValueId(Integer specValueId) {
		this.specValueId = specValueId;
	}
	/**
	 * 获取：规格值id
	 */
	public Integer getSpecValueId() {
		return specValueId;
	}
	/**
	 * 设置：图片id 多个用逗号隔开
	 */
	public void setSkuImgArray(String skuImgArray) {
		this.skuImgArray = skuImgArray;
	}
	/**
	 * 获取：图片id 多个用逗号隔开
	 */
	public String getSkuImgArray() {
		return skuImgArray;
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
	/**
	 * 设置：修改时间
	 */
	public void setModifyTime(Integer modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Integer getModifyTime() {
		return modifyTime;
	}
}
