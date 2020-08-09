package com.wdkf.wdkfspringbootautoconfigure.utils.common;

import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: wdkf-spring-boot-starter
 * @Package: com.wdkf.wdkfspringbootautoconfigure.utils.common
 * @ClassName: UA
 * @Description:
 * @Author: wangdehonga
 * @Date: 2020/8/3 10:47
 * @Version: 1.0
 */
@Component
public class GetUA {

    /**
     * @param request
     * @Method: getUA
     * @Description: 获取请求来源，eg:ios-iphone,pc-Chrome
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/7/30 10:39
     * @Version: 1.0
     */
    public String getUA(HttpServletRequest request) {
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("user-agent"));
        String userAgents = userAgent.toString();
        String UA = null;
        //safari 5.1 – MAC
        if (userAgents.contains("SAFARI") && userAgents.contains("MAC_OS_X-SAFARI")) {
            UA = "safari(MAC)";
        }
        //safari 5.1 – Windows
        else if (userAgents.contains("SAFARI") && userAgents.contains("WINDOWS")) {
            UA = "safari(Windows)";
        }
        // IE
        else if (userAgents.contains("IE") && userAgents.contains("WINDOWS")) {
            UA = "IE";
        }
        // Firefox 4.0.1 – MAC
        else if (userAgents.contains("FIREFOX") && userAgents.contains("MAC_OS_X")) {
            UA = "Firefox(MAC)";
        }
        // Firefox 4.0.1 – Windows
        else if (userAgents.contains("FIREFOX") && userAgents.contains("WINDOWS")) {
            UA = "Firefox(Windows)";
        }
        // Opera 11.11 – MAC
        else if (userAgents.contains("OPERA") && userAgents.contains("MAC_OS_X")) {
            UA = "Opera(MAC)";
        }
        // Opera 11.11 – Windows
        else if (userAgents.contains("OPERA") && userAgents.contains("WINDOWS")) {
            UA = "Opera(Windows)";
        }
        // Chrome 17.0 – MAC
        else if (userAgents.contains("CHROME") && userAgents.contains("MAC_OS_X")) {
            UA = "Chrome(MAC)";
        }
        // Chrome 17.0 – Windows
        else if (userAgents.contains("CHROME") && userAgents.contains("WINDOWS")) {
            UA = "Chrome(Windows)";
        }
        //safari iOS – iPhone
        if (userAgents.contains("IPHONE-MOBILE")) {
            UA = "iPhone";
        }
        //safari iOS – iPad
        if (userAgents.contains("IPAD-MOBILE")) {
            UA = "iPad";
        }
        //Android
        if (userAgents.contains("ANDROID")) {
            UA = "Android";
        }
        return UA;
    }
}
