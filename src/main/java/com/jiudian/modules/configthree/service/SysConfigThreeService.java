package com.jiudian.modules.configthree.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.configthree.entity.SysConfigThreeEntity;

import java.util.List;
import java.util.Map;

/**
 * 第三方配置表
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-06-20 09:40:02
 */
public interface SysConfigThreeService extends IService<SysConfigThreeEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    /**
     * 根据key查第三方配置信息
     */
    SysConfigThreeEntity queryByKeyInfo(String key);

    /**
     * 会员提现设置
     * @param shopId
     * @param key
     * @param withdrawAccountMap
     * @param isUse
     * @return
     */
    boolean setBalanceWithdrawConfig(Integer shopId, String key, List<Map<String, Object>> withdrawAccountMap,
			Integer isUse);
    
}

