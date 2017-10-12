package com.zxjz.dto.excution;

import com.zxjz.entity.MerchantAccountInfo;
import com.zxjz.enums.CityEnum;
import com.zxjz.enums.RegistrationEnum;

public class MerchantAccountExcution {
    private MerchantAccountInfo merchantAccountInfo;
    private int code;
    private String codeInfo;

    public MerchantAccountExcution(RegistrationEnum registrationEnum) {
        this.code = registrationEnum.getCode();
        this.codeInfo = registrationEnum.getCodeInfo();
    }
    public MerchantAccountExcution(RegistrationEnum registrationEnum,MerchantAccountInfo merchantAccountInfo) {
        this.merchantAccountInfo = merchantAccountInfo;
        this.code = registrationEnum.getCode();
        this.codeInfo = registrationEnum.getCodeInfo();
    }

    public MerchantAccountInfo getMerchantAccountInfo() {
        return merchantAccountInfo;
    }

    public void setMerchantAccountInfo(MerchantAccountInfo merchantAccountInfo) {
        this.merchantAccountInfo = merchantAccountInfo;
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
        return "MerchantAccountExcution{" +
                "merchantAccountInfo=" + merchantAccountInfo +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
