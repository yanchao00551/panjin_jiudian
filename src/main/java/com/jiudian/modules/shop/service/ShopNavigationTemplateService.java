package com.jiudian.modules.shop.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.shop.entity.ShopNavigationTemplateEntity;

import java.util.Map;

/**
 * 导航 的 系统默认模板
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 13:58:03
 */
public interface ShopNavigationTemplateService extends IService<ShopNavigationTemplateEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

