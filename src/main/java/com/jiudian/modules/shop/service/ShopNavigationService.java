package com.jiudian.modules.shop.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.shop.entity.ShopNavigationEntity;

import java.util.Map;

/**
 * 店铺导航管理
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 13:58:02
 */
public interface ShopNavigationService extends IService<ShopNavigationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

