package com.jiudian.modules.express.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 物流模板打印项
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-14 09:27:46
 */
@TableName("ns_express_shipping_items")
public class ExpressShippingItemsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 运单模版id
	 */
	@TableId
	private Integer sid;
	/**
	 * 字段名称
	 */
	private String fieldName;
	/**
	 * 打印项名称
	 */
	private String fieldDisplayName;
	/**
	 * 是否打印
	 */
	private Integer isPrint;
	/**
	 * x
	 */
	private Integer x;
	/**
	 * y
	 */
	private Integer y;

	/**
	 * 设置：运单模版id
	 */
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	/**
	 * 获取：运单模版id
	 */
	public Integer getSid() {
		return sid;
	}
	/**
	 * 设置：字段名称
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	/**
	 * 获取：字段名称
	 */
	public String getFieldName() {
		return fieldName;
	}
	/**
	 * 设置：打印项名称
	 */
	public void setFieldDisplayName(String fieldDisplayName) {
		this.fieldDisplayName = fieldDisplayName;
	}
	/**
	 * 获取：打印项名称
	 */
	public String getFieldDisplayName() {
		return fieldDisplayName;
	}
	/**
	 * 设置：是否打印
	 */
	public void setIsPrint(Integer isPrint) {
		this.isPrint = isPrint;
	}
	/**
	 * 获取：是否打印
	 */
	public Integer getIsPrint() {
		return isPrint;
	}
	/**
	 * 设置：x
	 */
	public void setX(Integer x) {
		this.x = x;
	}
	/**
	 * 获取：x
	 */
	public Integer getX() {
		return x;
	}
	/**
	 * 设置：y
	 */
	public void setY(Integer y) {
		this.y = y;
	}
	/**
	 * 获取：y
	 */
	public Integer getY() {
		return y;
	}
}
