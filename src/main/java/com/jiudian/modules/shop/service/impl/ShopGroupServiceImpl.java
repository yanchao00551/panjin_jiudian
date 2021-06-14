package com.jiudian.modules.shop.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.shop.dao.ShopGroupDao;
import com.jiudian.modules.shop.entity.ShopGroupEntity;
import com.jiudian.modules.shop.service.ShopGroupService;


@Service("shopGroupService")
public class ShopGroupServiceImpl extends ServiceImpl<ShopGroupDao, ShopGroupEntity> implements ShopGroupService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShopGroupEntity> page = this.selectPage(
                new Query<ShopGroupEntity>(params).getPage(),
                new EntityWrapper<ShopGroupEntity>()
        );

        return new PageUtils(page);
    }

}
