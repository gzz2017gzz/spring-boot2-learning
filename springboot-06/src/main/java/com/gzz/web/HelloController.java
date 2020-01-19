package com.gzz.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.aop.RequestLimit;

@RestController
public class HelloController {

	@RequestMapping("/hello")
	@RequestLimit(count = 10)
	public String hello() {
		return "Hello World";
	}

}