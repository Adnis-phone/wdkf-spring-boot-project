package com.wdkf.wdkfspringbootautoconfigure.properties.redis;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: wdkf-spring-boot-project
 * @Package: wdkf.wdkfspringbootredisautoconfigure.config
 * @ClassName: config
 * @Description:
 * @Author: wangdehonga
 * @Date: 2020/8/8 11:44
 * @Version: 1.0
 */
@Data
public class Config {

    private String timeout = "10000";
    private int maxTotal = 100;
    private int maxIdle = 10;
    private int maxWaitMillis = 100000;
    private String minEvictableIdleTimeMillis = "60000";
    private int numTestsPerEvictionRun = -1;
    private String timeBetweenEvictionRunsMillis = "30000";
    private Boolean testOnBorrow = true;
    private Boolean testWhileIdle = true;

}
