package com.cdg.db.user.model;

import java.io.Serializable;

/**
* auto generate
* @date 2018-01-04 19:20:53
 *
 * @author aicuishou
 */
public class AdoptRecord implements Serializable {
    /**
     * 自增id
     */
    private Long recordId;

    /**
     * 宠物id
     */
    private Long petId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 类型：0-浏览 1-收藏
     */
    private Byte recordType;

    /**
     * 
     */
    private Long createTime;

    /**
     * 
     */
    private Long updateTime;

    /**
     * adopt_record
     */
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     * @return record_id 自增id
     */
    public Long getRecordId() {
        return recordId;
    }

    /**
     * 自增id
     * @param recordId 自增id
     */
    public void setRecordId(Long recordId) {
        this.recordId = recordId;
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
     * 用户id
     * @return user_id 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户id
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 类型：0-浏览 1-收藏
     * @return record_type 类型：0-浏览 1-收藏
     */
    public Byte getRecordType() {
        return recordType;
    }

    /**
     * 类型：0-浏览 1-收藏
     * @param recordType 类型：0-浏览 1-收藏
     */
    public void setRecordType(Byte recordType) {
        this.recordType = recordType;
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
    * @date 2018-01-04 19:20:53
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
        AdoptRecord other = (AdoptRecord) that;
        return (this.getRecordId() == null ? other.getRecordId() == null : this.getRecordId().equals(other.getRecordId()))
            && (this.getPetId() == null ? other.getPetId() == null : this.getPetId().equals(other.getPetId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getRecordType() == null ? other.getRecordType() == null : this.getRecordType().equals(other.getRecordType()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
    * auto generate
    * @return int
    * @date 2018-01-04 19:20:53
     *
     * @author aicuishou
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRecordId() == null) ? 0 : getRecordId().hashCode());
        result = prime * result + ((getPetId() == null) ? 0 : getPetId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getRecordType() == null) ? 0 : getRecordType().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}