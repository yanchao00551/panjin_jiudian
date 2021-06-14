package com.jiudian.modules.weixin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.weixin.dao.SysWeixinFunctiobuttonDao;
import com.jiudian.modules.weixin.entity.SysWeixinFunctiobuttonEntity;
import com.jiudian.modules.weixin.service.SysWeixinFunctiobuttonService;


@Service("sysWeixinFunctiobuttonService")
public class SysWeixinFunctiobuttonServiceImpl extends ServiceImpl<SysWeixinFunctiobuttonDao, SysWeixinFunctiobuttonEntity> implements SysWeixinFunctiobuttonService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysWeixinFunctiobuttonEntity> page = this.selectPage(
                new Query<SysWeixinFunctiobuttonEntity>(params).getPage(),
                new EntityWrapper<SysWeixinFunctiobuttonEntity>()
        );

        return new PageUtils(page);
    }

}
