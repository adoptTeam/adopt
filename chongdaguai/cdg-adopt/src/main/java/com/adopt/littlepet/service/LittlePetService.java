package com.adopt.littlepet.service;

import com.adopt.littlepet.model.LittlePetViewModel;
import com.cdg.common.constant.RecordConstants;
import com.cdg.common.constant.StateConstants;
import com.cdg.common.model.ResultList;
import com.cdg.db.enhance.dao.AdoptPetDao;
import com.cdg.db.pet.dao.AdoptLittlePetMapper;
import com.cdg.db.pet.model.AdoptLittlePet;
import com.cdg.db.pet.model.AdoptLittlePetExample;
import com.cdg.db.plugin.Page;
import com.cdg.db.user.dao.AdoptRecordMapper;
import com.cdg.db.user.dao.AdoptUserAdoptMapper;
import com.cdg.db.user.model.AdoptRecord;
import com.cdg.db.user.model.AdoptRecordExample;
import com.cdg.db.user.model.AdoptUserAdopt;
import com.cdg.db.user.model.AdoptUserAdoptExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.*;

/**
 * @author huayu
 * @date 2018/4/18 下午2:10
 */
@Service
public class LittlePetService {
    @Autowired
    private AdoptLittlePetMapper petDao;
    @Autowired
    private AdoptRecordMapper recordDao;
    @Autowired
    private AdoptPetDao adoptPetDao;
    @Autowired
    private AdoptUserAdoptMapper userAdoptMapper;
    /**
     *  首页查询 小乖列表
     * @param content
     * @param page
     * @return
     */
    public ResultList getLittlePetList(String content, Page page) {
        AdoptLittlePetExample example = new AdoptLittlePetExample();
        example.setPage(page);
        if (StringUtils.isNotEmpty(content)) {
            example.or().andNameLike("%" + content + "%").andPetStateEqualTo(StateConstants.ENABLE_STATE);
            example.or().andPetTellLike("%" + content + "%").andPetStateEqualTo(StateConstants.ENABLE_STATE);
            example.or().andCommentLike("%" + content + "%").andPetStateEqualTo(StateConstants.ENABLE_STATE);
        }
        List<AdoptLittlePet> adoptLittlePets = petDao.selectByExample(example);
        long count = petDao.countByExample(example);
        List<LittlePetViewModel> littlePetViewModelList = new ArrayList<>();
        adoptLittlePets.forEach(alp -> {
            LittlePetViewModel littlePetViewModel = new LittlePetViewModel(alp);
            littlePetViewModelList.add(littlePetViewModel);
        });
        ResultList resultList = new ResultList(count, littlePetViewModelList);
        return resultList;
    }

    /**
     * 首页查询 小乖列表
     * @param content
     * @return
     */
    public ResultList selectLittlePetList(String content) {
        AdoptLittlePetExample example = new AdoptLittlePetExample();
        if (StringUtils.isNotEmpty(content)) {
            example.or().andNameLike("%" + content + "%").andPetStateEqualTo(StateConstants.ENABLE_STATE);
            example.or().andPetTellLike("%" + content + "%").andPetStateEqualTo(StateConstants.ENABLE_STATE);
            example.or().andCommentLike("%" + content + "%").andPetStateEqualTo(StateConstants.ENABLE_STATE);
        }
        List<AdoptLittlePet> adoptLittlePets = petDao.selectByExample(example);
        long count = petDao.countByExample(example);
        List<LittlePetViewModel> littlePetViewModelList = new ArrayList<>();

        adoptLittlePets.forEach(alp -> {
            if (getUserAdoptByPetId(alp.getPetId()) == null) {
                LittlePetViewModel littlePetViewModel = new LittlePetViewModel(alp);
                littlePetViewModelList.add(littlePetViewModel);
            }
        });

        ResultList resultList = new ResultList(littlePetViewModelList.size(), littlePetViewModelList);
        return resultList;
    }

    public AdoptUserAdopt getUserAdoptByPetId(Long petId) {
        AdoptUserAdoptExample example = new AdoptUserAdoptExample();
        example.createCriteria().andPetIdEqualTo(petId);
        List<AdoptUserAdopt> adoptUserAdoptList = userAdoptMapper.selectByExample(example);
        if (adoptUserAdoptList == null || adoptUserAdoptList.size() <= 0) {
            return null;
        }
        if (adoptUserAdoptList.get(0).getAdoptState() == (byte) 60
                || adoptUserAdoptList.get(0).getAdoptState() == (byte) 70) {

            return null;
        }
        return adoptUserAdoptList.get(0);
    }
    /**
     * 添加小乖信息
     * @param pet
     * @return
     */
    public boolean addPetInfo(AdoptLittlePet pet) {
        pet.setUpdateTime(System.currentTimeMillis());
        pet.setCreateTime(System.currentTimeMillis());
        pet.setBrowseCount(0);
        pet.setHeadPortraits(null);
        return petDao.insert(pet) > 0;
    }
    /**
     * 更新小乖信息
     * @param pet
     * @return
     */
    public boolean updatePetInfo(AdoptLittlePet pet) {
        if (pet.getPetId() == null) {
            return false;
        }
        return petDao.updateByPrimaryKey(pet) > 0;
    }
    /**
     * 更新小乖信息部分信息
     * @param pet
     * @return
     */
    @Transactional
    public boolean updatePetPartInfo(AdoptLittlePet pet) {
        if (pet.getPetId() == null) {
            return false;
        }
        return petDao.updateByPrimaryKeySelective(pet) > 0;
    }
    /**
     * 删除小乖信息
     * @param petId
     * @return
     */
    public boolean delPetInfo(Long petId) {
        if (petId == null) {
            return false;
        }
        return petDao.deleteByPrimaryKey(petId) > 0;
    }
    /**
     * 根据petId查询小乖信息
     * @param petId
     * @return
     */
    public AdoptLittlePet queryPetInfoByPetId(long petId) {
        return petDao.selectByPrimaryKey(petId);
    }

