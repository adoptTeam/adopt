package com.cdg.db.pet.dao;

import com.cdg.db.pet.model.AdoptLittlePet;
import com.cdg.db.pet.model.AdoptLittlePetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdoptLittlePetMapper {
    /**
    * auto generate
    * @param example
    * @return long
    * @date 2018-01-08 18:12:20
     *
     * @author aicuishou
     */
    long countByExample(AdoptLittlePetExample example);

    /**
    * auto generate
    * @param example
    * @return int
    * @date 2018-01-08 18:12:20
     *
     * @author aicuishou
     */
    int deleteByExample(AdoptLittlePetExample example);

    /**
    * auto generate
    * @param petId
    * @return int
    * @date 2018-01-08 18:12:20
     *
     * @author aicuishou
     */
    int deleteByPrimaryKey(Long petId);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-08 18:12:20
     *
     * @author aicuishou
     */
    int insert(AdoptLittlePet record);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-08 18:12:20
     *
     * @author aicuishou
     */
    int insertSelective(AdoptLittlePet record);

    /**
    * auto generate
    * @param example
    * @return java.util.List<com.cdg.db.pet.model.AdoptLittlePet>
    * @date 2018-01-08 18:12:20
     *
     * @author aicuishou
     */
    List<AdoptLittlePet> selectByExample(AdoptLittlePetExample example);

    /**
    * auto generate
    * @param petId
    * @return com.cdg.db.pet.model.AdoptLittlePet
    * @date 2018-01-08 18:12:20
     *
     * @author aicuishou
     */
    AdoptLittlePet selectByPrimaryKey(Long petId);

    /**
    * auto generate
    * @param record
    * @param example
    * @return int
    * @date 2018-01-08 18:12:20
     *
     * @author aicuishou
     */
    int updateByExampleSelective(@Param("record") AdoptLittlePet record, @Param("example") AdoptLittlePetExample example);

    /**
    * auto generate
    * @param record
    * @param example
    * @return int
    * @date 2018-01-08 18:12:20
     *
     * @author aicuishou
     */
    int updateByExample(@Param("record") AdoptLittlePet record, @Param("example") AdoptLittlePetExample example);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-08 18:12:20
     *
     * @author aicuishou
     */
    int updateByPrimaryKeySelective(AdoptLittlePet record);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-08 18:12:20
     *
     * @author aicuishou
     */
    int updateByPrimaryKey(AdoptLittlePet record);

    int updateBatchByPrimaryKeySelective(List<AdoptLittlePet> records);

    int insertBatchSelective(List<AdoptLittlePet> records);

    int insertBatch(List<AdoptLittlePet> records);
}