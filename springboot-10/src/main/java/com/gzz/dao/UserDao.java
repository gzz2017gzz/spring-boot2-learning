package com.gzz.dao;

import org.apache.ibatis.annotations.Mapper;

import com.gzz.model.User;

@Mapper
public interface UserDao {

	void delete(String uuid);

	int update(User user);

	User findByUuid(String uuid);

	int save(User user);
}
