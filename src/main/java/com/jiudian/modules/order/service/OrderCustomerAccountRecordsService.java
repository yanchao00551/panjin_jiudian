package com.jiudian.modules.order.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.order.entity.OrderCustomerAccountRecordsEntity;

import java.util.Map;

/**
 * 订单售后账户记录
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:36
 */
public interface OrderCustomerAccountRecordsService extends IService<OrderCustomerAccountRecordsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

