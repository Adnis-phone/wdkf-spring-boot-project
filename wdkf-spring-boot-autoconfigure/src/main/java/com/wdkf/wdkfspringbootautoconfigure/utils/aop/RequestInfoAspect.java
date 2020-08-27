package com.wdkf.wdkfspringbootautoconfigure.utils.aop;

import com.wdkf.wdkfspringbootautoconfigure.utils.common.GetUA;
import com.wdkf.wdkfspringbootautoconfigure.utils.redis.RedisUtil;
import com.wdkf.wdkfspringbootautoconfigure.utils.thread.AgentThreadLocal;
import com.wdkf.wdkfspringbootautoconfigure.utils.myenum.MyException;
import com.wdkf.wdkfspringbootautoconfigure.utils.myenum.ReturnMsg;
import com.wdkf.wdkfspringbootutils.structuretransform.ObjectToMap;
import io.lettuce.core.RedisException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * @ProjectName: frist_dome
 * @Package: com.wdkf.wdkfspringbootautoconfigure.utils
 * @ClassName: LogRecordAspect
 * @Description: 切面
 * @Author: wangdehonga
 * @Date: 2020/7/5 10:28
 * @Version: 1.0
 */
@Slf4j
@Configuration
@Aspect
@Component
@Order(1)
public class RequestInfoAspect {

    @Autowired(required = false)
    private RedisUtil redisUtil;
    @Autowired(required = false)
    private GetUA getUA;
    /**
     * 定义切点Pointcut
     */
    @Pointcut("execution(* com.*..controller.*.*(..)) &&!@annotation(com.wdkf.wdkfspringbootautoconfigure.utils.customannotation.NoAuthentication)")
    public void excudeService() {
    }


    @Around("excudeService()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {

        //获取请求
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();

        //获取请求头的authcode
        Enumeration<String> enumeration = request.getHeaderNames();
        String auth = null;
        while (enumeration.hasMoreElements()) {

            if ("auth".equals(enumeration.nextElement())) {
                auth = "".equals(request.getHeader("auth")) ? null : request.getHeader("auth");
                auth = Optional.ofNullable(auth).orElseThrow(() -> new MyException(ReturnMsg.THE_USER_TOKEN_IS_EMPTY));
                break;
            }
        }
        //获取操作人信息
        auth = getUA.getUA(request) + ":" + auth;
        try {
            Set<String> keys = redisUtil.getKeysList("*" + auth);
            Object[] objects = keys.toArray();
            auth = (String) objects[0];
            Map<String, Object> map = new ObjectToMap().getKeyAndValue(redisUtil.get(auth));
            if (map.isEmpty()) {
                AgentThreadLocal.remove();
                throw new MyException(ReturnMsg.NO_ACCESS_RIGHTS);
            }
            AgentThreadLocal.set(map);
        } catch (RedisException e) {
            new MyException(e.getMessage());
        }
        //更新缓存失效时间
        redisUtil.expire(auth, 1800);

        //调用方法
        Object result = pjp.proceed();

        return result;
    }

}
