package com.jiudian.modules.member.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;
import com.jiudian.modules.app.entity.UserEntity;
import com.jiudian.modules.app.service.UserService;
import com.jiudian.modules.member.dao.MemberBalanceWithdrawDao;
import com.jiudian.modules.member.entity.MemberBalanceWithdrawEntity;
import com.jiudian.modules.member.service.MemberBalanceWithdrawService;


@Service("memberBalanceWithdrawService")
public class MemberBalanceWithdrawServiceImpl extends ServiceImpl<MemberBalanceWithdrawDao, MemberBalanceWithdrawEntity> implements MemberBalanceWithdrawService {

	@Autowired
	UserService userService;
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MemberBalanceWithdrawEntity> page = this.selectPage(
                new Query<MemberBalanceWithdrawEntity>(params).getPage(),
                new EntityWrapper<MemberBalanceWithdrawEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public PageUtils getMemberBalanceWithdraw(Map<String, Object> params) {
		int limit = Integer.parseInt((String)params.get("limit"));
    	int current = (Integer.parseInt((String)params.get("page")));
    	Page<MemberBalanceWithdrawEntity> page = new Page<MemberBalanceWithdrawEntity>(current,limit);
    	List<MemberBalanceWithdrawEntity> pageList = baseMapper.getMemberBalanceWithdraw(page,params);
    	if(!pageList.isEmpty()) {
    		for(int i = 0;i<pageList.size();i++) {
    			UserEntity userinfo = userService.selectById(pageList.get(i).getUid());
    			pageList.get(i).setUsername(userinfo.getUsername());
    			pageList.get(i).setRealname(userinfo.getNickName());
    		}
    	}
    	page.setRecords(pageList);
    	return new PageUtils(page);
	}

	@Override
	public boolean updateCashReview(Map<String, String> params) {
		return baseMapper.updateCashReview(params);
	}

	@Override
	public Integer getWithdraw(Map<String, Object> params) {
		return baseMapper.getWithdraw(params);
	}

	@Override
	public Integer getWaitWithdraw(Map<String, Object> params) {
		return baseMapper.getWaitWithdraw(params);
	}

}
