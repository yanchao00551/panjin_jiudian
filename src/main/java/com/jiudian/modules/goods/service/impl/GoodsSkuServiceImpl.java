package com.jiudian.modules.goods.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.goods.dao.GoodsSkuDao;
import com.jiudian.modules.goods.entity.GoodsSkuEntity;
import com.jiudian.modules.goods.service.GoodsSkuService;


@Service("goodsSkuService")
public class GoodsSkuServiceImpl extends ServiceImpl<GoodsSkuDao, GoodsSkuEntity> implements GoodsSkuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsSkuEntity> page = this.selectPage(
                new Query<GoodsSkuEntity>(params).getPage(),
                new EntityWrapper<GoodsSkuEntity>()
        );

        return new PageUtils(page);
    }

}
