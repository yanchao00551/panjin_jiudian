package com.jiudian.modules.member.dao;

import com.jiudian.modules.member.entity.MemberPartnerEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 会员合伙人申请表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-21 15:55:35
 */
@Mapper
public interface MemberPartnerDao extends BaseMapper<MemberPartnerEntity> {

	List<MemberPartnerEntity> queryByPartnerList(Page<MemberPartnerEntity> page, Map<String, Object> params);

	
}
