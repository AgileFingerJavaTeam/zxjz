package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.LoginEnum;

public class LoginExcution extends BaseAPIExcution{
    public LoginExcution(Object data, LoginEnum loginEnum) {
        this.data = data;
        this.code = loginEnum.getCode();
    }

    public LoginExcution(LoginEnum loginEnum) {
        this.code = loginEnum.getCode();
    }
}
