package com.jiudian.modules.promotion.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.promotion.dao.NsPromotionGamesDao;
import com.jiudian.modules.promotion.entity.NsPromotionGamesEntity;
import com.jiudian.modules.promotion.service.NsPromotionGamesService;


@Service("nsPromotionGamesService")
public class NsPromotionGamesServiceImpl extends ServiceImpl<NsPromotionGamesDao, NsPromotionGamesEntity> implements NsPromotionGamesService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NsPromotionGamesEntity> page = this.selectPage(
                new Query<NsPromotionGamesEntity>(params).getPage(),
                new EntityWrapper<NsPromotionGamesEntity>()
        );

        return new PageUtils(page);
    }

}
