package com.jiudian.modules.order.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.R;
import com.jiudian.modules.address.service.AddressService;
import com.jiudian.modules.express.entity.ExpressCompanyEntity;
import com.jiudian.modules.express.service.ExpressCompanyService;
import com.jiudian.modules.order.entity.OrderEntity;
import com.jiudian.modules.order.entity.OrderGoodsEntity;
import com.jiudian.modules.order.form.OrderDeliveryForm;
import com.jiudian.modules.order.service.OrderGoodsService;
import com.jiudian.modules.order.service.OrderService;
import com.jiudian.modules.sys.controller.AbstractController;



/**
 * 订单表
 *
 * @author yanchao
 * @email 7631990@qq.com
 * @date 2018-07-20 14:48:36
 */
@RestController
@RequestMapping("order/order")
public class OrderController extends AbstractController{
    @Autowired
    private OrderService orderService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private ExpressCompanyService expressCompanyService;
    @Autowired
    private OrderGoodsService orderGoodsService;
//    @Autowired
//	private StarService starService;
    
    private Integer instance_id;
    
    public OrderController() {
    	this.instance_id = 0;
    }
    
    /**
     * 订单列表
     * @throws ParseException 
     */
	@RequestMapping("/orderList")
    @RequiresPermissions("order:order:orderList")
    public R orderList(@RequestParam Map<String,String> params) throws ParseException
    {
    	if(params.containsKey("startDatetime")) {
    		String startDatetime = params.get("startDatetime").toString();
    		SimpleDateFormat startDateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		long startDate = startDateformat.parse(startDatetime).getTime()/ 1000;
    		params.put("startDatetime", String.valueOf(startDate));
    	}
    	if(params.containsKey("endDatetime")) {
    		String endDatetime = params.get("endDatetime").toString();
    		SimpleDateFormat endDateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		long endDate = endDateformat.parse(endDatetime).getTime()/ 1000;
    		params.put("endDatetime", String.valueOf(endDate));
    	}
    	String orderStatus = params.get("orderStatus");
    	if(orderStatus != null) {
    		if(orderStatus.equals("1")) {   // order_status 1 待发货
    			// 订单状态为待发货实际为已经支付未完成还未发货的订单
    			params.put("orderStatus1", "1");
    			params.put("shippingStatus", "0");   	// 0 待发货
    			params.put("payStatus", "2");   //已支付
    		}else {
    			params.put("orderStatus2",orderStatus);
    		}
    	}
    	params.put("isDeleted", "0,1");
    	params.put("shopId", this.instance_id.toString());
    	PageUtils result = orderService.getOrderList(params);
//    	List<OrderEntity> orderEntities = (List<OrderEntity>) result.getList();
//		orderEntities.forEach(oe -> {
//			StarEntity starEntity = starService.selectOne
//					(new EntityWrapper<StarEntity>().eq("star_id", oe.getKeyId()));
//			oe.setStar(starEntity);
//		});
//		result.setList(orderEntities);
    	BigDecimal orderPayMoney = orderService.queryPayTotal(params);
    	BigDecimal orderLeftMoney = orderService.queryLeftTotal(params);
    	BigDecimal orderPayPoint = orderService.queryPayPoint(params);
    	BigDecimal orderLeftPoint = orderService.queryLeftPoint(params);
    	return R.ok().put("page", result).put("orderPayMoney", orderPayMoney)
    			.put("orderLeftMoney", orderLeftMoney).put("orderPayPoint", orderPayPoint).put("orderLeftPoint", orderLeftPoint);
    }
    
    /**
     * 订单详情
     */
    @RequestMapping("/orderDetail")
    @RequiresPermissions("order:order:orderDetail")
    public R orderDetail(@RequestParam Map<String,String> params) {
    	String orderId = params.get("orderId");
    	if(orderId == null) {
    		return R.error("没有获取到订单信息");
    	}
    	OrderEntity detail = orderService.getOrderDetail(Integer.parseInt(orderId));
    	if(detail == null) {
    		return R.error("没有获取到订单信息");
    	}
    	return R.ok().put("order", detail);
    }
    
