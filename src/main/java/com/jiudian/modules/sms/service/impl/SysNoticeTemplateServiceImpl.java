package com.jiudian.modules.sms.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.sms.dao.SysNoticeTemplateDao;
import com.jiudian.modules.sms.entity.SysNoticeTemplateEntity;
import com.jiudian.modules.sms.service.SysNoticeTemplateService;

import java.util.HashMap;
import java.util.List;


@Service("sysNoticeTemplateService")
public class SysNoticeTemplateServiceImpl extends ServiceImpl<SysNoticeTemplateDao, SysNoticeTemplateEntity> implements SysNoticeTemplateService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysNoticeTemplateEntity> page = this.selectPage(
                new Query<SysNoticeTemplateEntity>(params).getPage(),
                new EntityWrapper<SysNoticeTemplateEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
    public List<SysNoticeTemplateEntity> queryByTemplateCodeInfo(String templateCode) {
    	Map<String,Object> map = new HashMap<>();
    	if(StringUtils.isNotBlank(templateCode)) {
    		map.put("template_code", templateCode);
    	}
    	List<SysNoticeTemplateEntity> list = baseMapper.selectByMap(map);
    	return list;
    }

}
