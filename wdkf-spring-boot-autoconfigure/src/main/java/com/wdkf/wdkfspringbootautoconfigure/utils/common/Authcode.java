package com.wdkf.wdkfspringbootautoconfigure.utils.common;

import com.wdkf.wdkfspringbootautoconfigure.utils.myenum.MyException;
import com.wdkf.wdkfspringbootautoconfigure.utils.myenum.ReturnMsg;
import com.wdkf.wdkfspringbootautoconfigure.utils.redis.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * @ProjectName: wdkf-spring-boot-starter
 * @Package: com.wdkf.wdkfspringbootautoconfigure.utils.common
 * @ClassName: Authcode
 * @Description:
 * @Author: wangdehonga
 * @Date: 2020/8/3 10:47
 * @Version: 1.0
 */
@Slf4j
@Component
public class Authcode {

    @Autowired
    private RedisUtil redisUtil;

    public Authcode() {
    }

    /**
     * @param object
     * @Method: getAuthCode
     * @Description: 1、生成token
     * 2、将token与用户信息存入Redis
     * @Return: java.lang.String
     * @Author: wangdehonga
     * @Date 2020/7/29 20:07
     * @Version: 1.0
     */
    public String getAuthCode(Object object, HttpServletRequest request) {
        String totilToken = null;
        GetMyToken getMyToken = new GetMyToken();
        Map<String, Object> map = new ObjectToMap().getKeyAndValue(object);
        String userId = Optional.ofNullable(map.get("userId").toString()).orElse(null);
        String ua = Optional.ofNullable(new GetUA().getUA(request)).orElse(null);
        String token = Optional.ofNullable(new GetMyToken().getToken()).orElse(null);
        totilToken = userId + ":"
                + ua + ":"
                + token;
        //check缓存是否存在
        Set<String> keys = redisUtil.getKeysList(userId + ":" + ua + "*");
        if (!CollectionUtils.isEmpty(keys)) {
            redisUtil.del(keys);
        }
        //存储用户信息
        log.info("开始存储用户信息（有效期 30 min）。。。");
        if (!redisUtil.set(totilToken, map, 1800)) {
            throw new MyException(ReturnMsg.USER_INFORMATION_STORAGE_CACHE_FAILED);
        }
        return token;
    }
}
