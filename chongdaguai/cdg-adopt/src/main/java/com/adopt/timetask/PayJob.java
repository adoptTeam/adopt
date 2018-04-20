package com.adopt.timetask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;

/**
 * @author huayu
 * @date 2018/4/20 上午9:30
 */
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
        try {
            int deleteCount = userService.deleteOrderByStatusAndCreatetime();
        } catch (Exception e) {
            System.out.println("定时任务：删除adopt_user_adopt表中待支付状态，且超过15分钟的数据 发生异常");
            e.printStackTrace();
        }

        //System.out.println("定时任务：删除adopt_user_adopt表中待支付状态，且超过15分钟的数据 结束");
    }
}
