package com.zxjz.dto.excution;

import com.zxjz.entity.UserInfo;
import com.zxjz.enums.UserInfoEnum;

/**
 * Created by sunzhongyuan on 2017/9/20.
 */
public class UserInfoExcution {

    private UserInfo userInfo;

    private int code;

    private String codeInfo;

    public UserInfoExcution(UserInfoEnum userInfoEnum) {
        this.code = userInfoEnum.getCode();
        this.codeInfo = userInfoEnum.getCodeInfo();
    }

    public UserInfoExcution(UserInfoEnum userInfoEnum,UserInfo userInfo) {
        this.code = userInfoEnum.getCode();
        this.codeInfo = userInfoEnum.getCodeInfo();
        this.userInfo = userInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCodeInfo() {
        return codeInfo;
    }

    public void setCodeInfo(String codeInfo) {
        this.codeInfo = codeInfo;
    }

    @Override
    public String toString() {
        return "UserInfoExcution{" +
                "userInfo=" + userInfo +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
