package com.jiudian.modules.goods.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.goods.entity.GoodsCategoryBlockEntity;

import java.util.Map;

/**
 * 商品分类楼层表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
public interface GoodsCategoryBlockService extends IService<GoodsCategoryBlockEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

