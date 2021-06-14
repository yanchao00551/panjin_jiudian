package com.jiudian.modules.app.calculate;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

public class RewardQueue<E> extends PriorityBlockingQueue<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5384865812136814502L;
	final static AtomicLong seq = new AtomicLong();
	long seqNum = 0l;

	public RewardQueue(int initialCapacity, Comparator<? super E> comparator) {
		super(initialCapacity, comparator);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean offer(Object e) {
		seqNum = seq.incrementAndGet();
		if (e instanceof RewardCalcuTask) {
			((RewardCalcuTask) e).setIndex(seqNum);
		}
		return super.offer((E) e);
	}

}
