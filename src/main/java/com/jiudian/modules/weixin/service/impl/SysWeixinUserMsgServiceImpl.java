package com.jiudian.modules.weixin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.weixin.dao.SysWeixinUserMsgDao;
import com.jiudian.modules.weixin.entity.SysWeixinUserMsgEntity;
import com.jiudian.modules.weixin.service.SysWeixinUserMsgService;


@Service("sysWeixinUserMsgService")
public class SysWeixinUserMsgServiceImpl extends ServiceImpl<SysWeixinUserMsgDao, SysWeixinUserMsgEntity> implements SysWeixinUserMsgService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysWeixinUserMsgEntity> page = this.selectPage(
                new Query<SysWeixinUserMsgEntity>(params).getPage(),
                new EntityWrapper<SysWeixinUserMsgEntity>()
        );

        return new PageUtils(page);
    }

}
