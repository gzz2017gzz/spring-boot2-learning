package com.gzz.aop;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class RequestLimitAop {
	private static final Logger logger = LoggerFactory.getLogger(RequestLimitAop.class);
	// 用于存储记录
	private Map<String, Integer> redisTemplate = new HashMap<String, Integer>();

	@Before("within(@org.springframework.web.bind.annotation.RestController *) && @annotation(limit)")
	public void requestLimit(RequestLimit limit) {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		String ip = request.getLocalAddr();
		String key = request.getRequestURL().toString();

		logger.info("key={}", key);
		Integer count = redisTemplate.get(key);
		if (count == null || count == 0) {
			redisTemplate.put(key, 1);
			new Timer().schedule(new TimerTask() { // 创建一个新的计时器任务。
				@Override
				public void run() {
					redisTemplate.remove(key);
				}
			}, limit.time());
		} else {
			redisTemplate.put(key, count + 1);
		}

		if (redisTemplate.get(key) > limit.count()) {
			logger.info("用户IP[" + ip + "]访问地址[" + key + "]超过了限定的次数[" + limit.count() + "]");
		}

	}
}