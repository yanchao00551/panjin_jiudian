package com.jiudian.modules.member.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.Semaphore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jiudian.StartUpRunner;
import com.jiudian.common.utils.ErrorMsg;
import com.jiudian.common.utils.PageUtils;
import com.jiudian.common.utils.Query;
import com.jiudian.modules.app.calculate.RewardCalcuTask;
import com.jiudian.modules.app.config.PayConfig;
import com.jiudian.modules.member.dao.MemberAccountDao;
import com.jiudian.modules.member.entity.MemberAccountEntity;
import com.jiudian.modules.member.entity.MemberAccountRecordsEntity;
import com.jiudian.modules.member.form.MemberAccountRecordsTypeNameList;
import com.jiudian.modules.member.service.MemberAccountRecordsService;
import com.jiudian.modules.member.service.MemberAccountService;


@Service("memberAccountService")
public class MemberAccountServiceImpl extends ServiceImpl<MemberAccountDao, MemberAccountEntity> implements MemberAccountService {

	@Autowired
	MemberAccountRecordsService memberAccountRecordsService;
	@Autowired
	private MemberAccountService memberAccountService;
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MemberAccountEntity> page = this.selectPage(
                new Query<MemberAccountEntity>(params).getPage(),
                new EntityWrapper<MemberAccountEntity>()
        );

