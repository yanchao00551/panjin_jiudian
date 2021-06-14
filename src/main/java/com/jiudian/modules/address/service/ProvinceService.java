package com.jiudian.modules.address.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.address.entity.ProvinceEntity;

import java.util.Map;

/**
 * 
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-02 10:59:59
 */
public interface ProvinceService extends IService<ProvinceEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

