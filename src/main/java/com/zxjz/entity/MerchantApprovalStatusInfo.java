package com.zxjz.entity;

public class MerchantApprovalStatusInfo {
    private String status;
    private String head;
    private String companyName;
    private String phone;
    private int userId;
    private int recruitingId;
    private int studentUserId;
    private String merchantsName;
    private String merchantsShort;
    private String accountBalance;
    private String creditBalance;
    private String PaymentDays;
    private String job;
    private String stateJudgement;
    private String creditTotal;
    private String payPassword;
    private String payTime;
    private String isPassword;
    private String portraitUrl;//头像地址
    private String note;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

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

    public int getStudentUserId() {
        return studentUserId;
    }

    public void setStudentUserId(int studentUserId) {
        this.studentUserId = studentUserId;
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

    public String getPortraitUrl() {
        return portraitUrl;
    }

    public void setPortraitUrl(String portraitUrl) {
        this.portraitUrl = portraitUrl;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "MerchantApprovalStatusInfo{" +
                "status='" + status + '\'' +
                ", head='" + head + '\'' +
                ", companyName='" + companyName + '\'' +
                ", phone='" + phone + '\'' +
                ", userId=" + userId +
                ", recruitingId=" + recruitingId +
                ", studentUserId=" + studentUserId +
                ", merchantsName='" + merchantsName + '\'' +
                ", merchantsShort='" + merchantsShort + '\'' +
                ", accountBalance='" + accountBalance + '\'' +
                ", creditBalance='" + creditBalance + '\'' +
                ", PaymentDays='" + PaymentDays + '\'' +
                ", job='" + job + '\'' +
                ", stateJudgement='" + stateJudgement + '\'' +
                ", creditTotal='" + creditTotal + '\'' +
                ", payPassword='" + payPassword + '\'' +
                ", payTime='" + payTime + '\'' +
                ", isPassword='" + isPassword + '\'' +
                ", portraitUrl='" + portraitUrl + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
