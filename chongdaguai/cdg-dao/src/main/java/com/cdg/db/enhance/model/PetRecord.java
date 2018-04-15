package com.cdg.db.enhance.model;

import java.io.Serializable;

/**
 * @author: ALWZ
 * @create: 2018-01-12 15:53
 * @description: 浏览收藏信息实体
 **/
public class PetRecord implements Serializable{
    private Long recordId;
    private Long petId;
    private Long userId;
    private Integer recordType;
    private Long createTime;
    private Long updateTime;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }
}
