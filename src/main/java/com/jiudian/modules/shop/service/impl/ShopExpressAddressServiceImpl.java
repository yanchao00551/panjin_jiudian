package com.jiudian.modules.shop.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.shop.dao.ShopExpressAddressDao;
import com.jiudian.modules.shop.entity.ShopExpressAddressEntity;
import com.jiudian.modules.shop.service.ShopExpressAddressService;


@Service("shopExpressAddressService")
public class ShopExpressAddressServiceImpl extends ServiceImpl<ShopExpressAddressDao, ShopExpressAddressEntity> implements ShopExpressAddressService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShopExpressAddressEntity> page = this.selectPage(
                new Query<ShopExpressAddressEntity>(params).getPage(),
                new EntityWrapper<ShopExpressAddressEntity>()
        );

        return new PageUtils(page);
    }

}
