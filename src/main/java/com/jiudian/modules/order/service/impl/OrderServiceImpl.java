package com.jiudian.modules.order.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.common.exception.RRException;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;
import com.jiudian.modules.address.service.AddressService;
import com.jiudian.modules.album.entity.AlbumPictureEntity;
import com.jiudian.modules.album.service.AlbumPictureService;
import com.jiudian.modules.app.service.UserService;
import com.jiudian.modules.express.entity.ExpressCompanyEntity;
import com.jiudian.modules.express.service.ExpressCompanyService;
import com.jiudian.modules.goods.entity.GoodsAttributeEntity;
import com.jiudian.modules.goods.entity.GoodsEntity;
import com.jiudian.modules.goods.entity.GoodsSkuEntity;
import com.jiudian.modules.goods.service.GoodsAttributeService;
import com.jiudian.modules.goods.service.GoodsService;
import com.jiudian.modules.goods.service.GoodsSkuService;
import com.jiudian.modules.member.service.MemberService;
import com.jiudian.modules.order.controller.OrderStatus;
import com.jiudian.modules.order.dao.OrderDao;
import com.jiudian.modules.order.entity.GoodsPacketList;
import com.jiudian.modules.order.entity.OrderEntity;
import com.jiudian.modules.order.entity.OrderGoodsEntity;
import com.jiudian.modules.order.entity.OrderGoodsExpressEntity;
import com.jiudian.modules.order.entity.OrderGromType;
import com.jiudian.modules.order.entity.PayStatus;
import com.jiudian.modules.order.entity.ShippingStatus;
import com.jiudian.modules.order.service.OrderGoodsExpressService;
import com.jiudian.modules.order.service.OrderGoodsService;
import com.jiudian.modules.order.service.OrderService;
import com.jiudian.modules.sys.service.SysUserService;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

	@Autowired
	OrderService orderService;
	@Autowired
	OrderGoodsService orderGoodsService ;
	@Autowired
	GoodsSkuService goodsSkuService;
	@Autowired
	AlbumPictureService albumPictureService;
	@Autowired
	ExpressCompanyService expressCompanyService;
	@Autowired
	OrderGoodsExpressService orderGoodsExpressService;
	@Autowired
	MemberService memberService;
	@Autowired
	UserService userService;
	@Autowired
	SysUserService sysUserService;
	@Autowired
	GoodsService goodsService;
	@Autowired
	private GoodsAttributeService goodsAttributeService;
	@Autowired
	private AddressService addressService;
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrderEntity> page = this.selectPage(
                new Query<OrderEntity>(params).getPage(),
                new EntityWrapper<OrderEntity>()
        );

        return new PageUtils(page);
    }

	@Override
	public PageUtils getOrderList(Map<String, String> params) {
		int limit = Integer.parseInt(params.get("limit"));
    	int current = (Integer.parseInt(params.get("page")));
    	int orderType = -1;
    	if(params.containsKey("orderType")) {
    		orderType = Integer.parseInt(params.get("orderType"));
    	}
    	Page<OrderEntity> page = new Page<OrderEntity>(current,limit);
    	List<OrderEntity> pageList = baseMapper.queryByOrderList(page,params);
    	int k = 0;
    	for(OrderEntity item:pageList) {
    		//查询订单表项
    		Wrapper<OrderGoodsEntity> wrapper = new EntityWrapper<OrderGoodsEntity>().eq("order_id", item.getOrderId());
    		if(orderType != -1) {
    			wrapper.eq("order_type", orderType);
    		}
    		List<OrderGoodsEntity> orderItemList = orderGoodsService.selectList(wrapper);
    		for(int i=0;i<orderItemList.size();i++) {
                //查询商品sku结束
    			GoodsSkuEntity skuInfo = goodsSkuService.selectById(orderItemList.get(i).getSkuId());
    			if(skuInfo != null) {
    				orderItemList.get(i).setCode(skuInfo.getCode());
    			}
    			AlbumPictureEntity goodsPicture = albumPictureService.selectById(orderItemList.get(i).getGoodsPicture());
    			if(goodsPicture == null) {
    				goodsPicture = new AlbumPictureEntity();
    				goodsPicture.setUploadType(1);
    			}
    			orderItemList.get(i).setPicture(goodsPicture);
    			//订单商品详细信息
    			GoodsEntity goodsEntity = goodsService.selectOne(
    					new EntityWrapper<GoodsEntity>().eq("goods_id", orderItemList.get(i).getGoodsId()));
    			orderItemList.get(i).setGoodsEntities(goodsEntity);
    			if(orderItemList.get(i).getRefundStatus() != 0) {   //退款流程逻辑暂略
    				
    			}
    			
    			//查询是否有售后信息 暂略
    		}
    		pageList.get(k).setOrderItemList(orderItemList);
    		 // 订单来源名称
    		OrderGromType orderFrom = OrderStatus.getOrderFrom(item.getOrderFrom());
    		pageList.get(k).setOrderFromName(orderFrom.getTypeName());
    		pageList.get(k).setOrderFromTag(orderFrom.getTag());
    		pageList.get(k).setPayTypeName(OrderStatus.getPayType(item.getPaymentType()));
            // 根据订单类型判断订单相关操作 包括 货到付款订单 逻辑 暂略
    		k++;
    	}
    	page.setRecords(pageList);
    	return new PageUtils(page);
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public OrderEntity getOrderDetail(Integer orderId) {
		// TODO Auto-generated method stub
		//查询主表信息
		OrderEntity detail = this.getDetail(orderId);
		if(detail == null) {
			return null;
		}
		String addr = addressService.getAddress(detail.getReceiverProvince(), 
				detail.getReceiverCity(), detail.getReceiverDistrict());
		if(!StringUtils.isEmpty(addr)) {
			detail.setAddress(addr.replaceAll("\\|", " ") +" " + detail.getReceiverAddress());
		}
		detail.setPayStatusName(this.getPayStatusInfo(detail.getPayStatus()).getStatusName());
		detail.setShippingStatusName(this.getShippingInfo(detail.getShippingStatus()).getStatusName());
		detail.setShippingTypeName(OrderStatus.getShippingTypeName(detail.getShippingType()).getTypeName());
		
		//o2o逻辑略 
		
		List<OrderGoodsExpressEntity> expressList = this.getOrderGoodsExpressList(orderId);
		// 未发货的订单项
		List<OrderGoodsEntity> orderGoodsList = new ArrayList<OrderGoodsEntity>();
		// 已发货的订单项
		List<OrderGoodsEntity> orderGoodsDelive = new ArrayList<OrderGoodsEntity>();
		// 没有配送信息的订单项
		List<OrderGoodsEntity> orderGoodsExpress = new ArrayList<OrderGoodsEntity>();
		int maxUsePoint = 0;
		for (OrderGoodsEntity item : detail.getOrderGoods()) {
			Integer shippingStatus = item.getShippingStatus();
			GoodsEntity goodsEntity = goodsService
					.selectOne(new EntityWrapper<GoodsEntity>().eq("goods_id", item.getGoodsId()));
			item.setGoodsEntities(goodsEntity);
			maxUsePoint += item.getMaxUsePoint();
//			int attrid = item.getSkuId();
//			GoodsAttributeEntity goodsAttributeEntity = goodsAttributeService.selectOne
//					(new EntityWrapper<GoodsAttributeEntity>().eq("attr_id", attrid));
//			item.setAttrName(goodsAttributeEntity.getAttrValueName());
			if (shippingStatus == 0) {
				// 未发货
				orderGoodsList.add(item);
			} else {
				orderGoodsDelive.add(item);
			}
		}
		detail.setOrderMaxUsePoint(maxUsePoint);
		detail.setOrderGoodsNoDelive(orderGoodsList);
		// 没有配送信息的订单项
		if(!orderGoodsDelive.isEmpty() && orderGoodsDelive.size() > 0) {
			for(OrderGoodsEntity item:orderGoodsDelive) {
				boolean isHave = false;
				Integer orderGoodsId = item.getOrderGoodsId();
				for(OrderGoodsExpressEntity value:expressList) {
					String orderGoodsIdArray = value.getOrderGoodsIdArray();
					String[] goodsIdStr = orderGoodsIdArray.split(",");
					if(Arrays.asList(goodsIdStr).contains(orderGoodsId)) {
						isHave = true;
					}
				}
				if(! isHave) {
					orderGoodsExpress.add(item);
				}
			}
		}
		
		List<GoodsPacketList> goodsPacketList = new ArrayList<GoodsPacketList>();
		if(!orderGoodsExpress.isEmpty() && orderGoodsExpress.size() > 0) {
			GoodsPacketList packetObj = new GoodsPacketList();
			packetObj.setPacketName("无需物流");
			packetObj.setExpressId(0);
			packetObj.setIsExpress(0);
			packetObj.setOrderGoodsList(orderGoodsExpress);
			goodsPacketList.add(packetObj);
		}
		
		if(!expressList.isEmpty() && expressList.size() > 0 && orderGoodsDelive.size() > 0) {
			int packetNum = 1;
			List<OrderGoodsEntity> packetGoodsList = new ArrayList<OrderGoodsEntity>();
			for(OrderGoodsExpressEntity item:expressList) {
				String orderGoodsIdArray = item.getOrderGoodsIdArray();
				String[] goodsIdStr = orderGoodsIdArray.split(",");
				for(OrderGoodsEntity value:orderGoodsDelive) {
					Integer orderGoodsId = value.getOrderGoodsId();
					if(Arrays.asList(goodsIdStr).contains(orderGoodsId.toString())) {
						packetGoodsList.add(value);
					}
				}
				GoodsPacketList packetObj = new GoodsPacketList();
				packetObj.setPacketName("包裹 + " + packetNum);
				packetObj.setExpressName(item.getExpressName());
				packetObj.setExpressCode(item.getExpressNo());
				packetObj.setExpressId(item.getId());
				packetObj.setExpressCompanyId(item.getExpressCompanyId());
				packetObj.setIsExpress(1);
				packetObj.setOrderGoodsList(packetGoodsList);
				packetNum = packetNum + 1;
				goodsPacketList.add(packetObj);
			}
		}
		detail.setGoodsPacketList(goodsPacketList);
		
		// 虚拟商品列表  订单优惠类型  暂略
		return detail;
	}

	
	/**
	 * 通过订单id 得到 该订单的发货物流
	 * @param orderId
	 * @return
	 */
	private List<OrderGoodsExpressEntity> getOrderGoodsExpressList(Integer orderId) {
		// TODO Auto-generated method stub
		return orderGoodsExpressService.selectList(new EntityWrapper<OrderGoodsExpressEntity>().eq("order_id", orderId));
	}

	/**
	 * 获取具体配送状态信息
	 * @param shippingStatus
	 * @return
	 */
	private ShippingStatus getShippingInfo(Integer shippingStatus) {
		// TODO Auto-generated method stub
		List<ShippingStatus> list = OrderStatus.getShippingStatus();
		ShippingStatus info = new ShippingStatus();
		for(ShippingStatus item:list) {
			if(Integer.parseInt(item.getShippingStatus()) == shippingStatus) {
				info = item;
				break;
			}
		}
		return info; 
	}

	/**
	 * 获取具体支付状态信息
	 * @param payStatus
	 * @return
	 */
	private PayStatus getPayStatusInfo(Integer payStatus) {
		// TODO Auto-generated method stub
		List<PayStatus> list = OrderStatus.getPayStatus();
		PayStatus info = new PayStatus();
		for(PayStatus item:list) {
			if(Integer.parseInt(item.getPayStatus()) == payStatus) {
				info = item;
				break;
			}
		}
		return info;
	}

	/**
	 * 获取订单详情
	 * @param orderId
	 * @return
	 */
	private OrderEntity getDetail(Integer orderId) {
		// TODO Auto-generated method stub
		OrderEntity detail = orderService.selectOne(new EntityWrapper<OrderEntity>().eq("order_id", orderId).eq("is_deleted", 0));
		if(detail == null) {
			return null;
		}
		//发票信息
		String[] tempArray = null;
		if(!detail.getBuyerInvoice().equals("")) {
			tempArray = detail.getBuyerInvoice().split("\\$");
		}
		detail.setBuyerInvoiceInfo(tempArray);
		detail.setPaymentTypeName(OrderStatus.getPayType(detail.getPaymentType()));
		String expressCompanyName = "";
		if(detail.getShippingType() == 1) {
			detail.setShippingTypeName("商家配送");
			ExpressCompanyEntity expressObj = expressCompanyService.selectById(detail.getShippingCompanyId());
			if(expressObj != null && expressObj.getCompanyName() != null) {
				expressCompanyName = expressObj.getCompanyName();
			}
		}else if(detail.getShippingType() == 2) {
			detail.setShippingTypeName("门店自提");
		}else {
			detail.setShippingTypeName("");
		}
		detail.setShippingCompanyName(expressCompanyName);
		
		//查询订单项表
		detail.setOrderGoods(this.getOrderGoods(orderId));
		
		//预支付订单 和 自提订单 逻辑 略
		
		//查询操作项 前端实现略
		
		//订单日志略
		
		
		return detail;
	}

	/**
	 * 查询订单的订单项列表
	 * @param orderId
	 * @return
	 */
	public List<OrderGoodsEntity> getOrderGoods(Integer orderId) {
		// TODO Auto-generated method stub
		List<OrderGoodsEntity> orderGoodsList = orderGoodsService.selectList
				(new EntityWrapper<OrderGoodsEntity>().eq("order_id", orderId));
		for(int i = 0;i<orderGoodsList.size();i++) {
			orderGoodsList.get(i).setExpressInfo(this.getOrderGoodsExpress(orderGoodsList.get(i).getOrderGoodsId()));
			List<ShippingStatus> shippingStatus = OrderStatus.getShippingStatus();
			for(ShippingStatus item:shippingStatus) {
				if(orderGoodsList.get(i).getShippingStatus() == Integer.parseInt(item.getShippingStatus())) {
					orderGoodsList.get(i).setShippingStatusName(item.getStatusName());
				}
			}
			//商品图片
			AlbumPictureEntity pictureInfo = albumPictureService.selectById(orderGoodsList.get(i).getGoodsPicture());
			orderGoodsList.get(i).setPictureInfo(pictureInfo);
			if(orderGoodsList.get(i).getRefundStatus() != 0) {
				//退款逻辑暂略过
			}
			//获取商品详情
			orderGoodsList.get(i).setGoodsEntities(goodsService.selectOne(
					new EntityWrapper<GoodsEntity>().eq("goods_id", String.valueOf(orderGoodsList.get(i).getGoodsId()))));
			if(orderGoodsList.get(i).getSkuId() != 0) {
				GoodsAttributeEntity goodsAttributeEntity = goodsAttributeService.selectOne
						(new EntityWrapper<GoodsAttributeEntity>().eq("attr_id", orderGoodsList.get(i).getSkuId()));
				orderGoodsList.get(i).setGoodsAttributeEntity(goodsAttributeEntity);
			}
		}
		
		return orderGoodsList;
	}
	
	/**
	 * 获取订单项的物流信息
	 * @param orderGoodsId
	 * @return
	 */
	@SuppressWarnings("unused")
	private ExpressCompanyEntity getOrderGoodsExpress(Integer orderGoodsId) {
		// TODO Auto-generated method stub
		OrderGoodsEntity orderGoodsInfo = orderGoodsService.selectById(orderGoodsId);
		if(orderGoodsInfo.getShippingStatus() == 0) {
			return null;
		}else {
			List<OrderGoodsExpressEntity> orderExpressList = this.getOrderExpress(orderGoodsInfo.getOrderId());
			
		}
		return null;
	}

	/**
	 * 获取订单的物流信息
	 * @param orderId
	 * @return
	 */
	private List<OrderGoodsExpressEntity> getOrderExpress(Integer orderId) {
		// TODO Auto-generated method stub
		return orderGoodsExpressService.selectList(new EntityWrapper<OrderGoodsExpressEntity>().eq("order_id", orderId));
	}

	
	@SuppressWarnings("unused")
	@Override
	@Transactional
	public void orderComplete(Integer orderId) {
		// TODO Auto-generated method stub
		Integer retval = this.orderCompleteOver(orderId);
		try {
			//结算订单的分销佣金
			this.updateOrderCommission(orderId);
		}catch(RRException e){
	        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	        throw new RRException("订单完成fail!");
	    }
	}

	/**
	 * 订单完成交易进行 佣金结算
	 * @param orderId
	 */
	@SuppressWarnings("unused")
	@Transactional
	private void updateOrderCommission(Integer orderId) {
		// TODO Auto-generated method stub
		try {
			OrderEntity shopObj = orderService.selectById(orderId);
			Integer orderStatus = shopObj.getOrderStatus();
			if(orderStatus == 4 || orderStatus == -2 || orderStatus == 5) {
				// 得到订单的店铺id
				int shopId = shopObj.getShopId();
				// 得到订单用户id
				Integer uid = shopObj.getBuyerId();
				// 发放订单的三级分销佣金
				memberService.updateCommissionDistributionIssue(orderId);
			}
		}catch(RRException e){
	        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	        throw new RRException("订单完成交易进行 佣金结算fail!");
	    }
	}

	/**
	 * 执行订单交易完成
	 * @param orderId
	 * @return
	 */
	@Transactional
	private Integer orderCompleteOver(Integer orderId) {
		// TODO Auto-generated method stub
		try {
			OrderEntity entity = new OrderEntity();
			entity.setOrderStatus(4);
			entity.setFinishTime((int)(System.currentTimeMillis() / 1000));
			baseMapper.update(entity, new EntityWrapper<OrderEntity>().eq("order_id", orderId));
			//订单日志  订单完成后统计满减赠送  判断是否需要在本阶段赠送积分 暂略
			return 1;
		}catch(RRException e){
	        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	        throw new RRException("执行订单交易完成fail!");
	    }
	}

	@Override
	@Transactional
	public int orderDelivery(Integer orderId, String orderGoodsIdArray, String expressName, Integer shippingType,
			Integer expressCompanyId, String expressNo, Integer userId) {
		// TODO Auto-generated method stub
		String username =  sysUserService.selectById(userId).getUsername();
		OrderGoodsExpressEntity orderExpress = new OrderGoodsExpressEntity();
		
		try {
			int count = orderGoodsExpressService.selectCount(new EntityWrapper<OrderGoodsExpressEntity>().eq("order_goods_id_array", orderGoodsIdArray));
			if(count == 0) {
				ExpressCompanyEntity expressCompany = new ExpressCompanyEntity();
				expressCompany = expressCompanyService.selectById(expressCompanyId);
				orderExpress.setOrderId(orderId);
				orderExpress.setOrderGoodsIdArray(orderGoodsIdArray);
				orderExpress.setExpressName(expressName);
				orderExpress.setShippingType(shippingType);
				orderExpress.setExpressCompany(expressCompany.getCompanyName());
				orderExpress.setExpressCompanyId(expressCompanyId);
				orderExpress.setExpressNo(expressNo);
				orderExpress.setShippingTime((int)(System.currentTimeMillis() / 1000));
				orderExpress.setUid(userId);
				orderExpress.setUserName(username);
				orderGoodsExpressService.insert(orderExpress);
				// 循环添加到订单商品项
				orderService.orderGoodsDelivery(orderId,orderGoodsIdArray);
			}
		}catch(RRException e){
	        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	        throw new RRException("物流公司发货fail!");
	    }
		return 0;
	}

	@Override
	@Transactional
	public int orderGoodsDelivery(Integer orderId, String orderGoodsIdArray) {
		// TODO Auto-generated method stub
		try {
			String[] orderGoodsIdArr= orderGoodsIdArray.split(",");
			if(orderGoodsIdArr != null && orderGoodsIdArr.length > 0) {
				for(String item:orderGoodsIdArr) {
					Integer orderGoodsId = Integer.parseInt(item);
					OrderGoodsEntity info = new OrderGoodsEntity();
					info.setShippingStatus(1);
					boolean retval = orderGoodsService.update(info, new EntityWrapper<OrderGoodsEntity>().eq("order_goods_id", orderGoodsId));
					if(retval) {	
						return 1;
					}else {
						return -1;
					}
				}
			}
			orderService.orderDoDelivery(orderId);
			return 1;
		}catch(RRException e){
	        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	        throw new RRException("订单项发货fail!");
	    }
	}

	
	@Override
	@Transactional
	public void orderDoDelivery(Integer orderId) {
		// TODO Auto-generated method stub
		try {
			int count = orderGoodsService.selectCount(new EntityWrapper<OrderGoodsEntity>().eq("order_id", orderId).eq("shipping_status", 0).le("refund_status", 0));
			if(count == 0) {
				OrderEntity dataDelivery = new OrderEntity();
				dataDelivery.setShippingStatus(1);
				dataDelivery.setOrderStatus(2);
				dataDelivery.setCreateTime((int)(System.currentTimeMillis() / 1000));
				orderService.update(dataDelivery, new EntityWrapper<OrderEntity>().eq("order_id", orderId));
				//记录日志略
			}
		}catch(RRException e){
	        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	        throw new RRException("订单发货(整体发货)fail!");
	    }
	}

	@Override
	public BigDecimal queryPayTotal(Map<String, String> params) {
		return baseMapper.queryPayTotal(params);
	}

	@Override
	public BigDecimal queryLeftTotal(Map<String, String> params) {
		return baseMapper.queryLeftTotal(params);
	}

	@Override
	public BigDecimal queryPayPoint(Map<String, String> params) {
		return baseMapper.queryPayPoint(params);
	}

	@Override
	public BigDecimal queryLeftPoint(Map<String, String> params) {
		return baseMapper.queryLeftPoint(params);
	}

}
