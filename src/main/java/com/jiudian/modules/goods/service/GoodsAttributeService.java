package com.jiudian.modules.goods.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.goods.entity.GoodsAttributeEntity;

import java.util.Map;

/**
 * 商品属性表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:40
 */
public interface GoodsAttributeService extends IService<GoodsAttributeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
	/**
	 * 更新属性值排序
	 * @param attrValueId
	 * @param fieldValue
	 * @param instance_id
	 * @return
	 */
	Integer updateGoodsAttributeSort(Integer attrValueId, String fieldValue, Integer instance_id);

	
}

