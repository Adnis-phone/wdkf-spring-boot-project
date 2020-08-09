package com.wdkf.wdkfspringbootautoconfigure.utils.customannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: frist_dome
 * @Package: com.wdkf.wdkfspringbootautoconfigure.utils.customannotation
 * @ClassName: LogAnnotation
 * @Description: 日志注解
 * @Author: wangdehonga
 * @Date: 2020/7/5 22:25
 * @Version: 1.0
 */
@Target(value = {ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogAnnotation {

    String value() default "";
}
