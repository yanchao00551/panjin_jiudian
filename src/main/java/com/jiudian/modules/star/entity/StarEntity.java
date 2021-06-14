package com.jiudian.modules.star.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jiudian.modules.album.entity.AlbumPictureEntity;

/**
 * 服务星表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-20 08:29:38
 */
@TableName("ns_star")
public class StarEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 服务星姓名
	 */
	@TableId
	private Integer starId;
	/**
	 * 服务星名称
	 */
	private String starName;
	/**
	 * 服务星评分
	 */
	private BigDecimal grade;
	/**
	 * 服务星分类
	 */
	private Integer starClass;
	/**
	 * 类型
	 */
	private Integer type;
	/**
	 * banner图
	 */
	private Integer banner;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 创建时间
	 */
	private Integer createDate;
	
	private String telNum;
	
	private String linkUrl;

	/*----- other ------*/
	/**
	 * 评论列表
	 */
	@TableField(exist = false)
	private List<StarCommentEntity> commentList;
	
	@TableField(exist = false)
	private AlbumPictureEntity albumPicture;
	
	@TableField(exist = false)
	private double avgPoint;
	
	
	
	public AlbumPictureEntity getAlbumPicture() {
		return albumPicture;
	}
	public void setAlbumPicture(AlbumPictureEntity albumPicture) {
		this.albumPicture = albumPicture;
	}
	public List<StarCommentEntity> getCommentList() {
		return commentList;
	}
	public void setCommentList(List<StarCommentEntity> commentList) {
		this.commentList = commentList;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getBanner() {
		return banner;
	}
	public void setBanner(Integer banner) {
		this.banner = banner;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 设置：服务星姓名
	 */
	public void setStarId(Integer starId) {
		this.starId = starId;
	}
	/**
	 * 获取：服务星姓名
	 */
	public Integer getStarId() {
		return starId;
	}
	/**
	 * 设置：
	 */
	public void setStarName(String starName) {
		this.starName = starName;
	}
	/**
	 * 获取：
	 */
	public String getStarName() {
		return starName;
	}
	/**
	 * 设置：
	 */
	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}
	/**
	 * 获取：
	 */
	public BigDecimal getGrade() {
		return grade;
	}
	/**
	 * 设置：服务型分类
	 */
	public void setStarClass(Integer starClass) {
		this.starClass = starClass;
	}
	/**
	 * 获取：服务型分类
	 */
	public Integer getStarClass() {
		return starClass;
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
	public String getTelNum() {
		return telNum;
	}
	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}
	public double getAvgPoint() {
		return avgPoint;
	}
	public void setAvgPoint(double avgPoint) {
		this.avgPoint = avgPoint;
	}
	public String getLinkUrl() {
		return linkUrl;
	}
	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}
}
