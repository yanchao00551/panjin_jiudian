package com.jiudian.modules.order.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.order.entity.O2oOrderDeliveryEntity;

import java.util.Map;

/**
 * o2o订单配送
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:47
 */
public interface O2oOrderDeliveryService extends IService<O2oOrderDeliveryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

