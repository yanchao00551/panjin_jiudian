package com.jiudian.modules.app.calculate;

import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class RewardExcutor extends ThreadPoolExecutor{
	
	private static Vector<String> vector = new Vector<String>(); 
	
	private ReentrantLock reentrantLock = new ReentrantLock();

	public RewardExcutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
	}
	
	@Override
	public void execute(Runnable command) {
		if(command instanceof RewardCalcuTask) {
			reentrantLock.lock();
			if(vector.contains(((RewardCalcuTask) command).getUserId())) {
				BlockingQueue<Runnable> blockingQueue = this.getQueue();
				((RewardCalcuTask) command).setLastIndex(((RewardCalcuTask) command).getIndex());
				((RewardCalcuTask) command).delay();
				blockingQueue.offer(command);
				reentrantLock.unlock();
			}else {
				vector.add(((RewardCalcuTask) command).getUserId());
				reentrantLock.unlock();
				super.execute(command);
			}
			
		}
		
	}
	
	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		super.afterExecute(r, t);
		reentrantLock.lock();
		if(r instanceof RewardCalcuTask) {
			vector.remove(((RewardCalcuTask) r).getUserId());
		}
		reentrantLock.unlock();
	}

}
