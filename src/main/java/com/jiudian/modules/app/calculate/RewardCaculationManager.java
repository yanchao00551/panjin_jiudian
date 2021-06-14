package com.jiudian.modules.app.calculate;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.Semaphore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jiudian.StartUpRunner;
import com.jiudian.common.exception.RRException;
import com.jiudian.common.utils.Constant;
import com.jiudian.modules.balance.entity.BalanceCofigEntity;
import com.jiudian.modules.balance.service.BalanceCofigService;
import com.jiudian.modules.goods.entity.GoodsEntity;
import com.jiudian.modules.goods.service.GoodsService;
import com.jiudian.modules.member.entity.MemberAccountEntity;
import com.jiudian.modules.member.entity.MemberAccountRecordsEntity;
import com.jiudian.modules.member.entity.MemberEntity;
import com.jiudian.modules.member.service.MemberAccountRecordsService;
import com.jiudian.modules.member.service.MemberAccountService;
import com.jiudian.modules.member.service.MemberService;
import com.jiudian.modules.order.entity.OrderEntity;
import com.jiudian.modules.order.entity.OrderGoodsEntity;
import com.jiudian.modules.order.service.OrderGoodsService;
import com.jiudian.modules.order.service.OrderService;
import com.jiudian.modules.rebate.entity.RebateEntity;
import com.jiudian.modules.rebate.service.RebateService;
import com.jiudian.modules.rewardRecord.entity.RewardRecordEntity;
import com.jiudian.modules.rewardRecord.service.RewardRecordService;

@Service("RewardCaculationManager")
@Scope(value = "prototype")
public class RewardCaculationManager {
	
	@Autowired
	private OrderGoodsService orderGoodsService;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private RebateService rebateService;
	
	@Autowired
	private RewardCalcuUtil rewardCalcuUtil;
	
	@Autowired
	private MemberAccountService memberAccountService;
	
	@Autowired
	private RewardRecordService rewardRecordService;
	
	@Autowired
	private MemberAccountRecordsService memberAccountRecordsService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private GoodsService goodsService;
	
	@Autowired
	private BalanceCofigService balanceCofigService;
	
	private Semaphore semaphore = new Semaphore(0);
	
