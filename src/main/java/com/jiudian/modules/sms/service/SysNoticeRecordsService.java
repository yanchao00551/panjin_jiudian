package com.jiudian.modules.sms.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.sms.entity.SysNoticeRecordsEntity;

import java.util.Map;

/**
 * 通知记录
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-21 09:08:19
 */
public interface SysNoticeRecordsService extends IService<SysNoticeRecordsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    /**
     * 阿里云短信发送
     * @param notice_id 未发送通知记录id
     * @param send_account 发送号码
     * @param send_config  发送核心配置json
     * @param notice_params 发送内容参数
     * @param templateTitle 发送模板ID
     * @return
     */
    Boolean noticeSmsSend(Integer notice_id, String send_account, String send_config, String notice_params,String templateCode);

    
}

