package com.zxjz.dto.in;

/**
 * Created by Administrator on 2017/9/25 0025.
 */
public class UpdateJobStatusDto {
    private int recruiting_id;
    private int student_user_id;
    private String students_confirmed;



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

    public String getStudents_confirmed() {
        return students_confirmed;
    }

    public void setStudents_confirmed(String students_confirmed) {
        this.students_confirmed = students_confirmed;
    }

    @Override
    public String toString() {
        return "UpdateJobStatusDto{" +
                "recruiting_id=" + recruiting_id +
                ", student_user_id=" + student_user_id +
                ", students_confirmed='" + students_confirmed + '\'' +
                '}';
    }
}
