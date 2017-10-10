package com.zxjz.dto.in;

public class StuWalletIncomeDto {
    private  int userid;
    private  String start;
    private  String end;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "StuWalletIncomeDto{" +
                "userid=" + userid +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
