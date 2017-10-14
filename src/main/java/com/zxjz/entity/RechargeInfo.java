package com.zxjz.entity;

public class RechargeInfo {
    private int userId;
    private String merchantsName;
    private int rechargeSequenceNumber;
    private String rechargeTime;
    private String rechargeMode;
    private String rechargeModeName;
    private Double amountOfRecharge;
    private String rechargeDeclare;
    private int PaymentPlatformFlowNumber;
    private int operatingStaffId;
    private int employeesId;
    private String employeesName;//操作人姓名

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

    public int getRechargeSequenceNumber() {
        return rechargeSequenceNumber;
    }

    public void setRechargeSequenceNumber(int rechargeSequenceNumber) {
        this.rechargeSequenceNumber = rechargeSequenceNumber;
    }

    public String getRechargeTime() {
        return rechargeTime;
    }

    public void setRechargeTime(String rechargeTime) {
        this.rechargeTime = rechargeTime;
    }

    public String getRechargeMode() {
        return rechargeMode;
    }

    public void setRechargeMode(String rechargeMode) {
        this.rechargeMode = rechargeMode;
    }

    public String getRechargeModeName() {
        return rechargeModeName;
    }

    public void setRechargeModeName(String rechargeModeName) {
        this.rechargeModeName = rechargeModeName;
    }

    public Double getAmountOfRecharge() {
        return amountOfRecharge;
    }

    public void setAmountOfRecharge(Double amountOfRecharge) {
        this.amountOfRecharge = amountOfRecharge;
    }

    public String getRechargeDeclare() {
        return rechargeDeclare;
    }

    public void setRechargeDeclare(String rechargeDeclare) {
        this.rechargeDeclare = rechargeDeclare;
    }

    public int getPaymentPlatformFlowNumber() {
        return PaymentPlatformFlowNumber;
    }

    public void setPaymentPlatformFlowNumber(int paymentPlatformFlowNumber) {
        PaymentPlatformFlowNumber = paymentPlatformFlowNumber;
    }

    public int getOperatingStaffId() {
        return operatingStaffId;
    }

    public void setOperatingStaffId(int operatingStaffId) {
        this.operatingStaffId = operatingStaffId;
    }

    public int getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(int employeesId) {
        this.employeesId = employeesId;
    }

    public String getEmployeesName() {
        return employeesName;
    }

    public void setEmployeesName(String employeesName) {
        this.employeesName = employeesName;
    }

    @Override
    public String toString() {
        return "RechargeInfo{" +
                "userId=" + userId +
                ", merchantsName='" + merchantsName + '\'' +
                ", rechargeSequenceNumber=" + rechargeSequenceNumber +
                ", rechargeTime='" + rechargeTime + '\'' +
                ", rechargeMode='" + rechargeMode + '\'' +
                ", rechargeModeName='" + rechargeModeName + '\'' +
                ", amountOfRecharge=" + amountOfRecharge +
                ", rechargeDeclare='" + rechargeDeclare + '\'' +
                ", PaymentPlatformFlowNumber=" + PaymentPlatformFlowNumber +
                ", operatingStaffId=" + operatingStaffId +
                ", employeesId=" + employeesId +
                ", employeesName='" + employeesName + '\'' +
                '}';
    }
}
