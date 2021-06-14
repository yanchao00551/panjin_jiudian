package com.jiudian.modules.cms.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * CMS文章表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:19:57
 */
@TableName("nc_cms_article")
public class NcCmsArticleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 文章编号
	 */
	@TableId
	private Integer articleId;
	/**
	 * 文章标题
	 */
	private String title;
	/**
	 * 文章分类编号
	 */
	private Integer classId;
	/**
	 * 文章短标题
	 */
	private String shortTitle;
	/**
	 * 文章来源
	 */
	private String source;
	/**
	 * 文章来源链接
	 */
	private String url;
	/**
	 * 文章作者
	 */
	private String author;
	/**
	 * 文章摘要
	 */
	private String summary;
	/**
	 * 文章正文
	 */
	private String content;
	/**
	 * 文章标题图片
	 */
	private String image;
	/**
	 * 文章关键字
	 */
	private String keyword;
	/**
	 * 相关文章
	 */
	private String articleIdArray;
	/**
	 * 文章点击量
	 */
	private Integer click;
	/**
	 * 文章排序0-255
	 */
	private Integer sort;
	/**
	 * 文章推荐标志0-未推荐，1-已推荐
	 */
	private Integer commendFlag;
	/**
	 * 文章是否允许评论1-允许，0-不允许
	 */
	private Integer commentFlag;
	/**
	 * 0-草稿、1-待审核、2-已发布、-1-回收站
	 */
	private Integer status;
	/**
	 * 文章附件路径
	 */
	private String attachmentPath;
	/**
	 * 文章标签
	 */
	private String tag;
	/**
	 * 文章评论数
	 */
	private Integer commentCount;
	/**
	 * 文章分享数
	 */
	private Integer shareCount;
	/**
	 * 发布者用户名 
	 */
	private String publisherName;
	/**
	 * 发布者编号
	 */
	private Integer uid;
	/**
	 * 最新评论时间
	 */
	private Integer lastCommentTime;
	/**
	 * 发布时间
	 */
	private Integer publicTime;
	/**
	 * 文章发布时间
	 */
	private Integer createTime;
	/**
	 * 文章修改时间
	 */
	private Integer modifyTime;

	/**
	 * 设置：文章编号
	 */
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	/**
	 * 获取：文章编号
	 */
	public Integer getArticleId() {
		return articleId;
	}
	/**
	 * 设置：文章标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：文章标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：文章分类编号
	 */
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	/**
	 * 获取：文章分类编号
	 */
	public Integer getClassId() {
		return classId;
	}
	/**
	 * 设置：文章短标题
	 */
	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}
	/**
	 * 获取：文章短标题
	 */
	public String getShortTitle() {
		return shortTitle;
	}
	/**
	 * 设置：文章来源
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * 获取：文章来源
	 */
	public String getSource() {
		return source;
	}
	/**
	 * 设置：文章来源链接
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：文章来源链接
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：文章作者
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * 获取：文章作者
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * 设置：文章摘要
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * 获取：文章摘要
	 */
	public String getSummary() {
		return summary;
	}
	/**
	 * 设置：文章正文
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：文章正文
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：文章标题图片
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * 获取：文章标题图片
	 */
	public String getImage() {
		return image;
	}
	/**
	 * 设置：文章关键字
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	/**
	 * 获取：文章关键字
	 */
	public String getKeyword() {
		return keyword;
	}
	/**
	 * 设置：相关文章
	 */
	public void setArticleIdArray(String articleIdArray) {
		this.articleIdArray = articleIdArray;
	}
	/**
	 * 获取：相关文章
	 */
	public String getArticleIdArray() {
		return articleIdArray;
	}
	/**
	 * 设置：文章点击量
	 */
	public void setClick(Integer click) {
		this.click = click;
	}
	/**
	 * 获取：文章点击量
	 */
	public Integer getClick() {
		return click;
	}
	/**
	 * 设置：文章排序0-255
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：文章排序0-255
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：文章推荐标志0-未推荐，1-已推荐
	 */
	public void setCommendFlag(Integer commendFlag) {
		this.commendFlag = commendFlag;
	}
	/**
	 * 获取：文章推荐标志0-未推荐，1-已推荐
	 */
	public Integer getCommendFlag() {
		return commendFlag;
	}
	/**
	 * 设置：文章是否允许评论1-允许，0-不允许
	 */
	public void setCommentFlag(Integer commentFlag) {
		this.commentFlag = commentFlag;
	}
	/**
	 * 获取：文章是否允许评论1-允许，0-不允许
	 */
	public Integer getCommentFlag() {
		return commentFlag;
	}
	/**
	 * 设置：0-草稿、1-待审核、2-已发布、-1-回收站
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：0-草稿、1-待审核、2-已发布、-1-回收站
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：文章附件路径
	 */
	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}
	/**
	 * 获取：文章附件路径
	 */
	public String getAttachmentPath() {
		return attachmentPath;
	}
	/**
	 * 设置：文章标签
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	/**
	 * 获取：文章标签
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * 设置：文章评论数
	 */
	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}
	/**
	 * 获取：文章评论数
	 */
	public Integer getCommentCount() {
		return commentCount;
	}
	/**
	 * 设置：文章分享数
	 */
	public void setShareCount(Integer shareCount) {
		this.shareCount = shareCount;
	}
	/**
	 * 获取：文章分享数
	 */
	public Integer getShareCount() {
		return shareCount;
	}
	/**
	 * 设置：发布者用户名 
	 */
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	/**
	 * 获取：发布者用户名 
	 */
	public String getPublisherName() {
		return publisherName;
	}
	/**
	 * 设置：发布者编号
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：发布者编号
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：最新评论时间
	 */
	public void setLastCommentTime(Integer lastCommentTime) {
		this.lastCommentTime = lastCommentTime;
	}
	/**
	 * 获取：最新评论时间
	 */
	public Integer getLastCommentTime() {
		return lastCommentTime;
	}
	/**
	 * 设置：发布时间
	 */
	public void setPublicTime(Integer publicTime) {
		this.publicTime = publicTime;
	}
	/**
	 * 获取：发布时间
	 */
	public Integer getPublicTime() {
		return publicTime;
	}
	/**
	 * 设置：文章发布时间
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：文章发布时间
	 */
	public Integer getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：文章修改时间
	 */
	public void setModifyTime(Integer modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：文章修改时间
	 */
	public Integer getModifyTime() {
		return modifyTime;
	}
}
