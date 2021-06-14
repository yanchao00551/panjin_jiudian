package com.jiudian.modules.member.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.member.entity.MemberAccountRecordsEntity;
/**
 * 会员流水账表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-26 13:10:53
 */
public interface MemberAccountRecordsService extends IService<MemberAccountRecordsEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
    /**
     * 分页查询会员详情流水记录
     * @param params
     * @return
     */
    PageUtils queryDetailByUserList(Map<String,Object> params);

    public int queryTodayCount(Map<String, String> params);
    
    public List<MemberAccountRecordsEntity> queryTotalPoint(Map<String, String> params);
    
	public BigDecimal queryUse(Map<String, Object> params);
	
	public BigDecimal queryGet(Map<String, Object> params);
}

