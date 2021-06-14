package com.jiudian.modules.album.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 相册图片表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-11 17:15:11
 */
@TableName("sys_album_picture")
public class AlbumPictureEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 相册图片表id
	 */
	@TableId
	private Integer picId;
	/**
	 * 所属实例id
	 */
	private Integer shopId;
	/**
	 * 相册id
	 */
	private Integer albumId;
	/**
	 * 是否宽屏
	 */
	private Integer isWide;
	/**
	 * 图片名称
	 */
	private String picName;
	/**
	 * 图片标签
	 */
	private String picTag;
	/**
	 * 原图图片路径
	 */
	private String picCover;
	/**
	 * 原图大小
	 */
	private String picSize;
	/**
	 * 原图规格
	 */
	private String picSpec;
	/**
	 * 大图路径
	 */
	private String picCoverBig;
	/**
	 * 大图大小
	 */
	private String picSizeBig;
	/**
	 * 大图规格
	 */
	private String picSpecBig;
	/**
	 * 中图路径
	 */
	private String picCoverMid;
	/**
	 * 中图大小
	 */
	private String picSizeMid;
	/**
	 * 中图规格
	 */
	private String picSpecMid;
	/**
	 * 小图路径
	 */
	private String picCoverSmall;
	/**
	 * 小图大小
	 */
	private String picSizeSmall;
	/**
	 * 小图规格
	 */
	private String picSpecSmall;
	/**
	 * 微图路径
	 */
	private String picCoverMicro;
	/**
	 * 微图大小
	 */
	private String picSizeMicro;
	/**
	 * 微图规格
	 */
	private String picSpecMicro;
	/**
	 * 图片上传时间
	 */
	private Integer uploadTime;
	/**
	 * 图片外链
	 */
	private Integer uploadType;
	/**
	 * 图片外链
	 */
	private String domain;
	/**
	 * 存储空间名称
	 */
	private String bucket;

	/**
	 * 上传file原名称
	 */
	private String fileSourceName;
	
	
	public String getFileSourceName() {
		return fileSourceName;
	}
	public void setFileSourceName(String fileSourceName) {
		this.fileSourceName = fileSourceName;
	}
	/**
	 * 设置：相册图片表id
	 */
	public void setPicId(Integer picId) {
		this.picId = picId;
	}
	/**
	 * 获取：相册图片表id
	 */
	public Integer getPicId() {
		return picId;
	}
	/**
	 * 设置：所属实例id
	 */
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	/**
	 * 获取：所属实例id
	 */
	public Integer getShopId() {
		return shopId;
	}
	/**
	 * 设置：相册id
	 */
	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}
	/**
	 * 获取：相册id
	 */
	public Integer getAlbumId() {
		return albumId;
	}
	/**
	 * 设置：是否宽屏
	 */
	public void setIsWide(Integer isWide) {
		this.isWide = isWide;
	}
	/**
	 * 获取：是否宽屏
	 */
	public Integer getIsWide() {
		return isWide;
	}
	/**
	 * 设置：图片名称
	 */
	public void setPicName(String picName) {
		this.picName = picName;
	}
	/**
	 * 获取：图片名称
	 */
	public String getPicName() {
		return picName;
	}
	/**
	 * 设置：图片标签
	 */
	public void setPicTag(String picTag) {
		this.picTag = picTag;
	}
	/**
	 * 获取：图片标签
	 */
	public String getPicTag() {
		return picTag;
	}
	/**
	 * 设置：原图图片路径
	 */
	public void setPicCover(String picCover) {
		this.picCover = picCover;
	}
	/**
	 * 获取：原图图片路径
	 */
	public String getPicCover() {
		return picCover;
	}
	/**
	 * 设置：原图大小
	 */
	public void setPicSize(String picSize) {
		this.picSize = picSize;
	}
	/**
	 * 获取：原图大小
	 */
	public String getPicSize() {
		return picSize;
	}
	/**
	 * 设置：原图规格
	 */
	public void setPicSpec(String picSpec) {
		this.picSpec = picSpec;
	}
	/**
	 * 获取：原图规格
	 */
	public String getPicSpec() {
		return picSpec;
	}
	/**
	 * 设置：大图路径
	 */
	public void setPicCoverBig(String picCoverBig) {
		this.picCoverBig = picCoverBig;
	}
	/**
	 * 获取：大图路径
	 */
	public String getPicCoverBig() {
		return picCoverBig;
	}
	/**
	 * 设置：大图大小
	 */
	public void setPicSizeBig(String picSizeBig) {
		this.picSizeBig = picSizeBig;
	}
	/**
	 * 获取：大图大小
	 */
	public String getPicSizeBig() {
		return picSizeBig;
	}
	/**
	 * 设置：大图规格
	 */
	public void setPicSpecBig(String picSpecBig) {
		this.picSpecBig = picSpecBig;
	}
	/**
	 * 获取：大图规格
	 */
	public String getPicSpecBig() {
		return picSpecBig;
	}
	/**
	 * 设置：中图路径
	 */
	public void setPicCoverMid(String picCoverMid) {
		this.picCoverMid = picCoverMid;
	}
	/**
	 * 获取：中图路径
	 */
	public String getPicCoverMid() {
		return picCoverMid;
	}
	/**
	 * 设置：中图大小
	 */
	public void setPicSizeMid(String picSizeMid) {
		this.picSizeMid = picSizeMid;
	}
	/**
	 * 获取：中图大小
	 */
	public String getPicSizeMid() {
		return picSizeMid;
	}
	/**
	 * 设置：中图规格
	 */
	public void setPicSpecMid(String picSpecMid) {
		this.picSpecMid = picSpecMid;
	}
	/**
	 * 获取：中图规格
	 */
	public String getPicSpecMid() {
		return picSpecMid;
	}
	/**
	 * 设置：小图路径
	 */
	public void setPicCoverSmall(String picCoverSmall) {
		this.picCoverSmall = picCoverSmall;
	}
	/**
	 * 获取：小图路径
	 */
	public String getPicCoverSmall() {
		return picCoverSmall;
	}
	/**
	 * 设置：小图大小
	 */
	public void setPicSizeSmall(String picSizeSmall) {
		this.picSizeSmall = picSizeSmall;
	}
	/**
	 * 获取：小图大小
	 */
	public String getPicSizeSmall() {
		return picSizeSmall;
	}
	/**
	 * 设置：小图规格
	 */
	public void setPicSpecSmall(String picSpecSmall) {
		this.picSpecSmall = picSpecSmall;
	}
	/**
	 * 获取：小图规格
	 */
	public String getPicSpecSmall() {
		return picSpecSmall;
	}
	/**
	 * 设置：微图路径
	 */
	public void setPicCoverMicro(String picCoverMicro) {
		this.picCoverMicro = picCoverMicro;
	}
	/**
	 * 获取：微图路径
	 */
	public String getPicCoverMicro() {
		return picCoverMicro;
	}
	/**
	 * 设置：微图大小
	 */
	public void setPicSizeMicro(String picSizeMicro) {
		this.picSizeMicro = picSizeMicro;
	}
	/**
	 * 获取：微图大小
	 */
	public String getPicSizeMicro() {
		return picSizeMicro;
	}
	/**
	 * 设置：微图规格
	 */
	public void setPicSpecMicro(String picSpecMicro) {
		this.picSpecMicro = picSpecMicro;
	}
	/**
	 * 获取：微图规格
	 */
	public String getPicSpecMicro() {
		return picSpecMicro;
	}
	/**
	 * 设置：图片上传时间
	 */
	public void setUploadTime(Integer uploadTime) {
		this.uploadTime = uploadTime;
	}
	/**
	 * 获取：图片上传时间
	 */
	public Integer getUploadTime() {
		return uploadTime;
	}
	/**
	 * 设置：图片外链
	 */
	public void setUploadType(Integer uploadType) {
		this.uploadType = uploadType;
	}
	/**
	 * 获取：图片外链
	 */
	public Integer getUploadType() {
		return uploadType;
	}
	/**
	 * 设置：图片外链
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
	/**
	 * 获取：图片外链
	 */
	public String getDomain() {
		return domain;
	}
	/**
	 * 设置：存储空间名称
	 */
	public void setBucket(String bucket) {
		this.bucket = bucket;
	}
	/**
	 * 获取：存储空间名称
	 */
	public String getBucket() {
		return bucket;
	}
}
