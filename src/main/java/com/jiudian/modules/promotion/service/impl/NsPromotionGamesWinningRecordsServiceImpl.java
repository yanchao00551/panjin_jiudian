package com.jiudian.modules.promotion.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.promotion.dao.NsPromotionGamesWinningRecordsDao;
import com.jiudian.modules.promotion.entity.NsPromotionGamesWinningRecordsEntity;
import com.jiudian.modules.promotion.service.NsPromotionGamesWinningRecordsService;


@Service("nsPromotionGamesWinningRecordsService")
public class NsPromotionGamesWinningRecordsServiceImpl extends ServiceImpl<NsPromotionGamesWinningRecordsDao, NsPromotionGamesWinningRecordsEntity> implements NsPromotionGamesWinningRecordsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NsPromotionGamesWinningRecordsEntity> page = this.selectPage(
                new Query<NsPromotionGamesWinningRecordsEntity>(params).getPage(),
                new EntityWrapper<NsPromotionGamesWinningRecordsEntity>()
        );

        return new PageUtils(page);
    }

}
