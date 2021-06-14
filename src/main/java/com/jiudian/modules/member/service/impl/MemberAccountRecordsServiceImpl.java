package com.jiudian.modules.member.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;
import com.jiudian.modules.member.dao.MemberAccountRecordsDao;
import com.jiudian.modules.member.entity.MemberAccountRecordsEntity;
import com.jiudian.modules.member.service.MemberAccountRecordsService;


@Service("memberAccountRecordsService")
public class MemberAccountRecordsServiceImpl extends ServiceImpl<MemberAccountRecordsDao, MemberAccountRecordsEntity> implements MemberAccountRecordsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MemberAccountRecordsEntity> page = this.selectPage(
                new Query<MemberAccountRecordsEntity>(params).getPage(),
                new EntityWrapper<MemberAccountRecordsEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryDetailByUserList(Map<String,Object> params) {
    	int limit = Integer.parseInt((String)params.get("limit"));
    	int current = (Integer.parseInt((String)params.get("page")));
    	Page<MemberAccountRecordsEntity> page = new Page<MemberAccountRecordsEntity>(current,limit);
    	List<MemberAccountRecordsEntity> pageList = baseMapper.queryDetailByUserList(page,params);
    	page.setRecords(pageList);
    	return new PageUtils(page);
    }

	@Override
	public int queryTodayCount(Map<String, String> params) {
		return baseMapper.queryTodayCount(params);
	}

	@Override
	public List<MemberAccountRecordsEntity> queryTotalPoint(Map<String, String> params) {
		return baseMapper.queryTotalPoint(params);
	}

	@Override
	public BigDecimal queryUse(Map<String, Object> params) {
		return baseMapper.queryUse(params);
	}

	@Override
	public BigDecimal queryGet(Map<String, Object> params) {
		return baseMapper.queryGet(params);
	}
    
   
}
