package com.zxjz.entity;

/**
 * Created by Administrator on 2017/10/11 0011.
 */
public class MerchantAccount {
     private int userId;
     private String merchantsName;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMerchantsName() {
        return merchantsName;
    }

    public void setMerchantsName(String merchantsName) {
        this.merchantsName = merchantsName;
    }

    @Override
    public String toString() {
        return "MerchantAccount{" +
                "userId=" + userId +
                ", merchantsName='" + merchantsName + '\'' +
                '}';
    }
}
