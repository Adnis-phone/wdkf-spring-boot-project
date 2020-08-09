package com.wdkf.wdkfspringbootautoconfigure.utils.redis;

import lombok.Data;

import java.util.Map;

/**
 * @ProjectName: frist_dome
 * @Package: com.wdkf.wdkfspringbootautoconfigure.utils.redis.common
 * @ClassName: RedisUserInfoDTO
 * @Description: Redis交互实体
 * @Author: wangdehonga
 * @Date: 2020/7/14 15:29
 * @Version: 1.0
 */
@Data
public class RedisUserInfoDTO {
    private String token;

    private Map<String, Object> map;
}
