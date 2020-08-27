package com.wdkf.wdkfspringbootutils.date;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ProjectName: wdkf-spring-boot-project
 * @Package: com.wdkf.wdkfspringbootutils.date
 * @ClassName: dateConversion
 * @Description: 时间格式转换
 * @Author: wangdehonga
 * @Date: 2020/8/27 13:52
 * @Version: 1.0
 */
@Slf4j
public class DateUtils {

    /**
     * @Method: longToDateString
     * @Description: D大数转化为默认格式（yyyy-MM-dd HH:mm:ss）的 date（String）
     * @param time
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/8/27 14:23
     * @Version:  1.0
     */
    public String longToDateString(Long time) {}

    /**
     * @Method: longToDateString
     * @Description: D大数转化为自定义格式的 date（String）
     * @param time
     * @param sdf
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/8/27 14:25
     * @Version:  1.0
     */
    public String longToDateString(Long time, SimpleDateFormat sdf) {}

    /**
     * @Method: longToDate
     * @Description: D大数转化为 date
     * @param time
     * @Return: java.util.Date
     * @Author: wangdehonga
     * @Date 2020/8/27 14:26
     * @Version:  1.0
     */
    public Date longToDate(Long time) {}

    /**
     * @Method: dateToLong
     * @Description: date（date型）转化为D大数 (Long)
     * @param date
     * @Return: java.lang.Long
     * @Author: wangdehonga
     * @Date 2020/8/27 14:26
     * @Version:  1.0
     */
    public Long dateToLong(Date date) {}

    /**
     * @Method: dateToString
     * @Description: date（date型）转化为D大数 (String)
     * @param date
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/8/27 14:27
     * @Version:  1.0
     */
    public String dateToString(Date date) {}

    /**
     * @Method: dateStringToLong
     * @Description: date（String型）转化为D大数 (Long)
     * @param date
     * @Return: java.lang.Long
     * @Author: wangdehonga
     * @Date 2020/8/27 14:29
     * @Version:  1.0
     */
    public Long dateStringToLong(String date) {}

}
