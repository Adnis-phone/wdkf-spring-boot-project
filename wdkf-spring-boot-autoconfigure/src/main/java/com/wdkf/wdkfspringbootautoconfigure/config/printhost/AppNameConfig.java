package com.wdkf.wdkfspringbootautoconfigure.config.printhost;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: wdkf-spring-boot-project
 * @Package: com.wdkf.wdkfspringbootautoconfigure.config.printhost
 * @ClassName: hostConfig
 * @Description:
 * @Author: wangdehonga
 * @Date: 2020/8/19 17:24
 * @Version: 1.0
 */
//@ConfigurationProperties(prefix = "spring.application")
@Data
@Component
public class AppNameConfig {

    @Value("spring.application.name")
    private String name;
}