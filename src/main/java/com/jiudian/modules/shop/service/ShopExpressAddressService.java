package com.jiudian.modules.shop.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.shop.entity.ShopExpressAddressEntity;

import java.util.Map;

/**
 * 物流地址
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 13:58:02
 */
public interface ShopExpressAddressService extends IService<ShopExpressAddressEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

