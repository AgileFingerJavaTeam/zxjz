package com.zxjz.dto.excution;

import com.zxjz.enums.UserInfoEnum;

/**
 * Created by sunzhongyuan on 2017/9/20.
 */
public class UserInfoExcution {

    private int state;

    private UserInfoEnum userInfoEnum;

    public UserInfoExcution(int state, UserInfoEnum userInfoEnum) {
        this.state = state;
        this.userInfoEnum = userInfoEnum;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }


    public UserInfoEnum getUserInfoEnum() {
        return userInfoEnum;
    }

    public void setUserInfoEnum(UserInfoEnum userInfoEnum) {
        this.userInfoEnum = userInfoEnum;
    }

    @Override
    public String toString() {
        return "UserInfoExcution{" +
                "state=" + state +
                ", userInfoEnum=" + userInfoEnum +
                '}';
    }
}
