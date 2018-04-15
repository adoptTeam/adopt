package com.cdg.db.system.dao;

import com.cdg.db.system.model.AdoptPlatformReply;
import com.cdg.db.system.model.AdoptPlatformReplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdoptPlatformReplyMapper {
    /**
    * auto generate
    * @param example
    * @return long
    * @date 2018-01-03 10:27:00
     *
     * @author aicuishou
     */
    long countByExample(AdoptPlatformReplyExample example);

    /**
    * auto generate
    * @param example
    * @return int
    * @date 2018-01-03 10:27:00
     *
     * @author aicuishou
     */
    int deleteByExample(AdoptPlatformReplyExample example);

    /**
    * auto generate
    * @param replyId
    * @return int
    * @date 2018-01-03 10:27:00
     *
     * @author aicuishou
     */
    int deleteByPrimaryKey(Long replyId);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:27:00
     *
     * @author aicuishou
     */
    int insert(AdoptPlatformReply record);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:27:00
     *
     * @author aicuishou
     */
    int insertSelective(AdoptPlatformReply record);

    /**
    * auto generate
    * @param example
    * @return java.util.List<com.cdg.db.system.model.AdoptPlatformReply>
    * @date 2018-01-03 10:27:00
     *
     * @author aicuishou
     */
    List<AdoptPlatformReply> selectByExample(AdoptPlatformReplyExample example);

    /**
    * auto generate
    * @param replyId
    * @return com.cdg.db.system.model.AdoptPlatformReply
    * @date 2018-01-03 10:27:00
     *
     * @author aicuishou
     */
    AdoptPlatformReply selectByPrimaryKey(Long replyId);

    /**
    * auto generate
    * @param record
    * @param example
    * @return int
    * @date 2018-01-03 10:27:00
     *
     * @author aicuishou
     */
    int updateByExampleSelective(@Param("record") AdoptPlatformReply record, @Param("example") AdoptPlatformReplyExample example);

    /**
    * auto generate
    * @param record
    * @param example
    * @return int
    * @date 2018-01-03 10:27:00
     *
     * @author aicuishou
     */
    int updateByExample(@Param("record") AdoptPlatformReply record, @Param("example") AdoptPlatformReplyExample example);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:27:00
     *
     * @author aicuishou
     */
    int updateByPrimaryKeySelective(AdoptPlatformReply record);

    /**
    * auto generate
    * @param record
    * @return int
    * @date 2018-01-03 10:27:00
     *
     * @author aicuishou
     */
    int updateByPrimaryKey(AdoptPlatformReply record);

    int updateBatchByPrimaryKeySelective(List<AdoptPlatformReply> records);

    int insertBatchSelective(List<AdoptPlatformReply> records);

    int insertBatch(List<AdoptPlatformReply> records);
}