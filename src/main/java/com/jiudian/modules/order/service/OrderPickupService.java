package com.jiudian.modules.order.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.order.entity.OrderPickupEntity;

import java.util.Map;

/**
 * 订单自提点管理
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:54:29
 */
public interface OrderPickupService extends IService<OrderPickupEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

