package com.adopt.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import redis.clients.jedis.exceptions.JedisConnectionException;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author: fengyao
 * @date: 2018-04-16
 * @ver: 1.0
 * @desc: redis工具类
 */
@Component
public class RedisHelper {

    private static Logger log = Logger.getLogger(RedisConfig.class);
    /**
     * :
     */
    private final static String COLON = ":";

    /**
     * 文字列模版
     */
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 存在性判断
     *
     * @param key key
     * @return true: 存在 false: 不存在
     */
    public boolean exists(String key) {
        try {
            return redisTemplate.hasKey(key);
        } catch (JedisConnectionException e) {
            log.error(e.getMessage(), e);
            return false;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    /**
     * 获取key值(String, String)
     *
     * @param key key
     * @return key值
     */
    public String get(String key) {
        try {
            return redisTemplate.opsForValue().get(key);
        } catch (JedisConnectionException e) {
            log.error(e.getMessage(), e);
            return "";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "";
        }
    }

    /**
     * 设置key值(String, String)
     *
     * @param key   key
     * @param value String
     */
    public void set(String key, String value) {
        try {
            redisTemplate.opsForValue().set(key, value);
        } catch (JedisConnectionException e) {
            log.error(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 设置key值(String, String)
     *
     * @param key     key
     * @param value   String
     * @param timeout 时效时间
     */
    public void set(String key, String value, long timeout) {
        try {
            redisTemplate.opsForValue().set(key, value);
            redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
        } catch (JedisConnectionException e) {
            log.error(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 获取key值(String, Object)
     *
     * @param key   键
     * @param clazz 对象
     * @return key值
     */
    public <T> T get(String key, Class<T> clazz) {
        try {
            String str = redisTemplate.opsForValue().get(key);
            return JSON.parseObject(str, clazz);
        } catch (JedisConnectionException e) {
            log.error(e.getMessage(), e);
            return null;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 获取key值(String, type)
     *
     * @param key  键
     * @param type 对象
     * @return key值
     */
    public <T> T get(String key, TypeReference<T> type) {
        try {
            String str = redisTemplate.opsForValue().get(key);
            return JSON.parseObject(str, type);
        } catch (JedisConnectionException e) {
            log.error(e.getMessage(), e);
            return null;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 设置key值(String, Object)
     *
     * @param key 键
     * @param obj 对象
     */
    public void set(String key, Object obj) {
        try {
            redisTemplate.opsForValue().set(key, JSON.toJSONString(obj));
        } catch (JedisConnectionException e) {
            log.error(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 设置key值(String, Object)
     *
     * @param key     键
     * @param obj     对象
     * @param timeout 时效时间
     */
    public void set(String key, Object obj, long timeout) {
        try {
            redisTemplate.opsForValue().set(key, JSON.toJSONString(obj), timeout);
        } catch (JedisConnectionException e) {
            log.error(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 设置自增值(String, Object)
     *
     * @param key 键
     */
    public Long incr(String key) {
        try {
            return redisTemplate.opsForValue().increment(key, 1L);
        } catch (JedisConnectionException e) {
            log.error(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 设置自增值(String, Object)
     *
     * @param key 键
     * @param obj 对象
     */
    public void incr(String key, Long obj) {
        try {
            redisTemplate.opsForValue().increment(key, obj);
        } catch (JedisConnectionException e) {
            log.error(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Hash: 添加值
     *
     * @param key   键
     * @param field Hash键
     * @param value 对象
     */
    public void hset(String key, String field, String value) {
        try {
            redisTemplate.opsForHash().put(key, field, value);
        } catch (JedisConnectionException e) {
            log.error(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * Hash: 获取所有值
     *
     * @param key 键
     * @return Map对象
     */
    public Map<Object, Object> entries(String key) {
        try {
            return redisTemplate.opsForHash().entries(key);
        } catch (JedisConnectionException e) {
            log.error(e.getMessage(), e);
            return null;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * Hash: 获取指定field值
     *
     * @param key   键
     * @param field Hash键
     * @return Map对象
     */
    public String hget(String key, String field) {
        try {
            Object result = redisTemplate.opsForHash().get(key, field);
            if (result != null) {
                return result.toString();
            } else {
                return "";
            }
        } catch (JedisConnectionException e) {
            log.error(e.getMessage(), e);
            return "";
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "";
        }
    }

    /**
     * Hash: 删除指定key的字段值
     *
     * @param key   键
     * @param field Hash键
     * @return Map对象
     */
    public void hdel(String key, String field) {
        try {
            Object result = redisTemplate.opsForHash().delete(key, field);
        } catch (JedisConnectionException e) {
            log.error(e.getMessage(), e);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 组合键
     *
     * @param prefix 前缀
     * @param key    键
     * @return 结果
     */
    public String join(String prefix, String key) {
        StringBuffer sb = new StringBuffer();
        sb.append(prefix);
        sb.append(COLON);
        sb.append(key);
        return sb.toString();
    }

    /**
     * 组合键
     *
     * @param keys 数组
     * @return 结果
     */
    public String join(String... keys) {
        StringBuffer sb = new StringBuffer();
        for (String str : keys) {
            if (Objects.equals(str, "")) {
                continue;
            }
            sb.append(str);
            sb.append(COLON);
        }
        String result = sb.toString();
        return result.substring(0, result.length() - 1);
    }
}