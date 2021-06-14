package com.jiudian.modules.shop.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.shop.dao.ShopDao;
import com.jiudian.modules.shop.entity.ShopEntity;
import com.jiudian.modules.shop.service.ShopService;


@Service("shopService")
public class ShopServiceImpl extends ServiceImpl<ShopDao, ShopEntity> implements ShopService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShopEntity> page = this.selectPage(
                new Query<ShopEntity>(params).getPage(),
                new EntityWrapper<ShopEntity>()
        );

        return new PageUtils(page);
    }

}
