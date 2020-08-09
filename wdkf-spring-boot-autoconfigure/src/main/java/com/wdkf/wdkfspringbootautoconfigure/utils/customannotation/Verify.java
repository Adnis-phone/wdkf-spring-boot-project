package com.wdkf.wdkfspringbootautoconfigure.utils.customannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: frist_dome
 * @Package: com.wdkf.wdkfspringbootautoconfigure.utils.customannotation
 * @ClassName: Verify
 * @Description: 使用在需要校验的参数上面（对校验规则的设置）
 * @Author: wangdehonga
 * @Date: 2020/7/6 16:20
 * @Version: 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Verify {

    /**
     * 参数
     *
     * @return
     */
    String params();

    /**
     * 参数名称
     *
     * @return
     */
    String paramsName();

    /**
     * 是否必填,默认为非必填
     *
     * @return
     */
    boolean required() default false;

    /**
     * 数据最大长度
     *
     * @return
     */
    int maxLength() default Integer.MAX_VALUE;

    /**
     * 数据最小长度
     *
     * @return
     */
    int minLength() default Integer.MIN_VALUE;

    /**
     * 参数最大值
     *
     * @return
     */
    int max() default Integer.MAX_VALUE;

    /**
     * 参数最小值
     *
     * @return
     */
    int min() default Integer.MIN_VALUE;

    /**
     * 正则匹配
     *
     * @return
     */
    String regular() default "";
}
