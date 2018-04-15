package com.cdg.db.cash.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
* auto generate
* @date 2018-02-06 00:29:49
 *
 * @author aicuishou
 */
public class AdoptCashInfo implements Serializable {
    /**
     * 
     */
    private Long cashId;

    /**
     * 
     */
    private Long adoptId;

    /**
     * 
     */
    private BigDecimal amount;

    /**
     * 金额描述：缴纳体验承诺金，体验退还，退还中
     */
    private String description;

    /**
     * 备注，申请退还理由
     */
    private String remarks;

    /**
     * 资金状态：0--资金缴纳，1--申请退还，2--已经退还
     */
    private Byte amountState;

    /**
     * 
     */
    private Long updateTime;

    /**
     * 
     */
    private Long createTime;

    /**
     * adopt_cash_info
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @return cash_id 
     */
    public Long getCashId() {
        return cashId;
    }

    /**
     * 
     * @param cashId 
     */
    public void setCashId(Long cashId) {
        this.cashId = cashId;
    }

    /**
     * 
     * @return adopt_id 
     */
    public Long getAdoptId() {
        return adoptId;
    }

    /**
     * 
     * @param adoptId 
     */
    public void setAdoptId(Long adoptId) {
        this.adoptId = adoptId;
    }

    /**
     * 
     * @return amount 
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 
     * @param amount 
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 金额描述：缴纳体验承诺金，体验退还，退还中
     * @return description 金额描述：缴纳体验承诺金，体验退还，退还中
     */
    public String getDescription() {
        return description;
    }

    /**
     * 金额描述：缴纳体验承诺金，体验退还，退还中
     * @param description 金额描述：缴纳体验承诺金，体验退还，退还中
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 备注，申请退还理由
     * @return remarks 备注，申请退还理由
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注，申请退还理由
     * @param remarks 备注，申请退还理由
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 资金状态：0--资金缴纳，1--申请退还，2--已经退还
     * @return amount_state 资金状态：0--资金缴纳，1--申请退还，2--已经退还
     */
    public Byte getAmountState() {
        return amountState;
    }

    /**
     * 资金状态：0--资金缴纳，1--申请退还，2--已经退还
     * @param amountState 资金状态：0--资金缴纳，1--申请退还，2--已经退还
     */
    public void setAmountState(Byte amountState) {
        this.amountState = amountState;
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
    * @date 2018-02-06 00:29:49
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
        AdoptCashInfo other = (AdoptCashInfo) that;
        return (this.getCashId() == null ? other.getCashId() == null : this.getCashId().equals(other.getCashId()))
            && (this.getAdoptId() == null ? other.getAdoptId() == null : this.getAdoptId().equals(other.getAdoptId()))
            && (this.getAmount() == null ? other.getAmount() == null : this.getAmount().equals(other.getAmount()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getAmountState() == null ? other.getAmountState() == null : this.getAmountState().equals(other.getAmountState()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    /**
    * auto generate
    * @return int
    * @date 2018-02-06 00:29:49
     *
     * @author aicuishou
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCashId() == null) ? 0 : getCashId().hashCode());
        result = prime * result + ((getAdoptId() == null) ? 0 : getAdoptId().hashCode());
        result = prime * result + ((getAmount() == null) ? 0 : getAmount().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getAmountState() == null) ? 0 : getAmountState().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}