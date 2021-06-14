package com.jiudian.modules.goods.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.goods.dao.GoodsSkuPictureDeleteDao;
import com.jiudian.modules.goods.entity.GoodsSkuPictureDeleteEntity;
import com.jiudian.modules.goods.service.GoodsSkuPictureDeleteService;


@Service("goodsSkuPictureDeleteService")
public class GoodsSkuPictureDeleteServiceImpl extends ServiceImpl<GoodsSkuPictureDeleteDao, GoodsSkuPictureDeleteEntity> implements GoodsSkuPictureDeleteService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsSkuPictureDeleteEntity> page = this.selectPage(
                new Query<GoodsSkuPictureDeleteEntity>(params).getPage(),
                new EntityWrapper<GoodsSkuPictureDeleteEntity>()
        );

        return new PageUtils(page);
    }

}
