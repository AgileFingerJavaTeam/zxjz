package com.zxjz.entity;

/**
 * Created by Administrator on 2017/9/30 0030.
 */
public class CreditAndPayment {
    private int userId;//用户id
    private String merchantsName;//商户名称
    private int jobId;//行业id
    private String text;//行业名称
    private String head;//负责人
    private String phone;//电话
    private double accountBalance;
    private Double creditTotal;//授信总额
    private Double creditBalance;//授信余额
    private String paymentDays;//账期
    private Double debt;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getMerchantsName() {
        return merchantsName;
    }

    public void setMerchantsName(String merchantsName) {
        this.merchantsName = merchantsName;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Double getCreditTotal() {
        return creditTotal;
    }

    public void setCreditTotal(Double creditTotal) {
        this.creditTotal = creditTotal;
    }

    public Double getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(Double creditBalance) {
        this.creditBalance = creditBalance;
    }

    public String getPaymentDays() {
        return paymentDays;
    }

    public void setPaymentDays(String paymentDays) {
        this.paymentDays = paymentDays;
    }

    public Double getDebt() {
        return debt;
    }

    public void setDebt(Double debt) {
        this.debt = debt;
    }



    @Override
    public String toString() {
        return "CreditAndPayment{" +
                "userId=" + userId +
                ", merchantsName='" + merchantsName + '\'' +
                ", jobId=" + jobId +
                ", text='" + text + '\'' +
                ", head='" + head + '\'' +
                ", phone='" + phone + '\'' +
                ", accountBalance='" + accountBalance + '\'' +
                ", creditTotal=" + creditTotal +
                ", creditBalance=" + creditBalance +
                ", paymentDays='" + paymentDays + '\'' +
                ", debt=" + debt +
                '}';
    }
}
