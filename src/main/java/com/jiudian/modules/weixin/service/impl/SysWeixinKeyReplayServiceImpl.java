package com.jiudian.modules.weixin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.weixin.dao.SysWeixinKeyReplayDao;
import com.jiudian.modules.weixin.entity.SysWeixinKeyReplayEntity;
import com.jiudian.modules.weixin.service.SysWeixinKeyReplayService;


@Service("sysWeixinKeyReplayService")
public class SysWeixinKeyReplayServiceImpl extends ServiceImpl<SysWeixinKeyReplayDao, SysWeixinKeyReplayEntity> implements SysWeixinKeyReplayService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysWeixinKeyReplayEntity> page = this.selectPage(
                new Query<SysWeixinKeyReplayEntity>(params).getPage(),
                new EntityWrapper<SysWeixinKeyReplayEntity>()
        );

        return new PageUtils(page);
    }

}
