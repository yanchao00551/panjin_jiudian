package com.jiudian.modules.goods.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.goods.entity.GoodsGroupEntity;

import java.util.Map;

/**
 * 商品本店分类
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
public interface GoodsGroupService extends IService<GoodsGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);
	/**
	 * 商品分组列表
	 * @param params
	 * @return
	 */
	PageUtils getGoodsGroupList(Map<String, Object> params);
	
	/**
	 * 添加商品分组
	 * @param groupId
	 * @param instance_id
	 * @param groupName
	 * @param pid
	 * @param isVisible
	 * @param sort
	 * @param groupPic
	 * @param groupDec
	 * @return
	 */
	Integer addOrEditGoodsGroup(int groupId, Integer instance_id, String groupName, Integer pid, Integer isVisible,
			Integer sort, String groupPic, String groupDec);
	
	/**
	 * 删除商品分组
	 * @param groupId
	 * @param instance_id
	 * @return
	 */
	Integer deleteGoodsGroup(Integer groupId, Integer instance_id);
}

