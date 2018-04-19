package com.adopt.system.controller;

import com.adopt.system.service.AddressService;
import com.cdg.common.utils.ServletUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author huayu
 * @date 2018/4/18 下午2:25
 */
@Controller
@RequestMapping("/system")
public class AddressController {
    @Autowired
    private AddressService addressService;

    /**
     * @description 查询地址
     * @param
     * @date 18:04 2017/11/25
     * @return
     * @author zhenghao
     */
    @RequestMapping(value = "/getAddress")
    @CrossOrigin
    public void getAddress(byte type, String par, HttpServletRequest req, HttpServletResponse res) {
        List<String> address = addressService.getAddress(type, par);
        ServletUtils.toJson(address, req, res);
    }

}
