package com.jiudian.modules.weixin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.weixin.dao.SysWeixinInstanceMsgDao;
import com.jiudian.modules.weixin.entity.SysWeixinInstanceMsgEntity;
import com.jiudian.modules.weixin.service.SysWeixinInstanceMsgService;


@Service("sysWeixinInstanceMsgService")
public class SysWeixinInstanceMsgServiceImpl extends ServiceImpl<SysWeixinInstanceMsgDao, SysWeixinInstanceMsgEntity> implements SysWeixinInstanceMsgService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysWeixinInstanceMsgEntity> page = this.selectPage(
                new Query<SysWeixinInstanceMsgEntity>(params).getPage(),
                new EntityWrapper<SysWeixinInstanceMsgEntity>()
        );

        return new PageUtils(page);
    }

}
