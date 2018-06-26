package com.cdg.db.enhance.model;

import com.cdg.db.pet.model.AdoptComment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AdoptCommentViewModel extends AdoptComment{
    private String strCreateTime;

    public String getStrCreateTime(){
        return long2DateString(this.createTime);
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
