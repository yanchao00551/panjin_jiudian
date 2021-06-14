package com.jiudian.modules.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.order.dao.OrderPaymentDao;
import com.jiudian.modules.order.entity.OrderPaymentEntity;
import com.jiudian.modules.order.service.OrderPaymentService;


@Service("orderPaymentService")
public class OrderPaymentServiceImpl extends ServiceImpl<OrderPaymentDao, OrderPaymentEntity> implements OrderPaymentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrderPaymentEntity> page = this.selectPage(
                new Query<OrderPaymentEntity>(params).getPage(),
                new EntityWrapper<OrderPaymentEntity>()
        );

        return new PageUtils(page);
    }

}
