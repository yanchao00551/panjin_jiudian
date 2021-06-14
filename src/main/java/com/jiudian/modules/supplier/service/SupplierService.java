package com.jiudian.modules.supplier.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.supplier.entity.SupplierEntity;

import java.util.Map;

/**
 * 供货商表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-30 10:23:09
 */
public interface SupplierService extends IService<SupplierEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

