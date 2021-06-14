package com.jiudian.modules.rebate.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.rebate.dao.RebateDao;
import com.jiudian.modules.rebate.entity.RebateEntity;
import com.jiudian.modules.rebate.service.RebateService;


@Service("rebateService")
public class RebateServiceImpl extends ServiceImpl<RebateDao, RebateEntity> implements RebateService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<RebateEntity> page = this.selectPage(
                new Query<RebateEntity>(params).getPage(),
                new EntityWrapper<RebateEntity>()
        );

        return new PageUtils(page);
    }

}
