package com.wdkf.wdkfspringbootautoconfigure.utils.aop;

import com.wdkf.wdkfspringbootautoconfigure.utils.customannotation.Verify;
import com.wdkf.wdkfspringbootautoconfigure.utils.myenum.MyException;
import com.wdkf.wdkfspringbootautoconfigure.utils.myenum.ReturnMsg;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * @ProjectName: frist_dome
 * @Package: com.wdkf.wdkfspringbootautoconfigure.utils.aop
 * @ClassName: paramsVerifyAspect
 * @Description: 参数统一校验、正常返回统一包装切面
 * @Author: wangdehonga
 * @Date: 2020/7/6 16:44
 * @Version: 1.0
 */
@Order(1)
@Aspect
@Slf4j
@Component
public class paramsVerifyAspect {
    @Pointcut("execution(* com.*..controller.*.*(..))")
    public void excudeService() {
    }

    /**
     * @param joinPoint
     * @Method: parameterVerifyBefore
     * @Description: 统一入参校验
     * @Return: void
     * @Author: wangdehonga
     * @Date 2020/7/13 20:09
     * @Version: 1.0
     */
    @Before(value = "@annotation(com.wdkf.wdkfspringbootautoconfigure.utils.customannotation.Verifys)")
    public void parameterVerifyBefore(JoinPoint joinPoint) throws IllegalAccessException {

        //获取切点对象
        Object object = joinPoint.getArgs()[0];
        Class clz = object.getClass();
        Field[] fields = clz.getDeclaredFields();

        //循坏属性
        Optional.ofNullable(fields).orElseThrow(() -> new MyException(ReturnMsg.ENTRY_PARAMETER_ISEMPTY));
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Verify.class)) {

                //获取校验标准
                Verify verify = field.getAnnotation(Verify.class);
                String params = verify.params();
                String paramsName = verify.paramsName();
                boolean required = verify.required();
                int maxLength = verify.maxLength();
                int minLength = verify.minLength();
                int max = verify.max();
                int min = verify.min();
                String regular = verify.regular();
                Object fieldObj = null;
                //获取属性值
                try {
                    fieldObj = field.get(object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                //开始校验
                //必填项校验
                if (required) {
                    if (StringUtils.isEmpty(fieldObj)) {
                        ReturnMsg returnMsg = ReturnMsg.PROPERTY_IS_REQUIRED;
                        returnMsg.setMsg(String.format(ReturnMsg.PROPERTY_IS_REQUIRED.getMsg(), params, paramsName));
                        throw new MyException(returnMsg);
                    }
                }
                //最大长度校验
                if (Integer.MAX_VALUE != maxLength) {
                    if (maxLength < String.valueOf(fieldObj).length()) {
                        ReturnMsg returnMsg = ReturnMsg.THE_MAXIMUM_LENGTH_IS_UNREASONABLE;
                        returnMsg.setMsg(String.format(ReturnMsg.THE_MAXIMUM_LENGTH_IS_UNREASONABLE.getMsg(), params, paramsName));
                        throw new MyException(returnMsg);
                    }
                }
                //最小长度校验
                if (Integer.MIN_VALUE != minLength) {
                    if (minLength > String.valueOf(fieldObj).length()) {
                        ReturnMsg returnMsg = ReturnMsg.THE_MINIMUM_LENGTH_IS_UNREASONABLE;
                        returnMsg.setMsg(String.format(ReturnMsg.THE_MINIMUM_LENGTH_IS_UNREASONABLE.getMsg(), params, paramsName));
                        throw new MyException(returnMsg);
                    }
                }
                //最大值校验
                if (Integer.MAX_VALUE != max) {
                    if (max < (int) fieldObj) {
                        ReturnMsg returnMsg = ReturnMsg.THE_MAXIMUM_VALUE_IS_OUT_OF_THE_SPECIFIED_RANGE;
                        returnMsg.setMsg(String.format(ReturnMsg.THE_MAXIMUM_VALUE_IS_OUT_OF_THE_SPECIFIED_RANGE.getMsg(), params, paramsName));
                        throw new MyException(returnMsg);
                    }
                }
                //最小值校验
                if (Integer.MIN_VALUE != min) {
                    if (min > (int) fieldObj) {
                        ReturnMsg returnMsg = ReturnMsg.THE_MINIMUM_VALUE_IS_OUT_OF_THE_SPECIFIED_RANGE;
                        returnMsg.setMsg(String.format(ReturnMsg.THE_MINIMUM_VALUE_IS_OUT_OF_THE_SPECIFIED_RANGE.getMsg(), params, paramsName));
                        throw new MyException(returnMsg);
                    }
                }
                //正则校验
                if (!StringUtils.isEmpty(regular)) {
                    Pattern pattern = Pattern.compile(regular);
                    if (!pattern.matcher(String.valueOf(fieldObj)).matches()) {
                        ReturnMsg returnMsg = ReturnMsg.THE_PARAMETER_DOES_NOT_CONFORM_TO_THE_RULE;
                        returnMsg.setMsg(String.format(ReturnMsg.THE_PARAMETER_DOES_NOT_CONFORM_TO_THE_RULE.getMsg(), params, paramsName));
                        throw new MyException(returnMsg);
                    }
                }
            }
        }
    }
}
