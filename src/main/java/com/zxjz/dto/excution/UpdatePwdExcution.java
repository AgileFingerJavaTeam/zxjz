package com.zxjz.dto.excution;

import com.zxjz.enums.RegistrationEnum;

public class UpdatePwdExcution {
    private int updataPwdByPhone;
    private int code;
    private String codeInfo;

    public UpdatePwdExcution(int updataPwdByPhone, RegistrationEnum registrationEnum) {
        this.updataPwdByPhone = updataPwdByPhone;
        this.code = registrationEnum.getCode();
        this.codeInfo = registrationEnum.getCodeInfo();
    }

    public UpdatePwdExcution(RegistrationEnum registrationEnum) {
        this.code = registrationEnum.getCode();
        this.codeInfo = registrationEnum.getCodeInfo();
    }

    public int getUpdataPwdByPhone() {
        return updataPwdByPhone;
    }

    public void setUpdataPwdByPhone(int updataPwdByPhone) {
        this.updataPwdByPhone = updataPwdByPhone;
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
        return "UpdatePwdExcution{" +
                "updataPwdByPhone=" + updataPwdByPhone +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
