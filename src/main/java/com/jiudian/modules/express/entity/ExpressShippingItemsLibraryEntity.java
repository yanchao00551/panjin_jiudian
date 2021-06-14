package com.jiudian.modules.express.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 物流模版打印项库
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-14 09:27:46
 */
@TableName("ns_express_shipping_items_library")
public class ExpressShippingItemsLibraryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 物流模版打印项库ID
	 */
	@TableId
	private Integer id;
	/**
	 * 店铺id
	 */
	private Integer shopId;
	/**
	 * 字段名
	 */
	private String fieldName;
	/**
	 * 字段显示名
	 */
	private String fieldDisplayName;
	/**
	 * 是否启用
	 */
	private Boolean isEnabled;

	/**
	 * 设置：物流模版打印项库ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：物流模版打印项库ID
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：店铺id
	 */
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	/**
	 * 获取：店铺id
	 */
	public Integer getShopId() {
		return shopId;
	}
	/**
	 * 设置：字段名
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	/**
	 * 获取：字段名
	 */
	public String getFieldName() {
		return fieldName;
	}
	/**
	 * 设置：字段显示名
	 */
	public void setFieldDisplayName(String fieldDisplayName) {
		this.fieldDisplayName = fieldDisplayName;
	}
	/**
	 * 获取：字段显示名
	 */
	public String getFieldDisplayName() {
		return fieldDisplayName;
	}
	/**
	 * 设置：是否启用
	 */
	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	/**
	 * 获取：是否启用
	 */
	public Boolean getIsEnabled() {
		return isEnabled;
	}
}
