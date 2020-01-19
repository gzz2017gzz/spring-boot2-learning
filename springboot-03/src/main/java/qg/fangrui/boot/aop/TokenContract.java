package qg.fangrui.boot.aop;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class TokenContract {

	private static final Logger logger = LoggerFactory.getLogger(TokenContract.class);

	@Before("within(@org.springframework.stereotype.Controller *) && @annotation(token)")
	public void testToken(final JoinPoint joinPoint, Token token) {
		try {
			ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			if (token != null) {
				HttpServletRequest request = attributes.getRequest();
				boolean needSaveSession = token.save();
				if (needSaveSession) {
					String uuid = UUID.randomUUID().toString();
					request.getSession().setAttribute("token", uuid);
					logger.debug("进入表单页面，Token值为：" + uuid);
				}
				boolean needRemoveSession = token.remove();
				if (needRemoveSession) {
					if (isRepeatSubmit(request)) {
						logger.error("表单重复提交");
					}
					request.getSession(false).removeAttribute("token");
				}
			}

		} catch (Exception e) {
			logger.error("token 发生异常 : " + e);
		}
	}

	private boolean isRepeatSubmit(HttpServletRequest request) {
		String serverToken = (String) request.getSession(false).getAttribute("token");
		if (serverToken == null) {
			// throw new FormRepeatException("session 为空");
			return true;
		}
		String clinetToken = request.getParameter("token");
		if (clinetToken == null || clinetToken.equals("")) {
			// throw new FormRepeatException("请从正常页面进入！");
			return true;
		}
		if (!serverToken.equals(clinetToken)) {
			// throw new FormRepeatException("重复表单提交！");
			return true;
		}
		logger.debug("校验是否重复提交：表单页面Token值为：" + clinetToken + ",Session中的Token值为:" + serverToken);
		return false;
	}
}
