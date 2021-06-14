package com.jiudian.modules.weixin.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.weixin.entity.SysWeixinFansEntity;

import java.util.Map;

/**
 * 微信公众号获取粉丝列表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:23:07
 */
public interface SysWeixinFansService extends IService<SysWeixinFansEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

