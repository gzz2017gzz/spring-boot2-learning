package com.gzz.service;

import com.gzz.entity.User;

public interface UserService {

	/**
	 * 删除
	 */
	User saveOrUpdate(User user);

	/**
	 * 添加
	 */
	User get(Long id);

	/**
	 * 删除
	 */
	void delete(Long id);
}
