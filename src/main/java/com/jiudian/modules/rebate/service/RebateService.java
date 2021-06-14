package com.jiudian.modules.rebate.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.rebate.entity.RebateEntity;

import java.util.Map;

/**
 * 
 *
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-10-08 09:46:47
 */
public interface RebateService extends IService<RebateEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

