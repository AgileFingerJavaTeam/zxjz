package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.RegistrationEnum;

public class UpdatePwdByPhoneExcution extends BaseAPIExcution{

    public UpdatePwdByPhoneExcution(Object data, RegistrationEnum registrationEnum) {
        this.data = data;
        this.code = registrationEnum.getCode();
    }
    public UpdatePwdByPhoneExcution(RegistrationEnum registrationEnum) {
        this.code = registrationEnum.getCode();
    }

}
