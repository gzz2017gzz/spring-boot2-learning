package com.gzz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gzz.entity.User;
import com.gzz.mapper.UserMapper;
import com.gzz.service.UserService;

/**
 * t_user 操作：演示两种方式
 * <p>第一种是基于mybatis3.x版本后提供的注解方式<p/>
 * <p>第二种是早期写法，将SQL写在 XML 中<p/>
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert() {
        this.userMapper.insertA(new User(2L, "aa", "aa"));
        this.userMapper.insertB(new User(2L, "bb", "bb"));
        @SuppressWarnings("unused")
		int i = 10 / 0;
        return 0;
    }
}
