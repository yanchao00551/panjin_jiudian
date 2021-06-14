package com.jiudian.modules.weixin.dao;

import com.jiudian.modules.weixin.entity.SysWeixinUserMsgReplayEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 微信用户消息回复表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:22:58
 */
@Mapper
public interface SysWeixinUserMsgReplayDao extends BaseMapper<SysWeixinUserMsgReplayEntity> {
	
}
