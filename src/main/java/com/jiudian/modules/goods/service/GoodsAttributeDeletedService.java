package com.jiudian.modules.goods.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.goods.entity.GoodsAttributeDeletedEntity;

import java.util.Map;

/**
 * 商品属性回收站表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:40
 */
public interface GoodsAttributeDeletedService extends IService<GoodsAttributeDeletedEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

