package com.jiudian.modules.order.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.order.entity.OrderGoodsEntity;

import java.util.List;
import java.util.Map;

/**
 * 订单商品表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:36
 */
public interface OrderGoodsService extends IService<OrderGoodsEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 查询订单的订单项列表
     * @param orderId
     * @return
     */
	List<OrderGoodsEntity> getOrderGoods(Integer orderId);
	
	public List<OrderGoodsEntity> queryOrderGoodsByOrderNo(Map<String, String> params);
	
	public List<OrderGoodsEntity> queryOrderGoodsInfo(Map<String, String> params);
}

