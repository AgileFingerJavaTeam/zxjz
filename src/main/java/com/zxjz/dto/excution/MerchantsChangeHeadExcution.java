package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.MerchantsInfo;
import com.zxjz.enums.MerchantsChangeHeadEnum;

public class MerchantsChangeHeadExcution extends BaseAPIExcution{

    public MerchantsChangeHeadExcution(MerchantsChangeHeadEnum merchantsChangeHeadEnum) {
        this.code = merchantsChangeHeadEnum.getCode();
    }
    public MerchantsChangeHeadExcution(MerchantsChangeHeadEnum merchantsChangeHeadEnum,Object data) {
        this.code = merchantsChangeHeadEnum.getCode();
        this.data = data;
    }
}
