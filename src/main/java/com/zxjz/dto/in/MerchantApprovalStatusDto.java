package com.zxjz.dto.in;

public class MerchantApprovalStatusDto {
    private int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "MerchantApprovalStatusDto{" +
                "user_id=" + user_id +
                '}';
    }
}
