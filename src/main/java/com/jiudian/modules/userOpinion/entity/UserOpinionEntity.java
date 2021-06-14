package com.jiudian.modules.userOpinion.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-10-27 14:44:06
 */
@TableName("ns_user_opinion")
public class UserOpinionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 提出意见的用户
	 */
	private Integer uid;
	/**
	 * 意见内容
	 */
	private String cotent;
	
	private Date createDate;
	
	@TableField(exist = false)
	private String nickName;

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
	 * 设置：提出意见的用户
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：提出意见的用户
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：意见内容
	 */
	public void setCotent(String cotent) {
		this.cotent = cotent;
	}
	/**
	 * 获取：意见内容
	 */
	public String getCotent() {
		return cotent;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}
