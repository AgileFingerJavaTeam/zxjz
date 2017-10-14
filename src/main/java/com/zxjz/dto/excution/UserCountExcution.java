package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.UserCountInfo;
import com.zxjz.enums.RegistrationEnum;

public class UserCountExcution extends BaseAPIExcution{

    public UserCountExcution(Object data, RegistrationEnum registrationEnum) {
        this.data = data;
        this.code = registrationEnum.getCode();
    }

}
