package com.wdkf.wdkfspringbootautoconfigure.config.wdkf;

import com.wdkf.wdkfspringbootautoconfigure.properties.WdkfLocalBean;
import com.wdkf.wdkfspringbootautoconfigure.service.WdkfService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ProjectName: wdkf-spring-boot-starter
 * @Package: com.wdkf.wdkfspringbootautoconfigure.service
 * @ClassName: WdkfServiceAutoConfiguration
 * @Description:
 * @Author: wangdehonga
 * @Date: 2020/8/3 11:36
 * @Version: 1.0
 */
@Slf4j
@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(WdkfProperties.class)
@ConditionalOnClass(WdkfLocalBean.class)
public class WdkfServiceAutoConfiguration {

    @Autowired(required = false)
    private WdkfLocalBean wdkfLocalBean;



    @Bean
    public WdkfService wdkfService() {
        WdkfService service = new WdkfService();
        service.setWdkfLocalBean(wdkfLocalBean);
        return service;
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "wdkf.starter.v", name = "flag", havingValue = "true")
    public WdkfLocalBean defaultWdkfLocalBean(WdkfProperties wdkfProperties) {
        WdkfLocalBean wdkfLocalBean = new WdkfLocalBean();
        wdkfLocalBean.setFlag(wdkfProperties.isFlag());
        if(wdkfProperties.isFlag()) {
            log.info("---------------------------------------框架版本：v0.1.0---------------------------------------");
            log.info("版本说明：当前版本暂不支持用户请求头Token验证！");
            log.info("支持统一日志打印。。。");
            log.info("支持统一异常处理。。。");
            log.info("支持统一返回包装。。。");
            log.info("---------------------------------------框架版本：v0.1.0---------------------------------------");
        }
        return wdkfLocalBean;
    }

    @Bean
    @ConditionalOnMissingBean
    public WdkfService Service () {
        return new WdkfService();
    }
}
