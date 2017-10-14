package com.zxjz.entity;

/**
 * Created by Administrator on 2017/9/30 0030.
 */
public class LandFallInfo {
    private int employees_id;//员工ID
    private String employees_num;//员工编号
    private String employees_name;//员工姓名
    private String login_password;//登陆账号
    private int permission_grouping_id;//权限分组ID
    private int is_delete;//是否删除

    public int getEmployees_id() {
        return employees_id;
    }
    public void setEmployees_id(int employees_id) {
        this.employees_id = employees_id;
    }
    public String getEmployees_name() {
        return employees_name;
    }
    public void setEmployees_name(String employees_name) {
        this.employees_name = employees_name;
    }
    public int getPermission_grouping_id() {
        return permission_grouping_id;
    }
    public void setPermission_grouping_id(int permission_grouping_id) {
        this.permission_grouping_id = permission_grouping_id;
    }
    public int getIs_delete() {
        return is_delete;
    }
    public void setIs_delete(int is_delete) {
        this.is_delete = is_delete;
    }
    public String getEmployees_num() {
        return employees_num;
    }
    public void setEmployees_num(String employees_num) {
        this.employees_num = employees_num;
    }
    public String getLogin_password() {
        return login_password;
    }
    public void setLogin_password(String login_password) {
        this.login_password = login_password;
    }

    @Override
    public String toString() {
        return "LandFallInfo{" +
                "employees_id=" + employees_id +
                ", employees_num='" + employees_num + '\'' +
                ", employees_name='" + employees_name + '\'' +
                ", login_password='" + login_password + '\'' +
                ", permission_grouping_id=" + permission_grouping_id +
                ", is_delete=" + is_delete +
                '}';
    }
}
