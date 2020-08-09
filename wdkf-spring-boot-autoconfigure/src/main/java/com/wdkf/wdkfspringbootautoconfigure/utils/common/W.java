package com.wdkf.wdkfspringbootautoconfigure.utils.common;

import com.wdkf.wdkfspringbootautoconfigure.utils.myenum.ReturnMsg;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ProjectName: frist_dome
 * @Package: com.wdkf.wdkfspringbootautoconfigure.utils.common
 * @ClassName: W
 * @Description: 返回实体包装类
 * @Author: wangdehonga
 * @Date: 2020/7/9 14:22
 * @Version: 1.0
 */
@Getter
@Setter
@NoArgsConstructor
public class W<T> {

    private Integer code = -9999;

    private T data;

    private String msg;

    private String date;

    public W(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public W(T data, ReturnMsg returnMsg) {
        this.data = data;
        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        this.code = returnMsg.getCode();
        this.msg = returnMsg.getMsg();
    }

    public W(T data, ReturnMsg returnMsg, String extendsString) {
        this.code = returnMsg.getCode();
        this.msg = returnMsg.getMsg() + extendsString;
        this.data = data;
        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public W(String msg) {
        this.msg = msg;
        this.date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public static <T> W hasError(ReturnMsg returnMsg) {
        return new W("", returnMsg);
    }

    public static <T> W hasError(Integer code, String msg) {
        return new W(code, "", msg);
    }

    public static <T> W hasError() {
        return new W("", ReturnMsg.REQUEST_ERROR);
    }

    public static <T> W hasError(String msg) {
        return new W(msg);
    }

    public static <T> W success() {
        return new W("", ReturnMsg.THE_OPERATION_WAS_SUCCESSFUL);
    }

    public static <T> W success(T data) {
        return new W(data, ReturnMsg.THE_OPERATION_WAS_SUCCESSFUL);
    }



    @Override
    public String toString() {
        return "W{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
