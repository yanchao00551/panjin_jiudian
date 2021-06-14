package com.jiudian.modules.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.order.dao.OrderPresellDao;
import com.jiudian.modules.order.entity.OrderPresellEntity;
import com.jiudian.modules.order.service.OrderPresellService;


@Service("orderPresellService")
public class OrderPresellServiceImpl extends ServiceImpl<OrderPresellDao, OrderPresellEntity> implements OrderPresellService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrderPresellEntity> page = this.selectPage(
                new Query<OrderPresellEntity>(params).getPage(),
                new EntityWrapper<OrderPresellEntity>()
        );

        return new PageUtils(page);
    }

}
