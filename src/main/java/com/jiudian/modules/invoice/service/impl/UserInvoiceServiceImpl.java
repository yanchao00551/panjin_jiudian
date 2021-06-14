package com.jiudian.modules.invoice.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.invoice.dao.UserInvoiceDao;
import com.jiudian.modules.invoice.entity.UserInvoiceEntity;
import com.jiudian.modules.invoice.service.UserInvoiceService;


@Service("userInvoiceService")
public class UserInvoiceServiceImpl extends ServiceImpl<UserInvoiceDao, UserInvoiceEntity> implements UserInvoiceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserInvoiceEntity> page = this.selectPage(
                new Query<UserInvoiceEntity>(params).getPage(),
                new EntityWrapper<UserInvoiceEntity>()
        );

        return new PageUtils(page);
    }

}
