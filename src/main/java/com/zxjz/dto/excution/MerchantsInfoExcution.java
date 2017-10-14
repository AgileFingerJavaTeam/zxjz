package com.zxjz.dto.excution;

import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.MerchantsInfo;
import com.zxjz.enums.MerchantsInfoEnum;

public class MerchantsInfoExcution extends BaseAPIExcution{

    public MerchantsInfoExcution(MerchantsInfoEnum merchantsInfoEnum) {
        this.code = merchantsInfoEnum.getCode();
    }
    public MerchantsInfoExcution(MerchantsInfoEnum merchantsInfoEnum,Object data){
        this.code = merchantsInfoEnum.getCode();
        this.data = data;
    }
}
