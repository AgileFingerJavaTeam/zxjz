package com.zxjz.entity;

/**
 * Created by Administrator on 2017/9/30 0030.
 */
public class CheckBill {
    private String isPayWages; //是否平台代付
    private String settlementTime; //结算时间
    private double finalPay; //实发金额
    private String postName; //岗位名称
    private String name; //大学生姓名

    public String getIsPayWages() {
        return isPayWages;
    }

    public void setIsPayWages(String isPayWages) {
        this.isPayWages = isPayWages;
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

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CheckBill{" +
                "isPayWages='" + isPayWages + '\'' +
                ", settlementTime='" + settlementTime + '\'' +
                ", finalPay=" + finalPay +
                ", postName='" + postName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
