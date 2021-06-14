package com.jiudian.modules.goods.entity;

import com.jiudian.modules.album.entity.AlbumPictureEntity;

public class RecommendGoodsInfo {
	
	private String goodsId;

	//商品图片
	private AlbumPictureEntity albumPictureEntity;
	
	//商品售价
	private String sellPrice;
	
	//商品名称
	private String goodsName;
	
	//商品销量
	private String soldCount;

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public AlbumPictureEntity getAlbumPictureEntity() {
		return albumPictureEntity;
	}

	public void setAlbumPictureEntity(AlbumPictureEntity albumPictureEntity) {
		this.albumPictureEntity = albumPictureEntity;
	}

	public String getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(String sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getSoldCount() {
		return soldCount;
	}

	public void setSoldCount(String soldCount) {
		this.soldCount = soldCount;
	}
}
