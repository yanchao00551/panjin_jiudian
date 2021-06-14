package com.jiudian.modules.cms.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 专题
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:19:57
 */
@TableName("nc_cms_topic")
public class NcCmsTopicEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 专题编号
	 */
	@TableId
	private Integer topicId;
	/**
	 * 店铺ID
	 */
	private Integer instanceId;
	/**
	 * 专题标题
	 */
	private String title;
	/**
	 * 专题封面
	 */
	private String image;
	/**
	 * 专题状态  0草稿  1发布
	 */
	private Integer status;
	/**
	 * 专题内容
	 */
	private String content;
	/**
	 * 创建时间
	 */
	private Integer createTime;
	/**
	 * 修改时间
	 */
	private Integer modifyTime;

	/**
	 * 设置：专题编号
	 */
	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}
	/**
	 * 获取：专题编号
	 */
	public Integer getTopicId() {
		return topicId;
	}
	/**
	 * 设置：店铺ID
	 */
	public void setInstanceId(Integer instanceId) {
		this.instanceId = instanceId;
	}
	/**
	 * 获取：店铺ID
	 */
	public Integer getInstanceId() {
		return instanceId;
	}
	/**
	 * 设置：专题标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：专题标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：专题封面
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * 获取：专题封面
	 */
	public String getImage() {
		return image;
	}
	/**
	 * 设置：专题状态  0草稿  1发布
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：专题状态  0草稿  1发布
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：专题内容
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * 获取：专题内容
	 */
	public String getContent() {
		return content;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建时间
	 */
	public Integer getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：修改时间
	 */
	public void setModifyTime(Integer modifyTime) {
		this.modifyTime = modifyTime;
	}
	/**
	 * 获取：修改时间
	 */
	public Integer getModifyTime() {
		return modifyTime;
	}
}
