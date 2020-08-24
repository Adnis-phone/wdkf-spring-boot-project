//package com.wdkf.wdkfspringbootautoconfigure.config.wdkf;
//
//import com.wdkf.wdkfspringbootautoconfigure.config.printhost.AppNameConfig;
//import com.wdkf.wdkfspringbootautoconfigure.config.printhost.HostConfig;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
///**
// * @ProjectName: wdkf-spring-boot-project
// * @Package: com.wdkf.wdkfspringbootautoconfigure.config.wdkf
// * @ClassName: CommandLineRunnerImpl
// * @Description:
// * @Author: wangdehonga
// * @Date: 2020/8/19 17:35
// * @Version: 1.0
// */
//@Component
//public class CommandLineRunnerImpl implements CommandLineRunner {
//
//    @Autowired(required = false)
//    private AppNameConfig appNameConfig;
//
//    @Autowired(required = false)
//    private HostConfig hostConfig;
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println("----------------------------------------------------------");
//        System.out.println("\tApplication '"+appNameConfig.getName()+"' is running! Access URLs:");
//        System.out.println("\tLocal: \t\thttp://localhost:"+hostConfig.getPort());
//        System.out.println("\tExternal: \thttp://"+hostConfig.getUrl()+":"+hostConfig.getPort());
//        System.out.println("----------------------------------------------------------");
//    }
//}
