package com.jiudian.modules.weixin.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.weixin.entity.SysWeixinFollowReplayEntity;

import java.util.Map;

/**
 * 关注时回复
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:23:07
 */
public interface SysWeixinFollowReplayService extends IService<SysWeixinFollowReplayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

