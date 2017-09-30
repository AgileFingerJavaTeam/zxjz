package com.zxjz.dto.in;

public class MerchantsUpgradeDto {
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    @Override
    public String toString() {
        return "MerchantsUpgradeDto{" +
                "userId=" + userId +
                '}';
    }
}
