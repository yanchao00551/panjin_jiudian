package com.jiudian.modules.order.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.order.entity.OrderActionEntity;

import java.util.Map;

/**
 * 订单操作表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:35
 */
public interface OrderActionService extends IService<OrderActionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

