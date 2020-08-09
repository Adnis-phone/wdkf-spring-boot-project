package com.wdkf.wdkfspringbootautoconfigure.utils.external;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ProjectName: wdkf-spring-boot-starter
 * @Package: com.wdkf.wdkfspringbootautoconfigure.utils.external
 * @ClassName: PublicInterface
 * @Description:
 * @Author: wangdehonga
 * @Date: 2020/8/3 10:45
 * @Version: 1.0
 */
public interface PublicInterface {

    Map<String, Object> getUser();

    String getAuthCode(Object object, HttpServletRequest request);
}
