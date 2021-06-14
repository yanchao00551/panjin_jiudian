package com.jiudian.modules.supplier.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.supplier.dao.SupplierDao;
import com.jiudian.modules.supplier.entity.SupplierEntity;
import com.jiudian.modules.supplier.service.SupplierService;


@Service("supplierService")
public class SupplierServiceImpl extends ServiceImpl<SupplierDao, SupplierEntity> implements SupplierService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SupplierEntity> page = this.selectPage(
                new Query<SupplierEntity>(params).getPage(),
                new EntityWrapper<SupplierEntity>()
        );

        return new PageUtils(page);
    }

}
