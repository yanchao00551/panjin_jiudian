package com.jiudian.modules.order.dao;

import com.jiudian.modules.order.entity.OrderPaymentEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单支付表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-02 15:13:28
 */
@Mapper
public interface OrderPaymentDao extends BaseMapper<OrderPaymentEntity> {
	
}
