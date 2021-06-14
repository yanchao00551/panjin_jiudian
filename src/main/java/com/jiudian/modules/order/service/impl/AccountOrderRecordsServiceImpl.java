package com.jiudian.modules.order.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.order.dao.AccountOrderRecordsDao;
import com.jiudian.modules.order.entity.AccountOrderRecordsEntity;
import com.jiudian.modules.order.service.AccountOrderRecordsService;


@Service("accountOrderRecordsService")
public class AccountOrderRecordsServiceImpl extends ServiceImpl<AccountOrderRecordsDao, AccountOrderRecordsEntity> implements AccountOrderRecordsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AccountOrderRecordsEntity> page = this.selectPage(
                new Query<AccountOrderRecordsEntity>(params).getPage(),
                new EntityWrapper<AccountOrderRecordsEntity>()
        );

        return new PageUtils(page);
    }

}
