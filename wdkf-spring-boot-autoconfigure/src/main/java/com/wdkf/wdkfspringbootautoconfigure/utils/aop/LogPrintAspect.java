package com.wdkf.wdkfspringbootautoconfigure.utils.aop;

import com.alibaba.fastjson.JSON;
import com.wdkf.wdkfspringbootautoconfigure.utils.customannotation.LogAnnotation;
import com.wdkf.wdkfspringbootautoconfigure.utils.thread.AgentThreadLocal;
import com.wdkf.wdkfspringbootautoconfigure.utils.myenum.MyException;
import com.wdkf.wdkfspringbootautoconfigure.utils.myenum.ReturnMsg;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Optional;

/**
 * @ProjectName: frist_dome
 * @Package: com.wdkf.wdkfspringbootautoconfigure.utils.validator
 * @ClassName: LogPrintAspect
 * @Description: 日志打印切点
 * @Author: wangdehonga
 * @Date: 2020/7/5 21:17
 * @Version: 1.0
 */
@Order(3)
@Aspect
@Slf4j
@Component
public class LogPrintAspect {

    long startTime;
    /**
     * 定义切点Pointcut
     */
    private final String POINT_CUT = "execution(* com.*..service.impl.*.*(..))  && @annotation(com.wdkf.wdkfspringbootautoconfigure.utils.customannotation.LogAnnotation)&&!@annotation(com.wdkf.wdkfspringbootautoconfigure.utils.customannotation.NoAuthentication)";

    //切入点描述

    /**
     * 签名，可以理解成这个切入点的一个名称
     */
    @Pointcut(POINT_CUT)
    public void myLogPrint() {
    }

    /**
     * 进入方法前通知行为
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("myLogPrint()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        startTime = System.currentTimeMillis();
        Map<String, Object> map = AgentThreadLocal.get();
        String userId = Optional.ofNullable(map.get("userId").toString()).orElseThrow(() -> new MyException(ReturnMsg.THE_USERID_DESIGN_IS_ILLEGAL_OR_DOES_NOT_MATCH_THE_FRAMEWORK));
        String userName = Optional.ofNullable(map.get("userName").toString()).orElseThrow(() -> new MyException(ReturnMsg.THE_USERNAME_DESIGN_IS_ILLEGAL_OR_DOES_NOT_MATCH_THE_FRAMEWORK));
        ;
        log.info("==============================" + getAnnotation(joinPoint) + " 开始！========================================");
        log.info("操作人：{}", userName + "(" + userId + ")");
        log.info("方法路径: {}", joinPoint.getSignature());
        log.info("方法名称：{}", joinPoint.getSignature().getName());
        log.info("实现业务：{}", getAnnotation(joinPoint));
        log.info("请求参数: {}", JSON.toJSON(joinPoint.getArgs()));
    }

    /**
     * 方法结束后通知
     *
     * @param arg0
     * @return
     * @throws Throwable
     */
    @AfterReturning(value = "myLogPrint()", returning = "arg0")
    public void stealPassword(JoinPoint joinPoint, Object arg0) throws Throwable {
        if (null == arg0 || "".equals(arg0)) {
            log.info("请求结果: {}", "null");
        } else {
            log.info("请求结果: {}", JSON.toJSON(arg0.toString()));
        }
        log.info("耗时 : {} ms", System.currentTimeMillis() - startTime);
        log.info("==============================" + getAnnotation(joinPoint) + " 结束！========================================");
    }

    /**
     * 后置通知异常信息
     *
     * @param e
     */
    @AfterThrowing(value = "myLogPrint()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Throwable e) {
        log.error("异常信息: " + e.getMessage(), e);
        log.info("耗时 : {} ms", System.currentTimeMillis() - startTime);
        log.info("==============================" + getAnnotation(joinPoint) + " 结束！========================================");
    }

    /**
     * 获取方法注解
     *
     * @param joinPoint
     * @return String
     */
    public static String getAnnotation(JoinPoint joinPoint) {
        String result = "";
        Class<?> className = joinPoint.getTarget().getClass();
        //获得访问的方法名
        String methodName = joinPoint.getSignature().getName();
        //得到方法的参数的类型
        Class[] argClass = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();
        try {
            // 得到访问的方法对象
            Method method = className.getDeclaredMethod(methodName, argClass);
            // 判断是否存在@LogAnnotation
            if (method.isAnnotationPresent(LogAnnotation.class)) {
                LogAnnotation annotation = method.getAnnotation(LogAnnotation.class);
                result = annotation.value();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return result;
    }

}
