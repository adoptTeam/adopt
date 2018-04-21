package com.adopt.user.model;

import com.cdg.db.user.model.AdoptUserAddress;

/**
 * @author hemingguang
 * @description
 * @date 2018/04/21 22:32
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
