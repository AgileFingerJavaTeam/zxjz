package com.zxjz.entity;

public class MerchantsUpgrade {
    private int userId;
    private String applyTime;
    private String isDispose;
    private String acceptEmployees;
    private String operatingStaff;
    private String operatingTime;
    private String merchantsName;//商户名称
    private String employeesName;//员工姓名
    private int employeesId;

    public String getAcceptEmployees() {
        return acceptEmployees;
    }

    public void setAcceptEmployees(String acceptEmployees) {
        this.acceptEmployees = acceptEmployees;
    }

    public String getOperatingStaff() {
        return operatingStaff;
    }

    public void setOperatingStaff(String operatingStaff) {
        this.operatingStaff = operatingStaff;
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

    public String getMerchantsName() {
        return merchantsName;
    }

    public void setMerchantsName(String merchantsName) {
        this.merchantsName = merchantsName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
    }

    public String getIsDispose() {
        return isDispose;
    }

    public void setIsDispose(String isDispose) {
        this.isDispose = isDispose;
    }


    public String getOperatingTime() {
        return operatingTime;
    }

    public void setOperatingTime(String operatingTime) {
        this.operatingTime = operatingTime;
    }

    @Override
    public String toString() {
        return "MerchantsUpgrade{" +
                "userId=" + userId +
                ", applyTime='" + applyTime + '\'' +
                ", isDispose='" + isDispose + '\'' +
                ", acceptEmployees='" + acceptEmployees + '\'' +
                ", operatingStaff='" + operatingStaff + '\'' +
                ", operatingTime='" + operatingTime + '\'' +
                ", merchantsName='" + merchantsName + '\'' +
                ", employeesName='" + employeesName + '\'' +
                ", employeesId=" + employeesId +
                '}';
    }
}
