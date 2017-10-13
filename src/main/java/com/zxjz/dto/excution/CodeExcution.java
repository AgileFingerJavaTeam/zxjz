package com.zxjz.dto.excution;

import com.zxjz.enums.RegistrationEnum;

public class CodeExcution {
    private String codes;
    private int code;
    private String codeInfo;


    public CodeExcution(RegistrationEnum registrationEnum, String codes) {
        this.codes = codes;
        this.code = registrationEnum.getCode();
        this.codeInfo = registrationEnum.getCodeInfo();
    }

    public CodeExcution(RegistrationEnum registrationEnum) {
        this.code = registrationEnum.getCode();
        this.codeInfo = registrationEnum.getCodeInfo();
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes;
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
        return "CodeExcution{" +
                "codes=" + codes +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
