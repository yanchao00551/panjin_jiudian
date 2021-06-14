package com.jiudian.modules.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;

import com.jiudian.modules.order.dao.OrderGoodsDao;
import com.jiudian.modules.order.entity.OrderGoodsEntity;
import com.jiudian.modules.order.service.OrderGoodsService;
import com.jiudian.modules.order.service.OrderService;


@Service("orderGoodsService")
public class OrderGoodsServiceImpl extends ServiceImpl<OrderGoodsDao, OrderGoodsEntity> implements OrderGoodsService {

	@Autowired
	OrderService orderService;
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrderGoodsEntity> page = this.selectPage(
                new Query<OrderGoodsEntity>(params).getPage(),
                new EntityWrapper<OrderGoodsEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public List<OrderGoodsEntity> getOrderGoods(Integer orderId) {
		// TODO Auto-generated method stub
		return orderService.getOrderGoods(orderId);
	}

	@Override
	public List<OrderGoodsEntity> queryOrderGoodsByOrderNo(Map<String, String> params) {
		return baseMapper.queryOrderGoodsByOrderNo(params);
	}

	@Override
	public List<OrderGoodsEntity> queryOrderGoodsInfo(Map<String, String> params) {
		return baseMapper.queryOrderGoodsInfo(params);
	}

}
