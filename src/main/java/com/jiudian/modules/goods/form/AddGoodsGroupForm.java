package com.jiudian.modules.goods.form;

/**
 * 添加商品分组表单
 * 
 * @author KF-180419
 *
 */

public class AddGoodsGroupForm {

	/**
	 * 分组ID
	 */
	private Integer groupId;

	/**
	 * 分组名称
	 */
	private String groupName;

	/**
	 * 上级id 最多2级
	 */
	private Integer pid;

	/**
	 * 是否启用
	 */
	private Integer isVisible;

	/**
	 * 分组图片
	 */
	private String groupPic;

	/**
	 * 分组说明
	 */
	private String groupDec;

	/**
	 * 排序
	 */
	private Integer sort;

	
	
	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getIsVisible() {
		return isVisible;
	}

	public void setIsVisible(Integer isVisible) {
		this.isVisible = isVisible;
	}

	public String getGroupPic() {
		return groupPic;
	}

	public void setGroupPic(String groupPic) {
		this.groupPic = groupPic;
	}

	public String getGroupDec() {
		return groupDec;
	}

	public void setGroupDec(String groupDec) {
		this.groupDec = groupDec;
	}

}
