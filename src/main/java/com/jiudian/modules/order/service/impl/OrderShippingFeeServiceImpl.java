package com.jiudian.modules.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.order.dao.OrderShippingFeeDao;
import com.jiudian.modules.order.entity.OrderShippingFeeEntity;
import com.jiudian.modules.order.service.OrderShippingFeeService;


@Service("orderShippingFeeService")
public class OrderShippingFeeServiceImpl extends ServiceImpl<OrderShippingFeeDao, OrderShippingFeeEntity> implements OrderShippingFeeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrderShippingFeeEntity> page = this.selectPage(
                new Query<OrderShippingFeeEntity>(params).getPage(),
                new EntityWrapper<OrderShippingFeeEntity>()
        );

        return new PageUtils(page);
    }

}
