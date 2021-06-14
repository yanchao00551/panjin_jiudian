package com.jiudian.modules.promotion.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.promotion.entity.NsPromotionGamesWinningRecordsEntity;

import java.util.Map;

/**
 * 获奖记录
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-19 17:14:29
 */
public interface NsPromotionGamesWinningRecordsService extends IService<NsPromotionGamesWinningRecordsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

