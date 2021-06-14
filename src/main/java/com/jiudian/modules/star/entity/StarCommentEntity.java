package com.jiudian.modules.star.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 服务星评论表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-20 08:29:38
 */
@TableName("ns_star_comment")
public class StarCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 被评论服务星ID
	 */
	private Integer starId;
	/**
	 * 评论用户ID
	 */
	private Integer userId;
	/**
	 * 评论内容
	 */
	private String content;
	/**
	 * 
	 */
	private Integer createDate;
	
	private double point = 0;
	
	/**
	 * 1 服务星 2 金钥匙
	 */
	private Integer type;
	
	/*---- other ----*/
	
	/**
	 * 用户头像
	 */
	private String picCoverMicro;
	

	/**
	 * 昵称
	 */
	private String nickName;
	
	/**
	 * 用户名
	 * 
	 */
	private String username;

	
	
	public String getPicCoverMicro() {
		return picCoverMicro;
	}
	public void setPicCoverMicro(String picCoverMicro) {
		this.picCoverMicro = picCoverMicro;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}

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
	 * 设置：被评论服务星ID
	 */
	public void setStarId(Integer starId) {
		this.starId = starId;
	}
	/**
	 * 获取：被评论服务星ID
	 */
	public Integer getStarId() {
		return starId;
	}
	/**
	 * 设置：评论用户ID
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	/**
	 * 获取：评论用户ID
	 */
	public Integer getUserId() {
		return userId;
	}
	/**
	 * 设置：评论内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：评论内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：
	 */
	public void setCreateDate(Integer createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：
	 */
	public Integer getCreateDate() {
		return createDate;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
}
