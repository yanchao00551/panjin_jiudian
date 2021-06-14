package com.jiudian.modules.member.dao;

import com.jiudian.modules.member.entity.MemberEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.jiudian.modules.app.entity.UserEntity;
/**
 * 前台用户表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-26 13:10:53
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	List<UserEntity> getUserListByCondition(Map<String, Object> parameterMap);
	Integer getCountByCondition(String username);
	List<MemberEntity> queryByUserList(Page<MemberEntity> page, Map<String, Object> params);
	MemberEntity queryByUserDetail(Map<String, Object> map);
	Boolean updateByUserLevel(Map<String, Object> params);
	List<MemberEntity> queryByTeamList(Page<MemberEntity> page, Map<String, Object> params);
	MemberEntity queryTeamNum(Map<String, Object> params);
	MemberEntity queryTeamNumAmong(Map<String, Object> params);
	List<MemberEntity> queryAllTeamList(Map<String, Object> params);
	
	public List<MemberEntity> queryPartnerList(Page<MemberEntity> page, Map<String, String> params);
}
