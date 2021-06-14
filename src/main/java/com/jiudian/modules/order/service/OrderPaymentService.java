package com.jiudian.modules.order.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.order.entity.OrderPaymentEntity;

import java.util.Map;

/**
 * 订单支付表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-02 15:13:28
 */
public interface OrderPaymentService extends IService<OrderPaymentEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

