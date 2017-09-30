package com.zxjz.dto.excution;

import com.zxjz.entity.SystemParameter;
import com.zxjz.enums.SystemParameterEnum;

public class SystemParameterExcution {
    private SystemParameter systemParameter;
    private int code;
    private String codeInfo;

    public SystemParameterExcution(SystemParameterEnum systemParameterEnum) {
        this.code = systemParameterEnum.getCode();
        this.codeInfo = systemParameterEnum.getCodeInfo();
    }
    public SystemParameterExcution(SystemParameterEnum systemParameterEnum,SystemParameter systemParameter) {
        this.systemParameter = systemParameter;
        this.code = systemParameterEnum.getCode();
        this.codeInfo = systemParameterEnum.getCodeInfo();
    }

    public SystemParameter getSystemParameter() {
        return systemParameter;
    }

    public void setSystemParameter(SystemParameter systemParameter) {
        this.systemParameter = systemParameter;
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
        return "SystemParameterExcution{" +
                "systemParameter=" + systemParameter +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
