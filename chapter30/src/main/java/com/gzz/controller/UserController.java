package com.gzz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gzz.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public int insert() {
		return userService.insert();
	}

}
