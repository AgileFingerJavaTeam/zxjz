package com.zxjz.dto.in;

public class StuJobDto {
    private  int userid;
    private  int type;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "StuJobDto{" +
                "userid=" + userid +
                ", type=" + type +
                '}';
    }
}
