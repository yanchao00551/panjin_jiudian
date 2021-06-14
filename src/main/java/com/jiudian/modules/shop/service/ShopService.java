package com.jiudian.modules.shop.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.shop.entity.ShopEntity;

import java.util.Map;

/**
 * 店铺数据表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 13:58:03
 */
public interface ShopService extends IService<ShopEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

