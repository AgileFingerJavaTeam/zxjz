package com.zxjz.dto.excution;

import com.zxjz.entity.ManagementPart;
import com.zxjz.enums.StuPersonalEnum;

import java.util.List;

public class ManagementPartExcuton {
    private List<ManagementPart> managementPart;
    private int code;
    private String codeInfo;

    public ManagementPartExcuton(List<ManagementPart> managementPart, StuPersonalEnum stuPersonalEnum) {
        this.managementPart = managementPart;
        this.code = stuPersonalEnum.getCode();
        this.codeInfo = stuPersonalEnum.getCodeInfo();
    }

    public ManagementPartExcuton(StuPersonalEnum stuPersonalEnum) {
        this.code = stuPersonalEnum.getCode();
        this.codeInfo = stuPersonalEnum.getCodeInfo();
    }

    public List<ManagementPart> getManagementPart() {
        return managementPart;
    }

    public void setManagementPart(List<ManagementPart> managementPart) {
        this.managementPart = managementPart;
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
        return "ManagementPartExcuton{" +
                "managementPart=" + managementPart +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
