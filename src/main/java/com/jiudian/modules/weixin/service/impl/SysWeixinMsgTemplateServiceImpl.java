package com.jiudian.modules.weixin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.weixin.dao.SysWeixinMsgTemplateDao;
import com.jiudian.modules.weixin.entity.SysWeixinMsgTemplateEntity;
import com.jiudian.modules.weixin.service.SysWeixinMsgTemplateService;


@Service("sysWeixinMsgTemplateService")
public class SysWeixinMsgTemplateServiceImpl extends ServiceImpl<SysWeixinMsgTemplateDao, SysWeixinMsgTemplateEntity> implements SysWeixinMsgTemplateService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysWeixinMsgTemplateEntity> page = this.selectPage(
                new Query<SysWeixinMsgTemplateEntity>(params).getPage(),
                new EntityWrapper<SysWeixinMsgTemplateEntity>()
        );

        return new PageUtils(page);
    }

}
