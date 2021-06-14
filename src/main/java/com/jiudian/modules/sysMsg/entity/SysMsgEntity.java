package com.jiudian.modules.sysMsg.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jiudian.modules.album.entity.AlbumPictureEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-10-27 16:23:13
 */
@TableName("sys_msg")
public class SysMsgEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 发送对象分类0注册消息1全用户消息
	 */
	private Integer toType;
	/**
	 * 消息类型0系统消息1活动消息
	 */
	private Integer msgType;
	/**
	 * 消息内容
	 */
	private String msgContent;
	/**
	 * 已发送次数
	 */
	private Integer sendTimes;
	/**
	 * 创建时间
	 */
	private Date createDate;
	/**
	 * 上次发送时间
	 */
	private Date lastSendDate;
	/**
	 * 消息插图
	 */
	private Integer img;
	/**
	 * 消息标题
	 */
	private String title;
	
	@TableField(exist = false)
	private AlbumPictureEntity imgDetail;

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
	 * 设置：发送对象分类0注册消息1全用户消息
	 */
	public void setToType(Integer toType) {
		this.toType = toType;
	}
	/**
	 * 获取：发送对象分类0注册消息1全用户消息
	 */
	public Integer getToType() {
		return toType;
	}
	/**
	 * 设置：消息类型0系统消息1活动消息
	 */
	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}
	/**
	 * 获取：消息类型0系统消息1活动消息
	 */
	public Integer getMsgType() {
		return msgType;
	}
	/**
	 * 设置：消息内容
	 */
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}
	/**
	 * 获取：消息内容
	 */
	public String getMsgContent() {
		return msgContent;
	}
	/**
	 * 设置：已发送次数
	 */
	public void setSendTimes(Integer sendTimes) {
		this.sendTimes = sendTimes;
	}
	/**
	 * 获取：已发送次数
	 */
	public Integer getSendTimes() {
		return sendTimes;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：上次发送时间
	 */
	public void setLastSendDate(Date lastSendDate) {
		this.lastSendDate = lastSendDate;
	}
	/**
	 * 获取：上次发送时间
	 */
	public Date getLastSendDate() {
		return lastSendDate;
	}
	/**
	 * 设置：消息插图
	 */
	public void setImg(Integer img) {
		this.img = img;
	}
	/**
	 * 获取：消息插图
	 */
	public Integer getImg() {
		return img;
	}
	public AlbumPictureEntity getImgDetail() {
		return imgDetail;
	}
	public void setImgDetail(AlbumPictureEntity imgDetail) {
		this.imgDetail = imgDetail;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
