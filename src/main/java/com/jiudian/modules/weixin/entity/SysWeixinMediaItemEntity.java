package com.jiudian.modules.weixin.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
@TableName("sys_weixin_media_item")
public class SysWeixinMediaItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id
	 */
	@TableId
	private Integer id;
	/**
	 * 图文消息id
	 */
	private Integer mediaId;
	/**
	 * 
	 */
	private String title;
	/**
	 * 作者
	 */
	private String author;
	/**
	 * 图文消息封面
	 */
	private String cover;
	/**
	 * 封面图片显示在正文中
	 */
	private Integer showCoverPic;
	/**
	 * 
	 */
	private String summary;
	/**
	 * 正文
	 */
	private String content;
	/**
	 * 图文消息的原文地址，即点击“阅读原文”后的URL
	 */
	private String contentSourceUrl;
	/**
	 * 排序号
	 */
	private Integer sort;
	/**
	 * 阅读次数
	 */
	private Integer hits;

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：图文消息id
	 */
	public void setMediaId(Integer mediaId) {
		this.mediaId = mediaId;
	}
	/**
	 * 获取：图文消息id
	 */
	public Integer getMediaId() {
		return mediaId;
	}
	/**
	 * 设置：
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：作者
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * 获取：作者
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * 设置：图文消息封面
	 */
	public void setCover(String cover) {
		this.cover = cover;
	}
	/**
	 * 获取：图文消息封面
	 */
	public String getCover() {
		return cover;
	}
	/**
	 * 设置：封面图片显示在正文中
	 */
	public void setShowCoverPic(Integer showCoverPic) {
		this.showCoverPic = showCoverPic;
	}
	/**
	 * 获取：封面图片显示在正文中
	 */
	public Integer getShowCoverPic() {
		return showCoverPic;
	}
	/**
	 * 设置：
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * 获取：
	 */
	public String getSummary() {
		return summary;
	}
	/**
	 * 设置：正文
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：正文
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：图文消息的原文地址，即点击“阅读原文”后的URL
	 */
	public void setContentSourceUrl(String contentSourceUrl) {
		this.contentSourceUrl = contentSourceUrl;
	}
	/**
	 * 获取：图文消息的原文地址，即点击“阅读原文”后的URL
	 */
	public String getContentSourceUrl() {
		return contentSourceUrl;
	}
	/**
	 * 设置：排序号
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序号
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：阅读次数
	 */
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	/**
	 * 获取：阅读次数
	 */
	public Integer getHits() {
		return hits;
	}
}
