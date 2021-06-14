package com.jiudian.modules.userMsg.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;
import com.jiudian.modules.userMsg.dao.UserMsgDao;
import com.jiudian.modules.userMsg.entity.UserMsgEntity;
import com.jiudian.modules.userMsg.service.UserMsgService;


@Service("userMsgService")
public class UserMsgServiceImpl extends ServiceImpl<UserMsgDao, UserMsgEntity> implements UserMsgService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<UserMsgEntity> page = this.selectPage(
                new Query<UserMsgEntity>(params).getPage(),
                new EntityWrapper<UserMsgEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public PageUtils queryByMsgType(Map<String, String> params) {
		int current = Integer.parseInt(params.get("page"));
		int limit = Integer.parseInt(params.get("limit"));
		Page<UserMsgEntity> page = new Page<UserMsgEntity>(current, limit);
		List<UserMsgEntity> pageList = baseMapper.queryByMsgType(page, params);
		page.setRecords(pageList);
		return new PageUtils(page);
	}

}
