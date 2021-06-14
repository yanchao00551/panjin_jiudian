package com.jiudian.modules.cms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.cms.dao.NcCmsArticleDao;
import com.jiudian.modules.cms.entity.NcCmsArticleEntity;
import com.jiudian.modules.cms.service.NcCmsArticleService;


@Service("ncCmsArticleService")
public class NcCmsArticleServiceImpl extends ServiceImpl<NcCmsArticleDao, NcCmsArticleEntity> implements NcCmsArticleService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NcCmsArticleEntity> page = this.selectPage(
                new Query<NcCmsArticleEntity>(params).getPage(),
                new EntityWrapper<NcCmsArticleEntity>()
        );

        return new PageUtils(page);
    }

}
