package com.zxjz.dto.in;

/**
 * Created by Administrator on 2017/9/28 0028.
 */
public class MerchantDto {
     private int student_user_id;

     private int recruiting_id;

     private int user_id;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
        return "MerchantDto{" +
                "student_user_id=" + student_user_id +
                ", recruiting_id=" + recruiting_id +
                '}';
    }
}
