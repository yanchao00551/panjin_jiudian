package com.jiudian.modules.member.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.member.entity.MemberBalanceWithdrawEntity;

import java.util.Map;

/**
 * 会员余额提现记录表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-26 13:10:53
 */
public interface MemberBalanceWithdrawService extends IService<MemberBalanceWithdrawEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 会员提现列表
     * @param params
     * @return
     */
	PageUtils getMemberBalanceWithdraw(Map<String, Object> params);
	
	public boolean updateCashReview(Map<String, String> params);
	
	public Integer getWithdraw(Map<String, Object> params);
	
	public Integer getWaitWithdraw(Map<String, Object> params);
}

