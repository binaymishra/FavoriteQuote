package com.favorite.quote.api.business;

import java.util.concurrent.atomic.AtomicLong;


public final class  CounterIdGenerator implements IdGenerator{

	private AtomicLong counter;
	
	public CounterIdGenerator(long initialValue) {
		this. counter = new AtomicLong(initialValue);
	}

	private long  nextValue() {
		return counter.incrementAndGet();
	}

	@Override
	public final String getGeneratedId() {
		StringBuilder id = new StringBuilder();
		long counter = this.nextValue();
		id.append(counter);
		return id.toString();
	}
	

}
