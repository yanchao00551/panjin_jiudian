package com.jiudian.modules.weixin.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.weixin.entity.SysWeixinAuthEntity;

import java.util.Map;

/**
 * 店铺(实例)微信公众账号授权
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:23:07
 */
public interface SysWeixinAuthService extends IService<SysWeixinAuthEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

