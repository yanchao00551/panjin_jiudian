package com.jiudian.modules.order.dao;

import com.jiudian.modules.order.entity.OrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 订单表
 * 
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:36
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {

	List<OrderEntity> queryByOrderList(Page<OrderEntity> page, Map<String, String> params);
	
	BigDecimal queryPayTotal(Map<String, String> params);
	
	BigDecimal queryLeftTotal(Map<String, String> params);
	
	BigDecimal queryPayPoint(Map<String, String> params);
	
	BigDecimal queryLeftPoint(Map<String, String> params);
	
}
