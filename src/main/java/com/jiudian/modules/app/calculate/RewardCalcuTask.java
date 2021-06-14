package com.jiudian.modules.app.calculate;

import java.util.Vector;
import java.util.concurrent.Semaphore;

import org.slf4j.LoggerFactory;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.jiudian.common.utils.ErrorMsg;
import com.jiudian.modules.app.config.PayConfig;
import com.jiudian.modules.member.entity.MemberAccountEntity;
import com.jiudian.modules.member.service.MemberAccountService;

public class RewardCalcuTask implements Runnable{

	
	private String userId;
	
	//返润给该用户的积分数
	private double rewardValue;
	
	//因线程池中有冲突任务而延迟的次数
	private int delay = 0;
	
	private long index;
	
	private long lastIndex;
	
	private MemberAccountService memberAccountService;
	
	private Semaphore semaphore;
	
	private Vector<String> uidVector;
	
	private org.slf4j.Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 构造器
	 * 
	 * @param s1 返润涉及用户ID列表
	 */
	public RewardCalcuTask(String userId,double rewardValue, MemberAccountService memberAccountService,
			Semaphore semaphore, Vector<String> uidVector) {
		this.userId = userId;
		this.rewardValue = rewardValue;
		this.memberAccountService = memberAccountService;
		this.semaphore = semaphore;
		this.uidVector = uidVector;
	}
	
	@Override
//	@Transactional
	public void run() {
		// spring无法处理thread的事务，声明式事务无效
//		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
//		PlatformTransactionManager txManager = ContextLoader.getCurrentWebApplicationContext()
//				.getBean(PlatformTransactionManager.class);
//		TransactionStatus status = txManager.getTransaction(def);
		boolean res = false;
		try {
			MemberAccountEntity memberAccountEntity = memberAccountService
					.selectOne(new EntityWrapper<MemberAccountEntity>().eq("uid", userId));
			double point = memberAccountEntity.getPoint();
			memberAccountEntity.setPoint((int) Math.floor(point + rewardValue));// 目前为向下取整
			res = memberAccountService.insertOrUpdate(memberAccountEntity);
		} catch (Exception e) {
			logger.error(ErrorMsg.getException(e));
			logger.error("返润更新失败！ uid: " + userId + " reward: " + rewardValue);
//			txManager.rollback(status); // 回滚事务
		}
		if (res) {
			uidVector.add(userId);
		} else {
			logger.error("返润更新失败！ uid: " + userId + " reward: " + rewardValue);
			uidVector.add(PayConfig.ERROR_HEAD + " uid: " + userId + " reward: " + rewardValue);
//			txManager.rollback(status); // 回滚事务
		}
//		txManager.commit(status); // 提交事务
		semaphore.release();
	}

	/**
	 *	延迟任务执行 
	 * 
	 */
	public void delay() {
		delay = delay++;
	}
	
	public int getDelay() {
		return delay;
	}

	public String getUserId() {
		return userId;
	}

	public long getIndex() {
		return index;
	}

	public void setIndex(long index) {
		this.index = index	;
	}

	public long getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(long lastIndex) {
		this.lastIndex = lastIndex;
	}

	public Semaphore getSemaphore() {
		return semaphore;
	}

	public Vector<String> getUidVector() {
		return uidVector;
	}
}
