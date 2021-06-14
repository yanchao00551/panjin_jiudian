package com.jiudian.modules.rewardRecord.dao;

import com.jiudian.modules.rewardRecord.entity.RewardRecordEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-10-20 15:45:58
 */
@Mapper
public interface RewardRecordDao extends BaseMapper<RewardRecordEntity> {

	
	public RewardRecordEntity querySumGroupByFromUid(Map<String, String> params);
}
