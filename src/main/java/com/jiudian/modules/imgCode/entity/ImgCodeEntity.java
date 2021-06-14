package com.jiudian.modules.imgCode.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-11-07 10:16:48
 */
@TableName("ns_img_code")
public class ImgCodeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 图片验证码
	 */
	private String imgCode;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 客户端IP
	 */
	private String remoteIp;

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
	 * 设置：图片验证码
	 */
	public void setImgCode(String imgCode) {
		this.imgCode = imgCode;
	}
	/**
	 * 获取：图片验证码
	 */
	public String getImgCode() {
		return imgCode;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：客户端IP
	 */
	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}
	/**
	 * 获取：客户端IP
	 */
	public String getRemoteIp() {
		return remoteIp;
	}
}
