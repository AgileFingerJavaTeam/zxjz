package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.GetMerchantInfo;
import com.zxjz.enums.MerchantEnum;

public class MerchantInformationExcution extends BaseAPIExcution{

    public MerchantInformationExcution(MerchantEnum merchantEnum, GetMerchantInfo getMerchantInfo) {
        this.data = getMerchantInfo;
        this.code = merchantEnum.getCode();
    }

}
