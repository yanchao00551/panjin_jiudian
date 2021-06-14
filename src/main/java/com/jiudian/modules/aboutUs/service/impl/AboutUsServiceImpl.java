package com.jiudian.modules.aboutUs.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.aboutUs.dao.AboutUsDao;
import com.jiudian.modules.aboutUs.entity.AboutUsEntity;
import com.jiudian.modules.aboutUs.service.AboutUsService;


@Service("aboutUsService")
public class AboutUsServiceImpl extends ServiceImpl<AboutUsDao, AboutUsEntity> implements AboutUsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AboutUsEntity> page = this.selectPage(
                new Query<AboutUsEntity>(params).getPage(),
                new EntityWrapper<AboutUsEntity>()
        );

        return new PageUtils(page);
    }

}
