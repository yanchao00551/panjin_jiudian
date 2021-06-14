package com.jiudian.modules.rewardRecord.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.rewardRecord.entity.RewardRecordEntity;

import java.util.Map;

/**
 * 
 *
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-10-20 15:45:58
 */
public interface RewardRecordService extends IService<RewardRecordEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    public RewardRecordEntity querySumGroupByFromUid(Map<String, String> params);
}

