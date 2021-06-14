package com.jiudian.modules.goods.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.goods.dao.GoodsSkuDeletedDao;
import com.jiudian.modules.goods.entity.GoodsSkuDeletedEntity;
import com.jiudian.modules.goods.service.GoodsSkuDeletedService;


@Service("goodsSkuDeletedService")
public class GoodsSkuDeletedServiceImpl extends ServiceImpl<GoodsSkuDeletedDao, GoodsSkuDeletedEntity> implements GoodsSkuDeletedService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsSkuDeletedEntity> page = this.selectPage(
                new Query<GoodsSkuDeletedEntity>(params).getPage(),
                new EntityWrapper<GoodsSkuDeletedEntity>()
        );

        return new PageUtils(page);
    }

}
