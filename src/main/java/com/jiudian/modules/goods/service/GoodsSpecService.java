package com.jiudian.modules.goods.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.goods.entity.GoodsSpecEntity;

import java.util.List;
import java.util.Map;

/**
 * 商品属性（规格）表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:53
 */
public interface GoodsSpecService extends IService<GoodsSpecEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取规格
     * @return
     */
	List<GoodsSpecEntity> getGoodsSpecList();

	/**
	 * 单一获取规格数据
	 * @param attrId
	 * @return
	 */
	List<GoodsSpecEntity> getGoodsSpecInfoQuery(Integer attrId);
}

