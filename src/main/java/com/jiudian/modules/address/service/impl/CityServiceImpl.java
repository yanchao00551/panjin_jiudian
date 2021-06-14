package com.jiudian.modules.address.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.address.dao.CityDao;
import com.jiudian.modules.address.entity.CityEntity;
import com.jiudian.modules.address.service.CityService;


@Service("cityService")
public class CityServiceImpl extends ServiceImpl<CityDao, CityEntity> implements CityService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CityEntity> page = this.selectPage(
                new Query<CityEntity>(params).getPage(),
                new EntityWrapper<CityEntity>()
        );

        return new PageUtils(page);
    }

}
