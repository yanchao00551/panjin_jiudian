package com.jiudian.modules.balance.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.balance.dao.BalanceCofigDao;
import com.jiudian.modules.balance.entity.BalanceCofigEntity;
import com.jiudian.modules.balance.service.BalanceCofigService;


@Service("balanceCofigService")
public class BalanceCofigServiceImpl extends ServiceImpl<BalanceCofigDao, BalanceCofigEntity> implements BalanceCofigService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BalanceCofigEntity> page = this.selectPage(
                new Query<BalanceCofigEntity>(params).getPage(),
                new EntityWrapper<BalanceCofigEntity>()
        );

        return new PageUtils(page);
    }

}
