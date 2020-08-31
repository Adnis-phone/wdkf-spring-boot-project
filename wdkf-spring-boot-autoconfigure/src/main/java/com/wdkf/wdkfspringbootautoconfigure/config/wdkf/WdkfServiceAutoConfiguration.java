package com.wdkf.wdkfspringbootautoconfigure.config.wdkf;

import com.wdkf.wdkfspringbootautoconfigure.properties.print.AppNameConfig;
import com.wdkf.wdkfspringbootautoconfigure.properties.print.HostConfig;
import com.wdkf.wdkfspringbootautoconfigure.properties.print.Profiles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: wdkf-spring-boot-starter
 * @Package: com.wdkf.wdkfspringbootautoconfigure.service
 * @ClassName: WdkfServiceAutoConfiguration
 * @Description:
 * @Author: wangdehonga
 * @Date: 2020/8/3 11:36
 * @Version: 1.0
 */
@Slf4j
@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties({AppNameConfig.class,HostConfig.class, Profiles.class})
@ConditionalOnClass({AppNameConfig.class,HostConfig.class, Profiles.class})
public class WdkfServiceAutoConfiguration implements CommandLineRunner {

    @Autowired
    private AppNameConfig appNameConfig;
    @Autowired
    private HostConfig hostConfig;
    @Autowired
    private Profiles profiles;

    @Override
    @ConditionalOnMissingBean
    public void run(String... args) throws Exception {
        System.out.println("----------------------------------------------------------");
        System.out.println("\tApplication '"+appNameConfig.getName()+"' is running! Access URLs:");
        System.out.println("\tLocal: \t\thttp://localhost:"+hostConfig.getPort()+hostConfig.getServlet().getContextPath());
        System.out.println("\tExternal: \thttp://"+hostConfig.getUrl()+":"+hostConfig.getPort()+hostConfig.getServlet().getContextPath());
        System.out.println("\tSwagger: \thttp://"+hostConfig.getUrl()+":"+hostConfig.getPort()+hostConfig.getServlet().getContextPath()+"/doc.html");
        System.out.println("\tProfile(s): \t\t["+profiles.getActive()+"]");
        System.out.println("----------------------------------------------------------");
    }


}
