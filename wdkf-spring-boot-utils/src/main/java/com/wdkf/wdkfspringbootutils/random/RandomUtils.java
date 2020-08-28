package com.wdkf.wdkfspringbootutils.random;

import lombok.extern.slf4j.Slf4j;

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
     * @Description: 传递随机大小写，falg :0小写，1大写，2大小写
     * @DateTime: 2020/8/27 16:33
     * @Params: [length, ascil]
     * @Return: java.lang.String
     */
    private String randomNumberAndCase(Integer length,Integer flag){
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
     * flag：是否允许重复；true允许重复
     * @param length
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/8/27 14:34
     * @Version:  1.0
     */
    public String randomNumbersAndLowercase(Integer length) {
        return randomNumberAndCase(length,0);
    }

    public String[] randomNumbersAndLowercase(Integer length, Integer size) {
        return randomNumbersAndLowercase(length,size,true);
    }

    public String[] randomNumbersAndLowercase(Integer length, Integer size, boolean flag) {
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
    public String randomNumbersAndUpcase(Integer length) {
        return randomNumberAndCase(length,1);
    }

    public String[] randomNumbersAndUpcase(Integer length, Integer size) {
        return randomNumbersAndUpcase(length,size,true);
    }

    public String[] randomNumbersAndUpcase(Integer length, Integer size, boolean flag) {
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
    public String randomNumbersAndLowerUpcase(Integer length) {
        return randomNumberAndCase(length,2);
    }

    public String[] randomNumbersAndLowerUpcase(Integer length, Integer size) {
        return randomNumbersAndLowerUpcase(length,size,true);
    }

    public String[] randomNumbersAndLowerUpcase(Integer length, Integer size, boolean flag) {
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
    public String randomNumbers(Integer length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public String[] randomNumbers(Integer length, Integer size) {
        return randomNumbers(length,size,true);
    }

    public String[] randomNumbers(Integer length, Integer size, boolean flag) {
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

    private static long random(long begin,long end){
        long rtn = begin + (long)(Math.random() * (end - begin));
        if(rtn == begin || rtn == end){
            return random(begin,end);
        }
        return rtn;
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
    public String randomDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return randomDate("1970-01-01",format.format(new Date()));
    }

    public String randomDate(String startDate, String endDate) {
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
            return format.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String[] randomDate(String startDate, String endDate, Integer size) {
        return randomDate(startDate, endDate, size, true);
    }

    public String[] randomDate(String startDate, String endDate, Integer size, boolean flag) {
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
    public String randomIDNumber() {}

    public String[] randomIDNumber(Integer size) {

    }

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
