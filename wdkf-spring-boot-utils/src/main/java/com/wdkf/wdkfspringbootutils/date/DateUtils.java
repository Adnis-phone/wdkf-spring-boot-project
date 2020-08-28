package com.wdkf.wdkfspringbootutils.date;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

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
     * @param time 时间戳，默认转化模板为："yyyy-MM-dd HH:mm:ss"
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/8/27 14:23
     * @Version:  1.0
     */
    public static String longToDateString(Long time) {
        return longToDateString(time, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @Method: longToDateString
     * @Description: D大数转化为自定义格式的 date（String）
     * @param time 时间戳
     * @param form 转化模板
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/8/27 14:25
     * @Version:  1.0
     */
    public static String longToDateString(Long time, String form) {
        SimpleDateFormat format = new SimpleDateFormat(form);
        return format.format(new Date(time));
    }

    /**
     * @Method: longToDate
     * @Description: D大数转化为 date
     * @param time 时间戳
     * @Return: java.util.Date
     * @Author: wangdehonga
     * @Date 2020/8/27 14:26
     * @Version:  1.0
     */
    public static Date longToDate(Long time) {
        return new Date(time);
    }

    /**
     * @Method: dateToLong
     * @Description: date（date型）转化为D大数 (Long)
     * @param date 时间
     * @Return: java.lang.Long
     * @Author: wangdehonga
     * @Date 2020/8/27 14:26
     * @Version:  1.0
     */
    public  static Long dateToLong(Date date) {
        return date.getTime();
    }

    /**
     * @Method: dateToString
     * @Description: date（date型）转化为D大数 (String)
     * @param date 时间
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/8/27 14:27
     * @Version:  1.0
     */
    public  static String dateToString(Date date) {
        return String.valueOf(date.getTime());
    }

    /**
     * @Method: dateStringToLong
     * @Description: date（String型）转化为D大数 (Long)
     * @param date 时间（String型），默认模板为："yyyy-MM-dd HH:mm:ss"
     * @Return: java.lang.Long
     * @Author: wangdehonga
     * @Date 2020/8/27 14:29
     * @Version:  1.0
     */
    public  static Long dateStringToLong(String date) throws Exception {
        return dateStringToLong(date,"yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @Method: dateStringToLong
     * @Description:
     * @param date 时间（String型）
     * @param form 时间模板
     * @Return: java.lang.Long
     * @Author: wangdehonga
     * @Date 2020/8/28 10:15
     * @Version:  1.0
     */
    public  static Long dateStringToLong(String date, String form) throws Exception {

        //设定入参时间格式
        SimpleDateFormat format = new SimpleDateFormat(form);
        try {
            return format.parse(date).getTime();
        } catch (Exception pe) {
            throw new Exception("时间格式不匹配！");
        }
    }

    /**
     * @Method: timeShift
     * @Description: 随机时间增加变换
     * 返回 String（"yyyy-MM-dd HH:mm:ss"（默认模板））
     * @param date 时间，默认模板为："yyyy-MM-dd HH:mm:ss"
     * @Return: java.lang.Long
     * @Author: wangdehonga
     * @Date 2020/8/27 17:08
     * @Version:  1.0
     */
    public  static String timeShift(String date) throws Exception {
        return timeShift(date,"yyyy-MM-dd HH:mm:ss",true);
    }

    /**
     * @Method: timeShift
     * @Description: 随机时间增加变换
     * 返回 String（"yyyy-MM-dd HH:mm:ss"（默认模板））
     * @param date 时间
     * @param form 模板
     * @Return: java.lang.Long
     * @Author: wangdehonga
     * @Date 2020/8/27 17:08
     * @Version:  1.0
     */
    public  static String timeShift(String date, String form) throws Exception {
        return timeShift(date ,form,true);
    }

    /**
     * @Method: timeShift
     * @Description: 随机时间变换
     * 返回 String（form模板）
     * @param date 时间
     * @param form 时间模板
     * @param flag true：增加时间，false：减少时间
     * @Return: java.lang.Long
     * @Author: wangdehonga
     * @Date 2020/8/27 17:08
     * @Version:  1.0
     */
    public  static String timeShift(String date, String form, boolean flag) throws Exception {
        Random r = new Random();
        int number = r.nextInt(999999999);
        Long time = dateStringToLong(date,form);
        if(!flag) {

            //减少操作
            number = -number;
        }
        time += number;
        return longToDateString(time,form);
    }

    /**
     * @Method: timeShift
     * @Description: 时间增加变换
     * @param date 时间，默认时间模板为："yyyy-MM-dd HH:mm:ss"
     * @param number 变换基数
     * @param item 变换项目: years, months, days, hours, minutes or seconds
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/8/28 10:24
     * @Version:  1.0
     */
    public  static String timeShift(String date, int number, String item) throws Exception {
        return timeShift(date, "yyyy-MM-dd HH:mm:ss",number, item, true);
    }

    /**
     * @Method: timeShift
     * @Description: 时间增加变换
     * @param date 时间
     * @param form 时间模板
     * @param number 变换基数
     * @param item 变换项目: years, months, days, hours, minutes or seconds
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/8/28 10:26
     * @Version:  1.0
     */
    public  static String timeShift(String date, String form, int number, String item) throws Exception {
        return timeShift(date, form,number, item, true);
    }

    /**
     * @Method: timeShift
     * @Description: 时间变换
     * @param date 时间
     * @param form 时间模板
     * @param number 变换基数
     * @param item 变换项目: years, months, days, hours, minutes or seconds
     * @param flag true：增加时间，false：减少时间
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/8/28 10:26
     * @Version:  1.0
     */
    public  static String timeShift(String date, String form, int number, String item, boolean flag) throws Exception {
        try {
            switch (item) {
                case "years":
                    return timeShift(date,form,number,0,0,0,0,0,flag);
                case "months":
                    return timeShift(date,form,0,number,0,0,0,0,flag);
                case "days":
                    return timeShift(date,form,0,0,number,0,0,0,flag);
                case "hours":
                    return timeShift(date,form,0,0,0,number,0,0,flag);
                case "minutes":
                    return timeShift(date,form,0,0,0,0,number,0,flag);
                case "seconds":
                    return timeShift(date,form,0,0,0,0,0,number,flag);
                default:
                    throw new Exception("Please input one of years, months, days, hours, minutes or seconds! ");
            }
        } catch (Exception ignored) {
            throw new Exception("Please input one of years, months, days, hours, minutes or seconds! ");
        }
    }

    /**
     * @Method: timeShift
     * @Description: 时间变换
     * @param date 时间
     * @param form 时间模板
     * @param years 变换项目（年）
     * @param months 变换项目（月）
     * @param days 变换项目（日）
     * @param hours 变换项目（时）
     * @param minutes 变换项目（分）
     * @param seconds 变换项目（秒）
     * @param flag true：增加时间，false：减少时间
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/8/28 10:29
     * @Version:  1.0
     */
    public  static String timeShift(String date, String form, Integer years, Integer months, Integer days, Integer hours, Integer minutes, Integer seconds, boolean flag) throws Exception {
        //定义返回时间
        String resDate = "";
        long resTime = dateStringToLong(date,form);
        SimpleDateFormat sdf = new SimpleDateFormat(form);
        Date dt = sdf.parse(date);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        if(!flag) {

            //减少变换
            years   = -years;
            months  = -months;
            days    = -days;
            hours   = -hours;
            minutes = -minutes;
            seconds = -seconds;
        }
        rightNow.add(Calendar.YEAR, years);
        rightNow.add(Calendar.MONTH, months);
        rightNow.add(Calendar.DATE, days);
        rightNow.add(Calendar.HOUR, hours);
        rightNow.add(Calendar.MINUTE, minutes);
        rightNow.add(Calendar.SECOND, seconds);
        Date dt1 = rightNow.getTime();
        return sdf.format(dt1);
    }

}
