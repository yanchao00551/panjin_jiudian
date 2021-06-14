package com.jiudian.modules.goods.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.goods.dao.GoodsLadderPreferentialDao;
import com.jiudian.modules.goods.entity.GoodsLadderPreferentialEntity;
import com.jiudian.modules.goods.service.GoodsLadderPreferentialService;


@Service("goodsLadderPreferentialService")
public class GoodsLadderPreferentialServiceImpl extends ServiceImpl<GoodsLadderPreferentialDao, GoodsLadderPreferentialEntity> implements GoodsLadderPreferentialService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsLadderPreferentialEntity> page = this.selectPage(
                new Query<GoodsLadderPreferentialEntity>(params).getPage(),
                new EntityWrapper<GoodsLadderPreferentialEntity>()
        );

        return new PageUtils(page);
    }

}
