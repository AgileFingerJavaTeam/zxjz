package com.zxjz.entity;

public class Authority {
    private int employeesId;
    private String employeesNum;
    private String employeesName;
    private int permissionGroupingId;
    private String permissionGroupingName;

    public int getEmployeesId() {
        return employeesId;
    }

    public void setEmployeesId(int employeesId) {
        this.employeesId = employeesId;
    }

    public String getEmployeesNum() {
        return employeesNum;
    }

    public void setEmployeesNum(String employeesNum) {
        this.employeesNum = employeesNum;
    }

    public String getEmployeesName() {
        return employeesName;
    }

    public void setEmployeesName(String employeesName) {
        this.employeesName = employeesName;
    }

    public int getPermissionGroupingId() {
        return permissionGroupingId;
    }

    public void setPermissionGroupingId(int permissionGroupingId) {
        this.permissionGroupingId = permissionGroupingId;
    }

    public String getPermissionGroupingName() {
        return permissionGroupingName;
    }

    public void setPermissionGroupingName(String permissionGroupingName) {
        this.permissionGroupingName = permissionGroupingName;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "employeesId=" + employeesId +
                ", employeesNum='" + employeesNum + '\'' +
                ", employeesName='" + employeesName + '\'' +
                ", permissionGroupingId=" + permissionGroupingId +
                ", permissionGroupingName='" + permissionGroupingName + '\'' +
                '}';
    }
}
