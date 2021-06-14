package com.jiudian.modules.userMsg.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.userMsg.entity.UserMsgEntity;

/**
 * 
 *
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-10-27 16:20:26
 */
public interface UserMsgService extends IService<UserMsgEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    public PageUtils queryByMsgType(Map<String, String> params);
}

