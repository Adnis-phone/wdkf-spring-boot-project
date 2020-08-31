package com.wdkf.wdkfspringbootautoconfigure.properties.print;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

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
@Repository
@ConfigurationProperties(prefix = "spring.application")
public class AppNameConfig {

    private String name;
}