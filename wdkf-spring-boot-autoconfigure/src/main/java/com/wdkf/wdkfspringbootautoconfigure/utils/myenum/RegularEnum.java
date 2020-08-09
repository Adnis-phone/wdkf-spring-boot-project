package com.wdkf.wdkfspringbootautoconfigure.utils.myenum;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ProjectName: frist_dome
 * @Package: com.wdkf.wdkfspringbootautoconfigure.utils.myenum
 * @ClassName: RegularEnum
 * @Description: 正则表达式枚举
 * @Author: wangdehonga
 * @Date: 2020/7/16 10:46
 * @Version: 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum RegularEnum {

    /**
     * 身份证号码匹配正则表达式
     */
    REGULAR_EXPRESSION_OF_ID_CARD_NUMBER_MATCHING("IDNum", "^[1-9]\\\\d{5}(18|19|20)\\\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\\\d{3}[0-9Xx]$)|(^[1-9]\\\\d{5}\\\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\\\d{3}$"),

    /**
     * 电话号码匹配正则表达式
     */
    TELEPHONE_NUMBER_MATCHING_REGULAR_EXPRESSION("phoneNum", "0\\d{2,3}[-]?\\d{7,8}|0\\d{2,3}\\s?\\d{7,8}|13[0-9]\\d{8}|15[1089]\\d{8}"),

    /**
     * 邮箱地址匹配正则表达式
     */
    EMAIL_ADDRESS_MATCHING_REGULAR_EXPRESSION("Email", "^([a-z0-9A-Z]+[-|\\\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\\\.)+[a-zA-Z]{2,}$"),

    ;

    private String name;
    private String regular;


    public String getName() {
        return name;
    }

    public String getName(String regular) {
        RegularEnum[] all = values();
        for (RegularEnum regularEnum : all) {
            if (regular.equals(regularEnum.getRegular())) {
                return regularEnum.name;
            }
        }
        return null;
    }

    public String getRegular() {
        return regular;
    }

    public static String getRegular(String name) {
        RegularEnum[] all = values();
        for (RegularEnum regularEnum : all) {
            if (name.equals(regularEnum.getName()) || name == regularEnum.name) {
                return regularEnum.regular;
            }
        }
        return null;
    }
}
