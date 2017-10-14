package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.RegistrationEnum;

public class UpdatePwdExcution extends BaseAPIExcution{

    public UpdatePwdExcution(Object data, RegistrationEnum registrationEnum) {
        this.data = data;
        this.code = registrationEnum.getCode();
    }

    public UpdatePwdExcution(RegistrationEnum registrationEnum) {
        this.code = registrationEnum.getCode();
    }

}
