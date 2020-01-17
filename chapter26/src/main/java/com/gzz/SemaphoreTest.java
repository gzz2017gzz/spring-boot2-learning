package com.gzz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
	private static Semaphore semaphore = new Semaphore(3);// 资源最多可被3个线程并发访问
	private static ExecutorService executorService = Executors.newCachedThreadPool();
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++) {
			final int threadnum = i;
			executorService.execute(() -> SemaphoreTest.test(threadnum));
		}
		executorService.shutdown();// 如果不shutdown工程不会结束
	}

	private static void test(int threadNum) {
		try {
			System.out.println("current thread" + Thread.currentThread().getName() + "+" + threadNum);
			semaphore.acquire(1);// 获取许可
			System.out.println(simpleDateFormat.format(new Date()) + "  method run " + Thread.currentThread().getName() + "+" + threadNum);
			Thread.sleep(1000);
			semaphore.release(1);// 释放许可
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
