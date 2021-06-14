package com.jiudian.modules.supplier.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 供货商表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-30 10:23:09
 */
@TableName("ns_supplier")
public class SupplierEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer supplierId;
	/**
	 * 
	 */
	private Integer uid;
	/**
	 * 供货商名称
	 */
	private String supplierName;
	/**
	 * 供货商描述
	 */
	private String desc;
	/**
	 * 联系人电话
	 */
	private String linkmanTel;
	/**
	 * 联系人姓名
	 */
	private String linkmanName;
	/**
	 * 联系人地址
	 */
	private String linkmanAddress;

	/**
	 * 设置：
	 */
	public void setSupplierId(Integer supplierId) {
		this.supplierId = supplierId;
	}
	/**
	 * 获取：
	 */
	public Integer getSupplierId() {
		return supplierId;
	}
	/**
	 * 设置：
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：供货商名称
	 */
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	/**
	 * 获取：供货商名称
	 */
	public String getSupplierName() {
		return supplierName;
	}
	/**
	 * 设置：供货商描述
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * 获取：供货商描述
	 */
	public String getDesc() {
		return desc;
	}
	/**
	 * 设置：联系人电话
	 */
	public void setLinkmanTel(String linkmanTel) {
		this.linkmanTel = linkmanTel;
	}
	/**
	 * 获取：联系人电话
	 */
	public String getLinkmanTel() {
		return linkmanTel;
	}
	/**
	 * 设置：联系人姓名
	 */
	public void setLinkmanName(String linkmanName) {
		this.linkmanName = linkmanName;
	}
	/**
	 * 获取：联系人姓名
	 */
	public String getLinkmanName() {
		return linkmanName;
	}
	/**
	 * 设置：联系人地址
	 */
	public void setLinkmanAddress(String linkmanAddress) {
		this.linkmanAddress = linkmanAddress;
	}
	/**
	 * 获取：联系人地址
	 */
	public String getLinkmanAddress() {
		return linkmanAddress;
	}
}
