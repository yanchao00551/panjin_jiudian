package com.jiudian.modules.aboutUs.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 
 * 
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-12-07 09:49:30
 */
@TableName("ns_about_us")
public class AboutUsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer id;
	/**
	 * 关于我们
	 */
	private String content;

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
	 * 设置：关于我们
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：关于我们
	 */
	public String getContent() {
		return content;
	}
}
