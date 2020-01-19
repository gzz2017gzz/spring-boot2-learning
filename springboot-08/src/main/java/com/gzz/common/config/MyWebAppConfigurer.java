package com.gzz.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gzz.common.aop.URLInterceptor;

@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {

	@Autowired
	private URLInterceptor urlInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		// 多个拦截器组成一个拦截器链
		// addPathPatterns 用于添加拦截规则, 这里假设拦截 /url 后面的全部链接
		// excludePathPatterns 用户排除拦截
		registry.addInterceptor(urlInterceptor).addPathPatterns("/**");

	}
}
