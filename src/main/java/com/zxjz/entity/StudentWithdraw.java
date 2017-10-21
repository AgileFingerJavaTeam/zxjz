package com.zxjz.entity;

public class StudentWithdraw {
    private int userId;//学生ID
    private int withdrawNum;//提现流水号
    private String withdrawTime;//提现时间
    private String withdrawMoney;//提现金额
    private int isOk;//处理状态
    private int staffId;//处理人Id
    private int isSuccess;//是否转账成功
    private String accountingDate;//到账时间
    private String name;//学生姓名
    private String employeesName;//操作员工姓名
    private String alipayId;//学生支付宝账号

    public String getAlipayId() {
        return alipayId;
    }

    public void setAlipayId(String alipayId) {
        this.alipayId = alipayId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeesName() {
        return employeesName;
    }

    public void setEmployeesName(String employeesName) {
        this.employeesName = employeesName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getWithdrawNum() {
        return withdrawNum;
    }

    public void setWithdrawNum(int withdrawNum) {
        this.withdrawNum = withdrawNum;
    }

    public String getWithdrawTime() {
        return withdrawTime;
    }

    public void setWithdrawTime(String withdrawTime) {
        this.withdrawTime = withdrawTime;
    }

    public String getWithdrawMoney() {
        return withdrawMoney;
    }

    public void setWithdrawMoney(String withdrawMoney) {
        this.withdrawMoney = withdrawMoney;
    }

    public int getIsOk() {
        return isOk;
    }

    public void setIsOk(int isOk) {
        this.isOk = isOk;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public int getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(int isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getAccountingDate() {
        return accountingDate;
    }

    public void setAccountingDate(String accountingDate) {
        this.accountingDate = accountingDate;
    }

    @Override
    public String toString() {
        return "StudentWithdraw{" +
                "userId=" + userId +
                ", withdrawNum=" + withdrawNum +
                ", withdrawTime='" + withdrawTime + '\'' +
                ", withdrawMoney='" + withdrawMoney + '\'' +
                ", isOk=" + isOk +
                ", staffId=" + staffId +
                ", isSuccess=" + isSuccess +
                ", accountingDate='" + accountingDate + '\'' +
                ", name='" + name + '\'' +
                ", employeesName='" + employeesName + '\'' +
                '}';
    }
}
