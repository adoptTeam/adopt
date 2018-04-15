package com.cdg.db.system.dao;

import com.cdg.db.system.model.AdoptSysAddress;
import com.cdg.db.system.model.AdoptSysAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdoptSysAddressMapper {
    /**
    * auto generate
    * @param example
    * @return long
    * @date 2018-01-03 10:22:21
     *
     * @author aicuishou
     */
    long countByExample(AdoptSysAddressExample example);

    /**
    * auto generate
    * @param example
    * @return int
    * @date 2018-01-03 10:22:21
     *
     * @author aicuishou
     */
    int deleteByExample(AdoptSysAddressExample example);

    /**
    * auto generate
    * @param addressId
    * @return int
    * @date 2018-01-03 10:22:21
     *
     * @author aicuishou
     */
    int deleteByPrimaryKey(Long addressId);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:22:21
     *
     * @author aicuishou
     */
    int insert(AdoptSysAddress record);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:22:21
     *
     * @author aicuishou
     */
    int insertSelective(AdoptSysAddress record);

    /**
    * auto generate
    * @param example
    * @return java.util.List<com.cdg.db.system.model.AdoptSysAddress>
    * @date 2018-01-03 10:22:21
     *
     * @author aicuishou
     */
    List<AdoptSysAddress> selectByExample(AdoptSysAddressExample example);

    /**
    * auto generate
    * @param addressId
    * @return com.cdg.db.system.model.AdoptSysAddress
    * @date 2018-01-03 10:22:21
     *
     * @author aicuishou
     */
    AdoptSysAddress selectByPrimaryKey(Long addressId);

    /**
    * auto generate
    * @param record
    * @param example
    * @return int
    * @date 2018-01-03 10:22:21
     *
     * @author aicuishou
     */
    int updateByExampleSelective(@Param("record") AdoptSysAddress record, @Param("example") AdoptSysAddressExample example);

    /**
    * auto generate
    * @param record
    * @param example
    * @return int
    * @date 2018-01-03 10:22:21
     *
     * @author aicuishou
     */
    int updateByExample(@Param("record") AdoptSysAddress record, @Param("example") AdoptSysAddressExample example);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:22:21
     *
     * @author aicuishou
     */
    int updateByPrimaryKeySelective(AdoptSysAddress record);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:22:21
     *
     * @author aicuishou
     */
    int updateByPrimaryKey(AdoptSysAddress record);

    int updateBatchByPrimaryKeySelective(List<AdoptSysAddress> records);

    int insertBatchSelective(List<AdoptSysAddress> records);

    int insertBatch(List<AdoptSysAddress> records);
}