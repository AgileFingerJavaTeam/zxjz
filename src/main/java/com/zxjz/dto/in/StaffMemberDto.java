package com.zxjz.dto.in;

public class StaffMemberDto {
    private int employees_num;
    private String employees_name;
    private String permission_grouping_name;
    private int employees_id;

    public int getEmployees_id() {
        return employees_id;
    }

    public void setEmployees_id(int employees_id) {
        this.employees_id = employees_id;
    }

    public int getEmployees_num() {
        return employees_num;
    }

    public void setEmployees_num(int employees_num) {
        this.employees_num = employees_num;
    }

    public String getEmployees_name() {
        return employees_name;
    }

    public void setEmployees_name(String employees_name) {
        this.employees_name = employees_name;
    }

    public String getPermission_grouping_name() {
        return permission_grouping_name;
    }

    public void setPermission_grouping_name(String permission_grouping_name) {
        this.permission_grouping_name = permission_grouping_name;
    }

    @Override
    public String toString() {
        return "StaffMemberDto{" +
                "employees_num=" + employees_num +
                ", employees_name='" + employees_name + '\'' +
                ", permission_grouping_name='" + permission_grouping_name + '\'' +
                ", employees_id=" + employees_id +
                '}';
    }
}
