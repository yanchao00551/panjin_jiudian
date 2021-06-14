package com.jiudian.modules.address.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.address.dao.ProvinceDao;
import com.jiudian.modules.address.entity.ProvinceEntity;
import com.jiudian.modules.address.service.ProvinceService;


@Service("provinceService")
public class ProvinceServiceImpl extends ServiceImpl<ProvinceDao, ProvinceEntity> implements ProvinceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ProvinceEntity> page = this.selectPage(
                new Query<ProvinceEntity>(params).getPage(),
                new EntityWrapper<ProvinceEntity>()
        );

        return new PageUtils(page);
    }

}
