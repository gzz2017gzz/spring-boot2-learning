package com.gzz.limiter.annotation;

import java.lang.annotation.*;

import com.gzz.limiter.LimitType;

/**
 * 限流
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Limit {

	/**
	 * 资源的名字
	 */
	String name() default "";

	/**
	 * 资源的key
	 */
	String key() default "";

	/**
	 * Key的prefix
	 */
	String prefix() default "";

	/**
	 * 给定的时间段 单位秒
	 */
	int period();

	/**
	 * 最多的访问限制次数
	 */
	int count();

	/**
	 * 类型
	 */
	LimitType limitType() default LimitType.CUSTOMER;
}