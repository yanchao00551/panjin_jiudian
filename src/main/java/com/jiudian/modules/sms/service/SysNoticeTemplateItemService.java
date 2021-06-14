
package com.jiudian.modules.sms.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.sms.entity.SysNoticeTemplateItemEntity;

import java.util.Map;
import java.util.List;

/**
 * 通知模板项
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-22 11:24:27
 */
public interface SysNoticeTemplateItemService extends IService<SysNoticeTemplateItemEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    /**
     * 根据templateCode 模糊精确匹配变量
     */
    List<SysNoticeTemplateItemEntity> queryByTemplateCodeInfo(String templateCode);
    
}

