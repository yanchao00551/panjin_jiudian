package com.jiudian.modules.shop.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.shop.dao.ShopAdDao;
import com.jiudian.modules.shop.entity.ShopAdEntity;
import com.jiudian.modules.shop.service.ShopAdService;


@Service("shopAdService")
public class ShopAdServiceImpl extends ServiceImpl<ShopAdDao, ShopAdEntity> implements ShopAdService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShopAdEntity> page = this.selectPage(
                new Query<ShopAdEntity>(params).getPage(),
                new EntityWrapper<ShopAdEntity>()
        );

        return new PageUtils(page);
    }

}
