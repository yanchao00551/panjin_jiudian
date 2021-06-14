package com.jiudian.modules.smsMsgRecord.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.smsMsgRecord.entity.SmsMsgRecordEntity;

import java.util.Map;

/**
 * 
 *
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-11-07 15:17:02
 */
public interface SmsMsgRecordService extends IService<SmsMsgRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    public SmsMsgRecordEntity queryNewestRecord(Map<String, String> params);
    
    public Integer querySentCount(Map<String, String> params);
}

