package com.jiudian.modules.member.dao;

import com.jiudian.modules.member.entity.MemberBalanceWithdrawEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 会员余额提现记录表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-26 13:10:53
 */
@Mapper
public interface MemberBalanceWithdrawDao extends BaseMapper<MemberBalanceWithdrawEntity> {

	List<MemberBalanceWithdrawEntity> getMemberBalanceWithdraw(Page<MemberBalanceWithdrawEntity> page,
			Map<String, Object> params);

	public boolean updateCashReview(Map<String, String> params);
	
	public Integer getWithdraw(Map<String, Object> params);
	
	public Integer getWaitWithdraw(Map<String, Object> params);
}
