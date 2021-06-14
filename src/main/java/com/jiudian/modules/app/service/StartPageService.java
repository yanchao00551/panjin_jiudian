package com.jiudian.modules.app.service;

import java.util.List;
import java.util.Map;

import com.jiudian.modules.app.entity.StartPageEntity;
import com.jiudian.modules.goods.entity.GoodsGroupEntity;

public interface StartPageService{
	/**
	 * 获取首页信息
	 * @return 首页信息
	 */
	public StartPageEntity getStartPage(Map<String,String> tParams);
	
	/**
	 * 获取商品标签列表
	 * @return 商品标签列表
	 */
	public List<GoodsGroupEntity> getGroupList();

}
