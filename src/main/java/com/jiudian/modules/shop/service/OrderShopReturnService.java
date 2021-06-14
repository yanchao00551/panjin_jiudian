package com.jiudian.modules.shop.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.shop.entity.OrderShopReturnEntity;

import java.util.Map;

/**
 * 店铺退货设置
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 13:58:04
 */
public interface OrderShopReturnService extends IService<OrderShopReturnEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