        return new PageUtils(page);
    }
    
    @Override
    public  List<MemberAccountRecordsTypeNameList> getMemberAccountRecordsTypeNameList(){
    	List<MemberAccountRecordsTypeNameList> list = new ArrayList<MemberAccountRecordsTypeNameList>();
    	list.add(new MemberAccountRecordsTypeNameList(1,"积分"));
    	list.add(new MemberAccountRecordsTypeNameList(2,"余额"));
//    	list.add(new MemberAccountRecordsTypeNameList(3,"购物币"));
    	return list;
    }
    
    
    @Override
    public List<MemberAccountRecordsTypeNameList> getMemberAccountRecordsNameList(){
    	List<MemberAccountRecordsTypeNameList> list = new ArrayList<MemberAccountRecordsTypeNameList>();
    	list.add(new MemberAccountRecordsTypeNameList(1,"商城订单"));
//    	list.add(new MemberAccountRecordsTypeNameList(2,"订单退还"));
    	list.add(new MemberAccountRecordsTypeNameList(3,"兑换"));
    	list.add(new MemberAccountRecordsTypeNameList(4,"充值"));
//    	list.add(new MemberAccountRecordsTypeNameList(5,"签到"));
//    	list.add(new MemberAccountRecordsTypeNameList(6,"分享"));
//    	list.add(new MemberAccountRecordsTypeNameList(7,"注册"));
    	list.add(new MemberAccountRecordsTypeNameList(8,"提现"));
    	list.add(new MemberAccountRecordsTypeNameList(9,"提现退还"));
    	list.add(new MemberAccountRecordsTypeNameList(10,"调整"));
//    	list.add(new MemberAccountRecordsTypeNameList(11,"参与营销游戏消耗积分"));
    	list.add(new MemberAccountRecordsTypeNameList(12,"返佣"));
    	list.add(new MemberAccountRecordsTypeNameList(13,"抽奖"));
    	list.add(new MemberAccountRecordsTypeNameList(14,"酒店订单"));
//    	list.add(new MemberAccountRecordsTypeNameList(19,"点赞"));
//    	list.add(new MemberAccountRecordsTypeNameList(20,"评论"));
    	return list;
    }

	@Override
	public String getMemberAccountRecordsName(Integer fromType) {
		// TODO Auto-generated method stub
		String typeName = null;
		switch(fromType) {
		case 1:
			typeName = "商城订单";
			break;
		case 2:
			typeName = "订单退还";
			break;
		case 3:
			typeName = "兑换";
			break;
		case 4:
			typeName = "充值";
			break;
		case 5:
			typeName = "签到";
			break;
		case 6:
			typeName = "分享";
			break;
		case 7:
			typeName = "注册";
			break;
		case 8:
			typeName = "提现";
			break;
		case 9:
			typeName = "提现退还";
			break;
		case 10:
			typeName = "调整";
			break;
		case 11:
			typeName = "参与营销游戏消耗积分";
			break;
		case 12:
			typeName = "返佣";
			break;
		case 13:
			typeName = "抽奖";
			break;
		case 14:
			typeName = "酒店订单";
			break;
		case 19:
			typeName = "点赞";
			break;
		case 20:
			typeName = "评论";
			break;
		default:
			typeName = null;
			break;
		}
		return typeName;
	}

	@Override
	public String getMemberAccountRecordsTypeName(Integer accountType) {
		// TODO Auto-generated method stub
		String typeName = null;
		switch(accountType) {
		case 1:
			typeName = "积分";
			break;
		case 2:
			typeName = "余额";
			break;
//		case 3:
//			typeName = "购物币";
//			break;
		default:
			typeName = null;
			break;
		}
		return typeName;
	}

	@Override
	public Integer getMemberPoint(long uid) {
		// TODO Auto-generated method stub
		List<MemberAccountEntity> list = new ArrayList<MemberAccountEntity>();
		list = baseMapper.selectList(new EntityWrapper<MemberAccountEntity>().eq("uid", uid));
		if(list.isEmpty()) {
			return 0;
		}else {
			return list.get(0).getPoint();
		}
	}

	@Override
	public BigDecimal getMemberCoin(long uid) {
		// TODO Auto-generated method stub
		List<MemberAccountEntity> list = new ArrayList<MemberAccountEntity>();
		list = baseMapper.selectList(new EntityWrapper<MemberAccountEntity>().eq("uid", uid));
		BigDecimal coin = list.isEmpty() ? new BigDecimal("0.00") :  new BigDecimal(list.get(0).getCoin().toString());
		return coin;
	}

	@Override
	public BigDecimal getMemberBalance(long uid) {
		// TODO Auto-generated method stub
		List<MemberAccountEntity> list = new ArrayList<MemberAccountEntity>();
		list = baseMapper.selectList(new EntityWrapper<MemberAccountEntity>().eq("uid", uid));
		BigDecimal coin = list.isEmpty() ? new BigDecimal("0.00") :  new BigDecimal(list.get(0).getBalance().toString());
		return coin;
	}

	@Override
	public void addMmemberConsum(Integer shopid, Integer uid, BigDecimal consum) {
		// TODO Auto-generated method stub
		List<MemberAccountEntity> list = new ArrayList<MemberAccountEntity>();
		list = baseMapper.selectList(new EntityWrapper<MemberAccountEntity>().eq("uid", uid).eq("shop_id", shopid));
		MemberAccountEntity obj = new MemberAccountEntity();
		if(list.isEmpty()) {
			obj.setUid(uid);
			obj.setShopId(shopid);
			baseMapper.insert(obj);
			list = baseMapper.selectList(new EntityWrapper<MemberAccountEntity>().eq("uid", uid).eq("shop_id", shopid));
		}
		obj.setMemberCunsum(obj.getMemberCunsum().add(consum));
		obj.setId(list.get(0).getId());
		baseMapper.updateById(obj); //暂不写自动升级
	}
	
	@Override
	public Integer addMemberAccountData(Integer shopid, Integer accountType, Integer uid, Integer sign,
			BigDecimal number, Integer fromType, Integer dataId, String text) {
		return addMemberAccountData(shopid, accountType, uid, sign, number, fromType, dataId, text, null);
	}

	@Override
	public Integer addMemberAccountData(Integer shopid, Integer accountType, Integer uid, Integer sign,
			BigDecimal number, Integer fromType, Integer dataId, String text , List<String> rollbackInfo) {
		MemberAccountRecordsEntity obj = null;
		if(uid == null) {
			return 1;
		}
		try {
			BigDecimal memberAllPoint;
			BigDecimal memberAllBalance;
			List<MemberAccountEntity> list = new ArrayList<MemberAccountEntity>();
			list = baseMapper.selectList(new EntityWrapper<MemberAccountEntity>().eq("uid", uid).eq("shop_id", shopid));			
			if(list.isEmpty()) {
				memberAllPoint = new BigDecimal("0.00");
				memberAllBalance = new BigDecimal("0.00");
			}else {
				memberAllPoint = new BigDecimal(list.get(0).getPoint().toString());
			    memberAllBalance = new BigDecimal(list.get(0).getBalance().toString());
			}
			if(number.compareTo(BigDecimal.ZERO) == -1) {
				if(accountType == 1) {
					if(number.add(memberAllPoint).compareTo(BigDecimal.ZERO) == -1) {
						return ErrorMsg.LOW_POINT.getCode();  //积分不足
					}
				}else if(accountType == 2) {
					if(number.add(memberAllBalance).compareTo(BigDecimal.ZERO) == -1) {
						return ErrorMsg.LOW_BALANCE.getCode(); //余额不足
					}
				}
			}
			obj = new MemberAccountRecordsEntity();
			obj.setShopId(shopid);
			obj.setUid(uid);
			obj.setAccountType(accountType);
			obj.setSign(sign);
			obj.setNumber(number);
			obj.setFromType(fromType);
			obj.setDataId(dataId);
			obj.setText(text);
			obj.setCreateTime(new Date());
			if(fromType == 8) {               //如果是提现  设置为冻结流水扣款
//				obj.setIsFreeze(1);
			}
			boolean retval = memberAccountRecordsService.insert(obj);
			if(retval) {
				MemberAccountEntity objAccount = new MemberAccountEntity();
				EntityWrapper<MemberAccountEntity> ew = new EntityWrapper<MemberAccountEntity>();
				Integer count = list.size();
				if(accountType == 1) {
//					if(count == 0) {
//						objAccount.setUid(uid);
//						objAccount.setShopId(shopid);
//						objAccount.setPoint(number.intValue());
//						objAccount.setMemberSumPoint(number.intValue());
//						baseMapper.insert(objAccount);
//					}else {
//						objAccount.setPoint(memberAllPoint.intValue() + number.intValue());
//						if(number.intValue() > 0) {
//							//计算会员累计积分
//							objAccount.setMemberSumPoint(memberAllPoint.intValue() + number.intValue());
//						}
//						ew.eq("uid", uid);
//						ew.eq("shop_id", shopid);
//						baseMapper.update(objAccount, ew);
//					}
					boolean res = false;
					Semaphore semaphore = new Semaphore(0);
					Vector<String> uidVector = new Vector<String>();
					double totalFee = number.doubleValue();
//					MemberAccountEntity memberAccountEntity = memberAccountService
//							.selectOne(new EntityWrapper<MemberAccountEntity>().eq("uid", uid));
					RewardCalcuTask rewardCalcuTask = new RewardCalcuTask(String.valueOf(uid), totalFee,
							memberAccountService, semaphore, uidVector);
					StartUpRunner.executor.getQueue().offer(rewardCalcuTask);
					try {
						semaphore.acquire();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					if (uidVector.size() > 0 && uidVector.get(0).equals(String.valueOf(uid))) {
						res = true;
					} else if(uidVector.size() > 0 && uidVector.get(0).startsWith(PayConfig.ERROR_HEAD)){
						res = false;
					}
//					if (res) {
//						MemberAccountRecordsEntity accountRecordsEntity = new MemberAccountRecordsEntity();
//						accountRecordsEntity.setUid(uid);
//						accountRecordsEntity.setShopId(0);
//						accountRecordsEntity.setAccountType(1);
//						accountRecordsEntity.setSign(1);
//						accountRecordsEntity.setNumber(number);
//						accountRecordsEntity.setFromType(3);
//						accountRecordsEntity.setDataId(0);
//						accountRecordsEntity.setText("余额兑换积分");
//						accountRecordsEntity.setIsFreeze(0);
//						Date date = Calendar.getInstance().getTime();
//						accountRecordsEntity.setCreateTime(date);
//						res = memberAccountRecordsService.insert(accountRecordsEntity);
//					}
					if(!res) {
						if(rollbackInfo != null) {
							rollbackInfo.add(String.valueOf(obj.getId()));
						}
						return -1;
					}
				}
				if(accountType == 2) {  
					if(count == 0) {
						objAccount.setUid(uid);
						objAccount.setShopId(shopid);
						objAccount.setBalance(number);
						baseMapper.insert(objAccount);
					}else {
						objAccount.setBalance(memberAllBalance.add(number));
						ew.eq("uid", uid);
						ew.eq("shop_id", shopid);
						baseMapper.update(objAccount, ew);
					}
				}
				//购物币不写
			}	
		} catch (Exception e) {
			if(rollbackInfo != null) {
				rollbackInfo.add(String.valueOf(obj.getId()));
			}
			return -1;
		}
		return obj.getId();
	}
    
}
