package com.jiudian.modules.sms.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.sms.dao.SysNoticeTemplateItemDao;
import com.jiudian.modules.sms.entity.SysNoticeTemplateItemEntity;
import com.jiudian.modules.sms.service.SysNoticeTemplateItemService;
import java.util.List;

@Service("sysNoticeTemplateItemService")
public class SysNoticeTemplateItemServiceImpl extends ServiceImpl<SysNoticeTemplateItemDao, SysNoticeTemplateItemEntity> implements SysNoticeTemplateItemService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<SysNoticeTemplateItemEntity> page = this.selectPage(
                new Query<SysNoticeTemplateItemEntity>(params).getPage(),
                new EntityWrapper<SysNoticeTemplateItemEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
    public List<SysNoticeTemplateItemEntity> queryByTemplateCodeInfo(String templateCode) {
    	if(StringUtils.isNotBlank(templateCode)) {
    		return baseMapper.queryByTemplateCodeInfo(templateCode);
    	}
    	return null;
    }

}
