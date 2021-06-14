package com.jiudian.modules.weixin.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.weixin.entity.SysWeixinUserMsgEntity;

import java.util.Map;

/**
 * 微信用户消息表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
public interface SysWeixinUserMsgService extends IService<SysWeixinUserMsgEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

