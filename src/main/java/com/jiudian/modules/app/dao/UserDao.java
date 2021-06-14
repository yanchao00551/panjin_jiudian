package com.jiudian.modules.app.dao;

import com.jiudian.modules.app.entity.UserEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * 前台用户表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-26 09:40:09
 */
@Mapper
public interface UserDao extends BaseMapper<UserEntity> {
	
}
