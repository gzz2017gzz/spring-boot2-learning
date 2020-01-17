package com.gzz.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gzz.entity.User;

/**
 * t_user 操作：演示两种方式
 * <p>
 * 第一种是基于mybatis3.x版本后提供的注解方式
 * <p/>
 * <p>
 * 第二种是早期写法，将SQL写在 XML 中
 * <p/>
 */
@Mapper
public interface UserMapper {

	/**
	 * 保存用户信息
	 *
	 * @param user 用户信息
	 * @return 成功 1 失败 0
	 */
	int insertA(User user);

	/**
	 * 保存用户信息
	 *
	 * @param user 用户信息
	 * @return 成功 1 失败 0
	 */
	int insertB(User user);
}
