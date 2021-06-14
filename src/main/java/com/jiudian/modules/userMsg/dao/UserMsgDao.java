package com.jiudian.modules.userMsg.dao;

import com.jiudian.modules.userMsg.entity.UserMsgEntity;
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
 * @date 2018-10-27 16:20:26
 */
@Mapper
public interface UserMsgDao extends BaseMapper<UserMsgEntity> {

	public List<UserMsgEntity> queryByMsgType(Page<UserMsgEntity> page,Map<String, String> params);
}
