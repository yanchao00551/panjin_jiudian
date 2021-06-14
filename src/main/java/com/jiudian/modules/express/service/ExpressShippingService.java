package com.jiudian.modules.express.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.express.entity.ExpressShippingEntity;

import java.util.Map;

/**
 * 运单模板
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-14 09:27:46
 */
public interface ExpressShippingService extends IService<ExpressShippingEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

