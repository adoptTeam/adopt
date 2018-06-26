package com.cdg.db.pet.dao;

import com.cdg.db.pet.model.AdoptComment;
import com.cdg.db.pet.model.AdoptCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdoptCommentMapper {
    /**
    * auto generate
    * @param example
    * @return long
    * @date 2018-01-03 10:31:08
     *
     * @author aicuishou
     */
    long countByExample(AdoptCommentExample example);

    /**
    * auto generate
    * @param example
    * @return int
    * @date 2018-01-03 10:31:08
     *
     * @author aicuishou
     */
    int deleteByExample(AdoptCommentExample example);

    /**
    * auto generate
    * @param commentId
    * @return int
    * @date 2018-01-03 10:31:08
     *
     * @author aicuishou
     */
    int deleteByPrimaryKey(Long commentId);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:31:08
     *
     * @author aicuishou
     */
    int insert(AdoptComment record);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:31:08
     *
     * @author aicuishou
     */
    int insertSelective(AdoptComment record);

    /**
    * auto generate
    * @param example
    * @return java.util.List<com.cdg.db.pet.model.AdoptComment>
    * @date 2018-01-03 10:31:08
     *
     * @author aicuishou
     */
    List<AdoptComment> selectByExample(AdoptCommentExample example);

    /**
    * auto generate
    * @param commentId
    * @return com.cdg.db.pet.model.AdoptComment
    * @date 2018-01-03 10:31:08
     *
     * @author aicuishou
     */
    AdoptComment selectByPrimaryKey(Long commentId);

    /**
    * auto generate
    * @param record
    * @param example
    * @return int
    * @date 2018-01-03 10:31:08
     *
     * @author aicuishou
     */
    int updateByExampleSelective(@Param("record") AdoptComment record, @Param("example") AdoptCommentExample example);

    /**
    * auto generate
    * @param record
    * @param example
    * @return int
    * @date 2018-01-03 10:31:08
     *
     * @author aicuishou
     */
    int updateByExample(@Param("record") AdoptComment record, @Param("example") AdoptCommentExample example);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:31:08
     *
     * @author aicuishou
     */
    int updateByPrimaryKeySelective(AdoptComment record);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:31:08
     *
     * @author aicuishou
     */
    int updateByPrimaryKey(AdoptComment record);

    int updateBatchByPrimaryKeySelective(List<AdoptComment> records);

    int insertBatchSelective(List<AdoptComment> records);

    int insertBatch(List<AdoptComment> records);
}