package com.zxjz.dto.excution;


import com.zxjz.base.BaseAPIExcution;
import com.zxjz.entity.MerchantsUpgrade;
import com.zxjz.enums.MerchantsUpgradeEnum;


public class MerchantsUpgradeExcution extends BaseAPIExcution{

    public MerchantsUpgradeExcution(MerchantsUpgradeEnum merchantsUpgradeEnum) {
        this.code = merchantsUpgradeEnum.getCode();
    }
    public MerchantsUpgradeExcution(MerchantsUpgradeEnum merchantsUpgradeEnum,Object data) {
        this.code = merchantsUpgradeEnum.getCode();
        this.data = data;
    }
}
