package com.adopt.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author: fengyao
 * @date: 2018-04-16
 * @ver: 1.0
 * @desc: redis配置
 */
@Configuration
@EnableAutoConfiguration
public class RedisConfig {

    private static Logger logger = Logger.getLogger(RedisConfig.class);

    /**
     * 获取springboot配置文件的值 (get的时候获取)
     */
    @Value("${spring.redis.hostName}")
    private String host;

    @Value("${spring.redis.password}")
    private String password;


    /**
     * @return
     * @Bean 和 @ConfigurationProperties
     * 该功能在官方文档是没有提到的，我们可以把@ConfigurationProperties和@Bean和在一起使用。
     * 举个例子，我们需要用@Bean配置一个Config对象，Config对象有a，b，c成员变量需要配置，
     * 那么我们只要在yml或properties中定义了a=1,b=2,c=3，
     * 然后通过@ConfigurationProperties就能把值注入进Config对象中
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.redis.pool")
    public JedisPoolConfig getRedisConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        return config;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public JedisConnectionFactory getConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setUsePool(true);
        JedisPoolConfig config = getRedisConfig();
        factory.setPoolConfig(config);
        logger.info("JedisConnectionFactory bean init success.");
        return factory;
    }


    @Bean
    public RedisTemplate<?, ?> getRedisTemplate() {
        JedisConnectionFactory factory = getConnectionFactory();
        logger.info(this.host + "," + factory.getHostName() + "," + factory.getDatabase());
        logger.info(this.password + "," + factory.getPassword());
        logger.info(factory.getPoolConfig().getMaxIdle());
        RedisTemplate<?, ?> template = new StringRedisTemplate(getConnectionFactory());
        return template;
    }
}
