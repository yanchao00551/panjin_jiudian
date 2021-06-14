package com.jiudian.modules.promotion.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.promotion.entity.NsPromotionGameRuleEntity;

import java.util.Map;

/**
 * 游戏活动规则
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-19 17:14:29
 */
public interface NsPromotionGameRuleService extends IService<NsPromotionGameRuleEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

