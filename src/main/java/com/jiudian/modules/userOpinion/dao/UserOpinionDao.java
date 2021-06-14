package com.jiudian.modules.userOpinion.dao;

import com.jiudian.modules.userOpinion.entity.UserOpinionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author congmzh
 * @email cmz0609@126.com
 * @date 2018-10-27 14:44:06
 */
@Mapper
public interface UserOpinionDao extends BaseMapper<UserOpinionEntity> {

	public List<UserOpinionEntity> queryContainsUserInfo(Page<UserOpinionEntity> page, Map<String, String> params);
}
