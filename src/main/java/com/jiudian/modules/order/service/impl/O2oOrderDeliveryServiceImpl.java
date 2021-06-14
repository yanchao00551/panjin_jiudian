package com.jiudian.modules.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.order.dao.O2oOrderDeliveryDao;
import com.jiudian.modules.order.entity.O2oOrderDeliveryEntity;
import com.jiudian.modules.order.service.O2oOrderDeliveryService;


@Service("o2oOrderDeliveryService")
public class O2oOrderDeliveryServiceImpl extends ServiceImpl<O2oOrderDeliveryDao, O2oOrderDeliveryEntity> implements O2oOrderDeliveryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<O2oOrderDeliveryEntity> page = this.selectPage(
                new Query<O2oOrderDeliveryEntity>(params).getPage(),
                new EntityWrapper<O2oOrderDeliveryEntity>()
        );

        return new PageUtils(page);
    }

}
