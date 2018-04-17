/*
 * Copyright (C) 2016-2020 jindan.com Corporation
 *
 */
package com.cdg.db.enhance.model;

/**
 * 后台查询
 *
 * @author cuiweilin.
 */
public class AdoptSearch {

    /**
     * 地址中的姓名
     */
    private String addressName;

    /**
     * 地址中的电话
     */
    private String addressPhone;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 真是姓名
     */
    private String realName;

    /**
     * 领养状态 10-初始化 20-已付款 30-发送中 40-体验中 50-申请退还 60已退还
     */
    private Byte adoptState;

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getAddressPhone() {
        return addressPhone;
    }

    public void setAddressPhone(String addressPhone) {
        this.addressPhone = addressPhone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Byte getAdoptState() {
        return adoptState;
    }

    public void setAdoptState(Byte adoptState) {
        this.adoptState = adoptState;
    }
}
