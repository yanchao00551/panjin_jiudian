package com.jiudian.modules.userOpinion.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.userOpinion.entity.UserOpinionEntity;

/**
 * 
 *
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-10-27 14:44:06
 */
public interface UserOpinionService extends IService<UserOpinionEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    public PageUtils queryContainsUserInfo(Map<String, String> params);
}

