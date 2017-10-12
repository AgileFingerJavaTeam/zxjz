package com.zxjz.dto.excution;

import com.zxjz.entity.StuEvaDetails;
import com.zxjz.enums.StuPersonalEnum;

public class StuEvaDetailsExcution {
    private StuEvaDetails stuEvaDetails;
    private int code;
    private String codeInfo;

    public StuEvaDetailsExcution(StuEvaDetails stuEvaDetails, StuPersonalEnum stuPersonalEnum) {
        this.stuEvaDetails = stuEvaDetails;
        this.code = stuPersonalEnum.getCode();
        this.codeInfo = stuPersonalEnum.getCodeInfo();
    }

    public StuEvaDetailsExcution(StuPersonalEnum stuPersonalEnum) {
        this.code = stuPersonalEnum.getCode();
        this.codeInfo = stuPersonalEnum.getCodeInfo();
    }

    public StuEvaDetails getStuEvaDetails() {
        return stuEvaDetails;
    }

    public void setStuEvaDetails(StuEvaDetails stuEvaDetails) {
        this.stuEvaDetails = stuEvaDetails;
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
        return "StuEvaDetailsExcution{" +
                "stuEvaDetails=" + stuEvaDetails +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
