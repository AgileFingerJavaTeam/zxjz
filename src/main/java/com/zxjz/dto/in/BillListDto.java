package com.zxjz.dto.in;

public class BillListDto {
    private int work_id;
    private int college_user_id;
    private int recruiting_id;

    public BillListDto(int work_id, int college_user_id, int recruiting_id) {
        this.work_id = work_id;
        this.college_user_id = college_user_id;
        this.recruiting_id = recruiting_id;
    }

    public int getWork_id() {
        return work_id;
    }

    public void setWork_id(int work_id) {
        this.work_id = work_id;
    }

    public int getCollege_user_id() {
        return college_user_id;
    }

    public void setCollege_user_id(int college_user_id) {
        this.college_user_id = college_user_id;
    }

    public int getRecruiting_id() {
        return recruiting_id;
    }

    public void setRecruiting_id(int recruiting_id) {
        this.recruiting_id = recruiting_id;
    }

    @Override
    public String toString() {
        return "BillListDto{" +
                "work_id=" + work_id +
                ", college_user_id=" + college_user_id +
                ", recruiting_id=" + recruiting_id +
                '}';
    }
}
