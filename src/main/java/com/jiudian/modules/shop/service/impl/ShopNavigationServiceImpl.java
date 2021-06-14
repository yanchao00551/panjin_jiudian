package com.jiudian.modules.shop.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.shop.dao.ShopNavigationDao;
import com.jiudian.modules.shop.entity.ShopNavigationEntity;
import com.jiudian.modules.shop.service.ShopNavigationService;


@Service("shopNavigationService")
public class ShopNavigationServiceImpl extends ServiceImpl<ShopNavigationDao, ShopNavigationEntity> implements ShopNavigationService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShopNavigationEntity> page = this.selectPage(
                new Query<ShopNavigationEntity>(params).getPage(),
                new EntityWrapper<ShopNavigationEntity>()
        );

        return new PageUtils(page);
    }

}
