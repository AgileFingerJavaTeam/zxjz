package com.zxjz.entity;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class MerchantFundsCurrentAccount {
    private int userId;//商户ID
    private int currentAccountNumber;//流水账序号
    private String accountingTime;//记账时间
    private int classification;//分类
    private String description;//描述
    private double amount;//金额
    private String referenceBillClassification;//引用票据分类
    private int referencesTheBillId;//引用票据ID
    private int referencesTheInternalSerialNumber1;//引用票据内部序号1
    private int targetId;//目标ID
    private int workId;//工作ID

    private String rechargeMode;//充值方式
    private String cashWithdrawal;//提现方式
    private String postName;//岗位名称
    private String headPic;//图片url
    private String isPayWages;//是否平台代付工资
    private String name;//大学生姓名

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

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
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

    public String getReferenceBillClassification() {
        return referenceBillClassification;
    }

    public void setReferenceBillClassification(String referenceBillClassification) {
        this.referenceBillClassification = referenceBillClassification;
    }

    public int getReferencesTheBillId() {
        return referencesTheBillId;
    }

    public void setReferencesTheBillId(int referencesTheBillId) {
        this.referencesTheBillId = referencesTheBillId;
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

    public String getRechargeMode() {
        return rechargeMode;
    }

    public void setRechargeMode(String rechargeMode) {
        this.rechargeMode = rechargeMode;
    }

    public String getCashWithdrawal() {
        return cashWithdrawal;
    }

    public void setCashWithdrawal(String cashWithdrawal) {
        this.cashWithdrawal = cashWithdrawal;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getIsPayWages() {
        return isPayWages;
    }

    public void setIsPayWages(String isPayWages) {
        this.isPayWages = isPayWages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MerchantFundsCurrentAccount{" +
                "userId=" + userId +
                ", currentAccountNumber=" + currentAccountNumber +
                ", accountingTime='" + accountingTime + '\'' +
                ", classification=" + classification +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", referenceBillClassification='" + referenceBillClassification + '\'' +
                ", referencesTheBillId=" + referencesTheBillId +
                ", referencesTheInternalSerialNumber1=" + referencesTheInternalSerialNumber1 +
                ", targetId=" + targetId +
                ", workId=" + workId +
                ", rechargeMode='" + rechargeMode + '\'' +
                ", cashWithdrawal='" + cashWithdrawal + '\'' +
                ", postName='" + postName + '\'' +
                ", headPic='" + headPic + '\'' +
                ", isPayWages='" + isPayWages + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
