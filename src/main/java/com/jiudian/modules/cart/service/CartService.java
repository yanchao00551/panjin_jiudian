package com.jiudian.modules.cart.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.cart.entity.CartEntity;

import java.util.Map;

/**
 * 购物车表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-28 10:13:44
 */
public interface CartService extends IService<CartEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

