package com.jiudian.modules.weixin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.weixin.dao.SysWeixinAuthDao;
import com.jiudian.modules.weixin.entity.SysWeixinAuthEntity;
import com.jiudian.modules.weixin.service.SysWeixinAuthService;


@Service("sysWeixinAuthService")
public class SysWeixinAuthServiceImpl extends ServiceImpl<SysWeixinAuthDao, SysWeixinAuthEntity> implements SysWeixinAuthService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysWeixinAuthEntity> page = this.selectPage(
                new Query<SysWeixinAuthEntity>(params).getPage(),
                new EntityWrapper<SysWeixinAuthEntity>()
        );

        return new PageUtils(page);
    }

}
