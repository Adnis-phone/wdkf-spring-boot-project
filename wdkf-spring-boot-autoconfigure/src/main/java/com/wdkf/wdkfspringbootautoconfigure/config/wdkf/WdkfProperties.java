package com.wdkf.wdkfspringbootautoconfigure.config.wdkf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Repository;

/**
 * @ProjectName: wdkf-spring-boot-starter
 * @Package: com.wdkf.wdkfspringbootautoconfigure.properties
 * @ClassName: WdkfProperties
 * @Description:
 * @Author: wangdehonga
 * @Date: 2020/8/3 11:15
 * @Version: 1.0
 */
@ConfigurationProperties(prefix = "wdkf.starter.v")
public class WdkfProperties {
    private boolean flag;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "WdkfProperties{" +
                "flag=" + flag +
                '}';
    }
}
