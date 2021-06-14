package com.jiudian.modules.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.order.dao.OrderRefundAccountRecordsDao;
import com.jiudian.modules.order.entity.OrderRefundAccountRecordsEntity;
import com.jiudian.modules.order.service.OrderRefundAccountRecordsService;


@Service("orderRefundAccountRecordsService")
public class OrderRefundAccountRecordsServiceImpl extends ServiceImpl<OrderRefundAccountRecordsDao, OrderRefundAccountRecordsEntity> implements OrderRefundAccountRecordsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrderRefundAccountRecordsEntity> page = this.selectPage(
                new Query<OrderRefundAccountRecordsEntity>(params).getPage(),
                new EntityWrapper<OrderRefundAccountRecordsEntity>()
        );

        return new PageUtils(page);
    }

}
