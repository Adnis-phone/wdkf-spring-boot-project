package com.wdkf.wdkfspringbootautoconfigure.utils.myenum;

import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ProjectName: frist_dome
 * @Package: com.wdkf.wdkfspringbootautoconfigure.utils
 * @ClassName: returnMsg
 * @Description: 返回状态信息枚举类
 * @Author: wangdehonga
 * @Date: 2020/6/30 14:47
 * @Version: 1.0
 */
@NoArgsConstructor
@ToString
public enum ReturnMsg {

    /**
     * 请求返回状态码及消息
     */
    REQUEST_ERROR(-9999, "请求出错！"),
    REQUEST_DEVICE_INFORMATION_ACQUISITION_FAILED(-8888, "request设备信息获取失败！"),


    /**
     * 参数状态校验返回状态码及消息
     */
    PARAMETER_ERROR(1000, "参数错误！"),
    ENTRY_PARAMETER_ERROR(1001, "入参有误！"),
    ENTRY_PARAMETER_ISEMPTY(1002, "入参为空！"),
    THE_INPUT_PARAMETER_IS_EMPTY_OR_WRONG(1003, "入参为空或入参有误！"),
    THE_RECORD_ALREADY_EXISTS(1004, "该记录已存在! "),

    /**
     * 用户信息返回状态码及消息
     */
    USER_INFORMATION_EMPTY(1050, "用户信息为空或用户密码有误！"),
    THE_USER_TOKEN_IS_EMPTY(1051, "用户token为空! "),
    THE_USERID_DESIGN_IS_ILLEGAL_OR_DOES_NOT_MATCH_THE_FRAMEWORK(1052, "userId设计非法或与框架不符! "),
    THE_USERNAME_DESIGN_IS_ILLEGAL_OR_DOES_NOT_MATCH_THE_FRAMEWORK(1053, "userName设计非法或与框架不符! "),

    /**
     * AOP统一校验返回状态码及消息
     */
    AOP_UNIFIED_VERIFICATION(2000, "AOP统一校验! "),
    PROPERTY_IS_REQUIRED(2001, "%s (%s) 为必填项！"),
    THE_MAXIMUM_LENGTH_IS_UNREASONABLE(2002, "%s (%s)长度不合理，最大长度为%s！"),
    THE_MINIMUM_LENGTH_IS_UNREASONABLE(2003, "%s (%s)长度不合理，最小长度为%s！"),
    THE_PARAMETER_DOES_NOT_CONFORM_TO_THE_RULE(2004, "%s (%s)的请求数据不符合规则! "),
    THE_MAXIMUM_VALUE_IS_OUT_OF_THE_SPECIFIED_RANGE(2005, "%s (%s)最大值超出规定范围，最大值为%s！"),
    THE_MINIMUM_VALUE_IS_OUT_OF_THE_SPECIFIED_RANGE(2006, "%s (%s)最小值超出规定范围，最小值为%s！"),


    REQUEST_INTERACTIVE_USER_INFO_ERROR(3000, "请指定交互类型！"),

    /**
     * 权限信息返回状态码及消息
     */
    ACCESS_RIGHTS(4000, "访问权限异常！"),
    NO_ACCESS_RIGHTS(4001, "没有访问权限! "),
    ERROR_GETTING_CACHE(4002, "获取缓存出错！"),

    /**
     * 数据库交互信息返回状态码及消息
     */
    DATA_WAREHOUSING_FAILURE(5000, "数据入库失败！"),
    USER_REQUEST_PARSING_DATA_WAREHOUSING_FAILED(5001, "用户请求解析数据入库失败"),
    USER_BASIC_INFORMATION_STORAGE_FAILED(5002, "用户基本信息入库失败！"),
    USER_LOGIN_INFORMATION_TABLE_FAILED_TO_BE_STORED(5003, "用户登录信息表入库失败! "),
    USER_INFORMATION_VERIFICATION_FAILED(5004, "用户信息验证失败！"),
    USER_INFORMATION_STORAGE_CACHE_FAILED(5005, "用户信息存储缓存失败！"),


    /**
     * redis交互类状态码
     */
    CACHE_DELETION_FAILED(6001, "缓存删除失败！"),
    CACHE_FUZZY_MATCH_KEY_FAILED(6002, "缓存模糊匹配key失败！"),


    /**
     * 操作状态信息返回状态码及消息
     */
    THE_OPERATION_WAS_SUCCESSFUL(10000, "操作成功！"),


    ;


    private Integer code;
    private String msg;

    ReturnMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public Integer getCode(String msg) {
        ReturnMsg[] all = values();
        for (ReturnMsg returnMsg : all) {
            if (msg.equals(returnMsg.getMsg())) {
                return returnMsg.code;
            }
        }
        return null;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public String getMsg(Integer code) {
        ReturnMsg[] all = values();
        for (ReturnMsg returnMsg : all) {
            if (code.equals(returnMsg.getCode()) || code == returnMsg.code) {
                return returnMsg.msg;
            }
        }
        return null;
    }

}
