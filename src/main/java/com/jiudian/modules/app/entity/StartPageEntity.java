package com.jiudian.modules.app.entity;

import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.cms.entity.CmsArticleSimpleEntity;
import com.jiudian.modules.goods.entity.GoodsCategoryEntity;
import com.jiudian.modules.goods.entity.GoodsGroupEntity;

public class StartPageEntity {

	//首页走马灯三张图片
	private List<AlbumPictureEntity> turnImg = null;
	
	@TableField(exist = false) 
	private List<GoodsGroupEntity> groupEntities = null;
	
	@TableField(exist = false) 
	private List<GoodsCategoryEntity> categoryEntities = null;
	
	@TableField(exist = false) 
	private PageUtils roomEntities = null;
	
	@TableField(exist = false) 
	private PageUtils goodsEntities = null;
	
	private AlbumPictureEntity prizeImg = null;
	
	@TableField(exist = false) 
	private List<CmsArticleSimpleEntity> articleSimpleEntities = null;
	

	public List<GoodsGroupEntity> getGroupEntities() {
		return groupEntities;
	}

	public List<AlbumPictureEntity> getTurnImg() {
		return turnImg;
	}

	public void setTurnImg(List<AlbumPictureEntity> turnImg) {
		this.turnImg = turnImg;
	}

	public void setGroupEntities(List<GoodsGroupEntity> groupEntities) {
		this.groupEntities = groupEntities;
	}

	public List<GoodsCategoryEntity> getCategoryEntities() {
		return categoryEntities;
	}

	public void setCategoryEntities(List<GoodsCategoryEntity> categoryEntities) {
		this.categoryEntities = categoryEntities;
	}

	public PageUtils getRoomEntities() {
		return roomEntities;
	}

	public void setRoomEntities(PageUtils roomEntities) {
		this.roomEntities = roomEntities;
	}

	public PageUtils getGoodsEntities() {
		return goodsEntities;
	}

	public void setGoodsEntities(PageUtils goodsEntities) {
		this.goodsEntities = goodsEntities;
	}

	public AlbumPictureEntity getPrizeImg() {
		return prizeImg;
	}

	public void setPrizeImg(AlbumPictureEntity prizeImg) {
		this.prizeImg = prizeImg;
	}

	public List<CmsArticleSimpleEntity> getArticleSimpleEntities() {
		return articleSimpleEntities;
	}

	public void setArticleSimpleEntities(List<CmsArticleSimpleEntity> articleSimpleEntities) {
		this.articleSimpleEntities = articleSimpleEntities;
	}
	
	
	
	
	
}
