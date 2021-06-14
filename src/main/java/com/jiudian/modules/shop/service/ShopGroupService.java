package com.jiudian.modules.shop.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.shop.entity.ShopGroupEntity;

import java.util.Map;

/**
 * 店铺分组表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 13:58:02
 */
public interface ShopGroupService extends IService<ShopGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

