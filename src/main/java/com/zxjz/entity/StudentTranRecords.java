package com.zxjz.entity;

public class StudentTranRecords {
    private int workId;//工作ID
    private String postName;//岗位名称
    private String settlementMethod;//结算方式
    private int settlementNum;//结算序号
    private String settlementTime;//结算时间
    private double totalPayAmount;//应发工资金额
    private double wageDeductions;//扣减金额
    private String deductingReason;//扣减原因
    private double bounty;//奖励金额
    private String rewardsCausation;//奖励原因
    private double finalPay;//实发金额

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getSettlementMethod() {
        return settlementMethod;
    }

    public void setSettlementMethod(String settlementMethod) {
        this.settlementMethod = settlementMethod;
    }

    public int getSettlementNum() {
        return settlementNum;
    }

    public void setSettlementNum(int settlementNum) {
        this.settlementNum = settlementNum;
    }

    public String getSettlementTime() {
        return settlementTime;
    }

    public void setSettlementTime(String settlementTime) {
        this.settlementTime = settlementTime;
    }

    public double getTotalPayAmount() {
        return totalPayAmount;
    }

    public void setTotalPayAmount(double totalPayAmount) {
        this.totalPayAmount = totalPayAmount;
    }

    public double getWageDeductions() {
        return wageDeductions;
    }

    public void setWageDeductions(double wageDeductions) {
        this.wageDeductions = wageDeductions;
    }

    public String getDeductingReason() {
        return deductingReason;
    }

    public void setDeductingReason(String deductingReason) {
        this.deductingReason = deductingReason;
    }

    public double getBounty() {
        return bounty;
    }

    public void setBounty(double bounty) {
        this.bounty = bounty;
    }

    public String getRewardsCausation() {
        return rewardsCausation;
    }

    public void setRewardsCausation(String rewardsCausation) {
        this.rewardsCausation = rewardsCausation;
    }

    public double getFinalPay() {
        return finalPay;
    }

    public void setFinalPay(double finalPay) {
        this.finalPay = finalPay;
    }

    @Override
    public String toString() {
        return "StudentTranRecords{" +
                "workId=" + workId +
                ", postName='" + postName + '\'' +
                ", settlementMethod='" + settlementMethod + '\'' +
                ", settlementNum=" + settlementNum +
                ", settlementTime='" + settlementTime + '\'' +
                ", totalPayAmount=" + totalPayAmount +
                ", wageDeductions=" + wageDeductions +
                ", deductingReason='" + deductingReason + '\'' +
                ", bounty=" + bounty +
                ", rewardsCausation='" + rewardsCausation + '\'' +
                ", finalPay=" + finalPay +
                '}';
    }
}
