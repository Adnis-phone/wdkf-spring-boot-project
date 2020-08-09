package com.wdkf.wdkfspringbootautoconfigure.utils.customannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: frist_dome
 * @Package: com.wdkf.wdkfspringbootautoconfigure.utils.customannotation
 * @ClassName: Verifys
 * @Description: 是否参与AOP统一校验标识（主要放在类上：controller、serviceImpl）
 * @Author: wangdehonga
 * @Date: 2020/7/6 16:14
 * @Version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
public @interface Verifys {
}
