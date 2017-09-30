package com.zxjz.dto.excution;

import com.zxjz.entity.MerchantsInfo;
import com.zxjz.enums.MerchantsChangeHeadEnum;

public class MerchantsChangeHeadExcution {
    private int code;
    private String codeInfo;

    public MerchantsChangeHeadExcution(MerchantsChangeHeadEnum merchantsChangeHeadEnum) {
        this.code = merchantsChangeHeadEnum.getCode();
        this.codeInfo = merchantsChangeHeadEnum.getCodeInfo();
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
        return "MerchantsChangeHeadExcution{" +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
