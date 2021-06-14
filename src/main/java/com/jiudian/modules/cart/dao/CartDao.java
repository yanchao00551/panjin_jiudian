package com.jiudian.modules.cart.dao;

import com.jiudian.modules.cart.entity.CartEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 购物车表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-08-28 10:13:44
 */
@Mapper
public interface CartDao extends BaseMapper<CartEntity> {
	
}
