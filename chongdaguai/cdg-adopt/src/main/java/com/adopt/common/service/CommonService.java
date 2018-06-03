package com.adopt.common.service;

import com.adopt.util.RedisHelper;
import com.cdg.common.constant.RedisConstants;
import com.cdg.common.utils.JsonUtils;
import com.cdg.db.user.model.AdoptUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: fengyao
 * @date: 2018-04-16
 * @ver: 1.0
 * @desc: 公共Service
 */
@Service
public class CommonService {

    @Autowired
    private RedisHelper redisHelper;

    /**
     * 将用户信息放在redis中
     * @param token
     * @param adoptUser
     */
    public void setUserInfo(String token, AdoptUser adoptUser) {
        String key = String.format("%s:%s", RedisConstants.ADOPT_USER_TOKEN_KEY, token);
        String userJson = JsonUtils.writeValue(adoptUser);
        redisHelper.set(key, userJson, RedisConstants.ADOPT_USER_TOKEN_TIME_KEY);
    }

    /**
     * 根据token 获得用户信息
     * @param token
     * @return
     */
    public AdoptUser getUserInfo(String token) {
        String key = String.format("%s:%s", RedisConstants.ADOPT_USER_TOKEN_KEY, token);
        String userJson = redisHelper.get(key);
        AdoptUser adoptUser = JsonUtils.readValue(userJson, AdoptUser.class);
        return adoptUser;
    }
}
