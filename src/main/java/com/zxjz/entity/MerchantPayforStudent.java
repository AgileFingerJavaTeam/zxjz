package com.zxjz.entity;

public class MerchantPayforStudent {
    private int userId; //用户id
    private int workId;//工作id
    private int settlementNum;//结算序号
    private String settlementTime;//结算时间
    private double totalPayAmount;//应发工资金额
    private double wageDeductions;//扣减金额
    private String deductingReason;//扣减原因
    private double bounty;//奖励金额
    private String rewardsCausation;//奖励原因
    private double finalPay;//实发金额
    private String merchantsName;//商户名称
    private String postName;//岗位名称

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
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

    public String getMerchantsName() {
        return merchantsName;
    }

    public void setMerchantsName(String merchantsName) {
        this.merchantsName = merchantsName;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    @Override
    public String toString() {
        return "MerchantPayforStudent{" +
                "userId=" + userId +
                ", workId=" + workId +
                ", settlementNum=" + settlementNum +
                ", settlementTime='" + settlementTime + '\'' +
                ", totalPayAmount=" + totalPayAmount +
                ", wageDeductions=" + wageDeductions +
                ", deductingReason='" + deductingReason + '\'' +
                ", bounty=" + bounty +
                ", rewardsCausation='" + rewardsCausation + '\'' +
                ", finalPay=" + finalPay +
                ", merchantsName='" + merchantsName + '\'' +
                ", postName='" + postName + '\'' +
                '}';
    }
}
