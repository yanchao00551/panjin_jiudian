package com.jiudian.modules.sms.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.sms.entity.SysNoticeTemplateEntity;

import java.util.Map;
import java.util.List;
/**
 * 通知模版设置
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-22 10:30:13
 */
public interface SysNoticeTemplateService extends IService<SysNoticeTemplateEntity> {

    public abstract PageUtils queryPage(Map<String, Object> params);
    
    /**
     * 根据templateCode获取单行内容
     */
    public abstract List<SysNoticeTemplateEntity> queryByTemplateCodeInfo(String templateCode);
}

