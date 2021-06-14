package com.jiudian.modules.member.dao;

import com.jiudian.modules.member.entity.MemberFavoritesEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 收藏表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-26 13:10:53
 */
@Mapper
public interface MemberFavoritesDao extends BaseMapper<MemberFavoritesEntity> {
	
}
