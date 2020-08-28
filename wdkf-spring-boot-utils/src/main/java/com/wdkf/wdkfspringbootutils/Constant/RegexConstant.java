package com.wdkf.wdkfspringbootutils.Constant;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 王品峰
 * @DateTime 2020/8/28 12:19
 * @Description
 */
@Slf4j
public class RegexConstant {
    /**
     * 验证数字
     */
    public static final String CHECK_NUMBER = "^[0-9]*$";

    /**
     *  验证标点符号
     */
    public static final String CHECK_PUNCTUATION = "[\\p{P}+~$`^=|<>～｀＄＾＋＝｜＜＞￥×\\s]";

    /**
     * 验证Email地址
     */
    public static final String CHECK_EMAIL = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";

    /**
     * 验证域名
     */
    public static final String CHECK_Domain_Name = "[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(/.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+/.?";

    /**
     * 验证URL
     */
    public static final String CHECK_URL = "[a-zA-z]+://[^\\s]*";

    /**
     * 验证手机号码
     */
    public static final String CHECK_PHONE_NUMBER = "^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$";
    /**
     * 验证强密码(8-16个字符，包含字母、数字和特殊字符,每种至少一个)
     */
    public static final String CHECK_PASSWORD = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[$@$!%*#?&])[A-Za-z\\d$@$!%*#?&]{8,16}$";
    /**
     * 验证日期格式 [2004-2-29], [2004-02-29 10:29:39 pm], [2004/12/31]
     */
    public static final String CHECK_DATE = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])| \n" +
            "   (3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9]))))) \n" +
            "   |(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9]) \n" +
            "   |(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[1-9])|(1[0-2]))\\:([0-5][0-9])((\\s)|(\\:([0-5][0-9])\\s))([AM|PM|am|pm]{2,2})))?$ ";
    /**
     * 验证首尾空白字符
     */
    public static final String CHECK_BLANK_CHAR = "^\\s*|\\s*$";

    /**
     * @Author: 王品峰
     * @Description:
     * @DateTime: 2020/8/28 16:12
     * @param str 需要判断的字符串
     * @param regex 正则表达式
     * @Return: java.lang.Boolean
     */
    public static Boolean checkString(String str,String regex){
        boolean flag = false;
        try{
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(str);
            flag = m.matches();
        }catch(Exception e){
            log.error("验证失败", e);
        }
        return flag;
    }
}
