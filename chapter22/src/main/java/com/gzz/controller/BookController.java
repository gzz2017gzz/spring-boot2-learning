package com.gzz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.annotation.CacheLock;
import com.gzz.annotation.CacheParam;

@RestController
@RequestMapping("/books")
public class BookController {

	@CacheLock(prefix = "books")
	@GetMapping
	public String query(@CacheParam(name = "token") @RequestParam String token) {
		return "success - " + token;
	}

}
