package com.adopt.system.controller;

import com.adopt.system.service.AdoptLogisticsInfoService;
import com.cdg.common.utils.ServletUtils;
import com.cdg.common.utils.ValidatorUtils;
import com.cdg.db.system.model.AdoptLogisticsInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author huayu
 * @date 2018/4/18 下午2:26
 */
@Controller
@RequestMapping("/logistics")
public class AdoptLogisticsInfoController {
    @Autowired
    private AdoptLogisticsInfoService adoptLogisticsInfoService;

    /**
     * 增加一条物流信息
     * @param req
     * @param res
     */
    @RequestMapping(value = "/insert")
    @CrossOrigin
    public void insert(HttpServletRequest req, HttpServletResponse res) {
        String id = req.getParameter("adoptId");
        String content = req.getParameter("content");
        AdoptLogisticsInfo adoptLogisticsInfo = new AdoptLogisticsInfo();
        if (!ValidatorUtils.isEmpty(id)) {
            adoptLogisticsInfo.setAdoptId(Long.valueOf(id));
        }
        if (!ValidatorUtils.isEmpty(content)) {
            adoptLogisticsInfo.setLogisticsContent(content);
        }
        Boolean result = adoptLogisticsInfoService.insert(adoptLogisticsInfo);
        ServletUtils.toJson(result, req, res);
    }

    /**
     * 根据id删除信息
     * @param req
     * @param res
     */
    @RequestMapping(value = "/deleteByLogisticsId")
    @CrossOrigin
    public void deleteByLogisticsId(HttpServletRequest req, HttpServletResponse res) {
        boolean result = false;
        String logisticsId = req.getParameter("logisticsId");
        if (!ValidatorUtils.isEmpty(logisticsId)) {
            result = adoptLogisticsInfoService.deleteByLogisticsId(Long.valueOf(logisticsId));
        }
        ServletUtils.toJson(result, req, res);
    }

    /**
     * 根据id修改内容
     * @param req
     * @param res
     */
    @RequestMapping(value = "/updateContentById")
    @CrossOrigin
    public void updateContentById(HttpServletRequest req, HttpServletResponse res){
        boolean result = false;
        String logisticsId = req.getParameter("logisticsId");
        String content = req.getParameter("content");
        if (!ValidatorUtils.isEmpty(logisticsId)) {
            result = adoptLogisticsInfoService.updateContentByLogisticsId(Long.valueOf(logisticsId),content);
        }
        ServletUtils.toJson(result, req, res);
    }

    /**
     * 根据id修改内容
     * @param req
     * @param res
     */
    @RequestMapping(value = "/selectByAdoptIdAndContent")
    @CrossOrigin
    public void selectByAdoptIdAndContent(HttpServletRequest req, HttpServletResponse res){
        Long adoptIdLong = null;
        String adoptId = req.getParameter("adoptId").trim();
        String content = req.getParameter("content").trim();
        if(!ValidatorUtils.isEmpty(adoptId)){
            adoptIdLong = Long.valueOf(adoptId);
        }
        List<AdoptLogisticsInfo> result = adoptLogisticsInfoService.selectByAdoptIdAndContent(adoptIdLong,content);
        ServletUtils.toJson(result, req, res);
    }
}
