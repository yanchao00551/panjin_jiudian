package com.jiudian.modules.express.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.express.dao.ExpressShippingItemsDao;
import com.jiudian.modules.express.entity.ExpressShippingItemsEntity;
import com.jiudian.modules.express.service.ExpressShippingItemsService;


@Service("expressShippingItemsService")
public class ExpressShippingItemsServiceImpl extends ServiceImpl<ExpressShippingItemsDao, ExpressShippingItemsEntity> implements ExpressShippingItemsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ExpressShippingItemsEntity> page = this.selectPage(
                new Query<ExpressShippingItemsEntity>(params).getPage(),
                new EntityWrapper<ExpressShippingItemsEntity>()
        );

        return new PageUtils(page);
    }

}
