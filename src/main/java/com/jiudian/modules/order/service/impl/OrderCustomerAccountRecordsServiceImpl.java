package com.jiudian.modules.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.order.dao.OrderCustomerAccountRecordsDao;
import com.jiudian.modules.order.entity.OrderCustomerAccountRecordsEntity;
import com.jiudian.modules.order.service.OrderCustomerAccountRecordsService;


@Service("orderCustomerAccountRecordsService")
public class OrderCustomerAccountRecordsServiceImpl extends ServiceImpl<OrderCustomerAccountRecordsDao, OrderCustomerAccountRecordsEntity> implements OrderCustomerAccountRecordsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrderCustomerAccountRecordsEntity> page = this.selectPage(
                new Query<OrderCustomerAccountRecordsEntity>(params).getPage(),
                new EntityWrapper<OrderCustomerAccountRecordsEntity>()
        );

        return new PageUtils(page);
    }

}
