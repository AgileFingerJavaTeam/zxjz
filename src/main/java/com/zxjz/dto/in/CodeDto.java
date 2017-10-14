package com.zxjz.dto.in;

public class CodeDto {
    private String phone;
    private String verify_code;

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

    @Override
    public String toString() {
        return "CodeDto{" +
                "phone='" + phone + '\'' +
                ", verify_code='" + verify_code + '\'' +
                '}';
    }
}
