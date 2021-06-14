package com.jiudian.modules.order.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.order.entity.OrderShippingFeeEntity;

import java.util.Map;

/**
 * 运费模板
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:36
 */
public interface OrderShippingFeeService extends IService<OrderShippingFeeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

