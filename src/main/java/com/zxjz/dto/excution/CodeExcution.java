package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.RegistrationEnum;

public class CodeExcution extends BaseAPIExcution{

    public CodeExcution(RegistrationEnum registrationEnum, Object data) {
        this.data = data;
        this.code = registrationEnum.getCode();
    }

    public CodeExcution(RegistrationEnum registrationEnum) {
        this.code = registrationEnum.getCode();
    }

}
