package com.wdkf.wdkfspringbootutils.random;

import lombok.extern.slf4j.Slf4j;

/**
 * @ProjectName: wdkf-spring-boot-project
 * @Package: com.wdkf.wdkfspringbootutils.date
 * @ClassName: RandomAccessDate
 * @Description: 获取随机时间
 * @Author: wangdehonga
 * @Date: 2020/8/27 13:55
 * @Version: 1.0
 */
@Slf4j
public class RandomUtils {

    /**
     * @Method: randomNumbersAndLowercase
     * @Description: 数字和大写字母随机组合（指定长度）
     * flag：是否允许重复；true允许重复
     * @param length
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/8/27 14:34
     * @Version:  1.0
     */
    public String randomNumbersAndLowercase(Integer length) {}

    public String[] randomNumbersAndLowercase(Integer length, Integer size) {
        return randomNumbersAndLowercase(length,size,true);
    }

    public String[] randomNumbersAndLowercase(Integer length, Integer size, boolean flag) {}

    /**
     * @Method: randomNumbersAndUpcase
     * @Description: 数字和大写字母随机组合（指定长度）
     * flag：是否允许重复；true允许重复
     * @param length
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/8/27 14:35
     * @Version:  1.0
     */
    public String randomNumbersAndUpcase(Integer length) {}

    public String[] randomNumbersAndUpcase(Integer length, Integer size) {
        return randomNumbersAndUpcase(length,size,true);
    }

    public String[] randomNumbersAndUpcase(Integer length, Integer size, boolean flag) {}

    /**
     * @Method: randomNumbersAndLowerUpcase
     * @Description: 数字和大小写字母随机组合（指定长度）
     * flag：是否允许重复；true允许重复
     * @param length
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/8/27 14:36
     * @Version:  1.0
     */
    public String randomNumbersAndLowerUpcase(Integer length) {}

    public String[] randomNumbersAndLowerUpcase(Integer length, Integer size) {
        return randomNumbersAndLowerUpcase(length,size,true);
    }

    public String[] randomNumbersAndLowerUpcase(Integer length, Integer size, boolean flag) {}

    /**
     * @Method: randomNumbers
     * @Description: 随机生成纯数字（指定长度）
     * flag：是否允许重复；true允许重复
     * @param length
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/8/27 14:40
     * @Version:  1.0
     */
    public String randomNumbers(Integer length) {}

    public String[] randomNumbers(Integer length, Integer size) {
        return randomNumbers(length,size,true);
    }

    public String[] randomNumbers(Integer length, Integer size, boolean flag) {}

    /**
     * @Method: randomDate
     * @Description: 随机生成日期
     * @param
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/8/27 14:42
     * @Version:  1.0
     */
    public String randomDate() {}

    public String randomDate(String startDate, String endDate) {}

    public String[] randomDate(String startDate, String endDate, Integer size) {
        return randomDate(startDate, endDate, size, true);
    }

    public String[] randomDate(String startDate, String endDate, Integer size, boolean flag) {}

    /**
     * @Method: randomIDNumber
     * @Description: 随机生成身份证号码（不允许重复）
     * @param
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/8/27 15:08
     * @Version:  1.0
     */
    public String randomIDNumber() {}

    public String[] randomIDNumber(Integer size) {}

    /**
     * @Method: randomUserName
     * @Description: 随机生成中文名字（不允许重复）
     * @param
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/8/27 15:13
     * @Version:  1.0
     */
    public String randomUserName() {}

    public String[] randomUserName(Integer size) {}

}
