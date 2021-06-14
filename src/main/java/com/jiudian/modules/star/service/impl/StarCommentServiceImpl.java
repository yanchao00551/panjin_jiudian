package com.jiudian.modules.star.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.star.dao.StarCommentDao;
import com.jiudian.modules.star.entity.StarCommentEntity;
import com.jiudian.modules.star.service.StarCommentService;


@Service("starCommentService")
public class StarCommentServiceImpl extends ServiceImpl<StarCommentDao, StarCommentEntity> implements StarCommentService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<StarCommentEntity> page = this.selectPage(
                new Query<StarCommentEntity>(params).getPage(),
                new EntityWrapper<StarCommentEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public List<StarCommentEntity> queryStarComment(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return baseMapper.queryStarComment(params);
	}

}
