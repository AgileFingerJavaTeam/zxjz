package com.zxjz.entity;

public class MerchantPayforTerrace {
    private int userId;// 用户ID
    private int withdrawalSerialNumber;//结算序号
    private int classificationOfSettlementExpenses;//结算费用分类
    private String clearingFeeName;//结算费用分类名称
    private String settlementTime;//结算时间
    private double settlementAmount;//结算金额
    private String instructions;//说明
    private int employeesId;//操作员工
    private String merchantsName;//商户名称
    private String employeesName;//操作员工

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getWithdrawalSerialNumber() {
        return withdrawalSerialNumber;
    }

    public void setWithdrawalSerialNumber(int withdrawalSerialNumber) {
        this.withdrawalSerialNumber = withdrawalSerialNumber;
    }

    public int getClassificationOfSettlementExpenses() {
        return classificationOfSettlementExpenses;
    }

    public void setClassificationOfSettlementExpenses(int classificationOfSettlementExpenses) {
        this.classificationOfSettlementExpenses = classificationOfSettlementExpenses;
    }

    public String getClearingFeeName() {
        return clearingFeeName;
    }

    public void setClearingFeeName(String clearingFeeName) {
        this.clearingFeeName = clearingFeeName;
    }

    public String getSettlementTime() {
        return settlementTime;
    }

    public void setSettlementTime(String settlementTime) {
        this.settlementTime = settlementTime;
    }

    public double getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(double settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(int employeesId) {
        this.employeesId = employeesId;
    }

    public String getMerchantsName() {
        return merchantsName;
    }

    public void setMerchantsName(String merchantsName) {
        this.merchantsName = merchantsName;
    }

    public String getEmployeesName() {
        return employeesName;
    }

    public void setEmployeesName(String employeesName) {
        this.employeesName = employeesName;
    }

    @Override
    public String toString() {
        return "MerchantPayforTerrace{" +
                "userId=" + userId +
                ", withdrawalSerialNumber=" + withdrawalSerialNumber +
                ", classificationOfSettlementExpenses=" + classificationOfSettlementExpenses +
                ", clearingFeeName='" + clearingFeeName + '\'' +
                ", settlementTime='" + settlementTime + '\'' +
                ", settlementAmount=" + settlementAmount +
                ", instructions='" + instructions + '\'' +
                ", employeesId=" + employeesId +
                ", merchantsName='" + merchantsName + '\'' +
                ", employeesName='" + employeesName + '\'' +
                '}';
    }
}
