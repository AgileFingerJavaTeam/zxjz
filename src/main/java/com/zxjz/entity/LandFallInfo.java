package com.zxjz.entity;

/**
 * Created by Administrator on 2017/9/30 0030.
 */
public class LandFallInfo {
    private int employeesId;//员工ID
    private String employeesNum;//员工编号
    private String employeesName;//员工姓名
    private String loginPassword;//登陆账号
    private int permissionGroupingId;//权限分组ID
    private int isDelete;//是否删除

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

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public int getPermissionGroupingId() {
        return permissionGroupingId;
    }

    public void setPermissionGroupingId(int permissionGroupingId) {
        this.permissionGroupingId = permissionGroupingId;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "LandFallInfo{" +
                "employeesId=" + employeesId +
                ", employeesNum='" + employeesNum + '\'' +
                ", employeesName='" + employeesName + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", permissionGroupingId=" + permissionGroupingId +
                ", isDelete=" + isDelete +
                '}';
    }
}
