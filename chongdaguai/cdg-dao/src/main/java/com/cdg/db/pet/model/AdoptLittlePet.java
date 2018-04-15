package com.cdg.db.pet.model;

import java.io.Serializable;

/**
* auto generate
* @date 2018-01-08 18:12:20
 *
 * @author aicuishou
 */
public class AdoptLittlePet implements Serializable {
    /**
     * 自增长id
     */
    public Long petId;

    /**
     * 名称
     */
    public String name;

    /**
     * 性别：0女  1男
     */
    public Byte sex;

    /**
     * 生日
     */
    public Long birthday;

    /**
     * 品种
     */
    public String breed;

    /**
     * 体重
     */
    public Integer weight;

    /**
     * 是否节育 0-未节育 1-节育
     */
    public Byte birthControl;

    /**
     * 所在地
     */
    public String location;

    /**
     * 上次疫苗时间
     */
    public Long vaccineTime;

    /**
     * 小乖想说
     */
    public String petTell;

    /**
     * 备注：已驱虫;已打疫苗
     */
    public String comment;

    /**
     * 多张照片用 分号 分隔
     */
    public String headPortraits;

    /**
     * 浏览次数
     */
    public Integer browseCount;

    /**
     * 0-删除 1-启用 2-停用
     */
    public Byte petState;

    /**
     * 
     */
    public Long createTime;

    /**
     * 
     */
    public Long updateTime;

    /**
     * adopt_little_ped
     */
    public static final long serialVersionUID = 1L;

    /**
     * 自增长id
     * @return pet_id 自增长id
     */
    public Long getPetId() {
        return petId;
    }

    /**
     * 自增长id
     * @param petId 自增长id
     */
    public void setPetId(Long petId) {
        this.petId = petId;
    }

    /**
     * 名称
     * @return name 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 性别：0女  1男
     * @return sex 性别：0女  1男
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 性别：0女  1男
     * @param sex 性别：0女  1男
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 生日
     * @return birthday 生日
     */
    public Long getBirthday() {
        return birthday;
    }

    /**
     * 生日
     * @param birthday 生日
     */
    public void setBirthday(Long birthday) {
        this.birthday = birthday;
    }

    /**
     * 品种
     * @return breed 品种
     */
    public String getBreed() {
        return breed;
    }

    /**
     * 品种
     * @param breed 品种
     */
    public void setBreed(String breed) {
        this.breed = breed == null ? null : breed.trim();
    }

    /**
     * 体重
     * @return weight 体重
     */
    public Integer getWeight() {
        return weight;
    }

    /**
     * 体重
     * @param weight 体重
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /**
     * 是否节育 0-未节育 1-节育
     * @return birth_control 是否节育 0-未节育 1-节育
     */
    public Byte getBirthControl() {
        return birthControl;
    }

    /**
     * 是否节育 0-未节育 1-节育
     * @param birthControl 是否节育 0-未节育 1-节育
     */
    public void setBirthControl(Byte birthControl) {
        this.birthControl = birthControl;
    }

    /**
     * 所在地
     * @return location 所在地
     */
    public String getLocation() {
        return location;
    }

    /**
     * 所在地
     * @param location 所在地
     */
    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    /**
     * 上次疫苗时间
     * @return vaccine_time 上次疫苗时间
     */
    public Long getVaccineTime() {
        return vaccineTime;
    }

    /**
     * 上次疫苗时间
     * @param vaccineTime 上次疫苗时间
     */
    public void setVaccineTime(Long vaccineTime) {
        this.vaccineTime = vaccineTime;
    }

    /**
     * 小乖想说
     * @return pet_tell 小乖想说
     */
    public String getPetTell() {
        return petTell;
    }

    /**
     * 小乖想说
     * @param petTell 小乖想说
     */
    public void setPetTell(String petTell) {
        this.petTell = petTell == null ? null : petTell.trim();
    }

    /**
     * 备注：已驱虫;已打疫苗
     * @return comment 备注：已驱虫;已打疫苗
     */
    public String getComment() {
        return comment;
    }

    /**
     * 备注：已驱虫;已打疫苗
     * @param comment 备注：已驱虫;已打疫苗
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    /**
     * 多张照片用 分号 分隔
     * @return head_portraits 多张照片用 分号 分隔
     */
    public String getHeadPortraits() {
        return headPortraits;
    }

    /**
     * 多张照片用 分号 分隔
     * @param headPortraits 多张照片用 分号 分隔
     */
    public void setHeadPortraits(String headPortraits) {
        this.headPortraits = headPortraits == null ? null : headPortraits.trim();
    }

    /**
     * 浏览次数
     * @return browse_count 浏览次数
     */
    public Integer getBrowseCount() {
        return browseCount;
    }

    /**
     * 浏览次数
     * @param browseCount 浏览次数
     */
    public void setBrowseCount(Integer browseCount) {
        this.browseCount = browseCount;
    }

    /**
     * 0-删除 1-启用 2-停用
     * @return pet_state 0-删除 1-启用 2-停用
     */
    public Byte getPetState() {
        return petState;
    }

    /**
     * 0-删除 1-启用 2-停用
     * @param petState 0-删除 1-启用 2-停用
     */
    public void setPetState(Byte petState) {
        this.petState = petState;
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
    * @date 2018-01-08 18:12:20
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
        AdoptLittlePet other = (AdoptLittlePet) that;
        return (this.getPetId() == null ? other.getPetId() == null : this.getPetId().equals(other.getPetId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(other.getBirthday()))
            && (this.getBreed() == null ? other.getBreed() == null : this.getBreed().equals(other.getBreed()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getBirthControl() == null ? other.getBirthControl() == null : this.getBirthControl().equals(other.getBirthControl()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getVaccineTime() == null ? other.getVaccineTime() == null : this.getVaccineTime().equals(other.getVaccineTime()))
            && (this.getPetTell() == null ? other.getPetTell() == null : this.getPetTell().equals(other.getPetTell()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()))
            && (this.getHeadPortraits() == null ? other.getHeadPortraits() == null : this.getHeadPortraits().equals(other.getHeadPortraits()))
            && (this.getBrowseCount() == null ? other.getBrowseCount() == null : this.getBrowseCount().equals(other.getBrowseCount()))
            && (this.getPetState() == null ? other.getPetState() == null : this.getPetState().equals(other.getPetState()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
    * auto generate
    * @return int
    * @date 2018-01-08 18:12:20
     *
     * @author aicuishou
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPetId() == null) ? 0 : getPetId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
        result = prime * result + ((getBreed() == null) ? 0 : getBreed().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getBirthControl() == null) ? 0 : getBirthControl().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getVaccineTime() == null) ? 0 : getVaccineTime().hashCode());
        result = prime * result + ((getPetTell() == null) ? 0 : getPetTell().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
        result = prime * result + ((getHeadPortraits() == null) ? 0 : getHeadPortraits().hashCode());
        result = prime * result + ((getBrowseCount() == null) ? 0 : getBrowseCount().hashCode());
        result = prime * result + ((getPetState() == null) ? 0 : getPetState().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}