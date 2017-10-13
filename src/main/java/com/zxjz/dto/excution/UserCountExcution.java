package com.zxjz.dto.excution;

import com.zxjz.entity.UserCountInfo;
import com.zxjz.enums.RegistrationEnum;

public class UserCountExcution {
    private UserCountInfo userCountInfo;
    private int code;
    private String codeInfo;

    public UserCountExcution(UserCountInfo userCountInfo, RegistrationEnum registrationEnum) {
        this.userCountInfo = userCountInfo;
        this.code = registrationEnum.getCode();
        this.codeInfo = registrationEnum.getCodeInfo();
    }

    public UserCountExcution(RegistrationEnum registrationEnum) {
        this.code = registrationEnum.getCode();
        this.codeInfo = registrationEnum.getCodeInfo();
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
        return "UserCountExcution{" +
                "userCountInfo=" + userCountInfo +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
