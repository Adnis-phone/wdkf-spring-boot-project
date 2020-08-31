package com.wdkf.wdkfspringbootautoconfigure.properties.print;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ProjectName: wdkf-spring-boot-project
 * @Package: com.wdkf.wdkfspringbootautoconfigure.config.printhost
 * @ClassName: HostConfig
 * @Description:
 * @Author: wangdehonga
 * @Date: 2020/8/19 17:27
 * @Version: 1.0
 */

//@ConfigurationProperties(prefix = "server")
@Data
@Repository
@ConfigurationProperties(prefix = "server")
public class HostConfig {
    private String url = InetAddress.getLocalHost().getHostAddress();

    private String port;
    private Servlet servlet;

    public HostConfig() throws UnknownHostException {
    }

    @Data
    public static class Servlet {

        private String contextPath;
    }
}
