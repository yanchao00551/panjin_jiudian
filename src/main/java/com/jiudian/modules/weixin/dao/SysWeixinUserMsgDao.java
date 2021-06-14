package com.jiudian.modules.weixin.dao;

import com.jiudian.modules.weixin.entity.SysWeixinUserMsgEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 微信用户消息表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
@Mapper
public interface SysWeixinUserMsgDao extends BaseMapper<SysWeixinUserMsgEntity> {
	
}
