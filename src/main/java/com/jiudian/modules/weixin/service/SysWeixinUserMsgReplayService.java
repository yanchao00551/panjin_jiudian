package com.jiudian.modules.weixin.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.weixin.entity.SysWeixinUserMsgReplayEntity;

import java.util.Map;

/**
 * 微信用户消息回复表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
public interface SysWeixinUserMsgReplayService extends IService<SysWeixinUserMsgReplayEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

