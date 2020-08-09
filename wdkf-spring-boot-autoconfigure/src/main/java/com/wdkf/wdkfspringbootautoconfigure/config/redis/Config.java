package com.wdkf.wdkfspringbootautoconfigure.config.redis;

import lombok.Data;

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

    private String timeout;
    private int maxTotal;
    private int maxIdle;
    private int maxWaitMillis;
    private String minEvictableIdleTimeMillis;
    private int numTestsPerEvictionRun;
    private String timeBetweenEvictionRunsMillis;
    private Boolean testOnBorrow;
    private Boolean testWhileIdle;

}
