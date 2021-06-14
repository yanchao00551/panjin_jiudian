package com.jiudian.modules.goods.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.goods.entity.GoodsAttributeValueEntity;

import java.util.Map;

/**
 * 商品规格值模版表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-09 14:37:47
 */
public interface GoodsAttributeValueService extends IService<GoodsAttributeValueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    

}

