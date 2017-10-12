package com.zxjz.dto.excution;


import com.zxjz.entity.MerchantsUpgrade;
import com.zxjz.enums.MerchantsUpgradeEnum;


public class MerchantsUpgradeExcution{
    private MerchantsUpgrade merchantsUpgrade;
    private int code;
    private String codeInfo;

    public MerchantsUpgradeExcution(MerchantsUpgradeEnum merchantsUpgradeEnum) {
        this.code = merchantsUpgradeEnum.getCode();
        this.codeInfo = merchantsUpgradeEnum.getCodeInfo();
    }
    public MerchantsUpgradeExcution(MerchantsUpgradeEnum merchantsUpgradeEnum,MerchantsUpgrade merchantsUpgrade) {
        this.merchantsUpgrade = merchantsUpgrade;
        this.code = merchantsUpgradeEnum.getCode();
        this.codeInfo = merchantsUpgradeEnum.getCodeInfo();
    }


    public MerchantsUpgrade getMerchantsUpgrade() {
        return merchantsUpgrade;
    }

    public void setMerchantsUpgrade(MerchantsUpgrade merchantsUpgrade) {
        this.merchantsUpgrade = merchantsUpgrade;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCodeInfo() {
        return codeInfo;
    }

    public void setCodeInfo(String codeInfo) {
        this.codeInfo = codeInfo;
    }

    @Override
    public String toString() {
        return "MerchantsUpgradeExcution{" +
                "merchantsUpgrade=" + merchantsUpgrade +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
