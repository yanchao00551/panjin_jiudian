package com.jiudian.modules.weixin.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.weixin.entity.SysWeixinKeyReplayEntity;

import java.util.Map;

/**
 * 关键词回复
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
public interface SysWeixinKeyReplayService extends IService<SysWeixinKeyReplayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

