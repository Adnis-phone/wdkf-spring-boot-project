package com.wdkf.wdkfspringbootautoconfigure.utils.advice;

import com.wdkf.wdkfspringbootautoconfigure.utils.common.W;
import com.wdkf.wdkfspringbootautoconfigure.utils.myenum.MyException;
import com.wdkf.wdkfspringbootautoconfigure.utils.myenum.ReturnMsg;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;


@ControllerAdvice(basePackages = "com")
public class MyReturnBodyAdvice implements ResponseBodyAdvice {
//    private static int flag = 0;

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    /**
     * @param o
     * @param methodParameter
     * @param mediaType
     * @param aClass
     * @param serverHttpRequest
     * @param serverHttpResponse
     * @Method: beforeBodyWrite
     * @Description: 统一返回包装
     * @Return: java.lang.Object
     * @Author: wangdehonga
     * @Date 2020/7/27 11:06
     * @Version: 1.0
     */
    @Override
    public W beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {

        String[] type = methodParameter.toString().split(" ");
        String methodName = type[1].replace("'", "");
        if ("handleException".equals(methodName)) {
            return (W) o;
        }
        if (null == o || "".equals(o)) {
            return W.success();
        }
        return W.success(o);
    }

    /**
     * @param exception
     * @Method: handleException
     * @Description: 统一异常处理
     * @Return: com.wdkf.wdkfspringbootautoconfigure.utils.common.W
     * @Author: wangdehonga
     * @Date 2020/7/27 11:07
     * @Version: 1.0
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody()
    public W handleException(Exception exception) throws Exception {
        W result = null;
        if (exception.toString().endsWith(".MyException")) {
            MyException myException = (MyException) exception;
            ReturnMsg r = myException.getReturnMsg();
            result = W.hasError(r);
        } else {
            result = W.hasError(exception.getMessage());
        }
        return result;
    }
}
