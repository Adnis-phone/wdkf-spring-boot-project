package com.wdkf.wdkfspringbootautoconfigure.utils.common;

import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: wdkf-spring-boot-project
 * @Package: com.wdkf.wdkfspringbootautoconfigure.utils.common
 * @ClassName: DoMain
 * @Description: 域
 * @Author: wangdehonga
 * @Date: 2020/8/31 16:40
 * @Version: 1.0
 */
@Component
public class DoMain {

    public String getDoMain(HttpServletRequest request) {
        return request.getHeader("domain");
    }

    public String getAppName(HttpServletRequest request) {
        return request.getHeader("Application");
    }
}
