package com.jiudian.modules.goods.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.goods.entity.GoodsSpecValueEntity;

import java.util.Map;

/**
 * 商品规格值模版表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:53
 */
public interface GoodsSpecValueService extends IService<GoodsSpecValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

