package com.wdkf.wdkfspringbootautoconfigure.utils.common;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @ProjectName: wdkf-spring-boot-starter
 * @Package: com.wdkf.wdkfspringbootautoconfigure.utils.common
 * @ClassName: Token
 * @Description:
 * @Author: wangdehonga
 * @Date: 2020/8/3 10:48
 * @Version: 1.0
 */
@Component
public class GetMyToken {

    /**
     * @param
     * @Method: getToken
     * @Description: 获取token
     * @Return: java.lang.String
     * @Author: chenlu
     * @Date 2020/7/30 10:40
     * @Version: 1.0
     */
    public String getToken() {

        return UUID.randomUUID().toString().replaceAll("-", "");

    }
}
