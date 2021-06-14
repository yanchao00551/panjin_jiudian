package com.jiudian.modules.goods.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.goods.dao.GoodsAttributeValueDao;
import com.jiudian.modules.goods.entity.GoodsAttributeValueEntity;
import com.jiudian.modules.goods.service.GoodsAttributeValueService;


@Service("goodsAttributeValueService")
public class GoodsAttributeValueServiceImpl extends ServiceImpl<GoodsAttributeValueDao, GoodsAttributeValueEntity> implements GoodsAttributeValueService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsAttributeValueEntity> page = this.selectPage(
                new Query<GoodsAttributeValueEntity>(params).getPage(),
                new EntityWrapper<GoodsAttributeValueEntity>()
        );

        return new PageUtils(page);
    }


}
