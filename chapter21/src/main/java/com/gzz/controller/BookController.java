package com.gzz.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.annotation.LocalLock;

/**
 * BookController
 */
@RestController
@RequestMapping("/books")
public class BookController {

	@LocalLock(key = "book:arg[0]")
	@GetMapping
	public String query(@RequestParam String token) {
		return "success - " + token;
	}

}
