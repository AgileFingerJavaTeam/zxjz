package com.zxjz.dto.in;

public class StuWalletDto {
    private  int userid;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "StuWalletDto{" +
                "userid=" + userid +
                '}';
    }
}
