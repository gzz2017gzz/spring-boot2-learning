package com.gzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gzz.interceptor.CacheKeyGenerator;
import com.gzz.interceptor.LockKeyGenerator;

@SpringBootApplication
public class Chapter22Application {

	public static void main(String[] args) {

		SpringApplication.run(Chapter22Application.class, args);

	}

	@Bean
	public CacheKeyGenerator cacheKeyGenerator() {
		return new LockKeyGenerator();
	}
}