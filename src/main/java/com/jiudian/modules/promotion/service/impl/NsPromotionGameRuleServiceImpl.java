package com.jiudian.modules.promotion.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.promotion.dao.NsPromotionGameRuleDao;
import com.jiudian.modules.promotion.entity.NsPromotionGameRuleEntity;
import com.jiudian.modules.promotion.service.NsPromotionGameRuleService;


@Service("nsPromotionGameRuleService")
public class NsPromotionGameRuleServiceImpl extends ServiceImpl<NsPromotionGameRuleDao, NsPromotionGameRuleEntity> implements NsPromotionGameRuleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NsPromotionGameRuleEntity> page = this.selectPage(
                new Query<NsPromotionGameRuleEntity>(params).getPage(),
                new EntityWrapper<NsPromotionGameRuleEntity>()
        );

        return new PageUtils(page);
    }

}
