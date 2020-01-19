package com.gzz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.mapper.UserMapper;
import com.gzz.model.User;

@Service
public class UserService {
	@Autowired
	private UserMapper dao;

	public int add(User user) {
		return dao.insertUser(user);
	}

	public User findByName(String name) {
		return dao.findByName(name);
	}
}
