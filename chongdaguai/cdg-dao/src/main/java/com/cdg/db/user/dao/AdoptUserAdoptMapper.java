package com.cdg.db.user.dao;

import com.cdg.db.user.model.AdoptUserAdopt;
import com.cdg.db.user.model.AdoptUserAdoptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdoptUserAdoptMapper {
    /**
    * auto generate
    * @param example
    * @return long
    * @date 2018-02-24 23:36:54
     *
     * @author aicuishou
     */
    long countByExample(AdoptUserAdoptExample example);

    /**
    * auto generate
    * @param example
    * @return int
    * @date 2018-02-24 23:36:54
     *
     * @author aicuishou
     */
    int deleteByExample(AdoptUserAdoptExample example);

    /**
    * auto generate
    * @param adoptId
    * @return int
    * @date 2018-02-24 23:36:54
     *
     * @author aicuishou
     */
    int deleteByPrimaryKey(Long adoptId);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-02-24 23:36:54
     *
     * @author aicuishou
     */
    int insert(AdoptUserAdopt record);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-02-24 23:36:54
     *
     * @author aicuishou
     */
    int insertSelective(AdoptUserAdopt record);

    /**
    * auto generate
    * @param example
    * @return java.util.List<com.cdg.db.user.model.AdoptUserAdopt>
    * @date 2018-02-24 23:36:54
     *
     * @author aicuishou
     */
    List<AdoptUserAdopt> selectByExample(AdoptUserAdoptExample example);

    /**
    * auto generate
    * @param adoptId
    * @return com.cdg.db.user.model.AdoptUserAdopt
    * @date 2018-02-24 23:36:54
     *
     * @author aicuishou
     */
    AdoptUserAdopt selectByPrimaryKey(Long adoptId);

    /**
    * auto generate
    * @param record
    * @param example
    * @return int
    * @date 2018-02-24 23:36:54
     *
     * @author aicuishou
     */
    int updateByExampleSelective(@Param("record") AdoptUserAdopt record, @Param("example") AdoptUserAdoptExample example);

    /**
    * auto generate
    * @param record
    * @param example
    * @return int
    * @date 2018-02-24 23:36:54
     *
     * @author aicuishou
     */
    int updateByExample(@Param("record") AdoptUserAdopt record, @Param("example") AdoptUserAdoptExample example);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-02-24 23:36:54
     *
     * @author aicuishou
     */
    int updateByPrimaryKeySelective(AdoptUserAdopt record);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-02-24 23:36:54
     *
     * @author aicuishou
     */
    int updateByPrimaryKey(AdoptUserAdopt record);

    int updateBatchByPrimaryKeySelective(List<AdoptUserAdopt> records);

    int insertBatchSelective(List<AdoptUserAdopt> records);

    int insertBatch(List<AdoptUserAdopt> records);
}