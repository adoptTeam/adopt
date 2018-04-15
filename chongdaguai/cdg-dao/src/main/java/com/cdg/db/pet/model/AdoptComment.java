package com.cdg.db.pet.model;

import java.io.Serializable;

/**
* auto generate
* @date 2018-01-03 10:31:08
 *
 * @author aicuishou
 */
public class AdoptComment implements Serializable {
    /**
     * 自增id
     */
    protected Long commentId;

    /**
     * 宠物id
     */
    protected Long petId;

    /**
     * 评论人id
     */
    protected Long userId;

    /**
     * 评论人昵称
     */
    protected String userNickname;

    /**
     * 评论内容
     */
    protected String commentContent;

    /**
     *
     */
    protected Long createTime;

    /**
     *
     */
    protected Long updateTime;

    /**
     * adopt_comment
     */
    protected static final long serialVersionUID = 1L;

    /**
     * 自增id
     * @return comment_id 自增id
     */
    public Long getCommentId() {
        return commentId;
    }

    /**
     * 自增id
     * @param commentId 自增id
     */
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    /**
     * 宠物id
     * @return pet_id 宠物id
     */
    public Long getPetId() {
        return petId;
    }

    /**
     * 宠物id
     * @param petId 宠物id
     */
    public void setPetId(Long petId) {
        this.petId = petId;
    }

    /**
     * 评论人id
     * @return user_id 评论人id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 评论人id
     * @param userId 评论人id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 评论人昵称
     * @return user_nickname 评论人昵称
     */
    public String getUserNickname() {
        return userNickname;
    }

    /**
     * 评论人昵称
     * @param userNickname 评论人昵称
     */
    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname == null ? null : userNickname.trim();
    }

    /**
     * 评论内容
     * @return comment_content 评论内容
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * 评论内容
     * @param commentContent 评论内容
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
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
    * @date 2018-01-03 10:31:08
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
        AdoptComment other = (AdoptComment) that;
        return (this.getCommentId() == null ? other.getCommentId() == null : this.getCommentId().equals(other.getCommentId()))
            && (this.getPetId() == null ? other.getPetId() == null : this.getPetId().equals(other.getPetId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserNickname() == null ? other.getUserNickname() == null : this.getUserNickname().equals(other.getUserNickname()))
            && (this.getCommentContent() == null ? other.getCommentContent() == null : this.getCommentContent().equals(other.getCommentContent()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
    * auto generate
    * @return int
    * @date 2018-01-03 10:31:08
     *
     * @author aicuishou
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCommentId() == null) ? 0 : getCommentId().hashCode());
        result = prime * result + ((getPetId() == null) ? 0 : getPetId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserNickname() == null) ? 0 : getUserNickname().hashCode());
        result = prime * result + ((getCommentContent() == null) ? 0 : getCommentContent().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}