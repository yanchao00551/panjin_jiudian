package com.jiudian.modules.star.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.star.entity.StarClassEntity;

import java.util.Map;

/**
 * 服务星分类表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-20 08:29:38
 */
public interface StarClassService extends IService<StarClassEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

