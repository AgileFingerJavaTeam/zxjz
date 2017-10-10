package com.zxjz.dto.excution;

import com.zxjz.entity.PendingTreatment;
import com.zxjz.enums.StuPersonalEnum;

import java.util.List;

public class PendingTreatmentExcution {
    private List<PendingTreatment> pendingTreatmentList;
    private int code;
    private String codeInfo;

    public PendingTreatmentExcution(List<PendingTreatment> pendingTreatmentList, StuPersonalEnum stuPersonalEnum) {
        this.pendingTreatmentList = pendingTreatmentList;
        this.code = stuPersonalEnum.getCode();
        this.codeInfo = stuPersonalEnum.getCodeInfo();
    }

    public PendingTreatmentExcution(StuPersonalEnum stuPersonalEnum) {
        this.code = stuPersonalEnum.getCode();
        this.codeInfo = stuPersonalEnum.getCodeInfo();
    }

    public List<PendingTreatment> getPendingTreatmentList() {
        return pendingTreatmentList;
    }

    public void setPendingTreatmentList(List<PendingTreatment> pendingTreatmentList) {
        this.pendingTreatmentList = pendingTreatmentList;
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
        return "PendingTreatmentExcution{" +
                "pendingTreatmentList=" + pendingTreatmentList +
                ", code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
