package com.jiudian.modules.weixin.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.weixin.entity.SysWeixinMenuEntity;

import java.util.Map;

/**
 * 微设置->微店菜单
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
public interface SysWeixinMenuService extends IService<SysWeixinMenuEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

