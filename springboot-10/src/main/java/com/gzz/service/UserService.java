package com.gzz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.gzz.dao.UserDao;
import com.gzz.model.User;

@CacheConfig(cacheNames = "users")
@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@CacheEvict(key = "'user'")
	public int save(User user)  {
		return userDao.save(user);
	}

	@CachePut(key = "'user_'+#user.getUuid()")
	public User update(User user) {
		User user1 = userDao.findByUuid(user.getUuid());
		if (null == user1) {
			System.err.println("Not Find");
		}
		user1.setAge(user.getAge());
		user1.setName(user.getName());
		userDao.update(user1);
		return user1;
	}

	@Cacheable(key = "'user_'+#uuid")
	public User findByUuid(String uuid) {
		System.err.println("没有走缓存！" + uuid);
		return userDao.findByUuid(uuid);
	}

	@CacheEvict(key = "'user_'+#uuid") // 这是清除缓存
	public void delete(String uuid) {
		userDao.delete(uuid);
	}
}
