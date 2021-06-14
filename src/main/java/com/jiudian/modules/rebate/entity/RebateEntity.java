package com.jiudian.modules.rebate.entity;

import java.io.Serializable;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jiudian.modules.album.entity.AlbumPictureEntity;

/**
 * 
 * 
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-10-08 09:46:47
 */
@TableName("ns_rebate")
public class RebateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private String rkey;
	/**
	 * 
	 */
	private String rvalue;
	
	@TableField(exist = false)
	private List<AlbumPictureEntity> imgTempArray;

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
	 * 设置：
	 */
	public void setRkey(String rkey) {
		this.rkey = rkey;
	}
	/**
	 * 获取：
	 */
	public String getRkey() {
		return rkey;
	}
	/**
	 * 设置：
	 */
	public void setRvalue(String rvalue) {
		this.rvalue = rvalue;
	}
	/**
	 * 获取：
	 */
	public String getRvalue() {
		return rvalue;
	}
	public List<AlbumPictureEntity> getImgTempArray() {
		return imgTempArray;
	}
	public void setImgTempArray(List<AlbumPictureEntity> imgTempArray) {
		this.imgTempArray = imgTempArray;
	}
}
