package com.cdg.db.user.model;

import java.io.Serializable;

/**
* auto generate
* @date 2018-02-24 23:36:54
 *
 * @author aicuishou
 */
public class AdoptUserAdopt implements Serializable {
    /**
     * 领养id
     */
    private Long adoptId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 宠物id
     */
    private Long petId;

    /**
     * 地址id
     */
    private Long addressId;

    /**
     * 领养备注
     */
    private String commentContent;

    /**
     * 领养押金
     */
    private Integer cashPledge;

    /**
     * 领养状态 10-初始化 20-已付款 30-发送中 40-体验中 50-申请退还 60已退还 70删除
     */
    private Byte adoptState;

    /**
     * 
     */
    private Long updateTime;

    /**
     * 
     */
    private Long createTime;

    /**
     * adopt_user_adopt
     */
    private static final long serialVersionUID = 1L;

    /**
     * 领养id
     * @return adopt_id 领养id
     */
    public Long getAdoptId() {
        return adoptId;
    }

    /**
     * 领养id
     * @param adoptId 领养id
     */
    public void setAdoptId(Long adoptId) {
        this.adoptId = adoptId;
    }

    /**
     * 用户id
     * @return user_Id 用户id
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
     * 地址id
     * @return address_id 地址id
     */
    public Long getAddressId() {
        return addressId;
    }

    /**
     * 地址id
     * @param addressId 地址id
     */
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    /**
     * 领养备注
     * @return comment_content 领养备注
     */
    public String getCommentContent() {
        return commentContent;
    }

    /**
     * 领养备注
     * @param commentContent 领养备注
     */
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    /**
     * 领养押金
     * @return cash_pledge 领养押金
     */
    public Integer getCashPledge() {
        return cashPledge;
    }

    /**
     * 领养押金
     * @param cashPledge 领养押金
     */
    public void setCashPledge(Integer cashPledge) {
        this.cashPledge = cashPledge;
    }

    /**
     * 领养状态 10-初始化 20-已付款 30-发送中 40-体验中 50-申请退还 60已退还 70删除
     * @return adopt_state 领养状态 10-初始化 20-已付款 30-发送中 40-体验中 50-申请退还 60已退还 70删除
     */
    public Byte getAdoptState() {
        return adoptState;
    }

    /**
     * 领养状态 10-初始化 20-已付款 30-发送中 40-体验中 50-申请退还 60已退还 70删除
     * @param adoptState 领养状态 10-初始化 20-已付款 30-发送中 40-体验中 50-申请退还 60已退还 70删除
     */
    public void setAdoptState(Byte adoptState) {
        this.adoptState = adoptState;
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
    * auto generate
    * @param that
    * @return boolean
    * @date 2018-02-24 23:36:54
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
        AdoptUserAdopt other = (AdoptUserAdopt) that;
        return (this.getAdoptId() == null ? other.getAdoptId() == null : this.getAdoptId().equals(other.getAdoptId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPetId() == null ? other.getPetId() == null : this.getPetId().equals(other.getPetId()))
            && (this.getAddressId() == null ? other.getAddressId() == null : this.getAddressId().equals(other.getAddressId()))
            && (this.getCommentContent() == null ? other.getCommentContent() == null : this.getCommentContent().equals(other.getCommentContent()))
            && (this.getCashPledge() == null ? other.getCashPledge() == null : this.getCashPledge().equals(other.getCashPledge()))
            && (this.getAdoptState() == null ? other.getAdoptState() == null : this.getAdoptState().equals(other.getAdoptState()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    /**
    * auto generate
    * @return int
    * @date 2018-02-24 23:36:54
     *
     * @author aicuishou
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdoptId() == null) ? 0 : getAdoptId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPetId() == null) ? 0 : getPetId().hashCode());
        result = prime * result + ((getAddressId() == null) ? 0 : getAddressId().hashCode());
        result = prime * result + ((getCommentContent() == null) ? 0 : getCommentContent().hashCode());
        result = prime * result + ((getCashPledge() == null) ? 0 : getCashPledge().hashCode());
        result = prime * result + ((getAdoptState() == null) ? 0 : getAdoptState().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}