package com.jiudian.modules.weixin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.weixin.dao.SysWeixinMediaItemDao;
import com.jiudian.modules.weixin.entity.SysWeixinMediaItemEntity;
import com.jiudian.modules.weixin.service.SysWeixinMediaItemService;


@Service("sysWeixinMediaItemService")
public class SysWeixinMediaItemServiceImpl extends ServiceImpl<SysWeixinMediaItemDao, SysWeixinMediaItemEntity> implements SysWeixinMediaItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysWeixinMediaItemEntity> page = this.selectPage(
                new Query<SysWeixinMediaItemEntity>(params).getPage(),
                new EntityWrapper<SysWeixinMediaItemEntity>()
        );

        return new PageUtils(page);
    }

}
