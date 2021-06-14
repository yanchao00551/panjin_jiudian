package com.jiudian.modules.cms.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * cms文章分类表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:19:57
 */
@TableName("nc_cms_article_class")
public class NcCmsArticleClassEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 分类编号 
	 */
	@TableId
	private Integer classId;
	/**
	 * 上级分类
	 */
	private Integer pid;
	/**
	 * 分类名称
	 */
	private String name;
	/**
	 * 
	 */
	private Integer sort;

	/**
	 * 设置：分类编号 
	 */
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	/**
	 * 获取：分类编号 
	 */
	public Integer getClassId() {
		return classId;
	}
	/**
	 * 设置：上级分类
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 获取：上级分类
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * 设置：分类名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：分类名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：
	 */
	public Integer getSort() {
		return sort;
	}
}
