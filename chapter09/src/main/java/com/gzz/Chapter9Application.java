package com.gzz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Chapter9Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter9Application.class, args);
	}

}
