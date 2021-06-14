package com.jiudian.modules.goods.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.goods.dao.GoodsSpecValueDao;
import com.jiudian.modules.goods.entity.GoodsSpecValueEntity;
import com.jiudian.modules.goods.service.GoodsSpecValueService;


@Service("goodsSpecValueService")
public class GoodsSpecValueServiceImpl extends ServiceImpl<GoodsSpecValueDao, GoodsSpecValueEntity> implements GoodsSpecValueService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsSpecValueEntity> page = this.selectPage(
                new Query<GoodsSpecValueEntity>(params).getPage(),
                new EntityWrapper<GoodsSpecValueEntity>()
        );

        return new PageUtils(page);
    }

}
