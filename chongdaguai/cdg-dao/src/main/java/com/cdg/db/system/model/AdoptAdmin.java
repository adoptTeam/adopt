package com.cdg.db.system.model;

import java.io.Serializable;

/**
* auto generate
* @date 2018-01-03 10:35:32
 *
 * @author aicuishou
 */
public class AdoptAdmin implements Serializable {
    /**
     * 
     */
    private Long adminId;

    /**
     * 账号
     */
    private String workAccount;

    /**
     * 密码
     */
    private String password;

    /**
     * 状态 0-删除 1-启用 2-停用
     */
    private Byte adminState;

    /**
     * adopt_admin
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @return admin_id 
     */
    public Long getAdminId() {
        return adminId;
    }

    /**
     * 
     * @param adminId 
     */
    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    /**
     * 账号
     * @return work_account 账号
     */
    public String getWorkAccount() {
        return workAccount;
    }

    /**
     * 账号
     * @param workAccount 账号
     */
    public void setWorkAccount(String workAccount) {
        this.workAccount = workAccount == null ? null : workAccount.trim();
    }

    /**
     * 密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 状态 0-删除 1-启用 2-停用
     * @return admin_state 状态 0-删除 1-启用 2-停用
     */
    public Byte getAdminState() {
        return adminState;
    }

    /**
     * 状态 0-删除 1-启用 2-停用
     * @param adminState 状态 0-删除 1-启用 2-停用
     */
    public void setAdminState(Byte adminState) {
        this.adminState = adminState;
    }

    /**
    * auto generate
    * @param that
    * @return boolean
    * @date 2018-01-03 10:35:32
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
        AdoptAdmin other = (AdoptAdmin) that;
        return (this.getAdminId() == null ? other.getAdminId() == null : this.getAdminId().equals(other.getAdminId()))
            && (this.getWorkAccount() == null ? other.getWorkAccount() == null : this.getWorkAccount().equals(other.getWorkAccount()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getAdminState() == null ? other.getAdminState() == null : this.getAdminState().equals(other.getAdminState()));
    }

    /**
    * auto generate
    * @return int
    * @date 2018-01-03 10:35:32
     *
     * @author aicuishou
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdminId() == null) ? 0 : getAdminId().hashCode());
        result = prime * result + ((getWorkAccount() == null) ? 0 : getWorkAccount().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getAdminState() == null) ? 0 : getAdminState().hashCode());
        return result;
    }
}