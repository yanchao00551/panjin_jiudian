package com.jiudian.modules.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.order.dao.OrderPromotionDetailsDao;
import com.jiudian.modules.order.entity.OrderPromotionDetailsEntity;
import com.jiudian.modules.order.service.OrderPromotionDetailsService;


@Service("orderPromotionDetailsService")
public class OrderPromotionDetailsServiceImpl extends ServiceImpl<OrderPromotionDetailsDao, OrderPromotionDetailsEntity> implements OrderPromotionDetailsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrderPromotionDetailsEntity> page = this.selectPage(
                new Query<OrderPromotionDetailsEntity>(params).getPage(),
                new EntityWrapper<OrderPromotionDetailsEntity>()
        );

        return new PageUtils(page);
    }

}
