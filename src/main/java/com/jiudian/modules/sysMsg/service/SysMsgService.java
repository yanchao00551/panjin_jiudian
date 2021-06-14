package com.jiudian.modules.sysMsg.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.sysMsg.entity.SysMsgEntity;

import java.util.Map;

/**
 * 
 *
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-10-27 16:23:13
 */
public interface SysMsgService extends IService<SysMsgEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

