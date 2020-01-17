package com.gzz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	private static Semaphore smp = new Semaphore(3);
	// 注意我创建的线程池类型，
	private static ExecutorService se = Executors.newCachedThreadPool();
	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss SSS");

	public static void run(String id) {
		try {
			smp.acquire();
			System.out.println(simpleDateFormat.format(new Date()) + " Thread " + id + " is working");
			Thread.sleep(1000);
			smp.release();
			System.out.println(simpleDateFormat.format(new Date()) + " Thread " + id + " is over");
		} catch (InterruptedException e) {
		}
	}

	public static void main(String[] args) {
		String ayy[] = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
		for (String string : ayy) {
			se.submit(() -> SemaphoreDemo.run(string));
		}
		se.shutdown();
	}
}