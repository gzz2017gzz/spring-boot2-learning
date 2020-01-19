package com.gzz;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class Chapter8ApplicationTest {
	@Autowired
	private RedisTemplate<String, Integer> redisTemplate;

	@Test
	public void get() {
		final String key = "req_limit_1113";
		RedisAtomicLong counter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
		if (counter.get() == 0) {
			counter.expire(10, TimeUnit.SECONDS);
		}
		long count = counter.incrementAndGet();
		log.info("count=", count);
	}

}
