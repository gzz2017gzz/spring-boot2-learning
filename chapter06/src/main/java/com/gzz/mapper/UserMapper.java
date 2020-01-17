package com.gzz.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.gzz.entity.User;

import java.util.List;

/**
 * t_user 操作：演示两种方式 第一种是基于mybatis3.x版本后提供的注解方式 第二种是早期写法，将SQL写在 XML 中
 */
@Mapper
public interface UserMapper {
	@Select("SELECT * FROM t_user WHERE username = #{username}")
	List<User> findByUsername(@Param("username") String username);

	int insert(User user);
}
