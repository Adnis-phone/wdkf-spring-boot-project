package com.wdkf.wdkfspringbootutils.random;

import com.wdkf.wdkfspringbootutils.file.FileUtils;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

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
     * @Author: 王品峰
     * @Description: 随机大小写
     * @DateTime: 2020/8/28 10:12
     * @param length 长度
     * @param flag 0小写，1大写，2大小写
     * @Return: java.lang.String
     */
    private static String randomNumberAndCase(Integer length,Integer flag){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        if (flag == 0){//falg=0小写
            for (int i = 0; i < length; i++) {
                boolean b = random.nextBoolean();
                if(b){
                    int choice = 97;
                    sb.append((char)(choice+random.nextInt(26)));
                }else{
                    sb.append(random.nextInt(10));
                }
            }
        }else if (flag == 1){//falg=1大写
            for (int i = 0; i < length; i++) {
                boolean b = random.nextBoolean();
                if(b){
                    int choice = 65;
                    sb.append((char)(choice+random.nextInt(26)));
                }else{
                    sb.append(random.nextInt(10));
                }
            }
        }else {//falg=2大小写
            for (int i = 0; i < length; i++) {
                boolean b = random.nextBoolean();
                if(b){
                    int choice = random.nextBoolean() ? 65 : 97;
                    sb.append((char)(choice+random.nextInt(26)));
                }else{
                    sb.append(random.nextInt(10));
                }
            }
        }
        return sb.toString();
    }

    /**
     * @Method: randomNumbersAndLowercase
     * @Description: 数字和小写字母随机组合（指定长度）
     * @param length 长度
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/8/27 14:34
     * @Version:  1.0
     */
    public static String randomNumbersAndLowercase(Integer length) {
        return randomNumberAndCase(length,0);
    }

    /**
     * @Author: 王品峰
     * @Description: 数字和小写字母随机组合（指定长度）
     * @DateTime: 2020/8/28 10:15
     * @param size 大小
     * @param length 长度
     * @Return: java.lang.String[]
     */
    public static String[] randomNumbersAndLowercase(Integer length, Integer size) {
        return randomNumbersAndLowercase(length,size,true);
    }

    /**
     * @Author: 王品峰
     * @Description: 数字和小写字母随机组合（指定长度）
     * @DateTime: 2020/8/28 10:15
     * @param flag 是否允许重复；true允许重复
     * @param size 大小
     * @param length 长度
     * @Return: java.lang.String[]
     */
    public static String[] randomNumbersAndLowercase(Integer length, Integer size, boolean flag) {
        Set<String> set = new HashSet<String>();
        List<String> list = new ArrayList<String>();
        if (flag){
            while(list.size() < size){
                list.add(randomNumbersAndLowercase(length));
            }
            return list.toArray(new String[list.size()]);
        }
        while(set.size() < size){
            set.add(randomNumbersAndLowercase(length));
        }
        return set.toArray(new String[set.size()]);
    }

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
    public static String randomNumbersAndUpcase(Integer length) {
        return randomNumberAndCase(length,1);
    }

    /**
     * @Author: 王品峰
     * @Description: 数字和大写字母随机组合（指定长度）
     * @DateTime: 2020/8/28 10:18
     * @param size 大小
     * @param length 长度
     * @Return: java.lang.String[]
     */
    public static String[] randomNumbersAndUpcase(Integer length, Integer size) {
        return randomNumbersAndUpcase(length,size,true);
    }

    /**
     * @Author: 王品峰
     * @Description: 数字和大写字母随机组合（指定长度）
     * @DateTime: 2020/8/28 10:18
     * @param flag 是否允许重复；true允许重复
     * @param size 大小
     * @param length 长度
     * @Return: java.lang.String[]
     */
    public static String[] randomNumbersAndUpcase(Integer length, Integer size, boolean flag) {
        Set<String> set = new HashSet<String>();
        List<String> list = new ArrayList<>();
        if (flag){
            while(list.size() < size){
                list.add(randomNumbersAndUpcase(length));
            }
            return list.toArray(new String[list.size()]);
        }
        while(set.size() < size){
            set.add(randomNumbersAndUpcase(length));
        }
        return set.toArray(new String[set.size()]);
    }

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
    public static String randomNumbersAndLowerUpcase(Integer length) {
        return randomNumberAndCase(length,2);
    }

    /**
     * @Author: 王品峰
     * @Description: 数字和大小写字母随机组合（指定长度）
     * @DateTime: 2020/8/28 10:19
     * @param size 大小
     * @param length 长度
     * @Return: java.lang.String[]
     */
    public static String[] randomNumbersAndLowerUpcase(Integer length, Integer size) {
        return randomNumbersAndLowerUpcase(length,size,true);
    }

    /**
     * @Author: 王品峰
     * @Description: 数字和大小写字母随机组合（指定长度）
     * @DateTime: 2020/8/28 10:19
     * @param flag 是否允许重复；true允许重复
     * @param size 大小
     * @param length 长度
     * @Return: java.lang.String[]
     */
    public static String[] randomNumbersAndLowerUpcase(Integer length, Integer size, boolean flag) {
        Set<String> set = new HashSet<String>();
        List<String> list = new ArrayList<>();
        if (flag){
            while(list.size() < size){
                list.add(randomNumbersAndLowerUpcase(length));
            }
            return list.toArray(new String[list.size()]);
        }
        while(set.size() < size){
            set.add(randomNumbersAndLowerUpcase(length));
        }
        return set.toArray(new String[set.size()]);
    }

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
    public static String randomNumbers(Integer length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    /**
     * @Author: 王品峰
     * @Description: 随机生成纯数字（指定长度）
     * @DateTime: 2020/8/28 10:23
     * @param size 大小
     * @param length 长度
     * @Return: java.lang.String[]
     */
    public static String[] randomNumbers(Integer length, Integer size) {
        return randomNumbers(length,size,true);
    }

    /**
     * @Author: 王品峰
     * @Description: 随机生成纯数字（指定长度）
     * @DateTime: 2020/8/28 10:23
     * @param flag 是否允许重复；true允许重复
     * @param size 大小
     * @param length 长度
     * @Return: java.lang.String[]
     */
    public static String[] randomNumbers(Integer length, Integer size, boolean flag) {
        Set<String> set = new HashSet<String>();
        List<String> list = new ArrayList<String>();
        if (flag){
            while(list.size() < size){
                list.add(randomNumbers(length));
            }
            return list.toArray(new String[list.size()]);
        }
        while(set.size() < size){
            set.add(randomNumbers(length));
        }
        return set.toArray(new String[set.size()]);
    }

    /**
     * @Method: randomDate
     * @Description: 随机生成日期
     * @param
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/8/27 14:42
     * @Version:  1.0
     */
    public static String randomDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return randomDate("1970-01-01",format.format(new Date()));
    }

    /**
     * @Author: 王品峰
     * @Description: 随机生成日期
     * @DateTime: 2020/8/28 10:25
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @Return: java.lang.String
     */
    public static String randomDate(String startDate, String endDate) {
        try {
            Random random = new Random();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date start = format.parse(startDate);
            Date end = format.parse(endDate);
            if(start.getTime() >= end.getTime()){
                throw new Exception("开始时间需要小于结束时间");
            }
            long date = start.getTime() + (long)(Math.random() * (end.getTime() - start.getTime()));
            return format2.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Author: 王品峰
     * @Description: 随机生成日期
     * @DateTime: 2020/8/28 10:25
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @param size 大小
     * @Return: java.lang.String
     */
    public static String[] randomDate(String startDate, String endDate, Integer size) {
        return randomDate(startDate, endDate, size, true);
    }

    /**
     * @Author: 王品峰
     * @Description: 随机生成日期
     * @DateTime: 2020/8/28 10:25
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @param size 大小
     * @param flag true为可重复,false为不可重复
     * @Return: java.lang.String
     */
    public static String[] randomDate(String startDate, String endDate, Integer size, boolean flag) {
        Set<String> set = new HashSet<String>();
        List<String> list = new ArrayList<>();
        if (flag){
            while(list.size() < size){
                list.add(randomDate(startDate,endDate));
            }
            return list.toArray(new String[list.size()]);
        }
        while(set.size() < size){
            set.add(randomDate(startDate,endDate));
        }
        return set.toArray(new String[set.size()]);
    }

    /**
     * @Method: randomIDNumber
     * @Description: 随机生成身份证号码（不允许重复）
     * @param
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/8/27 15:08
     * @Version:  1.0
     */
    public static String randomIDNumber() {}

    public static String[] randomIDNumber(Integer size) {

    }

    /**
     * @Method: randomUserName
     * @Description: 随机生成中文名字（不允许重复）
     * @param
     * @Return: java.lang.String
     * @Author: chenlu
     * @Date 2020/8/27 15:13
     * @Version:  1.0
     */
    public static String randomUserName() {
        List<String> firstList = FileUtils.fileToList("com/wdkf/wdkfspringbootutils/random/name/firstname.txt");
        List<String> secondList = FileUtils.fileToList("com/wdkf/wdkfspringbootutils/random/name/secondname.txt");
        List<String> thirdList = FileUtils.fileToList("com/wdkf/wdkfspringbootutils/random/name/thirdname.txt");
        int randomFirst = new Random().nextInt(firstList.size());
        int secondRandom = new Random().nextInt(secondList.size());
        int thirdRandom = new Random().nextInt(thirdList.size());
        StringBuilder sb = new StringBuilder();
        return sb.append(firstList.get(randomFirst)).append(secondList.get(secondRandom)).append(thirdList.get(thirdRandom)).toString();
    }
    /**
     * @Method: randomUserName
     * @Description: 随机生成中文名字（不允许重复）
     * @param
     * @Return: java.lang.String
     * @Author: chenlu
     * @Date 2020/8/27 15:13
     * @Version:  1.0
     */
    public static String[] randomUserName(Integer size) {
        HashSet<String> hashSet = new HashSet<>();
        List<String> firstList = new FileUtils().fileToArray("com/wdkf/wdkfspringbootutils/random/name/firstname.txt");
        List<String> secondList = fileToArray("com/wdkf/wdkfspringbootutils/random/name/secondname.txt");
        List<String> thirdList = fileToArray("com/wdkf/wdkfspringbootutils/random/name/thirdname.txt");
        while(hashSet.size()<=size){
            int randomFirst = new Random().nextInt(firstList.size());
            int secondRandom = new Random().nextInt(secondList.size());
            int thirdRandom = new Random().nextInt(thirdList.size());
            StringBuilder sb = new StringBuilder();
            hashSet.add(sb.append(firstList.get(randomFirst)).append(secondList.get(secondRandom)).append(thirdList.get(thirdRandom)).toString());
        }
        return (String[])hashSet.toArray();
    }

}
