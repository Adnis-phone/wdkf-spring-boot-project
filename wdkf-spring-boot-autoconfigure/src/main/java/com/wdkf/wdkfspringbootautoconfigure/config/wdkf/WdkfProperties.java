package com.wdkf.wdkfspringbootautoconfigure.config.wdkf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ProjectName: wdkf-spring-boot-starter
 * @Package: com.wdkf.wdkfspringbootautoconfigure.properties
 * @ClassName: WdkfProperties
 * @Description:
 * @Author: wangdehonga
 * @Date: 2020/8/3 11:15
 * @Version: 1.0
 */
@Data
@ConfigurationProperties(prefix = "wdkf.starter.v")
public class WdkfProperties {
    private boolean flag;

    private String name;

    private String url = InetAddress.getLocalHost().getHostAddress();

    private String port;

    public WdkfProperties() throws UnknownHostException {
    }
}
