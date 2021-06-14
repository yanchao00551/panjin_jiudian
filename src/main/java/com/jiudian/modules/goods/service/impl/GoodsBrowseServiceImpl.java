package com.jiudian.modules.goods.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.goods.dao.GoodsBrowseDao;
import com.jiudian.modules.goods.entity.GoodsBrowseEntity;
import com.jiudian.modules.goods.service.GoodsBrowseService;


@Service("goodsBrowseService")
public class GoodsBrowseServiceImpl extends ServiceImpl<GoodsBrowseDao, GoodsBrowseEntity> implements GoodsBrowseService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodsBrowseEntity> page = this.selectPage(
                new Query<GoodsBrowseEntity>(params).getPage(),
                new EntityWrapper<GoodsBrowseEntity>()
        );

        return new PageUtils(page);
    }

}
