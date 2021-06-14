package com.jiudian.modules.cms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.cms.dao.NcCmsArticleClassDao;
import com.jiudian.modules.cms.entity.NcCmsArticleClassEntity;
import com.jiudian.modules.cms.service.NcCmsArticleClassService;


@Service("ncCmsArticleClassService")
public class NcCmsArticleClassServiceImpl extends ServiceImpl<NcCmsArticleClassDao, NcCmsArticleClassEntity> implements NcCmsArticleClassService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NcCmsArticleClassEntity> page = this.selectPage(
                new Query<NcCmsArticleClassEntity>(params).getPage(),
                new EntityWrapper<NcCmsArticleClassEntity>()
        );

        return new PageUtils(page);
    }

}
