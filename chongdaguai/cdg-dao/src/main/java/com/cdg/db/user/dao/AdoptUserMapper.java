package com.cdg.db.user.dao;

import com.cdg.db.user.model.AdoptUser;
import com.cdg.db.user.model.AdoptUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdoptUserMapper {
    /**
    * auto generate
    * @param example
    * @return long
    * @date 2018-01-03 10:18:17
     *
     * @author aicuishou
     */
    long countByExample(AdoptUserExample example);

    /**
    * auto generate
    * @param example
    * @return int
    * @date 2018-01-03 10:18:17
     *
     * @author aicuishou
     */
    int deleteByExample(AdoptUserExample example);

    /**
    * auto generate
    * @param userId
    * @return int
    * @date 2018-01-03 10:18:17
     *
     * @author aicuishou
     */
    int deleteByPrimaryKey(Long userId);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:18:17
     *
     * @author aicuishou
     */
    int insert(AdoptUser record);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:18:17
     *
     * @author aicuishou
     */
    int insertSelective(AdoptUser record);

    /**
    * auto generate
    * @param example
    * @return java.util.List<com.cdg.db.user.model.AdoptUser>
    * @date 2018-01-03 10:18:17
     *
     * @author aicuishou
     */
    List<AdoptUser> selectByExample(AdoptUserExample example);

    /**
    * auto generate
    * @param userId
    * @return com.cdg.db.user.model.AdoptUser
    * @date 2018-01-03 10:18:17
     *
     * @author aicuishou
     */
    AdoptUser selectByPrimaryKey(Long userId);

    /**
    * auto generate
    * @param record
    * @param example
    * @return int
    * @date 2018-01-03 10:18:17
     *
     * @author aicuishou
     */
    int updateByExampleSelective(@Param("record") AdoptUser record, @Param("example") AdoptUserExample example);

    /**
    * auto generate
    * @param record
    * @param example
    * @return int
    * @date 2018-01-03 10:18:17
     *
     * @author aicuishou
     */
    int updateByExample(@Param("record") AdoptUser record, @Param("example") AdoptUserExample example);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:18:17
     *
     * @author aicuishou
     */
    int updateByPrimaryKeySelective(AdoptUser record);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:18:17
     *
     * @author aicuishou
     */
    int updateByPrimaryKey(AdoptUser record);

    int updateBatchByPrimaryKeySelective(List<AdoptUser> records);

    int insertBatchSelective(List<AdoptUser> records);

    int insertBatch(List<AdoptUser> records);
}