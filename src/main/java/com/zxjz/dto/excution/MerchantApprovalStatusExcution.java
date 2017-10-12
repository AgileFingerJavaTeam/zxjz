package com.zxjz.dto.excution;

import com.zxjz.entity.MerchantApprovalStatusInfo;
import com.zxjz.enums.RegistrationEnum;

public class MerchantApprovalStatusExcution {
    private MerchantApprovalStatusInfo merchantApprovalStatusInfo;
    private int code;
    private String codeInfo;

    public MerchantApprovalStatusExcution(RegistrationEnum registrationEnum) {
        this.code = registrationEnum.getCode();
        this.codeInfo = registrationEnum.getCodeInfo();
    }
    public MerchantApprovalStatusExcution(RegistrationEnum registrationEnum,MerchantApprovalStatusInfo merchantApprovalStatusInfo) {
        this.merchantApprovalStatusInfo = merchantApprovalStatusInfo;
        this.code = registrationEnum.getCode();
        this.codeInfo = registrationEnum.getCodeInfo();
    }

    public MerchantApprovalStatusInfo getMerchantApprovalStatusInfo() {
        return merchantApprovalStatusInfo;
    }

    public void setMerchantApprovalStatusInfo(MerchantApprovalStatusInfo merchantApprovalStatusInfo) {
        this.merchantApprovalStatusInfo = merchantApprovalStatusInfo;
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
        return "MerchantApprovalStatusExcution{" +
                "merchantApprovalStatusInfo=" + merchantApprovalStatusInfo +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
