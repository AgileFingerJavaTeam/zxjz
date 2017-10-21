package com.zxjz.dto.in;

public class StudentWithdrawDto {
    private int page;
    private int rows;
    private String withdraw_search;
    private String selectStatus;
    private int user_id;
    private int withdraw_num;
    private int staff_id;

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getWithdraw_num() {
        return withdraw_num;
    }

    public void setWithdraw_num(int withdraw_num) {
        this.withdraw_num = withdraw_num;
    }

    public String getWithdraw_search() {
        return withdraw_search;
    }

    public void setWithdraw_search(String withdraw_search) {
        this.withdraw_search = withdraw_search;
    }

    public String getSelectStatus() {
        return selectStatus;
    }

    public void setSelectStatus(String selectStatus) {
        this.selectStatus = selectStatus;
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
}
