package com.zxjz.dto.excution;

import com.zxjz.base.BaseExcution;
import com.zxjz.entity.UserInfo;
import com.zxjz.enums.UserInfoEnum;

/**
 * Created by sunzhongyuan on 2017/9/20.
 */
public class UserInfoExcution extends BaseExcution{

    private UserInfo userInfo;

    public UserInfoExcution(UserInfoEnum userInfoEnum, UserInfo userInfo) {
        super(userInfoEnum);
        this.userInfo = userInfo;
    }

    public UserInfoExcution(UserInfoEnum userInfoEnum) {
        super(userInfoEnum);
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "UserInfoExcution{" +
                "userInfo=" + userInfo +
                '}';
    }
}
