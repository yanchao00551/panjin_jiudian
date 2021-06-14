package com.jiudian.modules.order.dao;

import com.jiudian.modules.order.entity.OrderPickupEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单自提点管理
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:54:29
 */
@Mapper
public interface OrderPickupDao extends BaseMapper<OrderPickupEntity> {
	
}
