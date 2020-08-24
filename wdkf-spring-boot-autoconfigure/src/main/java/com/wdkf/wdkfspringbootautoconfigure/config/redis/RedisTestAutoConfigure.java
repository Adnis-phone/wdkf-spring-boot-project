package com.wdkf.wdkfspringbootautoconfigure.config.redis;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @ProjectName: wdkf-spring-boot-project
 * @Package: wdkf.wdkfspringbootredisautoconfigure.config
 * @ClassName: RedisTestAutoConfigure
 * @Description:
 * @Author: wangdehonga
 * @Date: 2020/8/8 11:47
 * @Version: 1.0
 */
@Configuration
@ConditionalOnClass(RedisProperties.class)
@ConditionalOnWebApplication
@EnableConfigurationProperties(RedisProperties.class)
public class RedisTestAutoConfigure {

    @Autowired
    private RedisProperties redisProperties;

    @Bean
    @ConditionalOnMissingBean(RedisConnectionFactory.class)
    public RedisConnectionFactory taskConnectionFactory() {
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setPort(redisProperties.getPort());
        connectionFactory.setHostName(redisProperties.getHost());
        connectionFactory.setDatabase(redisProperties.getDb());
        connectionFactory.setPassword(redisProperties.getPass());

        //配置连接池属性
        connectionFactory.setTimeout(Integer.parseInt(redisProperties.getConfig().getTimeout()));
        connectionFactory.getPoolConfig().setMaxIdle(redisProperties.getConfig().getMaxIdle());
        connectionFactory.getPoolConfig().setMaxTotal(redisProperties.getConfig().getMaxTotal());
        connectionFactory.getPoolConfig().setMaxWaitMillis(redisProperties.getConfig().getMaxWaitMillis());
        connectionFactory.getPoolConfig().setMinEvictableIdleTimeMillis(Integer.parseInt(redisProperties.getConfig().getMinEvictableIdleTimeMillis()));
        connectionFactory.getPoolConfig().setNumTestsPerEvictionRun(redisProperties.getConfig().getNumTestsPerEvictionRun());
        connectionFactory.getPoolConfig().setTimeBetweenEvictionRunsMillis(Integer.parseInt(redisProperties.getConfig().getTimeBetweenEvictionRunsMillis()));
        connectionFactory.getPoolConfig().setTestOnBorrow(redisProperties.getConfig().getTestOnBorrow());
        connectionFactory.getPoolConfig().setTestWhileIdle(redisProperties.getConfig().getTestWhileIdle());

        return connectionFactory;
    }

    @Bean
    @ConditionalOnMissingBean(RedisTemplate.class)
    public RedisTemplate<String, Object> redisTemplate() {
        RedisSerializer stringSerializer = new GenericFastJsonRedisSerializer();
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        redisTemplate.setConnectionFactory(taskConnectionFactory());
        return redisTemplate;
    }
}
