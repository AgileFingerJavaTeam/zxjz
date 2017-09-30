package com.zxjz.dto.excution;

import com.zxjz.entity.UserCountInfo;
import com.zxjz.enums.StudentSetBoundPhoneEnum;

public class StudentSetBoundPhoneExcution {
    private UserCountInfo userCountInfo;
    private int code;
    private String codeInfo;

    public StudentSetBoundPhoneExcution(StudentSetBoundPhoneEnum studentSetBoundPhoneEnum) {
        this.code = studentSetBoundPhoneEnum.getCode();
        this.codeInfo = studentSetBoundPhoneEnum.getCodeInfo();
    }
    public StudentSetBoundPhoneExcution(StudentSetBoundPhoneEnum studentSetBoundPhoneEnum,UserCountInfo userCountInfo) {
        this.userCountInfo = userCountInfo;
        this.code = studentSetBoundPhoneEnum.getCode();
        this.codeInfo = studentSetBoundPhoneEnum.getCodeInfo();
    }

    public UserCountInfo getUserCountInfo() {
        return userCountInfo;
    }

    public void setUserCountInfo(UserCountInfo userCountInfo) {
        this.userCountInfo = userCountInfo;
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
        return "StudentSetBoundPhoneExcution{" +
                "userCountInfo=" + userCountInfo +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
