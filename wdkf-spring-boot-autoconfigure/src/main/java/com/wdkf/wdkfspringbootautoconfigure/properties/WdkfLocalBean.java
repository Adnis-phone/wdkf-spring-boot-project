package com.wdkf.wdkfspringbootautoconfigure.properties;

import org.springframework.stereotype.Repository;

/**
 * @ProjectName: wdkf-spring-boot-project
 * @Package: com.wdkf.wdkfspringbootautoconfigure.properties
 * @ClassName: WdkfLocalBean
 * @Description:
 * @Author: wangdehonga
 * @Date: 2020/8/4 17:21
 * @Version: 1.0
 */
@Repository
public class WdkfLocalBean {
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
