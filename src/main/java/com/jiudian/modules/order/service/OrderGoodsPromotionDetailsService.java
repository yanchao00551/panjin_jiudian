package com.jiudian.modules.order.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.order.entity.OrderGoodsPromotionDetailsEntity;

import java.util.Map;

/**
 * 订单商品优惠详情
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-02 15:13:28
 */
public interface OrderGoodsPromotionDetailsService extends IService<OrderGoodsPromotionDetailsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

