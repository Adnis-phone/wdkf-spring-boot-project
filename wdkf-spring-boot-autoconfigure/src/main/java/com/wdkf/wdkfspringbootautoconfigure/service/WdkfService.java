package com.wdkf.wdkfspringbootautoconfigure.service;

import com.wdkf.wdkfspringbootautoconfigure.properties.WdkfLocalBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ProjectName: wdkf-spring-boot-starter
 * @Package: com.wdkf.wdkfspringbootautoconfigure.service
 * @ClassName: WdkfService
 * @Description:
 * @Author: wangdehonga
 * @Date: 2020/8/3 11:34
 * @Version: 1.0
 */
public class WdkfService {

    @Autowired
    private WdkfLocalBean wdkfLocalBean;

    public WdkfLocalBean getWdkfLocalBean() {
        return wdkfLocalBean;
    }

    public void setWdkfLocalBean(WdkfLocalBean wdkfLocalBean) {
        this.wdkfLocalBean = wdkfLocalBean;
    }
}
