package com.zxjz.entity;

public class FindMerchantName {
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
        return "FindMerchantName{" +
                "userId=" + userId +
                ", merchantsName='" + merchantsName + '\'' +
                '}';
    }
}
