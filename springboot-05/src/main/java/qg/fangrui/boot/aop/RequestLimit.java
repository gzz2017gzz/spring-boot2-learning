package qg.fangrui.boot.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface RequestLimit {
	int count() default Integer.MAX_VALUE;

	/**
	 * 时间段，单位为毫秒，默认值一分钟
	 */
	long time() default 60000;
}
