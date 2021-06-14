package com.jiudian.modules.weixin.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 微信公众号获取粉丝列表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:23:07
 */
@TableName("sys_weixin_fans")
public class SysWeixinFansEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 粉丝ID
	 */
	@TableId
	private Integer fansId;
	/**
	 * 会员编号ID
	 */
	private Integer uid;
	/**
	 * 推广人uid
	 */
	private Integer sourceUid;
	/**
	 * 店铺ID
	 */
	private Integer instanceId;
	/**
	 * 昵称
	 */
	private String nickname;
	/**
	 * 
	 */
	private String nicknameDecode;
	/**
	 * 头像
	 */
	private String headimgurl;
	/**
	 * 性别
	 */
	private Integer sex;
	/**
	 * 用户语言
	 */
	private String language;
	/**
	 * 国家
	 */
	private String country;
	/**
	 * 省
	 */
	private String province;
	/**
	 * 城市
	 */
	private String city;
	/**
	 * 行政区/县
	 */
	private String district;
	/**
	 * 用户的标识，对当前公众号唯一     用户的唯一身份ID
	 */
	private String openid;
	/**
	 * 粉丝unionid
	 */
	private String unionid;
	/**
	 * 粉丝所在组id
	 */
	private Integer groupid;
	/**
	 * 是否订阅
	 */
	private Long isSubscribe;
	/**
	 * 备注
	 */
	private String memo;
	/**
	 * 订阅时间
	 */
	private Integer subscribeDate;
	/**
	 * 解订阅时间
	 */
	private Integer unsubscribeDate;
	/**
	 * 粉丝信息最后更新时间
	 */
	private Integer updateDate;

	/**
	 * 设置：粉丝ID
	 */
	public void setFansId(Integer fansId) {
		this.fansId = fansId;
	}
	/**
	 * 获取：粉丝ID
	 */
	public Integer getFansId() {
		return fansId;
	}
	/**
	 * 设置：会员编号ID
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：会员编号ID
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：推广人uid
	 */
	public void setSourceUid(Integer sourceUid) {
		this.sourceUid = sourceUid;
	}
	/**
	 * 获取：推广人uid
	 */
	public Integer getSourceUid() {
		return sourceUid;
	}
	/**
	 * 设置：店铺ID
	 */
	public void setInstanceId(Integer instanceId) {
		this.instanceId = instanceId;
	}
	/**
	 * 获取：店铺ID
	 */
	public Integer getInstanceId() {
		return instanceId;
	}
	/**
	 * 设置：昵称
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * 获取：昵称
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * 设置：
	 */
	public void setNicknameDecode(String nicknameDecode) {
		this.nicknameDecode = nicknameDecode;
	}
	/**
	 * 获取：
	 */
	public String getNicknameDecode() {
		return nicknameDecode;
	}
	/**
	 * 设置：头像
	 */
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	/**
	 * 获取：头像
	 */
	public String getHeadimgurl() {
		return headimgurl;
	}
	/**
	 * 设置：性别
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：用户语言
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * 获取：用户语言
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * 设置：国家
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * 获取：国家
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * 设置：省
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：省
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：城市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：城市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：行政区/县
	 */
	public void setDistrict(String district) {
		this.district = district;
	}
	/**
	 * 获取：行政区/县
	 */
	public String getDistrict() {
		return district;
	}
	/**
	 * 设置：用户的标识，对当前公众号唯一     用户的唯一身份ID
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	/**
	 * 获取：用户的标识，对当前公众号唯一     用户的唯一身份ID
	 */
	public String getOpenid() {
		return openid;
	}
	/**
	 * 设置：粉丝unionid
	 */
	public void setUnionid(String unionid) {
		this.unionid = unionid;
	}
	/**
	 * 获取：粉丝unionid
	 */
	public String getUnionid() {
		return unionid;
	}
	/**
	 * 设置：粉丝所在组id
	 */
	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}
	/**
	 * 获取：粉丝所在组id
	 */
	public Integer getGroupid() {
		return groupid;
	}
	/**
	 * 设置：是否订阅
	 */
	public void setIsSubscribe(Long isSubscribe) {
		this.isSubscribe = isSubscribe;
	}
	/**
	 * 获取：是否订阅
	 */
	public Long getIsSubscribe() {
		return isSubscribe;
	}
	/**
	 * 设置：备注
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**
	 * 获取：备注
	 */
	public String getMemo() {
		return memo;
	}
	/**
	 * 设置：订阅时间
	 */
	public void setSubscribeDate(Integer subscribeDate) {
		this.subscribeDate = subscribeDate;
	}
	/**
	 * 获取：订阅时间
	 */
	public Integer getSubscribeDate() {
		return subscribeDate;
	}
	/**
	 * 设置：解订阅时间
	 */
	public void setUnsubscribeDate(Integer unsubscribeDate) {
		this.unsubscribeDate = unsubscribeDate;
	}
	/**
	 * 获取：解订阅时间
	 */
	public Integer getUnsubscribeDate() {
		return unsubscribeDate;
	}
	/**
	 * 设置：粉丝信息最后更新时间
	 */
	public void setUpdateDate(Integer updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 获取：粉丝信息最后更新时间
	 */
	public Integer getUpdateDate() {
		return updateDate;
	}
}
