package com.zxjz.dto.excution;

import com.zxjz.enums.RegistrationEnum;

public class UpdatePwdByPhoneExcution {
    private int updatePwdByPhone;
    private int code;
    private String codeInfo;

    public UpdatePwdByPhoneExcution(int updatePwdByPhone, RegistrationEnum registrationEnum) {
        this.updatePwdByPhone = updatePwdByPhone;
        this.code = registrationEnum.getCode();
        this.codeInfo = registrationEnum.getCodeInfo();
    }

    public UpdatePwdByPhoneExcution(RegistrationEnum registrationEnum) {
        this.code = registrationEnum.getCode();
        this.codeInfo = registrationEnum.getCodeInfo();
    }

    public int getUpdatePwdByPhone() {
        return updatePwdByPhone;
    }

    public void setUpdatePwdByPhone(int updatePwdByPhone) {
        this.updatePwdByPhone = updatePwdByPhone;
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
        return "UpdatePwdByPhoneExcution{" +
                "updatePwdByPhone=" + updatePwdByPhone +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
