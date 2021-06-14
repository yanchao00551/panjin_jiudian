package com.jiudian.modules.express.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.express.entity.ExpressCompanyEntity;

import java.util.Map;

/**
 * 物流公司
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-14 09:27:46
 */
public interface ExpressCompanyService extends IService<ExpressCompanyEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

