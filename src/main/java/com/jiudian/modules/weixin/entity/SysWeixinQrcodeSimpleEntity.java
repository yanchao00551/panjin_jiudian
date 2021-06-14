package com.jiudian.modules.weixin.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jiudian.modules.album.entity.AlbumPictureEntity;

import java.io.Serializable;

/**
 * 推广码简洁表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
@TableName("sys_weixin_qrcode_simple")
public class SysWeixinQrcodeSimpleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 推广码图片ID
	 */
	private Integer qrcodeImg;
	
	/*-------- other ---------*/
	@TableField(exist = false)
	private AlbumPictureEntity picture;
	
	
	public AlbumPictureEntity getPicture() {
		return picture;
	}
	public void setPicture(AlbumPictureEntity picture) {
		this.picture = picture;
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
	 * 设置：推广码图片ID
	 */
	public void setQrcodeImg(Integer qrcodeImg) {
		this.qrcodeImg = qrcodeImg;
	}
	/**
	 * 获取：推广码图片ID
	 */
	public Integer getQrcodeImg() {
		return qrcodeImg;
	}
}
