package com.jiudian.modules.order.dao;

import com.jiudian.modules.order.entity.OrderGoodsEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 订单商品表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:36
 */
@Mapper
public interface OrderGoodsDao extends BaseMapper<OrderGoodsEntity> {
	
	public List<OrderGoodsEntity> queryOrderGoodsByOrderNo(Map<String, String> params);

	public List<OrderGoodsEntity> queryOrderGoodsInfo(Map<String, String> params);
}
