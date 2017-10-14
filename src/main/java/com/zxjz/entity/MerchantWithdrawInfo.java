package com.zxjz.entity;

public class MerchantWithdrawInfo {
    private int userId;//商户ID
    private int withdrawalSequenceNumber;//提现序号
    private String withdrawalTime;//提现时间
    private int cashWithdrawal;//体现方式
    private String withdrawalModeName;//提现方式名称
    private double withdrawalAmount;//提现金额
    private int paymentPlatformFlowNumber;//支付平台流水号
    private String merchantsName;//商户名称

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getWithdrawalSequenceNumber() {
        return withdrawalSequenceNumber;
    }

    public void setWithdrawalSequenceNumber(int withdrawalSequenceNumber) {
        this.withdrawalSequenceNumber = withdrawalSequenceNumber;
    }

    public String getWithdrawalTime() {
        return withdrawalTime;
    }

    public void setWithdrawalTime(String withdrawalTime) {
        this.withdrawalTime = withdrawalTime;
    }

    public int getCashWithdrawal() {
        return cashWithdrawal;
    }

    public void setCashWithdrawal(int cashWithdrawal) {
        this.cashWithdrawal = cashWithdrawal;
    }

    public String getWithdrawalModeName() {
        return withdrawalModeName;
    }

    public void setWithdrawalModeName(String withdrawalModeName) {
        this.withdrawalModeName = withdrawalModeName;
    }

    public double getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public void setWithdrawalAmount(double withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    public int getPaymentPlatformFlowNumber() {
        return paymentPlatformFlowNumber;
    }

    public void setPaymentPlatformFlowNumber(int paymentPlatformFlowNumber) {
        this.paymentPlatformFlowNumber = paymentPlatformFlowNumber;
    }

    public String getMerchantsName() {
        return merchantsName;
    }

    public void setMerchantsName(String merchantsName) {
        this.merchantsName = merchantsName;
    }

    @Override
    public String toString() {
        return "MerchantWithdrawInfo{" +
                "userId=" + userId +
                ", withdrawalSequenceNumber=" + withdrawalSequenceNumber +
                ", withdrawalTime='" + withdrawalTime + '\'' +
                ", cashWithdrawal=" + cashWithdrawal +
                ", withdrawalModeName='" + withdrawalModeName + '\'' +
                ", withdrawalAmount=" + withdrawalAmount +
                ", paymentPlatformFlowNumber=" + paymentPlatformFlowNumber +
                ", merchantsName='" + merchantsName + '\'' +
                '}';
    }
}
