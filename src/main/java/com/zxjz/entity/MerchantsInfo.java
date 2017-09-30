package com.zxjz.entity;

public class MerchantsInfo {
    private int userId;
    private int recruitingId;
    private int student_userId;
    private String head;
    private String merchantsName;
    private String merchantsShort;
    private String accountBalance;
    private String creditBalance;
    private String PaymentDays;
    private String phone;
    private String job;
    private String stateJudgement;
    private String portraitUrl;
    private String creditTotal;
    private String payPassword;
    private String payTime;
    private String isPassword;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRecruitingId() {
        return recruitingId;
    }

    public void setRecruitingId(int recruitingId) {
        this.recruitingId = recruitingId;
    }

    public int getStudent_userId() {
        return student_userId;
    }

    public void setStudent_userId(int student_userId) {
        this.student_userId = student_userId;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getMerchantsName() {
        return merchantsName;
    }

    public void setMerchantsName(String merchantsName) {
        this.merchantsName = merchantsName;
    }

    public String getMerchantsShort() {
        return merchantsShort;
    }

    public void setMerchantsShort(String merchantsShort) {
        this.merchantsShort = merchantsShort;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getCreditBalance() {
        return creditBalance;
    }

    public void setCreditBalance(String creditBalance) {
        this.creditBalance = creditBalance;
    }

    public String getPaymentDays() {
        return PaymentDays;
    }

    public void setPaymentDays(String paymentDays) {
        PaymentDays = paymentDays;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getStateJudgement() {
        return stateJudgement;
    }

    public void setStateJudgement(String stateJudgement) {
        this.stateJudgement = stateJudgement;
    }

    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
    }

    public String getCreditTotal() {
        return creditTotal;
    }

    public void setCreditTotal(String creditTotal) {
        this.creditTotal = creditTotal;
    }

    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getIsPassword() {
        return isPassword;
    }

    public void setIsPassword(String isPassword) {
        this.isPassword = isPassword;
    }

    @Override
    public String toString() {
        return "MerchantsInfo{" +
                "userId=" + userId +
                ", recruitingId=" + recruitingId +
                ", student_userId=" + student_userId +
                ", head='" + head + '\'' +
                ", merchantsName='" + merchantsName + '\'' +
                ", merchantsShort='" + merchantsShort + '\'' +
                ", accountBalance='" + accountBalance + '\'' +
                ", creditBalance='" + creditBalance + '\'' +
                ", PaymentDays='" + PaymentDays + '\'' +
                ", phone='" + phone + '\'' +
                ", job='" + job + '\'' +
                ", stateJudgement='" + stateJudgement + '\'' +
                ", portraitUrl='" + portraitUrl + '\'' +
                ", creditTotal='" + creditTotal + '\'' +
                ", payPassword='" + payPassword + '\'' +
                ", payTime='" + payTime + '\'' +
                ", isPassword='" + isPassword + '\'' +
                '}';
    }
}
