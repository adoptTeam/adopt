package com.adopt.littlepet.controller;

import com.adopt.common.service.CommonService;
import com.adopt.littlepet.service.CommentService;
import com.cdg.common.exception.ToUserException;
import com.cdg.common.utils.ServletUtils;
import com.cdg.db.enhance.model.AdoptCommentAndReply;
import com.cdg.db.enhance.model.AdoptCommentViewModel;
import com.cdg.db.enhance.model.ReplyEntity;
import com.cdg.db.pet.model.AdoptComment;
import com.cdg.db.user.model.AdoptUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author huayu
 * @date 2018/4/17 下午9:10
 */
@RestController
@RequestMapping("/littlePet")
@Api(value = "评论模块")
public class AdoptCommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private CommonService commonService;

    /**
    * @Author:huayu
    * @Description:根据petId获取相关评论及相关的店家回复
    * @Date: 2018/4/17
    * @Time:下午9:16
    */
    @RequestMapping(value = "/getCommentAndReplyByPetId", method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value = "根据petId获取相关评论及相关的店家回复", notes = "根据petId获取相关评论及相关的店家回复", httpMethod = "POST")
    @CrossOrigin
    public void getCommentAndReplyByPetId(HttpServletRequest req, HttpServletResponse res) {
        String id=req.getParameter("petId");
        if (StringUtils.isEmpty(id)) {
            ServletUtils.toJson(req, res);
        }
        Long petId = Long.valueOf(id);
        List<AdoptCommentAndReply> resList = new ArrayList<>();
        try {
            resList = commentService.getAllCommentsByPetId(petId);
        } catch (Exception ex) {
            System.out.println("查询失败");
        }
        ServletUtils.toJson(resList, req, res);
    }
    /**
    * @Author:huayu
    * @Description:添加评论
    * @Date: 2018/4/17
    * @Time:下午9:16
    */
    @RequestMapping(value = "/addComment", method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value = "添加评论", notes = "添加评论", httpMethod = "POST")
    @CrossOrigin
    public void addComment(HttpServletRequest req, HttpServletResponse res, HttpSession session) {

        String petId = req.getParameter("petId");
        String commentContent = req.getParameter("commentContent");
        String redisToken = req.getHeader("token");
        AdoptUser user = commonService.getUserInfo(redisToken);
        if( user == null){
            throw new ToUserException("无效token信息");
        }
        long uId=user.getUserId();
        AdoptComment comment = new AdoptComment();
        comment.setUserId(uId);
        comment.setUserNickname(user.getNickname());
        comment.setPetId(Long.valueOf(petId));
        comment.setCommentContent(commentContent);
        comment.setCreateTime(System.currentTimeMillis());
        comment.setUpdateTime(System.currentTimeMillis());
        boolean flag = commentService.addComment(comment);
        ServletUtils.toJson(flag, req, res);
    }

    /**
    * @Author:huayu
    * @Description:添加评论
    * @Date: 2018/4/17
    * @Time:下午9:17
    */
    @RequestMapping(value = "/selectComment", method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value = "获取所有未被回复的评论信息", notes = "获取所有未被回复的评论信息", httpMethod = "POST")
    @CrossOrigin
    public void selectComment(HttpServletRequest req, HttpServletResponse res) {
        List<AdoptCommentViewModel> comments = commentService.selectComment();
        ServletUtils.toJson(comments, req, res);
    }

    /**
    * @Author:huayu
    * @Description:添加评论
    * @Date: 2018/4/17
    * @Time:下午9:17
    */
    @RequestMapping(value = "/addReply", method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value = "添加店家回复", notes = "添加店家回复", httpMethod = "POST")
    @CrossOrigin
    public void addReply(HttpServletRequest req, HttpServletResponse res) {
        String commentId=req.getParameter("commentId");
        String replyContent=req.getParameter("replyContent");
        if(StringUtils.isBlank(commentId) || StringUtils.isBlank(replyContent)){
            ServletUtils.toJson(false, req, res);
        }
        ReplyEntity replyEntity=new ReplyEntity();
        replyEntity.setReplyContent(replyContent);
        replyEntity.setCommentId(Long.valueOf(commentId));
        replyEntity.setReplyTime(System.currentTimeMillis());
        replyEntity.setReplyUpTime(System.currentTimeMillis());
        boolean flag=commentService.addReply(replyEntity);
        ServletUtils.toJson(flag, req, res);
    }
}
