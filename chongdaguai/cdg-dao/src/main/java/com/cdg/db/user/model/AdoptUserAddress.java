package com.cdg.db.user.model;

import java.io.Serializable;

/**
* auto generate
* @date 2018-01-03 10:18:17
 *
 * @author aicuishou
 */
public class AdoptUserAddress implements Serializable {
    /**
     * 自增id
     */
    private Long userAddressId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 收货人姓名
     */
    private String consigneeName;

    /**
     * 收货人电话
     */
    private String consigneePhone;

    /**
     * 所在省份
     */
    private String province;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 所在县区
     */
    private String areas;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 地址状态：0-删除 1-启用 2-停用
     */
    private Byte addressState;

    /**
     * 
     */
    private Long createTime;

    /**
     * 
     */
    private Long updateTime;

    /**
     * adopt_user_address
     */
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     * @return user_address_id 自增id
     */
    public Long getUserAddressId() {
        return userAddressId;
    }

    /**
     * 自增id
     * @param userAddressId 自增id
     */
    public void setUserAddressId(Long userAddressId) {
        this.userAddressId = userAddressId;
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
     * 收货人姓名
     * @return consignee_name 收货人姓名
     */
    public String getConsigneeName() {
        return consigneeName;
    }

    /**
     * 收货人姓名
     * @param consigneeName 收货人姓名
     */
    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName == null ? null : consigneeName.trim();
    }

    /**
     * 收货人电话
     * @return consignee_phone 收货人电话
     */
    public String getConsigneePhone() {
        return consigneePhone;
    }

    /**
     * 收货人电话
     * @param consigneePhone 收货人电话
     */
    public void setConsigneePhone(String consigneePhone) {
        this.consigneePhone = consigneePhone == null ? null : consigneePhone.trim();
    }

    /**
     * 所在省份
     * @return province 所在省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 所在省份
     * @param province 所在省份
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 所在城市
     * @return city 所在城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 所在城市
     * @param city 所在城市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 所在县区
     * @return areas 所在县区
     */
    public String getAreas() {
        return areas;
    }

    /**
     * 所在县区
     * @param areas 所在县区
     */
    public void setAreas(String areas) {
        this.areas = areas == null ? null : areas.trim();
    }

    /**
     * 详细地址
     * @return address 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 详细地址
     * @param address 详细地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 地址状态：0-删除 1-启用 2-停用
     * @return address_state 地址状态：0-删除 1-启用 2-停用
     */
    public Byte getAddressState() {
        return addressState;
    }

    /**
     * 地址状态：0-删除 1-启用 2-停用
     * @param addressState 地址状态：0-删除 1-启用 2-停用
     */
    public void setAddressState(Byte addressState) {
        this.addressState = addressState;
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
        AdoptUserAddress other = (AdoptUserAddress) that;
        return (this.getUserAddressId() == null ? other.getUserAddressId() == null : this.getUserAddressId().equals(other.getUserAddressId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getConsigneeName() == null ? other.getConsigneeName() == null : this.getConsigneeName().equals(other.getConsigneeName()))
            && (this.getConsigneePhone() == null ? other.getConsigneePhone() == null : this.getConsigneePhone().equals(other.getConsigneePhone()))
            && (this.getProvince() == null ? other.getProvince() == null : this.getProvince().equals(other.getProvince()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getAreas() == null ? other.getAreas() == null : this.getAreas().equals(other.getAreas()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getAddressState() == null ? other.getAddressState() == null : this.getAddressState().equals(other.getAddressState()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
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
        result = prime * result + ((getUserAddressId() == null) ? 0 : getUserAddressId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getConsigneeName() == null) ? 0 : getConsigneeName().hashCode());
        result = prime * result + ((getConsigneePhone() == null) ? 0 : getConsigneePhone().hashCode());
        result = prime * result + ((getProvince() == null) ? 0 : getProvince().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getAreas() == null) ? 0 : getAreas().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getAddressState() == null) ? 0 : getAddressState().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}