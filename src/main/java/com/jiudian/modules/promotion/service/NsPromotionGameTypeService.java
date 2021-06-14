package com.jiudian.modules.promotion.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.promotion.entity.NsPromotionGameTypeEntity;

import java.util.Map;

/**
 * 营销游戏类型
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-19 17:14:29
 */
public interface NsPromotionGameTypeService extends IService<NsPromotionGameTypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

