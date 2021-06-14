package com.jiudian.modules.weixin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.weixin.dao.SysWeixinUserMsgReplayDao;
import com.jiudian.modules.weixin.entity.SysWeixinUserMsgReplayEntity;
import com.jiudian.modules.weixin.service.SysWeixinUserMsgReplayService;


@Service("sysWeixinUserMsgReplayService")
public class SysWeixinUserMsgReplayServiceImpl extends ServiceImpl<SysWeixinUserMsgReplayDao, SysWeixinUserMsgReplayEntity> implements SysWeixinUserMsgReplayService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysWeixinUserMsgReplayEntity> page = this.selectPage(
                new Query<SysWeixinUserMsgReplayEntity>(params).getPage(),
                new EntityWrapper<SysWeixinUserMsgReplayEntity>()
        );

        return new PageUtils(page);
    }

}
