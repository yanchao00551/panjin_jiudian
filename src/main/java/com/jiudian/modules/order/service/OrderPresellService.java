package com.jiudian.modules.order.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.order.entity.OrderPresellEntity;

import java.util.Map;

/**
 * 预售订单表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:37
 */
public interface OrderPresellService extends IService<OrderPresellEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

