package com.jiudian.modules.member.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jiudian.modules.order.entity.OrderEntity;

/**
 * 会员流水账表
 * 
 * @author yanchao
 * @param <T>
 * @email 7631990@qq.com
 * @date 2018-06-26 13:10:53
 */
@TableName("ns_member_account_records")
public class MemberAccountRecordsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer id;
	/**
	 * 用户ID
	 */
	private Integer uid;
	/**
	 * 店铺ID
	 */
	private Integer shopId;
	/**
	 * 账户类型1.积分2.余额3.购物币
	 */
	private Integer accountType;
	/**
	 * 正负号
	 */
	private Integer sign;
	/**
	 * 数量
	 */
	private BigDecimal number;
	/**
	 * 产生方式1.商城订单2.订单退还3.兑换4.充值5.签到6.分享7.注册8.提现9提现退还
	 */
	private Integer fromType;
	/**
	 * 相关表的数据ID
	 */
	private Integer dataId;
	/**
	 * 数据相关内容描述文本
	 */
	private String text;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * fromType 的转义
	 */
	private String fromTypeName;
	
	/**
	 * accountTypeName 的转义
	 */
	private String accountTypeName;
	
	/**
	 * 通过dataId的外键表 order 返回内容
	 */
	private OrderEntity dataContent;
	
	/**
	 * 来自佣金的UID
	 */
	private Integer fromUid;
	
	/**
	 * 是否为冻结资金
	 */
	private Integer isFreeze;
	
	private int groupId;
	

	@TableField(exist = false)
	private String nickName;
	
	@TableField(exist = false)
	private String username;
	
	@TableField(exist = false)
	private String userTel;
	
	@TableField(exist = false)
	private String userEmail;
	
	@TableField(exist = false)
	private String userHeadimg;
	
	@TableField(exist = false)
	private String mobile;
	
	//佣金产生者信息
	@TableField(exist = false)
	private MemberEntity fromer;
	
	@TableField(exist = false)
	private int totalpoint;
	

	public Integer getFromUid() {
		return fromUid;
	}
	public void setFromUid(Integer fromUid) {
		this.fromUid = fromUid;
	}
	public Integer getIsFreeze() {
		return isFreeze;
	}
	public void setIsFreeze(Integer isFreeze) {
		this.isFreeze = isFreeze;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserTel() {
		return userTel;
	}
	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserHeadimg() {
		return userHeadimg;
	}
	public void setUserHeadimg(String userHeadimg) {
		this.userHeadimg = userHeadimg;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public OrderEntity getDataContent() {
		return dataContent;
	}
	public void setDataContent(OrderEntity orderInfo) {
		this.dataContent = orderInfo;
	}
	public String getFromTypeName() {
		return fromTypeName;
	}
	public void setFromTypeName(String fromTypeName) {
		this.fromTypeName = fromTypeName;
	}
	public String getAccountTypeName() {
		return accountTypeName;
	}
	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}
	/**
	 * 设置：主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：用户ID
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：用户ID
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：店铺ID
	 */
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	/**
	 * 获取：店铺ID
	 */
	public Integer getShopId() {
		return shopId;
	}
	/**
	 * 设置：账户类型1.积分2.余额3.购物币
	 */
	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}
	/**
	 * 获取：账户类型1.积分2.余额3.购物币
	 */
	public Integer getAccountType() {
		return accountType;
	}
	/**
	 * 设置：正负号
	 */
	public void setSign(Integer sign) {
		this.sign = sign;
	}
	/**
	 * 获取：正负号
	 */
	public Integer getSign() {
		return sign;
	}
	/**
	 * 设置：数量
	 */
	public void setNumber(BigDecimal number) {
		this.number = number;
	}
	/**
	 * 获取：数量
	 */
	public BigDecimal getNumber() {
		return number;
	}
	/**
	 * 设置：产生方式1.商城订单2.订单退还3.兑换4.充值5.签到6.分享7.注册8.提现9提现退还
	 */
	public void setFromType(Integer fromType) {
		this.fromType = fromType;
	}
	/**
	 * 获取：产生方式1.商城订单2.订单退还3.兑换4.充值5.签到6.分享7.注册8.提现9提现退还
	 */
	public Integer getFromType() {
		return fromType;
	}
	/**
	 * 设置：相关表的数据ID
	 */
	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}
	/**
	 * 获取：相关表的数据ID
	 */
	public Integer getDataId() {
		return dataId;
	}
	/**
	 * 设置：数据相关内容描述文本
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * 获取：数据相关内容描述文本
	 */
	public String getText() {
		return text;
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
	public MemberEntity getFromer() {
		return fromer;
	}
	public void setFromer(MemberEntity fromer) {
		this.fromer = fromer;
	}
	public int getTotalpoint() {
		return totalpoint;
	}
	public void setTotalpoint(int totalpoint) {
		this.totalpoint = totalpoint;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
}
