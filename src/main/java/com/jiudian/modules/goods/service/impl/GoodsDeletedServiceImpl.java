package com.jiudian.modules.goods.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.goods.dao.GoodsDeletedDao;
import com.jiudian.modules.goods.entity.GoodsDeletedEntity;
import com.jiudian.modules.goods.service.GoodsDeletedService;


@Service("goodsDeletedService")
public class GoodsDeletedServiceImpl extends ServiceImpl<GoodsDeletedDao, GoodsDeletedEntity> implements GoodsDeletedService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsDeletedEntity> page = this.selectPage(
                new Query<GoodsDeletedEntity>(params).getPage(),
                new EntityWrapper<GoodsDeletedEntity>()
        );

        return new PageUtils(page);
    }

}
