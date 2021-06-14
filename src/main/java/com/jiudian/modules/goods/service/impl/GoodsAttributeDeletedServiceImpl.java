package com.jiudian.modules.goods.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.goods.dao.GoodsAttributeDeletedDao;
import com.jiudian.modules.goods.entity.GoodsAttributeDeletedEntity;
import com.jiudian.modules.goods.service.GoodsAttributeDeletedService;


@Service("goodsAttributeDeletedService")
public class GoodsAttributeDeletedServiceImpl extends ServiceImpl<GoodsAttributeDeletedDao, GoodsAttributeDeletedEntity> implements GoodsAttributeDeletedService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsAttributeDeletedEntity> page = this.selectPage(
                new Query<GoodsAttributeDeletedEntity>(params).getPage(),
                new EntityWrapper<GoodsAttributeDeletedEntity>()
        );

        return new PageUtils(page);
    }

}
