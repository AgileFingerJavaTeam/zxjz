package com.zxjz.dto.in;

public class UserByWechatIDDto {
    private String wechat_id;
    private String headimgurl;//

    public String getWechat_id() {
        return wechat_id;
    }

    public void setWechat_id(String wechat_id) {
        this.wechat_id = wechat_id;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    @Override
    public String toString() {
        return "UserByWechatIDDto{" +
                "wechat_id='" + wechat_id + '\'' +
                ", headimgurl='" + headimgurl + '\'' +
                '}';
    }
}
