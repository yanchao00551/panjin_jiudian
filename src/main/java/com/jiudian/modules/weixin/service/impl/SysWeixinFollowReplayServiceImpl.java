package com.jiudian.modules.weixin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.weixin.dao.SysWeixinFollowReplayDao;
import com.jiudian.modules.weixin.entity.SysWeixinFollowReplayEntity;
import com.jiudian.modules.weixin.service.SysWeixinFollowReplayService;


@Service("sysWeixinFollowReplayService")
public class SysWeixinFollowReplayServiceImpl extends ServiceImpl<SysWeixinFollowReplayDao, SysWeixinFollowReplayEntity> implements SysWeixinFollowReplayService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysWeixinFollowReplayEntity> page = this.selectPage(
                new Query<SysWeixinFollowReplayEntity>(params).getPage(),
                new EntityWrapper<SysWeixinFollowReplayEntity>()
        );

        return new PageUtils(page);
    }

}
