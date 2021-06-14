package com.jiudian.modules.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.order.dao.OrderGoodsExpressDao;
import com.jiudian.modules.order.entity.OrderGoodsExpressEntity;
import com.jiudian.modules.order.service.OrderGoodsExpressService;


@Service("orderGoodsExpressService")
public class OrderGoodsExpressServiceImpl extends ServiceImpl<OrderGoodsExpressDao, OrderGoodsExpressEntity> implements OrderGoodsExpressService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrderGoodsExpressEntity> page = this.selectPage(
                new Query<OrderGoodsExpressEntity>(params).getPage(),
                new EntityWrapper<OrderGoodsExpressEntity>()
        );

        return new PageUtils(page);
    }

}
