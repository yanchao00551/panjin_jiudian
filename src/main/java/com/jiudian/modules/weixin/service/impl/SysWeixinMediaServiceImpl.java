package com.jiudian.modules.weixin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.weixin.dao.SysWeixinMediaDao;
import com.jiudian.modules.weixin.entity.SysWeixinMediaEntity;
import com.jiudian.modules.weixin.service.SysWeixinMediaService;


@Service("sysWeixinMediaService")
public class SysWeixinMediaServiceImpl extends ServiceImpl<SysWeixinMediaDao, SysWeixinMediaEntity> implements SysWeixinMediaService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysWeixinMediaEntity> page = this.selectPage(
                new Query<SysWeixinMediaEntity>(params).getPage(),
                new EntityWrapper<SysWeixinMediaEntity>()
        );

        return new PageUtils(page);
    }

}
