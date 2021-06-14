package com.jiudian.modules.goods.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.goods.dao.GoodsCategoryBlockDao;
import com.jiudian.modules.goods.entity.GoodsCategoryBlockEntity;
import com.jiudian.modules.goods.service.GoodsCategoryBlockService;


@Service("goodsCategoryBlockService")
public class GoodsCategoryBlockServiceImpl extends ServiceImpl<GoodsCategoryBlockDao, GoodsCategoryBlockEntity> implements GoodsCategoryBlockService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsCategoryBlockEntity> page = this.selectPage(
                new Query<GoodsCategoryBlockEntity>(params).getPage(),
                new EntityWrapper<GoodsCategoryBlockEntity>()
        );

        return new PageUtils(page);
    }

}
