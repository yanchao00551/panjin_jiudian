package com.jiudian.modules.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.order.dao.OrderGoodsPromotionDetailsDao;
import com.jiudian.modules.order.entity.OrderGoodsPromotionDetailsEntity;
import com.jiudian.modules.order.service.OrderGoodsPromotionDetailsService;


@Service("orderGoodsPromotionDetailsService")
public class OrderGoodsPromotionDetailsServiceImpl extends ServiceImpl<OrderGoodsPromotionDetailsDao, OrderGoodsPromotionDetailsEntity> implements OrderGoodsPromotionDetailsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrderGoodsPromotionDetailsEntity> page = this.selectPage(
                new Query<OrderGoodsPromotionDetailsEntity>(params).getPage(),
                new EntityWrapper<OrderGoodsPromotionDetailsEntity>()
        );

        return new PageUtils(page);
    }

}
