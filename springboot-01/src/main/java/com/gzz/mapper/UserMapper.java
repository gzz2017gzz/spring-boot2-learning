package com.gzz.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.gzz.model.User;

@Mapper
public interface UserMapper {
	int insertUser(@Param("user") User user);

	User findByName(String name);
}
