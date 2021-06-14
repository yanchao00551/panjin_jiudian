package com.jiudian.modules.star.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jiudian.modules.album.entity.AlbumPictureEntity;

/**
 * 服务星分类表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-20 08:29:38
 */
@TableName("ns_star_class")
public class StarClassEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer classId;
	/**
	 * 分类名称
	 */
	private String className;
	/**
	 * 
	 */
	private Integer createTime;
	
	/**
	 * 1 服务星 2 金钥匙
	 */
	private Integer type;
	
	private String classPic;
	
	@TableField(exist = false)
	private AlbumPictureEntity picDetail;
	
	

	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	/**
	 * 设置：
	 */
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	/**
	 * 获取：
	 */
	public Integer getClassId() {
		return classId;
	}
	/**
	 * 设置：分类名称
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	/**
	 * 获取：分类名称
	 */
	public String getClassName() {
		return className;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Integer getCreateTime() {
		return createTime;
	}
	public String getClassPic() {
		return classPic;
	}
	public void setClassPic(String classPic) {
		this.classPic = classPic;
	}
	public AlbumPictureEntity getPicDetail() {
		return picDetail;
	}
	public void setPicDetail(AlbumPictureEntity picDetail) {
		this.picDetail = picDetail;
	}
}
