package com.gzz.limiter;


/**
 * <p>redis 限流类型</p>
 */

public enum LimitType {
    /**
     * 自定义key
     */
    CUSTOMER,
    /**
     * 根据请求者IP
     */
    IP;
}
