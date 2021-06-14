package com.jiudian.modules.goods.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.goods.entity.GoodsBrandEntity;

import java.util.List;
import java.util.Map;

/**
 * 品牌表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
public interface GoodsBrandService extends IService<GoodsBrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取品牌
     * @return
     */
	List<GoodsBrandEntity> getGoodsBrandList();

	
	/**
	 * 获取品牌分页带模糊查询列表
	 * @param params
	 * @param instance_id 
	 * @return
	 */
	PageUtils getGoodsBrandList(Map<String, Object> params, Integer instance_id);
}

