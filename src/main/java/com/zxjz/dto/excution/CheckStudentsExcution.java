package com.zxjz.dto.excution;

import com.zxjz.entity.CheckStudentsInfo;
import com.zxjz.enums.CheckStudentsEnum;

import java.util.List;

public class CheckStudentsExcution {
    private int code;
    private String codeInfo;
    private List<CheckStudentsInfo> checkStudentsInfoList;

    public List<CheckStudentsInfo> getCheckStudentsInfoList() {
        return checkStudentsInfoList;
    }

    public void setCheckStudentsInfoList(List<CheckStudentsInfo> checkStudentsInfoList) {
        this.checkStudentsInfoList = checkStudentsInfoList;
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

    public CheckStudentsExcution(CheckStudentsEnum checkStudentsEnum ) {
        this.checkStudentsInfoList = checkStudentsInfoList;
        this.code = checkStudentsEnum.getCode();
        this.codeInfo = checkStudentsEnum.getCodeInfo();
    }

    public CheckStudentsExcution(CheckStudentsEnum checkStudentsEnum,List<CheckStudentsInfo> checkStudentsInfoList ) {
        this.checkStudentsInfoList = checkStudentsInfoList;
        this.code = checkStudentsEnum.getCode();
        this.codeInfo = checkStudentsEnum.getCodeInfo();
    }

    @Override
    public String toString() {
        return "CheckStudentsExcution{" +
                "code=" + code +
                ", codeInfo='" + codeInfo + '\'' +
                '}';
    }
}
