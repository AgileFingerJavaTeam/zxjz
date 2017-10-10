package com.zxjz.entity;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class IsSetPassword {
    private int userId;
    private String payPsw;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPayPsw() {
        return payPsw;
    }

    public void setPayPsw(String payPsw) {
        this.payPsw = payPsw;
    }

    @Override
    public String toString() {
        return "IsSetPassword{" +
                "userId=" + userId +
                ", payPsw='" + payPsw + '\'' +
                '}';
    }
}
