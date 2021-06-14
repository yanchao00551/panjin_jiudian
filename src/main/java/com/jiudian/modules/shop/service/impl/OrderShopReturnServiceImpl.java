package com.jiudian.modules.shop.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.shop.dao.OrderShopReturnDao;
import com.jiudian.modules.shop.entity.OrderShopReturnEntity;
import com.jiudian.modules.shop.service.OrderShopReturnService;


@Service("orderShopReturnService")
public class OrderShopReturnServiceImpl extends ServiceImpl<OrderShopReturnDao, OrderShopReturnEntity> implements OrderShopReturnService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrderShopReturnEntity> page = this.selectPage(
                new Query<OrderShopReturnEntity>(params).getPage(),
                new EntityWrapper<OrderShopReturnEntity>()
        );

        return new PageUtils(page);
    }

}
