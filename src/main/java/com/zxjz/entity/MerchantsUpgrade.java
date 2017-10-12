package com.zxjz.entity;

public class MerchantsUpgrade {
    private int userId;
    private String applyTime;
    private String isDispose;
    private int acceptEmployees;
    private int operatingStaff;
    private String operatingTime;
    private  String merchantsName;//商户名称
    private String employees_name;//员工姓名

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

    public int getAcceptEmployees() {
        return acceptEmployees;
    }

    public void setAcceptEmployees(int acceptEmployees) {
        this.acceptEmployees = acceptEmployees;
    }

    public int getOperatingStaff() {
        return operatingStaff;
    }

    public void setOperatingStaff(int operatingStaff) {
        this.operatingStaff = operatingStaff;
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
                ", acceptEmployees=" + acceptEmployees +
                ", operatingStaff=" + operatingStaff +
                ", operatingTime='" + operatingTime + '\'' +
                ", merchantsName='" + merchantsName + '\'' +
                ", employees_name='" + employees_name + '\'' +
                '}';
    }
}
