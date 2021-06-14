package com.jiudian.modules.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.order.dao.OrderRefundDao;
import com.jiudian.modules.order.entity.OrderRefundEntity;
import com.jiudian.modules.order.service.OrderRefundService;


@Service("orderRefundService")
public class OrderRefundServiceImpl extends ServiceImpl<OrderRefundDao, OrderRefundEntity> implements OrderRefundService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrderRefundEntity> page = this.selectPage(
                new Query<OrderRefundEntity>(params).getPage(),
                new EntityWrapper<OrderRefundEntity>()
        );

        return new PageUtils(page);
    }

}
