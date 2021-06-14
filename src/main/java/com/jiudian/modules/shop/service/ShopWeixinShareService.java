package com.jiudian.modules.shop.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.shop.entity.ShopWeixinShareEntity;

import java.util.Map;

/**
 * 店铺分享内容设置
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 13:58:03
 */
public interface ShopWeixinShareService extends IService<ShopWeixinShareEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

