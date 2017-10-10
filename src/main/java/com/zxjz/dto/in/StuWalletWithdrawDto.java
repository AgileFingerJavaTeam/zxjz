package com.zxjz.dto.in;

public class StuWalletWithdrawDto {
    private  int userid;
    private  double money;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "StuWalletWithdrawDto{" +
                "userid=" + userid +
                ", money=" + money +
                '}';
    }
}
