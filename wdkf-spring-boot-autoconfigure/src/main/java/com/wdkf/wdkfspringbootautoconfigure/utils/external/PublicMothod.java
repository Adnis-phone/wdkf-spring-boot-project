package com.wdkf.wdkfspringbootautoconfigure.utils.external;

import com.wdkf.wdkfspringbootautoconfigure.utils.common.Authcode;
import com.wdkf.wdkfspringbootautoconfigure.utils.thread.AgentThreadLocal;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @ProjectName: wdkf-spring-boot-starter
 * @Package: com.wdkf.wdkfspringbootautoconfigure.utils.external
 * @ClassName: PublicMothod
 * @Description:
 * @Author: wangdehonga
 * @Date: 2020/8/3 11:06
 * @Version: 1.0
 */
public class PublicMothod implements PublicInterface {
    @Autowired
    private Authcode authcode;

    @Override
    public Map<String, Object> getUser() {
        return AgentThreadLocal.get();
    }

    @Override
    public String getAuthCode(Object object, HttpServletRequest request) {
        return authcode.getAuthCode(object,request);
    }
}
