package com.cdg.db.enhance.dao;

import com.cdg.db.enhance.model.AdoptSearch;
import com.cdg.db.pet.model.AdoptLittlePet;
import com.cdg.db.system.model.AdoptLogisticsInfo;
import com.cdg.db.user.model.AdoptUserAddress;
import com.cdg.db.user.model.AdoptUserAdopt;

import java.util.List;
import java.util.Map;

/**
 * @author wugaoping 2017-10-16
 */
public interface NativeSqlMapper {
    /**
     * 执行读操作
     *
     * @param value
     * @return
     */
    List<Map<String, Object>> execReadSql(String value);

    /**
     * 执行写操作
     *
     * @param value
     */
    void execWriteSql(String value);

    /**
     * 执行统计操作
     *
     * @param value
     * @return
     */
    Integer countBySql(String value);

    /**
     * 根据用户id 查询领养的小乖
     *
     * @param userId 用户id
     * @return
     */
    List<AdoptLittlePet> selectPetByUserId(Long userId);

    /**
     * 根据用户id获取物流信息
     *
     * @param userId 用户id
     * @return int
     * @date 2018-01-03 10:34:19
     * @author aicuishou
     */
    List<AdoptLogisticsInfo> selectLogisticsByUserId(Long userId);

    /**
     * 根据用户id和状态信息查询地址
     *
     * @return int
     * @date 2018-01-03 10:34:19
     * @author aicuishou
     */
    List<AdoptUserAddress> selectAddressByUserIdAndState(Map<String, Object> params);

    /**
     * 根据用户id查询用户地址
     *
     * @param userId
     * @return
     */
    AdoptUserAddress selectUserAddressByUserId(Long userId);

    /**
     * 查询用户领养小乖信息
     *
     * @param adoptSearch
     * @return
     */
    List<AdoptUserAdopt> selectAdoptByAdoptSearch(AdoptSearch adoptSearch);

    /**
     * 收藏小乖的数量
     *
     * @param userId
     * @return
     */
    Integer getMyCollectionCount(Long userId);
}
