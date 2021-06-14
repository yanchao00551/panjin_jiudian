package com.jiudian.modules.weixin.dao;

import com.jiudian.modules.weixin.entity.SysWeixinAuthEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 店铺(实例)微信公众账号授权
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-15 09:23:07
 */
@Mapper
public interface SysWeixinAuthDao extends BaseMapper<SysWeixinAuthEntity> {
	
}
