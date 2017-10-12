package com.zxjz.entity;

public class MerchantsBillsInfo {
    private int userId;//用户ID
    private int currentAccountNumber;//流水账序号
    private String accountingTime;//记账时间
    private String referenceBillClassification;//分类
    private String description;//说明
    private double amount;//金额
    private String merchantsName;//商户名称
    private int referencesTheInternalSerialNumber1;//票据id
    private int targetId;//
    private int workId;//工作ID

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCurrentAccountNumber() {
        return currentAccountNumber;
    }

    public void setCurrentAccountNumber(int currentAccountNumber) {
        this.currentAccountNumber = currentAccountNumber;
    }

    public String getAccountingTime() {
        return accountingTime;
    }

    public void setAccountingTime(String accountingTime) {
        this.accountingTime = accountingTime;
    }

    public String getReferenceBillClassification() {
        return referenceBillClassification;
    }

    public void setReferenceBillClassification(String referenceBillClassification) {
        this.referenceBillClassification = referenceBillClassification;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getMerchantsName() {
        return merchantsName;
    }

    public void setMerchantsName(String merchantsName) {
        this.merchantsName = merchantsName;
    }

    public int getReferencesTheInternalSerialNumber1() {
        return referencesTheInternalSerialNumber1;
    }

    public void setReferencesTheInternalSerialNumber1(int referencesTheInternalSerialNumber1) {
        this.referencesTheInternalSerialNumber1 = referencesTheInternalSerialNumber1;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public int getWorkId() {
        return workId;
    }

    public void setWorkId(int workId) {
        this.workId = workId;
    }

    @Override
    public String toString() {
        return "MerchantsBillsInfo{" +
                "userId=" + userId +
                ", currentAccountNumber=" + currentAccountNumber +
                ", accountingTime='" + accountingTime + '\'' +
                ", referenceBillClassification='" + referenceBillClassification + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", merchantsName='" + merchantsName + '\'' +
                ", referencesTheInternalSerialNumber1=" + referencesTheInternalSerialNumber1 +
                ", targetId=" + targetId +
                ", workId=" + workId +
                '}';
    }
}
