package com.jiudian.modules.smsMsgRecord.dao;

import com.jiudian.modules.smsMsgRecord.entity.SmsMsgRecordEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-11-07 15:17:02
 */
@Mapper
public interface SmsMsgRecordDao extends BaseMapper<SmsMsgRecordEntity> {

	public SmsMsgRecordEntity queryNewestRecord(Map<String, String> params);
	
	public Integer querySentCount(Map<String, String> params);
}
