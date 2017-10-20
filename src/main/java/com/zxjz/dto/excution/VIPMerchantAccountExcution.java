package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.RegistrationEnum;
import com.zxjz.enums.VIPMerchantAccountEnum;

public class VIPMerchantAccountExcution extends BaseAPIExcution{
    public VIPMerchantAccountExcution(Object data, VIPMerchantAccountEnum vipMerchantAccountEnum) {
        this.data = data;
        this.code = vipMerchantAccountEnum.getCode();
    }

    public VIPMerchantAccountExcution(VIPMerchantAccountEnum vipMerchantAccountEnum) {
        this.code = vipMerchantAccountEnum.getCode();
    }


}
