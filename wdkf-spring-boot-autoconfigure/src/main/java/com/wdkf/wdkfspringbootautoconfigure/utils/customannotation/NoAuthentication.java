package com.wdkf.wdkfspringbootautoconfigure.utils.customannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: wdkf-spring-boot-starter
 * @Package: com.wdkf.wdkfspringbootautoconfigure.utils.customannotation
 * @ClassName: NoAuthentication
 * @Description: 跳过统一用户身份验证，仅用于调用登录接口
 * @Author: wangdehonga
 * @Date: 2020/7/28 10:55
 * @Version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
public @interface NoAuthentication {
}
