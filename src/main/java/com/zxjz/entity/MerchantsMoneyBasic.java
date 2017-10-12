package com.zxjz.entity;

/**
 * Created by Administrator on 2017/10/12 0012.
 */
public class MerchantsMoneyBasic {

       private int userId;
       private String accountBalance;
       private String alipayId;
       private String wechatId;
       private double creditTotal;
       private double creditBalance;
       private String PaymentDays;
       private String payPsw;
       private int isNeedPsw;
       private int notNeedPswPeriod;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAlipayId() {
        return alipayId;
    }

    public void setAlipayId(String alipayId) {
        this.alipayId = alipayId;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public double getCreditTotal() {
        return creditTotal;
    }

    public void setCreditTotal(double creditTotal) {
        this.creditTotal = creditTotal;
    }

    public double getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(double creditBalance) {
        this.creditBalance = creditBalance;
    }

    public String getPaymentDays() {
        return PaymentDays;
    }

    public void setPaymentDays(String paymentDays) {
        PaymentDays = paymentDays;
    }

    public String getPayPsw() {
        return payPsw;
    }

    public void setPayPsw(String payPsw) {
        this.payPsw = payPsw;
    }

    public int getIsNeedPsw() {
        return isNeedPsw;
    }

    public void setIsNeedPsw(int isNeedPsw) {
        this.isNeedPsw = isNeedPsw;
    }

    public int getNotNeedPswPeriod() {
        return notNeedPswPeriod;
    }

    public void setNotNeedPswPeriod(int notNeedPswPeriod) {
        this.notNeedPswPeriod = notNeedPswPeriod;
    }

    @Override
    public String toString() {
        return "MerchantsMoneyBasic{" +
                "userId=" + userId +
                ", accountBalance='" + accountBalance + '\'' +
                ", alipayId='" + alipayId + '\'' +
                ", wechatId='" + wechatId + '\'' +
                ", creditTotal=" + creditTotal +
                ", creditBalance=" + creditBalance +
                ", PaymentDays='" + PaymentDays + '\'' +
                ", payPsw='" + payPsw + '\'' +
                ", isNeedPsw=" + isNeedPsw +
                ", notNeedPswPeriod=" + notNeedPswPeriod +
                '}';
    }
}