	public void calcuPush(String orderNo,double cost, boolean outPay) {
		OrderEntity orderEntity = orderService.selectOne(new EntityWrapper<OrderEntity>().eq("order_no", orderNo));
		//暂定！！！积分和余额一起计算返利
		cost = orderEntity.getOrderMoney().doubleValue();
		orderEntity.setOrderStatus(2);//已付款/待收货
		orderService.insertOrUpdate(orderEntity);
		int usePoint = orderEntity.getPoint();
		if(outPay) {
			Runnable runnable = () -> {
				boolean res = false;
				Semaphore innerphore = new Semaphore(0);
				Vector<String> uidVector = new Vector<String>();
				RewardCalcuTask rewardCalcuTask = new RewardCalcuTask(String.valueOf(orderEntity.getBuyerId()), -usePoint,
						memberAccountService, innerphore, uidVector);
				StartUpRunner.executor.getQueue().offer(rewardCalcuTask);
				try {
					innerphore.acquire();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if (uidVector.size() > 0 && uidVector.get(0).equals(String.valueOf(orderEntity.getBuyerId()))) {
					res = true;
				} else {
					throw new RRException("支付失败");
				}
				if (res && usePoint != 0) {
					MemberAccountRecordsEntity accountRecordsEntity = new MemberAccountRecordsEntity();
					accountRecordsEntity.setUid(orderEntity.getBuyerId());
					accountRecordsEntity.setShopId(0);
					accountRecordsEntity.setAccountType(1);
					accountRecordsEntity.setSign(1);
					accountRecordsEntity.setNumber(new BigDecimal(usePoint).negate());
					accountRecordsEntity.setFromType(14);
					accountRecordsEntity.setDataId(0);
					accountRecordsEntity.setText("酒店订单积分抵扣|订单号：" + orderEntity.getOrderNo());
					accountRecordsEntity.setIsFreeze(0);
					Date date = Calendar.getInstance().getTime();
					accountRecordsEntity.setCreateTime(date);
					res = memberAccountRecordsService.insert(accountRecordsEntity);
				}
				if (!res) {
					throw new RRException("支付失败");
				}
			};
			new Thread(runnable).start();
		}
		Map<String,Double> rewardMap = calcuByLevel(orderEntity.getBuyerId(), cost);
		if(rewardMap == null || rewardMap.size() == 0) {
			return;
		}
		Vector<String> uidVector = new Vector<String>();
		rewardMap.keySet().forEach(k -> {
			RewardCalcuTask rewardCalcuTask = new RewardCalcuTask(k, rewardMap.get(k), memberAccountService, 
					semaphore, uidVector);
			StartUpRunner.executor.getQueue().offer(rewardCalcuTask);
		});
		int i = 0;
		while(true) {
			try {
				semaphore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
			if(uidVector.size() > 0) {
				RewardRecordEntity rewardRecordEntity = new RewardRecordEntity();
				rewardRecordEntity.setFromUid(orderEntity.getBuyerId());
				rewardRecordEntity.setToUid(Integer.parseInt(uidVector.get(i - 1)));
				rewardRecordEntity.setValue((int)Math.floor(rewardMap.get(uidVector.get(i - 1))));
				rewardRecordService.insert(rewardRecordEntity);
				updateUserPointRecord(orderEntity.getBuyerId(), Integer.parseInt(uidVector.get(i - 1)), 
						Math.floor(rewardMap.get(uidVector.get(i - 1))),orderEntity.getBuyerId(), orderNo, 
						uidVector.get(i - 1));
			}
			if(i == rewardMap.size()) {
				break;
			}
		}
	}
	
	//返润计算
	private Map<String,Double> calcuByLevel(int uid,double cost) {
		MemberEntity selfEntity = memberService.selectOne(new EntityWrapper<MemberEntity>().eq("uid", uid));
		int level = rewardCalcuUtil.getCurrentLevel(uid, String.valueOf(selfEntity.getPid()));
		Map<String,Double> rewardMap = new HashMap<String,Double>();
		MemberEntity parentEntity = memberService.selectOne(new EntityWrapper<MemberEntity>().eq("uid", selfEntity.getPid()));
		switch (level) {
		case 1:
		case 4:
			break;
		case 2:
			if(parentEntity != null) {
				RebateEntity rebateEntity = rebateService.selectOne
						(new EntityWrapper<RebateEntity>().eq("rkey", Constant.LEVEL2TOLEVEL1));
				if(rebateEntity != null) {
					int percent = Integer.parseInt(rebateEntity.getRvalue());
					double reward = cost * percent / 100;
					rewardMap.put(String.valueOf(parentEntity.getUid()), reward);
				}
			}
			break;
		case 3:
			if(parentEntity != null) {
				RebateEntity rebateEntity = rebateService.selectOne
						(new EntityWrapper<RebateEntity>().eq("rkey", Constant.LEVEL3TOLEVEL2));
				if(rebateEntity != null) {
					int percent = Integer.parseInt(rebateEntity.getRvalue());
					double reward = cost * percent / 100;
					rewardMap.put(String.valueOf(parentEntity.getUid()), reward);
				}
				MemberEntity grandParentEntity = memberService.selectOne
						(new EntityWrapper<MemberEntity>().eq("uid", parentEntity.getPid()));
				RebateEntity rebateEntity2 = rebateService.selectOne
						(new EntityWrapper<RebateEntity>().eq("rkey", Constant.LEVEL3TOLEVEL1));
				if(rebateEntity2 != null) {
					int percent = Integer.parseInt(rebateEntity2.getRvalue());
					double reward = cost * percent / 100;
					rewardMap.put(String.valueOf(grandParentEntity.getUid()), reward);
				}
			}
			break;
		default:
			break;
		}
		
		return rewardMap;
	}

	//交易记录更新
	private void updateUserPointRecord(int buyerId,Integer userId,double reward, int fromUid, String orderNo, String toUid) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("orderNo", orderNo);
		List<OrderGoodsEntity> orderGoodsEntities = orderGoodsService.queryOrderGoodsByOrderNo(params);
		BalanceCofigEntity balanceConfigInfo = balanceCofigService.selectById(1);
		if (balanceConfigInfo == null || balanceConfigInfo.getConvertRate().compareTo(new BigDecimal(0)) == 0) {
			return;
		}
		orderGoodsEntities.forEach(ogEntity ->{
			Map<String, Double> rMap = calcuByLevel(buyerId, ogEntity.getPrice().doubleValue());
			GoodsEntity goodsEntity = goodsService.selectOne
					(new EntityWrapper<GoodsEntity>().eq("goods_id", ogEntity.getGoodsId()));
			MemberAccountRecordsEntity accountRecordsEntity = new MemberAccountRecordsEntity();
			accountRecordsEntity.setUid(Integer.parseInt(toUid));
			accountRecordsEntity.setShopId(0);
			accountRecordsEntity.setAccountType(1);
			accountRecordsEntity.setSign(1);
			accountRecordsEntity.setNumber(new BigDecimal((int) Math.floor(rMap.get(toUid))));//向下取整
			accountRecordsEntity.setFromType(12);
			accountRecordsEntity.setDataId(0);
			accountRecordsEntity.setText("返佣|订单号：" + orderNo);
			accountRecordsEntity.setIsFreeze(0);
			accountRecordsEntity.setFromUid(fromUid);
			accountRecordsEntity.setGroupId(Integer.parseInt(goodsEntity.getGroupIdArray()));
			Date date = Calendar.getInstance().getTime();
			accountRecordsEntity.setCreateTime(date);
			memberAccountRecordsService.insert(accountRecordsEntity);
		});
	}
	
	@Transactional
	public boolean updateRecordByRecharge(String orderNo,String money) {
		OrderEntity orderEntity = orderService.selectOne(new EntityWrapper<OrderEntity>().eq("order_no", orderNo));
		MemberAccountEntity memberAccountEntity = memberAccountService.selectOne
				(new EntityWrapper<MemberAccountEntity>().eq("uid", orderEntity.getBuyerId()));
		BigDecimal balance = memberAccountEntity.getBalance();
		balance = balance.add(new BigDecimal(money));
		memberAccountEntity.setBalance(balance);
		boolean res = memberAccountService.insertOrUpdate(memberAccountEntity);
//		BalanceCofigEntity balanceConfigInfo = balanceCofigService.selectById(1);
//		if (balanceConfigInfo == null || balanceConfigInfo.getConvertRate().compareTo(new BigDecimal(0)) == 0) {
//			return false;
//		}
		if(res) {
			MemberAccountRecordsEntity accountRecordsEntity = new MemberAccountRecordsEntity();
			accountRecordsEntity.setUid(orderEntity.getBuyerId());
			accountRecordsEntity.setShopId(0);
			accountRecordsEntity.setAccountType(2);
			accountRecordsEntity.setSign(1);
			accountRecordsEntity.setNumber(new BigDecimal(money));
			accountRecordsEntity.setFromType(4);
			accountRecordsEntity.setDataId(0);
			accountRecordsEntity.setText("充值|订单号：" + orderNo);
			accountRecordsEntity.setIsFreeze(0);
//			accountRecordsEntity.setFromUid(fromUid);
//			accountRecordsEntity.setGroupId(Integer.parseInt(goodsEntity.getGroupIdArray()));
			Date date = Calendar.getInstance().getTime();
			accountRecordsEntity.setCreateTime(date);
			res = memberAccountRecordsService.insert(accountRecordsEntity);
		}else {
			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
		}
		return res;
	}
	
	@Transactional
	public boolean updateRecordByHotel(String orderNo,String money,String type) {
		boolean res = false;
		OrderEntity orderEntity = orderService.selectOne(new EntityWrapper<OrderEntity>().eq("order_no", orderNo));
//		MemberAccountEntity memberAccountEntity = memberAccountService.selectOne
//				(new EntityWrapper<MemberAccountEntity>().eq("uid", orderEntity.getBuyerId()));
//		BigDecimal balance = memberAccountEntity.getBalance();
//		balance = balance.add(new BigDecimal(money));
//		memberAccountEntity.setBalance(balance);
//		boolean res = memberAccountService.insertOrUpdate(memberAccountEntity);
//		BalanceCofigEntity balanceConfigInfo = balanceCofigService.selectById(1);
//		if (balanceConfigInfo == null || balanceConfigInfo.getConvertRate().compareTo(new BigDecimal(0)) == 0) {
//			return false;
//		}
//		if(res) {
			MemberAccountRecordsEntity accountRecordsEntity = new MemberAccountRecordsEntity();
			accountRecordsEntity.setUid(orderEntity.getBuyerId());
			accountRecordsEntity.setShopId(0);
			accountRecordsEntity.setAccountType(2);
			accountRecordsEntity.setSign(1);
			accountRecordsEntity.setNumber(new BigDecimal(money).negate());
			accountRecordsEntity.setFromType(14);
			accountRecordsEntity.setDataId(0);
			accountRecordsEntity.setText(type + "支付|"+ "酒店订单|订单号：" + orderEntity.getOrderNo());
			accountRecordsEntity.setIsFreeze(0);
//			accountRecordsEntity.setFromUid(fromUid);
//			accountRecordsEntity.setGroupId(Integer.parseInt(goodsEntity.getGroupIdArray()));
			Date date = Calendar.getInstance().getTime();
			accountRecordsEntity.setCreateTime(date);
			res = memberAccountRecordsService.insert(accountRecordsEntity);
//		}else {
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//		}
		return res;
	}
	
}
