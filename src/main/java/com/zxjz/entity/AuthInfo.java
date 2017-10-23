package com.zxjz.entity;

public class AuthInfo {
    private String permissionGroupingName;
    private String employeesNum;

    public String getPermissionGroupingName() {
        return permissionGroupingName;
    }

    public void setPermissionGroupingName(String permissionGroupingName) {
        this.permissionGroupingName = permissionGroupingName;
    }

    public String getEmployeesNum() {
        return employeesNum;
    }

    public void setEmployeesNum(String employeesNum) {
        this.employeesNum = employeesNum;
    }

    @Override
    public String toString() {
        return "AuthInfo{" +
                "permissionGroupingName='" + permissionGroupingName + '\'' +
                ", employeesNum='" + employeesNum + '\'' +
                '}';
    }
}
