package com.zxjz.entity;

public class BillList {
    private String name;//学生名称
    private String headPic;//学生头像
    private String postName;//岗位名称
    private String settlementTime;//结算时间
    private double finalPay;//实发金额

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getSettlementTime() {
        return settlementTime;
    }

    public void setSettlementTime(String settlementTime) {
        this.settlementTime = settlementTime;
    }

    public double getFinalPay() {
        return finalPay;
    }

    public void setFinalPay(double finalPay) {
        this.finalPay = finalPay;
    }

    @Override
    public String toString() {
        return "BillList{" +
                "name='" + name + '\'' +
                ", headPic='" + headPic + '\'' +
                ", postName='" + postName + '\'' +
                ", settlementTime='" + settlementTime + '\'' +
                ", finalPay=" + finalPay +
                '}';
    }
}
