package com.jiudian.modules.cms.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jiudian.modules.album.entity.AlbumPictureEntity;

/**
 * 
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:19:57
 */
@TableName("ns_cms_article_simple")
public class CmsArticleSimpleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
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
	 * 文章正文
	 */
	private String content;
	
	/**
	 * banner 图片
	 */
	private Integer banner;
	
	private Date createTime;
	
	private int sort;
	
	@TableField(exist = false)
	private AlbumPictureEntity albumPicture;
	

	
	public AlbumPictureEntity getAlbumPicture() {
		return albumPicture;
	}
	public void setAlbumPicture(AlbumPictureEntity albumPicture) {
		this.albumPicture = albumPicture;
	}
	public Integer getBanner() {
		return banner;
	}
	public void setBanner(Integer banner) {
		this.banner = banner;
	}
	/**
	 * 设置：
	 */
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	/**
	 * 获取：
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
}
