package com.adopt.wxpay.service;

import com.cdg.db.cash.dao.AdoptCashInfoMapper;
import com.cdg.db.cash.model.AdoptCashInfo;
import com.cdg.db.cash.model.AdoptCashInfoExample;
import com.mysql.jdbc.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author:whp
 * @Description:
 * @Date:2018/2/6 22:43
 */
@Service
public class CashInfoService {
    @Autowired
    private AdoptCashInfoMapper adoptCashInfoMapper;

    public void insert(long adoptId,byte amountState,String description,String reson) {
        try{
            AdoptCashInfo adoptCashInfo=new AdoptCashInfo();
            adoptCashInfo.setAmount(new BigDecimal(300));
            adoptCashInfo.setAdoptId(adoptId);
            adoptCashInfo.setAmountState(amountState);
            adoptCashInfo.setDescription(description);
            adoptCashInfo.setCreateTime(System.currentTimeMillis());
            if(StringUtils.isNullOrEmpty(reson)){
                adoptCashInfo.setRemarks(reson);
            }
            int flag= adoptCashInfoMapper.insertSelective(adoptCashInfo);
            System.out.println(flag);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<AdoptCashInfo> getPersonCashInfoByAdoptId(Long adoptId) {
        AdoptCashInfoExample example=new AdoptCashInfoExample();
        example.or().andAdoptIdEqualTo(adoptId);
        example.setOrderByClause("create_time desc");
        List<AdoptCashInfo> adoptCashInfoList=adoptCashInfoMapper.selectByExample(example);
        return adoptCashInfoList;
    }
}
