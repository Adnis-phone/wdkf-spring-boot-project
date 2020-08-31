package com.wdkf.wdkfspringbootautoconfigure.properties.print;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: wdkf-spring-boot-project
 * @Package: com.wdkf.wdkfspringbootautoconfigure.config.printhost
 * @ClassName: profiles
 * @Description:
 * @Author: wangdehonga
 * @Date: 2020/8/24 18:13
 * @Version: 1.0
 */
@Data
@Repository
@ConfigurationProperties(prefix = "spring.profiles")
public class Profiles {
    private String active;

}
