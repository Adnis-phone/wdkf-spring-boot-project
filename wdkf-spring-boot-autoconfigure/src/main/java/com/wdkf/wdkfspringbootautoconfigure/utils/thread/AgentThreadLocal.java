package com.wdkf.wdkfspringbootautoconfigure.utils.thread;

import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ProjectName: wdkf-spring-boot-starter
 * @Package: com.wdkf.wdkfspringbootautoconfigure.utils.thread
 * @ClassName: AgentThreadLocal
 * @Description: 本地线程交互类
 * @Author: wangdehonga
 * @Date: 2020/7/29 17:11
 * @Version: 1.0
 */
@Component
public class AgentThreadLocal {

    private AgentThreadLocal() {
    }

    /**
     * 用户信息
     */
    private static final ThreadLocal<Map<String, Object>> LOCAL = new ThreadLocal<Map<String, Object>>();

    public static void set(Map<String, Object> user) {
        LOCAL.set(user);
    }

    public static Map<String, Object> get() {
        return LOCAL.get();
    }

    public static void remove() {
        LOCAL.remove();
    }
}
