package com.jiudian.modules.weixin.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 微设置->微店菜单
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
@TableName("sys_weixin_menu")
public class SysWeixinMenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	@TableId
	private Integer menuId;
	/**
	 * 店铺id
	 */
	private Integer instanceId;
	/**
	 * 菜单名称
	 */
	private String menuName;
	/**
	 * 菜图标单
	 */
	private String ico;
	/**
	 * 父菜单
	 */
	private Integer pid;
	/**
	 * 1普通url 2 图文素材 3 功能
	 */
	private Integer menuEventType;
	/**
	 * 图文消息ID
	 */
	private Integer mediaId;
	/**
	 * 菜单url
	 */
	private String menuEventUrl;
	/**
	 * 触发数
	 */
	private Integer hits;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 创建日期
	 */
	private Integer createDate;
	/**
	 * 修改日期
	 */
	private Integer modifyDate;

	/**
	 * 设置：主键
	 */
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	/**
	 * 获取：主键
	 */
	public Integer getMenuId() {
		return menuId;
	}
	/**
	 * 设置：店铺id
	 */
	public void setInstanceId(Integer instanceId) {
		this.instanceId = instanceId;
	}
	/**
	 * 获取：店铺id
	 */
	public Integer getInstanceId() {
		return instanceId;
	}
	/**
	 * 设置：菜单名称
	 */
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	/**
	 * 获取：菜单名称
	 */
	public String getMenuName() {
		return menuName;
	}
	/**
	 * 设置：菜图标单
	 */
	public void setIco(String ico) {
		this.ico = ico;
	}
	/**
	 * 获取：菜图标单
	 */
	public String getIco() {
		return ico;
	}
	/**
	 * 设置：父菜单
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 获取：父菜单
	 */
	public Integer getPid() {
		return pid;
	}
	/**
	 * 设置：1普通url 2 图文素材 3 功能
	 */
	public void setMenuEventType(Integer menuEventType) {
		this.menuEventType = menuEventType;
	}
	/**
	 * 获取：1普通url 2 图文素材 3 功能
	 */
	public Integer getMenuEventType() {
		return menuEventType;
	}
	/**
	 * 设置：图文消息ID
	 */
	public void setMediaId(Integer mediaId) {
		this.mediaId = mediaId;
	}
	/**
	 * 获取：图文消息ID
	 */
	public Integer getMediaId() {
		return mediaId;
	}
	/**
	 * 设置：菜单url
	 */
	public void setMenuEventUrl(String menuEventUrl) {
		this.menuEventUrl = menuEventUrl;
	}
	/**
	 * 获取：菜单url
	 */
	public String getMenuEventUrl() {
		return menuEventUrl;
	}
	/**
	 * 设置：触发数
	 */
	public void setHits(Integer hits) {
		this.hits = hits;
	}
	/**
	 * 获取：触发数
	 */
	public Integer getHits() {
		return hits;
	}
	/**
	 * 设置：排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：创建日期
	 */
	public void setCreateDate(Integer createDate) {
		this.createDate = createDate;
	}
	/**
	 * 获取：创建日期
	 */
	public Integer getCreateDate() {
		return createDate;
	}
	/**
	 * 设置：修改日期
	 */
	public void setModifyDate(Integer modifyDate) {
		this.modifyDate = modifyDate;
	}
	/**
	 * 获取：修改日期
	 */
	public Integer getModifyDate() {
		return modifyDate;
	}
}
