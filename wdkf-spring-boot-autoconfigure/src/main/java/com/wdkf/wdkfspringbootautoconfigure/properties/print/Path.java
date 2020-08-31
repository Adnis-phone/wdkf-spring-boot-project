package com.wdkf.wdkfspringbootautoconfigure.properties.print;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: wdkf-spring-boot-project
 * @Package: com.wdkf.wdkfspringbootautoconfigure.properties.print
 * @ClassName: Path
 * @Description:
 * @Author: wangdehonga
 * @Date: 2020/8/31 16:08
 * @Version: 1.0
 */
@Data
@Repository
@ConfigurationProperties(prefix = "server.servlet")
public class Path {


}
