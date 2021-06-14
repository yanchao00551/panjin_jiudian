package com.jiudian.modules.weixin.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 微信推广二维码模板管理
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
@TableName("sys_weixin_qrcode_template")
public class SysWeixinQrcodeTemplateEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 实例ID
	 */
	@TableId
	private Integer id;
	/**
	 * 店铺id
	 */
	private Integer instanceId;
	/**
	 * 背景图片
	 */
	private String background;
	/**
	 * 昵称字体颜色
	 */
	private String nickFontColor;
	/**
	 * 昵称字体大小
	 */
	private Integer nickFontSize;
	/**
	 * logo是否显示
	 */
	private Integer isLogoShow;
	/**
	 * 头部左边距
	 */
	private String headerLeft;
	/**
	 * 头部上边距
	 */
	private String headerTop;
	/**
	 * 昵称左边距
	 */
	private String nameLeft;
	/**
	 * 昵称上边距
	 */
	private String nameTop;
	/**
	 * logo左边距
	 */
	private String logoLeft;
	/**
	 * logo上边距
	 */
	private String logoTop;
	/**
	 * 二维码左边距
	 */
	private String codeLeft;
	/**
	 * 二维码上边距
	 */
	private String codeTop;
	/**
	 * 是否默认
	 */
	private Integer isCheck;
	/**
	 * 是否删除  0未删除 1删除
	 */
	private Integer isRemove;
	/**
	 * 模板样式路径
	 */
	private String templateUrl;

	/**
	 * 设置：实例ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：实例ID
	 */
	public Integer getId() {
		return id;
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
	 * 设置：背景图片
	 */
	public void setBackground(String background) {
		this.background = background;
	}
	/**
	 * 获取：背景图片
	 */
	public String getBackground() {
		return background;
	}
	/**
	 * 设置：昵称字体颜色
	 */
	public void setNickFontColor(String nickFontColor) {
		this.nickFontColor = nickFontColor;
	}
	/**
	 * 获取：昵称字体颜色
	 */
	public String getNickFontColor() {
		return nickFontColor;
	}
	/**
	 * 设置：昵称字体大小
	 */
	public void setNickFontSize(Integer nickFontSize) {
		this.nickFontSize = nickFontSize;
	}
	/**
	 * 获取：昵称字体大小
	 */
	public Integer getNickFontSize() {
		return nickFontSize;
	}
	/**
	 * 设置：logo是否显示
	 */
	public void setIsLogoShow(Integer isLogoShow) {
		this.isLogoShow = isLogoShow;
	}
	/**
	 * 获取：logo是否显示
	 */
	public Integer getIsLogoShow() {
		return isLogoShow;
	}
	/**
	 * 设置：头部左边距
	 */
	public void setHeaderLeft(String headerLeft) {
		this.headerLeft = headerLeft;
	}
	/**
	 * 获取：头部左边距
	 */
	public String getHeaderLeft() {
		return headerLeft;
	}
	/**
	 * 设置：头部上边距
	 */
	public void setHeaderTop(String headerTop) {
		this.headerTop = headerTop;
	}
	/**
	 * 获取：头部上边距
	 */
	public String getHeaderTop() {
		return headerTop;
	}
	/**
	 * 设置：昵称左边距
	 */
	public void setNameLeft(String nameLeft) {
		this.nameLeft = nameLeft;
	}
	/**
	 * 获取：昵称左边距
	 */
	public String getNameLeft() {
		return nameLeft;
	}
	/**
	 * 设置：昵称上边距
	 */
	public void setNameTop(String nameTop) {
		this.nameTop = nameTop;
	}
	/**
	 * 获取：昵称上边距
	 */
	public String getNameTop() {
		return nameTop;
	}
	/**
	 * 设置：logo左边距
	 */
	public void setLogoLeft(String logoLeft) {
		this.logoLeft = logoLeft;
	}
	/**
	 * 获取：logo左边距
	 */
	public String getLogoLeft() {
		return logoLeft;
	}
	/**
	 * 设置：logo上边距
	 */
	public void setLogoTop(String logoTop) {
		this.logoTop = logoTop;
	}
	/**
	 * 获取：logo上边距
	 */
	public String getLogoTop() {
		return logoTop;
	}
	/**
	 * 设置：二维码左边距
	 */
	public void setCodeLeft(String codeLeft) {
		this.codeLeft = codeLeft;
	}
	/**
	 * 获取：二维码左边距
	 */
	public String getCodeLeft() {
		return codeLeft;
	}
	/**
	 * 设置：二维码上边距
	 */
	public void setCodeTop(String codeTop) {
		this.codeTop = codeTop;
	}
	/**
	 * 获取：二维码上边距
	 */
	public String getCodeTop() {
		return codeTop;
	}
	/**
	 * 设置：是否默认
	 */
	public void setIsCheck(Integer isCheck) {
		this.isCheck = isCheck;
	}
	/**
	 * 获取：是否默认
	 */
	public Integer getIsCheck() {
		return isCheck;
	}
	/**
	 * 设置：是否删除  0未删除 1删除
	 */
	public void setIsRemove(Integer isRemove) {
		this.isRemove = isRemove;
	}
	/**
	 * 获取：是否删除  0未删除 1删除
	 */
	public Integer getIsRemove() {
		return isRemove;
	}
	/**
	 * 设置：模板样式路径
	 */
	public void setTemplateUrl(String templateUrl) {
		this.templateUrl = templateUrl;
	}
	/**
	 * 获取：模板样式路径
	 */
	public String getTemplateUrl() {
		return templateUrl;
	}
}
