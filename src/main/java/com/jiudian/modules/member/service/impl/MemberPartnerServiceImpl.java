package com.jiudian.modules.member.service.impl;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.member.dao.MemberPartnerDao;
import com.jiudian.modules.member.entity.MemberPartnerEntity;
import com.jiudian.modules.member.service.MemberPartnerService;


@Service("memberPartnerService")
public class MemberPartnerServiceImpl extends ServiceImpl<MemberPartnerDao, MemberPartnerEntity> implements MemberPartnerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MemberPartnerEntity> page = this.selectPage(
                new Query<MemberPartnerEntity>(params).getPage(),
                new EntityWrapper<MemberPartnerEntity>()
        );
        
        return new PageUtils(page);
    }

	@Override
	public PageUtils queryByPartnerList(Map<String, Object> params) {
		int limit = Integer.parseInt((String)params.get("limit"));
    	int current = (Integer.parseInt((String)params.get("page")));
    	Page<MemberPartnerEntity> page = new Page<MemberPartnerEntity>(current,limit);
    	params.put("page", current);
    	params.put("limit", limit);
    	List<MemberPartnerEntity> pageList = baseMapper.queryByPartnerList(page,params);
    	page.setRecords(pageList);
    	return new PageUtils(page);
	}

}
