package com.jiudian.modules.express.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.express.dao.ExpressShippingDao;
import com.jiudian.modules.express.entity.ExpressShippingEntity;
import com.jiudian.modules.express.service.ExpressShippingService;


@Service("expressShippingService")
public class ExpressShippingServiceImpl extends ServiceImpl<ExpressShippingDao, ExpressShippingEntity> implements ExpressShippingService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ExpressShippingEntity> page = this.selectPage(
                new Query<ExpressShippingEntity>(params).getPage(),
                new EntityWrapper<ExpressShippingEntity>()
        );

        return new PageUtils(page);
    }

}
