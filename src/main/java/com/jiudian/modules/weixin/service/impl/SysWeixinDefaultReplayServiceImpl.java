package com.jiudian.modules.weixin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.weixin.dao.SysWeixinDefaultReplayDao;
import com.jiudian.modules.weixin.entity.SysWeixinDefaultReplayEntity;
import com.jiudian.modules.weixin.service.SysWeixinDefaultReplayService;


@Service("sysWeixinDefaultReplayService")
public class SysWeixinDefaultReplayServiceImpl extends ServiceImpl<SysWeixinDefaultReplayDao, SysWeixinDefaultReplayEntity> implements SysWeixinDefaultReplayService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysWeixinDefaultReplayEntity> page = this.selectPage(
                new Query<SysWeixinDefaultReplayEntity>(params).getPage(),
                new EntityWrapper<SysWeixinDefaultReplayEntity>()
        );

        return new PageUtils(page);
    }

}
