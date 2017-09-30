package com.zxjz.dto.in;

/**
 * Created by Administrator on 2017/9/26 0026.
 */
public class WhetherAdmissionDto {
    private int recruiting_id;
    private int student_user_id;
    private String hired;
    private String after_confirmation;


    public String getHired() {
        return hired;
    }

    public void setHired(String hired) {
        this.hired = hired;
    }

    public String getAfter_confirmation() {
        return after_confirmation;
    }

    public void setAfter_confirmation(String after_confirmation) {
        this.after_confirmation = after_confirmation;
    }

    public int getRecruiting_id() {
        return recruiting_id;
    }

    public void setRecruiting_id(int recruiting_id) {
        this.recruiting_id = recruiting_id;
    }

    public int getStudent_user_id() {
        return student_user_id;
    }

    public void setStudent_user_id(int student_user_id) {
        this.student_user_id = student_user_id;
    }

    @Override
    public String toString() {
        return "WhetherAdmissionDto{" +
                "recruiting_id=" + recruiting_id +
                ", student_user_id=" + student_user_id +
                ", hired='" + hired + '\'' +
                ", after_confirmation='" + after_confirmation + '\'' +
                '}';
    }
}
