package com.jiudian.modules.order.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.order.entity.OrderRefundEntity;

import java.util.Map;

/**
 * 订单商品退货退款操作表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:37
 */
public interface OrderRefundService extends IService<OrderRefundEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

