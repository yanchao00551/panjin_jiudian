package com.jiudian.modules.userOpinion.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;
import com.jiudian.modules.userOpinion.dao.UserOpinionDao;
import com.jiudian.modules.userOpinion.entity.UserOpinionEntity;
import com.jiudian.modules.userOpinion.service.UserOpinionService;


@Service("userOpinionService")
public class UserOpinionServiceImpl extends ServiceImpl<UserOpinionDao, UserOpinionEntity> implements UserOpinionService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserOpinionEntity> page = this.selectPage(
                new Query<UserOpinionEntity>(params).getPage(),
                new EntityWrapper<UserOpinionEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public PageUtils queryContainsUserInfo(Map<String, String> params) {
		int limit = Integer.parseInt((String)params.get("limit"));
    	int current = (Integer.parseInt((String)params.get("page")));
    	Page<UserOpinionEntity> page = new Page<UserOpinionEntity>(current,limit);
    	List<UserOpinionEntity> pageList = baseMapper.queryContainsUserInfo(page, params);
    	page.setRecords(pageList);
		return new PageUtils(page);
	}

}
