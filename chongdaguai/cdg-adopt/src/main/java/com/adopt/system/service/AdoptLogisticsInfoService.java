package com.adopt.system.service;

import com.cdg.common.enums.AdoptStateEnum;
import com.cdg.common.utils.ValidatorUtils;
import com.cdg.db.system.dao.AdoptLogisticsInfoMapper;
import com.cdg.db.system.model.AdoptLogisticsInfo;
import com.cdg.db.system.model.AdoptLogisticsInfoExample;
import com.cdg.db.user.dao.AdoptUserAdoptMapper;
import com.cdg.db.user.model.AdoptUserAdopt;
import com.cdg.db.user.model.AdoptUserAdoptExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author huayu
 * @date 2018/4/18 下午2:27
 */
@Service
public class AdoptLogisticsInfoService {
    @Autowired
    private AdoptLogisticsInfoMapper adoptLogisticsInfoMapper;
    @Autowired
    private AdoptUserAdoptMapper adoptUserAdoptMapper;
    @Autowired
    private CashInfoService cashInfoService;

    /**
     * 增加一条数据
     *
     * @param adoptLogisticsInfo
     */
    @Transactional
    public boolean insert(AdoptLogisticsInfo adoptLogisticsInfo) {
        try{
            AdoptUserAdoptExample adoptUserAdoptExample = new AdoptUserAdoptExample();
            adoptUserAdoptExample.createCriteria().andAdoptIdEqualTo(adoptLogisticsInfo.getAdoptId());
            AdoptUserAdopt adoptUserAdopt = new AdoptUserAdopt();
            if(adoptLogisticsInfo.getLogisticsContent().contains("已到达")){
                adoptUserAdoptExample.createCriteria().andAdoptStateEqualTo(AdoptStateEnum.SENDING.getValue());
                adoptUserAdopt.setAdoptState(AdoptStateEnum.EXPERIENCING.getValue());
                adoptUserAdoptMapper.updateByExampleSelective(adoptUserAdopt,adoptUserAdoptExample);
            }else if(adoptLogisticsInfo.getLogisticsContent().contains("已返还")){
                adoptUserAdoptExample.createCriteria().andAdoptStateEqualTo(AdoptStateEnum.APPLY_REFUND.getValue());
                adoptUserAdopt.setAdoptState(AdoptStateEnum.REFUNDED.getValue());
                String description="体验退还";
                byte state=2; //已退还
                cashInfoService.insert(adoptLogisticsInfo.getAdoptId(),state,description,"");
                adoptUserAdoptMapper.updateByExampleSelective(adoptUserAdopt,adoptUserAdoptExample);
            }

            adoptLogisticsInfo.setUpdateTime(System.currentTimeMillis());
            adoptLogisticsInfo.setCreateTime(System.currentTimeMillis());
            return adoptLogisticsInfoMapper.insertSelective(adoptLogisticsInfo) > 0;
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 根据id删除数据
     *
     * @param logisticsId
     */
    @Transactional
    public boolean deleteByLogisticsId(Long logisticsId) {
        return adoptLogisticsInfoMapper.deleteByPrimaryKey(logisticsId) > 0;
    }

    /**
     * 根据id修改数据
     *
     * @param logisticsId
     */
    @Transactional
    public boolean updateContentByLogisticsId(Long logisticsId,String content) {
        try{
            AdoptLogisticsInfoExample example = new AdoptLogisticsInfoExample();
            example.createCriteria().andLogisticsIdEqualTo(logisticsId);
            AdoptLogisticsInfo adoptLogisticsInfo = new AdoptLogisticsInfo();
            adoptLogisticsInfo.setLogisticsContent(content);
            adoptLogisticsInfo.setUpdateTime(System.currentTimeMillis());
            return adoptLogisticsInfoMapper.updateByExampleSelective(adoptLogisticsInfo, example) > 0;
        }catch (Exception e){
            throw e;
        }
    }

    /**
     * 根据adoptId查询数据
     *
     * @param adoptId
     * @return
     */
    public List<AdoptLogisticsInfo> selectByAdoptIdAndContent(Long adoptId, String content) {
        AdoptLogisticsInfoExample example = new AdoptLogisticsInfoExample();
        AdoptLogisticsInfoExample.Criteria criteria = example.createCriteria();
        if(!ValidatorUtils.isEmpty(content)){
            criteria.andLogisticsContentLike("%" + content + "%");
        }
        if(!ValidatorUtils.isNull(adoptId)){
            criteria.andAdoptIdEqualTo(adoptId);
        }

        return adoptLogisticsInfoMapper.selectByExample(example);
    }
}
