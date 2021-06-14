package com.jiudian.modules.member.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.jiudian.modules.member.entity.MemberAccountRecordsEntity;

/**
 * 会员流水账表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-26 13:10:53
 */
@Mapper
public interface MemberAccountRecordsDao extends BaseMapper<MemberAccountRecordsEntity> {

	List<MemberAccountRecordsEntity> queryDetailByUserList(Page<MemberAccountRecordsEntity> page, Map<String, Object> params);
	
	public int queryTodayCount(Map<String, String> params);

	public List<MemberAccountRecordsEntity> queryTotalPoint(Map<String, String> params);
	
	public BigDecimal queryUse(Map<String, Object> params);
	
	public BigDecimal queryGet(Map<String, Object> params);
}
