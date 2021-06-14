package com.jiudian.modules.weixin.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 微信消息模版
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
@TableName("sys_weixin_msg_template")
public class SysWeixinMsgTemplateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer id;
	/**
	 * 编号
	 */
	private String templateNo;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 内容示例
	 */
	private String contents;
	/**
	 * 模版id
	 */
	private String templateId;
	/**
	 * 头部文字
	 */
	private String headtext;
	/**
	 * 底部文字
	 */
	private String bottomtext;

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
	 * 设置：编号
	 */
	public void setTemplateNo(String templateNo) {
		this.templateNo = templateNo;
	}
	/**
	 * 获取：编号
	 */
	public String getTemplateNo() {
		return templateNo;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：内容示例
	 */
	public void setContents(String contents) {
		this.contents = contents;
	}
	/**
	 * 获取：内容示例
	 */
	public String getContents() {
		return contents;
	}
	/**
	 * 设置：模版id
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	/**
	 * 获取：模版id
	 */
	public String getTemplateId() {
		return templateId;
	}
	/**
	 * 设置：头部文字
	 */
	public void setHeadtext(String headtext) {
		this.headtext = headtext;
	}
	/**
	 * 获取：头部文字
	 */
	public String getHeadtext() {
		return headtext;
	}
	/**
	 * 设置：底部文字
	 */
	public void setBottomtext(String bottomtext) {
		this.bottomtext = bottomtext;
	}
	/**
	 * 获取：底部文字
	 */
	public String getBottomtext() {
		return bottomtext;
	}
}
