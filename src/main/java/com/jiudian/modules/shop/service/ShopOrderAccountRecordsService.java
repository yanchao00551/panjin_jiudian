package com.jiudian.modules.shop.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.shop.entity.ShopOrderAccountRecordsEntity;

import java.util.Map;

/**
 * 店铺针对订单的金额分配
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 13:58:03
 */
public interface ShopOrderAccountRecordsService extends IService<ShopOrderAccountRecordsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

