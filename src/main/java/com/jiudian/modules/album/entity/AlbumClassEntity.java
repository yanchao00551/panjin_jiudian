package com.jiudian.modules.album.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 相册表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-11 17:15:11
 */
@TableName("sys_album_class")
public class AlbumClassEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 相册id
	 */
	@TableId
	private Integer albumId;
	/**
	 * 店铺id
	 */
	private Integer shopId;
	/**
	 * 上级相册ID
	 */
	private Integer pid;
	/**
	 * 相册名称
	 */
	private String albumName;
	/**
	 * 相册封面
	 */
	private String albumCover;
	/**
	 * 是否为默认相册,1代表默认
	 */
	private Integer isDefault;
	/**
	 * 
	 */
	private Integer sort;
	/**
	 * 创建时间
	 */
	private Integer createTime;

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
	 * 设置：上级相册ID
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 获取：上级相册ID
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * 设置：相册名称
	 */
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	/**
	 * 获取：相册名称
	 */
	public String getAlbumName() {
		return albumName;
	}
	/**
	 * 设置：相册封面
	 */
	public void setAlbumCover(String albumCover) {
		this.albumCover = albumCover;
	}
	/**
	 * 获取：相册封面
	 */
	public String getAlbumCover() {
		return albumCover;
	}
	/**
	 * 设置：是否为默认相册,1代表默认
	 */
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	/**
	 * 获取：是否为默认相册,1代表默认
	 */
	public Integer getIsDefault() {
		return isDefault;
	}
	/**
	 * 设置：
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：
	 */
	public Integer getSort() {
		return sort;
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
