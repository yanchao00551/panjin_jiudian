package com.jiudian.modules.shop.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.shop.dao.ShopOrderAccountRecordsDao;
import com.jiudian.modules.shop.entity.ShopOrderAccountRecordsEntity;
import com.jiudian.modules.shop.service.ShopOrderAccountRecordsService;


@Service("shopOrderAccountRecordsService")
public class ShopOrderAccountRecordsServiceImpl extends ServiceImpl<ShopOrderAccountRecordsDao, ShopOrderAccountRecordsEntity> implements ShopOrderAccountRecordsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShopOrderAccountRecordsEntity> page = this.selectPage(
                new Query<ShopOrderAccountRecordsEntity>(params).getPage(),
                new EntityWrapper<ShopOrderAccountRecordsEntity>()
        );

        return new PageUtils(page);
    }

}
