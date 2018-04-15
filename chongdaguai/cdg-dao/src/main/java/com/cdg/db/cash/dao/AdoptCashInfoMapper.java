package com.cdg.db.cash.dao;

import com.cdg.db.cash.model.AdoptCashInfo;
import com.cdg.db.cash.model.AdoptCashInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdoptCashInfoMapper {
    /**
    * auto generate
    * @param example
    * @return long
    * @date 2018-02-06 00:29:49
     *
     * @author aicuishou
     */
    long countByExample(AdoptCashInfoExample example);

    /**
    * auto generate
    * @param example
    * @return int
    * @date 2018-02-06 00:29:49
     *
     * @author aicuishou
     */
    int deleteByExample(AdoptCashInfoExample example);

    /**
    * auto generate
    * @param cashId
    * @return int
    * @date 2018-02-06 00:29:49
     *
     * @author aicuishou
     */
    int deleteByPrimaryKey(Long cashId);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-02-06 00:29:49
     *
     * @author aicuishou
     */
    int insert(AdoptCashInfo record);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-02-06 00:29:49
     *
     * @author aicuishou
     */
    int insertSelective(AdoptCashInfo record);

    /**
    * auto generate
    * @param example
    * @return java.util.List<com.cdg.db.cash.model.AdoptCashInfo>
    * @date 2018-02-06 00:29:49
     *
     * @author aicuishou
     */
    List<AdoptCashInfo> selectByExample(AdoptCashInfoExample example);

    /**
    * auto generate
    * @param cashId
    * @return com.cdg.db.cash.model.AdoptCashInfo
    * @date 2018-02-06 00:29:49
     *
     * @author aicuishou
     */
    AdoptCashInfo selectByPrimaryKey(Long cashId);

    /**
    * auto generate
    * @param record
    * @param example
    * @return int
    * @date 2018-02-06 00:29:49
     *
     * @author aicuishou
     */
    int updateByExampleSelective(@Param("record") AdoptCashInfo record, @Param("example") AdoptCashInfoExample example);

    /**
    * auto generate
    * @param record
    * @param example
    * @return int
    * @date 2018-02-06 00:29:49
     *
     * @author aicuishou
     */
    int updateByExample(@Param("record") AdoptCashInfo record, @Param("example") AdoptCashInfoExample example);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-02-06 00:29:49
     *
     * @author aicuishou
     */
    int updateByPrimaryKeySelective(AdoptCashInfo record);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-02-06 00:29:49
     *
     * @author aicuishou
     */
    int updateByPrimaryKey(AdoptCashInfo record);

    int updateBatchByPrimaryKeySelective(List<AdoptCashInfo> records);

    int insertBatchSelective(List<AdoptCashInfo> records);

    int insertBatch(List<AdoptCashInfo> records);
}