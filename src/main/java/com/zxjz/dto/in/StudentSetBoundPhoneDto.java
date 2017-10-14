package com.zxjz.dto.in;


public class StudentSetBoundPhoneDto {
    private int user_id;
    private String phone;//新绑定手机号
    private String verify_code;//验证码
    private String phone_password;//手机登录密码
    private int code;//校验是否首次绑定码
    private String bound_phone;//原绑定手机号

    public StudentSetBoundPhoneDto() {
    }

    public StudentSetBoundPhoneDto(int user_id, String phone, String verify_code, String phone_password, int code) {
        this.user_id = user_id;
        this.phone = phone;
        this.verify_code = verify_code;
        this.phone_password = phone_password;
        this.code = code;
    }

    public StudentSetBoundPhoneDto(int user_id, String phone, String verify_code, String phone_password, int code, String bound_phone) {
        this.user_id = user_id;
        this.phone = phone;
        this.verify_code = verify_code;
        this.phone_password = phone_password;
        this.code = code;
        this.bound_phone = bound_phone;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVerify_code() {
        return verify_code;
    }

    public void setVerify_code(String verify_code) {
        this.verify_code = verify_code;
    }

    public String getPhone_password() {
        return phone_password;
    }

    public void setPhone_password(String phone_password) {
        this.phone_password = phone_password;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBound_phone() {
        return bound_phone;
    }

    public void setBound_phone(String bound_phone) {
        this.bound_phone = bound_phone;
    }

    @Override
    public String toString() {
        return "StudentSetBoundPhoneDto{" +
                "user_id=" + user_id +
                ", phone='" + phone + '\'' +
                ", verify_code='" + verify_code + '\'' +
                ", phone_password='" + phone_password + '\'' +
                ", code=" + code +
                ", bound_phone='" + bound_phone + '\'' +
                '}';
    }
}
