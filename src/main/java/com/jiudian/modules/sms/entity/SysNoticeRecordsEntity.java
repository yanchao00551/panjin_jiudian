package com.jiudian.modules.sms.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 通知记录
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-21 09:08:19
 */
@TableName("sys_notice_records")
public class SysNoticeRecordsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 店铺id
	 */
	private Integer shopId;
	/**
	 * 用户id
	 */
	private Integer uid;
	/**
	 * 发送类型 1 短信发送  2邮箱发送
	 */
	private Integer sendType;
	/**
	 * 发送账号
	 */
	private String sendAccount;
	/**
	 * 发送的配置信息
	 */
	private String sendConfig;
	/**
	 * 记录类型  1充值成功 2确认订单 3付款成功 4下单成功 5订单发货 6商家提醒退款订单 7 商家提醒订单提醒 8充值成功
	 */
	private Integer recordsType;
	/**
	 * 通知标题
	 */
	private String noticeTitle;
	/**
	 * 通知内容
	 */
	private String noticeContext;
	/**
	 * 是否发送  0未发送   1发送成功  2发送失败
	 */
	private String isSend;
	/**
	 * 发送返回结果
	 */
	private String sendMessage;
	/**
	 * 创建时间
	 */
	private Integer createDate;
	/**
	 * 发送时间
	 */
	private Integer sendDate;

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
	 * 设置：用户id
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：用户id
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：发送类型 1 短信发送  2邮箱发送
	 */
	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}
	/**
	 * 获取：发送类型 1 短信发送  2邮箱发送
	 */
	public Integer getSendType() {
		return sendType;
	}
	/**
	 * 设置：发送账号
	 */
	public void setSendAccount(String sendAccount) {
		this.sendAccount = sendAccount;
	}
	/**
	 * 获取：发送账号
	 */
	public String getSendAccount() {
		return sendAccount;
	}
	/**
	 * 设置：发送的配置信息
	 */
	public void setSendConfig(String sendConfig) {
		this.sendConfig = sendConfig;
	}
	/**
	 * 获取：发送的配置信息
	 */
	public String getSendConfig() {
		return sendConfig;
	}
	/**
	 * 设置：记录类型  1充值成功 2确认订单 3付款成功 4下单成功 5订单发货 6商家提醒退款订单 7 商家提醒订单提醒 8充值成功
	 */
	public void setRecordsType(Integer recordsType) {
		this.recordsType = recordsType;
	}
	/**
	 * 获取：记录类型  1充值成功 2确认订单 3付款成功 4下单成功 5订单发货 6商家提醒退款订单 7 商家提醒订单提醒 8充值成功
	 */
	public Integer getRecordsType() {
		return recordsType;
	}
	/**
	 * 设置：通知标题
	 */
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	/**
	 * 获取：通知标题
	 */
	public String getNoticeTitle() {
		return noticeTitle;
	}
	/**
	 * 设置：通知内容
	 */
	public void setNoticeContext(String noticeContext) {
		this.noticeContext = noticeContext;
	}
	/**
	 * 获取：通知内容
	 */
	public String getNoticeContext() {
		return noticeContext;
	}
	/**
	 * 设置：是否发送  0未发送   1发送成功  2发送失败
	 */
	public void setIsSend(String isSend) {
		this.isSend = isSend;
	}
	/**
	 * 获取：是否发送  0未发送   1发送成功  2发送失败
	 */
	public String getIsSend() {
		return isSend;
	}
	/**
	 * 设置：发送返回结果
	 */
	public void setSendMessage(String sendMessage) {
		this.sendMessage = sendMessage;
	}
	/**
	 * 获取：发送返回结果
	 */
	public String getSendMessage() {
		return sendMessage;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateDate(Integer createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建时间
	 */
	public Integer getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：发送时间
	 */
	public void setSendDate(Integer sendDate) {
		this.sendDate = sendDate;
	}
	/**
	 * 获取：发送时间
	 */
	public Integer getSendDate() {
		return sendDate;
	}
}
