package com.gzz.service;

/**
 * t_user 操作：演示两种方式
 * <p>第一种是基于mybatis3.x版本后提供的注解方式<p/>
 * <p>第二种是早期写法，将SQL写在 XML 中<p/>
 */
public interface UserService {


    /**
     * 保存用户信息
     *
     * @return 成功 1 失败 0
     */
    int insert();

}
