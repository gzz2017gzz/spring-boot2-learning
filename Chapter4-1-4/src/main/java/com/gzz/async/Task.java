package com.gzz.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 程序猿DD
 * @version 1.0.0
 * @date 16/5/16 下午12:58.
 * @blog http://blog.didispace.com
 */
@Slf4j
@Component
public class Task {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Async
	public void doTaskOne(int i) {
		log.info("开始做任务一{}", i);
		long start = System.currentTimeMillis();
		log.info(stringRedisTemplate.randomKey());
		long end = System.currentTimeMillis();
		log.info("i={}完成任务一，耗时：{}毫秒", i, end - start);
	}

	@Async
	public void doTaskTwo(int i) {
		log.info("开始做任务二{}", i);
		long start = System.currentTimeMillis();
		log.info(stringRedisTemplate.randomKey());
		long end = System.currentTimeMillis();
		log.info("i={}完成任务二，耗时：{}毫秒", i, end - start);
	}

	@Async
	public void doTaskThree(int i) {
		log.info("开始做任务三{}", i);
		long start = System.currentTimeMillis();
		log.info(stringRedisTemplate.randomKey());
		long end = System.currentTimeMillis();
		log.info("i={}完成任务三，耗时：{}毫秒", i, end - start);
	}
 
	public static void main(String[] args) {

		int oldCapacity = Integer.MAX_VALUE - 1000;
		int newCapacity = oldCapacity + (oldCapacity >> 1); // grow 50%
		if (newCapacity < 0) // overflow
			newCapacity = Integer.MAX_VALUE;
		System.out.println(newCapacity);

	}
}
