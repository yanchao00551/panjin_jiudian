package com.jiudian.modules.weixin.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.weixin.entity.SysWeixinFunctiobuttonEntity;

import java.util.Map;

/**
 * 微信功能按钮
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:23:07
 */
public interface SysWeixinFunctiobuttonService extends IService<SysWeixinFunctiobuttonEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

