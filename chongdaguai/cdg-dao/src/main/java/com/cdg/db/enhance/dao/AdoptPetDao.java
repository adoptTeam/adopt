package com.cdg.db.enhance.dao;

import com.cdg.db.pet.model.AdoptLittlePet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: ALWZ
 * @create: 2018-01-12 17:07
 * @description: AdoptPet补充接口
 **/
public interface AdoptPetDao {

    /**
     * @author: lwz
     * @description: 更新浏览数，自动+1
     * @param: [petId]
     * @return: void
     * @date: 17:08 2018/1/12
     */
    void updateBrowseCount(Long petId);

    /**
     * @author: lwz
     * @description: 模糊查询小乖信息
     * @param: [strLike]
     * @return: void
     * @date: 17:08 2018/1/12
     */
    List<AdoptLittlePet> queryPetsInfoByStrLike(String strLike);
    List<AdoptLittlePet> queryAllPetInfo();

    /**
     * 根据userId和petId获取宠物领养协议里面的相关三方信息
     * @return
     */
    HashMap<String,Object> getAdoptAgreementInfo(Map<String,Object> params);

    int deleteCollectionRecord(Map<String,Object> params);

    void addViewCount(Long petId);

    Integer isPetAdopted(long petId);
}
