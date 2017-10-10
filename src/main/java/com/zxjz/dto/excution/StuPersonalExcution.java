package com.zxjz.dto.excution;

import com.zxjz.entity.StuPersonal;
import com.zxjz.enums.StuPersonalEnum;

public class StuPersonalExcution {
    private StuPersonal stuPersonal;
    private int code;
    private String codeInfo;

    public StuPersonalExcution(StuPersonal stuPersonal, StuPersonalEnum stuPersonalEnum) {
        this.stuPersonal = stuPersonal;
        this.code = stuPersonalEnum.getCode();
        this.codeInfo = stuPersonalEnum.getCodeInfo();
    }

    public StuPersonalExcution(int code, String codeInfo) {
        this.code = code;
        this.codeInfo = codeInfo;
    }

    public StuPersonal getStuPersonal() {
        return stuPersonal;
    }

    public void setStuPersonal(StuPersonal stuPersonal) {
        this.stuPersonal = stuPersonal;
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
        return "StuPersonalExcution{" +
                "stuPersonal=" + stuPersonal +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
