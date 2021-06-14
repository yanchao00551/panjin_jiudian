package com.jiudian.modules.weixin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.weixin.dao.SysWeixinQrcodeSimpleDao;
import com.jiudian.modules.weixin.entity.SysWeixinQrcodeSimpleEntity;
import com.jiudian.modules.weixin.service.SysWeixinQrcodeSimpleService;


@Service("sysWeixinQrcodeSimpleService")
public class SysWeixinQrcodeSimpleServiceImpl extends ServiceImpl<SysWeixinQrcodeSimpleDao, SysWeixinQrcodeSimpleEntity> implements SysWeixinQrcodeSimpleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysWeixinQrcodeSimpleEntity> page = this.selectPage(
                new Query<SysWeixinQrcodeSimpleEntity>(params).getPage(),
                new EntityWrapper<SysWeixinQrcodeSimpleEntity>()
        );

        return new PageUtils(page);
    }

}
