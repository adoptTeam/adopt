package com.cdg.db.enhance.dao;

import com.cdg.db.enhance.model.AdoptCommentAndReply;
import com.cdg.db.enhance.model.AdoptCommentViewModel;
import com.cdg.db.enhance.model.PetRecord;
import com.cdg.db.enhance.model.ReplyEntity;

import java.util.List;
import java.util.Map;

/**
 * @author: ALWZ
 * @create: 2018-01-12 14:58
 * @description: get all comments and reply information
 **/
public interface AdoptCommentsDao {

    /**
     * @author: lwz
     * @description: 根据petId获取所有的评论和对应的店家回复
     * @param: [petId]
     * @return: java.util.List<com.cdg.db.enhance.model.AdoptCommentAndReply>
     * @date: 15:00 2018/1/12
     */
    List<AdoptCommentAndReply> getAllCommentAndReplyByPetId(Long petId);

    /**
     * 获取所有未被回复的评论信息
     *
     * @return
     */
    List<AdoptCommentViewModel> selecComment();

    /**
     * 添加店家回复
     * @param reply
     * @return
     */
    int addReply(ReplyEntity reply);

    /**
     * 添加浏览记录
     * @param map
     * @return
     */
    int addRecord(Map<String,Object> map);


}
