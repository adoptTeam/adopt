package com.cdg.db.system.model;

import java.io.Serializable;

/**
* auto generate
* @date 2018-01-03 10:22:21
 *
 * @author aicuishou
 */
public class AdoptSysAddress implements Serializable {
    /**
     * 
     */
    private Long addressId;

    /**
     * 0 省 1市 2区
     */
    private Byte type;

    /**
     * 名称
     */
    private String name;

    /**
     * 别名
     */
    private String alias;

    /**
     * 
     */
    private Long pid;

    /**
     * adopt_sys_address
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @return address_id 
     */
    public Long getAddressId() {
        return addressId;
    }

    /**
     * 
     * @param addressId 
     */
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    /**
     * 0 省 1市 2区
     * @return type 0 省 1市 2区
     */
    public Byte getType() {
        return type;
    }

    /**
     * 0 省 1市 2区
     * @param type 0 省 1市 2区
     */
    public void setType(Byte type) {
        this.type = type;
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
     * 别名
     * @return alias 别名
     */
    public String getAlias() {
        return alias;
    }

    /**
     * 别名
     * @param alias 别名
     */
    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    /**
     * 
     * @return pid 
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 
     * @param pid 
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
    * auto generate
    * @param that
    * @return boolean
    * @date 2018-01-03 10:22:21
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
        AdoptSysAddress other = (AdoptSysAddress) that;
        return (this.getAddressId() == null ? other.getAddressId() == null : this.getAddressId().equals(other.getAddressId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAlias() == null ? other.getAlias() == null : this.getAlias().equals(other.getAlias()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()));
    }

    /**
    * auto generate
    * @return int
    * @date 2018-01-03 10:22:21
     *
     * @author aicuishou
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAddressId() == null) ? 0 : getAddressId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAlias() == null) ? 0 : getAlias().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        return result;
    }
}