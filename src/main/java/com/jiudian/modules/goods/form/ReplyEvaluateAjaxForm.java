package com.jiudian.modules.goods.form;


/**
 *  添加商品评价回复
 * @author KF-180419
 *
 */

public class ReplyEvaluateAjaxForm {
	
	/**
	 * 评论ID
	 */
	private Integer evaluateId;
	
	/**
	 * 解释次数
	 */
	private Integer replyType;
	
	
	/**
	 * 解释内容
	 */
	private String evaluateReply;


	public Integer getEvaluateId() {
		return evaluateId;
	}


	public void setEvaluateId(Integer evaluateId) {
		this.evaluateId = evaluateId;
	}


	public Integer getReplyType() {
		return replyType;
	}


	public void setReplyType(Integer replyType) {
		this.replyType = replyType;
	}


	public String getEvaluateReply() {
		return evaluateReply;
	}


	public void setEvaluateReply(String evaluateReply) {
		this.evaluateReply = evaluateReply;
	}
	
	
	
}
