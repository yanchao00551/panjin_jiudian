package com.jiudian.modules.goods.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.jiudian.modules.album.entity.AlbumPictureEntity;

import java.io.Serializable;

/**
 * 商品本店分类
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
@TableName("ns_goods_group")
public class GoodsGroupEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer groupId;
	/**
	 * 
	 */
	private Integer shopId;
	/**
	 * 分类名称
	 */
	private String groupName;
	/**
	 * 上级id 最多2级
	 */
	private Integer pid;
	/**
	 * 级别
	 */
	private Integer level;
	/**
	 * 是否可视
	 */
	private Integer isVisible;
	/**
	 * 图片
	 */
	private String groupPic;
	/**
	 * 
	 */
	private Integer sort;
	/**
	 * 标签描述
	 */
	private String groupDec;
	
	/*------ other -----*/
	@TableField(exist = false) 
	private AlbumPictureEntity picture;
	
	

	public AlbumPictureEntity getPicture() {
		return picture;
	}
	public void setPicture(AlbumPictureEntity picInfo) {
		this.picture = picInfo;
	}
	/**
	 * 设置：
	 */
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	/**
	 * 获取：
	 */
	public Integer getGroupId() {
		return groupId;
	}
	/**
	 * 设置：
	 */
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	/**
	 * 获取：
	 */
	public Integer getShopId() {
		return shopId;
	}
	/**
	 * 设置：分类名称
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	/**
	 * 获取：分类名称
	 */
	public String getGroupName() {
		return groupName;
	}
	/**
	 * 设置：上级id 最多2级
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 获取：上级id 最多2级
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * 设置：级别
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 获取：级别
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * 设置：是否可视
	 */
	public void setIsVisible(Integer isVisible) {
		this.isVisible = isVisible;
	}
	/**
	 * 获取：是否可视
	 */
	public Integer getIsVisible() {
		return isVisible;
	}
	/**
	 * 设置：图片
	 */
	public void setGroupPic(String groupPic) {
		this.groupPic = groupPic;
	}
	/**
	 * 获取：图片
	 */
	public String getGroupPic() {
		return groupPic;
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
	/**
	 * 设置：标签描述
	 */
	public void setGroupDec(String groupDec) {
		this.groupDec = groupDec;
	}
	/**
	 * 获取：标签描述
	 */
	public String getGroupDec() {
		return groupDec;
	}
}
