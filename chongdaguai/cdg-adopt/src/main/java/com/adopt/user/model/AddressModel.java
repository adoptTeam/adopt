package com.adopt.user.model;

import com.cdg.db.user.model.AdoptUserAddress;

/**
 * @author zhenghao
 * @description
 * @date 2018/2/23 22:32
 */

public class AddressModel extends AdoptUserAddress {
    private boolean defaultAddress = false;

    public boolean isDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(boolean defaultAddress) {
        this.defaultAddress = defaultAddress;
    }
}
