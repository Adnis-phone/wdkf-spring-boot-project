package com.wdkf.wdkfspringbootautoconfigure.properties;

import lombok.Data;
import org.springframework.stereotype.Repository;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @ProjectName: wdkf-spring-boot-project
 * @Package: com.wdkf.wdkfspringbootautoconfigure.properties
 * @ClassName: WdkfLocalBean
 * @Description:
 * @Author: wangdehonga
 * @Date: 2020/8/4 17:21
 * @Version: 1.0
 */
@Data
@Repository
public class WdkfLocalBean {


    private String name;

    private String url;

    private String port;

    private String active;
}
