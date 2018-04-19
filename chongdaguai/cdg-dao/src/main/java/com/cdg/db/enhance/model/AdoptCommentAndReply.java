package com.cdg.db.enhance.model;

import com.cdg.db.pet.model.AdoptComment;
import com.cdg.db.system.model.AdoptPlatformReply;
import com.cdg.db.user.model.AdoptUser;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: ALWZ
 * @create: 2018-01-12 14:43
 * @description: 评论及回复信息
 **/
public class AdoptCommentAndReply extends AdoptComment implements Serializable{
    private AdoptUser user;
    private String strPhone;
    private String strCommentCreateTime;
    private ReplyEntity reply;

    public String getStrPhone() {
        if(this.user.getPhone()!=null && this.user.getPhone()!="" && this.user.getPhone().length()==11){
            String phone=this.user.getPhone();
            strPhone=phone.substring(0,3)+"****"+phone.substring(7,11);
        }
        return strPhone;
    }

    public void setStrPhone(String strPhone) {
        this.strPhone = strPhone;
    }

    public AdoptUser getUser() {
        return user;
    }

    public void setUser(AdoptUser user) {
        this.user = user;
    }


    public String getStrCommentCreateTime() {
        strCommentCreateTime=long2DateString(this.getCreateTime());
        return strCommentCreateTime;
    }

    public void setStrCommentCreateTime(String strCommentCreateTime) {
        this.strCommentCreateTime = strCommentCreateTime;
    }

    public ReplyEntity getReply() {
        return reply;
    }

    public void setReply(ReplyEntity reply) {
        this.reply = reply;
    }

    /**
     * 日期转换工具：long转成日期格式  年月日时分秒
     * @param dateLong
     * @return
     */
    private String long2DateString(Long dateLong){
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date=new Date(dateLong);
        return sdf.format(date);
    }
}
