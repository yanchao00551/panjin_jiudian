package com.jiudian.modules.express.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.express.dao.ExpressCompanyDao;
import com.jiudian.modules.express.entity.ExpressCompanyEntity;
import com.jiudian.modules.express.service.ExpressCompanyService;


@Service("expressCompanyService")
public class ExpressCompanyServiceImpl extends ServiceImpl<ExpressCompanyDao, ExpressCompanyEntity> implements ExpressCompanyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ExpressCompanyEntity> page = this.selectPage(
                new Query<ExpressCompanyEntity>(params).getPage(),
                new EntityWrapper<ExpressCompanyEntity>()
        );

        return new PageUtils(page);
    }

}
