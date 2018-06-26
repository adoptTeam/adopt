package com.cdg.db.system.model;

import java.io.Serializable;

/**
* auto generate
* @date 2018-01-03 10:27:00
 *
 * @author aicuishou
 */
public class AdoptPlatformReply implements Serializable {
    /**
     * 自增id
     */
    private Long replyId;

    /**
     * 评论id
     */
    private Long commentId;

    /**
     * 回复内容
     */
    private String replyContent;

    /**
     * 
     */
    private Long createTime;

    /**
     * 
     */
    private Long updateTime;

    /**
     * adopt_platform_reply
     */
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     * @return reply_id 自增id
     */
    public Long getReplyId() {
        return replyId;
    }

    /**
     * 自增id
     * @param replyId 自增id
     */
    public void setReplyId(Long replyId) {
        this.replyId = replyId;
    }

    /**
     * 评论id
     * @return comment_id 评论id
     */
    public Long getCommentId() {
        return commentId;
    }

    /**
     * 评论id
     * @param commentId 评论id
     */
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    /**
     * 回复内容
     * @return reply_content 回复内容
     */
    public String getReplyContent() {
        return replyContent;
    }

    /**
     * 回复内容
     * @param replyContent 回复内容
     */
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    /**
     * 
     * @return create_time 
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 
     * @param createTime 
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 
     * @return update_time 
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * 
     * @param updateTime 
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    /**
    * auto generate
    * @param that
    * @return boolean
    * @date 2018-01-03 10:27:00
     *
     * @author aicuishou
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        AdoptPlatformReply other = (AdoptPlatformReply) that;
        return (this.getReplyId() == null ? other.getReplyId() == null : this.getReplyId().equals(other.getReplyId()))
            && (this.getCommentId() == null ? other.getCommentId() == null : this.getCommentId().equals(other.getCommentId()))
            && (this.getReplyContent() == null ? other.getReplyContent() == null : this.getReplyContent().equals(other.getReplyContent()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
    * auto generate
    * @return int
    * @date 2018-01-03 10:27:00
     *
     * @author aicuishou
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReplyId() == null) ? 0 : getReplyId().hashCode());
        result = prime * result + ((getCommentId() == null) ? 0 : getCommentId().hashCode());
        result = prime * result + ((getReplyContent() == null) ? 0 : getReplyContent().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}