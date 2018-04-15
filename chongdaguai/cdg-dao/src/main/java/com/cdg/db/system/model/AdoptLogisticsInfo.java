package com.cdg.db.system.model;

import java.io.Serializable;

/**
* auto generate
* @date 2018-01-03 10:34:19
 *
 * @author aicuishou
 */
public class AdoptLogisticsInfo implements Serializable {
    /**
     * 自增id
     */
    private Long logisticsId;

    /**
     * 领养id
     */
    private Long adoptId;

    /**
     * 物流信息
     */
    private String logisticsContent;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;

    /**
     * adopt_logistics_info
     */
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     * @return logistics_id 自增id
     */
    public Long getLogisticsId() {
        return logisticsId;
    }

    /**
     * 自增id
     * @param logisticsId 自增id
     */
    public void setLogisticsId(Long logisticsId) {
        this.logisticsId = logisticsId;
    }

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
     * 物流信息
     * @return logistics_content 物流信息
     */
    public String getLogisticsContent() {
        return logisticsContent;
    }

    /**
     * 物流信息
     * @param logisticsContent 物流信息
     */
    public void setLogisticsContent(String logisticsContent) {
        this.logisticsContent = logisticsContent == null ? null : logisticsContent.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Long getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新时间
     * @return update_time 更新时间
     */
    public Long getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    /**
    * auto generate
    * @param that
    * @return boolean
    * @date 2018-01-03 10:34:19
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
        AdoptLogisticsInfo other = (AdoptLogisticsInfo) that;
        return (this.getLogisticsId() == null ? other.getLogisticsId() == null : this.getLogisticsId().equals(other.getLogisticsId()))
            && (this.getAdoptId() == null ? other.getAdoptId() == null : this.getAdoptId().equals(other.getAdoptId()))
            && (this.getLogisticsContent() == null ? other.getLogisticsContent() == null : this.getLogisticsContent().equals(other.getLogisticsContent()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    /**
    * auto generate
    * @return int
    * @date 2018-01-03 10:34:19
     *
     * @author aicuishou
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLogisticsId() == null) ? 0 : getLogisticsId().hashCode());
        result = prime * result + ((getAdoptId() == null) ? 0 : getAdoptId().hashCode());
        result = prime * result + ((getLogisticsContent() == null) ? 0 : getLogisticsContent().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}