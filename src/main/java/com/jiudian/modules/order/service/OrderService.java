package com.jiudian.modules.order.service;

import com.baomidou.mybatisplus.service.IService;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.modules.order.entity.OrderEntity;
import com.jiudian.modules.order.entity.OrderGoodsEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 订单表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:36
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);

    /**
     * 获取订单列表
     * @param params
     * @return
     */
	PageUtils getOrderList(Map<String, String> params);
	
	BigDecimal queryPayTotal(Map<String, String> params);
	
	BigDecimal queryLeftTotal(Map<String, String> params);
	
	BigDecimal queryPayPoint(Map<String, String> params);
	
	BigDecimal queryLeftPoint(Map<String, String> params);

	/**
	 * 获取订单详情
	 * @param params
	 * @return
	 */
	OrderEntity getOrderDetail(Integer orderId);
	
	/**
	 * 查询订单的订单项列表
	 * @param orderId
	 * @return
	 */
	List<OrderGoodsEntity> getOrderGoods(Integer orderId);

	/**
	 * 订单完成的函数
	 * @param orderId
	 */
	void orderComplete(Integer orderId);

	/**
	 * 物流公司发货
	 * @param orderId
	 * @param orderGoodsIdArray  订单项数组
	 * @param expressName 包裹名称
	 * @param shippingType  发货方式1 需要物流 0无需物流
	 * @param expressCompanyId  物流公司ID 
	 * @param expressNo 物流单号
	 * @param userId 
	 * @return
	 */
	int orderDelivery(Integer orderId, String orderGoodsIdArray, String expressName, Integer shippingType,
			Integer expressCompanyId, String expressNo, Integer userId);

	/**
	 * 订单项发货
	 * @param orderId
	 * @param orderGoodsIdArray    ','隔开
	 * @return
	 */
	int orderGoodsDelivery(Integer orderId, String orderGoodsIdArray);

	/**
	 * 订单发货(整体发货)(不考虑订单项)
	 * @param orderId
	 */
	void orderDoDelivery(Integer orderId);


}

