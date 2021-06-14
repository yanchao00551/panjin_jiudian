package com.jiudian.modules.shop.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.shop.entity.ShopAdEntity;

import java.util.Map;

/**
 * 店铺广告设置
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 13:58:03
 */
public interface ShopAdService extends IService<ShopAdEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

