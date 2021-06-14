package com.jiudian.modules.cms.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * CMS评论表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:19:57
 */
@TableName("nc_cms_comment")
public class NcCmsCommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 评论编号
	 */
	@TableId
	private Integer commentId;
	/**
	 * 评论内容
	 */
	private String text;
	/**
	 * 评论人编号
	 */
	private Integer uid;
	/**
	 * 评论引用
	 */
	private Integer quoteCommentId;
	/**
	 * 点赞数量
	 */
	private Integer up;
	/**
	 * 评论时间
	 */
	private Integer commentTime;

	/**
	 * 设置：评论编号
	 */
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	/**
	 * 获取：评论编号
	 */
	public Integer getCommentId() {
		return commentId;
	}
	/**
	 * 设置：评论内容
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * 获取：评论内容
	 */
	public String getText() {
		return text;
	}
	/**
	 * 设置：评论人编号
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：评论人编号
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：评论引用
	 */
	public void setQuoteCommentId(Integer quoteCommentId) {
		this.quoteCommentId = quoteCommentId;
	}
	/**
	 * 获取：评论引用
	 */
	public Integer getQuoteCommentId() {
		return quoteCommentId;
	}
	/**
	 * 设置：点赞数量
	 */
	public void setUp(Integer up) {
		this.up = up;
	}
	/**
	 * 获取：点赞数量
	 */
	public Integer getUp() {
		return up;
	}
	/**
	 * 设置：评论时间
	 */
	public void setCommentTime(Integer commentTime) {
		this.commentTime = commentTime;
	}
	/**
	 * 获取：评论时间
	 */
	public Integer getCommentTime() {
		return commentTime;
	}
}
