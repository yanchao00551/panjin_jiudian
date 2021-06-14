package com.jiudian.modules.order.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.order.entity.OrderRefundAccountRecordsEntity;

import java.util.Map;

/**
 * 订单退款账户记录
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:37
 */
public interface OrderRefundAccountRecordsService extends IService<OrderRefundAccountRecordsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

