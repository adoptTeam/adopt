package com.cdg.db.system.dao;

import com.cdg.db.system.model.AdoptLogisticsInfo;
import com.cdg.db.system.model.AdoptLogisticsInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdoptLogisticsInfoMapper {
    /**
    * auto generate
    * @param example
    * @return long
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    long countByExample(AdoptLogisticsInfoExample example);

    /**
    * auto generate
    * @param example
    * @return int
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    int deleteByExample(AdoptLogisticsInfoExample example);

    /**
    * auto generate
    * @param logisticsId
    * @return int
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    int deleteByPrimaryKey(Long logisticsId);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    int insert(AdoptLogisticsInfo record);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    int insertSelective(AdoptLogisticsInfo record);

    /**
    * auto generate
    * @param example
    * @return java.util.List<com.cdg.db.system.model.AdoptLogisticsInfo>
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    List<AdoptLogisticsInfo> selectByExample(AdoptLogisticsInfoExample example);

    /**
    * auto generate
    * @param logisticsId
    * @return com.cdg.db.system.model.AdoptLogisticsInfo
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    AdoptLogisticsInfo selectByPrimaryKey(Long logisticsId);

    /**
    * auto generate
    * @param record
    * @param example
    * @return int
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    int updateByExampleSelective(@Param("record") AdoptLogisticsInfo record, @Param("example") AdoptLogisticsInfoExample example);

    /**
    * auto generate
    * @param record
    * @param example
    * @return int
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    int updateByExample(@Param("record") AdoptLogisticsInfo record, @Param("example") AdoptLogisticsInfoExample example);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    int updateByPrimaryKeySelective(AdoptLogisticsInfo record);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    int updateByPrimaryKey(AdoptLogisticsInfo record);

    int updateBatchByPrimaryKeySelective(List<AdoptLogisticsInfo> records);

    int insertBatchSelective(List<AdoptLogisticsInfo> records);

    int insertBatch(List<AdoptLogisticsInfo> records);
}