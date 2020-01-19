package com.gzz.common.aop;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.gzz.common.util.IPAddressUtil;
import com.gzz.sys.blacklist.Blacklist;
import com.gzz.sys.blacklist.BlacklistCond;
import com.gzz.sys.blacklist.BlacklistDao;

@Component
public class URLInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private BlacklistDao blackListDao;

	@Autowired
	private RedisTemplate<String, Integer> redisTemplate;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {

		String ip = IPAddressUtil.getClientIpAddress(request);
		List<Blacklist> blackLists = blackListDao.queryList(BlacklistCond.builder().ip(ip).build());
		if (blackLists.size() == 0) {
			String url = request.getRequestURL().toString();
			final String key = "req_limit_".concat(url).concat(ip);

			RedisAtomicLong counter = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());

			if (counter.get() == 0) {
				counter.expire(1, TimeUnit.MINUTES);
			}
			long count = counter.incrementAndGet();
			if (count > 10) {
				blackListDao.save(Blacklist.builder().ip(ip).iptime(new Date()).build());
			}
			return true;
		} else {
			return false;
		}
	}

}
