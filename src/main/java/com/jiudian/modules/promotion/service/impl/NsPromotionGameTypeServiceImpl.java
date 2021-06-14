package com.jiudian.modules.promotion.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.promotion.dao.NsPromotionGameTypeDao;
import com.jiudian.modules.promotion.entity.NsPromotionGameTypeEntity;
import com.jiudian.modules.promotion.service.NsPromotionGameTypeService;


@Service("nsPromotionGameTypeService")
public class NsPromotionGameTypeServiceImpl extends ServiceImpl<NsPromotionGameTypeDao, NsPromotionGameTypeEntity> implements NsPromotionGameTypeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NsPromotionGameTypeEntity> page = this.selectPage(
                new Query<NsPromotionGameTypeEntity>(params).getPage(),
                new EntityWrapper<NsPromotionGameTypeEntity>()
        );

        return new PageUtils(page);
    }

}
