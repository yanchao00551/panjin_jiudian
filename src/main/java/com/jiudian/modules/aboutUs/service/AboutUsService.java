package com.jiudian.modules.aboutUs.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.aboutUs.entity.AboutUsEntity;

import java.util.Map;

/**
 * 
 *
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-12-07 09:49:30
 */
public interface AboutUsService extends IService<AboutUsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

