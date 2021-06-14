package com.jiudian.modules.app.entity;

import java.util.List;

import com.jiudian.modules.album.entity.AlbumPictureEntity;

public class RoomAttrbuteInfo {

	private String attrKey;

	private List<RoomAttributeValues> attributeValues;
	
	private int isIcon;
	
	private int ico;
	
	private AlbumPictureEntity iconDetail;

	public String getAttrKey() {
		return attrKey;
	}

	public void setAttrKey(String attrKey) {
		this.attrKey = attrKey;
	}

	public List<RoomAttributeValues> getAttributeValues() {
		return attributeValues;
	}

	public void setAttributeValues(List<RoomAttributeValues> attributeValues) {
		this.attributeValues = attributeValues;
	}

	public int getIsIcon() {
		return isIcon;
	}

	public void setIsIcon(int isIcon) {
		this.isIcon = isIcon;
	}

	public AlbumPictureEntity getIconDetail() {
		return iconDetail;
	}

	public void setIconDetail(AlbumPictureEntity iconDetail) {
		this.iconDetail = iconDetail;
	}

	public int getIco() {
		return ico;
	}

	public void setIco(int ico) {
		this.ico = ico;
	}

}
