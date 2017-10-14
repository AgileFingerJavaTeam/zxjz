package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.MerchantAccountInfo;
import com.zxjz.enums.CityEnum;
import com.zxjz.enums.RegistrationEnum;

public class MerchantAccountExcution extends BaseAPIExcution{

    public MerchantAccountExcution(RegistrationEnum registrationEnum,Object data) {
        this.data = data;
        this.code = registrationEnum.getCode();
    }
    public MerchantAccountExcution(RegistrationEnum registrationEnum) {
        this.code = registrationEnum.getCode();
    }

}
