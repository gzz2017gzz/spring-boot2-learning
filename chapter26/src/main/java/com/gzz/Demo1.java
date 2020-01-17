package com.gzz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import com.google.common.util.concurrent.RateLimiter;

public class Demo1 {

	private final RateLimiter rateLimiter = RateLimiter.create(0.5);// 0.5代表一秒最多多少个
	private final ExecutorService threadPool = Executors.newCachedThreadPool();

	@Test
	public void main() {
		for (int i = 0; i < 10; i++) {
			final int ii = i;
			System.out.println("等待时间：" + rateLimiter.acquire());
			threadPool.execute(() -> this.run(ii));
		}
	}

	public void run(int id) {
		System.out.println(id);
	}
}