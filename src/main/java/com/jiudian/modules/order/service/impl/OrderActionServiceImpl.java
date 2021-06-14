package com.jiudian.modules.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.order.dao.OrderActionDao;
import com.jiudian.modules.order.entity.OrderActionEntity;
import com.jiudian.modules.order.service.OrderActionService;


@Service("orderActionService")
public class OrderActionServiceImpl extends ServiceImpl<OrderActionDao, OrderActionEntity> implements OrderActionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrderActionEntity> page = this.selectPage(
                new Query<OrderActionEntity>(params).getPage(),
                new EntityWrapper<OrderActionEntity>()
        );

        return new PageUtils(page);
    }

}
