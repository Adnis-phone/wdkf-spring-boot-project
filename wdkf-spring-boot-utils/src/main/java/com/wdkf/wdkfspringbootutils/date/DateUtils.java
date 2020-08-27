package com.wdkf.wdkfspringbootutils.date;

import com.sun.org.apache.bcel.internal.generic.NEW;
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
     * @param time
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/8/27 14:23
     * @Version:  1.0
     */
    public String longToDateString(Long time) {
        return longToDateString(time, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @Method: longToDateString
     * @Description: D大数转化为自定义格式的 date（String）
     * @param time
     * @param form
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/8/27 14:25
     * @Version:  1.0
     */
    public String longToDateString(Long time, String form) {
        SimpleDateFormat format = new SimpleDateFormat(form);
        return format.format(new Date(time));
    }

    /**
     * @Method: longToDate
     * @Description: D大数转化为 date
     * @param time
     * @Return: java.util.Date
     * @Author: wangdehonga
     * @Date 2020/8/27 14:26
     * @Version:  1.0
     */
    public Date longToDate(Long time) {
        return new Date(time);
    }

    /**
     * @Method: dateToLong
     * @Description: date（date型）转化为D大数 (Long)
     * @param date
     * @Return: java.lang.Long
     * @Author: wangdehonga
     * @Date 2020/8/27 14:26
     * @Version:  1.0
     */
    public Long dateToLong(Date date) {
        return date.getTime();
    }

    /**
     * @Method: dateToString
     * @Description: date（date型）转化为D大数 (String)
     * @param date
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/8/27 14:27
     * @Version:  1.0
     */
    public String dateToString(Date date) {
        return String.valueOf(date.getTime());
    }

    /**
     * @Method: dateStringToLong
     * @Description: date（String型）转化为D大数 (Long)
     * @param date
     * @Return: java.lang.Long
     * @Author: wangdehonga
     * @Date 2020/8/27 14:29
     * @Version:  1.0
     */
    public Long dateStringToLong(String date) throws Exception {
        return dateStringToLong(date,"yyyy-MM-dd HH:mm:ss");
    }

    public Long dateStringToLong(String date, String form) throws Exception {
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
     * @Description: 时间变换
     * 返回 String（"yyyy-MM-dd HH:mm:ss"（默认模板））
     * @param
     * @Return: java.lang.Long
     * @Author: wangdehonga
     * @Date 2020/8/27 17:08
     * @Version:  1.0
     */
    public String timeShift(String date) throws Exception {
        return timeShift(date,"yyyy-MM-dd HH:mm:ss",true);
    }

    public String timeShift(String date, String form) throws Exception {
        return timeShift(date ,form,true);
    }

    public String timeShift(String date, String form, boolean flag) throws Exception {
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

    public String timeShift(String date, int number, String item) throws Exception {
        return timeShift(date, "yyyy-MM-dd HH:mm:ss",number, item, true);
    }

    public String timeShift(String date, String form, int number, String item) throws Exception {
        return timeShift(date, form,number, item, true);
    }

    public String timeShift(String date, String form, int number, String item, boolean flag) throws Exception {
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

    public String timeShift(String date, String form, Integer years, Integer months, Integer days, Integer hours, Integer minutes, Integer seconds, boolean flag) throws Exception {

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
