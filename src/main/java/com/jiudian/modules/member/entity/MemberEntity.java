package com.jiudian.modules.member.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.rewardRecord.entity.RewardRecordEntity;

/**
 * 前台用户表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-26 13:10:53
 */
@TableName("ns_member")
public class MemberEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@TableId
	private long id;
	
	/**
	 * 用户ID
	 */
	private long uid;
	/**
	 * 前台用户名
	 */
	private String memberName;
	/**
	 * 会员等级
	 */
//	private Integer memberLevel;
	/**
	 * 备注
	 */
	private String memo;
	/**
	 * 注册时间
	 */
	private Date regTime;
	
	
	/**
	 * 推荐人id
	 */
	private long pid;
	
	/**
	 * 推广人ID 编码
	 */
	private String promoter;
	
	/**
	 * 身份证正面
	 * 
	 */
	private Integer cardFront;
	
	/**
	 * 身份证反面
	 * 
	 */
	private Integer cardReverse;
	
	private int keyId;
	
	private Date birthDate;
	
	
	public Integer getCardFront() {
		return cardFront;
	}
	public void setCardFront(Integer cardFront) {
		this.cardFront = cardFront;
	}
	public Integer getCardReverse() {
		return cardReverse;
	}
	public void setCardReverse(Integer cardReverse) {
		this.cardReverse = cardReverse;
	}
	public String getPromoter() {
		return promoter;
	}
	public void setPromoter(String promoter) {
		this.promoter = promoter;
	}
	/* ---------  其他字段  tb_user----------------- */
	/**
	 * 用户名
	 */
	@TableField(exist = false)
	private String username;
	/**
	 * 手机号
	 */
	@TableField(exist = false)
	private String mobile;
	/**
	 * 密码
	 */
	@TableField(exist = false)
	private String password;
	/**
	 * 用户状态  用户状态默认为1
	 */
	@TableField(exist = false)
	private Integer userStatus;
	/**
	 * 用户头像
	 */
	@TableField(exist = false)
	private String userHeadimg;
	/**
	 * 是否是系统后台用户 0 不是 1 是
	 */
	@TableField(exist = false)
	private Integer isSystem;
	/**
	 * 是否是前台会员
	 */
	@TableField(exist = false)
	private Integer isMember;
	/**
	 * 手机号
	 */
	@TableField(exist = false)
	private String userTel;
	/**
	 * 手机号是否绑定 0 未绑定 1 绑定 
	 */
	@TableField(exist = false)
	private Integer userTelBind;
	/**
	 * qq号
	 */
	@TableField(exist = false)
	private String userQq;
	/**
	 * qq互联id
	 */
	@TableField(exist = false)
	private String qqOpenid;
	/**
	 * qq账号相关信息
	 */
	@TableField(exist = false)
	private String qqInfo;
	/**
	 * 邮箱
	 */
	@TableField(exist = false)
	private String userEmail;
	/**
	 * 是否邮箱绑定
	 */
	@TableField(exist = false)
	private Integer userEmailBind;
	/**
	 * 微信用户openid
	 */
	@TableField(exist = false)
	private String wxOpenid;
	/**
	 * 微信用户是否关注
	 */
	@TableField(exist = false)
	private Integer wxIsSub;
	/**
	 * 微信用户信息
	 */
	@TableField(exist = false)
	private String wxInfo;
	/**
	 * 合伙人状态（1是0申请中null(2)否）
	 * 
	 */
	@TableField(exist = false)
	private Integer partnerStatus;
	/**
	 * 附加信息
	 */
	@TableField(exist = false)
	private String otherInfo;
	/**
	 * 当前登录ip
	 */
	@TableField(exist = false)
	private String currentLoginIp;
	/**
	 * 当前登录的操作终端类型
	 */
	@TableField(exist = false)
	private Integer currentLoginType;
	/**
	 * 上次登录ip
	 */
	@TableField(exist = false)
	private String lastLoginIp;
	/**
	 * 上次登录的操作终端类型
	 */
	@TableField(exist = false)
	private Integer lastLoginType;
	/**
	 * 登录次数
	 */
	@TableField(exist = false)
	private Integer loginNum;
	/**
	 * 真实姓名
	 */
	@TableField(exist = false)
	private String realName;
	/**
	 * 性别 0保密 1男 2女
	 */
	@TableField(exist = false)
	private Integer sex;
	/**
	 * 所在地
	 */
	@TableField(exist = false)
	private String location;
	/**
	 * 用户昵称
	 */
	@TableField(exist = false)
	private String nickName;
	/**
	 * 微信unionid
	 */
	@TableField(exist = false)
	private String wxUnionid;
	/**
	 * 模板id
	 */
	@TableField(exist = false)
	private Integer qrcodeTemplateId;
	/**
	 * 微信用户关注时间
	 */
	@TableField(exist = false)
	private Date wxSubTime;
	/**
	 * 微信用户取消关注时间
	 */
	@TableField(exist = false)
	private Date wxNotsubTime;

	/**
	 * 当前登录时间
	 */
	@TableField(exist = false)
	private Date currentLoginTime;
	/**
	 * 上次登录时间
	 */
	@TableField(exist = false)
	private Date lastLoginTime;
	/**
	 * 
	 */
	@TableField(exist = false)
	private Integer birthday;
	
	@TableField(exist = false)
	private Date listLoginTime;
	
	/* ---------  其他字段  ns_member_account----------------- */

	/**
	 * 会员积分
	 */
	@TableField(exist = false)
	private Integer point;
	/**
	 * 余额
	 */
	@TableField(exist = false)
	private BigDecimal balance;
	/**
	 * 购物币
	 */
	@TableField(exist = false)
	private Integer coin;
	/**
	 * 会员消费
	 */
	@TableField(exist = false)
	private BigDecimal memberCunsum;
	/**
	 * 会员累计积分
	 */
	@TableField(exist = false)
	private Integer memberSumPoint;
	
	/*-----------  ns_member_level   ------ */
	/**
	 * 等级ID
	 */
	@TableField(exist = false)
	private Integer levelId;
	/**
	 * 店铺ID
	 */
	@TableField(exist = false)
	private Integer shopId;
	/**
	 * 等级名称
	 */
	@TableField(exist = false)
	private String levelName;
	/**
	 * 累计积分
	 */
	@TableField(exist = false)
	private Integer minIntegral;
	/**
	 * 折扣率
	 */
	@TableField(exist = false)
	private BigDecimal goodsDiscount;
	/**
	 * 等级描述
	 */
	@TableField(exist = false)
	private String desc;
	/**
	 * 是否是默认
	 */
	@TableField(exist = false)
	private Integer isDefault;
	/**
	 * 消费额度
	 */
	@TableField(exist = false)
	private Integer quota;
	/**
	 * 升级条件  1.累计积分 2.消费额度 3.同时满足
	 */
	@TableField(exist = false)
	private Integer upgrade;
	/**
	 * 1.或 2. 且
	 */
	@TableField(exist = false)
	private Integer relation;
	
	/**
	 * 上级用户名
	 * @return
	 */
	@TableField(exist = false)
	private String qUsername;
	
	/**
	 * 上级昵称
	 * @return
	 */
	@TableField(exist = false)
	private String qNickname;
	
	/**
	 * 流水提成
	 * @return
	 */
	@TableField(exist = false)
	private BigDecimal number;
	
	
	
	/**
	 * 团队总数
	 * @return
	 */
	@TableField(exist = false)
	private Integer teamNumber;
	
	/**
	 * 返润信息
	 * @return
	 */
	@TableField(exist = false)
	private RewardRecordEntity rewardList;
	
	/**
	 * 业绩排行
	 * @return
	 */
	@TableField(exist = false)
	private Integer among;
	
	
	@TableField(exist = false)
	private boolean isSelf = false;
	
	@TableField(exist = false)
	private AlbumPictureEntity userHeadImgDetail;
	
	
	
	public Integer getTeamNumber() {
		return teamNumber;
	}
	public void setTeamNumber(Integer teamNumber) {
		this.teamNumber = teamNumber;
	}
	public Integer getAmong() {
		return among;
	}
	public void setAmong(Integer among) {
		this.among = among;
	}
	public BigDecimal getNumber() {
		return number;
	}
	public void setNumber(BigDecimal number) {
		this.number = number;
	}
	public String getqUsername() {
		return qUsername;
	}
	public void setqUsername(String qUsername) {
		this.qUsername = qUsername;
	}
	public String getqNickname() {
		return qNickname;
	}
	public void setqNickName(String qNickname) {
		this.qNickname = qNickname;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * 设置：用户ID
	 */
	public void setUid(long userId) {
		this.uid =  userId;
	}
	/**
	 * 获取：用户ID
	 */
	public long getUid() {
		return uid;
	}
	/**
	 * 设置：前台用户名
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	/**
	 * 获取：前台用户名
	 */
	public String getMemberName() {
		return memberName;
	}
	/**
	 * 设置：会员等级
	 */
//	public void setMemberLevel(Integer memberLevel) {
//		this.memberLevel = memberLevel;
//	}
//	/**
//	 * 获取：会员等级
//	 */
//	public Integer getMemberLevel() {
//		return memberLevel;
//	}
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
	 * 设置：注册时间
	 */
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}
	/**
	 * 获取：注册时间
	 */
	public Date getRegTime() {
		return regTime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(Integer userStatus) {
		this.userStatus = userStatus;
	}
	public String getUserHeadimg() {
		return userHeadimg;
	}
	public void setUserHeadimg(String userHeadimg) {
		this.userHeadimg = userHeadimg;
	}
	public Integer getIsSystem() {
		return isSystem;
	}
	public void setIsSystem(Integer isSystem) {
		this.isSystem = isSystem;
	}
	public Integer getIsMember() {
		return isMember;
	}
	public void setIsMember(Integer isMember) {
		this.isMember = isMember;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public Integer getUserTelBind() {
		return userTelBind;
	}
	public void setUserTelBind(Integer userTelBind) {
		this.userTelBind = userTelBind;
	}
	public String getUserQq() {
		return userQq;
	}
	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}
	public String getQqOpenid() {
		return qqOpenid;
	}
	public void setQqOpenid(String qqOpenid) {
		this.qqOpenid = qqOpenid;
	}
	public String getQqInfo() {
		return qqInfo;
	}
	public void setQqInfo(String qqInfo) {
		this.qqInfo = qqInfo;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Integer getUserEmailBind() {
		return userEmailBind;
	}
	public void setUserEmailBind(Integer userEmailBind) {
		this.userEmailBind = userEmailBind;
	}
	public String getWxOpenid() {
		return wxOpenid;
	}
	public void setWxOpenid(String wxOpenid) {
		this.wxOpenid = wxOpenid;
	}
	public Integer getWxIsSub() {
		return wxIsSub;
	}
	public void setWxIsSub(Integer wxIsSub) {
		this.wxIsSub = wxIsSub;
	}
	public String getWxInfo() {
		return wxInfo;
	}
	public void setWxInfo(String wxInfo) {
		this.wxInfo = wxInfo;
	}
	public String getOtherInfo() {
		return otherInfo;
	}
	public void setOtherInfo(String otherInfo) {
		this.otherInfo = otherInfo;
	}
	public String getCurrentLoginIp() {
		return currentLoginIp;
	}
	public void setCurrentLoginIp(String currentLoginIp) {
		this.currentLoginIp = currentLoginIp;
	}
	public Integer getCurrentLoginType() {
		return currentLoginType;
	}
	public void setCurrentLoginType(Integer currentLoginType) {
		this.currentLoginType = currentLoginType;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public Integer getLastLoginType() {
		return lastLoginType;
	}
	public void setLastLoginType(Integer lastLoginType) {
		this.lastLoginType = lastLoginType;
	}
	public Integer getLoginNum() {
		return loginNum;
	}
	public void setLoginNum(Integer loginNum) {
		this.loginNum = loginNum;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getWxUnionid() {
		return wxUnionid;
	}
	public void setWxUnionid(String wxUnionid) {
		this.wxUnionid = wxUnionid;
	}
	public Integer getQrcodeTemplateId() {
		return qrcodeTemplateId;
	}
	public void setQrcodeTemplateId(Integer qrcodeTemplateId) {
		this.qrcodeTemplateId = qrcodeTemplateId;
	}
	public Date getWxSubTime() {
		return wxSubTime;
	}
	public void setWxSubTime(Date wxSubTime) {
		this.wxSubTime = wxSubTime;
	}
	public Date getWxNotsubTime() {
		return wxNotsubTime;
	}
	public void setWxNotsubTime(Date wxNotsubTime) {
		this.wxNotsubTime = wxNotsubTime;
	}
	public Date getCurrentLoginTime() {
		return currentLoginTime;
	}
	public void setCurrentLoginTime(Date currentLoginTime) {
		this.currentLoginTime = currentLoginTime;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public Integer getBirthday() {
		return birthday;
	}
	public void setBirthday(Integer birthday) {
		this.birthday = birthday;
	}
	public Integer getPoint() {
		return point;
	}
	public void setPoint(Integer point) {
		this.point = point;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public Integer getCoin() {
		return coin;
	}
	public void setCoin(Integer coin) {
		this.coin = coin;
	}
	public BigDecimal getMemberCunsum() {
		return memberCunsum;
	}
	public void setMemberCunsum(BigDecimal memberCunsum) {
		this.memberCunsum = memberCunsum;
	}
	public Integer getMemberSumPoint() {
		return memberSumPoint;
	}
	public void setMemberSumPoint(Integer memberSumPoint) {
		this.memberSumPoint = memberSumPoint;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public Integer getLevelId() {
		return levelId;
	}
	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}
	public Integer getShopId() {
		return shopId;
	}
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	public Integer getMinIntegral() {
		return minIntegral;
	}
	public void setMinIntegral(Integer minIntegral) {
		this.minIntegral = minIntegral;
	}
	public BigDecimal getGoodsDiscount() {
		return goodsDiscount;
	}
	public void setGoodsDiscount(BigDecimal goodsDiscount) {
		this.goodsDiscount = goodsDiscount;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Integer getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	public Integer getQuota() {
		return quota;
	}
	public void setQuota(Integer quota) {
		this.quota = quota;
	}
	public Integer getUpgrade() {
		return upgrade;
	}
	public void setUpgrade(Integer upgrade) {
		this.upgrade = upgrade;
	}
	public Integer getRelation() {
		return relation;
	}
	public void setRelation(Integer relation) {
		this.relation = relation;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public void setqNickname(String qNickname) {
		this.qNickname = qNickname;
	}
	public Date getListLoginTime() {
		return listLoginTime;
	}
	public void setListLoginTime(Date listLoginTime) {
		this.listLoginTime = listLoginTime;
	}
	public Integer getPartnerStatus() {
		return partnerStatus;
	}
	public void setPartnerStatus(Integer partnerStatus) {
		this.partnerStatus = partnerStatus;
	}
	public boolean isSelf() {
		return isSelf;
	}
	public void setSelf(boolean isSelf) {
		this.isSelf = isSelf;
	}
	public RewardRecordEntity getRewardList() {
		return rewardList;
	}
	public void setRewardList(RewardRecordEntity rewardList) {
		this.rewardList = rewardList;
	}
	public AlbumPictureEntity getUserHeadImgDetail() {
		return userHeadImgDetail;
	}
	public void setUserHeadImgDetail(AlbumPictureEntity userHeadImgDetail) {
		this.userHeadImgDetail = userHeadImgDetail;
	}
	public int getKeyId() {
		return keyId;
	}
	public void setKeyId(int keyId) {
		this.keyId = keyId;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	
}
