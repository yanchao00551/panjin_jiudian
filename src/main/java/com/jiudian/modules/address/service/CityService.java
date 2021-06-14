package com.jiudian.modules.address.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.address.entity.CityEntity;

import java.util.Map;

/**
 * 
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-02 11:00:07
 */
public interface CityService extends IService<CityEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

