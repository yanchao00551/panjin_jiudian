package com.jiudian.modules.balance.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.balance.entity.BalanceCofigEntity;

import java.util.Map;

/**
 * 余额设置表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-22 08:46:17
 */
public interface BalanceCofigService extends IService<BalanceCofigEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

