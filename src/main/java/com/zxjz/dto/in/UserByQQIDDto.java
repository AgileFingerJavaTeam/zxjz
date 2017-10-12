package com.zxjz.dto.in;

public class UserByQQIDDto {
    private String qq_id;
    private String headimgurl;

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

    @Override
    public String toString() {
        return "UserByQQIDDto{" +
                "qq_id='" + qq_id + '\'' +
                ", headimgurl='" + headimgurl + '\'' +
                '}';
    }
}
