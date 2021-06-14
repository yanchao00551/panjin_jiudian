package com.jiudian.modules.order.dao;

import com.jiudian.modules.order.entity.OrderRefundEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单商品退货退款操作表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:37
 */
@Mapper
public interface OrderRefundDao extends BaseMapper<OrderRefundEntity> {
	
}
