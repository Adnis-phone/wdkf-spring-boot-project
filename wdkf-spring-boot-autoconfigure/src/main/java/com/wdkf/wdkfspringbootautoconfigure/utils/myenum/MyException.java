package com.wdkf.wdkfspringbootautoconfigure.utils.myenum;

/**
 * @ProjectName: frist_dome
 * @Package: com.wdkf.wdkfspringbootautoconfigure.utils
 * @ClassName: MyException
 * @Description: 自定义异常类
 * @Author: wangdehonga
 * @Date: 2020/6/30 14:55
 * @Version: 1.0
 */
public class MyException extends RuntimeException {

    private static final long serialVersionUID = 2359767895161832954L;
    private ReturnMsg returnMsg;


    public MyException(String message) {
        super(message);
    }


    public MyException(ReturnMsg returnMsg) {
        this.returnMsg = returnMsg;
    }

    public ReturnMsg getReturnMsg() {
        return this.returnMsg;
    }


}
