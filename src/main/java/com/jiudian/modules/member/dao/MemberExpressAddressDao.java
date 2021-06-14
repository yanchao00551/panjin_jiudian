package com.jiudian.modules.member.dao;

import com.jiudian.modules.member.entity.MemberExpressAddressEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 会员收货地址管理
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-06-26 13:10:53
 */
@Mapper
public interface MemberExpressAddressDao extends BaseMapper<MemberExpressAddressEntity> {
	
	public void updateIsDefault(Map<String, String> params);
}
