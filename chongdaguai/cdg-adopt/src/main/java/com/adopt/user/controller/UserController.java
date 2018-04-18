package com.adopt.user.controller;

import com.cdg.common.model.ResultList;

import com.adopt.common.controller.BaseController;

import com.adopt.common.service.CommonService;

import com.adopt.user.model.AdoptInfo;
import com.adopt.user.service.UserService;
import com.adopt.utils.RedisHelper;
import com.adopt.wxpay.service.CashInfoService;
import com.cdg.common.enums.AdoptStateEnum;
import com.cdg.common.exception.ToUserException;
import com.cdg.common.model.ResultList;
import com.cdg.common.utils.ServletUtils;
import com.cdg.common.utils.ValidatorUtils;
import com.cdg.db.enhance.model.AdoptSearch;
import com.cdg.db.pet.model.AdoptLittlePet;
import com.cdg.db.plugin.Page;
import com.cdg.db.user.model.AdoptUser;
import com.cdg.db.user.model.AdoptUserAdopt;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @description
 * @param
 * @date 21:17 2018/04/18
 * @return
 * @author hemingguang
 */

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private RedisHelper redisHelper;

    @Autowired
    private UserService userService;

    @Autowired
    private CashInfoService cashInfoService;

    @Autowired
    private CommonService commonService;

    /**
     * @description 获得我的收藏
     * @param
     * @date 19:09 2018/4/18
     * @return
     * @author hemingguang
     */
    @RequestMapping("/getMyCollection")
    @CrossOrigin
    public void getMyCollection(HttpServletRequest req, HttpServletResponse res, Page page){

        String token = req.getHeader("token");
        if(StringUtils.isBlank(token)){
            throw new ToUserException("无效token");
        }
        AdoptUser user = commonService.getUserInfo(token);
        if(user == null){
            throw new ToUserException("无效token");
        }
        ResultList myCollection = userService.getMyCollection(user.getUserId(),page);
        ServletUtils.toJson(myCollection,req,res);

    }


    /**
     * @description 获得我的浏览
     * @param
     * @date 19:09 2018/4/18
     * @return
     * @author hemingguang
     */
    @RequestMapping("/getMyBrowse")
    @CrossOrigin
    public void getMyBrowse(HttpServletRequest req, HttpServletResponse res, Page page){

        AdoptUser user = getUser(req);
        ResultList myCollection = userService.getMyBrowse(user.getUserId(),page);

        ServletUtils.toJson(myCollection,req,res);

    }

    /**
     * @description 获取领养信息
     * @param
     * @return
     * @author hemingguang
     */
    @RequestMapping("/getAdoptInfoByUserId")
    @CrossOrigin
    public void getAdoptInfoByUserId(HttpServletRequest req, HttpServletResponse res){
        AdoptUser user = getUser(req);
        AdoptInfo adoptInfo = userService.getAdoptInfoByUserId(user.getUserId());
        ServletUtils.toJson(adoptInfo,req,res);
    }

    /**
     * @description 根据查询条件获取领养信息
     * @param
     * @return
     * @author hemingguang
     */
    @RequestMapping("/selectAdoptByAdoptSearch")
    @CrossOrigin
    public void selectAdoptByAdoptSearch(HttpServletRequest req, HttpServletResponse res){
        AdoptSearch adoptSearch = new AdoptSearch();
        adoptSearch.setAddressName(getParameter(req,"addressName"));
        adoptSearch.setAddressPhone(getParameter(req,"addressPhone"));
        String adoptState = getParameter(req,"adoptState");
        if(!ValidatorUtils.isEmpty(adoptState)){
            adoptSearch.setAdoptState(Byte.valueOf(adoptState));
        }
        adoptSearch.setNickname(getParameter(req,"nickname"));
        adoptSearch.setRealName(getParameter(req,"realName"));
        List<AdoptUserAdopt> list = userService.selectAdoptByAdoptSearch(adoptSearch);
        ServletUtils.toJson(list,req,res);
    }

    /**
     * 获取参数
     * @param req
     * @param fieldName
     * @return
     */
    private String getParameter(HttpServletRequest req,String fieldName){
        String fieldValue = req.getParameter(fieldName);
        if(null == fieldValue || "".equals(fieldValue) || "null".equals(fieldValue)){
            return null;
        }
        return fieldValue.trim();
    }

    /**
     * @description 获取用户信息
     * @param
     * @return
     * @author hemingguang
     */
    @RequestMapping("/getUserByUserId")
    @CrossOrigin
    public void getUserByUserId(HttpServletRequest req, HttpServletResponse res){
        JSONObject result = new JSONObject();
        AdoptUser user = getUser(req);
        //AdoptUser user = userService.getUserByUserId(2L);
        Integer myCollectionCount = userService.getMyCollectionCount(user.getUserId());
        Long myBrowseCount = userService.getMyBrowseCount(user.getUserId());
        result.put("user",user);
        result.put("myCollectionCount",myCollectionCount);
        result.put("myBrowseCount",myBrowseCount);
        ServletUtils.toJson(result,req,res);
    }

    /**
     * @description 获取领养信息
     * @param
     * @return
     * @author hemingguang
     */
    @RequestMapping("/getOrderByUserId")
    @CrossOrigin
    public void getOrderByUserId(HttpServletRequest req, HttpServletResponse res){
        AdoptUser user = getUser(req);
        AdoptUserAdopt adoptUserAdopt = userService.getOrderByUserId(user.getUserId());
        ServletUtils.toJson(adoptUserAdopt,req,res);
    }

    /**
     * @description 获取小乖信息
     * @param
     * @return
     * @author hemingguang
     */
    @RequestMapping("/getPetByUserId")
    @CrossOrigin
    public void getPetByUserId(HttpServletRequest req, HttpServletResponse res){
        AdoptUser user = getUser(req);
        AdoptLittlePet adoptLittlePet = userService.getLittlePetByUserId(user.getUserId());

        ServletUtils.toJson(adoptLittlePet,req,res);
    }

    /**
     * @description 申请退还信息
     * @param
     * @return
     * @author hemingguang
     */
    @RequestMapping("/applyRefund")
    @CrossOrigin
    public void applyRefund(HttpServletRequest req, HttpServletResponse res){
        AdoptUser user = getUser(req);
        AdoptUserAdopt adoptInfo = userService.getOrderByUserId(user.getUserId());
        Boolean result = userService.updateStatus(adoptInfo.getAdoptId(),
                AdoptStateEnum.APPLY_REFUND.getValue(),AdoptStateEnum.EXPERIENCING.getValue());
        String description=getParameter(req,"refundReason");
        byte state=2; //已退还
        String reason="领养时间到";
        cashInfoService.insert(adoptInfo.getAdoptId(),state,description,reason);
        ServletUtils.toJson(result,req,res);
    }

    /**
     * @description 取消付款
     * @param
     * @return
     * @author hemingguang
     */
    @RequestMapping("/cancelAdopt")
    @CrossOrigin
    public void cancelAdopt(HttpServletRequest req, HttpServletResponse res){
        AdoptUser user = getUser(req);
        AdoptUserAdopt adoptInfo = userService.getOrderByUserId(user.getUserId());
        Boolean result = userService.updateStatus(adoptInfo.getAdoptId(),
                AdoptStateEnum.DELETED.getValue(),AdoptStateEnum.INIT.getValue());
        ServletUtils.toJson(result,req,res);
    }

    /**
     * @description 立即领养
     * @param
     * @return
     * @author hemingguang
     */
    @RequestMapping("/nowAdopt")
    @CrossOrigin
    public void nowAdopt(HttpServletRequest req, HttpServletResponse res,AdoptUserAdopt adoptUserAdopt){
        AdoptUser user = getUser(req);
        userService.nowAdopt(user.getUserId(),adoptUserAdopt);
        ServletUtils.toJson(req,res);
    }

    /**
     * 从request中获取token
     * @param req
     * @return
     */
    private AdoptUser getUser(HttpServletRequest req){
        String redisToken = req.getHeader("token");
        AdoptUser user = commonService.getUserInfo(redisToken);
        return user;
    }



}
