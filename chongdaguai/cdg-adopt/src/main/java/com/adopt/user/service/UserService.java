package com.adopt.user.service;

import com.adopt.littlepet.model.LittlePetViewModel;
import com.adopt.user.model.AdoptInfo;
import com.cdg.common.exception.ToUserException;
import com.cdg.common.utils.ValidatorUtils;
import com.cdg.db.enhance.model.AdoptSearch;
import com.cdg.common.constant.RecordConstants;
import com.cdg.common.constant.StateConstants;
import com.cdg.common.enums.AdoptStateEnum;
import com.cdg.common.model.ResultList;
import com.cdg.common.utils.DateUtils;
import com.cdg.db.enhance.dao.NativeSqlMapper;
import com.cdg.db.pet.dao.AdoptLittlePetMapper;
import com.cdg.db.pet.model.AdoptLittlePet;
import com.cdg.db.pet.model.AdoptLittlePetExample;
import com.cdg.db.plugin.Page;
import com.cdg.db.system.dao.AdoptLogisticsInfoMapper;
import com.cdg.db.system.model.AdoptLogisticsInfo;
import com.cdg.db.user.dao.AdoptRecordMapper;
import com.cdg.db.user.dao.AdoptUserAddressMapper;
import com.cdg.db.user.dao.AdoptUserAdoptMapper;
import com.cdg.db.user.dao.AdoptUserMapper;
import com.cdg.db.user.model.*;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @author zhenghao
 * @description
 * @date 2017/12/8 21:08
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private AdoptRecordMapper adoptRecordMapper;
    @Autowired
    private AdoptLittlePetMapper littlePetMapper;
    @Autowired
    private AdoptUserMapper adoptUserMapper;
    @Autowired
    private AdoptLogisticsInfoMapper adoptLogisticsInfoMapper;
    @Autowired
    private AdoptUserAdoptMapper adoptUserAdoptMapper;
    @Autowired
    private NativeSqlMapper nativeSqlMapper;
    @Autowired
    private AdoptUserAddressMapper adoptUserAddressMapper;


    /**
     * @param
     * @return
     * @description 获得我的收藏
     * @date 19:30 2018/1/4
     * @author zhenghao
     */
    public ResultList getMyCollection(Long userId, Page page) {
        AdoptRecordExample example = new AdoptRecordExample();
        example.createCriteria().andUserIdEqualTo(userId).andRecordTypeEqualTo(RecordConstants.RECORD_TYPE_COLLECTION);
        example.setPage(page);
        example.setOrderByClause("create_time desc");
        List<AdoptRecord> adoptRecords = adoptRecordMapper.selectByExample(example);
        long count = adoptRecordMapper.countByExample(example);
        if (adoptRecords == null || adoptRecords.size() <= 0) {
            return null;
        }
        List<Long> petIds = new ArrayList<>();
        adoptRecords.forEach(record -> {
            petIds.add(record.getPetId());
        });
        AdoptLittlePetExample littlePetExample = new AdoptLittlePetExample();
        littlePetExample.createCriteria().andPetIdIn(petIds).andPetStateEqualTo(StateConstants.ENABLE_STATE);
        List<AdoptLittlePet> adoptLittlePets = littlePetMapper.selectByExample(littlePetExample);

        List<LittlePetViewModel> littlePetViewModelList = new ArrayList<>();
        adoptLittlePets.forEach(ap -> {
            LittlePetViewModel littlePetViewModel = new LittlePetViewModel(ap);
            littlePetViewModelList.add(littlePetViewModel);
        });
        ResultList resultList = new ResultList(count, littlePetViewModelList);
        return resultList;
    }

    /**
     * @param
     * @return
     * @description 获得我的收藏数量
     * @date 19:30 2018/1/4
     * @author cuiweilin
     */
    public Integer getMyCollectionCount(Long userId) {
        return nativeSqlMapper.getMyCollectionCount(userId);
    }

    /**
     * @param
     * @return
     * @description 获得我的浏览记录
     * @date 19:30 2018/1/4
     * @author zhenghao
     */
    public ResultList getMyBrowse(Long userId, Page page) {
        AdoptRecordExample example = new AdoptRecordExample();
        example.createCriteria().andUserIdEqualTo(userId).andRecordTypeEqualTo(RecordConstants.RECORD_TYPE_BROWSE);
        example.setPage(page);
        example.setOrderByClause("create_time desc");
        List<AdoptRecord> adoptRecords = adoptRecordMapper.selectByExample(example);
        long count = adoptRecordMapper.countByExample(example);
        if (adoptRecords == null || adoptRecords.size() <= 0) {
            return null;
        }
        List<Long> petIds = new ArrayList<>();
        adoptRecords.forEach(record -> {
            petIds.add(record.getPetId());
        });
        AdoptLittlePetExample littlePetExample = new AdoptLittlePetExample();
        littlePetExample.createCriteria().andPetIdIn(petIds).andPetStateEqualTo(StateConstants.ENABLE_STATE);
        List<AdoptLittlePet> adoptLittlePets = littlePetMapper.selectByExample(littlePetExample);
        List<LittlePetViewModel> littlePetViewModelList = new ArrayList<>();
        adoptLittlePets.forEach(ap -> {
            LittlePetViewModel littlePetViewModel = new LittlePetViewModel(ap);
            littlePetViewModelList.add(littlePetViewModel);
        });

        ResultList resultList = new ResultList(count, littlePetViewModelList);
        return resultList;
    }

    /**
     * @param
     * @return
     * @description 获得我的浏览记录数量
     * @date 19:30 2018/1/4
     * @author cuiweilin
     */
    public long getMyBrowseCount(Long userId) {
        TreeSet<String> result = new TreeSet<>();
        AdoptRecordExample example = new AdoptRecordExample();
        example.createCriteria().andUserIdEqualTo(userId).andRecordTypeEqualTo(RecordConstants.RECORD_TYPE_BROWSE);
        List<AdoptRecord> list = adoptRecordMapper.selectByExample(example);
        for (AdoptRecord item : list) {
            result.add(String.valueOf(item.getPetId()));
        }
        return Long.valueOf(result.size());
    }

    /**
     * @param
     * @return
     * @description 根据用户id获取我的领养的信息
     * @date 2018年1月7日23:05:13
     * @author cuiweilin
     */
    public AdoptInfo getAdoptInfoByUserId(Long userid) {
        AdoptInfo adoptInfo = new AdoptInfo();
        AdoptLittlePet adoptLittlePet = null;
        //AdoptUser user = null;
        AdoptUserAddress adoptUserAddress = null;
        List<AdoptLogisticsInfo> adoptLogisticsInfos = null;

        try {
            adoptUserAddress = nativeSqlMapper.selectUserAddressByUserId(userid);
            adoptLittlePet = getLittlePetByUserId(userid);


            adoptLogisticsInfos = nativeSqlMapper.selectLogisticsByUserId(userid);
            AdoptUserAdopt adoptUserAdopt = getOrderByUserId(userid);
            //备注信息
            if (null != adoptUserAdopt && null != adoptUserAdopt.getCommentContent()) {
                adoptInfo.setCommentContent(adoptUserAdopt.getCommentContent());
            } else {
                adoptInfo.setCommentContent("");
            }

            if (adoptUserAdopt != null &&
                    AdoptStateEnum.EXPERIENCING.getValue() == adoptUserAdopt.getAdoptState()) {
                int dayCount = DateUtils.getDaysDiff(System.currentTimeMillis(), adoptUserAdopt.getUpdateTime());
                if (dayCount > 30) {
                    adoptInfo.setAdoptDays(30);
                } else {
                    adoptInfo.setAdoptDays(dayCount);
                }
            } else if (adoptUserAdopt != null &&
                    AdoptStateEnum.INIT.getValue() == adoptUserAdopt.getAdoptState()) {
                long disToNow = 15 * 60 - (System.currentTimeMillis() - adoptUserAdopt.getCreateTime()) / 1000;
                long min = disToNow / 60;
                long sec = disToNow % 60;
                if (min < 0) {
                    adoptInfo.setDisToNowMin(0L);
                } else {
                    adoptInfo.setDisToNowMin(min);
                }
                if (sec == 0) {
                    adoptInfo.setDisToNowMin(min - 1);
                    adoptInfo.setDisToNowSec(60L);
                } else {
                    adoptInfo.setDisToNowSec(sec);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //adoptInfo.setUser(user);
        adoptInfo.setAdoptLittlePet(adoptLittlePet);
        adoptInfo.setAdoptLogisticsInfos(adoptLogisticsInfos);
        adoptInfo.setAdoptUserAddress(adoptUserAddress);
        return adoptInfo;
    }

    /**
     * 根据用户id查询用户信息
     *
     * @param userid
     * @return
     */
    public AdoptUser getUserByUserId(Long userid) {
        return adoptUserMapper.selectByPrimaryKey(userid);
    }

    /**
     * 根据userid 获取小乖信息
     *
     * @param userId
     * @return
     */
    public AdoptLittlePet getLittlePetByUserId(Long userId) {
        //log.info("获取小乖信息");

        AdoptLittlePet adoptLittlePet = new AdoptLittlePet();
        List<AdoptLittlePet> adoptLittlePets = nativeSqlMapper.selectPetByUserId(userId);
        if (adoptLittlePets != null && adoptLittlePets.size() > 0) {
            adoptLittlePet = adoptLittlePets.get(0);
            adoptLittlePet.setBirthday(Long.valueOf(DateUtils.getMonthsDiff(
                    System.currentTimeMillis(), adoptLittlePet.getBirthday())));
        }
        return adoptLittlePet;
    }

    /**
     * 根据小乖的生日获取小乖的年龄
     *
     * @param birthday
     * @return
     */
    public String getPetAge(Long birthday) {
        String age = "";
        if (null == birthday) {
            return "0";
        }
        int months = DateUtils.getYearsDiff(
                System.currentTimeMillis(), birthday);
        age = months / 12 + "岁" + months % 12 + "个月";
        return age;
    }

    /**
     * 从体验中修改为已退还的状态
     *
     * @param adoptId   id
     * @param newStatus 新状态
     * @param oldStatus 旧状态
     * @return
     */
    public boolean updateStatus(Long adoptId, Byte newStatus, Byte oldStatus) {
        AdoptUserAdoptExample example = new AdoptUserAdoptExample();
        AdoptUserAdopt adoptUserAdopt = new AdoptUserAdopt();
        example.createCriteria().andAdoptIdEqualTo(adoptId).andAdoptStateEqualTo(oldStatus);
        adoptUserAdopt.setAdoptState(newStatus);
        adoptUserAdopt.setUpdateTime(System.currentTimeMillis());
        return adoptUserAdoptMapper.updateByExampleSelective(adoptUserAdopt, example) > 0;
    }

    /**
     * 根据userid查询订单
     *
     * @param userId
     * @return
     */
    public AdoptUserAdopt getOrderByUserId(Long userId) {
        AdoptUserAdoptExample example = new AdoptUserAdoptExample();
        example.createCriteria().andUserIdEqualTo(userId).andAdoptStateNotEqualTo(AdoptStateEnum.DELETED.getValue());
        List<AdoptUserAdopt> list = adoptUserAdoptMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 删除出时间为创建时间 <now() -15分钟且status = 代支付数据
     *
     * @return
     */
    public int deleteOrderByStatusAndCreatetime() {
        Long time = System.currentTimeMillis() - 1000 * 60 * 15;
        AdoptUserAdoptExample example = new AdoptUserAdoptExample();
        AdoptUserAdopt adoptUserAdopt = new AdoptUserAdopt();
        example.createCriteria().andAdoptStateEqualTo(AdoptStateEnum.INIT.getValue())
                .andCreateTimeLessThanOrEqualTo(time);
        adoptUserAdopt.setAdoptState(AdoptStateEnum.DELETED.getValue());
        return adoptUserAdoptMapper.updateByExampleSelective(adoptUserAdopt, example);
    }

    /**
     * 后台页面搜索
     *
     * @param adoptSearch
     * @return
     */
    public List<AdoptUserAdopt> selectAdoptByAdoptSearch(AdoptSearch adoptSearch) {
        if (!ValidatorUtils.isEmpty(adoptSearch.getAddressName())) {
            adoptSearch.setAddressName("%" + adoptSearch.getAddressName() + "%");
        }
        if (!ValidatorUtils.isEmpty(adoptSearch.getAddressPhone())) {
            adoptSearch.setAddressPhone("%" + adoptSearch.getAddressPhone() + "%");
        }

        return nativeSqlMapper.selectAdoptByAdoptSearch(adoptSearch);
    }

    /**
     * 根据userid获取用户信息
     *
     * @param userId
     * @return
     */
    public AdoptUser getUserInfoByUserId(Long userId) {
        return adoptUserMapper.selectByPrimaryKey(userId);
    }

    /**
     * @param
     * @return
     * @description 立即领养
     * @date 14:20 2018/2/6
     * @author zhenghao
     */
    public void nowAdopt(Long userId, AdoptUserAdopt adoptUserAdopt) {
        AdoptUserAdoptExample example = new AdoptUserAdoptExample();
        example.createCriteria().andUserIdEqualTo(userId).andAdoptStateNotEqualTo(AdoptStateEnum.DELETED.getValue());
        List<AdoptUserAdopt> adoptUserAdopts = adoptUserAdoptMapper.selectByExample(example);
        if (adoptUserAdopts != null && adoptUserAdopts.size() > 0) {
            throw new ToUserException("主人，小乖不能重复领养");
        }
        adoptUserAdopt.setUserId(userId);
        adoptUserAdopt.setCreateTime(System.currentTimeMillis());
        adoptUserAdopt.setUpdateTime(System.currentTimeMillis());
        adoptUserAdopt.setAdoptState((byte) 10);
        adoptUserAdoptMapper.insertSelective(adoptUserAdopt);
    }
}
