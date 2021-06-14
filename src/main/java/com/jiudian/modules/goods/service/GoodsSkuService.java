package com.jiudian.modules.goods.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.goods.entity.GoodsSkuEntity;

import java.util.Map;

/**
 * 商品skui规格价格库存信息表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:53
 */
public interface GoodsSkuService extends IService<GoodsSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

