package com.jiudian.modules.shop.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.shop.dao.ShopWeixinShareDao;
import com.jiudian.modules.shop.entity.ShopWeixinShareEntity;
import com.jiudian.modules.shop.service.ShopWeixinShareService;


@Service("shopWeixinShareService")
public class ShopWeixinShareServiceImpl extends ServiceImpl<ShopWeixinShareDao, ShopWeixinShareEntity> implements ShopWeixinShareService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShopWeixinShareEntity> page = this.selectPage(
                new Query<ShopWeixinShareEntity>(params).getPage(),
                new EntityWrapper<ShopWeixinShareEntity>()
        );

        return new PageUtils(page);
    }

}
