package com.jiudian.modules.address.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.address.dao.DistrictDao;
import com.jiudian.modules.address.entity.DistrictEntity;
import com.jiudian.modules.address.service.DistrictService;


@Service("districtService")
public class DistrictServiceImpl extends ServiceImpl<DistrictDao, DistrictEntity> implements DistrictService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DistrictEntity> page = this.selectPage(
                new Query<DistrictEntity>(params).getPage(),
                new EntityWrapper<DistrictEntity>()
        );

        return new PageUtils(page);
    }

}
