package com.adopt.littlepet.service;

import com.cdg.db.enhance.dao.AdoptCommentsDao;
import com.cdg.db.enhance.dao.AdoptPetDao;
import com.cdg.db.enhance.model.AdoptCommentAndReply;
import com.cdg.db.enhance.model.AdoptCommentViewModel;
import com.cdg.db.enhance.model.ReplyEntity;
import com.cdg.db.pet.dao.AdoptCommentMapper;
import com.cdg.db.pet.model.AdoptComment;
import com.cdg.db.user.dao.AdoptRecordMapper;
import com.cdg.db.user.model.AdoptRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huayu
 * @date 2018/4/17 下午9:10
 */
@Service
public class CommentService {

    @Autowired
    private AdoptCommentsDao adoptCommentsDao;

    @Autowired
    private AdoptPetDao petDao;

    @Autowired
    private AdoptCommentMapper adoptCommentMapper;

    @Autowired
    private AdoptRecordMapper recordDao;

    /**
     *根据petId获取所有评论和对应的店家回复
     * @param petId
     * @return
     */
    public List<AdoptCommentAndReply> getAllCommentsByPetId(Long petId) {
        return adoptCommentsDao.getAllCommentAndReplyByPetId(petId);
    }

    /**
     * 添加评论
     * @param comment
     * @return
     */
    public boolean addComment(AdoptComment comment) {
        return adoptCommentMapper.insert(comment) > 0;
    }

    /**
     * 获取所有未被回复的评论信息
     * @return
     */
    public List<AdoptCommentViewModel> selectComment() {
        return adoptCommentsDao.selecComment();
    }

    /**
     * 添加店家回复
     * @param reply
     * @return
     */
    public boolean addReply(ReplyEntity reply) {
        return adoptCommentsDao.addReply(reply) > 0;
    }

    /**
     * 添加浏览记录
     * @param record
     * @return
     */
    public boolean addRecord(AdoptRecord record) {
        petDao.addViewCount(record.getPetId());
        return recordDao.insert( record ) > 0;
    }
}

