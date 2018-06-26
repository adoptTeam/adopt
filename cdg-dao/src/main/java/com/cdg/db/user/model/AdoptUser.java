package com.cdg.db.user.model;

import java.io.Serializable;

/**
* auto generate
* @date 2018-01-03 10:18:17
 *
 * @author aicuishou
 */
public class AdoptUser implements Serializable {
    /**
     * 用户id
     */
    private Long userId;

    /**
     * 微信id
     */
    private String openId;

    /**
     * 头像地址
     */
    private String headPortrait;

    /**
     * 电话
     */
    private String phone;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 真是姓名
     */
    private String realName;

    /**
     * 性别 0-男 1-女
     */
    private Byte sex;

    /**
     * 地址
     */
    private String address;

    /**
     * 
     */
    private String unionId;

    /**
     * 
     */
    private Long createTime;

    /**
     * 0-删除 1-启用 2-停用
     */
    private Byte userState;

    /**
     * adopt_user
     */
    private static final long serialVersionUID = 1L;

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
     * 微信id
     * @return open_id 微信id
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 微信id
     * @param openId 微信id
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * 头像地址
     * @return head_portrait 头像地址
     */
    public String getHeadPortrait() {
        return headPortrait;
    }

    /**
     * 头像地址
     * @param headPortrait 头像地址
     */
    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait == null ? null : headPortrait.trim();
    }

    /**
     * 电话
     * @return phone 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 电话
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 昵称
     * @return nickname 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 昵称
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 真是姓名
     * @return real_name 真是姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 真是姓名
     * @param realName 真是姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 性别 0-男 1-女
     * @return sex 性别 0-男 1-女
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 性别 0-男 1-女
     * @param sex 性别 0-男 1-女
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 地址
     * @return address 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 
     * @return union_id 
     */
    public String getUnionId() {
        return unionId;
    }

    /**
     * 
     * @param unionId 
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId == null ? null : unionId.trim();
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
     * 0-删除 1-启用 2-停用
     * @return user_state 0-删除 1-启用 2-停用
     */
    public Byte getUserState() {
        return userState;
    }

    /**
     * 0-删除 1-启用 2-停用
     * @param userState 0-删除 1-启用 2-停用
     */
    public void setUserState(Byte userState) {
        this.userState = userState;
    }

    /**
    * auto generate
    * @param that
    * @return boolean
    * @date 2018-01-03 10:18:17
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
        AdoptUser other = (AdoptUser) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOpenId() == null ? other.getOpenId() == null : this.getOpenId().equals(other.getOpenId()))
            && (this.getHeadPortrait() == null ? other.getHeadPortrait() == null : this.getHeadPortrait().equals(other.getHeadPortrait()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getUnionId() == null ? other.getUnionId() == null : this.getUnionId().equals(other.getUnionId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUserState() == null ? other.getUserState() == null : this.getUserState().equals(other.getUserState()));
    }

    /**
    * auto generate
    * @return int
    * @date 2018-01-03 10:18:17
     *
     * @author aicuishou
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOpenId() == null) ? 0 : getOpenId().hashCode());
        result = prime * result + ((getHeadPortrait() == null) ? 0 : getHeadPortrait().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getUnionId() == null) ? 0 : getUnionId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUserState() == null) ? 0 : getUserState().hashCode());
        return result;
    }
}