package com.jiudian.modules.cms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.cms.dao.NcCmsTopicDao;
import com.jiudian.modules.cms.entity.NcCmsTopicEntity;
import com.jiudian.modules.cms.service.NcCmsTopicService;


@Service("ncCmsTopicService")
public class NcCmsTopicServiceImpl extends ServiceImpl<NcCmsTopicDao, NcCmsTopicEntity> implements NcCmsTopicService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NcCmsTopicEntity> page = this.selectPage(
                new Query<NcCmsTopicEntity>(params).getPage(),
                new EntityWrapper<NcCmsTopicEntity>()
        );

        return new PageUtils(page);
    }

}
