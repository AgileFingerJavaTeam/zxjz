package com.zxjz.entity;

public class MerchantsUpgrade {
    private int userId;
    private String applyTime;
    private String isDispose;
    private String acceptEmployees;
    private String operatingStaff;
    private String operatingTime;
    private String merchantsName;//商户名称
    private String employees_name;//员工姓名
    private int employeesId;

    public void setAcceptEmployees(String acceptEmployees) {
        this.acceptEmployees = acceptEmployees;
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

    public String getEmployees_name() {
        return employees_name;
    }

    public void setEmployees_name(String employees_name) {
        this.employees_name = employees_name;
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
                ", employees_name='" + employees_name + '\'' +
                ", employeesId=" + employeesId +
                '}';
    }
}
