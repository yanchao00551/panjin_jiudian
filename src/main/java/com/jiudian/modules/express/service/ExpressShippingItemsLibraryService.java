package com.jiudian.modules.express.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.express.entity.ExpressShippingItemsLibraryEntity;

import java.util.Map;

/**
 * 物流模版打印项库
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-14 09:27:46
 */
public interface ExpressShippingItemsLibraryService extends IService<ExpressShippingItemsLibraryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

