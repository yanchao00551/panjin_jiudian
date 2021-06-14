package com.jiudian.modules.member.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jiudian.modules.album.entity.AlbumPictureEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员合伙人申请表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-21 15:55:35
 */
@TableName("ns_member_partner")
public class MemberPartnerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer partnerId;
	/**
	 * 申请用户
	 */
	private Integer uid;
	/**
	 * 申请时间
	 */
	private Integer createTime;
	/**
	 * 审核时间
	 */
	private Integer lastTime;
	/**
	 * 状态 0 未审核  1 已审核通过
	 */
	private Integer status;
	
	@TableField(exist = false)
	private String userTel;
	
	@TableField(exist = false)
	private String realName;
	
	/*----- other -----*/
	@TableField(exist = false)
	private String userHeadimg;
	
	@TableField(exist = false)
	private String username;
	
	@TableField(exist = false)
	private String memberName;
	
	@TableField(exist = false)
	private String nickName;
	
	@TableField(exist = false)
	private String mobile;
	
	@TableField(exist = false)
	private String userEmail;
	
	@TableField(exist = false)
	private String levelName;
	
	@TableField(exist = false)
	private Date regTime;
	
	@TableField(exist = false)
	private Date lastLoginTime;
	
	@TableField(exist = false)
	private AlbumPictureEntity cardFront;
	
	@TableField(exist = false)
	private AlbumPictureEntity cardBack;
	
	@TableField(exist = false)
	private AlbumPictureEntity headPic;
	
	
	

	public String getUserHeadimg() {
		return userHeadimg;
	}
	public void setUserHeadimg(String userHeadimg) {
		this.userHeadimg = userHeadimg;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	/**
	 * 设置：
	 */
	public void setPartnerId(Integer partnerId) {
		this.partnerId = partnerId;
	}
	/**
	 * 获取：
	 */
	public Integer getPartnerId() {
		return partnerId;
	}
	/**
	 * 设置：申请用户
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：申请用户
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：申请时间
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：申请时间
	 */
	public Integer getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：审核时间
	 */
	public void setLastTime(Integer lastTime) {
		this.lastTime = lastTime;
	}
	/**
	 * 获取：审核时间
	 */
	public Integer getLastTime() {
		return lastTime;
	}
	/**
	 * 设置：状态 0 未审核  1 已审核通过
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态 0 未审核  1 已审核通过
	 */
	public Integer getStatus() {
		return status;
	}
	public AlbumPictureEntity getCardFront() {
		return cardFront;
	}
	public void setCardFront(AlbumPictureEntity cardFront) {
		this.cardFront = cardFront;
	}
	public AlbumPictureEntity getCardBack() {
		return cardBack;
	}
	public void setCardBack(AlbumPictureEntity cardBack) {
		this.cardBack = cardBack;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public AlbumPictureEntity getHeadPic() {
		return headPic;
	}
	public void setHeadPic(AlbumPictureEntity headPic) {
		this.headPic = headPic;
	}
}
