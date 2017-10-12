package com.zxjz.dto.excution;

import com.zxjz.entity.SystemParameter;
import com.zxjz.enums.SystemParameterEnum;

import java.util.List;

public class SystemParameterExcution {
    private List<SystemParameter> systemParametersList;
    private SystemParameter systemParameter;
    private int code;
    private String codeInfo;

    public SystemParameterExcution(SystemParameterEnum systemParameterEnum) {
        this.code = systemParameterEnum.getCode();
        this.codeInfo = systemParameterEnum.getCodeInfo();
    }
    public SystemParameterExcution(SystemParameterEnum systemParameterEnum,List<SystemParameter> systemParametersList) {
        this.systemParametersList = systemParametersList;
        this.code = systemParameterEnum.getCode();
        this.codeInfo = systemParameterEnum.getCodeInfo();
    }
    public SystemParameterExcution(SystemParameterEnum systemParameterEnum,SystemParameter systemParameter) {
        this.systemParameter = systemParameter;
        this.code = systemParameterEnum.getCode();
        this.codeInfo = systemParameterEnum.getCodeInfo();
    }

    public List<SystemParameter> getSystemParametersList() {
        return systemParametersList;
    }

    public void setSystemParametersList(List<SystemParameter> systemParametersList) {
        this.systemParametersList = systemParametersList;
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
                "systemParametersList=" + systemParametersList +
                ", systemParameter=" + systemParameter +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
