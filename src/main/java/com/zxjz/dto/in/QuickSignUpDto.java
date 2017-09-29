package com.zxjz.dto.in;

/**
 * Created by Administrator on 2017/9/25 0025.
 */
public class QuickSignUpDto {
    private int recruiting_id;
    private int student_user_id;
    private String registration_time;
    private String student_name;
    private String contact_phone;
    private String code;
    private String sex;
    private String school;
    private String infor_type;
    private String leave_message_merchant;



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

    public String getRegistration_time() {
        return registration_time;
    }

    public void setRegistration_time(String registration_time) {
        this.registration_time = registration_time;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getContact_phone() {
        return contact_phone;
    }

    public void setContact_phone(String contact_phone) {
        this.contact_phone = contact_phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getInfor_type() {
        return infor_type;
    }

    public void setInfor_type(String infor_type) {
        this.infor_type = infor_type;
    }

    public String getLeave_message_merchant() {
        return leave_message_merchant;
    }

    public void setLeave_message_merchant(String leave_message_merchant) {
        this.leave_message_merchant = leave_message_merchant;
    }

    @Override
    public String toString() {
        return "QuickSignUpDto{" +
                "recruiting_id=" + recruiting_id +
                ", student_user_id=" + student_user_id +
                ", registration_time='" + registration_time + '\'' +
                ", student_name='" + student_name + '\'' +
                ", contact_phone='" + contact_phone + '\'' +
                ", code='" + code + '\'' +
                ", sex='" + sex + '\'' +
                ", school='" + school + '\'' +
                ", infor_type='" + infor_type + '\'' +
                ", leave_message_merchant='" + leave_message_merchant + '\'' +
                '}';
    }
}
