package com.jiudian.modules.weixin.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.weixin.dao.SysWeixinQrcodeTemplateDao;
import com.jiudian.modules.weixin.entity.SysWeixinQrcodeTemplateEntity;
import com.jiudian.modules.weixin.service.SysWeixinQrcodeTemplateService;


@Service("sysWeixinQrcodeTemplateService")
public class SysWeixinQrcodeTemplateServiceImpl extends ServiceImpl<SysWeixinQrcodeTemplateDao, SysWeixinQrcodeTemplateEntity> implements SysWeixinQrcodeTemplateService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysWeixinQrcodeTemplateEntity> page = this.selectPage(
                new Query<SysWeixinQrcodeTemplateEntity>(params).getPage(),
                new EntityWrapper<SysWeixinQrcodeTemplateEntity>()
        );

        return new PageUtils(page);
    }

}
