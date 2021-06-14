package com.jiudian.modules.weixin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.weixin.dao.SysWeixinMenuDao;
import com.jiudian.modules.weixin.entity.SysWeixinMenuEntity;
import com.jiudian.modules.weixin.service.SysWeixinMenuService;


@Service("sysWeixinMenuService")
public class SysWeixinMenuServiceImpl extends ServiceImpl<SysWeixinMenuDao, SysWeixinMenuEntity> implements SysWeixinMenuService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysWeixinMenuEntity> page = this.selectPage(
                new Query<SysWeixinMenuEntity>(params).getPage(),
                new EntityWrapper<SysWeixinMenuEntity>()
        );

        return new PageUtils(page);
    }

}
