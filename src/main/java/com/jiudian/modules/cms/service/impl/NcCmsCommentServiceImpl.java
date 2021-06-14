package com.jiudian.modules.cms.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.cms.dao.NcCmsCommentDao;
import com.jiudian.modules.cms.entity.NcCmsCommentEntity;
import com.jiudian.modules.cms.service.NcCmsCommentService;


@Service("ncCmsCommentService")
public class NcCmsCommentServiceImpl extends ServiceImpl<NcCmsCommentDao, NcCmsCommentEntity> implements NcCmsCommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NcCmsCommentEntity> page = this.selectPage(
                new Query<NcCmsCommentEntity>(params).getPage(),
                new EntityWrapper<NcCmsCommentEntity>()
        );

        return new PageUtils(page);
    }

}
