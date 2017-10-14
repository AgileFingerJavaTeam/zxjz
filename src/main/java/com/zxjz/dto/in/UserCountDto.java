package com.zxjz.dto.in;

public class UserCountDto {
    private String phone;
    private String password;
    private String wechat_id;
    private String headimgurl;
    private String qq_id;
    private String verify_code;

    public String getQq_id() {
        return qq_id;
    }

    public void setQq_id(String qq_id) {
        this.qq_id = qq_id;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public String getWechat_id() {
        return wechat_id;
    }

    public void setWechat_id(String wechat_id) {
        this.wechat_id = wechat_id;
    }

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

    @Override
    public String toString() {
        return "UserCountDto{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", wechat_id='" + wechat_id + '\'' +
                ", headimgurl='" + headimgurl + '\'' +
                ", qq_id='" + qq_id + '\'' +
                '}';
    }
}
