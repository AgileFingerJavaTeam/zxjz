package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.enums.AddMerchantEnum;

public class AddMerchantExcution extends BaseAPIExcution {
    public AddMerchantExcution(AddMerchantEnum addMerchantEnum, Object data) {
        this.code = addMerchantEnum.getCode();
        this.data = data;
    }
    public AddMerchantExcution(AddMerchantEnum addMerchantEnum) {
        this.code = addMerchantEnum.getCode();
    }

}
