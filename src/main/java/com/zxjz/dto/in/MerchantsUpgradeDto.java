package com.zxjz.dto.in;

public class MerchantsUpgradeDto {
    private int id;
    private int userId;
    private int user_id;
    private int page;
    private int rows;
    private int employees_name;
    private String employeesName;
    private String srt_approval_status1;
    private String srt_search_content1;

    public String getEmployeesName() {
        return employeesName;
    }

    public void setEmployeesName(String employeesName) {
        this.employeesName = employeesName;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getEmployees_name() {
        return employees_name;
    }

    public void setEmployees_name(int employees_name) {
        this.employees_name = employees_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSrt_approval_status1() {
        return srt_approval_status1;
    }

    public void setSrt_approval_status1(String srt_approval_status1) {
        this.srt_approval_status1 = srt_approval_status1;
    }

    public String getSrt_search_content1() {
        return srt_search_content1;
    }

    public void setSrt_search_content1(String srt_search_content1) {
        this.srt_search_content1 = srt_search_content1;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    @Override
    public String toString() {
        return "MerchantsUpgradeDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", page=" + page +
                ", rows=" + rows +
                ", employees_name=" + employees_name +
                ", srt_approval_status1='" + srt_approval_status1 + '\'' +
                ", srt_search_content1='" + srt_search_content1 + '\'' +
                '}';
    }
}
