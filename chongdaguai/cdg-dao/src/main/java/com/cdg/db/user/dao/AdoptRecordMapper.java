package com.cdg.db.user.dao;

import com.cdg.db.user.model.AdoptRecord;
import com.cdg.db.user.model.AdoptRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdoptRecordMapper {
    /**
    * auto generate
    * @param example
    * @return long
    * @date 2018-01-04 19:20:53
     *
     * @author aicuishou
     */
    long countByExample(AdoptRecordExample example);

    /**
    * auto generate
    * @param example
    * @return int
    * @date 2018-01-04 19:20:53
     *
     * @author aicuishou
     */
    int deleteByExample(AdoptRecordExample example);

    /**
    * auto generate
    * @param recordId
    * @return int
    * @date 2018-01-04 19:20:53
     *
     * @author aicuishou
     */
    int deleteByPrimaryKey(Long recordId);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-04 19:20:53
     *
     * @author aicuishou
     */
    int insert(AdoptRecord record);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-04 19:20:53
     *
     * @author aicuishou
     */
    int insertSelective(AdoptRecord record);

    /**
    * auto generate
    * @param example
    * @return java.util.List<com.cdg.db.user.model.AdoptRecord>
    * @date 2018-01-04 19:20:53
     *
     * @author aicuishou
     */
    List<AdoptRecord> selectByExample(AdoptRecordExample example);

    /**
    * auto generate
    * @param recordId
    * @return com.cdg.db.user.model.AdoptRecord
    * @date 2018-01-04 19:20:53
     *
     * @author aicuishou
     */
    AdoptRecord selectByPrimaryKey(Long recordId);

    /**
    * auto generate
    * @param record
    * @param example
    * @return int
    * @date 2018-01-04 19:20:53
     *
     * @author aicuishou
     */
    int updateByExampleSelective(@Param("record") AdoptRecord record, @Param("example") AdoptRecordExample example);

    /**
    * auto generate
    * @param record
    * @param example
    * @return int
    * @date 2018-01-04 19:20:53
     *
     * @author aicuishou
     */
    int updateByExample(@Param("record") AdoptRecord record, @Param("example") AdoptRecordExample example);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-04 19:20:53
     *
     * @author aicuishou
     */
    int updateByPrimaryKeySelective(AdoptRecord record);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-04 19:20:53
     *
     * @author aicuishou
     */
    int updateByPrimaryKey(AdoptRecord record);

    int updateBatchByPrimaryKeySelective(List<AdoptRecord> records);

    int insertBatchSelective(List<AdoptRecord> records);

    int insertBatch(List<AdoptRecord> records);
}