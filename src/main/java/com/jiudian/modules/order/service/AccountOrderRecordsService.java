package com.jiudian.modules.order.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.order.entity.AccountOrderRecordsEntity;

import java.util.Map;

/**
 * 金额账户记录
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:47
 */
public interface AccountOrderRecordsService extends IService<AccountOrderRecordsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

