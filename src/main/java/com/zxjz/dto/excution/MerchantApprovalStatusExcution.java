package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.MerchantApprovalStatusInfo;
import com.zxjz.enums.RegistrationEnum;

public class MerchantApprovalStatusExcution extends BaseAPIExcution{

    public MerchantApprovalStatusExcution(RegistrationEnum registrationEnum,Object data) {
        this.data = data;
        this.code = registrationEnum.getCode();
    }

    public MerchantApprovalStatusExcution(RegistrationEnum registrationEnum) {
        this.code = registrationEnum.getCode();
    }

}
