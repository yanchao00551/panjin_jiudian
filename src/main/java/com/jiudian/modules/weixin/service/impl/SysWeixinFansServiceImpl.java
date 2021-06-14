package com.jiudian.modules.weixin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.weixin.dao.SysWeixinFansDao;
import com.jiudian.modules.weixin.entity.SysWeixinFansEntity;
import com.jiudian.modules.weixin.service.SysWeixinFansService;


@Service("sysWeixinFansService")
public class SysWeixinFansServiceImpl extends ServiceImpl<SysWeixinFansDao, SysWeixinFansEntity> implements SysWeixinFansService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysWeixinFansEntity> page = this.selectPage(
                new Query<SysWeixinFansEntity>(params).getPage(),
                new EntityWrapper<SysWeixinFansEntity>()
        );

        return new PageUtils(page);
    }

}
