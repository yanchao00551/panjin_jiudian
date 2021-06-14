package com.jiudian.modules.goods.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.goods.dao.GoodsSkuPictureDao;
import com.jiudian.modules.goods.entity.GoodsSkuPictureEntity;
import com.jiudian.modules.goods.service.GoodsSkuPictureService;


@Service("goodsSkuPictureService")
public class GoodsSkuPictureServiceImpl extends ServiceImpl<GoodsSkuPictureDao, GoodsSkuPictureEntity> implements GoodsSkuPictureService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsSkuPictureEntity> page = this.selectPage(
                new Query<GoodsSkuPictureEntity>(params).getPage(),
                new EntityWrapper<GoodsSkuPictureEntity>()
        );

        return new PageUtils(page);
    }

}
