package com.jiudian.modules.weixin.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.weixin.entity.SysWeixinQrcodeTemplateEntity;

import java.util.Map;

/**
 * 微信推广二维码模板管理
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
public interface SysWeixinQrcodeTemplateService extends IService<SysWeixinQrcodeTemplateEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