    @RequestMapping("/changeStatus")
    public R changeStatus(@RequestParam Map<String,String> params) {
    	String orderId = params.get("orderId");
    	if(orderId == null) {
    		return R.error("没有获取到订单信息");
    	}
    	OrderEntity detail = orderService.getOrderDetail(Integer.parseInt(orderId));
    	if(detail == null) {
    		return R.error("没有获取到订单信息");
    	}
    	detail.setOrderStatus(6);
    	boolean res = orderService.updateById(detail);
    	return res? R.ok() : R.error("操作失败");
    }
    
    /**
     * 订单发货所需要的数据
     */
    @RequestMapping("/orderDeliveryData")
    public R orderDeliveryData(@RequestBody OrderEntity form) {
    	Integer orderId = form.getOrderId();
    	OrderEntity orderInfo = orderService.getOrderDetail(orderId);
    	orderInfo.setAddress(addressService.getAddress(orderInfo.getReceiverProvince(), 
    			orderInfo.getReceiverCity(), orderInfo.getReceiverDistrict()));
    	int shopId = this.instance_id;
    	// 快递公司列表
    	List<ExpressCompanyEntity> expressCompanyList = expressCompanyService.selectList
    			(new EntityWrapper<ExpressCompanyEntity>().eq("shop_id", shopId));
    	// 订单商品项
    	List<OrderGoodsEntity> orderGoodsList = orderGoodsService.getOrderGoods(orderId);
    	Map<String,Object> data = new HashMap<String,Object>();
    	data.put("orderInfo", orderInfo);
    	data.put("expressCompanyList", expressCompanyList);
    	data.put("orderGoodsList", orderGoodsList);
    	return R.ok(data);
    }
    
    /**
     * 订单完成
     */
    @RequestMapping("/orderComplete")
    public R orderComplete(@RequestBody OrderEntity form) {
    	Integer orderId = form.getOrderId();
    	orderService.orderComplete(orderId);
    	return R.ok();
    }
    

	@RequestMapping("/orderRefund")
	public R orderRefund(@RequestParam Map<String, String> params) {
		String orderId = params.get("orderId");
		String refundReason = params.get("refundReason");
		OrderEntity orderEntity = orderService.selectById(orderId);
		orderEntity.setOrderStatus(8);
		orderEntity.setRefundReason(refundReason);
		orderService.updateById(orderEntity);
		return R.ok();
	}

    /**
     * 订单发货
     */
    @RequestMapping("/orderDelivery")
    public R orderDelivery(@RequestBody OrderDeliveryForm form) {
    	Integer orderId  = form.getOrderId();
    	String orderGoodsIdArray = form.getOrderGoodsIdArray();
    	String expressName = form.getExpressName();
    	Integer shippingType = form.getShippingType();
    	Integer expressCompanyId = form.getExpressCompanyId();
    	String expressNo = form.getExpressNo();
    	Integer userId = this.getUserId().intValue();
    	if(shippingType == 1) {
    		orderService.orderDelivery(orderId,orderGoodsIdArray,expressName,shippingType,expressCompanyId,expressNo,userId);
    	}else {
    		orderService.orderGoodsDelivery(orderId,orderGoodsIdArray);
    	}
    	
    	return R.ok();
    }

    
    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("order:order:list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = orderService.queryPage(params);

        return R.ok().put("page", page);
    }
    


    /**
     * 信息
     */
    @RequestMapping("/info/{orderId}")
    @RequiresPermissions("order:order:info")
    public R info(@PathVariable("orderId") Integer orderId){
			OrderEntity order = orderService.selectById(orderId);

        return R.ok().put("order", order);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("order:order:save")
    public R save(@RequestBody OrderEntity order){
			orderService.insert(order);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("order:order:update")
    public R update(@RequestBody OrderEntity order){
			orderService.updateById(order);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("order:order:delete")
    public R delete(@RequestBody Integer[] orderIds){
			orderService.deleteBatchIds(Arrays.asList(orderIds));

        return R.ok();
    }

}
