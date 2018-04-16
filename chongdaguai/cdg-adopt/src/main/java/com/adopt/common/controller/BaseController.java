package com.adopt.common.controller;

import com.adopt.common.service.CommonService;
import com.cdg.common.exception.ToUserException;
import com.cdg.db.user.model.AdoptUser;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: fengyao
 * @date: 2018-04-16
 * @ver: 1.0
 * @desc: 公共Controller
 */
public class BaseController {

    @Autowired
    private CommonService commonService;

    /**
     * 获得用户Id
     * @param req
     * @return
     */
    public AdoptUser getUserInfo(HttpServletRequest req) {
        String token = req.getHeader("token");
        if (token == null) {
            throw new ToUserException("token不能为空");
        }
        AdoptUser userInfo = commonService.getUserInfo(token);
        return userInfo;
    }
}
