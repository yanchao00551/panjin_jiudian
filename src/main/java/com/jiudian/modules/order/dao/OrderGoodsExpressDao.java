package com.jiudian.modules.order.dao;

import com.jiudian.modules.order.entity.OrderGoodsExpressEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品订单物流信息表（多次发货）
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-02 15:13:19
 */
@Mapper
public interface OrderGoodsExpressDao extends BaseMapper<OrderGoodsExpressEntity> {
	
}
