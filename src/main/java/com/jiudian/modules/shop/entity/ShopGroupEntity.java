package com.jiudian.modules.shop.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 店铺分组表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 13:58:02
 */
@TableName("ns_shop_group")
public class ShopGroupEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 分组ID
	 */
	@TableId
	private Integer shopGroupId;
	/**
	 * 分组名称
	 */
	private String groupName;
	/**
	 * 分组排序号
	 */
	private Integer groupSort;
	/**
	 * 创建时间
	 */
	private Integer createTime;
	/**
	 * 修改时间
	 */
	private Integer modifyTime;

	/**
	 * 设置：分组ID
	 */
	public void setShopGroupId(Integer shopGroupId) {
		this.shopGroupId = shopGroupId;
	}
	/**
	 * 获取：分组ID
	 */
	public Integer getShopGroupId() {
		return shopGroupId;
	}
	/**
	 * 设置：分组名称
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	/**
	 * 获取：分组名称
	 */
	public String getGroupName() {
		return groupName;
	}
	/**
	 * 设置：分组排序号
	 */
	public void setGroupSort(Integer groupSort) {
		this.groupSort = groupSort;
	}
	/**
	 * 获取：分组排序号
	 */
	public Integer getGroupSort() {
		return groupSort;
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
