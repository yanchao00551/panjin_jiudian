package com.jiudian.modules.shop.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.shop.dao.ShopCoinRecordsDao;
import com.jiudian.modules.shop.entity.ShopCoinRecordsEntity;
import com.jiudian.modules.shop.service.ShopCoinRecordsService;


@Service("shopCoinRecordsService")
public class ShopCoinRecordsServiceImpl extends ServiceImpl<ShopCoinRecordsDao, ShopCoinRecordsEntity> implements ShopCoinRecordsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShopCoinRecordsEntity> page = this.selectPage(
                new Query<ShopCoinRecordsEntity>(params).getPage(),
                new EntityWrapper<ShopCoinRecordsEntity>()
        );

        return new PageUtils(page);
    }

}
