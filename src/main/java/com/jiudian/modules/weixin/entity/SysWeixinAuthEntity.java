package com.jiudian.modules.weixin.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 店铺(实例)微信公众账号授权
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:23:07
 */
@TableName("sys_weixin_auth")
public class SysWeixinAuthEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 店铺id
	 */
	private Integer instanceId;
	/**
	 * 店铺的appid  授权之后不用刷新
	 */
	private String authorizerAppid;
	/**
	 * 店铺授权之后的刷新token，每月刷新
	 */
	private String authorizerRefreshToken;
	/**
	 * 店铺的公众号token，只有2小时
	 */
	private String authorizerAccessToken;
	/**
	 * 授权项目
	 */
	private String funcInfo;
	/**
	 * 公众号昵称
	 */
	private String nickName;
	/**
	 * 公众号头像url
	 */
	private String headImg;
	/**
	 * 公众号原始账号
	 */
	private String userName;
	/**
	 * 公众号原始名称
	 */
	private String alias;
	/**
	 * 公众号二维码url
	 */
	private String qrcodeUrl;
	/**
	 * 授权时间
	 */
	private Integer authTime;

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
	public void setInstanceId(Integer instanceId) {
		this.instanceId = instanceId;
	}
	/**
	 * 获取：店铺id
	 */
	public Integer getInstanceId() {
		return instanceId;
	}
	/**
	 * 设置：店铺的appid  授权之后不用刷新
	 */
	public void setAuthorizerAppid(String authorizerAppid) {
		this.authorizerAppid = authorizerAppid;
	}
	/**
	 * 获取：店铺的appid  授权之后不用刷新
	 */
	public String getAuthorizerAppid() {
		return authorizerAppid;
	}
	/**
	 * 设置：店铺授权之后的刷新token，每月刷新
	 */
	public void setAuthorizerRefreshToken(String authorizerRefreshToken) {
		this.authorizerRefreshToken = authorizerRefreshToken;
	}
	/**
	 * 获取：店铺授权之后的刷新token，每月刷新
	 */
	public String getAuthorizerRefreshToken() {
		return authorizerRefreshToken;
	}
	/**
	 * 设置：店铺的公众号token，只有2小时
	 */
	public void setAuthorizerAccessToken(String authorizerAccessToken) {
		this.authorizerAccessToken = authorizerAccessToken;
	}
	/**
	 * 获取：店铺的公众号token，只有2小时
	 */
	public String getAuthorizerAccessToken() {
		return authorizerAccessToken;
	}
	/**
	 * 设置：授权项目
	 */
	public void setFuncInfo(String funcInfo) {
		this.funcInfo = funcInfo;
	}
	/**
	 * 获取：授权项目
	 */
	public String getFuncInfo() {
		return funcInfo;
	}
	/**
	 * 设置：公众号昵称
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * 获取：公众号昵称
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * 设置：公众号头像url
	 */
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	/**
	 * 获取：公众号头像url
	 */
	public String getHeadImg() {
		return headImg;
	}
	/**
	 * 设置：公众号原始账号
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * 获取：公众号原始账号
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置：公众号原始名称
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	/**
	 * 获取：公众号原始名称
	 */
	public String getAlias() {
		return alias;
	}
	/**
	 * 设置：公众号二维码url
	 */
	public void setQrcodeUrl(String qrcodeUrl) {
		this.qrcodeUrl = qrcodeUrl;
	}
	/**
	 * 获取：公众号二维码url
	 */
	public String getQrcodeUrl() {
		return qrcodeUrl;
	}
	/**
	 * 设置：授权时间
	 */
	public void setAuthTime(Integer authTime) {
		this.authTime = authTime;
	}
	/**
	 * 获取：授权时间
	 */
	public Integer getAuthTime() {
		return authTime;
	}
}
