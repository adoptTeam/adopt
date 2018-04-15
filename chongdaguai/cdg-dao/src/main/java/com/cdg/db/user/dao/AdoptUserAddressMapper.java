package com.cdg.db.user.dao;

import com.cdg.db.user.model.AdoptUserAddress;
import com.cdg.db.user.model.AdoptUserAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdoptUserAddressMapper {
    /**
    * auto generate
    * @param example
    * @return long
    * @date 2018-01-03 10:18:17
     *
     * @author aicuishou
     */
    long countByExample(AdoptUserAddressExample example);

    /**
    * auto generate
    * @param example
    * @return int
    * @date 2018-01-03 10:18:17
     *
     * @author aicuishou
     */
    int deleteByExample(AdoptUserAddressExample example);

    /**
    * auto generate
    * @param userAddressId
    * @return int
    * @date 2018-01-03 10:18:17
     *
     * @author aicuishou
     */
    int deleteByPrimaryKey(Long userAddressId);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:18:17
     *
     * @author aicuishou
     */
    int insert(AdoptUserAddress record);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:18:17
     *
     * @author aicuishou
     */
    int insertSelective(AdoptUserAddress record);

    /**
    * auto generate
    * @param example
    * @return java.util.List<com.cdg.db.user.model.AdoptUserAddress>
    * @date 2018-01-03 10:18:17
     *
     * @author aicuishou
     */
    List<AdoptUserAddress> selectByExample(AdoptUserAddressExample example);

    /**
    * auto generate
    * @param userAddressId
    * @return com.cdg.db.user.model.AdoptUserAddress
    * @date 2018-01-03 10:18:17
     *
     * @author aicuishou
     */
    AdoptUserAddress selectByPrimaryKey(Long userAddressId);

    /**
    * auto generate
    * @param record
    * @param example
    * @return int
    * @date 2018-01-03 10:18:17
     *
     * @author aicuishou
     */
    int updateByExampleSelective(@Param("record") AdoptUserAddress record, @Param("example") AdoptUserAddressExample example);

    /**
    * auto generate
    * @param record
    * @param example
    * @return int
    * @date 2018-01-03 10:18:17
     *
     * @author aicuishou
     */
    int updateByExample(@Param("record") AdoptUserAddress record, @Param("example") AdoptUserAddressExample example);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:18:17
     *
     * @author aicuishou
     */
    int updateByPrimaryKeySelective(AdoptUserAddress record);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:18:17
     *
     * @author aicuishou
     */
    int updateByPrimaryKey(AdoptUserAddress record);

    int updateBatchByPrimaryKeySelective(List<AdoptUserAddress> records);

    int insertBatchSelective(List<AdoptUserAddress> records);

    int insertBatch(List<AdoptUserAddress> records);
}