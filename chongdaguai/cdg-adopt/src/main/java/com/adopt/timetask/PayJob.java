/*
 * Copyright (C) 2016-2020 jindan.com Corporation
 *
 */
package com.adopt.timetask;

import com.adopt.user.service.UserService;
import com.cdg.db.user.model.AdoptUserAdopt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 代支付任务
 *
 * @author cuiweilin.
 */
@Component
public class PayJob {
    @Autowired
    private UserService userService;
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

    /**
     * 查询adopt_user_adopt表中待支付状态，且超过15分钟的数据
     */
    @Scheduled(cron = "*/30 * * * * ?")
    public void dueToPay() {
        //System.out.println("定时任务：删除adopt_user_adopt表中待支付状态，且超过15分钟的数据 开始");
        try{
            int deleteCount = userService.deleteOrderByStatusAndCreatetime();
        }catch (Exception e){
            System.out.println("定时任务：删除adopt_user_adopt表中待支付状态，且超过15分钟的数据 发生异常");
            e.printStackTrace();
        }

        //System.out.println("定时任务：删除adopt_user_adopt表中待支付状态，且超过15分钟的数据 结束");
    }
}
