package com.zxjz.dto.in;

public class MerchantAccountDto {
    private String phone;
    private String password;
    private String verify_code;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerify_code() {
        return verify_code;
    }

    public void setVerify_code(String verify_code) {
        this.verify_code = verify_code;
    }

    @Override
    public String toString() {
        return "MerchantAccountDto{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", verify_code='" + verify_code + '\'' +
                '}';
    }
}
