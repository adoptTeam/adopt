package com.adopt.login.controller;

import com.adopt.common.controller.BaseController;
import com.adopt.common.service.CommonService;
import com.adopt.login.service.LoginService;
import com.cdg.common.utils.ServletUtils;
import com.cdg.db.user.model.AdoptUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhenghao
 * @description
 * @date 2018/1/4 19:43
 */
@Api(value = "登录模块")
//@RestController
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController{
    @Autowired
    private LoginService loginService;
    @Autowired
    private CommonService commonService;
    /**
      * @description 登录
      * @param
      * @date 20:17 2018/1/4
      * @return
      * @author zhenghao
    */
    @ApiOperation(value = "登录",notes = "登录")
    @RequestMapping("/userLogin")
    @CrossOrigin
    public String userLogin(HttpServletRequest req, HttpServletResponse res,String code){
        AdoptUser adoptUser = new AdoptUser();
        adoptUser = loginService.userLogin(code);
        String redisToken=loginService.generateToken();
        commonService.setUserInfo(redisToken,adoptUser);
        return "redirect:http://adopt.chongxiaoguai.com/homepage.html?redisToken="+redisToken;
    }
}
