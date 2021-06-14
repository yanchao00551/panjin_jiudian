package com.jiudian.modules.star.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.star.dao.StarClassDao;
import com.jiudian.modules.star.entity.StarClassEntity;
import com.jiudian.modules.star.service.StarClassService;


@Service("starClassService")
public class StarClassServiceImpl extends ServiceImpl<StarClassDao, StarClassEntity> implements StarClassService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<StarClassEntity> page = this.selectPage(
                new Query<StarClassEntity>(params).getPage(),
                new EntityWrapper<StarClassEntity>().eq("type", params.get("type"))
        );

        return new PageUtils(page);
    }

}
