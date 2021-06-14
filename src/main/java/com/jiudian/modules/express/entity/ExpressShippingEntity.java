package com.jiudian.modules.express.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 运单模板
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-14 09:27:46
 */
@TableName("ns_express_shipping")
public class ExpressShippingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 运单模版id
	 */
	@TableId
	private Integer sid;
	/**
	 * 店铺id
	 */
	private Integer shopId;
	/**
	 * 模版名称
	 */
	private String templateName;
	/**
	 * 物流公司 id
	 */
	private Integer coId;
	/**
	 * 尺寸类型 1像素px  2毫米mm
	 */
	private Integer sizeType;
	/**
	 * 宽度
	 */
	private Integer width;
	/**
	 * 长度
	 */
	private Integer height;
	/**
	 * 快递单图片
	 */
	private String image;

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
	 * 设置：模版名称
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	/**
	 * 获取：模版名称
	 */
	public String getTemplateName() {
		return templateName;
	}
	/**
	 * 设置：物流公司 id
	 */
	public void setCoId(Integer coId) {
		this.coId = coId;
	}
	/**
	 * 获取：物流公司 id
	 */
	public Integer getCoId() {
		return coId;
	}
	/**
	 * 设置：尺寸类型 1像素px  2毫米mm
	 */
	public void setSizeType(Integer sizeType) {
		this.sizeType = sizeType;
	}
	/**
	 * 获取：尺寸类型 1像素px  2毫米mm
	 */
	public Integer getSizeType() {
		return sizeType;
	}
	/**
	 * 设置：宽度
	 */
	public void setWidth(Integer width) {
		this.width = width;
	}
	/**
	 * 获取：宽度
	 */
	public Integer getWidth() {
		return width;
	}
	/**
	 * 设置：长度
	 */
	public void setHeight(Integer height) {
		this.height = height;
	}
	/**
	 * 获取：长度
	 */
	public Integer getHeight() {
		return height;
	}
	/**
	 * 设置：快递单图片
	 */
	public void setImage(String image) {
		this.image = image;
	}
	/**
	 * 获取：快递单图片
	 */
	public String getImage() {
		return image;
	}
}