    /**
     * 根据条件查询宠物信息 :名称，性别，生日，体重，是否节育，所在地
     * @param pet
     * @return
     */
    public List<AdoptLittlePet> queryPetInfoByCondition(AdoptLittlePet pet) {
        AdoptLittlePetExample example = new AdoptLittlePetExample();
        if (StringUtils.isNotBlank(pet.getName())) {
            example.createCriteria().andNameEqualTo(pet.getName());
        }
        if (pet.getSex() != null) {
            example.createCriteria().andSexEqualTo(pet.getSex());
        }
        if (pet.getBirthday() != null) {
            example.createCriteria().andBirthdayEqualTo(pet.getBirthday());
        }
        if (pet.getWeight() != null) {
            example.createCriteria().andWeightEqualTo(pet.getWeight());
        }
        if (pet.getBirthControl() != null) {
            example.createCriteria().andBirthControlEqualTo(pet.getBirthControl());
        }
        if (StringUtils.isNotBlank(pet.getLocation())) {
            example.createCriteria().andLocationEqualTo(pet.getLocation());
        }
        return petDao.selectByExample(example);
    }
    /**
     * 获取收藏状态，如果有值，去index（0）
     * @param userId
     * @param petId
     * @return
     */
    public AdoptRecord getRecordState(Long userId, Long petId) {
        Map<String, Object> param = new HashMap<>();
        AdoptRecordExample recordExample = new AdoptRecordExample();
        recordExample.createCriteria().andPetIdEqualTo(petId).andUserIdEqualTo(userId)
                .andRecordTypeEqualTo(RecordConstants.RECORD_TYPE_COLLECTION);
        List<AdoptRecord> records = recordDao.selectByExample(recordExample);
        if (!CollectionUtils.isEmpty(records) && records.size() >= 1) {
            return records.get(0);
        }
        return null;
    }
    /**
     * 添加浏览记录
     * @param userId
     * @param petId
     */
    @Transactional(rollbackFor = Exception.class)
    public void addRecordBrowse(Long userId, Long petId) {
        AdoptRecord adoptRecord = new AdoptRecord();
        adoptRecord.setPetId(petId);
        adoptRecord.setUserId(userId);
        adoptRecord.setRecordType(RecordConstants.RECORD_TYPE_BROWSE);
        adoptRecord.setCreateTime(System.currentTimeMillis());
        adoptRecord.setUpdateTime(System.currentTimeMillis());
        recordDao.insert(adoptRecord);
        adoptPetDao.updateBrowseCount(petId);
    }
    /**
     * 添加收藏记录
     * @param userId
     * @param petId
     * @return
     */
    public boolean addRecordCollection(Long userId, Long petId) {
        AdoptRecord adoptRecord = new AdoptRecord();
        adoptRecord.setPetId(petId);
        adoptRecord.setUserId(userId);
        adoptRecord.setRecordType(RecordConstants.RECORD_TYPE_COLLECTION);
        adoptRecord.setCreateTime(System.currentTimeMillis());
        adoptRecord.setUpdateTime(System.currentTimeMillis());
        return recordDao.insert(adoptRecord) > 0;
    }
    /**
     * 删除收藏记录
     * @param userId
     * @param petId
     * @return
     */
    public boolean delRecordCollection(Long userId, Long petId) {
        Map<String, Object> params = new TreeMap<>();
        params.put("userId", userId);
        params.put("petId", petId);
        params.put("recordType", RecordConstants.RECORD_TYPE_COLLECTION);
        return adoptPetDao.deleteCollectionRecord(params) > 0;
    }
    /**
     * 模糊查询小乖信息
     * @param strLike
     * @return
     */
    public List<AdoptLittlePet> getPetInfoByStrLike(String strLike) {
        if (StringUtils.isBlank(strLike)) {
            return adoptPetDao.queryAllPetInfo();
        }
        strLike = "%" + strLike + "%";
        return adoptPetDao.queryPetsInfoByStrLike(strLike);
    }
    /**
     * 获取三方协议
     * @param petId
     * @param userId
     * @return
     */
    public HashMap<String, Object> getAdoptAgreementInfo(Long petId, Long userId) {
        Map<String, Object> params = new HashMap<>();
        params.put("petId", petId);
        params.put("userId", userId);
//		HashMap<String, Object> param = adoptPetDao.getAdoptAgreementInfo(params);
        return adoptPetDao.getAdoptAgreementInfo(params);
    }
    /**
     * 判断小乖是否已被收养 true 亦被收养，false 为被收养
     * @param petId
     * @return
     */
    public boolean isPetAdopted(Long petId){
        Integer flag = adoptPetDao.isPetAdopted(petId);
        if(flag == null){
            return false;
        }
        return flag > 0;
    }
}
