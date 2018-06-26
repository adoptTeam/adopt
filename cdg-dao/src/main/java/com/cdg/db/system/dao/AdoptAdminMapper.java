package com.cdg.db.system.dao;

import com.cdg.db.system.model.AdoptAdmin;
import com.cdg.db.system.model.AdoptAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdoptAdminMapper {
    /**
    * auto generate
    * @param example
    * @return long
    * @date 2018-01-03 10:35:32
     *
     * @author aicuishou
     */
    long countByExample(AdoptAdminExample example);

    /**
    * auto generate
    * @param example
    * @return int
    * @date 2018-01-03 10:35:32
     *
     * @author aicuishou
     */
    int deleteByExample(AdoptAdminExample example);

    /**
    * auto generate
    * @param adminId
    * @return int
    * @date 2018-01-03 10:35:32
     *
     * @author aicuishou
     */
    int deleteByPrimaryKey(Long adminId);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:35:32
     *
     * @author aicuishou
     */
    int insert(AdoptAdmin record);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:35:32
     *
     * @author aicuishou
     */
    int insertSelective(AdoptAdmin record);

    /**
    * auto generate
    * @param example
    * @return java.util.List<com.cdg.db.system.model.AdoptAdmin>
    * @date 2018-01-03 10:35:32
     *
     * @author aicuishou
     */
    List<AdoptAdmin> selectByExample(AdoptAdminExample example);

    /**
    * auto generate
    * @param adminId
    * @return com.cdg.db.system.model.AdoptAdmin
    * @date 2018-01-03 10:35:32
     *
     * @author aicuishou
     */
    AdoptAdmin selectByPrimaryKey(Long adminId);

    /**
    * auto generate
    * @param record
    * @param example
    * @return int
    * @date 2018-01-03 10:35:32
     *
     * @author aicuishou
     */
    int updateByExampleSelective(@Param("record") AdoptAdmin record, @Param("example") AdoptAdminExample example);

    /**
    * auto generate
    * @param record
    * @param example
    * @return int
    * @date 2018-01-03 10:35:32
     *
     * @author aicuishou
     */
    int updateByExample(@Param("record") AdoptAdmin record, @Param("example") AdoptAdminExample example);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:35:32
     *
     * @author aicuishou
     */
    int updateByPrimaryKeySelective(AdoptAdmin record);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:35:32
     *
     * @author aicuishou
     */
    int updateByPrimaryKey(AdoptAdmin record);

    int updateBatchByPrimaryKeySelective(List<AdoptAdmin> records);

    int insertBatchSelective(List<AdoptAdmin> records);

    int insertBatch(List<AdoptAdmin> records);
}