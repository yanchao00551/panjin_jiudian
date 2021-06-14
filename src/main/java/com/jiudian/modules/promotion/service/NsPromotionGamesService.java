package com.jiudian.modules.promotion.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.promotion.entity.NsPromotionGamesEntity;

import java.util.Map;

/**
 * 营销游戏（概率游戏）
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-19 17:14:29
 */
public interface NsPromotionGamesService extends IService<NsPromotionGamesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

