package com.jiudian.modules.order.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.order.entity.OrderGoodsExpressEntity;

import java.util.Map;

/**
 * 商品订单物流信息表（多次发货）
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-02 15:13:19
 */
public interface OrderGoodsExpressService extends IService<OrderGoodsExpressEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

