package com.zxjz.dto.excution;

import com.zxjz.enums.MerchantsAffirmStudentBreakPromiseEnum;

public class MerchantsAffirmStudentBreakPromiseExcution {
    private int code;
    private String codeInfo;

    public MerchantsAffirmStudentBreakPromiseExcution(MerchantsAffirmStudentBreakPromiseEnum merchantsAffirmStudentBreakPromiseEnum) {
        this.code = merchantsAffirmStudentBreakPromiseEnum.getCode();
        this.codeInfo = merchantsAffirmStudentBreakPromiseEnum.getCodeInfo();
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
        return "MerchantsAffirmStudentBreakPromiseExcution{" +
                "code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
