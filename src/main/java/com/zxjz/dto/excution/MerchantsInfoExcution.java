package com.zxjz.dto.excution;

import com.zxjz.entity.MerchantsInfo;
import com.zxjz.enums.MerchantsInfoEnum;

public class MerchantsInfoExcution {
    private MerchantsInfo merchantsInfo;
    private  int code;
    private  String codeInfo;

    public MerchantsInfoExcution(MerchantsInfoEnum merchantsInfoEnum) {
        this.code = merchantsInfoEnum.getCode();
        this.codeInfo = merchantsInfoEnum.getCodeInfo();
    }
    public MerchantsInfoExcution(MerchantsInfoEnum merchantsInfoEnum,MerchantsInfo merchantsInfo){
        this.code = merchantsInfoEnum.getCode();
        this.codeInfo = merchantsInfoEnum.getCodeInfo();
        this.merchantsInfo = merchantsInfo;
    }

    public MerchantsInfo getMerchantsInfo() {
        return merchantsInfo;
    }

    public void setMerchantsInfo(MerchantsInfo merchantsInfo) {
        this.merchantsInfo = merchantsInfo;
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
        return "MerchantsInfoExcution{" +
                "merchantsInfo=" + merchantsInfo +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
