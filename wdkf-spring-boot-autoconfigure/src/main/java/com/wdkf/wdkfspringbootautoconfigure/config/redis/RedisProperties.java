package com.wdkf.wdkfspringbootautoconfigure.config.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: wdkf-spring-boot-project
 * @Package: wdkf.wdkfspringbootredisautoconfigure.config
 * @ClassName: RedisProperties
 * @Description:
 * @Author: wangdehonga
 * @Date: 2020/8/8 11:45
 * @Version: 1.0
 */
@ConfigurationProperties("wdkf.starter.redis")
@Data
@Component
public class RedisProperties {

    private String host;

    private int port;

    private String pass;

    private int db;

    private Config config;

}
