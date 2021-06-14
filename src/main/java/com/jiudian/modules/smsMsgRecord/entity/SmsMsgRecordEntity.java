package com.jiudian.modules.smsMsgRecord.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-11-07 15:17:02
 */
@TableName("ns_sms_msg_record")
public class SmsMsgRecordEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 客户端IP
	 */
	private String remoteIp;
	/**
	 * 上次发送时间
	 */
	private Date sendTime;
	/**
	 * 发送类型0注册验证码1支付密码修改验证码3订单通知
	 */
	private Integer sendType;

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
	/**
	 * 设置：上次发送时间
	 */
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	/**
	 * 获取：上次发送时间
	 */
	public Date getSendTime() {
		return sendTime;
	}
	/**
	 * 设置：发送类型0注册验证码1支付密码修改验证码3订单通知
	 */
	public void setSendType(Integer sendType) {
		this.sendType = sendType;
	}
	/**
	 * 获取：发送类型0注册验证码1支付密码修改验证码3订单通知
	 */
	public Integer getSendType() {
		return sendType;
	}
}
