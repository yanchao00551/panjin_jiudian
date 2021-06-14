package com.jiudian.modules.order.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.math.BigDecimal;
import java.io.Serializable;

/**
 * 运费模板
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:36
 */
@TableName("ns_order_shipping_fee")
public class OrderShippingFeeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 运费模板ID
	 */
	@TableId
	private Integer shippingFeeId;
	/**
	 * 运费模板名称
	 */
	private String shippingFeeName;
	/**
	 * 是否是默认模板
	 */
	private Integer isDefault;
	/**
	 * 物流公司ID
	 */
	private Integer coId;
	/**
	 * 店铺ID
	 */
	private Integer shopId;
	/**
	 * 省ID组
	 */
	private String provinceIdArray;
	/**
	 * 市ID组
	 */
	private String cityIdArray;
	/**
	 * 是否启用重量运费
	 */
	private Integer weightIsUse;
	/**
	 * 首重
	 */
	private BigDecimal weightSnum;
	/**
	 * 首重运费
	 */
	private BigDecimal weightSprice;
	/**
	 * 续重
	 */
	private BigDecimal weightXnum;
	/**
	 * 续重运费
	 */
	private BigDecimal weightXprice;
	/**
	 * 是否启用体积计算运费
	 */
	private Integer volumeIsUse;
	/**
	 * 首体积量
	 */
	private BigDecimal volumeSnum;
	/**
	 * 首体积运费
	 */
	private BigDecimal volumeSprice;
	/**
	 * 续体积量
	 */
	private BigDecimal volumeXnum;
	/**
	 * 续体积运费
	 */
	private BigDecimal volumeXprice;
	/**
	 * 是否启用计件方式运费
	 */
	private Integer bynumIsUse;
	/**
	 * 首件
	 */
	private Integer bynumSnum;
	/**
	 * 首件运费
	 */
	private BigDecimal bynumSprice;
	/**
	 * 续件
	 */
	private Integer bynumXnum;
	/**
	 * 续件运费
	 */
	private BigDecimal bynumXprice;
	/**
	 * 创建日期
	 */
	private Integer createTime;
	/**
	 * 最后更新时间
	 */
	private Integer updateTime;
	/**
	 * 区县ID组
	 */
	private String districtIdArray;

	/**
	 * 设置：运费模板ID
	 */
	public void setShippingFeeId(Integer shippingFeeId) {
		this.shippingFeeId = shippingFeeId;
	}
	/**
	 * 获取：运费模板ID
	 */
	public Integer getShippingFeeId() {
		return shippingFeeId;
	}
	/**
	 * 设置：运费模板名称
	 */
	public void setShippingFeeName(String shippingFeeName) {
		this.shippingFeeName = shippingFeeName;
	}
	/**
	 * 获取：运费模板名称
	 */
	public String getShippingFeeName() {
		return shippingFeeName;
	}
	/**
	 * 设置：是否是默认模板
	 */
	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}
	/**
	 * 获取：是否是默认模板
	 */
	public Integer getIsDefault() {
		return isDefault;
	}
	/**
	 * 设置：物流公司ID
	 */
	public void setCoId(Integer coId) {
		this.coId = coId;
	}
	/**
	 * 获取：物流公司ID
	 */
	public Integer getCoId() {
		return coId;
	}
	/**
	 * 设置：店铺ID
	 */
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	/**
	 * 获取：店铺ID
	 */
	public Integer getShopId() {
		return shopId;
	}
	/**
	 * 设置：省ID组
	 */
	public void setProvinceIdArray(String provinceIdArray) {
		this.provinceIdArray = provinceIdArray;
	}
	/**
	 * 获取：省ID组
	 */
	public String getProvinceIdArray() {
		return provinceIdArray;
	}
	/**
	 * 设置：市ID组
	 */
	public void setCityIdArray(String cityIdArray) {
		this.cityIdArray = cityIdArray;
	}
	/**
	 * 获取：市ID组
	 */
	public String getCityIdArray() {
		return cityIdArray;
	}
	/**
	 * 设置：是否启用重量运费
	 */
	public void setWeightIsUse(Integer weightIsUse) {
		this.weightIsUse = weightIsUse;
	}
	/**
	 * 获取：是否启用重量运费
	 */
	public Integer getWeightIsUse() {
		return weightIsUse;
	}
	/**
	 * 设置：首重
	 */
	public void setWeightSnum(BigDecimal weightSnum) {
		this.weightSnum = weightSnum;
	}
	/**
	 * 获取：首重
	 */
	public BigDecimal getWeightSnum() {
		return weightSnum;
	}
	/**
	 * 设置：首重运费
	 */
	public void setWeightSprice(BigDecimal weightSprice) {
		this.weightSprice = weightSprice;
	}
	/**
	 * 获取：首重运费
	 */
	public BigDecimal getWeightSprice() {
		return weightSprice;
	}
	/**
	 * 设置：续重
	 */
	public void setWeightXnum(BigDecimal weightXnum) {
		this.weightXnum = weightXnum;
	}
	/**
	 * 获取：续重
	 */
	public BigDecimal getWeightXnum() {
		return weightXnum;
	}
	/**
	 * 设置：续重运费
	 */
	public void setWeightXprice(BigDecimal weightXprice) {
		this.weightXprice = weightXprice;
	}
	/**
	 * 获取：续重运费
	 */
	public BigDecimal getWeightXprice() {
		return weightXprice;
	}
	/**
	 * 设置：是否启用体积计算运费
	 */
	public void setVolumeIsUse(Integer volumeIsUse) {
		this.volumeIsUse = volumeIsUse;
	}
	/**
	 * 获取：是否启用体积计算运费
	 */
	public Integer getVolumeIsUse() {
		return volumeIsUse;
	}
	/**
	 * 设置：首体积量
	 */
	public void setVolumeSnum(BigDecimal volumeSnum) {
		this.volumeSnum = volumeSnum;
	}
	/**
	 * 获取：首体积量
	 */
	public BigDecimal getVolumeSnum() {
		return volumeSnum;
	}
	/**
	 * 设置：首体积运费
	 */
	public void setVolumeSprice(BigDecimal volumeSprice) {
		this.volumeSprice = volumeSprice;
	}
	/**
	 * 获取：首体积运费
	 */
	public BigDecimal getVolumeSprice() {
		return volumeSprice;
	}
	/**
	 * 设置：续体积量
	 */
	public void setVolumeXnum(BigDecimal volumeXnum) {
		this.volumeXnum = volumeXnum;
	}
	/**
	 * 获取：续体积量
	 */
	public BigDecimal getVolumeXnum() {
		return volumeXnum;
	}
	/**
	 * 设置：续体积运费
	 */
	public void setVolumeXprice(BigDecimal volumeXprice) {
		this.volumeXprice = volumeXprice;
	}
	/**
	 * 获取：续体积运费
	 */
	public BigDecimal getVolumeXprice() {
		return volumeXprice;
	}
	/**
	 * 设置：是否启用计件方式运费
	 */
	public void setBynumIsUse(Integer bynumIsUse) {
		this.bynumIsUse = bynumIsUse;
	}
	/**
	 * 获取：是否启用计件方式运费
	 */
	public Integer getBynumIsUse() {
		return bynumIsUse;
	}
	/**
	 * 设置：首件
	 */
	public void setBynumSnum(Integer bynumSnum) {
		this.bynumSnum = bynumSnum;
	}
	/**
	 * 获取：首件
	 */
	public Integer getBynumSnum() {
		return bynumSnum;
	}
	/**
	 * 设置：首件运费
	 */
	public void setBynumSprice(BigDecimal bynumSprice) {
		this.bynumSprice = bynumSprice;
	}
	/**
	 * 获取：首件运费
	 */
	public BigDecimal getBynumSprice() {
		return bynumSprice;
	}
	/**
	 * 设置：续件
	 */
	public void setBynumXnum(Integer bynumXnum) {
		this.bynumXnum = bynumXnum;
	}
	/**
	 * 获取：续件
	 */
	public Integer getBynumXnum() {
		return bynumXnum;
	}
	/**
	 * 设置：续件运费
	 */
	public void setBynumXprice(BigDecimal bynumXprice) {
		this.bynumXprice = bynumXprice;
	}
	/**
	 * 获取：续件运费
	 */
	public BigDecimal getBynumXprice() {
		return bynumXprice;
	}
	/**
	 * 设置：创建日期
	 */
	public void setCreateTime(Integer createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：创建日期
	 */
	public Integer getCreateTime() {
		return createTime;
	}
	/**
	 * 设置：最后更新时间
	 */
	public void setUpdateTime(Integer updateTime) {
		this.updateTime = updateTime;
	}
	/**
	 * 获取：最后更新时间
	 */
	public Integer getUpdateTime() {
		return updateTime;
	}
	/**
	 * 设置：区县ID组
	 */
	public void setDistrictIdArray(String districtIdArray) {
		this.districtIdArray = districtIdArray;
	}
	/**
	 * 获取：区县ID组
	 */
	public String getDistrictIdArray() {
		return districtIdArray;
	}
}
