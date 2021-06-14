package com.jiudian.modules.goods.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.goods.entity.GoodsDeletedEntity;

import java.util.Map;

/**
 * 商品回收站表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
public interface GoodsDeletedService extends IService<GoodsDeletedEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

