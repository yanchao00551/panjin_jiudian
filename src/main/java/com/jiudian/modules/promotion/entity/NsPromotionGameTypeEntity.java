package com.jiudian.modules.promotion.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;

/**
 * 营销游戏类型
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-19 17:14:29
 */
@TableName("ns_promotion_game_type")
public class NsPromotionGameTypeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Integer gameType;
	/**
	 * 类型名称
	 */
	private String typeName;
	/**
	 * 活动类型默认背景图
	 */
	private String typeImage;
	/**
	 * 活动小图标
	 */
	private String typeIco;
	/**
	 * 活动介绍
	 */
	private String typeDes;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 是否完成
	 */
	private Integer isComplete;
	/**
	 * 
	 */
	private String gameText;

	/**
	 * 设置：
	 */
	public void setGameType(Integer gameType) {
		this.gameType = gameType;
	}
	/**
	 * 获取：
	 */
	public Integer getGameType() {
		return gameType;
	}
	/**
	 * 设置：类型名称
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * 获取：类型名称
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * 设置：活动类型默认背景图
	 */
	public void setTypeImage(String typeImage) {
		this.typeImage = typeImage;
	}
	/**
	 * 获取：活动类型默认背景图
	 */
	public String getTypeImage() {
		return typeImage;
	}
	/**
	 * 设置：活动小图标
	 */
	public void setTypeIco(String typeIco) {
		this.typeIco = typeIco;
	}
	/**
	 * 获取：活动小图标
	 */
	public String getTypeIco() {
		return typeIco;
	}
	/**
	 * 设置：活动介绍
	 */
	public void setTypeDes(String typeDes) {
		this.typeDes = typeDes;
	}
	/**
	 * 获取：活动介绍
	 */
	public String getTypeDes() {
		return typeDes;
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
	 * 设置：是否完成
	 */
	public void setIsComplete(Integer isComplete) {
		this.isComplete = isComplete;
	}
	/**
	 * 获取：是否完成
	 */
	public Integer getIsComplete() {
		return isComplete;
	}
	/**
	 * 设置：
	 */
	public void setGameText(String gameText) {
		this.gameText = gameText;
	}
	/**
	 * 获取：
	 */
	public String getGameText() {
		return gameText;
	}
}
