package com.jiudian.modules.express.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.express.dao.ExpressShippingItemsLibraryDao;
import com.jiudian.modules.express.entity.ExpressShippingItemsLibraryEntity;
import com.jiudian.modules.express.service.ExpressShippingItemsLibraryService;


@Service("expressShippingItemsLibraryService")
public class ExpressShippingItemsLibraryServiceImpl extends ServiceImpl<ExpressShippingItemsLibraryDao, ExpressShippingItemsLibraryEntity> implements ExpressShippingItemsLibraryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ExpressShippingItemsLibraryEntity> page = this.selectPage(
                new Query<ExpressShippingItemsLibraryEntity>(params).getPage(),
                new EntityWrapper<ExpressShippingItemsLibraryEntity>()
        );

        return new PageUtils(page);
    }

}
