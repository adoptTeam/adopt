/*
 * Copyright (C) 2016-2020 jindan.com Corporation
 *
 */
package com.adopt.user.model;

import com.cdg.db.pet.model.AdoptLittlePet;
import com.cdg.db.system.model.AdoptLogisticsInfo;
import com.cdg.db.user.model.AdoptUser;
import com.cdg.db.user.model.AdoptUserAddress;

import java.util.List;

/**
 * 领养信息
 *
 * @author cuiweilin.
 */
public class AdoptInfo {

    /**
     * 用户信息
     */
    private AdoptUser user;

    /**
     * 领养小乖信息
     */
    private AdoptLittlePet adoptLittlePet;

    /**
     * 物流信息
     */
    private List<AdoptLogisticsInfo> adoptLogisticsInfos;

    /**
     * 用户地址
     */
    private AdoptUserAddress adoptUserAddress;

    /**
     * 收养天数
     */
    private int adoptDays;

    /**
     * 距离现在的的下单时间:分钟
     */
    private Long disToNowMin;
    /**
     * 距离现在的的下单时间：秒
     */
    private Long disToNowSec;

    /**
     * 小乖备注
     */
    private String commentContent;

    public int getAdoptDays() {
        return adoptDays;
    }

    public void setAdoptDays(int adoptDays) {
        this.adoptDays = adoptDays;
    }

    public AdoptUserAddress getAdoptUserAddress() {
        return adoptUserAddress;
    }

    public void setAdoptUserAddress(AdoptUserAddress adoptUserAddress) {
        this.adoptUserAddress = adoptUserAddress;
    }

    public AdoptUser getUser() {
        return user;
    }

    public void setUser(AdoptUser user) {
        this.user = user;
    }

    public AdoptLittlePet getAdoptLittlePet() {
        return adoptLittlePet;
    }

    public void setAdoptLittlePet(AdoptLittlePet adoptLittlePet) {
        this.adoptLittlePet = adoptLittlePet;
    }

    public List<AdoptLogisticsInfo> getAdoptLogisticsInfos() {
        return adoptLogisticsInfos;
    }

    public void setAdoptLogisticsInfos(List<AdoptLogisticsInfo> adoptLogisticsInfos) {
        this.adoptLogisticsInfos = adoptLogisticsInfos;
    }

    public Long getDisToNowMin() {
        return disToNowMin;
    }

    public void setDisToNowMin(Long disToNowMin) {
        this.disToNowMin = disToNowMin;
    }

    public Long getDisToNowSec() {
        return disToNowSec;
    }

    public void setDisToNowSec(Long disToNowSec) {
        this.disToNowSec = disToNowSec;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }
}
