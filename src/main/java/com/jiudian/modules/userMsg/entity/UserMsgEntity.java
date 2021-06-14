package com.jiudian.modules.userMsg.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jiudian.modules.sysMsg.entity.SysMsgEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-10-27 16:20:26
 */
@TableName("ns_user_msg")
public class UserMsgEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 
	 */
	private Integer uid;
	/**
	 * 
	 */
	private Date recieveDate;
	/**
	 * 
	 */
	private Integer msgId;
	/**
	 * 
	 */
	private Integer isRead;
	
	@TableField(exist = false)
	private SysMsgEntity sysMsgEntity;

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
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：
	 */
	public void setRecieveDate(Date recieveDate) {
		this.recieveDate = recieveDate;
	}
	/**
	 * 获取：
	 */
	public Date getRecieveDate() {
		return recieveDate;
	}
	/**
	 * 设置：
	 */
	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}
	/**
	 * 获取：
	 */
	public Integer getMsgId() {
		return msgId;
	}
	/**
	 * 设置：
	 */
	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}
	/**
	 * 获取：
	 */
	public Integer getIsRead() {
		return isRead;
	}
	public SysMsgEntity getSysMsgEntity() {
		return sysMsgEntity;
	}
	public void setSysMsgEntity(SysMsgEntity sysMsgEntity) {
		this.sysMsgEntity = sysMsgEntity;
	}
}
