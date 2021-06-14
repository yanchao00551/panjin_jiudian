package com.jiudian.modules.imgCode.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.imgCode.entity.ImgCodeEntity;

import java.util.Map;

/**
 * 
 *
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-11-07 10:16:48
 */
public interface ImgCodeService extends IService<ImgCodeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

