package com.jiudian.modules.shop.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.shop.dao.ShopNavigationTemplateDao;
import com.jiudian.modules.shop.entity.ShopNavigationTemplateEntity;
import com.jiudian.modules.shop.service.ShopNavigationTemplateService;


@Service("shopNavigationTemplateService")
public class ShopNavigationTemplateServiceImpl extends ServiceImpl<ShopNavigationTemplateDao, ShopNavigationTemplateEntity> implements ShopNavigationTemplateService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShopNavigationTemplateEntity> page = this.selectPage(
                new Query<ShopNavigationTemplateEntity>(params).getPage(),
                new EntityWrapper<ShopNavigationTemplateEntity>()
        );

        return new PageUtils(page);
    }

}
