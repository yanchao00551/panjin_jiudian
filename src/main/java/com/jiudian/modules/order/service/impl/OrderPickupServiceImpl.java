package com.jiudian.modules.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.order.dao.OrderPickupDao;
import com.jiudian.modules.order.entity.OrderPickupEntity;
import com.jiudian.modules.order.service.OrderPickupService;


@Service("orderPickupService")
public class OrderPickupServiceImpl extends ServiceImpl<OrderPickupDao, OrderPickupEntity> implements OrderPickupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrderPickupEntity> page = this.selectPage(
                new Query<OrderPickupEntity>(params).getPage(),
                new EntityWrapper<OrderPickupEntity>()
        );

        return new PageUtils(page);
    }

}
